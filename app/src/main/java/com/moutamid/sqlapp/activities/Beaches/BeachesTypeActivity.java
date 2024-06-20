package com.moutamid.sqlapp.activities.Beaches;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import com.moutamid.sqlapp.adapter.BeachesAdapter;
import com.moutamid.sqlapp.helper.Constants;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class BeachesTypeActivity extends AppCompatActivity {
    private String[] itemTexts;
    private String[] itemName;
    private String[] itemName1;
    private int[] itemImages;
    private double[] latitudes;
    private double[] longitudes;
    TextView title, heading, text_main, heading_main;
    ImageView image;
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
        setContentView(R.layout.activity_beaches_in_east);
        premium();

        title = findViewById(R.id.title);
        heading = findViewById(R.id.heading);
        text_main = findViewById(R.id.text_main);
        image = findViewById(R.id.image);
        heading_main = findViewById(R.id.heading_main);

        Intent intent = getIntent();
        String itemHeader = intent.getStringExtra("itemHeader");
        String itemTitle = intent.getStringExtra("itemTitle");
        title.setText(itemHeader);
        heading.setText(itemTitle);
        Stash.put("type", itemTitle);
        itemTexts = intent.getStringArrayExtra("itemTexts");
        itemName = intent.getStringArrayExtra("itemName");
        itemName1 = intent.getStringArrayExtra("itemName1");
        itemImages = intent.getIntArrayExtra("itemImages");
        latitudes = intent.getDoubleArrayExtra("itemLatitudes"); // Get latitude array
        longitudes = intent.getDoubleArrayExtra("itemLongitudes"); // Get longitude array
        Log.d("data", latitudes+" dtata");
         if (itemTitle.equals("East")) {
            text_main.setText("Discover some of the island's longest and finest beaches, along with clear-water lagoons. The eastern region is ideal for activities like swimming, snorkeling, and diving. Throughout most of the year, the east coast is exposed to cooling breezes, ideal for kitesurfing.");
            heading_main.setVisibility(View.GONE);
            image.setImageResource(R.drawable.ile_aux_cerfs_island_2);
        }
        else  if (itemTitle.equals("West")) {
            text_main.setText("The western coastline is ideal for indulging in sunset cocktails at stylish beach bars, engaging in activities like snorkeling and diving to discover treasures like the Crystal Rock. The Le Morne Brabant mountain graces the horizon, and the area is renowned as a premier kitesurfing hotspot. Moreover, there is an increased likelihood of encountering wild dolphin pods off the west coast.");
            heading_main.setVisibility(View.GONE);
            image.setImageResource(R.drawable.le_morne_brabant);
        } else  if (itemTitle.equals("South")) {
            text_main.setText("The southern region has a rugged shoreline characterized by steep cliffs, hidden coves, and roughsea. While the sandy areas are wide, swimmers should exercise caution when venturing into the sea because of the strong currents and presence of coral reefs.");
            heading_main.setVisibility(View.GONE);
            image.setImageResource(R.drawable.gris_gris_4);
        } else  if (itemTitle.equals("North")) {
            text_main.setText("The northern region is renowned for its lively atmosphere, great bars and restaurants, and beaches with scenic views of the northern islands. It's an ideal starting point for boat or catamaran trips to explore the islets like Ilot Gabriel. The area features flat, sandy beaches, abundant watersports, and calm waters, making it a perfect destination for relaxation and aquatic activities.");
            heading_main.setVisibility(View.GONE);
            image.setImageResource(R.drawable.coin_de_mire_10);
        }
        ListView listView = findViewById(R.id.listView);
        BeachesAdapter adapter = new BeachesAdapter(this, itemName, itemName1, itemTexts, itemImages, latitudes, longitudes); // Pass latitude and longitude arrays to the adapter
        listView.setAdapter(adapter);
    }

    public void menu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        // Optional: Set a listener to respond to menu item clicks
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if ((item.getItemId() == R.id.menu_item_1)) {
                    startActivity(new Intent(BeachesTypeActivity.this, DashboardActivity.class));
                    finishAffinity();
                }
                return true;
            }
        });
        popupMenu.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView listView = findViewById(R.id.listView);
        BeachesAdapter adapter = new BeachesAdapter(this, itemName, itemName1, itemTexts, itemImages, latitudes, longitudes); // Pass latitude and longitude arrays to the adapter
        listView.setAdapter(adapter);
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
        );  }

    public void BackPress(View view) {
        onBackPressed();
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
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
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
                Toast.makeText(BeachesTypeActivity.this, "Successfully purchased a lifetime subscription", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BeachesTypeActivity.this, CreateAccountActivity.class));
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
                                                Toast.makeText(BeachesTypeActivity.this, "Premium Restored", Toast.LENGTH_SHORT).show();

                                                Log.d("TAG", "Product id " + PRODUCT_PREMIUM + " will restore here");
                                            }
                                        }
                                    } else {
                                        Toast.makeText(BeachesTypeActivity.this, "Nothing found at restore", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}
