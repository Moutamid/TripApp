package com.moutamid.sqlapp.activities.Beaches;

import static com.moutamid.sqlapp.model.DatabaseHelper.TABLE_NAME;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryPurchasesParams;
import com.fxn.stash.Stash;
import com.moutamid.sqlapp.R;
import com.moutamid.sqlapp.activities.CreateAccountActivity;
import com.moutamid.sqlapp.activities.DashboardActivity;
import com.moutamid.sqlapp.activities.InAppPurchase.SliderAdapterExample;
import com.moutamid.sqlapp.activities.Iteneraries.ItinerariesActivity;
import com.moutamid.sqlapp.activities.Organizer.MyDocsActivity;
import com.moutamid.sqlapp.activities.Organizer.OrganizerActivity;
import com.moutamid.sqlapp.helper.Constants;
import com.moutamid.sqlapp.model.BeacModel;
import com.moutamid.sqlapp.model.DatabaseHelper;
import com.moutamid.sqlapp.offlinemap.MapActivity;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class BeachDetails extends AppCompatActivity {
    public static LinearLayout premium_layout, faq_layout;
    RelativeLayout lifetime_premium;
    TextView restore_purchase;
    SliderView sliderView;
    SliderAdapterExample adapter;
    ImageView close, close_faq;
    public static TextView faq_txt, text1, text2;
    private static String PRODUCT_PREMIUM = "lifetime";
    private BillingClient billingClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beach_details);
        premium();

        LinearLayout map_layout = findViewById(R.id.map_layout);
        ImageView mainImg = findViewById(R.id.main_img);
        ImageView menu = findViewById(R.id.menu);
        ImageView mainImage = findViewById(R.id.main_image);
        ImageView add = findViewById(R.id.add);
        ImageView map = findViewById(R.id.map);
        TextView text1 = findViewById(R.id.text1);
        TextView beach_type = findViewById(R.id.beach_type);
        TextView beach_header = findViewById(R.id.beach_header);
        TextView title1 = findViewById(R.id.title1);
        ImageView image1 = findViewById(R.id.image1);
        ImageView remove = findViewById(R.id.remove);
        TextView text2 = findViewById(R.id.text2);
        TextView title2 = findViewById(R.id.title2);
        ImageView image2 = findViewById(R.id.image2);
        TextView text3 = findViewById(R.id.text3);
        TextView title3 = findViewById(R.id.title3);
        ImageView image3 = findViewById(R.id.image3);
        TextView text4 = findViewById(R.id.text4);
        TextView title4 = findViewById(R.id.title4);
        ImageView image4 = findViewById(R.id.image4);
        TextView text5 = findViewById(R.id.text5);
        TextView title5 = findViewById(R.id.title5);
        ImageView image5 = findViewById(R.id.image5);
        TextView text6 = findViewById(R.id.text6);
        TextView title6 = findViewById(R.id.title6);
        TextView text7 = findViewById(R.id.text7);
        TextView title7 = findViewById(R.id.title7);
        TextView text8 = findViewById(R.id.text8);
        TextView title8 = findViewById(R.id.title8);
        TextView text9 = findViewById(R.id.text9);
        TextView text10 = findViewById(R.id.text10);
        TextView text11 = findViewById(R.id.text11);
        TextView text12 = findViewById(R.id.text12);
        TextView add_not = findViewById(R.id.add_not);
        LinearLayout add_lyt = findViewById(R.id.add_lyt);
        int isTrip = getIntent().getIntExtra("is_trip", 1);
        if (isTrip == 0) {
            beach_type.setVisibility(View.GONE);
        }

        com.moutamid.sqlapp.model.DatabaseHelper databaseHelper;
        databaseHelper = new DatabaseHelper(BeachDetails.this);
        BeacModel model = (BeacModel) Stash.getObject("model", BeacModel.class);
        Log.d("model", model.text1 + " test");
        beach_header.setText(Html.fromHtml(model.title));
        beach_type.setText(Stash.getString("type"));
        mainImage.setImageResource(model.main_image);
        if (!model.text1.isEmpty()) {
            text1.setText(Html.fromHtml(model.text1));
            text1.setVisibility(View.VISIBLE);
        } else {
            text1.setVisibility(View.GONE);
        }

        if (!model.title1.isEmpty()) {
            title1.setText(Html.fromHtml(model.title1));
            title1.setVisibility(View.VISIBLE);
        } else {

            title1.setVisibility(View.GONE);

        }

        if (model.image1 != R.drawable.map_location) {
            image1.setImageResource(model.image1);
            image1.setVisibility(View.VISIBLE);
        } else {
            image1.setVisibility(View.GONE);
        }

        if (!model.text2.isEmpty()) {
            text2.setText(Html.fromHtml(model.text2));
            text2.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            text2.setVisibility(View.GONE);
        }

        if (!model.title2.isEmpty()) {
            title2.setText(Html.fromHtml(model.title2));
            title2.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            title2.setVisibility(View.GONE);
        }

        if (model.image2 != R.drawable.map_location) {
            image2.setImageResource(model.image2);
            image2.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            image2.setVisibility(View.GONE);
        }

        if (!model.text3.isEmpty()) {
            text3.setText(Html.fromHtml(model.text3));
            text3.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            text3.setVisibility(View.GONE);
        }

        if (!model.title3.isEmpty()) {
            title3.setText(Html.fromHtml(model.title3));
            title3.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            title3.setVisibility(View.GONE);
        }

        if (model.image3 != R.drawable.map_location) {
            image3.setImageResource(model.image3);
            image3.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            image3.setVisibility(View.GONE);
        }
        // Set text or image and adjust visibility for the views
        if (!model.text4.isEmpty()) {
            text4.setText(Html.fromHtml(model.text4));
            text4.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            text4.setVisibility(View.GONE);
        }

        if (!model.title4.isEmpty()) {
            title4.setText(Html.fromHtml(model.title4));
            title4.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            title4.setVisibility(View.GONE);
        }

        if (model.image4 != R.drawable.map_location) {
            image4.setImageResource(model.image4);
            image4.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            image4.setVisibility(View.GONE);
        }

        if (!model.text5.isEmpty()) {
            text5.setText(Html.fromHtml(model.text5));
            text5.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            text5.setVisibility(View.GONE);
        }

        if (!model.title5.isEmpty()) {
            title5.setText(Html.fromHtml(model.title5));
            title5.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            title5.setVisibility(View.GONE);
        }

        if (model.image5 != R.drawable.map_location) {
            image5.setImageResource(model.image5);
            image5.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            image5.setVisibility(View.GONE);
        }

        if (!model.text6.isEmpty()) {
            text6.setText(Html.fromHtml(model.text6));
            text6.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            text6.setVisibility(View.GONE);
        }

        if (!model.title6.isEmpty()) {
            title6.setText(Html.fromHtml(model.title6));
            title6.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            title6.setVisibility(View.GONE);
        }
