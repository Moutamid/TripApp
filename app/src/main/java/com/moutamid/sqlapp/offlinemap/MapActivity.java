package com.moutamid.sqlapp.offlinemap;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.fxn.stash.Stash;
import com.moutamid.sqlapp.R;
import com.moutamid.sqlapp.databinding.ActivityMapBinding;

import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.map.android.graphics.AndroidGraphicFactory;
import org.mapsforge.map.android.util.AndroidUtil;
import org.mapsforge.map.layer.Layers;
import org.mapsforge.map.layer.cache.TileCache;
import org.mapsforge.map.layer.overlay.Marker;
import org.mapsforge.map.layer.overlay.Polyline;
import org.mapsforge.map.layer.renderer.TileRendererLayer;
import org.mapsforge.map.rendertheme.InternalRenderTheme;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity {
    public static final String TAG = "MapActivity";
    public static ActivityMapBinding b;
    public static double walkingDuration, bikingDuration, drivingDuration, tramDuration;
    public static String formattedDistance;
    static double mapLat;
    static double mapLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidGraphicFactory.createInstance(getApplicationContext());
        b = ActivityMapBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        mapLat = getIntent().getDoubleExtra("map_lat", 0);
        mapLng = getIntent().getDoubleExtra("map_lng", 0);
        openMap();
        LatLong start = new LatLong(-20.2668829, 57.8057047);
        LatLong end = new LatLong(mapLat, mapLng);
        double distanceKm = DistanceCalculator.calculateDistance(
                start.latitude, start.longitude, end.latitude, end.longitude
        );
        b.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();;
            }
        });

//        Stash.put("map_lat", itemLatitudes[position]);
//        Stash.put("map_lng", itemLongitudes[position]);
//        Stash.put("map_name", itemName[position]);
//        Stash.put("map_img", itemImages[position]);
        b.mapNam.setText(Stash.getString("map_name"));
        b.title.setText(Stash.getString("map_name"));
        b.imageView.setImageResource(Stash.getInt("map_img"));
        formattedDistance = String.format("%.2f", distanceKm);
        Log.d(TAG, mapLat + "  " + mapLng + "Distance: " + formattedDistance + " km");

        walkingDuration = DurationCalculator.calculateWalkingDuration(distanceKm);
        bikingDuration = DurationCalculator.calculateBikingDuration(distanceKm);
        drivingDuration = DurationCalculator.calculateDrivingDuration(distanceKm);
        tramDuration = DurationCalculator.calculateTramDuration(distanceKm);
        Log.d(TAG, "Walking Duration: " + DurationCalculator.formatDuration(walkingDuration));
        Log.d(TAG, "Biking Duration: " + DurationCalculator.formatDuration(bikingDuration));
        Log.d(TAG, "Driving Duration: " + DurationCalculator.formatDuration(drivingDuration));
        b.mapType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheet =
                        new BottomSheetDialog();
                bottomSheet.show(getSupportFragmentManager(),
                        "ModalBottomSheet");
            }
        });
        b.directions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DirectionBottomSheetDialog bottomSheet =
                        new DirectionBottomSheetDialog();
                bottomSheet.show(getSupportFragmentManager(),
                        "ModalBottomSheet");
            }
        });
    }

    private void openMap() {
        b.mapView.getMapScaleBar().setVisible(true);
        b.mapView.setBuiltInZoomControls(true);

        TileCache cache = AndroidUtil.createTileCache(
                this,
                "mycache",
                b.mapView.getModel().displayModel.getTileSize(),
                1f,
                b.mapView.getModel().frameBufferModel.getOverdrawFactor()
        );

        try {
            File mapFile = new File(getCacheDir(), "mauritius.map");
            copyMapFileToCache(R.raw.mauritius, mapFile);
            org.mapsforge.map.reader.MapFile mapStore = new org.mapsforge.map.reader.MapFile(mapFile);
            TileRendererLayer renderLayer = new TileRendererLayer(
                    cache,
                    mapStore,
                    b.mapView.getModel().mapViewPosition,
                    AndroidGraphicFactory.INSTANCE
            );
            renderLayer.setXmlRenderTheme(InternalRenderTheme.DEFAULT);
            b.mapView.getLayerManager().getLayers().add(renderLayer);
            b.mapView.setCenter(new LatLong(mapLat, mapLng));
            b.mapView.setZoomLevel((byte) 12);

            // Add overlays

//            addOverlayLayers(b.mapView.getLayerManager().getLayers());
            LatLong markerLocation = new LatLong(mapLat, mapLng); // Example coordinates
            addMarker(b.mapView.getLayerManager().getLayers(), markerLocation, R.drawable.dot); // Replace with your marker drawable resource ID
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void copyMapFileToCache(int resourceId, File outputFile) {
        try (InputStream inputStream = getResources().openRawResource(resourceId);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addOverlayLayers(Layers layers) {
        Paint paint = createPaint(
                AndroidGraphicFactory.INSTANCE.createColor(Color.BLUE),
                (int) (8 * b.mapView.getModel().displayModel.getScaleFactor()),
                Style.STROKE
        );

        Polyline polyline = new Polyline(paint, AndroidGraphicFactory.INSTANCE);
        List<LatLong> latLongs = new ArrayList<>();
        latLongs.add(new LatLong(mapLat, mapLng));
        latLongs.add(new LatLong(-20.2668829, 57.8057047));


        polyline.setPoints(latLongs);
        layers.add(polyline);
    }

    private static Paint createPaint(int color, int strokeWidth, Style style) {
        Paint paint = AndroidGraphicFactory.INSTANCE.createPaint();
        paint.setColor(color);
        paint.setStrokeWidth((float) strokeWidth);
        paint.setStyle(style);
        return paint;
    }

    private void addMarker(Layers layers, LatLong latLong, int resourceId) {
        Bitmap bitmap = AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(resourceId));

        Marker marker = new Marker(latLong, bitmap, 0, 0);
        layers.add(marker);
    }
}
