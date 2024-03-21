package com.moutimid.sqlapp.adapter;

import static com.moutimid.sqlapp.model.DatabaseHelper.TABLE_NAME;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fxn.stash.Stash;
import com.moutimid.sqlapp.R;
import com.moutimid.sqlapp.activities.Beaches.BeachDetails;
import com.moutimid.sqlapp.model.BeacModel;
import com.moutimid.sqlapp.model.DatabaseHelper;

import java.util.List;

public class BeachesAdapter extends BaseAdapter {

    private Context context;
    private String[] itemTexts;
    private String[] itemName;
    private String[] itemDetails;
    private int[] itemImages;

    public BeachesAdapter(Context context, String[] itemName, String[] itemDetails, String[] itemTexts, int[] itemImages) {
        this.context = context;
        this.itemTexts = itemTexts;
        this.itemImages = itemImages;
        this.itemDetails = itemDetails;
        this.itemName = itemName;
    }

    @Override
    public int getCount() {
        return itemTexts.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.beaches_east_layout, parent, false);
        ImageView imageView = itemView.findViewById(R.id.imageView);
        TextView textView = itemView.findViewById(R.id.textView);
        TextView textView1 = itemView.findViewById(R.id.textView1);
        TextView textView2 = itemView.findViewById(R.id.textView2);
        ImageView add = itemView.findViewById(R.id.add);
        ImageView remove = itemView.findViewById(R.id.remove);
        ImageView map = itemView.findViewById(R.id.map);
        imageView.setImageResource(itemImages[position]);
        textView.setText(itemName[position]);
        textView1.setText(itemTexts[position]);
        textView2.setText(itemDetails[position]);
        com.moutimid.sqlapp.model.DatabaseHelper databaseHelper;
        databaseHelper = new DatabaseHelper(context);
        List<BeacModel> beacModels = databaseHelper.getAllBeacModels();
        boolean isDataAvailable = false;
        for (BeacModel model : beacModels)
        {
            if (model.title.equals(textView.getText().toString())) {
                isDataAvailable = true;
                break;
            }
        }
        if (isDataAvailable) {
            add.setVisibility(View.GONE);
            remove.setVisibility(View.VISIBLE);
        } else {
            add.setVisibility(View.VISIBLE);
            remove.setVisibility(View.GONE);
        }
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String deleteName = textView.getText().toString();
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                db.delete(TABLE_NAME, DatabaseHelper.COLUMN_TITLE + "=?", new String[]{deleteName});
                db.close();
                remove.setVisibility(View.GONE);
                add.setVisibility(View.VISIBLE);
                notifyDataSetChanged();
            }
        });

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                if (Stash.getString("type").equals("West")) {
                    if (position == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.flic_en_flac_3;
                        model.text1 = "Located on the west coast of Mauritius, Flic en Flac has emerged as the second most popular tourist area in the country, following Grand Baie.<br>" +
                                "Unlike the faster-paced development in the north, the west coast, including beautiful villages like Flic en Flac, has transformed from small fishing communities into charming towns, earning a reputation as a premier holiday destination.<br>" +
                                "Over the past two centuries, Flic en Flac has evolved from a humble fishing village into a prominent tourist hub. Today, it stands as a sought-after destination, attracting both international tourists and local Mauritians";
                        model.title1 = "";

                        model.image1 = R.drawable.flic_en_flac_1;
                        model.text2 = "Flic en Flac offers an ideal holiday experience with its excellent beaches, a variety of watersports, and a tranquil ambiance for complete relaxation. The location boasts a delightful setting with pristine white sand beaches and picturesque blue lagoons. Along the extensive 8 km beach, numerous restaurants, hotels, shops, and facilities cater to visitors.<br>" +
                                "The beach provides a perfect backdrop for activities such as afternoon strolls, watersports, sunbathing, or simply unwinding. It's an excellent spot for picnics, shaded by trees scattered along the coastline.<br>" +
                                "Flic en Flac's beach, adorned with Casuarina Trees, features a fine lagoon protected by a reef, ensuring safe swimming and opportunities for various watersports.<br>" +
                                "Flic-en-Flac buzzes with activity throughout the day and night, offering a dynamic atmosphere for visitors. In the daytime, guests can indulge in delectable street food options such as the \"DhalPuri,\" a thin, multi-layered flatbread crafted from flour, yellow split peas, salt, and water, filled with flavorful curry and sauces. Another popular local dish is fried noodles paired with Mauritian meatballs, enjoyed by both locals and visitors. However, it's crucial for those unfamiliar with the local water and cuisine to exercise extreme caution to prevent any potential food-related illnesses or stomach discomfort.<br> During the weekends, the beach becomes a vibrant hub for locals spending quality time with family and friends. Entertainment unfolds as some locals engage in singing and dancing to the rhythmic beats of Sega music, typically played with guitars and \"ravannes\" — a percussion instrument resembling the \"Bodhrán\" but played with distinctive techniques using hands.<br>" +
                                "The nightlife in Flic-en-Flac is lively, attracting both locals and tourists to nightclubs and restaurants, fostering a lively atmosphere for socializing. Despite its diverse offerings, it's important to note that the otherwise beautiful white sandy beach does contain a considerable amount of corals and sea urchins.";
                        model.title2 = "Flic en Flac - Location";
                        model.text3 = "Situated in the Black River district on the island's western coast, approximately 15 km south of the capital, Port Louis, Flic en Flac lies between the villages of Albion to the north and Tamarin and Black River to the south. The west coastline, lined with hotels and villas providing direct beach access, characterizes Flic en Flac. The drive to Port Louis takes around 30 minutes, while reaching the airport takes approximately 1 hour.<br>" +
                                "Flic en Flac benefits from a well-established bus route, facilitating easy transportation to key locations across Mauritius. Buses connect to Port Louis and other cities like Quatre Bornes and Curepipe, offering convenient access to various parts of the island.";

                        model.image2 = R.drawable.map_location;
                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.la_preneuse_4; // Set the value for main_image

                        model.text1 = "The shoreline is adorned with pristine, snow-white sand, featuring a gentle slope and shallow waters. The ocean remains tranquil, displaying a captivating turquoise hue, although intermittent strong currents can be experienced. La Preneuse Beach boasts a spacious and expansive setting, providing ample room for all vacationers. The panoramic view from the coast reveals the towering Mount Le Morne against the backdrop of the turquoise lagoon.<br>" +
                                "Situated on the west coast of Mauritius, the beach offers a range of hotels catering to different comfort levels for tourists. Cafes, stores, and souvenir shops offering diverse goods are conveniently located near the shoreline. A notable attraction is the Martello Tower, erected by the British in the 1830s as a defense against the French fleet. It now serves as a museum housing information about the region's history and the initial planters. The renowned Black River, a freshwater river, flows along the beach. Yachts and boats gracefully navigate the open sea, providing opportunities for sea excursions.";
                        model.title1 = "";

                        model.image1 = R.drawable.map_location; // Set the value for image1

                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (position == 2) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.le_morne_beach_2; // Set the value for main_image

                        model.text1 = "Nestled on a peninsula along the western coast of Mauritius, at the base of the UNESCO-listed Morne Brabant mountain, lies Le Morne Beach. Easily accessible from the coastal road, this public beach boasts miles of pristine white sand and is adorned with majestic casuarina trees, all against the backdrop of the crystal-clear waters providing excellent visibility for scuba diving.";
                        model.title1 = "";

                        model.image1 = R.drawable.kite_surfing; // Set the value for image1

                        model.text2 = "Renowned as one of the premier kite-surfing spots in Mauritius, and often regarded as one of the best in the world, Le Morne Beach offers a breathtaking setting with its iconic mountain in the background. The beach is a favorite among windsurfers and kite surfers, as the conditions for these water sports are ideal throughout much of the year. The annual Kiteival, attracting international participants, is among the many competitions hosted at this spectacular location.<br>" +
                                "While Le Morne Beach remains a delightful spot for swimming, it can get quite busy on weekends and holidays. Nudism is prohibited, although topless sunbathing is accepted. For a more tranquil experience, the best times to visit the beach are early in the morning from 8:00 to 11:00 or in the afternoon from 13:00 to 17:00.<br> ";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.paddle_boarding; // Set the value for image2

                        model.text4 = "An array of activities awaits beachgoers, including pedalo rides, windsurfing, kite surfing, scuba diving, stand-up paddleboarding, and kayaking, ensuring there's something for everyone to enjoy at Le Morne Beach. ";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (position == 3) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.la_preneuse_4; // Set the value for main_image
                        model.text1 = "The shoreline is adorned with pristine, snow-white sand, featuring a gentle slope and shallow waters. The ocean remains tranquil, displaying a captivating turquoise hue, although intermittent strong currents can be experienced. La Preneuse Beach boasts a spacious and expansive setting, providing ample room for all vacationers. The panoramic view from the coast reveals the towering Mount Le Morne against the backdrop of the turquoise lagoon.<br>" +
                                "Situated on the west coast of Mauritius, the beach offers a range of hotels catering to different comfort levels for tourists. Cafes, stores, and souvenir shops offering diverse goods are conveniently located near the shoreline. A notable attraction is the Martello Tower, erected by the British in the 1830s as a defense against the French fleet. It now serves as a museum housing information about the region's history and the initial planters. The renowned Black River, a freshwater river, flows along the beach. Yachts and boats gracefully navigate the open sea, providing opportunities for sea excursions.";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location; // Set the value for image1
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    }

                }
                else if (Stash.getString("type").equals("East")) {
                    if (position == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.belle_mare_1; // Set the value for main_image

                        model.text1 = "The Belle Mare Beach is located near the town of Mahebourg on the Southeast coast of Mauritius, spanning between the villages Belle Mare and Pointe de Flacq. Sheltered from the big waves by the coral reef, this crescent-shaped beach has a parking area and a shaded rest area under the filaos trees. It is quite wide with parts of fine, dazzling white sand. The water is transparent and calm, and the lagoon has a most magnificent turquoise blue color. In this realm, unspoiled nature prevails, with minimal development except for a few scattering hotels and exclusive villas.";
                        model.title1 = "";

                        model.image1 = R.drawable.belle_mare_3; // Set the value for image1

                        model.text2 = "Renowned among holidaymakers as the epitome of beauty, the Belle Mare Beach is cherished not only by visitors but also by the island's residents who frequent the beach, particularly on weekends and holidays. This enclave retains an authentic charm, preserving the island's essence amidst the rapid development witnessed by other coastal cities, notably Grand Bay, Flic en Flac, and Black River.<br>" +
                                "<br>";
                        model.title2 = "";
                        model.text3 = "The Belle Mare Beach is an idyllic destination for swimming and diving, particularly on weekdays when the serene ambiance prevails. It offers an ideal retreat for nature enthusiasts, allowing them to relish miles of sandy expanse for sunbathing.<br>" +
                                "The optimal times to visit the Belle Mare Beach are during the early morning hours from 7:00 to 11:00 or in the afternoon from 13:00 to 17:00.<br>" +
                                "Engage in an array of activities at Belle Mare Beach, including pedalo rides, windsurfing, catamaran journeys, horseback riding, parasailing, scuba diving, speed boat excursions, and kayaking.<br>";
                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.ile_aux_cerfs_mauritius_1; // Set the value for main_image

                        model.text1 = "On the eastern coast of Mauritius, just south of Trou d’Eau Douce, lies a pair of islands known collectively as Ile aux Cerfs. Ile aux Cerfs is a genuine paradise spanning 87 hectares. It is particularly appealing to water sports enthusiasts andis one of the most stunning beaches in Mauritius.";
                        model.title1 = "What to Explore and Experience on Ile aux Cerfs";

                        model.image1 = R.drawable.ile_aux_cerfs_7; // Set the value for image1

                        model.text2 = "The island is celebrated for its picturesque turquoise lagoon, perfectly suited for an extensive array of water sports. Among the activities available, whether undertaken solo or with a companion, is parasailing—an endeavor worth adding to your bucket list, particularly for the breathtaking vistas of the lagoon.<br>" +
                                "Other activities include speedboat rides, water skiing, and paddleboarding. Snorkeling is also an option, although, you'll need to take a boat to a location where there is coral as the water near the beach is shallow and consists predominantly of sand<br>";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.ile_aux_cerfs_5_1; // Set the value for image2
                        model.text4 = "While many visitors come to the Ile aux Cerfs for leisurely water activities, true sun worshippers find their sanctuary here, especially given the limited shelter on the beach. The overarching advice is to liberally apply sunscreen, preferably opting for products that are environmentally friendly. ";
                        model.title3 = "";
                        model.text5 = " close proximity to the pier, where the shuttle from Pointe Maurice drops them off. If you wish to evade the crowds, particularly on weekends, consider strolling a bit farther along the coast. Numerous other nearby beaches offer equally tranquil surroundings.";
                        model.title4 = "How to Reach Ile aux Cerfs";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.ile_aux_cerfs_7;

                        model.text9 = "Access to the island is granted to the public from 9:00 a.m. to 6:00 p.m. Starting from the village of Trou-d’Eau Douce, a shuttle embarks every half hour from the pier at Pointe Maurice to the Masala pier on Ile aux Cerfs, at 9:30 a.m.<br>" +
                                "An alternative approach is by catamaran, with numerous providers offering scenic journeys to the island, sometimes incorporating detours to or from the waterfalls in the nature reserve of Grande Rivière Sud Est.<br>";
                        model.title8 = "Optimal Time to Explore the Island ";
                        model.text10 = "";

                        model.image4 = R.drawable.ile_aux_cerfs_6;

                        model.text11 = "The island tends to attract a considerable influx of day trippers during weekends. If your stay in Mauritius extends to at least a week, it is advisable to plan your visit on a weekday. While October and November are considered the prime months to experience Ile aux Cerfs, the period from June to November also offers a delightful visit.<br>" +
                                "<b>Accommodation</b> <br>" +
                                "Noteworthy among the accommodations on Ile aux Cerfs is the opulent 5-star Shangri-La’s Le Touessrok Resort & Spa. While not budget-friendly, it provides an exceptional setting for grand celebrations. <br>" +
                                "<b>Culinary Offerings</b><br>";
                        model.image5 = R.drawable.ile_aux_cerfs_3;
                        model.text12 = "Ile aux Cerfshas several dining establishments, including a charming beachside restaurant. Additionally, two bars are available for visitors seeking refreshing beverages or cocktails at reasonable prices. An alternative is to bring ample food and drinks to suit your preferences.";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (position == 2) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.poste_lafayette_1; // Set the value for main_image

                        model.text1 = "This unspoiled beach, often overlooked due to its turbulent sea, offers a rare opportunity to embrace tranquility and serenity. With its authentically rustic and untouched nature, this charming locale continually captivates nature enthusiasts. The preserved green habitat is a sanctuary for massive coral reefs, fostering rich marine biodiversity and mangroves.";
                        model.title1 = "";

                        model.image1 = R.drawable.poste_lafayette_2; // Set the value for image1

                        model.text2 = "Those seeking a peaceful picnic will be pleased that the southern part of the beach provides a serene retreat. Additionally, the southern beach serves as an ideal starting point for a trek leading north of Poste Lafayette, offering picturesque green landscapes along the rocky trail.";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.poste_lafayette_3; // Set the value for image2
//                        model.image2 = R.drawable.paddle_boarding; // Set the value for image2

                        model.text4 = "Picnicking in the shelter of the trees is a delightful option in certain areas where the sea displays stormy waves due to the proximity of the reefs to the lagoons. Enthusiasts of kite surfing and windsurfing will find this place ideal since Poste Lafayette is consistently exposed to the trade winds throughout ";
                        //                        model.text4 = "An array of activities awaits beachgoers, including pedalo rides, windsurfing, kite surfing, scuba diving, stand-up paddleboarding, and kayaking, ensuring there's something for everyone to enjoy at Le Morne Beach. ";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.poste_lafayette_4;

                        model.text9 = "While the sea may be too challenging for a Sunday swim, the shore or shallow waters provide opportunities for sunbathing while children can revel in building sandcastles";
                        model.title8 = "";
                        model.text10 = "The eastern coast boasts prominent hotels and restaurants, including establishments like Jalsa Beach Hotel & Spa, Radisson Blu Poste Lafayette Resort & Spa, and the esteemed Hôtel Constance Le Prince Maurice. <br>" +
                                "To cater to the discerning tourist, gourmet restaurants have thrived alongside small traditional eateries. La Maison D’Été, specializing in Italian cuisine with seafood and fish menus, is a must-visit in Poste Lafayette. Another favored dining spot, Seabell, offers a menu featuring typical Mauritian dishes, complemented by a nearby mini market owned by the Seabell owners.<br>" +
                                "<br>";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (position == 3) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.roche_noire_2; // Set the value for main_image
                        model.text1 = "Ranked among the top 10 beaches in Mauritius, the Roche Noire Beach is located just a few kilometers from Poste Lafayette on the southeast coast of the island. The beach has a stunning landscape characterized by black lava rocks and a dark sea, where gentle waves crash onto the nearby coral reef. The pristine sand and the spectacular views of sunrise and sunset contribute to making Roche Noire Beach an unparalleled destination. The winds throughout the year provide a refreshing breeze, especially during the hot summer months. It is one of the most photographed beaches according to tourist reviews.";
                        model.title1 = "";
                        model.image1 = R.drawable.roche_noire_3; // Set the value for image1
                        model.text2 = "The Roche Noire Beach is a true paradise for those who love water activities and appreciate nature. Guests can partake in a range of aquatic adventures, including swimming, snorkeling, and kayaking, allowing them to discover the diverse marine life and colorful coral reefs. Furthermore, the tranquil ambiance of the beach creates an ideal setting for a leisurely walk or a peaceful sunbathing experience. <br>" +
                                "Parking facilities are commonly accessible in the vicinity of the Roche Noire Beach, offering travelers a choice between free and paid parking options for easy access to the beach. Interesting fact about the Roche Noire Beach – the beach is famed for its breathtaking volcanic rock formations along the coastline, enhancing the natural beauty of the surroundings with a unique touch.<br>";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.map_location; // Set the value for image2
                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    }
                }
                else if (Stash.getString("type").equals("South")) {
                    if (position == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.bel_ombre_17; // Set the value for main_image
                        model.text1 = "Nestled in the southwestern part of Mauritius, the Bel Ombre Beach delicately unveils its shores of golden sand, extending a gracious invitation to aficionados of the sea.";
                        model.title1 = "";
                        model.image1 = R.drawable.bel_ombre_18; // Set the value for image1
                        model.text2 = "Along the turquoise shoreline, the Bel Ombre Beach unveils its captivating allure, accompanied by the gentle and intoxicating fragrance of paradise enveloped by the verdant casuarina trees. A mild southern breeze carries the delightful aroma of the vast open sea, a sensory indulgence prompting a poignant reminder to live life fully.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.bel_ombre_16; // Set the value for image2
                        model.text4 = "Stretching along the shoreline are extensive stretches of pristine white sand, graced by the shade of coconut trees standing as sentinel at the periphery of the opulent hotels. In this paradisiacal milieu, where casuarina trees and unspoiled nature meet, the Bel Ombre Beach in Mauritius is no doubt an oasis of serenity and peace.\n" +
                                "The best times to visit the Bel Ombre Beach are during the early morning hours from 7:00 to 11:00 or in the afternoon from 13:00 to 17:00.\n" +
                                "Engage in a spectrum of activities at the Bel Ombre Beach, including pedalo rides, scuba diving, speed boat journeys, and kayaking.\n";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.blue_bay; // Set the value for main_image

                        model.text1 = "Located in the southeast of the island, Blue Bay was designated a national park in 1997 and later recognized as a wetland site under the Ramsar Convention on Wetlands of International Importance in 2008. The marine park is renowned for its coral garden, housing a diverse array of corals and abundant fauna. Close to the coastline, it offers ideal conditions for snorkeling, boasting rich biodiversity and calm, shallow seawater.";

                        model.title1 = "";

                        model.image1 = R.drawable.blue_bay_4; // Set the value for image1

                        model.text2 = "Upon setting foot on Blue Bay beach, you will bump into hawkers selling artisanal jewelry and canvassers promoting glass-bottom boat trips or snorkeling outings. Over fifteen operators are permitted to engage in commercial activities within the Blue Bay Marine Park.";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.blue_bay_2; // Set the value for image2

                        model.text4 = "The main attraction in the Marine Park is a more than 1,000-year-old brain coral with a 5-meter diameter, making it the region's primary tourist attraction. The coral garden near Mahebourg, a small coastal village in the south-east, boasts a remarkable surface area and biodiversity. Visitors often come to witness the ancient brain coral, and various activities, such as glass-bottom boat trips, offer different perspectives of the vibrant marine life.\n" +
                                "Most operators in Blue Bay Marine Park are descendants of local fishermen turned to tourism. Glass-bottom boat trips are accessible to all, providing a serene experience to explore the beauty of the park. Those seeking a closer encounter can embark on a boat and snorkel, enjoying the vibrant underwater life in warm and clear waters.\n" +
                                "The Marine Park covers 353 hectares and is a popular leisure area for tourists and locals, sustaining numerous households through various activities. Measures have been implemented to balance economic activity with sustainable development, including the installationof permanent mooring buoys to demarcate conservation areas and regulated zones for fishing, boat traffic, swimming, and waterskiing. These measures aim to protect the marine fauna and flora, preserve biodiversity, promote scientific research, and educate the public.\n" +
                                "\n";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.blue_bay_6;

                        model.text9 = "Coast guards patrol the area daily to enforce regulations, ensuring compliance from skippers, swimmers, and fishermen. ";
                        model.title8 = "Protected Marine Area, Key Features";
                        model.text10 = "•\t<b>Exceptional Marine Biodiversity:</b> Blue Bay Marine Park features various ecosystems, including coral reefs, meadows of phanerogamous plants, mangroves, macro-algae, and inner lagoon flat stations. It houses over 38 coral species, 72 fish species, 31 algae species, 2 mangrove species, and 4 species of phanerogamous plants.";

                        model.image4 = R.drawable.blue_bay_3;

                        model.text11 = "•\t<b>Unique Classification in Mauritius:</b> Designated a Marine Park under the Wildlife and National Parks Act 1993, a protected zone in 2000 under the Fisheries and Marine Act 1998 and recognized as a Ramsar Convention site in 2008. Mooring buoys are strategically placed to minimize damage to corals by boat anchors.";

                        model.image5 = R.drawable.blue_bay_8;

                        model.text12 = "•\t<b>Outdoor Activities Available to All:</b> Glass-bottom boat trips and snorkeling are popular activities, allowing non-swimmers to explore the marine environment through the glass bottom. Snorkeling conditions are ideal, and Coco Island, visible from the beach, serves as a relaxing spot for snorkelers under casuarina trees. Operators provide drop-off and pick-up services.";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (position == 2) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.gris_gris_coastal_4; // Set the value for main_image

                        model.text1 = "The primary beach area features an expansive green field with a commanding view of dramatic cliffs and enormous waves. There are benches and a pavilion available for relaxation while taking in the scenery.\n" +
                                "To the left, a concrete staircase descends to the beach, but swimming is strongly discouraged due to the high danger level. The powerful waves can swiftly overwhelm swimmers. Instead, enjoy a leisurely stroll along the beach, heading toward a small cave at the far end.\n";

                        model.title1 = "Secret Caves at Gris Gris";

                        model.image1 = R.drawable.grisgris_2; // Set the value for image1

                        model.text2 = "In addition to the cave on the far left side of the beach, two other hidden caves can be discovered at Gris Gris. These are more challenging to reach, involving a descent down a cliff and walking through the water.\n" +
                                "Caution is advised against going all the way down, as water levels can fluctuate unpredictably, and the current is often too strong.\n" +
                                "For those eager to explore the secret caves at Gris Gris, head towards the cliff's edge directly across from the parking lot. Upon reaching the spot, descend only about halfway to catch a glimpse of the caves on your right.\n" +
                                "It's important to bear in mind that entering the caves could pose risks if the water level rises!\n" +
                                "Gris Gris beach is intricately connected to the village of Souillac, which relies heavily on tourism for its revenue. Established 200 years ago as a port for ships sailing from Europe to India, Souillac has a rich history worth exploring. Plan your day strategically to make the most of your visit to the southern part of Mauritius, and consider including a visit to Rochester Falls, just outside the village, renowned for its distinctive rectangular-sided rocks.\n";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (position == 3) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.la_cambuse_2; // Set the value for main_image

                        model.text1 = "The La Cambuse Beach graces the southeastern coast of the island, a mere 10-minute drive from the international airport. This pristine expanse of shoreline offers a captivating sense of untouched beauty, characterized by its broad stretch of sand adorned with natural shade-providing trees and complemented by picnic benches, creating an ideal setting for a scenic lunch. Take in the panoramic view of the lagoon, observing the untamed allure of waves crashing along the rugged and breathtaking coastline.";

                        model.title1 = "";

                        model.image1 = R.drawable.la_cambuse_3; // Set the value for image1

                        model.text2 = "It's noteworthy that the water currents in this area can be strong, prompting caution for those contemplating to swim. For an immersive experience, consider donning your hiking shoes and traversing the rocky terrain to uncover a trail leading to Le Bouchon and further onwards to the bridge-like cliff of Pont Naturel or the distinctive and rugged landscape of Le Souffleur. This journey promises a day filled with exploration and appreciation of the natural wonders that grace the surroundings.";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (position == 4) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.riviere_des_galets_1; // Set the value for main_image

                        model.text1 = "Located between Souillac and Bel Ombre, the Rivière des Galets Beach unfolds its unique charm, distinguished by the presence of innumerable small pebbles that pave its shores. Easily accessible along the coastal road in the southern region of Mauritius, in proximity to Ilot Sancho, this distinctive locale captivates with its one-of-a-kind character.";

                        model.title1 = "";

                        model.image1 = R.drawable.riviere_des_galets_4; // Set the value for image1

                        model.text2 = "Regarded as a noteworthy tourist attraction, the Rivière des Galets Beach is a must stop for those exploring the southern expanse of Mauritius. It provides an idyllic setting to unwind and savor the spectacle of robust waves crashing against the shoreline. In this coastal stretch, the sand is barely visible. Rather, the shore is layered with meticulously polished pebbles sculpted by the rhythmic dance of the incoming and receding waves.\n" +
                                "The beach unfolds an extraordinary panorama for visitors, serving as a picturesque backdrop that entices photographers and newlyweds, who frequently choose this locale for their enchanting photo shoots. The Rivière des Galets Beach, with its unconventional ambiance, is indeed a captivating departure from the typical Mauritian beaches, offering a splendid opportunity to explore the distinctive allure of the island's southern reaches.\n";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (position == 5) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.st_felix_1; // Set the value for main_image

                        model.text1 = "The Saint-Félix beach is an exquisite stretch of coastline located at the southernmost tip of the island, nestled between Souillac and Bel Ombre. Revered for its rare beauty, this beach boasts turquoise waters, pristine white sand, and is often regarded as the most picturesque beach in the southern region of Mauritius.\n" +
                                "Despite its allure, Saint-Félix remains somewhat enigmatic, with limited online information or imagery available. This secluded beach is divided into two sections, and the portion facing Morne is particularly enchanting, offering a private retreat amidst the elements and presenting an idyllic setting distinct from the more frequented tourist beaches on the island.\n" +
                                "Saint-Félix is an ideal destination for a leisurely day at the beach with friends or for intrepid adventurers seeking a slice of paradise to perfect their tan, away from the bustling shores of the island. Surrounded by lush vegetation that contrasts with the pristine white sand and turquoise sea, the beach exhibits a captivating array of blue hues.\n";

                        model.title1 = "";

                        model.image1 = R.drawable.map_location; // Set the value for image1

                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    }
                }
                else if (Stash.getString("type").equals("North")) {

                    if (position == 0)
                    {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.cap_malheureux_6; // Set the value for main_image

                        model.text1 = "Located on the northern tip of Mauritius, the Cap Malheureux Beach is located right behind the well-known Notre Dame Auxiliatrice Chapel, also known as the red church, famous for its vibrant color scheme and eye-catching facade. While its inviting waters are suitable for swimming, Cap Malheureux is more renowned as the starting point for boat and catamaran excursions to Flat Island and its lighthouse, along with the wildlife sanctuary of Round Island.";

                        model.title1 = "";

                        model.image1 = R.drawable.cap_malheureux_7; // Set the value for image1

                        model.text2 = "Scattered with basaltic rocks, the beach not only offers visitors a place to sit and relax while enjoying the peaceful view of the lagoon but also provides a breathtaking panorama of the northern offshore islets like Coin de Mire (Gunner’s Quoin), Ile Plate (Flat Island), Ile Ronde (Round Island), Ile aux Serpents (Serpent islet), and Ilôt Gabriel. \n" +
                                "The beach attracts water sports enthusiasts, especially for kiteboarding and windsurfing, particularly during the summer months when the winds are strong. Surfing is also popular, appealing to surfers with different skill levels. Children can have fun exploring the rock pools along the beach.\n";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.cap_malheureux_9; // Set the value for image2

                        model.text4 = "Despite being a quiet and tranquil beach, it receives a lot of locals during weekends, especially after chapel services. Therefore, it is recommended to visit this spot on weekdays and arrive early to secure a good parking spot.";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.grand_gaube_1; // Set the value for main_image

                        model.text1 = "The Grand Gaube Beach starkly contrast to its neighboring beaches Pereybere, Trou aux Biches, and Mont Choisy, all situated in the northern part of the island. This distinction arises not only from the minimal development in this corner of Mauritius but also due to its more rugged and rocky landscapes, making it unsuitable for swimming and water sports.\n" +
                                "The seabed of Grand Gaube beach is abundant with corals, and the sandy area is limited. This makes Grand Gaube a secluded beach.\n" +
                                "Despite the Ministry of Tourism's efforts to clean, install sanitation facilities, and embark on a beautification project, Grand Gaube has not managed to stand out from other beaches. Unfortunately, from a purely tourist perspective, Grand Gaube beach has little to offer and is destined to remain overshadowed by the more famous and beautiful beaches in the north.\n";

                        model.title1 = "";

                        model.image1 = R.drawable.map_location; // Set the value for image1

                        model.text2 = "Nevertheless, Grand Gaube remains an ideal beach for a breath of fresh air. Public beaches like Butte à L'herbe and Anse La Raie around Grand Gaube offer excellent alternatives for swimming or kitesurfing.\n" +
                                "For residents of Lux Grand Gaube, there are various activities available:\n" +
                                "•\tPedalo\n" +
                                "•\tWindsurfing\n" +
                                "•\tCatamaran\n" +
                                "•\tParasailing\n" +
                                "•\tScuba diving\n" +
                                "•\tDeep-sea fishing\n" +
                                "•\tSpeed boat trips\n" +
                                "•\tKayaking\n";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 2)
                    {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.mont_choisy_2; // Set the value for main_image

                        model.text1 = "Considered one of the most beautiful in the country, the Mont Choisy Beach is a haven for travelers seeking relaxation away from touristy crowds and commercialized beaches. Nestled in the Pamplemousses district in the north-west of Mauritius, this crescent-shaped, powdery white sand beach is the country's longest and one of the most serene.";
                        model.title1 = "Best Time to Visit Mont Choisy Beach";

                        model.image1 = R.drawable.map_location; // Set the value for image1

                        model.text2 = "While Mont Choisy Beach is a year-round destination, the ideal time to visit is from September to November, offering pleasant temperatures and limited rainfall. The warmest months are from January to March, perfect for enjoying the warm waters. November to January is the busiest period, and June to August is a quieter time for bargain hunters.";
                        model.title2 = "Things To Do at Mont Choisy Beach:";
                        model.text3 = "1.\t<b>Water sports & diving:</b> Mont Choisy Beach is a prominent water sports center, offering activities like kitesurfing, parasailing, water skiing, and glass-bottomed boat tours. Dive centers provide reef, drift, wreck, and deep-sea diving experiences with high safety standards.\n" +
                                "2.\t<b>Photography:</b> Capture the stunning blue hues, the arc-shaped coastline, and picturesque sunrise and sunset shots. The beach provides a perfect backdrop for memorable photographs.\n" +
                                "3.\t<b>Unwind:</b> Mont Choisy Beach is a serene and secluded spot, providing an escape from commercialization. Visitors can relax, swim, and enjoy local bites under the casuarina trees.\n" +
                                "4.\t<b>Beach soccer or golf:</b> The soft white sand is suitable for beach sports, and there is a beach soccer playground. Golf enthusiasts can explore the nearby 18-hole Mont Choisy Le Golf course with landscaped greens.\n" +
                                "5.\t<b>Horseback riding:</b> Visit Horse Riding Delights for a few hours of horseback riding along the splendid garden, admiring deer, giant tortoises, and farm animals.\n";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "Best Places to Stay Near Mont Choisy Beach:";
                        model.text5 = "•\t<b>Mont Choisy Beach Villas:</b> Located next to the beach, these villas offer excellent service, spacious accommodations, and panoramic views of the Indian Ocean.\n" +
                                "•\t<b>Casuarina Resort & Spa:</b> A 3-star property with elegant, air-conditioned rooms and bungalows, offering a location overlooking Trou aux Biches bay and complimentary water activities.\n" +
                                "•\t<b>Coral Azur Hotel Mont Choisy:</b> Nestled near the beach, this hotel provides value-for-money luxury, ocean-view swimming pool, and well-equipped rooms.\n" +
                                "•\t<b>Mont Choisy Beach R.:</b> A resort with beach-facing pool, apart-hotel style accommodations, and well-equipped kitchenettes for a resort-like experience.\n";
                        model.title4 = "";
                        model.text6 = "•\t<b>Choisy Les Bains:</b> A modern complex with well-appointed apartments, children's space, and a lovely garden, just walking distance from Mont Choisy beach.\n" +
                                "<b>How To Reach Mont Choisy Beach:</b> Located close to Port Louis, Mont Choisy Beach is easily accessible by car, taking about 20 minutes, or by an Express bus from the Immigration Square, taking around 35-40 minutes.\n";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (position == 3)
                    {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.pereybere_beach_1; // Set the value for main_image

                        model.text1 = "Despite its short 150-meter length, Pereybere Beach is considered the best family beach in the country. This is mainly because it's one of the few beaches where swimming is safe, making it a favorite for families, especially those with young children.\n" +
                                "The beach boasts clean white sands and clear turquoise water, surrounded by rows of palm trees. It's a breathtaking sight, and beach shacks along the shore offer a variety of food options. Water sports are popular here, and you can rent deck chairs to sunbathe while keeping an eye on your kids in the shallow waters.\n";
                        model.title1 = "";

                        model.image1 = R.drawable.pereybere_beach_5; // Set the value for image1

                        model.text2 = "Pereybere Beach is also perfect for collecting seashells, building sandcastles, and reliving childhood memories with your children. The crystal-clear waters offer a chance to observe underwater life, including colorful fish. Pedal boats are available for a delightful exploration of the Indian Ocean.\n" +
                                "\n";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.pereybere_beach_3; // Set the value for image2

                        model.text4 = "For those seeking more adventure, water sports like windsurfing, parasailing, and kayaking are available. The beach is known for deep-sea fishing, and catamarans offer a safe sea venture. Dolphin cruises are exciting, especially for children.";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.pereybere_beach_6;

                        model.text9 = "As the day winds down, Pereybere Beach provides a stunning sunset, making it must-see. However, it’s advisable to arrive early, especially on weekdays, to secure a good spot as the beach tends to get crowded, especially on weekends.\n" +
                                "\n";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.pereybere_beach_4;

                        model.text11 = "Unique to Mauritius is the underwater sea walk, a solar-powered experience where you can explore underwater life. It’s suitable for children as young as seven, accompanied by trained professionals. The beach area is lined with various restaurants offering a range of cuisines, from five-star hotels to food trucks.";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "Pereybere Beach is just five minutes away from Grand Baie, offering additional public beaches like La Cuvette Public Beach and Grand Baie Public Beach for those seeking a quieter atmosphere. Grand Baie itself has casinos, shopping options, and a lively nightlife.\n" +
                                "If you plan to stay near Pereybere Beach, you have various accommodation options, including Hibiscus Beach Resort & Spa, Pereybere Hotel and Spa, and Le Beachclub, each offering unique amenities and experiences.\n" +
                                "To reach Pereybere Beach from Port Louis, you can take the Express Cap Malheureux Bus from Immigration Square, and it will take around an hour. Alternatively, renting a car provides flexibility and convenience for the journey.\n";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (position == 4)
                    {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.trou_aux_biches_1; // Set the value for main_image

                        model.text1 = "Trou-aux-Biches, located on the northern coast of Mauritius in the Pamplemousses district, is a quaint town renowned for its public beach. Recognized by the World Travel group as one of the island's most beautiful beaches, it earned the prestigious title of World's Leading Beach Destination at the 2011 World Travel Award. The area boasts numerous tourist resorts and boutique hotels, such as the Trou aux Biches Resort & Spa. Accessible from Port Louis via the M2 highway, Trou-aux-Biches is approximately a mile west from the end of M2, and public buses connect the town with the airport.\n" ;
                        model.title1 = "";

                        model.image1 = R.drawable.map_location; // Set the value for image1

                        model.text2 = "Initially a fishing village in the 19th century, Trou-aux-Biches has undergone transformation into a charming town. The name dates back to the French colonial rule, featuring on the Lislet-Geoffroy map from 1807. Presently, it offers a two-kilometer-long white sand beach adorned with casuarina trees, snorkeling reefs, boutique shops, a supermarket, and various amenities along the B38 road, catering to family tourism.";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.trou_aux_biches_2; // Set the value for image2

                        model.text4 = "While tourism began in Mauritius in 1952, the first major hotel was established in Trou-aux-Biches in 1971, following the island's independence in 1968. The town maintains its village ambiance, distinguishing itself from the more commercialized Grand Baie nearby. Inland from Trou-aux-Biches stands the Maheswarnath Mandir, the largest Hindu temple on the island, founded in 1888.\n" +
                                "Visitors to Trou-aux-Biches can enjoy its beach, which is particularly popular for watching the sunset.\n" +
                                "\n";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } 
                }

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                if (Stash.getString("type").equals("West")) {
                    if (position == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.flic_en_flac_3; // Set the value for main_image

                        model.text1 = "Located on the west coast of Mauritius, Flic en Flac has emerged as the second most popular tourist area in the country, following Grand Baie.<br>" +
                                "Unlike the faster-paced development in the north, the west coast, including beautiful villages like Flic en Flac, has transformed from small fishing communities into charming towns, earning a reputation as a premier holiday destination.<br>" +
                                "Over the past two centuries, Flic en Flac has evolved from a humble fishing village into a prominent tourist hub. Today, it stands as a sought-after destination, attracting both international tourists and local Mauritians";
                        model.title1 = "";

                        model.image1 = R.drawable.flic_en_flac_1; // Set the value for image1

                        model.text2 = "Flic en Flac offers an ideal holiday experience with its excellent beaches, a variety of watersports, and a tranquil ambiance for complete relaxation. The location boasts a delightful setting with pristine white sand beaches and picturesque blue lagoons. Along the extensive 8 km beach, numerous restaurants, hotels, shops, and facilities cater to visitors.<br>" +
                                "The beach provides a perfect backdrop for activities such as afternoon strolls, watersports, sunbathing, or simply unwinding. It's an excellent spot for picnics, shaded by trees scattered along the coastline.<br>" +
                                "Flic en Flac's beach, adorned with Casuarina Trees, features a fine lagoon protected by a reef, ensuring safe swimming and opportunities for various watersports.<br>" +
                                "Flic-en-Flac buzzes with activity throughout the day and night, offering a dynamic atmosphere for visitors. In the daytime, guests can indulge in delectable street food options such as the \"DhalPuri,\" a thin, multi-layered flatbread crafted from flour, yellow split peas, salt, and water, filled with flavorful curry and sauces. Another popular local dish is fried noodles paired with Mauritian meatballs, enjoyed by both locals and visitors. However, it's crucial for those unfamiliar with the local water and cuisine to exercise extreme caution to prevent any potential food-related illnesses or stomach discomfort.<br> During the weekends, the beach becomes a vibrant hub for locals spending quality time with family and friends. Entertainment unfolds as some locals engage in singing and dancing to the rhythmic beats of Sega music, typically played with guitars and \"ravannes\" — a percussion instrument resembling the \"Bodhrán\" but played with distinctive techniques using hands.<br>" +
                                "The nightlife in Flic-en-Flac is lively, attracting both locals and tourists to nightclubs and restaurants, fostering a lively atmosphere for socializing. Despite its diverse offerings, it's important to note that the otherwise beautiful white sandy beach does contain a considerable amount of corals and sea urchins.";
                        model.title2 = "Flic en Flac - Location";
                        model.text3 = "Situated in the Black River district on the island's western coast, approximately 15 km south of the capital, Port Louis, Flic en Flac lies between the villages of Albion to the north and Tamarin and Black River to the south. The west coastline, lined with hotels and villas providing direct beach access, characterizes Flic en Flac. The drive to Port Louis takes around 30 minutes, while reaching the airport takes approximately 1 hour.<br>" +
                                "Flic en Flac benefits from a well-established bus route, facilitating easy transportation to key locations across Mauritius. Buses connect to Port Louis and other cities like Quatre Bornes and Curepipe, offering convenient access to various parts of the island.";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                        com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                    } else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.la_preneuse_4; // Set the value for main_image

                        model.text1 = "The shoreline is adorned with pristine, snow-white sand, featuring a gentle slope and shallow waters. The ocean remains tranquil, displaying a captivating turquoise hue, although intermittent strong currents can be experienced. La Preneuse Beach boasts a spacious and expansive setting, providing ample room for all vacationers. The panoramic view from the coast reveals the towering Mount Le Morne against the backdrop of the turquoise lagoon.<br>" +
                                "Situated on the west coast of Mauritius, the beach offers a range of hotels catering to different comfort levels for tourists. Cafes, stores, and souvenir shops offering diverse goods are conveniently located near the shoreline. A notable attraction is the Martello Tower, erected by the British in the 1830s as a defense against the French fleet. It now serves as a museum housing information about the region's history and the initial planters. The renowned Black River, a freshwater river, flows along the beach. Yachts and boats gracefully navigate the open sea, providing opportunities for sea excursions.";
                        model.title1 = "";

                        model.image1 = R.drawable.map_location; // Set the value for image1

                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                         com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  } else if (position == 2) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.le_morne_beach_2; // Set the value for main_image

                        model.text1 = "Nestled on a peninsula along the western coast of Mauritius, at the base of the UNESCO-listed Morne Brabant mountain, lies Le Morne Beach. Easily accessible from the coastal road, this public beach boasts miles of pristine white sand and is adorned with majestic casuarina trees, all against the backdrop of the crystal-clear waters providing excellent visibility for scuba diving.";
                        model.title1 = "";

                        model.image1 = R.drawable.kite_surfing; // Set the value for image1

                        model.text2 = "Renowned as one of the premier kite-surfing spots in Mauritius, and often regarded as one of the best in the world, Le Morne Beach offers a breathtaking setting with its iconic mountain in the background. The beach is a favorite among windsurfers and kite surfers, as the conditions for these water sports are ideal throughout much of the year. The annual Kiteival, attracting international participants, is among the many competitions hosted at this spectacular location.<br>" +
                                "While Le Morne Beach remains a delightful spot for swimming, it can get quite busy on weekends and holidays. Nudism is prohibited, although topless sunbathing is accepted. For a more tranquil experience, the best times to visit the beach are early in the morning from 8:00 to 11:00 or in the afternoon from 13:00 to 17:00.<br> ";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.paddle_boarding; // Set the value for image2

                        model.text4 = "An array of activities awaits beachgoers, including pedalo rides, windsurfing, kite surfing, scuba diving, stand-up paddleboarding, and kayaking, ensuring there's something for everyone to enjoy at Le Morne Beach. ";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                         com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  } else if (position == 3) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.la_preneuse_4; // Set the value for main_image
                        model.text1 = "The shoreline is adorned with pristine, snow-white sand, featuring a gentle slope and shallow waters. The ocean remains tranquil, displaying a captivating turquoise hue, although intermittent strong currents can be experienced. La Preneuse Beach boasts a spacious and expansive setting, providing ample room for all vacationers. The panoramic view from the coast reveals the towering Mount Le Morne against the backdrop of the turquoise lagoon.<br>" +
                                "Situated on the west coast of Mauritius, the beach offers a range of hotels catering to different comfort levels for tourists. Cafes, stores, and souvenir shops offering diverse goods are conveniently located near the shoreline. A notable attraction is the Martello Tower, erected by the British in the 1830s as a defense against the French fleet. It now serves as a museum housing information about the region's history and the initial planters. The renowned Black River, a freshwater river, flows along the beach. Yachts and boats gracefully navigate the open sea, providing opportunities for sea excursions.";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location; // Set the value for image1
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                         com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  }

                }
                else if (Stash.getString("type").equals("East")) {
                    if (position == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.belle_mare_1; // Set the value for main_image

                        model.text1 = "The Belle Mare Beach is located near the town of Mahebourg on the Southeast coast of Mauritius, spanning between the villages Belle Mare and Pointe de Flacq. Sheltered from the big waves by the coral reef, this crescent-shaped beach has a parking area and a shaded rest area under the filaos trees. It is quite wide with parts of fine, dazzling white sand. The water is transparent and calm, and the lagoon has a most magnificent turquoise blue color. In this realm, unspoiled nature prevails, with minimal development except for a few scattering hotels and exclusive villas.";
                        model.title1 = "";

                        model.image1 = R.drawable.belle_mare_3; // Set the value for image1

                        model.text2 = "Renowned among holidaymakers as the epitome of beauty, the Belle Mare Beach is cherished not only by visitors but also by the island's residents who frequent the beach, particularly on weekends and holidays. This enclave retains an authentic charm, preserving the island's essence amidst the rapid development witnessed by other coastal cities, notably Grand Bay, Flic en Flac, and Black River.<br>" +
                                "<br>";
                        model.title2 = "";
                        model.text3 = "The Belle Mare Beach is an idyllic destination for swimming and diving, particularly on weekdays when the serene ambiance prevails. It offers an ideal retreat for nature enthusiasts, allowing them to relish miles of sandy expanse for sunbathing.<br>" +
                                "The optimal times to visit the Belle Mare Beach are during the early morning hours from 7:00 to 11:00 or in the afternoon from 13:00 to 17:00.<br>" +
                                "Engage in an array of activities at Belle Mare Beach, including pedalo rides, windsurfing, catamaran journeys, horseback riding, parasailing, scuba diving, speed boat excursions, and kayaking.<br>";
                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                         com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  } else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.ile_aux_cerfs_mauritius_1; // Set the value for main_image

                        model.text1 = "On the eastern coast of Mauritius, just south of Trou d’Eau Douce, lies a pair of islands known collectively as Ile aux Cerfs. Ile aux Cerfs is a genuine paradise spanning 87 hectares. It is particularly appealing to water sports enthusiasts andis one of the most stunning beaches in Mauritius.";
                        model.title1 = "What to Explore and Experience on Ile aux Cerfs";

                        model.image1 = R.drawable.ile_aux_cerfs_7; // Set the value for image1

                        model.text2 = "The island is celebrated for its picturesque turquoise lagoon, perfectly suited for an extensive array of water sports. Among the activities available, whether undertaken solo or with a companion, is parasailing—an endeavor worth adding to your bucket list, particularly for the breathtaking vistas of the lagoon.<br>" +
                                "Other activities include speedboat rides, water skiing, and paddleboarding. Snorkeling is also an option, although, you'll need to take a boat to a location where there is coral as the water near the beach is shallow and consists predominantly of sand<br>";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.ile_aux_cerfs_5_1; // Set the value for image2

                        model.text4 = "While many visitors come to the Ile aux Cerfs for leisurely water activities, true sun worshippers find their sanctuary here, especially given the limited shelter on the beach. The overarching advice is to liberally apply sunscreen, preferably opting for products that are environmentally friendly. ";
                        model.title3 = "";
                        model.text5 = " close proximity to the pier, where the shuttle from Pointe Maurice drops them off. If you wish to evade the crowds, particularly on weekends, consider strolling a bit farther along the coast. Numerous other nearby beaches offer equally tranquil surroundings.";
                        model.title4 = "How to Reach Ile aux Cerfs";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.ile_aux_cerfs_7;

                        model.text9 = "Access to the island is granted to the public from 9:00 a.m. to 6:00 p.m. Starting from the village of Trou-d’Eau Douce, a shuttle embarks every half hour from the pier at Pointe Maurice to the Masala pier on Ile aux Cerfs, at 9:30 a.m.<br>" +
                                "An alternative approach is by catamaran, with numerous providers offering scenic journeys to the island, sometimes incorporating detours to or from the waterfalls in the nature reserve of Grande Rivière Sud Est.<br>";
                        model.title8 = "Optimal Time to Explore the Island ";
                        model.text10 = "";

                        model.image4 = R.drawable.ile_aux_cerfs_6;

                        model.text11 = "The island tends to attract a considerable influx of day trippers during weekends. If your stay in Mauritius extends to at least a week, it is advisable to plan your visit on a weekday. While October and November are considered the prime months to experience Ile aux Cerfs, the period from June to November also offers a delightful visit.<br>" +
                                "<b>Accommodation</b> <br>" +
                                "Noteworthy among the accommodations on Ile aux Cerfs is the opulent 5-star Shangri-La’s Le Touessrok Resort & Spa. While not budget-friendly, it provides an exceptional setting for grand celebrations. <br>" +
                                "<b>Culinary Offerings</b><br>";
                        model.image5 = R.drawable.ile_aux_cerfs_3;
                        model.text12 = "Ile aux Cerfshas several dining establishments, including a charming beachside restaurant. Additionally, two bars are available for visitors seeking refreshing beverages or cocktails at reasonable prices. An alternative is to bring ample food and drinks to suit your preferences.";
                         com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  } else if (position == 2) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.poste_lafayette_1; // Set the value for main_image

                        model.text1 = "This unspoiled beach, often overlooked due to its turbulent sea, offers a rare opportunity to embrace tranquility and serenity. With its authentically rustic and untouched nature, this charming locale continually captivates nature enthusiasts. The preserved green habitat is a sanctuary for massive coral reefs, fostering rich marine biodiversity and mangroves.";
                        model.title1 = "";

                        model.image1 = R.drawable.poste_lafayette_2; // Set the value for image1

                        model.text2 = "Those seeking a peaceful picnic will be pleased that the southern part of the beach provides a serene retreat. Additionally, the southern beach serves as an ideal starting point for a trek leading north of Poste Lafayette, offering picturesque green landscapes along the rocky trail.";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.poste_lafayette_3; // Set the value for image2