// Set text or image and adjust visibility for the views
        if (!model.text7.isEmpty()) {
            text7.setText(Html.fromHtml(model.text7));
            text7.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            text7.setVisibility(View.GONE);
        }

        if (!model.title7.isEmpty()) {
            title7.setText(Html.fromHtml(model.title7));
            title7.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            title7.setVisibility(View.GONE);
        }

        if (!model.text8.isEmpty()) {
            text8.setText(Html.fromHtml(model.text8));
            text8.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            text8.setVisibility(View.GONE);
        }

        if (!model.title8.isEmpty()) {
            title8.setText(Html.fromHtml(model.title8));
            title8.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            title8.setVisibility(View.GONE);
        }

        if (!model.text9.isEmpty()) {
            text9.setText(Html.fromHtml(model.text9));
            text9.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            text9.setVisibility(View.GONE);
        }

        if (!model.text10.isEmpty()) {
            text10.setText(Html.fromHtml(model.text10));
            text10.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            text10.setVisibility(View.GONE);
        }

        if (!model.text11.isEmpty()) {
            text11.setText(Html.fromHtml(model.text11));
            text11.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            text11.setVisibility(View.GONE);
        }

        if (!model.text12.isEmpty()) {
            text12.setText(Html.fromHtml(model.text12));
            text12.setVisibility(View.VISIBLE); // Set visibility to VISIBLE explicitly
        } else {
            text12.setVisibility(View.GONE);
        }


        List<BeacModel> beacModels = databaseHelper.getAllBeacModels();
        boolean isDataAvailable = false;
        for (BeacModel model1 : beacModels) {
            if (model1.title.equals(beach_header.getText().toString())) {
                isDataAvailable = true;
                break;
            }
        }
        if (isDataAvailable) {
            add.setVisibility(View.GONE);
            remove.setVisibility(View.VISIBLE);
            add_not.setText("Remove");
        } else {
            add.setVisibility(View.VISIBLE);
            remove.setVisibility(View.GONE);
            add_not.setText("Add");
        }

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Stash.getBoolean(Constants.IS_PREMIUM, false)) {
                    String deleteName = beach_header.getText().toString();
                    SQLiteDatabase db = databaseHelper.getWritableDatabase();
                    db.delete(TABLE_NAME, DatabaseHelper.COLUMN_TITLE + "=?", new String[]{deleteName});
                    db.close();
                    remove.setVisibility(View.GONE);
                    add.setVisibility(View.VISIBLE);
                    add_not.setText("Add");
                } else {
                    premium_layout.setVisibility(View.VISIBLE);
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Stash.getBoolean(Constants.IS_PREMIUM, false)) {

                    com.moutamid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutamid.sqlapp.model.DatabaseHelper(BeachDetails.this);
                    databaseHelper.insertBeacModel(model);
                    add.setVisibility(View.GONE);
                    remove.setVisibility(View.VISIBLE);
                    add_not.setText("Remove");
                } else {
                    premium_layout.setVisibility(View.VISIBLE);
                }

            }
        });
        boolean finalIsDataAvailable = isDataAvailable;
        add_lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Stash.getBoolean(Constants.IS_PREMIUM, false)) {

                    if (finalIsDataAvailable) {
                        String deleteName = beach_header.getText().toString();
                        SQLiteDatabase db = databaseHelper.getWritableDatabase();
                        db.delete(TABLE_NAME, DatabaseHelper.COLUMN_TITLE + "=?", new String[]{deleteName});
                        db.close();
                        remove.setVisibility(View.GONE);
                        add.setVisibility(View.VISIBLE);
                        add_not.setText("Add");
                    } else {
                        com.moutamid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutamid.sqlapp.model.DatabaseHelper(BeachDetails.this);
                        databaseHelper.insertBeacModel(model);
                        add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                        add_not.setText("Remove");

                    }
                } else {
                    premium_layout.setVisibility(View.VISIBLE);
                }
            }
        });
        map_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Stash.getBoolean(Constants.IS_PREMIUM, false)) {
                    Stash.put("map_lat", model.lat);
                    Stash.put("map_lng", model.lng);
                    Stash.put("map_name", model.title);
                    Stash.put("map_img", model.main_image);
                    Intent intent = new Intent(BeachDetails.this, MapActivity.class);
                    intent.putExtra("map_lat", model.lat);
                    intent.putExtra("map_lng", model.lng);
                    startActivity(intent);
                } else {
                    premium_layout.setVisibility(View.VISIBLE);
                }

            }
        });

    }

    public void BackPress(View view) {
        onBackPressed();
    }

    public void menu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if ((item.getItemId() == R.id.menu_item_1)) {
                    startActivity(new Intent(BeachDetails.this, DashboardActivity.class));
                    finishAffinity();
                }
                return true;
            }
        });
        popupMenu.show();
    }

    public void premium() {

        restore_purchase = findViewById(R.id.restore_purchase);
        lifetime_premium = findViewById(R.id.lifetime_premium);
        premium_layout = findViewById(R.id.premium_layout);
        faq_layout = findViewById(R.id.faq_layout);
        close = findViewById(R.id.close);
        sliderView = findViewById(R.id.slider);
        close_faq = findViewById(R.id.close_faq);
        faq_txt = findViewById(R.id.faq_txt);
        text1 = findViewById(R.id.text111);
        text2 = findViewById(R.id.text112);
//        faq_txt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                faq_layout.setVisibility(View.VISIBLE);
//            }
//        });
        billingClient = BillingClient.newBuilder(this)
                .enablePendingPurchases()
                .setListener(
                        (billingResult, list) -> {

                            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK && list != null) {
                                for (Purchase purchase : list) {
                                    verifySubPurchase(purchase);
                                }
                            }
                        }
                ).build();

        //start the connection after initializing the billing client
        establishConnection();
        List<Integer> sliderData = new ArrayList<>();
        sliderData.add(R.drawable.img_1);
        sliderData.add(R.drawable.img_2);
        sliderData.add(R.drawable.img5);
        sliderData.add(R.drawable.img_4);
        sliderData.add(R.drawable.img_6);

        adapter = new SliderAdapterExample(this, sliderData);
        sliderView.setSliderAdapter(adapter);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);

//    sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
//    sliderView.startAutoCycle();
        sliderView.setCurrentPageListener(new SliderView.OnSliderPageListener() {
            @Override
            public void onSliderPageChanged(int position) {
                if (position == 0) {
                    text1.setText("Customize Itinerary");
                    text2.setText("Create and manage your travel itinerary");
                } else if (position == 1) {
                    text1.setText("Save your Itinerary");
                    text2.setText("Save your itinerary so you may access it from any other devices");
                } else if (position == 2) {
                    text1.setText("Offline Maps");
                    text2.setText("Get locations without connecting to the internet");
                } else if (position == 3) {
                    text1.setText("Travel Itinerary Organizer");
                    text2.setText("Gather all your hotel bookings and planes, trains, and rental carsdocuments all in one place");
                } else if (position == 4) {
                    text1.setText("Calender-based Trip Manager");
                    text2.setText("Organize your trip with the calendar-based interface to see what you have booked and when");
                }
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                premium_layout.setVisibility(View.GONE);
            }
        });
        close_faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                faq_layout.setVisibility(View.GONE);
            }
        });
        lifetime_premium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                TODO remove this dummy code
                premium_layout.setVisibility(View.GONE);
                faq_layout.setVisibility(View.GONE);
                Stash.put(Constants.IS_PREMIUM, true);
                Toast.makeText(BeachDetails.this, "Successfully purchased a lifetime subscription", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BeachDetails.this, CreateAccountActivity.class));
                GetSubPurchases();
            }
        });

        restore_purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restorePurchases();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        billingClient.queryPurchasesAsync(
                QueryPurchasesParams.newBuilder().setProductType(BillingClient.ProductType.SUBS).build(),
                (billingResult, list) -> {
                    if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                        for (Purchase purchase : list) {
                            if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED && !purchase.isAcknowledged()) {
                                verifySubPurchase(purchase);
                            }
                        }
                    }
                }
        );
    }

    void establishConnection() {
        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(@NonNull BillingResult billingResult) {
                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                    // The BillingClient is ready. You can query purchases here.
                    //Use any of function below to get details upon successful connection
                    Log.d("TAG", "Connection Established");
                }
            }

            @Override
            public void onBillingServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.
                Log.d("TAG", "Connection NOT Established");
                establishConnection();
            }
        });
    }

    void GetSubPurchases() {
        ArrayList<QueryProductDetailsParams.Product> productList = new ArrayList<>();

        productList.add(
                QueryProductDetailsParams.Product.newBuilder()
                        .setProductId(PRODUCT_PREMIUM)
                        .setProductType(BillingClient.ProductType.SUBS)
                        .build()
        );

        QueryProductDetailsParams params = QueryProductDetailsParams.newBuilder()
                .setProductList(productList)
                .build();


        billingClient.queryProductDetailsAsync(params, new ProductDetailsResponseListener() {
            @Override
            public void onProductDetailsResponse(@NonNull BillingResult billingResult, @NonNull List<ProductDetails> list) {
                LaunchSubPurchase(list.get(0));
                Log.d("TAG", "Product Price" + list.get(0).getSubscriptionOfferDetails().get(0).getPricingPhases().getPricingPhaseList().get(0).getFormattedPrice());

            }
        });
    }

    void LaunchSubPurchase(ProductDetails productDetails) {
        assert productDetails.getSubscriptionOfferDetails() != null;
        ArrayList<BillingFlowParams.ProductDetailsParams> productList = new ArrayList<>();

        productList.add(
                BillingFlowParams.ProductDetailsParams.newBuilder()
                        .setProductDetails(productDetails)
                        .setOfferToken(productDetails.getSubscriptionOfferDetails().get(0).getOfferToken())
                        .build()
        );

        BillingFlowParams billingFlowParams = BillingFlowParams.newBuilder()
                .setProductDetailsParamsList(productList)
                .build();

        billingClient.launchBillingFlow(this, billingFlowParams);
    }

    void verifySubPurchase(Purchase purchases) {
        if (!purchases.isAcknowledged()) {
            billingClient.acknowledgePurchase(AcknowledgePurchaseParams
                    .newBuilder()
                    .setPurchaseToken(purchases.getPurchaseToken())
                    .build(), billingResult -> {

                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                    for (String pur : purchases.getProducts()) {
                        if (pur.equalsIgnoreCase(PRODUCT_PREMIUM)) {
                            Log.d("TAG", "Purchase is successful" + pur);
                            Toast.makeText(this, "Purchase is Successful", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(this, "kjdhhjd", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    void restorePurchases() {

        billingClient = BillingClient.newBuilder(this).enablePendingPurchases().setListener((billingResult, list) -> {
        }).build();
        final BillingClient finalBillingClient = billingClient;
        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingServiceDisconnected() {
            }

            @Override
            public void onBillingSetupFinished(@NonNull BillingResult billingResult) {

                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                    finalBillingClient.queryPurchasesAsync(
                            QueryPurchasesParams.newBuilder().setProductType(BillingClient.ProductType.SUBS).build(), (billingResult1, list) -> {
                                if (billingResult1.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                                    if (list.size() > 0) {
                                        for (int i = 0; i < list.size(); i++) {
                                            if (list.get(i).getProducts().contains(PRODUCT_PREMIUM)) {
                                                Toast.makeText(BeachDetails.this, "Premium Restored", Toast.LENGTH_SHORT).show();

                                                Log.d("TAG", "Product id " + PRODUCT_PREMIUM + " will restore here");
                                            }
                                        }
                                    } else {
                                        Toast.makeText(BeachDetails.this, "Nothing found at restore", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }

}