//                        model.image2 = R.drawable.paddle_boarding; // Set the value for image2

                        model.text4 = "Picnicking in the shelter of the trees is a delightful option in certain areas where the sea displays stormy waves due to the proximity of the reefs to the lagoons. Enthusiasts of kite surfing and windsurfing will find this place ideal since Poste Lafayette is consistently exposed to the trade winds throughout ";
                        //                        model.text4 = "An array of activities awaits beachgoers, including pedalo rides, windsurfing, kite surfing, scuba diving, stand-up paddleboarding, and kayaking, ensuring there's something for everyone to enjoy at Le Morne Beach. ";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.poste_lafayette_4;

                        model.text9 = "While the sea may be too challenging for a Sunday swim, the shore or shallow waters provide opportunities for sunbathing while children can revel in building sandcastles";
                        model.title8 = "";
                        model.text10 = "The eastern coast boasts prominent hotels and restaurants, including establishments like Jalsa Beach Hotel & Spa, Radisson Blu Poste Lafayette Resort & Spa, and the esteemed Hôtel Constance Le Prince Maurice. <br>" +
                                "To cater to the discerning tourist, gourmet restaurants have thrived alongside small traditional eateries. La Maison D’Été, specializing in Italian cuisine with seafood and fish menus, is a must-visit in Poste Lafayette. Another favored dining spot, Seabell, offers a menu featuring typical Mauritian dishes, complemented by a nearby mini market owned by the Seabell owners.<br>" +
                                "<br>";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                         com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  } else if (position == 3) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();

                        model.main_image = R.drawable.roche_noire_2; // Set the value for main_image
                        model.text1 = "Ranked among the top 10 beaches in Mauritius, the Roche Noire Beach is located just a few kilometers from Poste Lafayette on the southeast coast of the island. The beach has a stunning landscape characterized by black lava rocks and a dark sea, where gentle waves crash onto the nearby coral reef. The pristine sand and the spectacular views of sunrise and sunset contribute to making Roche Noire Beach an unparalleled destination. The winds throughout the year provide a refreshing breeze, especially during the hot summer months. It is one of the most photographed beaches according to tourist reviews.";
                        model.title1 = "";
                        model.image1 = R.drawable.roche_noire_3; // Set the value for image1
                        model.text2 = "The Roche Noire Beach is a true paradise for those who love water activities and appreciate nature. Guests can partake in a range of aquatic adventures, including swimming, snorkeling, and kayaking, allowing them to discover the diverse marine life and colorful coral reefs. Furthermore, the tranquil ambiance of the beach creates an ideal setting for a leisurely walk or a peaceful sunbathing experience. <br>" +
                                "Parking facilities are commonly accessible in the vicinity of the Roche Noire Beach, offering travelers a choice between free and paid parking options for easy access to the beach. Interesting fact about the Roche Noire Beach – the beach is famed for its breathtaking volcanic rock formations along the coastline, enhancing the natural beauty of the surroundings with a unique touch.<br>";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.map_location; // Set the value for image2
                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                         com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  }
                }
                else if (Stash.getString("type").equals("South")) {
                    if (position == 0) {
                                               BeacModel model = new BeacModel();
 model.title = textView.getText().toString();
                        model.main_image = R.drawable.bel_ombre_17; // Set the value for main_image
                        model.text1 = "Nestled in the southwestern part of Mauritius, the Bel Ombre Beach delicately unveils its shores of golden sand, extending a gracious invitation to aficionados of the sea.";
                        model.title1 = "";
                        model.image1 = R.drawable.bel_ombre_18; // Set the value for image1
                        model.text2 = "Along the turquoise shoreline, the Bel Ombre Beach unveils its captivating allure, accompanied by the gentle and intoxicating fragrance of paradise enveloped by the verdant casuarina trees. A mild southern breeze carries the delightful aroma of the vast open sea, a sensory indulgence prompting a poignant reminder to live life fully.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.bel_ombre_16; // Set the value for image2
                        model.text4 = "Stretching along the shoreline are extensive stretches of pristine white sand, graced by the shade of coconut trees standing as sentinel at the periphery of the opulent hotels. In this paradisiacal milieu, where casuarina trees and unspoiled nature meet, the Bel Ombre Beach in Mauritius is no doubt an oasis of serenity and peace.\n" +
                                "The best times to visit the Bel Ombre Beach are during the early morning hours from 7:00 to 11:00 or in the afternoon from 13:00 to 17:00.\n" +
                                "Engage in a spectrum of activities at the Bel Ombre Beach, including pedalo rides, scuba diving, speed boat journeys, and kayaking.\n";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                           com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  } else if (position == 1) {
                                               BeacModel model = new BeacModel();
 model.title = textView.getText().toString();
                        model.main_image = R.drawable.blue_bay; // Set the value for main_image

                        model.text1 = "Located in the southeast of the island, Blue Bay was designated a national park in 1997 and later recognized as a wetland site under the Ramsar Convention on Wetlands of International Importance in 2008. The marine park is renowned for its coral garden, housing a diverse array of corals and abundant fauna. Close to the coastline, it offers ideal conditions for snorkeling, boasting rich biodiversity and calm, shallow seawater.";

                        model.title1 = "";

                        model.image1 = R.drawable.blue_bay_4; // Set the value for image1

                        model.text2 = "Upon setting foot on Blue Bay beach, you will bump into hawkers selling artisanal jewelry and canvassers promoting glass-bottom boat trips or snorkeling outings. Over fifteen operators are permitted to engage in commercial activities within the Blue Bay Marine Park.";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.blue_bay_2; // Set the value for image2

                        model.text4 = "The main attraction in the Marine Park is a more than 1,000-year-old brain coral with a 5-meter diameter, making it the region's primary tourist attraction. The coral garden near Mahebourg, a small coastal village in the south-east, boasts a remarkable surface area and biodiversity. Visitors often come to witness the ancient brain coral, and various activities, such as glass-bottom boat trips, offer different perspectives of the vibrant marine life.\n" +
                                "Most operators in Blue Bay Marine Park are descendants of local fishermen turned to tourism. Glass-bottom boat trips are accessible to all, providing a serene experience to explore the beauty of the park. Those seeking a closer encounter can embark on a boat and snorkel, enjoying the vibrant underwater life in warm and clear waters.\n" +
                                "The Marine Park covers 353 hectares and is a popular leisure area for tourists and locals, sustaining numerous households through various activities. Measures have been implemented to balance economic activity with sustainable development, including the installationof permanent mooring buoys to demarcate conservation areas and regulated zones for fishing, boat traffic, swimming, and waterskiing. These measures aim to protect the marine fauna and flora, preserve biodiversity, promote scientific research, and educate the public.\n" +
                                "\n";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.blue_bay_6;

                        model.text9 = "Coast guards patrol the area daily to enforce regulations, ensuring compliance from skippers, swimmers, and fishermen. ";
                        model.title8 = "Protected Marine Area, Key Features";
                        model.text10 = "•\t<b>Exceptional Marine Biodiversity:</b> Blue Bay Marine Park features various ecosystems, including coral reefs, meadows of phanerogamous plants, mangroves, macro-algae, and inner lagoon flat stations. It houses over 38 coral species, 72 fish species, 31 algae species, 2 mangrove species, and 4 species of phanerogamous plants.";

                        model.image4 = R.drawable.blue_bay_3;

                        model.text11 = "•\t<b>Unique Classification in Mauritius:</b> Designated a Marine Park under the Wildlife and National Parks Act 1993, a protected zone in 2000 under the Fisheries and Marine Act 1998 and recognized as a Ramsar Convention site in 2008. Mooring buoys are strategically placed to minimize damage to corals by boat anchors.";

                        model.image5 = R.drawable.blue_bay_8;

                        model.text12 = "•\t<b>Outdoor Activities Available to All:</b> Glass-bottom boat trips and snorkeling are popular activities, allowing non-swimmers to explore the marine environment through the glass bottom. Snorkeling conditions are ideal, and Coco Island, visible from the beach, serves as a relaxing spot for snorkelers under casuarina trees. Operators provide drop-off and pick-up services.";
                           com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  } else if (position == 2) {
                                               BeacModel model = new BeacModel();
 model.title = textView.getText().toString();
                        model.main_image = R.drawable.gris_gris_coastal_4; // Set the value for main_image

                        model.text1 = "The primary beach area features an expansive green field with a commanding view of dramatic cliffs and enormous waves. There are benches and a pavilion available for relaxation while taking in the scenery.\n" +
                                "To the left, a concrete staircase descends to the beach, but swimming is strongly discouraged due to the high danger level. The powerful waves can swiftly overwhelm swimmers. Instead, enjoy a leisurely stroll along the beach, heading toward a small cave at the far end.\n";

                        model.title1 = "Secret Caves at Gris Gris";

                        model.image1 = R.drawable.grisgris_2; // Set the value for image1

                        model.text2 = "In addition to the cave on the far left side of the beach, two other hidden caves can be discovered at Gris Gris. These are more challenging to reach, involving a descent down a cliff and walking through the water.\n" +
                                "Caution is advised against going all the way down, as water levels can fluctuate unpredictably, and the current is often too strong.\n" +
                                "For those eager to explore the secret caves at Gris Gris, head towards the cliff's edge directly across from the parking lot. Upon reaching the spot, descend only about halfway to catch a glimpse of the caves on your right.\n" +
                                "It's important to bear in mind that entering the caves could pose risks if the water level rises!\n" +
                                "Gris Gris beach is intricately connected to the village of Souillac, which relies heavily on tourism for its revenue. Established 200 years ago as a port for ships sailing from Europe to India, Souillac has a rich history worth exploring. Plan your day strategically to make the most of your visit to the southern part of Mauritius, and consider including a visit to Rochester Falls, just outside the village, renowned for its distinctive rectangular-sided rocks.\n";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                           com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  } else if (position == 3) {
                                               BeacModel model = new BeacModel();
 model.title = textView.getText().toString();
                        model.main_image = R.drawable.la_cambuse_2; // Set the value for main_image

                        model.text1 = "The La Cambuse Beach graces the southeastern coast of the island, a mere 10-minute drive from the international airport. This pristine expanse of shoreline offers a captivating sense of untouched beauty, characterized by its broad stretch of sand adorned with natural shade-providing trees and complemented by picnic benches, creating an ideal setting for a scenic lunch. Take in the panoramic view of the lagoon, observing the untamed allure of waves crashing along the rugged and breathtaking coastline.";

                        model.title1 = "";

                        model.image1 = R.drawable.la_cambuse_3; // Set the value for image1

                        model.text2 = "It's noteworthy that the water currents in this area can be strong, prompting caution for those contemplating to swim. For an immersive experience, consider donning your hiking shoes and traversing the rocky terrain to uncover a trail leading to Le Bouchon and further onwards to the bridge-like cliff of Pont Naturel or the distinctive and rugged landscape of Le Souffleur. This journey promises a day filled with exploration and appreciation of the natural wonders that grace the surroundings.";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                           com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  } else if (position == 4) {
                                               BeacModel model = new BeacModel();
 model.title = textView.getText().toString();
                        model.main_image = R.drawable.riviere_des_galets_1; // Set the value for main_image

                        model.text1 = "Located between Souillac and Bel Ombre, the Rivière des Galets Beach unfolds its unique charm, distinguished by the presence of innumerable small pebbles that pave its shores. Easily accessible along the coastal road in the southern region of Mauritius, in proximity to Ilot Sancho, this distinctive locale captivates with its one-of-a-kind character.";

                        model.title1 = "";

                        model.image1 = R.drawable.riviere_des_galets_4; // Set the value for image1

                        model.text2 = "Regarded as a noteworthy tourist attraction, the Rivière des Galets Beach is a must stop for those exploring the southern expanse of Mauritius. It provides an idyllic setting to unwind and savor the spectacle of robust waves crashing against the shoreline. In this coastal stretch, the sand is barely visible. Rather, the shore is layered with meticulously polished pebbles sculpted by the rhythmic dance of the incoming and receding waves.\n" +
                                "The beach unfolds an extraordinary panorama for visitors, serving as a picturesque backdrop that entices photographers and newlyweds, who frequently choose this locale for their enchanting photo shoots. The Rivière des Galets Beach, with its unconventional ambiance, is indeed a captivating departure from the typical Mauritian beaches, offering a splendid opportunity to explore the distinctive allure of the island's southern reaches.\n";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                           com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  } else if (position == 5) {
                                               BeacModel model = new BeacModel();
 model.title = textView.getText().toString();
                        model.main_image = R.drawable.st_felix_1; // Set the value for main_image

                        model.text1 = "The Saint-Félix beach is an exquisite stretch of coastline located at the southernmost tip of the island, nestled between Souillac and Bel Ombre. Revered for its rare beauty, this beach boasts turquoise waters, pristine white sand, and is often regarded as the most picturesque beach in the southern region of Mauritius.\n" +
                                "Despite its allure, Saint-Félix remains somewhat enigmatic, with limited online information or imagery available. This secluded beach is divided into two sections, and the portion facing Morne is particularly enchanting, offering a private retreat amidst the elements and presenting an idyllic setting distinct from the more frequented tourist beaches on the island.\n" +
                                "Saint-Félix is an ideal destination for a leisurely day at the beach with friends or for intrepid adventurers seeking a slice of paradise to perfect their tan, away from the bustling shores of the island. Surrounded by lush vegetation that contrasts with the pristine white sand and turquoise sea, the beach exhibits a captivating array of blue hues.\n";

                        model.title1 = "";

                        model.image1 = R.drawable.map_location; // Set the value for image1

                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                           com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  }
                }
                else if (Stash.getString("type").equals("North")) {

                    if (position == 0)
                    {
                                               BeacModel model = new BeacModel();
 model.title = textView.getText().toString();
                        model.main_image = R.drawable.cap_malheureux_6; // Set the value for main_image

                        model.text1 = "Located on the northern tip of Mauritius, the Cap Malheureux Beach is located right behind the well-known Notre Dame Auxiliatrice Chapel, also known as the red church, famous for its vibrant color scheme and eye-catching facade. While its inviting waters are suitable for swimming, Cap Malheureux is more renowned as the starting point for boat and catamaran excursions to Flat Island and its lighthouse, along with the wildlife sanctuary of Round Island.";

                        model.title1 = "";

                        model.image1 = R.drawable.cap_malheureux_7; // Set the value for image1

                        model.text2 = "Scattered with basaltic rocks, the beach not only offers visitors a place to sit and relax while enjoying the peaceful view of the lagoon but also provides a breathtaking panorama of the northern offshore islets like Coin de Mire (Gunner’s Quoin), Ile Plate (Flat Island), Ile Ronde (Round Island), Ile aux Serpents (Serpent islet), and Ilôt Gabriel. \n" +
                                "The beach attracts water sports enthusiasts, especially for kiteboarding and windsurfing, particularly during the summer months when the winds are strong. Surfing is also popular, appealing to surfers with different skill levels. Children can have fun exploring the rock pools along the beach.\n";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.cap_malheureux_9; // Set the value for image2

                        model.text4 = "Despite being a quiet and tranquil beach, it receives a lot of locals during weekends, especially after chapel services. Therefore, it is recommended to visit this spot on weekdays and arrive early to secure a good parking spot.";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                           com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  }
                    else if (position == 1) {
                                               BeacModel model = new BeacModel();
 model.title = textView.getText().toString();
                        model.main_image = R.drawable.grand_gaube_1; // Set the value for main_image

                        model.text1 = "The Grand Gaube Beach starkly contrast to its neighboring beaches Pereybere, Trou aux Biches, and Mont Choisy, all situated in the northern part of the island. This distinction arises not only from the minimal development in this corner of Mauritius but also due to its more rugged and rocky landscapes, making it unsuitable for swimming and water sports.\n" +
                                "The seabed of Grand Gaube beach is abundant with corals, and the sandy area is limited. This makes Grand Gaube a secluded beach.\n" +
                                "Despite the Ministry of Tourism's efforts to clean, install sanitation facilities, and embark on a beautification project, Grand Gaube has not managed to stand out from other beaches. Unfortunately, from a purely tourist perspective, Grand Gaube beach has little to offer and is destined to remain overshadowed by the more famous and beautiful beaches in the north.\n";

                        model.title1 = "";

                        model.image1 = R.drawable.map_location; // Set the value for image1

                        model.text2 = "Nevertheless, Grand Gaube remains an ideal beach for a breath of fresh air. Public beaches like Butte à L'herbe and Anse La Raie around Grand Gaube offer excellent alternatives for swimming or kitesurfing.\n" +
                                "For residents of Lux Grand Gaube, there are various activities available:\n" +
                                "•\tPedalo\n" +
                                "•\tWindsurfing\n" +
                                "•\tCatamaran\n" +
                                "•\tParasailing\n" +
                                "•\tScuba diving\n" +
                                "•\tDeep-sea fishing\n" +
                                "•\tSpeed boat trips\n" +
                                "•\tKayaking\n";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                           com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  }
                    else if (position == 2)
                    {
                                               BeacModel model = new BeacModel();
 model.title = textView.getText().toString();
                        model.main_image = R.drawable.mont_choisy_2; // Set the value for main_image

                        model.text1 = "Considered one of the most beautiful in the country, the Mont Choisy Beach is a haven for travelers seeking relaxation away from touristy crowds and commercialized beaches. Nestled in the Pamplemousses district in the north-west of Mauritius, this crescent-shaped, powdery white sand beach is the country's longest and one of the most serene.";
                        model.title1 = "Best Time to Visit Mont Choisy Beach";

                        model.image1 = R.drawable.map_location; // Set the value for image1

                        model.text2 = "While Mont Choisy Beach is a year-round destination, the ideal time to visit is from September to November, offering pleasant temperatures and limited rainfall. The warmest months are from January to March, perfect for enjoying the warm waters. November to January is the busiest period, and June to August is a quieter time for bargain hunters.";
                        model.title2 = "Things To Do at Mont Choisy Beach:";
                        model.text3 = "1.\t<b>Water sports & diving:</b> Mont Choisy Beach is a prominent water sports center, offering activities like kitesurfing, parasailing, water skiing, and glass-bottomed boat tours. Dive centers provide reef, drift, wreck, and deep-sea diving experiences with high safety standards.\n" +
                                "2.\t<b>Photography:</b> Capture the stunning blue hues, the arc-shaped coastline, and picturesque sunrise and sunset shots. The beach provides a perfect backdrop for memorable photographs.\n" +
                                "3.\t<b>Unwind:</b> Mont Choisy Beach is a serene and secluded spot, providing an escape from commercialization. Visitors can relax, swim, and enjoy local bites under the casuarina trees.\n" +
                                "4.\t<b>Beach soccer or golf:</b> The soft white sand is suitable for beach sports, and there is a beach soccer playground. Golf enthusiasts can explore the nearby 18-hole Mont Choisy Le Golf course with landscaped greens.\n" +
                                "5.\t<b>Horseback riding:</b> Visit Horse Riding Delights for a few hours of horseback riding along the splendid garden, admiring deer, giant tortoises, and farm animals.\n";

                        model.image2 = R.drawable.map_location; // Set the value for image2

                        model.text4 = "";
                        model.title3 = "Best Places to Stay Near Mont Choisy Beach:";
                        model.text5 = "•\t<b>Mont Choisy Beach Villas:</b> Located next to the beach, these villas offer excellent service, spacious accommodations, and panoramic views of the Indian Ocean.\n" +
                                "•\t<b>Casuarina Resort & Spa:</b> A 3-star property with elegant, air-conditioned rooms and bungalows, offering a location overlooking Trou aux Biches bay and complimentary water activities.\n" +
                                "•\t<b>Coral Azur Hotel Mont Choisy:</b> Nestled near the beach, this hotel provides value-for-money luxury, ocean-view swimming pool, and well-equipped rooms.\n" +
                                "•\t<b>Mont Choisy Beach R.:</b> A resort with beach-facing pool, apart-hotel style accommodations, and well-equipped kitchenettes for a resort-like experience.\n";
                        model.title4 = "";
                        model.text6 = "•\t<b>Choisy Les Bains:</b> A modern complex with well-appointed apartments, children's space, and a lovely garden, just walking distance from Mont Choisy beach.\n" +
                                "<b>How To Reach Mont Choisy Beach:</b> Located close to Port Louis, Mont Choisy Beach is easily accessible by car, taking about 20 minutes, or by an Express bus from the Immigration Square, taking around 35-40 minutes.\n";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                           com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  } else if (position == 3)
                    {
                                               BeacModel model = new BeacModel();
 model.title = textView.getText().toString();
                        model.main_image = R.drawable.pereybere_beach_1; // Set the value for main_image

                        model.text1 = "Despite its short 150-meter length, Pereybere Beach is considered the best family beach in the country. This is mainly because it's one of the few beaches where swimming is safe, making it a favorite for families, especially those with young children.\n" +
                                "The beach boasts clean white sands and clear turquoise water, surrounded by rows of palm trees. It's a breathtaking sight, and beach shacks along the shore offer a variety of food options. Water sports are popular here, and you can rent deck chairs to sunbathe while keeping an eye on your kids in the shallow waters.\n";
                        model.title1 = "";

                        model.image1 = R.drawable.pereybere_beach_5; // Set the value for image1

                        model.text2 = "Pereybere Beach is also perfect for collecting seashells, building sandcastles, and reliving childhood memories with your children. The crystal-clear waters offer a chance to observe underwater life, including colorful fish. Pedal boats are available for a delightful exploration of the Indian Ocean.\n" +
                                "\n";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.pereybere_beach_3; // Set the value for image2

                        model.text4 = "For those seeking more adventure, water sports like windsurfing, parasailing, and kayaking are available. The beach is known for deep-sea fishing, and catamarans offer a safe sea venture. Dolphin cruises are exciting, especially for children.";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.pereybere_beach_6;

                        model.text9 = "As the day winds down, Pereybere Beach provides a stunning sunset, making it must-see. However, it’s advisable to arrive early, especially on weekdays, to secure a good spot as the beach tends to get crowded, especially on weekends.\n" +
                                "\n";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.pereybere_beach_4;

                        model.text11 = "Unique to Mauritius is the underwater sea walk, a solar-powered experience where you can explore underwater life. It’s suitable for children as young as seven, accompanied by trained professionals. The beach area is lined with various restaurants offering a range of cuisines, from five-star hotels to food trucks.";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "Pereybere Beach is just five minutes away from Grand Baie, offering additional public beaches like La Cuvette Public Beach and Grand Baie Public Beach for those seeking a quieter atmosphere. Grand Baie itself has casinos, shopping options, and a lively nightlife.\n" +
                                "If you plan to stay near Pereybere Beach, you have various accommodation options, including Hibiscus Beach Resort & Spa, Pereybere Hotel and Spa, and Le Beachclub, each offering unique amenities and experiences.\n" +
                                "To reach Pereybere Beach from Port Louis, you can take the Express Cap Malheureux Bus from Immigration Square, and it will take around an hour. Alternatively, renting a car provides flexibility and convenience for the journey.\n";
                           com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);
       add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                                  } else if (position == 4)
                    {
                                               BeacModel model = new BeacModel();
 model.title = textView.getText().toString();
                        model.main_image = R.drawable.trou_aux_biches_1; // Set the value for main_image

                        model.text1 = "Trou-aux-Biches, located on the northern coast of Mauritius in the Pamplemousses district, is a quaint town renowned for its public beach. Recognized by the World Travel group as one of the island's most beautiful beaches, it earned the prestigious title of World's Leading Beach Destination at the 2011 World Travel Award. The area boasts numerous tourist resorts and boutique hotels, such as the Trou aux Biches Resort & Spa. Accessible from Port Louis via the M2 highway, Trou-aux-Biches is approximately a mile west from the end of M2, and public buses connect the town with the airport.\n" ;
                        model.title1 = "";

                        model.image1 = R.drawable.map_location; // Set the value for image1

                        model.text2 = "Initially a fishing village in the 19th century, Trou-aux-Biches has undergone transformation into a charming town. The name dates back to the French colonial rule, featuring on the Lislet-Geoffroy map from 1807. Presently, it offers a two-kilometer-long white sand beach adorned with casuarina trees, snorkeling reefs, boutique shops, a supermarket, and various amenities along the B38 road, catering to family tourism.";
                        model.title2 = "";
                        model.text3 = "";

                        model.image2 = R.drawable.trou_aux_biches_2; // Set the value for image2

                        model.text4 = "While tourism began in Mauritius in 1952, the first major hotel was established in Trou-aux-Biches in 1971, following the island's independence in 1968. The town maintains its village ambiance, distinguishing itself from the more commercialized Grand Baie nearby. Inland from Trou-aux-Biches stands the Maheswarnath Mandir, the largest Hindu temple on the island, founded in 1888.\n" +
                                "Visitors to Trou-aux-Biches can enjoy its beach, which is particularly popular for watching the sunset.\n" +
                                "\n";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";

                        model.image3 = R.drawable.map_location;

                        model.text9 = "";
                        model.title8 = "";
                        model.text10 = "";

                        model.image4 = R.drawable.map_location;

                        model.text11 = "";

                        model.image5 = R.drawable.map_location;

                        model.text12 = "";
                           com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                        databaseHelper.insertBeacModel(model);

                                        add.setVisibility(View.GONE);
                        remove.setVisibility(View.VISIBLE);
                  }
                }

            }
        });

        return itemView;
    }


}
