package com.moutimid.sqlapp.adapter;

import static com.moutimid.sqlapp.model.DatabaseHelper.TABLE_NAME;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fxn.stash.Stash;
import com.moutimid.sqlapp.R;
import com.moutimid.sqlapp.activities.Beaches.BeachDetails;
import com.moutimid.sqlapp.model.BeacModel;
import com.moutimid.sqlapp.model.DatabaseHelper;

import java.util.List;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder> {

    private Context context;
    private String[] itemName;
    private int[] itemImages;
    String name;

    public ExploreAdapter(Context context, String[] itemName, int[] itemImages, String name) {
        this.context = context;
        this.itemImages = itemImages;
        this.itemName = itemName;
        this.name = name;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.explore_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(itemImages[position]);
        holder.textView.setText(itemName[position]);
        com.moutimid.sqlapp.model.DatabaseHelper databaseHelper;
        databaseHelper = new DatabaseHelper(context);
        List<BeacModel> beacModels = databaseHelper.getAllBeacModels();
        boolean isDataAvailable = false;
        for (BeacModel model : beacModels) {
            Log.d("model", model.text1 + " test");

            if (model.title.equals(holder.textView.getText().toString())) {
                isDataAvailable = true;
                break;
            }
        }
        if (isDataAvailable) {
            holder.add.setVisibility(View.GONE);
            holder.remove.setVisibility(View.VISIBLE);
        } else {
            holder.add.setVisibility(View.VISIBLE);
            holder.remove.setVisibility(View.GONE);
        }
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String deleteName = holder.textView.getText().toString();
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                db.delete(TABLE_NAME, DatabaseHelper.COLUMN_TITLE + "=?", new String[]{deleteName});
                db.close();
                holder.remove.setVisibility(View.GONE);
                holder.add.setVisibility(View.VISIBLE);
                notifyDataSetChanged();
            }
        });
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                switch (name) {
                    case "Central":
                        if (holder.getAdapterPosition() == 0) {
                            BeacModel model = new BeacModel();
                            model.type = name;
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.bagatelle_mall_1;
                            model.text1 = "The Bagatelle Mall is a premier shopping destination in Mauritius, offering a myriad of options in the realms of shopping, dining, and entertainment. Located in the Moka area, it opened its doors in September of 2011. Boasting an impressive array of over 150 stores, the mall showcases a harmonious blend of internationally renowned brands such as Mango, Zara, and Lacoste alongside cherished local labels. Additional facilities within the mall include a hypermarket, a gastronomic court, a cinema, and a children's play zone.<br>" + "The culinary offerings at Bagatelle Mall of Mauritius are equally diverse, comprising refined restaurants, charming cafes, and fast-food establishments. The food court, a focal point of gastronomic delight, hosts multiple vendors specializing in a plethora of cuisines. Whether one seeks a quick bite or a more leisurely dining experience, the Bagatelle Mall ensures a gastronomic journey to satiate even the most discerning palates. Revered by both locals and tourists alike, the mall has solidified its status as a cultural landmark in Mauritius.<br>" + "Accessing Bagatelle Mall of Mauritius is easy, facilitated by taxi services, or public transportation. For those opting for a personal vehicle, the mall is strategically positioned along the M1 highway, approximately 10 minutes southward from Port Louis, the capital city. The mall has plenty of parking spaces.  Alternatively, taxis or public transport offer convenient alternatives, with multiple bus routes servicing the area and conveniently located stops in close proximity to the mall.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 1) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.bois_cheri_1;
                            model.text1 = "The Bois Cheri Plantation was established in 1892 and since then has become the largest tea producer in the country. Covering more than 250 hectares, it includes a museum and a factory where visitors can learn all about the art and science of tea.<br>" + "When you visit the tea estate, you can join guided tours to explore the factory, see the museum and plantation, and even try some tea tasting. Your guide will share the history and stories of Bois Chéri and explain how important tea production is for Mauritius.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.bois_cheri_8;
                            model.text2 = "If you enjoy tea and nature, this tour is a must. The plantation is close to the museum and the main factory, surrounded by lush greenery. The peaceful setting provides a perfect backdrop for relaxation.";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.bois_cheri_6;
                            model.text4 = "Aside from the beautiful tea plantation, you'll enjoy picturesque views of the South coast on one side and a stunning crater lake on the other. Driving around is delightful, with spots to stop and capture photos of the lake, unique trees, and tea plantations from different angles.";
                            model.title3 = "The factory and Museum";
                            model.text5 = "The museum provides lots of information about Mauritian tea history, showcasing old machines used in tea production, including an old locomotive train. The factory tour allows you to see the tea-making process in action. Bois Cheri produces both green and black tea, with their signature being vanilla tea.";
                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.bois_cheri_7;
                            model.text9 = "After your museum and factory adventure, it's time for tea tasting. Head to the factory café near the restaurant to try various teas. You can also purchase waffles or pancakes to enjoy with your tea.<br>" + "The Bois Cheri restaurant is within walking distance and offers breathtaking views of the south coast. The restaurant serves unique cuisines, including local flavors. You'll have the chance to taste dishes like shrimps with green tea and chicken with exotic tea. Whether you visit with friends or family, the restaurant and the entire tour offer a delightful experience with delicious food, scenic views, and soothing music.<br>";
                            model.title8 = "";
                            model.text10 = "";
                            model.image4 = R.drawable.bois_cheri_4;
                            model.text11 = "<b>Visit Hours</b><br>" + " <br>" + "Monday to Friday:<br><br>" + "09.00 - 14.00<br><br>" + "Saturday:<br><br>" + "09.00 - 11.00<br><br>" + "<b>Bois Chéri Tea FactoryOperating Hours</b><br><br>" + "Monday - Friday 09.00 - 14.00 & Saturday 09.00 - 11.00 (closed on Sundays & public holidays)<br> ";
                            model.image5 = R.drawable.map_location;
                            model.text12 = "";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 2) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.eureka_house;
                            model.text1 = "If you're looking to explore an attraction that encapsulates Mauritius' rich colonial history, Eureka is the top choice. This meticulously preserved Creole mansion, constructed in the 1830s, now serves as a museum, offering a captivating journey back in time and unveiling the vibrant plantation history of the island. The main manor house stands as a tropical architectural marvel, renowned for maintaining a refreshingly cool interior during the scorching summers. With an impressive count of 109 doors and more rooms than a Cluedo board, it truly showcases exceptional craftsmanship.";
                            model.title1 = "";
                            model.image1 = R.drawable.eureka_house_3;
                            model.text2 = "Inside, rooms are adorned with a flawlessly conserved collection of period furniture imported by the French East India Company. Noteworthy items include antique maps, a peculiar shower contraption that was considered a luxury 150 years ago, and a weathered piano with keys resembling decaying teeth.";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.eureka_house_2;
                            model.text4 = "Venturing into the courtyard behind the main mansion reveals beautifully landscaped grounds encompassed by a series of stone cottages, formerly serving as servants' quarters and a kitchen. Following the trail at the back for 15 minutes leads to the picturesque Ravin waterfall.<br>" + "The estate earned its distinctive name when Eugène Le Clézio successfully secured the house through auction in 1856.<br>";
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
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 3) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.grand_bassin_1;
                            model.text1 = "Grand Bassin, also known as Ganga Talao, is located in the Savanne quiet mountain area. It's a crater lake about 550 meters above sea level. The first group of people to visit Ganga Talao was from the village of Triolet, led by Pandit Giri Gossayne in 1898. This place is sacred to Hindus in Mauritius.<br>" + "The Shiv Mandir is on the lake's bank and is dedicated to Shiva. During Shivaratri, around half a million Hindus in Mauritius go on a pilgrimage to the lake, with many walking barefoot from their homes carrying Kanvars.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.grand_bassin_2;
                            model.text2 = "The name Ganga Talao means \"Lake of Ganga,\" connecting it symbolically to the Indian river Ganga (Ganges).<br>" + "<b>History</b><br>" + "In 1866, Pandit Sanjibonlal returned to Mauritius from India after his first contract and turned Grand Bassin into a pilgrimage place. He converted a building into a temple and brought a Shivalingam from India. <br>" + "In 1897, Jhummon Giri Gosagne Napal, a priest, had a dream about the water of Grand Bassin being part of Ganga. The lake was then known as \"Pari Talao,\" and in 1998, it was declared a \"sacred lake.\" In 1972, Ganga water from the Ganges River was mixed with the lake water, and it was renamed Ganga Talao.<br>" + "<b>Events</b><br>" + "During Maha Shivaratri, devotees start a journey on foot to Grand Bassin, and volunteers offer food and drinks to the pilgrims. The lake hosts a 33-meter-tall statue of Shiva called Mangal Mahadev, inaugurated in 2007. Durga Pooja and Navaratri are celebrated grandly near the statue, and Shiva Ratri is a national holiday celebrated auspiciously by Hindus in Mauritius.<br>";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 4) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.gymkhana_2;
                            model.text1 = "Established in 1844 by the esteemed British Royal Navy, the Gymkhana Club is a testament to the history of golf, ranking as the fourth oldest golf course globally and a distinguished presence in the southern hemisphere. Although comparatively modest in size, this historic course in Vacoas, located at the heart of the island, presents a challenge to golf enthusiasts with its demand for precision and technical prowess.<br>" + "Adorned by century-old trees, the Gymkhana Club looks like a picturesque garden, boasting vibrant hues from bougainvilleas, Gabonese tulips, elms, arocarias, palm trees, and traveler's trees. This unique 18-hole haven is not merely a golf course; it encapsulates an unforgettable experience, steeped in a rich legacy.<br>" + "Acknowledging its historical significance, the Gymkhana Club takes pride in awarding every golfer a certificate, a testament to their participation in a course that has witnessed the sport since its inception in 1844. Despite its relatively compact footprint compared to other Mauritian golf courses, the Gymkhana Club's layout poses challenges that demand precision and skill.<br>" + "While traditionally accessible to Mauritian members, the Gymkhana Club now extends a gracious invitation to golf enthusiasts worldwide. Recognized as the most approachable of the 18 holes, it offers a nominal green fee for non-members and provides a temporary membership solution, ensuring a distinguished golfing experience for all.";
                            model.title1 = "";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 5) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.le_pouce_1;
                            model.text1 = "Le Pouce is the third highest mountain in Mauritius, soaring to an elevation of 812 meters (2664 feet). Only surpassed in height by Piton de la Petite Rivière Noire (828 m) and Pieter Both (820 m), this mountain derives its name from the distinctive, thumb-shaped apex that graces its summit. It is part of the Moka range which is a dome of basalt lava that is no longer experiencing volcanic activity.";
                            model.title1 = "";
                            model.image1 = R.drawable.le_pouce_2;
                            model.text2 = "This mountain was formerly known as the Mountain of Immortals, a name derived from a plant that persists on its slopes to this very day. Le Pouce Mountain promises an exquisite panorama encompassing Le Morne, Coin de Mire, the capital city, and various other locales strewn across the island. As you climb towards its summit, the mountain unfolds a tapestry of flourishing flora, unveiling exotic specimens and a collection of rare, uniquely indigenous species.It’s worth noting thaton the 2nd of May 1836, Charles Darwin ascended this majestic mountain.";
                            model.title2 = "Trails";
                            model.text3 = "";
                            model.image2 = R.drawable.le_pouce_3;
                            model.text4 = "There are two hiking trails to climb Le Pouce: one from the north side, starting in Port Louis, and the other from the south side, starting in Moka.<br>" + "The southern route, widely embraced by tourists and locals alike, follows a conventional path, starting at a higher elevation and covering less than half the distance of its northern counterpart. While the north route provides superior views, more shaded sections, and a more gradual ascent, it entails a significantly longer journey. <br>" + "<b>Southern Route</b><br>" + "Type of Trail: Out and Back/Through Hike<br>" + "Start Point: Moka Trailhead<br>" + "End Point: Summit<br>" + "Length: 1.4 miles one way<br>" + "Duration: 2 hours one way<br>" + "Lowest Point: 1514 feet<br>" + "Highest Point: 2587 feet<br>" + "Total Elevation Gain: 1165 feet<br>" + "Drive towards the foot of the mountain from Moka, turning off the main road where a Le Pouce sign directs you onto a meandering road through the sugarcane fields. Once you reach the foot of the mountain, proceed along the dirt road towards Le Pouce, following the well-trodden trail that zigzags up the mountainside. As you climb, you'll hike through an open, grassy expanse. Continue along any trail leading towards the summit.<br>" + "The final leg, where you climb \"the thumb,\" presents a relatively steep climb for both approaches, requiring some manual assistance in places. Caution is advised, especially in inclement weather.<br>" + "<b>Northern Route:</b><br>" + "Type of Trail: Out and Back/Through Hike<br>" + "Start Point: Trailhead in Tranquebar<br>" + "End Point: Summit<br>" + "Length: 3.9 miles one way<br>" + "Duration:6 hours one way<br>" + "Lowest Point: 273 feet<br>" + "Highest Point: 2656 feet<br>" + "Total Elevation Gain: 2690 feet<br>" + "Embark on the northern route from the trailhead where Chateau D’eau Street ends. Follow the primary road, gradually climbing toward Le Pouce. Blue and white markings on stones guide the way, ensuring navigation is straightforward. Stay left at various forks along the main road, passing temples and mango trees until you encounter a sign bank on your left. At this point, the trail turns left, narrows, and becomes steeper.<br>" + "The trail will eventually come to a more open, less steep area. Proceed down the main path. Do not follow the one notable fork to the left that crosses a stream. As you approach closer to Le Pouce, the route splits off again, but all of them lead to the summit and eventually converge.<br>" + "The last section, where you climb \"the thumb,\" presents a similar challenge for both routes, demanding manual assistance in certain sections and warranting caution during inclement weather.<br>";
                            model.title3 = "Practical Information";
                            model.text5 = "<b>What to bring: </b>bottled water, food, clothing and appropriate footwear, sunscreen, insect repellent, and a first aid kit<br>" + "<b>Other Tips:</b><br>" + "•\tCarry your trash with you. Avoid leaving trash behind.<br>" + "•\tDon't stray from the trails and don't split up with your group.<br>" + "•\tFor your own safety, avoid feeding untamed animals.<br>" + "•\tDon't harm other plants or trees.<br>";
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
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 6) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.pieter_both_1;
                            model.text1 = "The Pieter Both is one among the most well-known and iconic locations in Mauritius. Postcards from Mauritius frequently include images of its spectacular beauty. Thousands of nature enthusiasts go to the Pieter Both Mountain for its breathtaking views and hiking adventures.An interesting fact is that the palm species Hyophorbe amaricaulis, once a ubiquitous sight on this mountain, is now the world's rarest palmas of 2023 due to a decline in propagation.<br>" + "One of Mauritius' most recognizable mountains, the Pieter Both is visible from practically every south-west and central-northhighways.Itis the second highest mountain in Mauritius standing at 820 meters (2,690 feet). Shorter than Piton de la Petite Rivière Noire by eight meters, this mountain got its name from Pieter Both, the Governor-General of the Dutch East Indies. It is part of the Moka Range and distinguishes itself with a notable feature: a colossal rock formation crowning its summit, evoking the semblance of a human head.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.pieter_both_2;
                            model.text2 = "Indeed, there is a well-known local mythology associated with this rock. There are rumors that a milkman from Crève Coeur, a village at the base of the mountain, used to sell milk in La Laura and the neighboring communities. He decided one day to go to the next village by using the Pieter Both route shortcut. Feeling tired from his trek, he took a short break to rest. Soon he felt asleep only to be awaked later by the sound of a lovely music.His eyes opened to the sight of mesmerizing fairies singing and dancing. When the fairies realized they were being watched by a mortal, theycursedthe milkman he would turn into a stone if he ever told anyone about what he had seen. Still mesmerized by what he saw and overwhelmed by his experience, he forgot his oath and revealed his encounter with the fairies tohis friends.When themilkman came to the same spotthe following day, the fairies already knew the milkman had not kept the secret. Furious, the fairies transformed him into stone. Severed from his body, the milkman’s head grew larger and transposed onto the summit of the mountain. According to the legend, the milkman's head turned into rock is the one atop the mountain.<br>" + "Folklore aside, the Pieter Both is also well-known for its hiking trails. Hikers of all skill levels can tackle the mountain hike, which ranges from moderately tough to extremely challenging. It is advised that hikers, whether novice or expert, wear helmets, ropes, and harnesses. Guided hiking trips up the Pieter Both can also be arranged through these agencies.<br>" + "The starting point of your climbing journey is in the La Laura village at the base of a mountain. It takes roughly one hour to climb the first 600–650 meters. The climb is moderately demanding and appropriate for hikers with average physical and health conditions. <br>";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.pieter_both_3;
                            model.text4 = "If you're the daring type and want to try the unbatteredpath, carry on with the hike.  You will need goodrock-climbingtechniques to get to the mountain's neck. Although climbers still find assistance from the iron rungs set into the rock years ago by the Royal Navy and Special Mobile Force, it is safer to use ropes to climb your way up.<br>" + "Want a more adventurous and challenging route up to the mountain's summit? No problem, there is something available for the brave ones as well. All you will need is some confidence and efforts on your part to climb the nine-meter-diameter boulder. Be aware that climbing the boulder is the hardest part due to the upward steepness.<br>" + "If you choose to climb the mountain in the summer, bring with you water, a hat, sunglass, and sunscreen lotion. Exercise caution when hiking after a rainy day as the walkways become quite slippery.<br>" + "The palm species Hyophorbe amaricaulis, once a ubiquitous sight on this mountain, is now the world's rarest palmas of 2023 due to a decline in propagation.<br>";
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
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 7) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.tamarin_falls_1;
                            model.text1 = "The Tamarind Falls is a picturesque waterfalllocated in the southwestern region of Mauritius. Nestled along the Rivière Tamarin river near the village of Henrietta, these falls boast seven successive tiers of cascades.";
                            model.title1 = "";

                            model.image1 = R.drawable.tamarin_falls_2;
                            model.text2 = "<br>" + "The main waterfall of the Tamarind Falls has an impressive height of 293 meters (961 feet), making it one of the highest waterfalls on the island. Thanks to the lush and diverse flora surrounding the waterfall, the area is one of the most picturesque and serene places in Mauritius. Nature and animal lovers will be delighted to discovermany exotic plants and birds populating the area.<br>" + "Reaching the waterfalls can be a bit challenging though.Indeed, it takes nearly a full day of hiking to access this unspoiled natural marvel. The trail winds its way through the forest and includes a stretch across an open area on the basalt rockwhich is a clear sign you are in the vicinity of the Tamarind falls.<br>" + "Once you reach the waterfall, you can take a well-deserved break and cool off in the basin. Alternatively, you can continue onward to climb to the top of the falls. As you climb up, you will come across a series of small pools and when you reach the top of the waterfall you will be rewarded bythespectacularpanorama of the lush green canyon unfolding in front of your eyes.<br>";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 8) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.trou_aux_cerfs_4;
                            model.text1 = "The Trou aux Cerfs crater is surrounded by a vast expanse of lush forest home toindigenous plant species and some enormous green pine trees. It is thought to have erupted once and been inactive for the past 700 000 years, although scientists believe there may be a chance for it to erupt again.<br>" + "Undoubtedly, one of its main attractions is the panoramic 360-degree view encompassing the town of Curepipe, along with stunning views of Rempart Mountain, Trois Mamelles, and the PortLouis-Moka mountain range.<br>" + "This lush and green verdant sanctuary serves as a favored jogging locale for the locals. Evolving into a social gathering place, it regularly attracts joggers every at around five o’clock in the morning. A gazebo provides a pleasant spot to sit, relax, and appreciate the unparalleled natural beauty. Due to the surrounding woods and elevation, it can become slightly chilly, so it is advisable to bring along a light sweater or shawl.<br>" + "There are three primary access points to Trou aux Cerfs, specifically the La Hausse de la Louviere Road, the Edgar Huges Road, and the Crater Lane. Parking facilities are available.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        }
                        break;
                    case "South":
                        if (holder.getAdapterPosition() == 0) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.gris_gris_coastal_4;
                            model.text1 = "This enchanting havendistinguishes itself by the absence of a coral barrier reef, making it truly unique. The ocean waves vigorously crash against the shoreline, providing captivating vistas for visitors. Gris Gris beach stands in stark contrast to other tranquil and calm beaches in Mauritius, known for their coral reef protection. The island's typical coral reef barrier contributes to calmer ocean waves and shallow beach waters, creating ideal swimming conditions. However, Gris Gris, surprisingly, lacks this barrier reef.";

                            model.title1 = "";
                            model.image1 = R.drawable.gris_gris_3;
                            model.text2 = "A visit to Gris Gris is an absolute essential for anyone exploring Mauritius. The beach's beauty is awe-inspiring, with towering cliffs descending toward the ocean, where turbulent waves crash against rocks, creating a striking white froth accompanied by a resounding crash. Located at the southernmost point of of Mauritius, a few kilometers southeast of the village of Souillac, Gris Gris boasts a unique history dating back to the French colonial era.<br>" + "The name \"Gris Gris\" adds an intriguing dimension to the experience. Upon entering the beach, a large sign displays the history behind the name. According to local tradition, \"Gris Gris\" is linked to the African amulet known as the “Gris Gris” and its association with the tumultuous coastline. However, the story takes an unexpected turn, suggesting that Gris Gris might have been the name of a puppy belonging to a French cartographer who visited the coast in 1753.<br>";
                            model.title2 = "Gris Gris Beach";
                            model.text3 = "";
                            model.image2 = R.drawable.gris_gris_1;
                            model.text4 = "The primary beach area features an expansive green field with a commanding view of dramatic cliffs and enormous waves. There are benches and a pavilion available for relaxation while taking in the scenery.<br>" + "To the left, a concrete staircase descends to the beach, but swimming is strongly discouraged due to the high danger level. The powerful waves can swiftly overwhelm swimmers. Instead, enjoy a leisurely stroll along the beach, heading toward a small cave at the far end.<br>";
                            model.title3 = "Caves at Gris Gris";
                            model.text5 = "";
                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.grisgris_2;
                            model.text9 = "In addition to the cave on the far left side of the beach, two other hidden caves can be discovered at Gris Gris. These are more challenging to reach, involving a descent down a cliff and walking through the water.<br>" + "Caution is advised against going all the way down, as water levels can fluctuate unpredictably, and the current is often too strong.<br>" + "For those eager to explore the secret caves at Gris Gris, head towards the cliff's edge directly across from the parking lot. Upon reaching the spot, descend only about halfway to catch a glimpse of the caves on your right.<br>" + "It's important to bear in mind that entering the caves could pose risks if the water level rises!<br>" + "Gris Gris beach is intricately connected to the village of Souillac, which relies heavily on tourism for its revenue. Established 200 years ago as a port for ships sailing from Europe to India, Souillac has a rich history worth exploring. Plan your day strategically to make the most of your visit to the southern part of Mauritius, and consider including a visit to Rochester Falls, just outside the village, renowned for its distinctive rectangular-sided rocks.<br>";

                            model.title8 = "La Roche qui Pleure";
                            model.text10 = "";
                            model.image4 = R.drawable.la_roche_qui_pleure;
                            model.text11 = "This mystical site derives its name from the visual impression it creates: as water trickles down its walls, the cliffs appear to shed tears. Even more astonishing, some claim to recognize the eroded features of the Mauritian poet Robert Edward Hart.<br>" + "From a geographical and climatic standpoint, unlike other parts of the island, La Roche qui Pleure lacks coral reefs. Consequently, its shores are more exposed to the assaults of the ocean. This absence of a natural barrier results in more powerful and spectacular waves, a stark contrast to the tranquil lagoons typically associated with the island. The region is influenced by strong winds and seasonal variations, shaping its unique landscape and marine dynamics.<br>";
                            model.image5 = R.drawable.map_location;
                            model.text12 = "";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 1) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.rochester_falls_1;
                            model.text1 = "Although Rochester Falls may not rank as the most breathtaking waterfalls in the country, they are undeniably worth exploring if you find yourself nearby. Simply follow the makeshift signs guiding you from the main road through Souillac. The route, while a bit intricate, is reliable, albeit a tad rough along the stony track. Be prepared for local vendors who might expect a tip for assisting you in finding a parking spot. Following a brief five-minute walk from your vehicle, you'll arrive at the cascading waterfall emerging from the cane fields.<br>" + "Situated in the southern part of the island, within the Souillac district, Rochester Falls exemplifies the distinctive volcanic formations and the historical background of Mauritius as a volcanic island. What sets this waterfall apart is its unique appearance, with water flowing through rock formations that resemble square blocks, creating a captivating illusion unlike any other waterfall on the island.<br>" + "Popular among both locals and visitors, the falls offer a serene pond for swimming, tucked away in a lush, untamed forest, providing a peaceful escape from the hustle and bustle of civilization. This secluded setting makes it an ideal location for a day out with friends, emphasizing the appeal of nature's untouched beauty. <br>";

                            model.title1 = "A few tips";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "1.\tNot recommended to visit during or after heavy rainfall.<br>" + "2.\tExercise caution if engaging in cliff jumping, as surfaces may be slippery.<br>";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 2) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.bel_ombre_1;
                            model.text1 = "Bel Ombre is more than just a beautiful beach destination; it's a haven of untouched nature, where the air is filled with the melody of chirping birds and the surroundings boast lush greenery, majestic mountain views, and hidden waterfalls. The Bel Ombre Nature Reserve, protected by the Mauritian Wildlife Foundation, resembles a magical Garden of Eden, promoting sustainability and effective environmental management. The reserve, spanning 1,300 hectares in the Domaine de Bel Ombre, invites visitors to engage with nature through activities like quad biking, trekking, Segway tours, and 4x4 discovery tours.";
                            model.title1 = "";
                            model.image1 = R.drawable.bel_ombre_11;
                            model.text2 = "Nestled between the Indian Ocean's blue expanse and the emerald green endemic forests of the South, the Bel Ombre Nature Reserve is a treasure trove of Mauritian biodiversity. The mountainous landscape offers breathtaking views, plains where stags gracefully roam, impressive waterfalls, and unspoiled natural beauty. Various activities, including quad biking, 4x4 discovery tours, trekking, kids' tours, and Segway rides, provide opportunities to explore this enchanting reserve.<br>";
                            model.title2 = "";
                            model.text3 = "Highlights of the activities include:<br>" + "1.\t4x4 Excursion – A journey through the diverse flora and fauna, with a stop at the picturesque l'Example waterfall.<br>";
                            model.image2 = R.drawable.bel_ombre_6;
                            model.text4 = "2.\tQuad & Buggy – An adventurous exploration of the reserve's natural wonders, including a refreshing stop at a waterfall for a swim.";
                            model.title3 = "";
                            model.text5 = "3. xcb\tKids Discovery Tour – Specially designed for young adventurers, featuring a drive through sugarcane fields and a freshwater fishing trip.<br>" + "4.\tTrekking Exploration – A nature walk starting at the Old Chimney, leading through the river reserve to a waterfall with a natural rock pool for a refreshing dip.<br>";
                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.bel_ombre_12;
                            model.text9 = "5.\tSegway Ride – An easy exploration of the Domaine's magnificent scenery during a 45-minute ride, covering key landmarks.<br>" + "The Segway ride's itinerary includes the welcome center of Frederica, Heritage Golf Club, C Beach Club, Heritage Le Telfair Golf and Spa Resort, Place du Moulin, Le Château de Bel Ombre, and back to the welcome center.<br>";
                            model.title8 = "";
                            model.text10 = "";
                            model.image4 = R.drawable.map_location;
                            model.text11 = "";
                            model.image5 = R.drawable.map_location;
                            model.text12 = "";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 3) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.valle_des_couleurs;
                            model.text1 = "The southern region of Mauritius is adorned by the 450-acre natural reserve known as La Vallée Des Couleurs. It is a picturesque haven, allowing visitors to escape the worries of the world and immerse themselves in the refreshing air amidst extraordinary views of nature. Located in Mare Anguilles, Chamouny, the reserve is open every day from 9 am to 5:30 pm.<br>" + "La Vallée des Couleurs offers a myriad of exciting activities, creating a memorable experience for all. Explore the charming animal farm, savor delicious cuisines while surrounded by grazing deer and a waterfall, and partake in activities such as trekking, luge karting, Nepalese bridge rides, quad bike tours, ziplining, and witness the mesmerizing 23-colored earth.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.valle_des_couleurs_2;
                            model.text2 = "The park offers panoramic views of the sea amid lovely greenery. Notable activities and attractions include trekking, mountain luge karting, Nepalese bridge walks, ziplining, quad biking, and visits to the animal farm and restaurants.<br>" + "La Vallée des Couleurs is designed for both adventure seekers and those seeking tranquility. Major attractions are within a 15-minute walk, and additional options include buggy or quad bike rides for a quick park exploration. The highlight is the 23-colored earth visible during the quad bike ride.<br>";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.valle_des_couleurs_17;
                            model.text4 = "The park engages all senses, from the visual delight of the iconic 23-colored land to the sounds of birds and waterfalls, the fragrance of wet tree trunks, the taste of delicious cuisine, and the unique experience of ziplining. Trekking through the park provides a two-hour journey with thrilling activities and breathtaking views, culminating at a waterfall.";
                            model.title3 = "";
                            model.text5 = "";
                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.valle_des_couleurs_5;
                            model.text9 = "Mountain luge karting offers a thrilling experience on a 700m track, while the Nepalese Bridge, a 350m footbridge, provides an adrenaline rush with panoramic views. Ziplining features seven lines, including the longest one stretching over 1.5 km, offering a bird's-eye view of the park.";
                            model.title8 = "";
                            model.text10 = "";
                            model.image4 = R.drawable.valle_des_couleurs_12;
                            model.text11 = "<br>" + "Quad biking and buggy rides delve into the tropical forest, interacting with wildlife and reaching the 23-colored land, rich in minerals from volcanic eruptions. The park also houses an animal farm with tortoises, chickens, and deer.<br>";
                            model.image5 = R.drawable.vallee_des_couleurs_1;
                            model.text12 = "Various eateries serve delectable cuisine around the waterfalls, including an Indian restaurant providing Subcontinent and French cuisines. La Vallée des Couleurs ensures a captivating experience for visitors of all ages, combining adventure, wildlife, and natural beauty.";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 4) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.blue_bay;
                            model.text1 = "Located in the southeast of the island, Blue Bay was designated a national park in 1997 and later recognized as a wetland site under the Ramsar Convention on Wetlands of International Importance in 2008. The marine park is renowned for its coral garden, housing a diverse array of corals and abundant fauna. Close to the coastline, it offers ideal conditions for snorkeling, boasting rich biodiversity and calm, shallow seawater.";
                            model.title1 = "";
                            model.image1 = R.drawable.blue_bay_4;
                            model.text2 = "Upon setting foot on Blue Bay beach, you will bump intohawkers selling artisanal jewelry and canvassers promoting glass-bottom boat trips or snorkeling outings. Over fifteen operators are permitted to engage in commercial activities within the Blue Bay Marine Park.";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.blue_bay_2;
                            model.text4 = "<br>" + "The main attraction in the Marine Park is a more than 1,000-year-old brain coral with a 5-meter diameter, making it the region's primary tourist attraction. The coral garden near Mahebourg, a small coastal village in the south-east, boasts a remarkable surface area and biodiversity. Visitors often come to witness the ancient brain coral, and various activities, such as glass-bottom boat trips, offer different perspectives of the vibrant marine life.<br>" + "Most operators in Blue Bay Marine Park are descendants of local fishermen turned to tourism. Glass-bottom boat trips are accessible to all, providing a serene experience to explore the beauty of the park. Those seeking a closer encounter can embark on a boat and snorkel, enjoying the vibrant underwater life in warm and clear waters.<br>" + "The Marine Park covers 353 hectares and is a popular leisure area for tourists and locals, sustaining numerous households through various activities. Measures have been implemented to balance economic activity with sustainable development, including the installation of permanent mooring buoys to demarcate conservation areas and regulated zones for fishing, boat traffic, swimming, and waterskiing. These measures aim to protect the marine fauna and flora, preserve biodiversity, promote scientific research, and educate the public.<br>";
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
                            model.text11 = "•\t<b>Unique Classification in Mauritius:</b> Designated a Marine Park under the Wildlife and National Parks Act 1993, a protected zone in 2000 under the Fisheries and Marine Act 1998 and recognized as a Ramsar Convention site in 2008. Mooring buoys are strategically placed to minimize damage to corals by boat anchors";
                            model.image5 = R.drawable.blue_bay_8;
                            model.text12 = "•\t<b>Outdoor Activities Available to All:</b> Glass-bottom boat trips and snorkeling are popular activities, allowing non-swimmers to explore the marine environment through the glass bottom. Snorkeling conditions are ideal, and Coco Island, visible from the beach, serves as a relaxing spot for snorkelers under casuarina trees. Operators provide drop-off and pick-up services.";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 5) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.mahebourg;
                            model.text1 = "Nestled in the heart of the traditional Mauritian Village, the newly developed Mahebourg Waterfront offers an idyllic setting for a leisurely stroll and a captivating journey into local Mauritian history. Take the opportunity to explore the naval museum and delve into the details of the epic battle that unfolded in this region. The Bataille de le Passe memorial stands as a poignant tribute to the brave fighters who sacrificed their lives in that historic battle.";
                            model.title1 = "";
                            model.image1 = R.drawable.mahebourg_5;
                            model.text2 = "Conveniently situated behind the bus station, the iconic Sir Gaetan Duval Esplanade is a prominent feature of the Mahebourg Waterfront. This locale is perfect for enthusiasts of seaside walks, offering an enchanting experience amidst the beauty of nature and breathtaking sea views.";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.mahebourg_waterfront_1;
                            model.text4 = "Immerse yourself in the rich history of the Grand Port battle, a pivotal event that has left an indelible mark on our heritage. Don't overlook the captivating sight of the 'Mouchoir Rouge' island at the quay's end – a truly mesmerizing view.";
                            model.title3 = "";
                            model.text5 = "";
                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.mahebourg_3;
                            model.text9 = "Facing the Mahebourg Waterfront is the bustling local market of Mahebourg, a vibrant hub filled with delectable street food, local treats, and fresh vegetables. Take a detour to indulge in some essential shopping. While the Mahebourg Waterfront is a popular weekend destination for locals, attracting picnickers and those seeking casual relaxation, we recommend visiting during the week to avoid the crowds.";
                            model.title8 = "";
                            model.text10 = "";
                            model.image4 = R.drawable.map_location;
                            model.text11 = "";
                            model.image5 = R.drawable.map_location;
                            model.text12 = "";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 6) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.mahebourg_museum_2;
                            model.text1 = "Nestled in the enchanting Southeast of Mauritius, the National History Museum in Mahebourg is a captivating attraction. Imagine encountering the rare and nearly complete skeleton of the dodo, along with naval artifacts and posters vividly illustrating life during colonial times. Housed in a vintage 'old world' mansion, this museum is not only charming but is also designated as a National Heritage Site.<br>" + "Known as Gheude Castle, this charming residence was constructed at the close of the 18th century and originally belonged to the de Robillard family. Mr. Jean de Robillard, the district commander of Grand Port, was its first owner. Over the years, the house was inhabited by various significant French settlers before being acquired by the Mauritius government in 1947. The transformation of this colonial mansion into a Naval and Historical Museum culminated in the inauguration of the Dutch Section by the descendant of Maurits Van Nassau, after whom Mauritius was named in 1598.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.mahebourg_museum_5;
                            model.text2 = "Within the 12-acre garden surrounding the museum, visitors are treated to a reproduction of quaint village houses. The museum's collection includes salvaged items from naval battles, a rare dodo skeleton, maps, old coins, and furniture. Explore the weaponry used by the corsair Robert Surcouf and marvel at the bell retrieved from the wreck of the Saint Geran, which sank off the East coast in the 18th century.";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.mahebourg_6;
                            model.text4 = "The cannon displayed in front of the museum originates from the British frigate named La Magicienne and faces the entrance from the main road leading to the village of Mahebourg. As you ascend to the first floor, discover a four-poster bed that once belonged to Mahe de Labourdonnais, the first French governor of Mauritius. The museum also showcases palanquins carried by slaves, highlighting a regal era.";
                            model.title3 = "";
                            model.text5 = "";
                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.mahebourg_museum_4;
                            model.text9 = "A remarkable historical note reveals that during a naval battle in August 1810 at nearby Vieux Grand Port, both the British and French commanders, Sir Nesbit Willoughby and Baron Victor Duperre, were injured and cared for in the same wing of the maritime museum. This battle is notably the only naval victory for the French, commemorated at the Arc de Triomphe in Paris.<br>" + "Located off the main road, a mere 10-minute drive from the airport, the Mahebourg Naval Museum can be visited from Monday to Saturday, 09:00 to 16:00, and on Sundays from 09:00 to 12:00. Admission is free, making it a must-visit destination in the Southeast. Please note that interior photography is prohibited, ensuring an immersive experience during your visit to this delightful museum.<br>";
                            model.title8 = "";
                            model.text10 = "";
                            model.image4 = R.drawable.map_location;
                            model.text11 = "";
                            model.image5 = R.drawable.map_location;
                            model.text12 = "";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 7) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.ile_aux_fouquets;
                            model.text1 = "Île aux Fouquets, also known as Île au Phare or Lighthouse Island, is located off the southeastern shoreline of Mauritius.\n" +
                                    "This coral-origin island has held the status of Islet National Park since June 5, 2004. Located approximately five kilometers off the southeastern coast, near Ilot Vacoas and Île de la Passe, it lies south of the islands, marking the sole opening in the coral reef through which larger vessels can navigate. Occupying an area of 2.49 hectares, Île aux Fouquets derived its name from a species of tern known as \"fouquet,\" named by local fishermen, as documented by the German zoologist Karl August Möbius.\n" +
                                    "Around 1694, a group of Huguenot refugees, led by the Frenchman François Leguat, resided on Île aux Fouquets for several years. Previously attempting to establish a Protestant republic called Eden on Rodrigues Island, 580 kilometers to the east, they abandoned the project due to loneliness and sailed to Mauritius on a self-constructed barge without anchor or compass. Despite safely reaching Mauritius, they found themselves in conflict with the Dutch governor, resulting in their exile to the treeless Île aux Fouquets. Only years later were they transported from there to the island of Java.\n" +
                                    "In 1810, near Île aux Fouquets, the naval Battle of Grand Port occurred, resulting in a French victory. Over fifty years later, well after the British had conquered Mauritius, a lighthouse was erected on the island in 1864. While the structure is now a ruin, it holds the designation of a listed building. Île aux Fouquets provides panoramic views of neighboring islands, the coastline, and the prominent Lion Mountain.";
                            model.title1 = "Ile aux Fouqets Lighthouse";
                            model.image1 = R.drawable.ile_aux_fouqets_3;
                            model.text2 = "Erected in 1864, this lighthouse served as a guide for ships navigating towards the Mahébourg harbor. Initially, Mahébourg was the primary French settlement and retained its significance as a crucial port until the early 20th century. During this period, the British shifted all port activities to Port Louis on the opposite side of the island. Consequently, as port operations relocated, the light station was left abandoned and gradually fell into a state of disrepair.\n" +
                                    "Located alongside Ile de la Passe and Ile aux Vacoas, Ile aux Fouquets, also known as Ile aux Phare, constitutes the second island in the chain. Unlike its counterparts, this island features relatively hilly terrain, crowned by the remnants of the lighthouse from which it draws its name.\n" +
                                    "Regrettably, efforts to restore this lighthouse have not been undertaken, and the metallic components of its once-shining orb are now scattered across its vicinity. Despite its dilapidated state, the ruins offer shade from the sun and shelter from the wind, making Ile aux Phare a preferred picnic spot for local residents and fishermen. Behind the lighthouse, on the steep incline, a colony of tropical birds has made its nesting grounds.\n" +
                                    "Accessible solely by boat, the islets offer a distant view from the mainland. \n";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 8) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.ile_aux_aigrettes_1;
                            model.text1 = "Located off the southeastern coast of Mauritius, Ile aux Aigrettes serves as both a nature reserve and a scientific research station, drawing visitors that include both tourists and Mauritians.<br>" + "Geographically, it spans 27 hectares (67 acres) and is the largest islet in the Grand Port bay, situated 850 meters (2,790 ft) from the southeast coast of Mauritius and approximately a kilometer (0.62 mi) from the coastal town of Mahebourg. Characterized by its low-lying terrain, the islet is composed of coral-limestone, in contrast to the volcanic rock predominant in the majority of Mauritius.<br>" + "<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.ile_aux_aigrettes_4;
                            model.text2 = "Functioning as a nature reserve and conservation area, Ile aux Aigrettes safeguards the world's sole remaining fragment of the \"Mauritius Dry Coastal Forest,\" once a flourishing vegetation type. Consequently, it hosts a significant population of highly rare or endangered plant and animal species.";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.pink_pigeon;
                            model.text4 = "Historically, extensive logging and invasive species decimated indigenous flora and fauna over several centuries, mirroring the plight of the rest of Mauritius. The extinction of the Dodo and the native giant tortoise, along with numerous plant species, was a shared fate. Despite these challenges, remnants of certain species endured. In 1965, the islet earned designation as a nature reserve, prompting dedicated efforts to restore vegetation and preserve the remaining indigenous animal species. Furthermore, various species, previously absent from the island but surviving elsewhere in Mauritius, were reintroduced.";
                            model.title3 = "";
                            model.text5 = "";
                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.ile_aux_aigrettes_3;
                            model.text9 = "<br>" + "Reptile species on the islet include the Telfairs Skink, a large and slow-moving reptile, various ornately colored day geckos, and a population of non-indigenous Aldabra giant tortoises. Introduced to Île aux Aigrettes, these giant tortoises play a vital ecological role, replicating the function of the extinct Mauritian tortoises by consuming and dispersing plant seeds, facilitating natural forest rejuvenation.<br>";
                            model.title8 = "";
                            model.text10 = "";
                            model.image4 = R.drawable.map_location;
                            model.text11 = "The rare and endemic ebony tree species, Diospyros egrettarum, derives its name from this island, where it thrives abundantly.";
                            model.image5 = R.drawable.map_location;
                            model.text12 = "";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        }


                        break;
                    case "East":
                        if (holder.getAdapterPosition() == 0) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.ferney_1;
                            model.text1 = "Located in the Bambou mountains north of Mahébourg in Grand Port District, La Vallée de Ferney, is a forest and wildlife reserve managed by the La Vallée de Ferney Conservation Trust. Established in 2006, the 200-hectare natural area serves as a conservation trust in collaboration with the Mauritian Wildlife Foundation (MWF) and local authorities, focusing on the restoration of indigenous forests.";
                            model.title1 = "";
                            model.image1 = R.drawable.ferney_3;
                            model.text2 = "The valley gained attention in 2004 when a proposed highway threatened the local flora and fauna. Surveys revealed new and presumed extinct species, leading to successful local action diverting the highway. Situated north of Mahébourg, La Vallée de Ferney boasts Tertiary volcanic soils and a humid climate, making it one of the last nature refuges on the island.";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.ferney_4;
                            model.text4 = "The reserve offers hiking circuits through indigenous forests, guided tours, a stone museum depicting the area's history, gardens with useful plants, a restaurant, and a visitor’s complex. Giant tortoises and a nursery for endemic plants are also present. The biodiversity of La Vallée de Ferney includes endangered plant species and protected animals like the Mauritius kestrel and Mauritian flying fox.";
                            model.title3 = "";
                            model.text5 = "";
                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.ferney_conservation_park_1;
                            model.text9 = "With less than 2% of Mauritius' indigenous ecosystems intact, future projects at La Vallée de Ferney focus on large-scale propagation of indigenous plants, weeding out invasive species, and reintroducing endangered birds like the pink pigeon and echo parakeet. The reserve collaborates with la Vallée de l'Est, another conservation area, to protect an additional 70 hectares of rare highland forest.";
                            model.title8 = "";
                            model.text10 = "";
                            model.image4 = R.drawable.map_location;
                            model.text11 = "";
                            model.image5 = R.drawable.map_location;
                            model.text12 = "";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 1) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.frederik_hendrik_museum_1;
                            model.text1 = "The Vieux Grand Port Heritage site is on the South East coast, about 4km North of Mahebourg/Pointe d’Esny. The Dutch picked this spot at the foot of Lion Mountain, 7 meters above sea level, with a great view of the bay.";
                            model.title1 = "";
                            model.image1 = R.drawable.frederik_hendrik_museum_5;
                            model.text2 = "Here are some interesting facts about the Old Grand Port Heritage Site:<br>" + "•\tIt has the first Dutch East India Company 'VOC' fort in the eastern hemisphere.<br>" + "•\tIt's the initial Dutch Fort built to defend against the sea.<br>" + "•\tIt experienced the first slave rebellion, where slaves set fire to the wooden fort.<br>" + "•\tSlaves influenced the architecture, leading to forts being built with stones for safety.<br>" + "In 1658, Dutch commander Cornelius Gooyer and his crew of 25 men built a small wooden fort shaped like a four-pointed star. Life was tough in Mauritius, with frequent attacks and fires by slaves, cyclones damaging the fort, and crops eaten by rodents. In 1694, one fire destroyed the fort, so the Dutch built a stone fort a few years later.<br>";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.frederik_hendrik_museum_4;
                            model.text4 = "The Dutch left Mauritius in 1710, destroying the site before leaving, with only the stone lodge left standing. You can still see the stone jetty below the fort in the lagoon.<br>" + "Later, the French settled in Mauritius and used the stone lodge as their administration center. They turned the site into a military outpost to protect Vieux Grand Port Bay. In 1806, the outpost moved to the newly built town of Mahebourg.<br>" + "Remnants of the powder/storehouse, prison, bakery, and workshop from the French period are on top of the Dutch ruins.<br>" + "In 1998, the Old Grand Port Heritage site was renovated to celebrate the 400th anniversary of the first Dutch landing in Mauritius. The site was inaugurated by the descendant of Maurits van Nassau, after whom Mauritius was named.<br>" + "The Frederik Hendrik Museum was built alongside the fort and opened in 1999. It houses memorabilia found during archaeological excavations, with a permanent exhibition in the main hall displaying old maps, military objects, potteries, cooking utensils, beads, coins, and more.<br>";
                            model.title3 = "";
                            model.text5 = "";
                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.frederik_hendrik_museum_2;
                            model.text9 = "On your way to the cultural site, check out the monument commemorating the first Dutch landing on 20th September 1598. The sailors were led by Admiral Wybrand Warwick, and you can see the Lion Mountain on the left.<br>" + "Address: The Old Grand Port Heritage site is on the South East coast, a 15-minute drive from the airport, and 4 km North of Mahebourg/Pointe d’Esny.<br>" + "The Frederik Hendrik Museum: Royal Road Old Grand Port Mauritius<br>" + "Visiting hours: <br>" + "Monday, Tuesday, Thursday, Friday, Saturday: 09h00 to 16h00 <br>" + "Wednesday: 11h00 to 16h00 <br>" + "Sunday: 09h00 to 12h00 <br>" + "The cultural heritage site is closed on public holidays.<br>" + "The entrance is free.<br>" + "Nearby attractions include Ile aux Aigrettes Nature Reserve, where you can explore Mauritius before the arrival of humans, and the historical Mahebourg Museum building. These are three must-do activities when you are in the Grand Port area.<br>";
                            model.title8 = "";
                            model.text10 = "";
                            model.image4 = R.drawable.map_location;
                            model.text11 = "";
                            model.image5 = R.drawable.map_location;
                            model.text12 = "";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 2) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.belle_mare_1;
                            model.text1 = "The Belle Mare Beach is located near the town of Mahebourg on the Southeast coast of Mauritius, spanning between the villages Belle Mare and Pointe de Flacq. Sheltered from the big waves by the coral reef, this crescent-shaped beach has a parking area and a shaded rest area under the filaos trees. It is quite wide with parts of fine, dazzling white sand. The water is transparent and calm, and the lagoon has a most magnificent turquoise blue color. In this realm, unspoiled nature prevails, with minimal development except for a few scatteringhotels and exclusive villas.";
                            model.title1 = "";
                            model.image1 = R.drawable.belle_mare_3;
                            model.text2 = "Renowned among holidaymakers as the epitome of beauty, the Belle Mare Beach is cherished not only by visitors but also by the island's residents who frequent the beach, particularly on weekends and holidays. This enclave retains an authentic charm, preserving the island's essence amidst the rapid development witnessed by other coastal cities, notably Grand Bay, Flic en Flac, and Black River.<br>" + "The Belle Mare Beach is an idyllic destination for swimming and diving, particularly on weekdays when the serene ambiance prevails. It offers an ideal retreat for nature enthusiasts, allowing them to relish miles of sandy expanse for sunbathing.<br>" + "The optimal times to visit the Belle Mare Beach are during the early morning hours from 7:00 to 11:00 or in the afternoon from 13:00 to 17:00.<br>" + "Engage in an array of activities at Belle Mare Beach, including pedalo rides, windsurfing, catamaran journeys, horseback riding, parasailing, scuba diving, speed boat excursions, and kayaking.<br>";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 3) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.poste_lafayette_1;
                            model.text1 = "This unspoiled beach, often overlooked due to its turbulent sea, offers a rare opportunity to embrace tranquility and serenity. With its authentically rustic and untouched nature, this charming locale continually captivates nature enthusiasts. The preserved green habitat is a sanctuary for massive coral reefs, fostering rich marine biodiversity and mangroves.";
                            model.title1 = "";
                            model.image1 = R.drawable.poste_lafayette_2;
                            model.text2 = "Those seeking a peaceful picnic will be pleased that the southern part of the beach provides a serene retreat. Additionally, the southern beach serves as an ideal starting point for a trek leading north of Poste Lafayette, offering picturesque green landscapes along the rocky trail.";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.poste_lafayette_3;
                            model.text4 = "Picnicking in the shelter of the trees is a delightful option in certain areas where the sea displays stormy waves due to the proximity of the reefs to the lagoons. Enthusiasts of kite surfing and windsurfing will find this place ideal since Poste Lafayette is consistently exposed to the trade winds throughout the year. ";
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
                            model.text9 = "While the sea may be too challenging for a Sunday swim, the shore or shallow waters provide opportunities for sunbathing while children can revel in building sandcastles.<br>" + "The eastern coast boasts prominent hotels and restaurants, including establishments like Jalsa Beach Hotel & Spa, Radisson Blu Poste Lafayette Resort & Spa, and the esteemed Hôtel Constance Le Prince Maurice. <br>" + "To cater to the discerning tourist, gourmet restaurants have thrived alongside small traditional eateries. La Maison D’Été, specializing in Italian cuisine with seafood and fish menus, is a must-visit in Poste Lafayette. Another favored dining spot, Seabell, offers a menu featuring typical Mauritian dishes, complemented by a nearby mini market owned by the Seabell owners.<br>";
                            model.title8 = "";
                            model.text10 = "";
                            model.image4 = R.drawable.map_location;
                            model.text11 = "";
                            model.image5 = R.drawable.map_location;
                            model.text12 = "";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 4) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.roche_noire_2;
                            model.text1 = "Ranked among the top 10 beaches in Mauritius, the Roche Noire Beachis located just a few kilometers from Poste Lafayette on the northeast coast of the island. The beach has a stunning landscape characterized by black lava rocks and a dark sea, where gentle waves crash onto the nearby coral reef. The pristine sand and the spectacular views of sunrise and sunset contribute to making Roche Noire Beach an unparalleled destination. The winds throughout the year provide a refreshing breeze, especially during the hot summer months. It is one of the most photographed beaches according to tourist reviews.";
                            model.title1 = "";
                            model.image1 = R.drawable.roche_noire_3;
                            model.text2 = "<br>" + "The Roche Noire Beach is a true paradise for those who love water activities and appreciate nature. Guests can partake in a range of aquatic adventures, including swimming, snorkeling, and kayaking, allowing them to discover the diverse marine life and colorful coral reefs. Furthermore, the tranquil ambiance of the beach creates an ideal setting for a leisurely walk or a peaceful sunbathing experience. <br>" + "Parking facilities are commonly accessible in the vicinity of the Roche Noire Beach, offering travelers a choice between free and paid parking options for easy access to the beach. Interesting fact about the Roche Noire Beach – the beach is famed for its breathtaking volcanic rock formations along the coastline, enhancing the natural beauty of the surroundings with a unique touch.<br>";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 5) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.ile_aux_cerfs_mauritius_1;
                            model.text1 = "On the eastern coast of Mauritius, just south of Trou d’Eau Douce, lies a pair of islands known collectively as Ile aux Cerfs. Ile aux Cerfs is a genuine paradise spanning 87 hectares. It is particularly appealing to water sports enthusiasts andis one of the most stunning beaches in Mauritius.";
                            model.title1 = "What to Explore and Experience on Ile aux Cerfs";
                            model.image1 = R.drawable.ile_aux_cerfs_7;
                            model.text2 = "The island is celebrated for its picturesque turquoise lagoon, perfectly suited for an extensive array of water sports. Among the activities available, whether undertaken solo or with a companion, is parasailing—an endeavor worth adding to your bucket list, particularly for the breathtaking vistas of the lagoon.<br>" + "Other activities include speedboat rides, water skiing, and paddleboarding. Snorkeling is also an option, although, you'll need to take a boat to a location where there is coral as the water near the beach is shallow and consists predominantly of sand.<br>";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.ile_aux_cerfs_5_1;
                            model.text4 = "While many visitors come to the Ile aux Cerfs for leisurely water activities, true sun worshippers find their sanctuary here, especially given the limited shelter on the beach. The overarching advice is to liberally apply sunscreen, preferably opting for products that are environmentally friendly. <br>" + "It's worth noting that most visitors tend to remain in close proximity to the pier, where the shuttle from Pointe Maurice drops them off. If you wish to evade the crowds, particularly on weekends, consider strolling a bit farther along the coast. Numerous other nearby beaches offer equally tranquil surroundings.<br>";
                            model.title3 = "How to Reach Ile aux Cerfs ";
                            model.text5 = "";
                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.ile_aux_cerfs_7;
                            model.text9 = "Access to the island is granted to the public from 9:00 a.m. to 6:00 p.m. Starting from the village of Trou-d’Eau Douce, a shuttle embarks every half hour from the pier at Pointe Maurice to the Masala pier on Ile aux Cerfs, at 9:30 a.m.<br>" + "An alternative approach is by catamaran, with numerous providers offering scenic journeys to the island, sometimes incorporating detours to or from the waterfalls in the nature reserve of Grande Rivière Sud Est.<br>";
                            model.title8 = "Optimal Time to Explore the Island ";
                            model.text10 = "";
                            model.image4 = R.drawable.ile_aux_cerfs_6;
                            model.text11 = "The island tends to attract a considerable influx of day trippers during weekends. If your stay in Mauritius extends to at least a week, it is advisable to plan your visit on a weekday. While October and November are considered the prime months to experience Ile aux Cerfs, the period from June to November also offers a delightful visit.<br>" + "<b>Accommodation</b> <br>" + "Noteworthy among the accommodations on Ile aux Cerfs is the opulent 5-star Shangri-La’s Le Touessrok Resort & Spa. While not budget-friendly, it provides an exceptional setting for grand celebrations. <br>" + "<b>Culinary Offerings</b> <br>";
                            model.image5 = R.drawable.ile_aux_cerfs_3;
                            model.text12 = "Ile aux Cerfs has several dining establishments, including a charming beachside restaurant. Additionally, two bars are available for visitors seeking refreshing beverages or cocktails at reasonable prices. An alternative is to bring ample food and drinks to suit your preferences.";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        }
                        break;
                    case "West":

                        if (holder.getAdapterPosition() == 0) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.albion_lighthouse;
                            model.text1 = "Standing proudly on the cliff's edge, overseeing the expanse of the sea, the Cave Point lighthouse stands as a beacon guiding incoming ships into the harbor of Port Louis. Adorned with distinctive red and white stripes running from top to bottom, this iconic lighthouse was inaugurated in 1910 and remains impeccably preserved. To reach the lighthouse's summit, one must ascend a 98-step staircase crafted from wood and cast iron.<br>" + "<br>" + "The reason you would want to make the climb is that the summit offers breathtaking panoramic views of the entire coastline, stretching from Pointe aux Sables to Flic en Flac. For those who are afraid of heights, a stroll along the trail leading to the lighthouse still presents awe-inspiring vistas of the shoreline. Taking a moment to pause, closing your eyes, and immersing yourself in the melodic sounds of waves crashing against the cliffs adds another layer to the experience.<br>" + "<br>" + "Beyond being a hot spot for photographers capturing stunning backdrops, the area beneath the cliffs harbors the entrance to a cave populated by birds and bats. Brave cliff divers often scale the rocks beneath the cliffs, executing impressive jumps into the sea. Additionally, you can witness fishermen engaged in their craft. As the day draws to a close, the sunset unfolds, treating observers to a mesmerizing fusion of colors in the sky, sun, and sea.<br>" + "<br>" + "It's advisable to avoid visiting the Albion Lighthouse on windy days.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 1) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.flic_en_flac_3;
                            model.text1 = "Located on the west coast of Mauritius, Flic en Flachas emerged as the second most popular tourist area in the country, following Grand Baie.<br>" + "Unlike the faster-paced development in the north, the west coast, including beautiful villages like Flic en Flac, has transformed from small fishing communities into charming towns, earning a reputation as a premier holiday destination.<br>" + "Over the past two centuries, Flic en Flac has evolved from a humble fishing village into a prominent tourist hub. Today, it stands as a sought-after destination, attracting both international tourists and local Mauritians.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.flic_en_flac_1;
                            model.text2 = "Flic en Flac offers an ideal holiday experience with its excellent beaches, a variety of watersports, and a tranquil ambiance for complete relaxation. The location boasts a delightful setting with pristine white sand beaches and picturesque blue lagoons. Along the extensive 8 km beach, numerous restaurants, hotels, shops, and facilities cater to visitors.<br>" + "The beach provides a perfect backdrop for activities such as afternoon strolls, watersports, sunbathing, or simply unwinding. It's an excellent spot for picnics, shaded by trees scattered along the coastline.<br>" + "Flic en Flac's beach, adorned with Casuarina Trees, features a fine lagoon protected by a reef, ensuring safe swimming and opportunities for various watersports.<br>" + "Flic-en-Flac buzzes with activity throughout the day and night, offering a dynamic atmosphere for visitors. In the daytime, guests can indulge in delectable street food options such as the \"DhalPuri,\" a thin, multi-layered flatbread crafted from flour, yellow split peas, salt, and water, filled with flavorful curry and sauces. Another popular local dish is fried noodles paired with Mauritian meatballs, enjoyed by both locals and visitors. However, it's crucial for those unfamiliar with the local water and cuisine to exercise extreme caution to prevent any potential food-related illnesses or stomach discomfort.<br>" + "During the weekends, the beach becomes a vibrant hub for locals spending quality time with family and friends. Entertainment unfolds as some locals engage in singing and dancing to the rhythmic beats of Sega music, typically played with guitars and \"ravannes\" — a percussion instrument resembling the \"Bodhrán\" but played with distinctive techniques using hands.<br>" + "The nightlife in Flic-en-Flac is lively, attracting both locals and tourists to nightclubs and restaurants, fostering a lively atmosphere for socializing. Despite its diverse offerings, it's important to note that the otherwise beautiful white sandy beach does contain a considerable amount of corals and sea urchins.<br>";
                            model.title2 = "Flic en Flac - Location";
                            model.text3 = "Situated in the Black River district on the island's western coast, approximately 15 km south of the capital, Port Louis, Flic en Flac lies between the villages of Albion to the north and Tamarin and Black River to the south. The west coastline, lined with hotels and villas providing direct beach access, characterizes Flic en Flac. The drive to Port Louis takes around 30 minutes, while reaching the airport takes approximately 1 hour.<br>" + "Flic en Flac benefits from a well-established bus route, facilitating easy transportation to key locations across Mauritius. Buses connect to Port Louis and other cities like Quatre Bornes and Curepipe, offering convenient access to various parts of the island.<br>";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 2) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.casela;
                            model.text1 = "Casela World of Adventures, acclaimed as the most visited attraction in Mauritius, is a picturesque nature park nestled amidst sugarcane fields in the western part of the island, framed by the Rempart Mountain.";
                            model.title1 = "Casela World of Adventures";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "This nature park boasts an extensive range of activities and enjoyable experiences. Adventurous individuals can engage in thrilling pursuits such as ziplining, quad biking trails, canyoning, and more. Families looking for a fun time can explore the impressive African safari, featuring big cats, monkeys, giraffes, rhinos, impalas, and zebras.";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.botanical_garden_5;
                            model.text4 = "";
                            model.title3 = "Thrilling Activities at Casela World of Adventures";
                            model.text5 = "Customize your Casela experience by choosing from a variety of activities, including quad biking, mountain climbing, interactions with cheetahs and lions, camel riding, zip-lining, and the exhilarating Canyon Swing. The Park offers four thematic worlds:<br>" + "1.\t<b>Mountain Kingdom:</b> Features various activities like Zig Zag Racer, Canyon Swing, and Zip and Splash Tour.<br>" + "2.\t<b>Big Cats Kingdom:</b> Offers unique experiences like walking and interacting with lions, cheetahs, and caracals.<br>" + "3.\t<b>Safari Kingdom:</b> Includes Quad biking, Giraffe Feeding, Segway, Rhino Interaction, and E-bike Safari.<br>" + "4.\t<b>Middle Kingdom:</b> Allows visitors to feed and interact with tortoises.<br>";
                            model.title4 = "Action-Packed Thrill Mountain Activities at Casela World of Adventures";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.casela_6;
                            model.text9 = "•\t<b>Ziplining:</b> Enjoy the thrill of flying on zip lines, providing a bird's eye view of the park.<br>" + "•\t<b>Canyon Swing:</b> Experience a different form of bungee jumping from a 45m high platform.<br>" + "•\t<b>Mountain Climbing:</b> Embark on a Via Ferrata Canyon Tour through sugarcane fields and plateaus.<br>";
                            model.title8 = "Safari and Animal Activities at Casela World of Adventures";
                            model.text10 = "";
                            model.image4 = R.drawable.casela_4;
                            model.text11 = "•\t<b>Walk with Lions:</b> Take a stroll alongside lions with expert guides ensuring safety.<br>" + "•\t<b>Interaction with Big Cats:</b> Get up close with lions, cheetahs, and caracals under supervision.<br>" + "•\t<b>Drive Thru:</b> A 45-minute drive to observe lions in their natural habitat.<br>" + "•\t<b>E-Bike Safari:</b> Explore the safari park on eco-friendly electric bikes.<br>" + "•\t<b>Segway Trip:</b> Discover the Yemen Nature Reserve Park on a Segway.<br>" + "•\t<b>Safari Quad Biking:</b> Navigate the park's hills, valleys, and rivers on quad bikes.<br>" + "•\t<b>Camel Riding:</b> Enjoy a camel ride through Casela park.<br>";
                            model.image5 = R.drawable.casela_3;
                            model.text12 = "<b>History</b><br>" + "Casela World of Adventures originated in December 1979 as a bird sanctuary and has evolved into a must-see attraction in Mauritius. Throughout the years, the park has continually expanded its array of adventures, from quad biking and bus safari trips to unforgettable encounters with big cats, traversing a Nepalese bridge, and ziplining above trees and canyons.<br>" + "Today, visitors can engage in activities such as feeding giraffes, interacting with brightly colored lorikeets and pygmy hippos, exploring the hilly landscape on camelback, fishing for tilapias, and embarking on a fun e-bike safari trip around the park.<br>" + "<b>Conservation</b><br>" + "Remaining true to its founding vision, Casela World of Adventures is actively committed to the conservation and protection of endangered species. In February 2015, the park gained notoriety with Her Royal Highness Princess Stephanie of Monaco becoming its patron. Princess Stephanie, renowned for her dedication to elephant protection in Asia, wholeheartedly supported the conservation efforts of Mauritius' leading visitor attraction.<br>";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 3) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.tamarin_3;
                            model.text1 = "Tamarin Bay Beach in Mauritius is a renowned coastal gem located on the west coast of the island, just past the village of Black River. Widely celebrated for its natural beauty and surf-friendly conditions, Tamarin Bay attracts locals and visitors alike. <br>" + "The region was once known as Santosha Bay, evident in the faintly painted word 'Santosha' on some buildings. It was a hidden gem, providing avid surfers with some of the planet's best waves. Interestingly, locals initially refrained from naming the beach to keep its surfable seas a secret from outsiders.<br>" + "The broader recognition of Tamarin Bay came with the release of the iconic surf documentary \"Forgotten Island of Santosha\" by Larry and Roger Yates in 1974, immortalizing the area. Tamarin Bay boasts two globally acclaimed surfing spots: ‘Dal’ on its left (south) and ‘Black Stone’ on the right (north) of the bay.<br>" + "Tamarin Bay is a frequent habitat for dolphins, particularly Spinners and Bottlenose dolphins. These playful creatures are often spotted in the bay during the early morning before returning to the open sea. Numerous boat companies provide morning trips for tourists to observe and swim with dolphins.Tamarin is renowned for its apartments and the excellent service it extends to tourists.<br>";
                            model.title1 = "Surfing Hub";
                            model.image1 = R.drawable.tamarin_2;
                            model.text2 = "Tamarin Bay is famed for being one of the best surfing spots in Mauritius. Since the 1970s, it has been a central hub for surfers, initially introduced by Australians living on the island's west coast. The surf breaks draw enthusiasts, and access to this iconic spot is considered a privileged right.<br>" + "<b>Authentic Charm</b><br>" + "Despite its reputation as a premier surfing destination, Tamarin Bay retains an authentic and genuine atmosphere. Local families frequent the beach for a relaxing break or a leisurely stroll during the week, creating a vibrant yet laid-back ambiance.<br>" + "<b>Swimming Cautions</b><br>" + "While Tamarin Bay is a haven for surfers, swimming is not recommended for children and inexperienced swimmers. The presence of unpredictable currents and substantial waves breaking along the shore makes it less suitable for casual swimming.<br>" + "<b>Beach Atmosphere</b><br>" + "Tamarin Bay is a popular destination for both locals and tourists. The beach may be more crowded on weekends and holidays, offering a lively atmosphere and a chance to witness the vibrant beach culture.<br>" + "<b>Time Recommendations</b><br>" + "For those planning a visit, the best times to enjoy Tamarin Bay are early in the morning from 8:00 to 11:00 or in the afternoon from 13:00 to 16:00. During these periods, the beach offers favorable conditions for various activities.<br>" + "<b>Activities</b><br>" + "<br>";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.tamarin_1;
                            model.text4 = "Apart from surfing, Tamarin Bay provides opportunities for diverse water activities, including stand-up paddleboarding, bodyboarding, catamaran tours, swimming with dolphins, speed boat trips, and kayaking.<br>" + "In summary, Tamarin Bay Beach stands out as a dynamic and authentic coastal destination, offering a perfect blend of surfing excitement, natural beauty, and a lively beach atmosphere.<br>";
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
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 4) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.la_preneuse_4;
                            model.text1 = "The shoreline is adorned with pristine, snow-white sand, featuring a gentle slope and shallow waters. The ocean remains tranquil, displaying a captivating turquoise hue, although intermittent strong currents can be experienced. La Preneuse Beach boasts a spacious and expansive setting, providing ample room for all vacationers. The panoramic view from the coast reveals the towering Mount Le Morne against the backdrop of the turquoise lagoon.<br>" + "Situated on the west coast of Mauritius, the beach offers a range of hotels catering to different comfort levels for tourists. Cafes, stores, and souvenir shops offering diverse goods are conveniently located near the shoreline. A notable attraction is the Martello Tower, erected by the British in the 1830s as a defense against the French fleet. It now serves as a museum housing information about the region's history and the initial planters. The renowned Black River, a freshwater river, flows along the beach. Yachts and boats gracefully navigate the open sea, providing opportunities for sea excursions.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 5) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.martello_tower_4;
                            model.text1 = "To enhance your holiday experience in Mauritius, be sure to explore the Martello Tower Museum. Prepare to be fascinated by the artifacts, and the living conditions that characterize this historical period.As a relic of Mauritius' history, the Martello Tower Museum, located on the La Preneuse beach in Black River, is essential for those seeking a deeper understanding of the island's past.<br>" + "<b>Origin of the Martello Towers </b><br>" + "The British first encountered one of these fortresses during a fierce battle at Mortella Bay in Corsica in 1794. Manned by the French, the tower impressed the British, who decided to build similar structures to safeguard their empire. Remnants of these towers can still be found in some former colonies and along the shores of England, characterized by a conical shape, thick walls, and slight variations.<br>" + "<b>The Martello Tower in Mauritius </b><br>" + "The Martello Tower at La Preneuse has been meticulously restored and converted into a Heritage Museum. Nestled among casuarina trees, it stands as a testament to history.<br>" + "<b>Is it Martello or Mortella? </b><br>" + "Contrary to a common misconception, 'Mortella' and 'Martello' are not related. Mortella Bay is named after a shrub abundant in Corsica, where the battle took place. 'Martello' means hammer in Italian, and in the past, a fire on the tower's flat roof served as a warning of approaching enemies. In Italy, the alarm was signaled by striking a bell with a hammer or 'martello.'<br>";
                            model.title1 = "The Story behind the Martello Towers in Mauritius";
                            model.image1 = R.drawable.matello_tower_1;
                            model.text2 = "In the early 19th century, after the British captured Mauritius, concerns arose about a potential French insurrection with the abolition of slavery and the end of free labor. To protect the island, the British decided to construct five Martello Towers along the west coast at strategic locations near river mouths.<br>" + "The Martello towers wereprimarily built using basalt rock. The construction involved royal engineers, skilled stonecutters from India, carpenters, and, regrettably, slave labor for heavy tasks. Sand dunes called batteries were erected in front of the towers by the slaves. Each tower featured two cannons on the flat rooftop, capable of 360-degree rotation. The construction of the five towers spanned three years, but they never saw any action.<br>";
                            model.title2 = "The Tower turned into a Museum ";
                            model.text3 = "";
                            model.image2 = R.drawable.martello_tower_3;
                            model.text4 = "In 1992, the 'Friends of the Environment' initiated the restoration of the La Preneuse tower, funded by the government and other institutions. Transformed into a museum, it opened its doors in 2000, becoming an integral part of Mauritius' National Heritage Site.";
                            model.title3 = "Inside the Museum ";
                            model.text5 = "";
                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.martello_tower_2;
                            model.text9 = "The tower comprises several floors, including a basement for rainwater storage, a ground floor used as a storeroom and gunpowder armory, a first floor for the Chief Officer's exclusive use and soldier accommodation, and a flat roof where cannons were installed. The museum exhibits various memorabilia, including muskets, the officer's deck and uniform, a fireplace with utensils, and more.";
                            model.title8 = "Opening times ";
                            model.text10 = "Tuesday to Saturday: 09h30 to 17h00 <br>" + "Sunday: 09h30 to 13h00 <br>" + "Public Holidays: open except on 1 May, 25 December, 1 and 2 January, 1 February, 12 March. <br>" + "Closed on Mondays.<br>" + "Guided tours occur every half hour, and no advance booking is required. Simply walk in, pay the entrance fee, and a guide will welcome you for a tour.<br>";
                            model.image4 = R.drawable.map_location;
                            model.text11 = "";
                            model.image5 = R.drawable.map_location;
                            model.text12 = "";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 6) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.le_morne_1;
                            model.text1 = "Added to the World Heritage List in 2008, the Le Morne Cultural Landscape is a mountain on the southwestern edge of Mauritius, extending into the Indian Ocean. This site served as a refuge for runaway slaves, commonly referred to as maroons, spanning the 18th century until the early 1900s.<br>" + "The mountain bears an almost fortress-like character, featuring vertical cliffs encircling it, steep slopes crisscrossed by ravines and valleys, and, at its summit, a relatively level plateau—all of which offered refuge to the maroon slaves.<br>" + "A wide gorge, referred to as the V-Gap or the mountain's crucial entry point, posed challenges for accessing the plateau. Both oral traditions and early written records suggest the presence of a narrow and hazardous passage that the maroons had to navigate to evade pursuers and find sanctuary at the summit.<br>" + "Archaeological excavations conducted in cave shelters on the mountain unveiled ashy deposits, providing evidence of fire utilization. Additionally, the discovery of the 300-year-old remains of a young sheep supports the notion that maroons occupied the mountain's summit, successfully securing their survival.<br>" + "The distinctive and fragile ecosystem of Le Morne Brabant Mountain harbors numerous endemic plant species, some of which are among the rarest in the world.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.brabant_6;
                            model.text2 = "The flora is exceptionally varied, encompassing 73 out of the 311 species of flowering plants that are exclusive to Mauritius. Among these, the L’Immortelle Du Morne, or Helichrysum Mauritianum, stands out as an endemic species found specifically on the mountain.";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.brabant_8;
                            model.text4 = "The International Slave Route Monument is a tangible representation of the historical impact of slavery in Mauritius and globally. The central monument is encircled by nine smaller stone sculptures, symbolizing the origins and destinations of enslaved individuals.";
                            model.title3 = "";
                            model.text5 = "";
                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.brabant_4;
                            model.text9 = "A notable sculpture, crafted by Haitian artist Fritz Laratte, embodies the theme of liberation from slavery. It narrates the tale of a slave who, through prayer, witnessed the sudden release of his hands from the chains of servitude.<br>" + "The unique Ah-yee shop, an integral part of Trou-Chenille village since its inception, served as a crucial source of basic necessities for the villagers. Testimonies reveal that the villagers relocated along with the shop.<br>" + "Stella Maris, the initial Catholic chapel in Le Morne dating back to 1891, originally situated in Trou-Chenille, found its relocation to L’Embrasure during WWI. Following destruction by a cyclone in 1975, it was reconstructed in concrete in Le Morne Village in 1987.<br>";
                            model.title8 = "";
                            model.text10 = "";
                            model.image4 = R.drawable.brabant_7;
                            model.text11 = "Trou-Chenille, an integral component of the cultural heritage within the Le Morne Cultural Landscape, retains an open-air museum featuring five traditional huts portraying various aspects of daily life.<br>" + "Archaeological investigations uncovered evidence of a 19th-20th century settlement, Macaque, at the foot of Le Morne Brabant, likely associated with the Labonté and Béguinot families from Madagascar.<br>";
                            model.image5 = R.drawable.brabant_9;
                            model.text12 = "An abandoned cemetery, identified in a remote area beneath the mountain, dates back to the 19th century, with archaeological findings suggesting a connection to individuals of Malagasy and Mozambican origin.";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 7) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.maconde_1;
                            model.text1 = "The Maconde viewpoint is locatedon the southern coast of Baie du Cap, a charming and modest village celebrated for its striking natural allure and untamed, rugged coastlines. The viewpoint is nestled on a curved stretch of the coastal road atop a small rocky cliff. The landscape unfolds with picturesque vistas, featuring the vibrant red earth, lush green forests, rows of palm trees, and the glistening expanse of the Indian Ocean, creating a truly mesmerizing experience.<br>" + "Legend has it that the name \"Maconde\" traces its roots to the era of slavery, where runaway slaves from the Makonde tribe in Mozambique sought refuge in this area, while others believe it was named after Governor Jean Baptiste Henri Conde, who constructed an outlook on the cliff.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.maconde_2;
                            model.text2 = "Access to this region was historically challenging, and it wasn't until the 1920s that the first road was constructed, overcoming the difficulties posed by the low-lying coast and uneven terrain. Recent renovations have significantly enhanced safety. The winding road along basalt cliffs, with the rhythmic sounds of the ocean against the rocks, provides a captivating spectacle, making it a favored spot for those captivated by ocean swells.<br>" + "To reach the viewpoint, ascend a set of narrow stairs, where you'll be greeted by panoramic views of the ocean, the nearby coastal village, and occasional fishermen along the shore.<br>";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 8) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.chamarel_2;
                            model.text1 = "The Seven Coloured Earths form a geological wonder and a popular tourist destination situated in the Chamarel plain of the Rivière Noire District in southwestern Mauritius. This unique site encompasses small sand dunes exhibiting seven distinctive colors—red, brown, violet, green, blue, purple, and yellow. The remarkable characteristic of this location lies in the settling of differently colored sands in distinct layers, creating surrealistic and striped patterns on the dunes. Over time, rains have sculpted captivating designs into the hillside, resulting in an effect reminiscent of earthen meringue.<br>" + "These sands originate from the decomposition of volcanic rock (basalt) gullies into clay, later transformed into ferralitic soil through total hydrolysis. The primary elements responsible for the red/anthracite and blue/purplish colors are iron and aluminum, respectively. The various hues are thought to be a consequence of the molten volcanic rock cooling down at different external temperatures, although the specific causes of their consistent and spontaneous separation are not fully understood.<br>" + "The term \"Seven Coloured Earths\" serves as a descriptive, rather than an official, name. Various versions, including \"Chamarel Seven Coloured Earths,\" \"Chamarel Coloured Earth(s),\" \"Coloured Earth,\" and Terres des Sept Couleurs in French, have been reported.<br>" + "This phenomenon can be replicated on a smaller scale by taking sands of different colors, mixing them together, and observing their eventual separation into a layered spectrum.<br>" + "Since the 1960s, this site has evolved into one of Mauritius' major tourist attractions. Presently, the dunes are safeguarded by a wooden fence, and visitors are prohibited from climbing on them. However, observation outposts along the fence allow visitors to enjoy the scenery. Curio shops in the vicinity offer small test tubes containing the colored sands.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 9) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.chamarel_1;
                            model.text1 = "Unquestionably the tallest single-drop waterfall in Mauritius, standing at an impressive height of approximately 100m, the Chamarel Waterfall is a captivating natural wonder nestled amidst lush vegetation. Fueled by the convergence of three distinct streams flowing into the Saint Denis River, the waterfall exhibits a formidable rush, boasting a peak flow rate exceeding 40,000 m³ per minute.<br>" + "As you traverse the 3km access road of the Seven Coloured Earth Geopark, providing a picturesque drive to the geosite, be sure not to overlook the waterfall's viewpoint on your left. Accessible through a trail winding through dense foliage, the viewpoint offers a front-row spectacle of this natural marvel.<br>" + "Perched on the edge of a basalt cliff, the Chamarel Waterfall cascades into an oval pool before meandering through a 6km canyon fringed by tropical forests, eventually reaching Baie du Cap. The sight not only immerses the senses in freshness but also serves as a stunning testament to millions of years of volcanic activity. The dramatic landscape is shaped by lavas from two distinct ages. The brecciated basalt layer near the base dates back to 10 to 8 million years ago, overlaying a second layer from the intermediate period between 3.5 and 1.7 million years ago.<br>" + "Embark on a three-hour trek through the secret valley of the Chamarel Waterfall, leading you to the waterfall's base, where you can enjoy a refreshing swim in the pool as the majestic waterfall showers you from above.<br>" + "This location, characterized by its exceptional beauty, will mesmerize you with sights and sounds reminiscent of a true tropical rainforest. <br>";
                            model.title1 = "";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 10) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.black_river_georges_2;
                            model.text1 = "Black River Gorges National Park, located in the hilly southwestern region of Mauritius, was officially established on June 15, 1994, and is under the management of the National Parks and Conservation Service. Encompassing a total area of 67.54 km², the park features diverse habitats, including humid upland forests, drier lowland forests, and marshy heathlands. Visitor facilities within the park comprise two information centers, picnic areas, and an extensive network of 60 kilometers of trails. Additionally, there are four field stations dedicated to research and conservation projects conducted by the National Parks and Conservation Service and the Mauritian Wildlife Foundation.<br>" + "The primary aim of the park is to safeguard a significant portion of the island's remaining rainforest, even though parts of it have suffered degradation due to the introduction of non-native plants like Chinese guava and privet, as well as the presence of invasive animals such as the rusa deer and wild pigs. To preserve native wildlife, specific areas within the park have been cordoned off, and efforts have been made to eliminate invasive species. <br>";
                            model.title1 = "";
                            model.image1 = R.drawable.fody;
                            model.text2 = "Despite the challenges, the park continues to host a variety of endemic plants and animals, including the Mauritian flying fox and all endemic bird species on the island: Mauritius kestrel, pink pigeon, Mauritius parakeet, Mauritius cuckooshrike, Mauritius bulbul, Mauritius olive white-eye, Mauritius grey white-eye, and Mauritius fody. Recognized as an Important Bird Area by BirdLife International, Black River Gorges National Park plays a crucial role in the conservation of Mauritius' unique biodiversity.";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 11) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.le_morne_beach_2;
                            model.text1 = "Nestled on a peninsula along the western coast of Mauritius, at the base of the UNESCO-listed Morne Brabant mountain, lies Le Morne Beach. Easily accessible from the coastal road, this public beach boasts miles of pristine white sand and is adorned with majestic casuarina trees, all against the backdrop of the crystal-clear waters providing excellent visibility for scuba diving.";
                            model.title1 = "";
                            model.image1 = R.drawable.kite_surfing;
                            model.text2 = "Renowned as one of the premier kite-surfing spots in Mauritius, and often regarded as one of the best in the world, Le Morne Beach offers a breathtaking setting with its iconic mountain in the background. The beach is a favorite among windsurfers and kite surfers, as the conditions for these water sports are ideal throughout much of the year. The annual Kiteival, attracting international participants, is among the many competitions hosted at this spectacular location.<br>" + "While Le Morne Beach remains a delightful spot for swimming, it can get quite busy on weekends and holidays. Nudism is prohibited, although topless sunbathing is accepted. For a more tranquil experience, the best times to visit the beach are early in the morning from 8:00 to 11:00 or in the afternoon from 13:00 to 17:00.<br>";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.paddle_boarding;
                            model.text4 = "An array of activities awaits beachgoers, including pedalo rides, windsurfing, kite surfing, scuba diving, stand-up paddleboarding, and kayaking, ensuring there's something for everyone to enjoy at Le Morne Beach.";
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
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 12) {

                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.rhumerie_de_chamarel_1;
                            model.text1 = "Nestled in the fertile valley of the South West region of Mauritius, the Rhumerie de Chamarel offers a captivating experience surrounded by expansive sugarcane plantations seamlessly integrated with pineapples and other tropical fruits.<br>" + "Radiating warmth and authenticity, the Rhumerie de Chamarel Distillery invites visitors to partake in a comprehensive tourism journey, encompassing a guided tour of the distillery, rum tasting, and a delightful meal at L’Alchimiste, its distinctive \"A la Carte\" restaurant.<br>" + "The design of Rhumerie de Chamarel is a testament to its commitment to providing a holistic tourism experience, seamlessly blending with the stunning natural surroundings through the use of wood, natural stone, and water, fostering a sense of communion with nature.<br>" + "Guided Tour of Rhumerie de Chamarel embark on a guided tour of the Rhumerie de Chamarel with experienced guides taking you behind the scenes, offering detailed explanations of the rum-making process during your distillery visit.<br>" + "Explore the exclusive rum-making process, starting with the careful selection and cultivation of sugar cane plants on the domain. The unique fermentation techniques employed ensure the finest aromas and enhance specific flavors. The duration of the tour is approximately 30 to 40 minutes, conducted in either English or French for your convenience.<br>";
                            model.title1 = "Rum Tasting ";
                            model.image1 = R.drawable.rhumerie_de_chamarel_3;
                            model.text2 = "A highlight of the distillery's guided tour is the rum tasting experience. Conclude your tour with a unique opportunity to sample a selection of agricultural rums produced by the distillery. Unlike traditional rum distilled from molasses, agricultural rum is derived from distilling pure cane juice, resulting in distinctive aromas and flavors.<br>" + "Indulge in rum tasting, featuring varieties such as White Rum, Coeur de Chauffe, Chamarel Liquors, Exotic-Flavoured Rums, and the Old Rum.<br>";
                            model.title2 = "About the Rum of Rhumerie de Chamarel ";
                            model.text3 = "";
                            model.image2 = R.drawable.rhumerie_2;
                            model.text4 = "The focus of Rhumerie de Chamarel's rum-making process is to ensure a high-quality, eco-friendly agricultural rum. From cultivation to fermentation and sophisticated distillation, the distillery takes pride in producing rum by distilling fresh, fermented cane juice, deviating from the traditional molasses-based approach.<br>" + "Aligned with sustainable development principles, the distillery emphasizes environmental efforts, including recycling bagasse into energy, purifying industrial fumes, using ashes as fertilizers, and utilizing steam for garden irrigation.<br>" + "Additional Experiences<br>" + "1.\tThe Sugar Cane Spirit Shop: An opportunity to purchase authentic products, including local rum, Mauritian crafts, jewelry, and an exclusive line of clothing crafted by Rhumerie.<br>" + "2.\tRestaurant L’Alchimiste: Immerse yourself in a unique cuisine with dishes prepared from local products sourced on-site, surrounded by lush tropical flora overlooking plantations and mountains. Indulge in exotic delicacies such as palm heart or dishes featuring deer and wild pig, complemented by fine wines from France and other continents.<br>" + "Tourist Information<br>" + "•\tOpened from Monday to Saturday from 9.30 am to 5.30 pm.<br>" + "•\tThe guided visit and rum tasting last approximately 30-40 minutes.<br>" + "•\tChildren (up to 12 years old) must be accompanied by their parents, and rum tasting is not included.<br>";
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
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 13) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.curious_corner_2;
                            model.text1 = "The Curious Corner is the sole science museum in Chamarel, located in the southwestern part of Mauritius. It caters to inquisitive minds, both young and old, who revel in the challenges presented by puzzles. For children, it serves as a stimulating environment, fostering curiosity, enhancing the thought process, and promoting growth. The space also appeals to couples and parents, creating an ambiance conducive to social interaction and daily encounters with numerous people.<br>" + "This venue has become a delightful choice for celebrating birthdays, exchanging gifts with loved ones, or expressing care for one another in a unique setting, creating lasting memories. Families and relatives also frequent the Curious Corner, drawn by its captivating allure.<br>" + "While most tourists visit Mauritius for its beaches and blue lagoon, the Curious Corner offers a distinct adventure and a touch of strangeness. <br>";
                            model.title1 = "";
                            model.image1 = R.drawable.curious_corner_4;
                            model.text2 = "Located opposite the entrance of Chamarel's Seven Coloured Earth, the Curious Corner was constructed with the primary aim of surprising visitors.<br>" + "Spanning an area of 5,000 sq. meters, the adventure at the Curious Corner is filled with optical illusions that spark curiosity, boasting 40 exhibits to explore. A full visit typically takes around one and a half hours to experience all the thrills the place has to offer.<br>" + "Activities at the Curious Corner:<br>" + "1.\t<b>Upside-Down Room:</b> Experience the illusion of standing upside down, where the earth appears above your head, and the sky seems below your feet. The room challenges gravity, providing an excellent opportunity for unique photographs.<br>" + "2.\t<b>Staircase Music Room:</b> Ascend a staircase that produces musical notes with each step, adding an interactive and enjoyable element to the experience.<br>" + "3.\t<b>Light-Tapping Room:</b> Engage in a room where tapping on lights earns points, creating moments of fun and delight.<br>" + "4.\t<b>Ames Room:</b> Named after Adelbert Ames, this room features a trapezoidal shape that distorts perspective, making individuals appear larger or smaller depending on their position in the room.<br>";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.curious_corner_5;
                            model.text4 = "5.\t<b>Mirror Maze:</b> Navigate through a maze of 200 mirrors, creating optical illusions that challenge both the body and the mind.";
                            model.title3 = "";
                            model.text5 = "";
                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.curious_corner_3;
                            model.text9 = "6.\t<b>Laser Music Room:</b> Play your favorite tunes using laser beams, putting your musical skills to the test.<br>" + "7.\t<b>Corner Café:</b> Relax in a pleasant garden setting, enjoying a variety of food items, including ice cream, pizzas, burgers, snacks, and smoothies.<br>" + "8.\t<b>Gift Shop ('Puzzles and Things'):</b> Purchase souvenirs, including local rum produced at the distillery, Mauritian crafts, jewelry, and an exclusive line of clothing.<br>" + "<b>Special Guide:</b> The Curious Corner's staff is always ready to assist and provide information, ensuring a pleasant and engaging visit.<br>" + "<b>Group Visits:</b> Special prices are offered to groups, making group visits a cost-effective and enjoyable way to experience the attraction with friends, family, and loved ones.<br>" + "<b>Operating Information:</b><br>" + "•\tOpening Hours: 9 AM to 5 PM, seven days a week.<br>";
                            model.title8 = "";
                            model.text10 = "";
                            model.image4 = R.drawable.map_location;
                            model.text11 = "";
                            model.image5 = R.drawable.map_location;
                            model.text12 = "";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        }
                        break;
                    case "North":
                        if (holder.getAdapterPosition() == 0) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.red_roof_church;
                            model.text1 = "Situated along the northern coast of Mauritius, overlooking the lagoon in Cap-Malheureux, stands a small church distinguished by its striking red roof, known as Notre Dame Auxiliatrice. Regarded as an emblematic symbol of the island, this location affords breathtaking vistas of Coin de Mire, a nearby islet situated less than ten kilometers off the north coast of Mauritius.<br>" + "A simplistic architectural gem mirroring the essence of Mauritius, the Notre Dame Auxiliatrice chapel in Cap Malheureux is a featured stop on all tours provided by the Mauritius Resort. With its unassuming yet charming design, the chapel boasts a timeless quality, welcoming visitors throughout the year. The serene white hues of its interior walls evoke a sense of tranquility, and the aged yet imposing carved stone altar adds to its allure.<br>" + "<b>Notre Dame Auxiliatrice</b><br>" + "This renowned church, reminiscent of a postcard-perfect scene, beckons exploration. Visitors are captivated by its magnificent basalt altar and Holy water font. The picturesque landscape, adorned with a majestic Banyan tree casting a cooling shade, further enhances its charm. It stands as one of the most photographed locations on the island, attracting not only couples seeking a romantic setting for their vows but also avid photographers.<br>" + "<b>Embark on a Journey Through a Unique Setting/b><br>";
                            model.title1 = "";
                            model.image1 = R.drawable.cap_malheureux_1;
                            model.text2 = "Cap Malheureux, along with its iconic chapel, is best explored towards the end of the day. The sunset bathes the surroundings in an exceptional glow, reminiscent of the enchanting scenes from classic Hollywood romances. The natural beauty of the location is preserved and abundant, offering a chance to witness the renowned green ray, a phenomenon the island proudly boasts about. Optimal times to visit are between October and December when the flamboyant flowers adorn the island, creating a captivating spectacle.";
                            model.title2 = "Coin De Mire ";
                            model.text3 = "";
                            model.image2 = R.drawable.cap_malheureux_2;
                            model.text4 = "A detour to Cap Malheureux provides an opportunity to extend the exploration to the marine cemetery or the nearby Tamil temple. As serene as a sanctuary, Cap Malheureux serves as an ideal haven for recharging one's spirits.<br>";
                            model.title3 = "A Must-Visit Destination in Mauritius";
                            model.text5 = "This enchanting chapel is a highlight not to be overlooked during your stay in Mauritius. Conceived by Max Boullé and constructed by Raoul Lolliot in 1938, it received consecration from the Vicar General and Bishop Richard Lee on August 7, 1938.<br>";

                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.red_church_inside;
                            model.text9 = "Originally envisioned by Abbé Albert Glorieux, a Belgian missionary and parish priest of Saint-Michel of Grand Gaube, Notre Dame Auxiliaitrice was initially built to host wedding celebrations. The chapel continues to draw a congregation for Sunday masses, welcoming visitors throughout the day at any given time.";
                            model.title8 = "Cap Malheureux";
                            model.text10 = "Cap Malheureux is a village situated in the Rivière du Rempart District of Mauritius.<br>" + "The designation \"Cap Malheureux,\" translating to \"Cape of Bad Luck,\" was bestowed by the French during their control of the island from 1715 to 1810.<br>" + "The island served as a contentious focal point for numerous explorers, with the British being among them. In 1810, the British decided to seize the island to halt Mauritian corsairs' attacks on British fleets, notably those led by Surcouf. The British naval dominance had severed the island's supply connections with France. After an unsuccessful attempt to invade through Grand Port in the south (marked as the sole defeat of the Royal Navy by the French in the Napoleonic Wars), the British tactically surprised the French by launching an attack from the northern region, where French defenses were vulnerable. Consequently, the French were vanquished, and the name \"Cap Malheureux\" was coined to memorialize their defeat by the English, who successfully invaded and assumed control of the island from that strategic point.<br>";
                            model.image4 = R.drawable.map_location;
                            model.text11 = "";
                            model.image5 = R.drawable.map_location;
                            model.text12 = "";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 1) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.pamplemousse_garden;
                            model.text1 = "The Sir Seewoosagur Ramgoolam Botanic Garden, also known as the Pamplemousses Botanic Garden, is a prominent tourist attraction located in Pamplemousses near Port Louis, Mauritius. It holds the distinction of being the oldest botanical garden in the Southern Hemisphere. Established in 1770 by Pierre Poivre, the garden spans approximately 37 hectares (91 acres) and is renowned for its expansive pond featuring giant water lilies (Victoria amazonica).<br>" + "Throughout its history, the garden underwent various name changes, reflecting its evolving status and ownership. Notable names include 'Jardin de Mon Plaisir,' 'Jardin des Plantes,' 'Le Jardin National de l’Ile de France,' 'Jardin Royal,' 'Jardin Botanique des Pamplemousses,' 'The Royal Botanical Gardens of Pamplemousses,' and 'The Royal Botanic Gardens, Pamplemousses.' Eventually, on September 17, 1988, it was officially named the \"Sir Seewoosagur Ramgoolam Botanic Garden\" in honor of the first prime minister of Mauritius.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.botanical_garden_1;
                            model.text2 = "Beyond the mesmerizing giant water lilies, the garden boasts an assortment of spices, ebonies, sugar canes, and 85 palm varieties sourced from Central America, Asia, Africa, and the Indian Ocean islands. Noteworthy individuals, including Princess Margaret, Countess of Snowdon, Indira Gandhi, François Mitterrand, and Robert Mugabe, have contributed by planting trees within the garden.<br>" + "Situated in the village of Pamplemousses, approximately seven miles northeast of Port Louis, the garden has a rich history dating back to 1729 when it was set aside for colonist P. Barmont. Over the years, it changed hands multiple times, with various owners contributing to its expansion and development. Today, it covers an area of about 25,110 hectares (62,040 acres), with the remaining portion serving as an experimental station.<br>";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.botanical_garden_3;
                            model.text4 = "<br>" + "The roots of the Royal Botanic Gardens can be traced to the initiative of Mahé de La Bourdonnais, the first French Governor of Mauritius, in 1735. Initially created as a vegetable garden for his household and the burgeoning township of Port Louis, the garden evolved into a botanical haven. Under Pierre Poivre's directorship in 1768, the garden became a hub for acclimatizing plants from overseas and nurturing crops with economic significance, such as cassava.<br>";
                            model.title3 = "";
                            model.text5 = "";
                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.botanical_garden_2;
                            model.text9 = "Throughout its history, the garden weathered periods of neglect and upheaval, with directors like James Duncan contributing to its restoration and enhancement. In 1866, during a malaria epidemic, the garden played a crucial role in producing Eucalyptus trees to combat the disease.<br>" + "The Department of Agriculture assumed responsibility for the garden in 1913, overseeing its development and maintenance. Notably, following Seewoosagur Ramgoolam's death in 1985, part of the botanical garden was dedicated to a crematorium, marking the first instance of someone being cremated within its grounds.<br>" + "<br>" + "The Sir Seewoosagur Ramgoolam Botanic Garden stands as a testament to Mauritius's botanical heritage, offering visitors a captivating journey through its lush landscapes and rich history.<br>";
                            model.title8 = "Chateau de Mon Plaisir";
                            model.text10 = "";
                            model.image4 = R.drawable.botanical_garden_4;
                            model.text11 = "Until 1839, the Chateau de Mon Plaisir featured a modest structure characterized by a flat roof and circular verandahs. The current single-story building, constructed by the English in the mid-19th century, has been designated as a National Monument, giving it legal protection. Visitors can enjoy a charming panorama of the Moka Range and the Peak of Pieter Both from the Chateau.";
                            model.image5 = R.drawable.map_location;
                            model.text12 = "";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 2) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.sugar_museum_pamplemousses;
                            model.text1 = "Located not too far from the Pamplemousse Botanical Garden, amidst a picturesque setting featuring a bougainvillea and coconut tree-lined alley, a pond surrounded by lush greenery, stands the impressively renovated sugar mill—a truly spectacular attraction on the island!<br>" + "From the moment the Dutch set foot in Mauritius and introduced sugar canes to the island, the sugar industry has played a significant role in the island's history. At L'Aventure du Sucre, you'll delve into the intricacies of the sugar-making process and explore the colonial past that has profoundly shaped Mauritius into what it is today. Traverse a 250-year historical journey within the museum, a former operational sugar factory, and conclude your tour with a delightful sugar tasting experience, along with sampling various products derived from the golden era of colonial centuries.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.laventure_du_sucre;
                            model.text2 = "Embark on your museum tour by delving into the history of sugar plantations in Mauritius. Gain insights into the Dutch era, succeeded by the French and eventually the English colonists. Following this historical exploration, proceed to the operational factory, which remained active until the 1970s. Immerse yourself in the intricate stages of the sugar-making process showcased in vivid detail. Complement your visit to L'Aventure du Sucre by exploring the Village Boutik for gift shopping and souvenirs. Alternatively, enjoy a delightful pause at Restaurant Le Fangourin, savoring the nuances of Mauritian cuisine.";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 3) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.baie_de_larsenal_2;
                            model.text1 = "Explore the remnants of the Balaclava Ruins situated within the enchanting grounds of Maritim Resort and Spa, nestled along the shores of Turtle Bay. Immerse yourself in our Mauritian heritage as you visit the fort, perched gracefully over Riviere Citron on the scenic Northwest coast.<br>" + "<b>Balaclava Ruins</b><br>" + "Turtle Bay has a historical significance as a favored stop for ships traveling from Europe to the East during the 17th century. Initially named 'Ebony Bay' by the Dutch, the abundance of ebony trees in the area, ideal for ship repairs, led to its designation. Over time, the bay earned the name 'Turtle Bay,' possibly due to the presence of numerous turtles in the bay.<br>" + "<b>Balaclava Ruins History</b><br>";
                            model.title1 = "";
                            model.image1 = R.drawable.baie_de_larsenal;
                            model.text2 = "Moving into the 18th century, when the French settled in Mauritius, Governor Mahe de Labourdonnais relocated the administration from Mahebourg to the North, resulting in the establishment of Port Louis. The iron from Balaclava was crucial in constructing the new capital, its harbor, and supporting military efforts in India, including an iron foundry, naval arsenal, and gunpowder factory.<br>" + "<b>Cannon at Balaclava</b><br>" + "In 1774, a powder store explosion occurred, sparing some structures like the flour mill, sawmill, and the building housing ironworks. In 1864, the estate was sold to Mr. Wiehe, who built 'Mon Desir' and a school. Later, it became a popular holiday destination for wealthy Mauritians. Mr. Wiehe also established a modern rum distillery.<br>" + "<b>Balaclava Ruins Today</b><br>" + "Currently owned by a German hotel chain and a Mauritian family, preserving this heritage site is a priority. The Chateau Mon Desir restaurant was constructed on the original Mon Desir site, offering a panoramic view of the ruins and Turtle Bay.<br>" + "<b>Location</b><br>" + "Situated within the Maritim Hotel's 35-hectare estate on the Southwest coast, a mere 10-minute drive from Grand Bay, this open-air museum awaits your exploration. <br>" + "Visitors are advised to contact Maritim Resort for permission due to occasional film and fashion shoots at the site.<br>";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 4) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.mauritius_aquarium_1;
                            model.text1 = "Nestled in the quaint coastal village of Pointe aux Piments, situated in the northern region of Mauritius and approximately a 20-minute drive from Grand Baie, the aquarium unveils a novel ecological system. This innovative setup mirrors the depths and surroundings of the ocean, immersing visitors in a captivating world.<br>" + "Spread across five distinct buildings, the aquarium features various tanks and pools showcasing 150 different species of aquatic life native to Mauritius and its surroundings. The largest tank, spanning 15 meters, offers a mesmerizing spectacle of diverse marine animals. For young visitors, the \"touch pool\" provides an interactive experience with harmless marine creatures.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.mauritius_aquarium_2;
                            model.text2 = "The daily feeding ritual for the fishes takes place at 11:00 am, providing an opportunity to witness the impressive feeding sessions of sharks, tortoises, and morays. While guided tours are not available, the aquarium employs six knowledgeable staff members who are ready to address any queries. Additionally, a small souvenir shop and a snack bar, offering diverse lunch options and beverages, complement the visitor experience.<br>" + "In the event of unfavorable weather during your stay in Mauritius, the aquarium presents itself as a compelling alternative for exploration.<br>";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 5) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.grand_baie_1;
                            model.text1 = "Grand Bay, also known as Grand Baie, is a coastal village and prominent tourist destination situated in the Rivière du Rempart district at the northern tip of Mauritius. In the 17th century, the Dutch referred to it as De Bogt Zonder Eyndt (Bay Without End), a name that resonates when one explores the village. Today, Grand Bay stands out as the most favored holiday spot in Mauritius.<br>" + "<br>" + "Renowned for its mesmerizing emerald waters and vibrant atmosphere both day and night, Grand Bay caters to various water activities such as safe swimming, sailing, windsurfing, and water skiing. It also serves as the starting point for deep-sea fishing expeditions and boat trips to the northern islands of Mauritius, including Gunners' Quoin, Flat Island, Round Island, and Serpent Island.<br>" + "<br>" + "Grand Bay and its surroundings boast an extensive array of fashion and craft shops, hotels, and restaurants. The village offers a blend of traditional local shops, some with nearly five decades of operation, alongside modern shopping centers and global brand outlets, making it a premier shopping destination for clothing, jewelry, textiles, and souvenirs.<br>" + "<b>Nightlife</b><br>" + "Recognized for its vibrant nightlife, Grand Bay hosts some of the island's best bars and nightclubs, such as Banana Café, Zanzibar, Les Enfants Terribles, and the renowned Buddha Bar. Night owls can revel in the lively atmosphere, with parties kicking off around midnight and continuing into the early morning hours.<br>" + "<b>Location</b><br>" + "Located in the Rivière du Rempart district on the northwest side of the island, Grand Bay sits approximately 25 km north of Port Louis, the capital of Mauritius. Positioned between the villages of Pereybere to the east and Trou aux Biches to the west, the drive to Port Louis takes about 30 minutes, while the journey to the airport lasts approximately 1 hour and 30 minutes.<br>" + "<br>" + "Grand Bay enjoys a well-connected bus route, facilitating easy travel to key locations in Mauritius, including Port Louis, Triolet, Goodlands, and Grand Gaube.<br>" + "<b>Climate</b><br>" + "Boasting a favorable climate year-round, Grand Bay offers warm summers and mild winters. With sheltered beaches and lagoons, the region is an excellent choice for a holiday at any time.<br>" + "<b>Activities</b><br>";
                            model.title1 = "";
                            model.image1 = R.drawable.parasailing;
                            model.text2 = "Visitors to Grand Bay can engage in a plethora of activities beyond sunbathing, such as safe swimming, sailing, windsurfing, parasailing, and various water sports. The region is also ideal for exploring the underwater marine life through activities like the Underwater Sea Walk, submarine excursions, and the Underwater Scooter. Divers can discover numerous diving sites along the coral reefs just a few kilometers from the shore.<br>" + "<b>Hotels</b><br>" + "The hospitality industry in Mauritius, particularly Grand Bay, has witnessed significant changes over the years. From being a hidden paradise known to a select few travelers, Mauritius has transformed into a popular holiday destination with a diverse range of hotel options, guesthouses, private apartments, and villas. Grand Bay caters to various preferences, from deluxe resorts to cozy rooms for rent.<br>" + "<br>" + "Prominent hotels in Grand Bay include Veranda Grand Bay, Le Mauricia Hotel, 20 Sud, Ocean Villas, Royal Palm, Ventura Hotel, and Merville Beach Resort.<br>" + "<b>Grand Bay Beaches</b><br>";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.grand_baie_3;
                            model.text4 = "Grand Bay is home to two popular beaches: La Cuvette Beach and the Grand Bay Public Beach. La Cuvette, located near the Royal Palm hotel, offers a small and intimate setting with calm waters, free of rocks and corals. The Grand Bay Public Beach, situated at the heart of Grand Bay, provides panoramic views but has a limited area for entering the water due to active boat traffic inside the bay.";
                            model.title3 = "";
                            model.text5 = "";
                            model.title4 = "";
                            model.text6 = "";
                            model.title5 = "";
                            model.text7 = "";
                            model.title6 = "";
                            model.text8 = "";
                            model.title7 = "";
                            model.image3 = R.drawable.grand_bay_1;
                            model.text9 = "<br>" + "The north of Mauritius, including Grand Bay, is characterized by flat terrain, earning the name \"Northern Plains.\" With beautiful lagoons and white sandy beaches, this region boasts a rich palette of colors and varied landscapes. The sea within the lagoons is often adorned with soft sand, offering unmatched transparency. The view of the lagoons transitioning from green to blue, framed by the white surf of coral reefs and the deep blue open sea, creates a breathtaking spectacle.<br>";
                            model.title8 = "";
                            model.text10 = "";
                            model.image4 = R.drawable.catamaran_cruise_west_coast_2;
                            model.text11 = "For those seeking an underwater adventure, glass-bottom boat trips offer a glimpse into the marine world, but for a truly unique experience, embark on a journey with a two-person submarine to cruise beneath the surface alongside tropical fish.";
                            model.image5 = R.drawable.map_location;
                            model.text12 = "";
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 6) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.port_louis_3;
                            model.text1 = "Le Caudan Waterfront is as a prominent commercial development in Port Louis, the capital city of Mauritius, offering a diverse array of amenities such as shops, banking facilities, casinos, cinemas, restaurants, a marina, and the renowned five-star hotel, Le Labourdonnais.<br>" + "<b>Historical Roots:</b><br>" + "The name \"Le Caudan Waterfront\" pays homage to Jean Dominique Michel de Caudan, a notable figure who arrived in the former Isle de France from Languedoc, a historical province in the South of France, in 1726. He initiated a saltpan near a small bay in the southwest of Port-Louis, now recognized as the Robert Edward Hart Garden, situated on the entrance road to Le Caudan Waterfront.<br>" + "The peninsula of Le Caudan, formed around a fossil coral islet, witnessed the evolution of various structures over 250 years, including a powder magazine, an astronomical and meteorological observatory, quays, warehouses, and small enterprises. The sugar industry significantly influenced the harbor's daily activities until the establishment of the Bulk Sugar Terminal in 1980. Today, only a few remaining walls bear testament to the bustling activities that transpired over 150 years.<br>" + "<b>Historically Significant Spots</b><br>" + "Several areas within Le Caudan Waterfront hold historical significance. The first meteorological observatory in the Indian Ocean, now home to the Food Court and the Namasté restaurant, is one such spot. The Blue Penny Museum occupies the former Docks office building.<br>" + "The naming of different wings within the complex reflects episodes from the country's colonial history:<br>" + "Barkly Wharf: Named after Sir Henry Barkly, a Member of Parliament of the British government and appointed governor of Mauritius from 1863-1870.<br>" + "Le Pavillon wing: Derived from Pavillon Street on an ancient map of Port Louis, speculated to have origins during the period when Port Louis was called ‘Port Napoléon.’<br>" + "Dias Pier: A tribute to Diogo Dias, brother of the famous navigator Barthoulomeu Dias, believed to be the first to record the Mascarene Islands on a navigation map.<br>" + "<b>Modern Day Attraction</b><br>";
                            model.title1 = "";
                            model.image1 = R.drawable.port_louis_13;
                            model.text2 = "<br>" + "Caudan, commonly known today, was the island's first major shopping development, and it continues to be an iconic shopping destination for both locals and tourists. The mall features the latest fashion trends, a popular Craft Market, specialty shops offering unique local goods, cinemas, a marina, a bookstore, restaurants, cafes, a museum housing two of the rarest stamps globally, a casino, and tax-free shopping for tourists.<br>";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.port_louis_6;
                            model.text4 = "Despite being the first shopping mall on the island, Caudan has adeptly adapted to current trends, maintaining its appeal as a modern waterfront mall. Visitors can witness the bustling port activities as large container and cruise ships navigate in and out.";
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
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 7) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.port_louis_4;
                            model.text1 = "The primary shopping hub in Port Louis is undeniably the Port Louis Central Market, also referred to as the Bazaar of Port Louis. It is segmented into different sections, each hosting diverse stalls offering various products.<br>" + "The central focus of the market revolves around fresh fruits and vegetables, creating a visually stunning display of vibrant produce that is truly a feast for the eyes.<br>" + "Ascending to the first floor, visitors encounter the renowned Craft Market. This section provides an extensive selection of locally crafted souvenirs, spices, and handicrafts at reasonable prices. Whether you're seeking a gift for a challenging recipient, the Craft Market ensures you'll find something suitable. We strongly recommend taking the opportunity to indulge in some shopping.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.port_louis_5;
                            model.text2 = "After a bout of shopping, satisfy your appetite by exploring the adjacent section of the Central Market, home to numerous street food stalls. A wide array of choices awaits, ensuring you find something to suit your taste. Don't miss the chance to try dhall puri, crafted from split chickpea and flour, or the famous alouda, resembling a milkshake with basil seeds, grated jelly, and sometimes a scoop of ice. For those interested in local snacks, there's a diverse range of options, including samoussas (fritters filled with potatoes), bajas (fritters made with chickpea flour), and gato piment (fritters made with yellow split pea and chili).<br>" + "<br>" + "Remaining bustling throughout the week, the Central Market stands as a key shopping destination for locals and draws visitors from across the island. It is undeniably worth a visit, offering insights into local life and allowing you to immerse yourself in the authentic Mauritian atmosphere.<br>";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 8) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.port_louis_9;
                            model.text1 = "The Government House in Port Louis is one of the oldest structures, maintaining its graceful presence since the days of the French colony. Although its current appearance differs from its original form, the construction of the Government House began under the leadership of the first French governors, Nicolas de Maupin (1729 – 1735) and Mahé de Labourdonnais (1735 – 1746), who also used it as his residence. The building served as the official venue for the Governor's administrative activities, as well as a host for various receptions and functions.<br>" + "Under the governance of Mahé de La Bourdonnais, Port Louis emerged as a significant naval base and shipbuilding center. During his tenure, several structures were erected, some of which still endure today, including parts of the Government House, the Chateau de Mon Plaisir in Pamplemousses, and the Line Barracks. The French East India Company maintained control of the island until 1767.<br>" + "Originally, the building featured a wooden structure with palm leaf coverings, which was later replaced by a one-story construction during Nicolas de Maupin's era. Mahé de Labourdonnais subsequently expanded the ground floor in 1738, and the building was then designated as Hôtel du Gouvernement. Over time, through the French and British colonial periods, the structure underwent additional modifications and enhancements, culminating in the final form we recognize today.<br>" + "Adjacent to the structure, a statue of Queen Victoria, bearing her trademark solemn expression, stands prominently. Regrettably, the building is not open to visitors.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 9) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.place_des_armes;
                            model.text1 = "In the heart of the bustling capital of the island, Port Louis, between the former government hotel and the waterfront overlooking the port, lies the Place d'Armes. Known to all Mauritians, the Place d'Armes is a square in the capital adorned with statues of the founding fathers of Mauritius.<br>" + "The Place d'Armes is a must-visit location as it is where north-south traffic converges, and the main access points to the city meet.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.place_darmes_2;
                            model.text2 = "Built during the time of Mahé de La Bourdonnais, his statue stands at the entrance of the Place d'Armes. Also known for its towering palm trees, the Place d'Armes features a three-lane avenue that has hosted many dignitaries from around the world.<br>" + "<br>" + "It is also the oldest part of the city of Port Louis, where one can find the headquarters of numerous banks, commercial houses, and consulates. However, the old period buildings have given way to a much more modern architecture.<br>";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.port_louis_8;
                            model.text4 = "The Place d'Armes remains the ideal starting point for your visit to the capital. Nearby, you will find several city landmarks, including the government hotel, the oldest theater in the Indian Ocean, some still cobbled roads like Vieux Conseil Street and Georges Guibert Street. Also in the vicinity are St Louis Cathedral, a Catholic church, and St James Cathedral, a Protestant church. You can also explore the central market and many other museums.<br>";
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
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 10) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.blue_penny_museum_2;
                            model.text1 = "The Blue Penny Museum in Mauritius was inaugurated in November 2001 and is dedicated to showcasing the history and art of the island. Its name is derived from the famous 1847 Blue Penny and Red Penny stamps, which hold great historical significance.<br>" + "Here's a brief history of the Blue Penny Museum:<br>" + "1.\t<b>Stamp Acquisition (1993):</b> The museum's centerpiece is the 1847 Blue Penny and Red Penny stamps, considered some of the rarest and most valuable stamps in the world. In 1993, a consortium of Mauritian enterprises, led by The Mauritius Commercial Bank, purchased the stamps for $2,000,000. These stamps were then repatriated to Mauritius, marking their return to the island after nearly 150 years.<br>" + "2.\t<b>Museum Inauguration (2001):</b> The Blue Penny Museum officially opened its doors to the public in November 2001. It was established as a cultural institution aimed at preserving and showcasing Mauritius's rich history and artistic heritage.<br>" + "3.\t<b>Conservation Efforts:</b> Given the extreme rarity and value of the Blue Penny stamps, conservation efforts were implemented. The originals are illuminated only temporarily to prevent damage from prolonged exposure. Visitors to the museum typically view replicas of the stamps, ensuring the long-term preservation of the priceless artifacts.<br>" + "4.\t<b>Founder - The Mauritius Commercial Bank:</b> The museum was founded by The Mauritius Commercial Bank, one of the leading financial institutions in Mauritius. This initiative reflects the bank's commitment to preserving and promoting the cultural heritage of the island.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.blue_penny_museum_1;
                            model.text2 = "5.\t<b>Additional Artifacts: In addition to the Blue Penny stamps, the museum houses other notable artifacts, including the original statue of Paul and Virginia. Crafted by Prosper d'Épinay in 1881, this statue adds to the cultural and artistic richness of the museum's collection.<br>" + "The Blue Penny Museum has become a significant cultural institution in Mauritius, attracting both locals and tourists interested in exploring the island's history through its valuable artifacts and exhibits.<br>" + "The Blue Penny Museum is structured across two floors, each offering distinct features and exhibits:<br>" + "<b>Ground Floor:</b><br>" + "1.\t<b>Souvenir Shop: Visitors are welcomed by a souvenir shop on the ground floor, providing an opportunity to purchase mementos related to the museum and Mauritius.<br>" + "2.\t<b>Temporary Exhibition Room: The ground floor houses a temporary exhibition room, showcasing rotating exhibits that may vary over time, allowing for diverse and dynamic displays.<br>" + "First Floor:<br>" + "1.\t<b>The Age of Discovery:</b> This exhibition room narrates the stories of pioneers who undertook the first oceanic voyages to reach the Mascarene Islands. It prominently features ancient maps that document this historic journey.<br>" + "2.\t<b>The Island Builders:</b> Covering three significant periods in Mauritius's history—the Dutch Period, the French Period, and the English Taking Over—this room provides a comprehensive overview of the island's historical evolution.<br>" + "3.\t<b>Port Louis:</b> This exhibition room focuses on the origins and history of Port Louis, offering insights into the development and growth of the city.<br>" + "4.\t<b>The Postal Adventure:</b> Dedicated to the postal history of Mauritius, this room proudly displays two stamps from the renowned Blue Penny collection, contributing to the island's philatelic heritage.<br>" + "5.\t<b>Engraved Memory:</b> Honoring Joseph Osmond Barnard, the first individual to engrave stamps in Mauritius, this room serves as a tribute to his significant contributions to the field.<br>" + "Overall, the Blue Penny Museum is thoughtfully organized to provide visitors with a captivating journey through Mauritius's history, art, and unique cultural heritage.<br>";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 11) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.church_pl;
                            model.text1 = "The St. Louis Cathedral, locally known as 'Katedral Sin Lwi,' is situated in Port Louis, not far from Champ de Mars, making it one of the oldest churches in Mauritius. As the seat of the bishop of the diocese of Port Louis, this religious edifice has undergone multiple demolitions and rebuilds throughout its history.<br>" + "Initially erected between 1752 and 1756 as a temporary wooden chapel where the Bank of Mauritius stands today, the cathedral faced destruction due to cyclones and wartime usage. Mahe de Labourdonnais, the visionary behind the church's location, completed it in 1756. However, a cyclone in April 1773 brought it down completely. In 1782, a new church opened but was closed due to structural issues. Sir Robert Farquhar reconstructed it in 1814. Demolished again in 1928 and rebuilt in 1933 under Mgr James Leen, the present structure, with its larger size and historic features like the facade and stone towers, emerged.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.text1;
                            model.text2 = "The interior preserves relics from the past, such as statues, paintings, and furniture. The altar, in use since earlier years, holds historical significance. In 2007, marking its 160th anniversary as a cathedral, the building underwent extensive renovation, restoring its prominence in Port Louis.<br>" + "The cathedral serves as the burial place for its bishops, a tradition in the Catholic Church. Six bishops, including Mgrs Hankinson, Meurin, O’Neil, Bilsborrow, Leen, and the latest, Cardinal Margéot, interred in July 2009, rest beneath the choir tiling.<br>";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 12) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.natural_history_musuem;
                            model.text1 = "The Natural History Museum in Port Louis is located on the ground floor of the Mauritius Institute Building, a structure recognized as a National Heritage, situated in the vibrant heart of the City of Port Louis. Erected between 1880 and 1884, the Mauritius Institute Building is a partial emulation of the Colombo Museum of African Modern Art building in Sri Lanka, designed by British architect M. Mann.<br>" + "As the oldest museum in Mauritius and one of the earliest in southern Africa, the Natural History Museum holds a storied history. The idea for a museum in Mauritius was conceived in 1826 when naturalists Julien Desjardins and Louis Bouton presented the proposal to Governor Sir Lowry Cole. Consequently, on October 14, 1842, the Desjardins Museum of African Modern Art was inaugurated in a wing of the old Royal College in Port Louis, where it remained for the ensuing 42 years.<br>" + "In 1880, the Mauritius Institute was founded under the guidance of Governor Sir George Ferguson Bowen. The collection from the Desjardins Museum was relocated to the newly constructed Mauritius Institute Building in 1885. Primarily focused on marine fauna and birds from the Mascarene Islands, this collection laid the groundwork for the present-day Natural History Museum.<br>" + "Dedicated to the systematic collection, study, and documentation of the fauna and flora of Mauritius and the Mascarene Islands, the museum has evolved into a center for information and exchange across various natural history fields in the Mascarene region.<br>" + "In 2000, the Natural History Museum of the Mauritius Institute attained the status of a National museum, reinforcing its role as a pivotal institution in preserving and promoting the country's natural heritage. Notably, the museum is home to the most complete dodo skeleton, unearthed in 1904 by barber Etienne Thirioux, further emphasizing its significance in the scientific and historical exploration of Mauritius's distinctive biodiversity.<br>" + "Key features of the Natural History Museum in Port Louis:<br>" + "1.\t<b>Exhibits and Displays:</b> The museum typically features exhibits on various aspects of natural history, including geology, paleontology, botany, and zoology. Displays may include fossils, specimens of indigenous plants, and information about the unique ecosystems found in Mauritius.<br>" + "2.\t<b>Endemic Species:</b> Mauritius is known for its unique flora and fauna, and the museum often highlights endemic species that are found nowhere else in the world. This can include information about rare plants, birds, and other wildlife.<br>" + "3.\t<b>Educational Content:</b> Natural history museums often serve an educational purpose, providing valuable information about the island's geological history, evolution of its species, and the importance of conservation.<br>" + "4.\t<b>Research and Conservation:</b> Some natural history museums engage in research and conservation efforts. They may collaborate with scientists, researchers, and conservationists to contribute to the understanding and preservation of the island's natural environment.<br>" + "5.\t<b>Interactive and Engaging Displays:</b> Modern museums often incorporate interactive displays, multimedia presentations, and engaging activities to make the learning experience more enjoyable for visitors of all ages.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 13) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.aapravasi_ghat_1;
                            model.text1 = "The Aapravasi Ghat is a historical site located in Port Louis, the capital city of Mauritius. It holds great significance in the history of the island and is recognized as a UNESCO World Heritage Site. The history of the Aapravasi Ghat is closely tied to the indentured labor system that shaped the social and economic landscape of Mauritius.<br>" + "Here is a brief history of the Aapravasi Ghat:<br>" + "1.\t<b>Indentured Labor System:</b> In the 19th century, after the abolition of slavery, the British turned to the system of indentured labor to meet the demand for cheap and abundant workforce for their colonies. Indentured laborers were recruited from various parts of India, as well as China and Africa, to work on plantations in Mauritius and other British colonies.<br>" + "2.\t<b>Establishment of Aapravasi Ghat:</b> The Aapravasi Ghat was established in 1849 as the first site for the reception of indentured laborers in Mauritius. The name \"Aapravasi Ghat\" translates to \"immigration depot\" in Hindi. The location served as a processing center where indentured laborers arriving by ship were registered, housed temporarily, and assigned to various plantations across the island.<br>" + "3.\t<b>Living Conditions:</b> Indentured laborers faced harsh living conditions at the Aapravasi Ghat. They were often crowded into cramped barracks, and the site became a place where many experienced suffering, sickness, and death. The conditions were challenging, and the laborers endured a difficult transition from their home countries to the unfamiliar environment of Mauritius.<br>" + "4.\t<b>End of Indenture:</b> The indenture system continued until the early 20th century when it was officially abolished. The Aapravasi Ghat continued to be used for processing immigrants until 1920. After the cessation of the indenture system, the site underwent various transformations, serving different purposes over the years.<br>" + "5.\t<b>UNESCO World Heritage Site:</b> In 2006, the Aapravasi Ghat was designated as a UNESCO World Heritage Site in recognition of its historical importance in the global migration of indentured laborers and its impact on the multicultural identity of Mauritius.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.aapravasi_ghat_2;
                            model.text2 = "indentured laborers who played a crucial role in shaping the cultural and social fabric of Mauritius. The site is open to visitors, allowing them to explore its history and gain insights into this critical period in the island's past.";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 14) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.post_office;
                            model.text1 = "The present-day museum building was erected as the General Post Office between 1865 and 1870. It is located by the harbor, adjacent to the customs building in the heart of the city.<br>" + "Construction commenced in January 1865 under the supervision of Surveyor General Morrison. By 1868, three-quarters of the building was completed, with an additional two years required to finish the entire project. The construction expenses amounted to £10,000 to £11,000, employing approximately 80 workers. It officially opened in December 1870.<br>" + "The architecture serves as a notable illustration of Victorian design in public colonial structures from the era of Queen Victoria, mirroring similar structures found in countries such as India, Sri Lanka, South Africa, Trinidad, and Guyana.<br>" + "It served as a replacement for the former General Post Office situated on Government Street near Government House, which had been the post office's headquarters since 1847.<br>" + "Since December 21, 1870, it has functioned as the primary post office of Mauritius, and in April 1877, the Central Telegraph Office also took residence in the building.<br>" + "The Postmaster General made his residence in the building, and it became the hub for mail from the 33 rural post offices built between the 1870s and 1890s on the island.<br>" + "In 1958, under British Governor-General Sir Robert Scott, the building received recognition as a listed structure through Government Notice No. 614. This decision followed a recommendation from the Ancient Monuments Board. The Mauritian National Monuments Act of 1985 confirmed the building's protected status, as did the \"National Monuments of Mauritius\" annex to the National Heritage Fund Act (Act No. 40) of 2003.<br>" + "The postal museum, inaugurated in 2001, showcases exhibits detailing the postal and telecommunications history of the island. Notably, the world-renowned Red and Blue \"Post Office\" Mauritius stamps are not on display here but at the nearby Blue Penny Museum.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 15) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.citadelle;
                            model.text1 = "The Fort Adelaide is as a testament to the initial years of British governance in the region. Erected in the 19th century, precisely between 1834 and 1835, by Colonel Thomas Cunningham, the fort's construction presented formidable challenges due to the scarcity of labor caused by the recent abolition of slavery. To address this shortage, the British government initially relied on apprentices, liberated slaves, prisoners, and even some soldiers. However, owing to the lack of skilled labor, the government had to enlist stonemasons, masons, laborers, and other craftsmen from India in 1837 to complete the construction.<br>" + "The primary purpose behind constructing the fort was to safeguard the port against potential invasions and suppress any potential uprising from the local population. It was christened Fort Adelaide in homage to Adelaide, the wife of King William IV of England, featuring her initials and crown on the entrance pediment. Despite never being utilized for military or policing purposes, it stands as one of the few remnants of the period between the abolition of slavery and the arrival of indentured laborers.<br>" + "In contrast to other forts from the British era, such as Fort William and Fort Victoria, which have succumbed to deterioration and neglect, Fort Adelaide remains the sole intact structure. Crafted from black basalt stones, it serves as a testament to the expertise of the craftsmen of that era. Completed in 1840, the fort became a symbol of the commencement of Indian immigration and the cessation of slavery, not only due to those involved in its construction but also due to the circumstances that led to its inception.<br>" + "During the 1830s, tensions ran high in Mauritius, recently brought under British rule. The French inhabitants on the island were discontented about losing control and the prohibition of the slave trade, compounded by the abolition of slavery. The news of the French Revolution of 1830 heightened these tensions. The island's population comprised whites, people of color, and slaves, prompting British authorities to worry about potential enemy attacks or uprisings. Fort Adelaide's construction was sanctioned to provide defensive capabilities in case of invasion or rebellion. The strategic hill of Port-Louis was chosen to oversee the city, port, and mountain slopes.<br>" + "Upon the fort's completion, the island's situation had significantly improved, and its original purpose was no longer applicable. Instead, it was repurposed for signaling fires and announcing the arrival of notable figures through cannon fire or simply for daily ceremonial cannon fire. Over the years, its function evolved into a hub for cultural initiatives, hosting concerts, shows, and various events. Despite this shift, Fort Adelaide remains a pivotal landmark in Mauritius, symbolizing the intricate history of the island.<br>";
                            model.title1 = "";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 16) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.port_louis_photography_museum;
                            model.text1 = "Established in 1966 through the avid collecting enthusiasm of Mr. Tristan Bréville and his wife, this private museum had its initial presence at their residence in Rose-Hill, then in Quatre Bornes, and eventually found its current home in 1993 within an old building donated by the municipality. This space underwent restoration with the support of AIMF. The inauguration, graced by sixty-four French mayors from AIMF, Mr. Jacques Toubon (French Minister of Culture), and Mr. Jean-Luc Monterrosso (director of the European House of Photography), unfolded on July 1, 1993. Mauritius welcomed the daguerreotype in February 1840, marking its entry into photography practice merely four months after procuring the patent from Louis Daguerre in France. Consequently, the island stands among the pioneers globally in adopting photography.";
                            model.title1 = "";
                            model.image1 = R.drawable.photography_musuem_3;
                            model.text2 = "The museum proudly showcases an array of documents capturing the history of photography in Mauritius, encompassing portraits, landscapes, urban and rural scenes, significant events, factories, fishing moments, inaugural automobiles, early buses (1930), the Mauritian railway, colonial residences, historical structures, flora, fauna, and more.";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.port_louis_photography_museum_inside;
                            model.text4 = "With a collection boasting over a thousand cameras spanning various epochs, including Charles Chevalier's lens crafted for Daguerre in 1839, the museum also serves as an iconographic research center. Housing a specialized library and Nadar business card collections, it possesses an extensive compilation featuring 400,000 acetate negatives, 5,000 glass plates, 28 daguerreotypes, 10 Lumière brothers' autochromes, 200,000 prints illustrating the history and landscapes of Mauritius, 9,000 vintage postcards, over twenty-five hours of films depicting Mauritius and its inhabitants from 1939, archival newspapers spanning the late 19th century to 1945 related to photography in Mauritius, as well as books and newspapers delving into the history of cinematography in Mauritius since 1897.";
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
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 17) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.marie_reine_de_la_paix_3;
                            model.text1 = "Marie Reine de la Paix, or Mary Queen of Peace, is a Catholic church and holy site, showcasing a remarkable monument portraying the Virgin Mary gracefully holding a globe. Crafted from Carrara marbleby Ferdinando Palla in Italy, this 3-meter-tall statue was unveiledon the Feast of the Assumption in 1940.The Monument was dedicated to Mary Queen of Peace as an expression of gratitude for safeguarding the country during World War I.";
                            model.title1 = "";
                            model.image1 = R.drawable.marie_reine_de_la_paix_5;
                            model.text2 = "This church holds considerable importance as a pilgrimage destination for Catholics in Mauritius. Particularly esteemed during religious festivities like the Feast of the Assumption of the Blessed Virgin Mary, it attracts throngs of devotees to its sacred premises. In 1989, Pope John Paul II graced the church with his presence during his 44th international journey.";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.marie_reine_de_la_paix_4;
                            model.text4 = "Nestled on the inclines of Signal Mountain in the capital city of Port Louis, the church transcends its role as a mere place of worship, evolving into a tranquil haven offering a sweeping view of the city. Accessing the church entails ascending seven terraces and 82 steps hewn from rock. Each terrace is adorned with vibrant flowers, and the meticulously manicured surrounding gardens create an idyllic setting for individuals, friends, and families to convene and partake in moments of serene contemplation.";
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
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 18) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.jardin_de_la_compagnie_1;
                            model.text1 = "The Jardins de la Compagnie is the city's most enchanting garden, adorned with expansive banyan trees, numerous statues, benches, and fountains. It is a delightful and secure destination during the day. However, it is advisable to steer clear of the park at night, as it tends to be a popular gathering spot for sex workers and drug addicts.";
                            model.title1 = "";
                            model.image1 = R.drawable.les_jardins_de_la_compagnie_2;
                            model.text2 = "The origin of the 'Jardin de la Compagnie' dates back to the French Occupation period when French settlers were establishing their colony on the island. After the Dutch abandoned Mauritius in February 1710 due to various challenges, including cyclones, floods, and attacks from maroon slaves, the French took control of the island in September 1721. During the arrival of the acting governor De Nyon (1722 – 1725), Mr. Durongouet-Le-Toullec, dispatched from Bourbon Island in December 1721, settled on the border of 'Ruisseau du Pouce,' establishing a garden that later became the Company Garden.<br>" + "Initially, the area was marshy and not suitable for construction. Over time, as different governors took charge, the 'Jardin de la Compagnie' served partly as a cemetery due to the Smallpox epidemic. In 1771, during Governor Desroches' tenure (1769 – 1772), Port Louis began to resemble a town with the creation and correction of large streets. It was at this point that the cemetery section of the garden was relocated to the current site of the 'West Cemetery' (Les Salines), allowing the original purpose of the garden to emerge as a place for relaxation and enjoyment.<br>";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 19) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.odysseo_1;
                            model.text1 = "Embark on a captivating adventure at Odysseo, the largest oceanarium in the Mascarene Islands, and prepare to be mesmerized by a diverse array of species thriving in their natural habitat. A true delight for animal enthusiasts and sea lovers, especially those with a passion for marine biology and biodiversity.";
                            model.title1 = "";
                            model.image1 = R.drawable.odysseo_2;
                            model.text2 = "Nestled in the heart of the island's capital, Port Louis, near the harbor, Odysseo immerses you in an oceanic theme from the moment you arrive. Encounter adorable fish reminiscent of Nemo and even encounter awe-inspiring sharks. This package provides two options, both including admission to the oceanarium and park access.";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.odysseo_3;
                            model.text4 = "Option 2 offers a guided tour of the entire park, providing an opportunity to delve deeper into the mysteries of the ocean and its inhabitants. <br>" + "Odysseo Experience Highlights:<br>" + "1.\t<b>The Lagoon:</b> Immerse yourself in the Mauritian territory, exploring the lagoon's calm waters, vibrant fish, seagrass beds, mangroves, and coral reefs.<br>" + "2.\t<b>Inland Forests:</b> Venture inland to discover species in their habitats, exploring lakes, rivers, and forests with diverse freshwater, insect, and reptile inhabitants.<br>" + "3.\t<b>Coral Reefs:</b> Dive into the blue waters of the Indian Ocean to unveil the secrets and biodiversity of the majestic coral reefs.<br>" + "4.\t<b>Open Sea:</b> Experience a fully immersive underwater journey as stingrays, sharks, eels, and various fish swim alongside you in the tunnel.<br>" + "5.\t<b>Invertebrates:</b> Explore the fascinating world of invertebrates, comprising 95% of animal species on Earth, and unravel their incredible evolutionary history.<br>" + "6.\t<b>Sub-Oceanic View:</b> Gain a better understanding of sharks and their vital role in the interconnected oceans, advocating for their protection.<br>" + "Upon completing your visit, make your way to the gift store, where a diverse range of offerings awaits. From stuffed animals and t-shirts to books, educational games exploring the marine environment, goodies, and jewelry, you can find an array of souvenirs to bring the oceanic experience home with you.<br>";
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

                        } else if (holder.getAdapterPosition() == 20) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.chateau_de_labourdonnais;
                            model.text1 = "A majestic lane of exceptionally large trees invites you to the colonial mansion once owned by Christian Wiehe. Constructed in 1856 and completed approximately three years later, this residence is often referred to by many Mauritians as the most exquisite colonial house on the island, and rightfully so. Featuring a spacious dining room, an impressive house pantry, a large living room, elegantly styled bedrooms, and a grand exhibition hall, this palace is undeniably an enchanting destination.";
                            model.title1 = "";
                            model.image1 = R.drawable.chateau_de_labourdonnais_4;
                            model.text2 = "During your exploration, you'll wander through the lush gardens with expansive pathways, showcasing the opulence of Mr. Wiehe's era. Century-old mango trees, various spice trees, and numerous exotic fruit trees contribute to the garden's incredible charm. The Aldabra tortoises peacefully graze, considering the palace their home. As part of your visit, you can venture to the Rhumerie des Mascareignes, established in 2006, to learn about traditional rum-making techniques. The tour of La Château de Labourdonnais concludes with a splendid tasting session featuring rum and other local delights such as fruit pastes, juices, and sorbets. The boutique provides an opportunity to purchase gifts and souvenirs, and you can also take a break at La Table du Chateau, an elegant restaurant offering Mauritian dishes.";
                            model.title2 = "";
                            model.text3 = "";
                            model.image2 = R.drawable.chateau_de_labourdonnais_2;
                            model.text4 = "The visit concludes delectably at the Tasting Bar, where you can sample products from the distillery or orchards, including jams, fruit jellies, fruit juices, and sorbets.<br>" + "Beyond the Château of Labourdonnais tour, you can explore the shop offering authentic local products, including decorative items related to colonial life and gardens, rum, fruit jellies, spices, and more.<br>" + "La Table du Château provides a unique and refined culinary experience inspired by the fruits and vegetables from the Labourdonnais orchards. Set in a contemporary ambiance, it offers a gastronomic journey unveiling the flavors of Mauritius.<br>";
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
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 21) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.albion_lighthouse;
                            model.text1 = "";
                            model.title1 = "";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 22) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.albion_lighthouse;
                            model.text1 = "";
                            model.title1 = "";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 23) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.albion_lighthouse;
                            model.text1 = "";
                            model.title1 = "";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        } else if (holder.getAdapterPosition() == 24) {
                            BeacModel model = new BeacModel();
                            model.title = holder.textView.getText().toString();
                            model.main_image = R.drawable.albion_lighthouse;
                            model.text1 = "";
                            model.title1 = "";
                            model.image1 = R.drawable.map_location;
                            model.text2 = "";
                            model.title2 = "";
                            model.text3 = "";
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
                            com.moutimid.sqlapp.model.DatabaseHelper databaseHelper = new com.moutimid.sqlapp.model.DatabaseHelper(context);
                            databaseHelper.insertBeacModel(model);
                            holder.add.setVisibility(View.GONE);
                            holder.remove.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }

        });


    }

    @Override
    public int getItemCount() {
        return itemName.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView, add, remove;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.title);
            add = itemView.findViewById(R.id.add);
            remove = itemView.findViewById(R.id.remove);
            imageView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (name) {
                case "Central":
                    if (getAdapterPosition() == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.bagatelle_mall_1;
                        model.text1 = "The Bagatelle Mall is a premier shopping destination in Mauritius, offering a myriad of options in the realms of shopping, dining, and entertainment. Located in the Moka area, it opened its doors in September of 2011. Boasting an impressive array of over 150 stores, the mall showcases a harmonious blend of internationally renowned brands such as Mango, Zara, and Lacoste alongside cherished local labels. Additional facilities within the mall include a hypermarket, a gastronomic court, a cinema, and a children's play zone.<br>" +
                                "The culinary offerings at Bagatelle Mall of Mauritius are equally diverse, comprising refined restaurants, charming cafes, and fast-food establishments. The food court, a focal point of gastronomic delight, hosts multiple vendors specializing in a plethora of cuisines. Whether one seeks a quick bite or a more leisurely dining experience, the Bagatelle Mall ensures a gastronomic journey to satiate even the most discerning palates. Revered by both locals and tourists alike, the mall has solidified its status as a cultural landmark in Mauritius.<br>" +
                                "Accessing Bagatelle Mall of Mauritius is easy, facilitated by taxi services, or public transportation. For those opting for a personal vehicle, the mall is strategically positioned along the M1 highway, approximately 10 minutes southward from Port Louis, the capital city. The mall has plenty of parking spaces.  Alternatively, taxis or public transport offer convenient alternatives, with multiple bus routes servicing the area and conveniently located stops in close proximity to the mall.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 1) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.bois_cheri_1;
                        model.text1 = "The Bois Cheri Plantation was established in 1892 and since then has become the largest tea producer in the country. Covering more than 250 hectares, it includes a museum and a factory where visitors can learn all about the art and science of tea.<br>" +
                                "When you visit the tea estate, you can join guided tours to explore the factory, see the museum and plantation, and even try some tea tasting. Your guide will share the history and stories of Bois Chéri and explain how important tea production is for Mauritius.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.bois_cheri_8;
                        model.text2 = "If you enjoy tea and nature, this tour is a must. The plantation is close to the museum and the main factory, surrounded by lush greenery. The peaceful setting provides a perfect backdrop for relaxation.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.bois_cheri_6;
                        model.text4 = "Aside from the beautiful tea plantation, you'll enjoy picturesque views of the South coast on one side and a stunning crater lake on the other. Driving around is delightful, with spots to stop and capture photos of the lake, unique trees, and tea plantations from different angles.";
                        model.title3 = "The factory and Museum";
                        model.text5 = "The museum provides lots of information about Mauritian tea history, showcasing old machines used in tea production, including an old locomotive train. The factory tour allows you to see the tea-making process in action. Bois Cheri produces both green and black tea, with their signature being vanilla tea.";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.bois_cheri_7;
                        model.text9 = "After your museum and factory adventure, it's time for tea tasting. Head to the factory café near the restaurant to try various teas. You can also purchase waffles or pancakes to enjoy with your tea.<br>" +
                                "The Bois Cheri restaurant is within walking distance and offers breathtaking views of the south coast. The restaurant serves unique cuisines, including local flavors. You'll have the chance to taste dishes like shrimps with green tea and chicken with exotic tea. Whether you visit with friends or family, the restaurant and the entire tour offer a delightful experience with delicious food, scenic views, and soothing music.<br>";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.bois_cheri_4;
                        model.text11 = "<b>Visit Hours</b><br>" +
                                " <br>" +
                                "Monday to Friday:<br><br>" +
                                "09.00 - 14.00<br><br>" +
                                "Saturday:<br><br>" +
                                "09.00 - 11.00<br><br>" +
                                "<b>Bois Chéri Tea FactoryOperating Hours</b><br><br>" +
                                "Monday - Friday 09.00 - 14.00 & Saturday 09.00 - 11.00 (closed on Sundays & public holidays)<br> ";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 2) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.eureka_house;
                        model.text1 = "If you're looking to explore an attraction that encapsulates Mauritius' rich colonial history, Eureka is the top choice. This meticulously preserved Creole mansion, constructed in the 1830s, now serves as a museum, offering a captivating journey back in time and unveiling the vibrant plantation history of the island. The main manor house stands as a tropical architectural marvel, renowned for maintaining a refreshingly cool interior during the scorching summers. With an impressive count of 109 doors and more rooms than a Cluedo board, it truly showcases exceptional craftsmanship.";
                        model.title1 = "";
                        model.image1 = R.drawable.eureka_house_3;
                        model.text2 = "Inside, rooms are adorned with a flawlessly conserved collection of period furniture imported by the French East India Company. Noteworthy items include antique maps, a peculiar shower contraption that was considered a luxury 150 years ago, and a weathered piano with keys resembling decaying teeth.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.eureka_house_2;
                        model.text4 = "Venturing into the courtyard behind the main mansion reveals beautifully landscaped grounds encompassed by a series of stone cottages, formerly serving as servants' quarters and a kitchen. Following the trail at the back for 15 minutes leads to the picturesque Ravin waterfall.<br>" +
                                "The estate earned its distinctive name when Eugène Le Clézio successfully secured the house through auction in 1856.<br>";
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
                    } else if (getAdapterPosition() == 3) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.grand_bassin_1;
                        model.text1 = "Grand Bassin, also known as Ganga Talao, is located in the Savanne quiet mountain area. It's a crater lake about 550 meters above sea level. The first group of people to visit Ganga Talao was from the village of Triolet, led by Pandit Giri Gossayne in 1898. This place is sacred to Hindus in Mauritius.<br>" +
                                "The Shiv Mandir is on the lake's bank and is dedicated to Shiva. During Shivaratri, around half a million Hindus in Mauritius go on a pilgrimage to the lake, with many walking barefoot from their homes carrying Kanvars.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.grand_bassin_2;
                        model.text2 = "The name Ganga Talao means \"Lake of Ganga,\" connecting it symbolically to the Indian river Ganga (Ganges).<br>" +
                                "<b>History</b><br>" +
                                "In 1866, Pandit Sanjibonlal returned to Mauritius from India after his first contract and turned Grand Bassin into a pilgrimage place. He converted a building into a temple and brought a Shivalingam from India. <br>" +
                                "In 1897, Jhummon Giri Gosagne Napal, a priest, had a dream about the water of Grand Bassin being part of Ganga. The lake was then known as \"Pari Talao,\" and in 1998, it was declared a \"sacred lake.\" In 1972, Ganga water from the Ganges River was mixed with the lake water, and it was renamed Ganga Talao.<br>" +
                                "<b>Events</b><br>" +
                                "During Maha Shivaratri, devotees start a journey on foot to Grand Bassin, and volunteers offer food and drinks to the pilgrims. The lake hosts a 33-meter-tall statue of Shiva called Mangal Mahadev, inaugurated in 2007. Durga Pooja and Navaratri are celebrated grandly near the statue, and Shiva Ratri is a national holiday celebrated auspiciously by Hindus in Mauritius.<br>";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 4) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.gymkhana_2;
                        model.text1 = "Established in 1844 by the esteemed British Royal Navy, the Gymkhana Club is a testament to the history of golf, ranking as the fourth oldest golf course globally and a distinguished presence in the southern hemisphere. Although comparatively modest in size, this historic course in Vacoas, located at the heart of the island, presents a challenge to golf enthusiasts with its demand for precision and technical prowess.<br>" +
                                "Adorned by century-old trees, the Gymkhana Club looks like a picturesque garden, boasting vibrant hues from bougainvilleas, Gabonese tulips, elms, arocarias, palm trees, and traveler's trees. This unique 18-hole haven is not merely a golf course; it encapsulates an unforgettable experience, steeped in a rich legacy.<br>" +
                                "Acknowledging its historical significance, the Gymkhana Club takes pride in awarding every golfer a certificate, a testament to their participation in a course that has witnessed the sport since its inception in 1844. Despite its relatively compact footprint compared to other Mauritian golf courses, the Gymkhana Club's layout poses challenges that demand precision and skill.<br>" +
                                "While traditionally accessible to Mauritian members, the Gymkhana Club now extends a gracious invitation to golf enthusiasts worldwide. Recognized as the most approachable of the 18 holes, it offers a nominal green fee for non-members and provides a temporary membership solution, ensuring a distinguished golfing experience for all.";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 5) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.le_pouce_1;
                        model.text1 = "Le Pouce is the third highest mountain in Mauritius, soaring to an elevation of 812 meters (2664 feet). Only surpassed in height by Piton de la Petite Rivière Noire (828 m) and Pieter Both (820 m), this mountain derives its name from the distinctive, thumb-shaped apex that graces its summit. It is part of the Moka range which is a dome of basalt lava that is no longer experiencing volcanic activity.";
                        model.title1 = "";
                        model.image1 = R.drawable.le_pouce_2;
                        model.text2 = "This mountain was formerly known as the Mountain of Immortals, a name derived from a plant that persists on its slopes to this very day. Le Pouce Mountain promises an exquisite panorama encompassing Le Morne, Coin de Mire, the capital city, and various other locales strewn across the island. As you climb towards its summit, the mountain unfolds a tapestry of flourishing flora, unveiling exotic specimens and a collection of rare, uniquely indigenous species.It’s worth noting thaton the 2nd of May 1836, Charles Darwin ascended this majestic mountain.";
                        model.title2 = "Trails";
                        model.text3 = "";
                        model.image2 = R.drawable.le_pouce_3;
                        model.text4 = "There are two hiking trails to climb Le Pouce: one from the north side, starting in Port Louis, and the other from the south side, starting in Moka.<br>" +
                                "The southern route, widely embraced by tourists and locals alike, follows a conventional path, starting at a higher elevation and covering less than half the distance of its northern counterpart. While the north route provides superior views, more shaded sections, and a more gradual ascent, it entails a significantly longer journey. <br>" +
                                "<b>Southern Route</b><br>" +
                                "Type of Trail: Out and Back/Through Hike<br>" +
                                "Start Point: Moka Trailhead<br>" +
                                "End Point: Summit<br>" +
                                "Length: 1.4 miles one way<br>" +
                                "Duration: 2 hours one way<br>" +
                                "Lowest Point: 1514 feet<br>" +
                                "Highest Point: 2587 feet<br>" +
                                "Total Elevation Gain: 1165 feet<br>" +
                                "Drive towards the foot of the mountain from Moka, turning off the main road where a Le Pouce sign directs you onto a meandering road through the sugarcane fields. Once you reach the foot of the mountain, proceed along the dirt road towards Le Pouce, following the well-trodden trail that zigzags up the mountainside. As you climb, you'll hike through an open, grassy expanse. Continue along any trail leading towards the summit.<br>" +
                                "The final leg, where you climb \"the thumb,\" presents a relatively steep climb for both approaches, requiring some manual assistance in places. Caution is advised, especially in inclement weather.<br>" +
                                "<b>Northern Route:</b><br>" +
                                "Type of Trail: Out and Back/Through Hike<br>" +
                                "Start Point: Trailhead in Tranquebar<br>" +
                                "End Point: Summit<br>" +
                                "Length: 3.9 miles one way<br>" +
                                "Duration:6 hours one way<br>" +
                                "Lowest Point: 273 feet<br>" +
                                "Highest Point: 2656 feet<br>" +
                                "Total Elevation Gain: 2690 feet<br>" +
                                "Embark on the northern route from the trailhead where Chateau D’eau Street ends. Follow the primary road, gradually climbing toward Le Pouce. Blue and white markings on stones guide the way, ensuring navigation is straightforward. Stay left at various forks along the main road, passing temples and mango trees until you encounter a sign bank on your left. At this point, the trail turns left, narrows, and becomes steeper.<br>" +
                                "The trail will eventually come to a more open, less steep area. Proceed down the main path. Do not follow the one notable fork to the left that crosses a stream. As you approach closer to Le Pouce, the route splits off again, but all of them lead to the summit and eventually converge.<br>" +
                                "The last section, where you climb \"the thumb,\" presents a similar challenge for both routes, demanding manual assistance in certain sections and warranting caution during inclement weather.<br>";
                        model.title3 = "Practical Information";
                        model.text5 = "<b>What to bring: </b>bottled water, food, clothing and appropriate footwear, sunscreen, insect repellent, and a first aid kit<br>" +
                                "<b>Other Tips:</b><br>" +
                                "•\tCarry your trash with you. Avoid leaving trash behind.<br>" +
                                "•\tDon't stray from the trails and don't split up with your group.<br>" +
                                "•\tFor your own safety, avoid feeding untamed animals.<br>" +
                                "•\tDon't harm other plants or trees.<br>";
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
                    } else if (getAdapterPosition() == 6) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.pieter_both_1;
                        model.text1 = "The Pieter Both is one among the most well-known and iconic locations in Mauritius. Postcards from Mauritius frequently include images of its spectacular beauty. Thousands of nature enthusiasts go to the Pieter Both Mountain for its breathtaking views and hiking adventures.An interesting fact is that the palm species Hyophorbe amaricaulis, once a ubiquitous sight on this mountain, is now the world's rarest palmas of 2023 due to a decline in propagation.<br>" +
                                "One of Mauritius' most recognizable mountains, the Pieter Both is visible from practically every south-west and central-northhighways.Itis the second highest mountain in Mauritius standing at 820 meters (2,690 feet). Shorter than Piton de la Petite Rivière Noire by eight meters, this mountain got its name from Pieter Both, the Governor-General of the Dutch East Indies. It is part of the Moka Range and distinguishes itself with a notable feature: a colossal rock formation crowning its summit, evoking the semblance of a human head.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.pieter_both_2;
                        model.text2 = "Indeed, there is a well-known local mythology associated with this rock. There are rumors that a milkman from Crève Coeur, a village at the base of the mountain, used to sell milk in La Laura and the neighboring communities. He decided one day to go to the next village by using the Pieter Both route shortcut. Feeling tired from his trek, he took a short break to rest. Soon he felt asleep only to be awaked later by the sound of a lovely music.His eyes opened to the sight of mesmerizing fairies singing and dancing. When the fairies realized they were being watched by a mortal, theycursedthe milkman he would turn into a stone if he ever told anyone about what he had seen. Still mesmerized by what he saw and overwhelmed by his experience, he forgot his oath and revealed his encounter with the fairies tohis friends.When themilkman came to the same spotthe following day, the fairies already knew the milkman had not kept the secret. Furious, the fairies transformed him into stone. Severed from his body, the milkman’s head grew larger and transposed onto the summit of the mountain. According to the legend, the milkman's head turned into rock is the one atop the mountain.<br>" +
                                "Folklore aside, the Pieter Both is also well-known for its hiking trails. Hikers of all skill levels can tackle the mountain hike, which ranges from moderately tough to extremely challenging. It is advised that hikers, whether novice or expert, wear helmets, ropes, and harnesses. Guided hiking trips up the Pieter Both can also be arranged through these agencies.<br>" +
                                "The starting point of your climbing journey is in the La Laura village at the base of a mountain. It takes roughly one hour to climb the first 600–650 meters. The climb is moderately demanding and appropriate for hikers with average physical and health conditions. <br>";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.pieter_both_3;
                        model.text4 = "If you're the daring type and want to try the unbatteredpath, carry on with the hike.  You will need goodrock-climbingtechniques to get to the mountain's neck. Although climbers still find assistance from the iron rungs set into the rock years ago by the Royal Navy and Special Mobile Force, it is safer to use ropes to climb your way up.<br>" +
                                "Want a more adventurous and challenging route up to the mountain's summit? No problem, there is something available for the brave ones as well. All you will need is some confidence and efforts on your part to climb the nine-meter-diameter boulder. Be aware that climbing the boulder is the hardest part due to the upward steepness.<br>" +
                                "If you choose to climb the mountain in the summer, bring with you water, a hat, sunglass, and sunscreen lotion. Exercise caution when hiking after a rainy day as the walkways become quite slippery.<br>" +
                                "The palm species Hyophorbe amaricaulis, once a ubiquitous sight on this mountain, is now the world's rarest palmas of 2023 due to a decline in propagation.<br>";
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
                    } else if (getAdapterPosition() == 7) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.tamarin_falls_1;
                        model.text1 = "The Tamarind Falls is a picturesque waterfalllocated in the southwestern region of Mauritius. Nestled along the Rivière Tamarin river near the village of Henrietta, these falls boast seven successive tiers of cascades.";
                        model.title1 = "";

                        model.image1 = R.drawable.tamarin_falls_2;
                        model.text2 = "<br>" +
                                "The main waterfall of the Tamarind Falls has an impressive height of 293 meters (961 feet), making it one of the highest waterfalls on the island. Thanks to the lush and diverse flora surrounding the waterfall, the area is one of the most picturesque and serene places in Mauritius. Nature and animal lovers will be delighted to discovermany exotic plants and birds populating the area.<br>" +
                                "Reaching the waterfalls can be a bit challenging though.Indeed, it takes nearly a full day of hiking to access this unspoiled natural marvel. The trail winds its way through the forest and includes a stretch across an open area on the basalt rockwhich is a clear sign you are in the vicinity of the Tamarind falls.<br>" +
                                "Once you reach the waterfall, you can take a well-deserved break and cool off in the basin. Alternatively, you can continue onward to climb to the top of the falls. As you climb up, you will come across a series of small pools and when you reach the top of the waterfall you will be rewarded bythespectacularpanorama of the lush green canyon unfolding in front of your eyes.<br>";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 8) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.trou_aux_cerfs_4;
                        model.text1 = "The Trou aux Cerfs crater is surrounded by a vast expanse of lush forest home toindigenous plant species and some enormous green pine trees. It is thought to have erupted once and been inactive for the past 700 000 years, although scientists believe there may be a chance for it to erupt again.<br>" +
                                "Undoubtedly, one of its main attractions is the panoramic 360-degree view encompassing the town of Curepipe, along with stunning views of Rempart Mountain, Trois Mamelles, and the PortLouis-Moka mountain range.<br>" +
                                "This lush and green verdant sanctuary serves as a favored jogging locale for the locals. Evolving into a social gathering place, it regularly attracts joggers every at around five o’clock in the morning. A gazebo provides a pleasant spot to sit, relax, and appreciate the unparalleled natural beauty. Due to the surrounding woods and elevation, it can become slightly chilly, so it is advisable to bring along a light sweater or shawl.<br>" +
                                "There are three primary access points to Trou aux Cerfs, specifically the La Hausse de la Louviere Road, the Edgar Huges Road, and the Crater Lane. Parking facilities are available.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";
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
                    }
                    break;
                case "South":
                    if (getAdapterPosition() == 0) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.gris_gris_coastal_4;
                        model.text1 = "This enchanting havendistinguishes itself by the absence of a coral barrier reef, making it truly unique. The ocean waves vigorously crash against the shoreline, providing captivating vistas for visitors. Gris Gris beach stands in stark contrast to other tranquil and calm beaches in Mauritius, known for their coral reef protection. The island's typical coral reef barrier contributes to calmer ocean waves and shallow beach waters, creating ideal swimming conditions. However, Gris Gris, surprisingly, lacks this barrier reef.";

                        model.title1 = "";
                        model.image1 = R.drawable.gris_gris_3;
                        model.text2 = "A visit to Gris Gris is an absolute essential for anyone exploring Mauritius. The beach's beauty is awe-inspiring, with towering cliffs descending toward the ocean, where turbulent waves crash against rocks, creating a striking white froth accompanied by a resounding crash. Located at the southernmost point of of Mauritius, a few kilometers southeast of the village of Souillac, Gris Gris boasts a unique history dating back to the French colonial era.<br>" +
                                "The name \"Gris Gris\" adds an intriguing dimension to the experience. Upon entering the beach, a large sign displays the history behind the name. According to local tradition, \"Gris Gris\" is linked to the African amulet known as the “Gris Gris” and its association with the tumultuous coastline. However, the story takes an unexpected turn, suggesting that Gris Gris might have been the name of a puppy belonging to a French cartographer who visited the coast in 1753.<br>";
                        model.title2 = "Gris Gris Beach";
                        model.text3 = "";
                        model.image2 = R.drawable.gris_gris_1;
                        model.text4 = "The primary beach area features an expansive green field with a commanding view of dramatic cliffs and enormous waves. There are benches and a pavilion available for relaxation while taking in the scenery.<br>" +
                                "To the left, a concrete staircase descends to the beach, but swimming is strongly discouraged due to the high danger level. The powerful waves can swiftly overwhelm swimmers. Instead, enjoy a leisurely stroll along the beach, heading toward a small cave at the far end.<br>";
                        model.title3 = "Caves at Gris Gris";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.grisgris_2;
                        model.text9 = "In addition to the cave on the far left side of the beach, two other hidden caves can be discovered at Gris Gris. These are more challenging to reach, involving a descent down a cliff and walking through the water.<br>" +
                                "Caution is advised against going all the way down, as water levels can fluctuate unpredictably, and the current is often too strong.<br>" +
                                "For those eager to explore the secret caves at Gris Gris, head towards the cliff's edge directly across from the parking lot. Upon reaching the spot, descend only about halfway to catch a glimpse of the caves on your right.<br>" +
                                "It's important to bear in mind that entering the caves could pose risks if the water level rises!<br>" +
                                "Gris Gris beach is intricately connected to the village of Souillac, which relies heavily on tourism for its revenue. Established 200 years ago as a port for ships sailing from Europe to India, Souillac has a rich history worth exploring. Plan your day strategically to make the most of your visit to the southern part of Mauritius, and consider including a visit to Rochester Falls, just outside the village, renowned for its distinctive rectangular-sided rocks.<br>";

                        model.title8 = "La Roche qui Pleure";
                        model.text10 = "";
                        model.image4 = R.drawable.la_roche_qui_pleure;
                        model.text11 = "This mystical site derives its name from the visual impression it creates: as water trickles down its walls, the cliffs appear to shed tears. Even more astonishing, some claim to recognize the eroded features of the Mauritian poet Robert Edward Hart.<br>" +
                                "From a geographical and climatic standpoint, unlike other parts of the island, La Roche qui Pleure lacks coral reefs. Consequently, its shores are more exposed to the assaults of the ocean. This absence of a natural barrier results in more powerful and spectacular waves, a stark contrast to the tranquil lagoons typically associated with the island. The region is influenced by strong winds and seasonal variations, shaping its unique landscape and marine dynamics.<br>";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 1) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.rochester_falls_1;
                        model.text1 = "Although Rochester Falls may not rank as the most breathtaking waterfalls in the country, they are undeniably worth exploring if you find yourself nearby. Simply follow the makeshift signs guiding you from the main road through Souillac. The route, while a bit intricate, is reliable, albeit a tad rough along the stony track. Be prepared for local vendors who might expect a tip for assisting you in finding a parking spot. Following a brief five-minute walk from your vehicle, you'll arrive at the cascading waterfall emerging from the cane fields.<br>" +
                                "Situated in the southern part of the island, within the Souillac district, Rochester Falls exemplifies the distinctive volcanic formations and the historical background of Mauritius as a volcanic island. What sets this waterfall apart is its unique appearance, with water flowing through rock formations that resemble square blocks, creating a captivating illusion unlike any other waterfall on the island.<br>" +
                                "Popular among both locals and visitors, the falls offer a serene pond for swimming, tucked away in a lush, untamed forest, providing a peaceful escape from the hustle and bustle of civilization. This secluded setting makes it an ideal location for a day out with friends, emphasizing the appeal of nature's untouched beauty. <br>";

                        model.title1 = "A few tips";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "1.\tNot recommended to visit during or after heavy rainfall.<br>" +
                                "2.\tExercise caution if engaging in cliff jumping, as surfaces may be slippery.<br>";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 2) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.bel_ombre_1;
                        model.text1 = "Bel Ombre is more than just a beautiful beach destination; it's a haven of untouched nature, where the air is filled with the melody of chirping birds and the surroundings boast lush greenery, majestic mountain views, and hidden waterfalls. The Bel Ombre Nature Reserve, protected by the Mauritian Wildlife Foundation, resembles a magical Garden of Eden, promoting sustainability and effective environmental management. The reserve, spanning 1,300 hectares in the Domaine de Bel Ombre, invites visitors to engage with nature through activities like quad biking, trekking, Segway tours, and 4x4 discovery tours.";
                        model.title1 = "";
                        model.image1 = R.drawable.bel_ombre_11;
                        model.text2 = "Nestled between the Indian Ocean's blue expanse and the emerald green endemic forests of the South, the Bel Ombre Nature Reserve is a treasure trove of Mauritian biodiversity. The mountainous landscape offers breathtaking views, plains where stags gracefully roam, impressive waterfalls, and unspoiled natural beauty. Various activities, including quad biking, 4x4 discovery tours, trekking, kids' tours, and Segway rides, provide opportunities to explore this enchanting reserve.<br>";
                        model.title2 = "";
                        model.text3 = "Highlights of the activities include:<br>" +
                                "1.\t4x4 Excursion – A journey through the diverse flora and fauna, with a stop at the picturesque l'Example waterfall.<br>";
                        model.image2 = R.drawable.bel_ombre_6;
                        model.text4 = "2.\tQuad & Buggy – An adventurous exploration of the reserve's natural wonders, including a refreshing stop at a waterfall for a swim.";
                        model.title3 = "";
                        model.text5 = "3. xcb\tKids Discovery Tour – Specially designed for young adventurers, featuring a drive through sugarcane fields and a freshwater fishing trip.<br>" + "4.\tTrekking Exploration – A nature walk starting at the Old Chimney, leading through the river reserve to a waterfall with a natural rock pool for a refreshing dip.<br>";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.bel_ombre_12;
                        model.text9 = "5.\tSegway Ride – An easy exploration of the Domaine's magnificent scenery during a 45-minute ride, covering key landmarks.<br>" +
                                "The Segway ride's itinerary includes the welcome center of Frederica, Heritage Golf Club, C Beach Club, Heritage Le Telfair Golf and Spa Resort, Place du Moulin, Le Château de Bel Ombre, and back to the welcome center.<br>";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.map_location;
                        model.text11 = "";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 3) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.valle_des_couleurs;
                        model.text1 = "The southern region of Mauritius is adorned by the 450-acre natural reserve known as La Vallée Des Couleurs. It is a picturesque haven, allowing visitors to escape the worries of the world and immerse themselves in the refreshing air amidst extraordinary views of nature. Located in Mare Anguilles, Chamouny, the reserve is open every day from 9 am to 5:30 pm.<br>" +
                                "La Vallée des Couleurs offers a myriad of exciting activities, creating a memorable experience for all. Explore the charming animal farm, savor delicious cuisines while surrounded by grazing deer and a waterfall, and partake in activities such as trekking, luge karting, Nepalese bridge rides, quad bike tours, ziplining, and witness the mesmerizing 23-colored earth.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.valle_des_couleurs_2;
                        model.text2 = "The park offers panoramic views of the sea amid lovely greenery. Notable activities and attractions include trekking, mountain luge karting, Nepalese bridge walks, ziplining, quad biking, and visits to the animal farm and restaurants.<br>" +
                                "La Vallée des Couleurs is designed for both adventure seekers and those seeking tranquility. Major attractions are within a 15-minute walk, and additional options include buggy or quad bike rides for a quick park exploration. The highlight is the 23-colored earth visible during the quad bike ride.<br>";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.valle_des_couleurs_17;
                        model.text4 = "The park engages all senses, from the visual delight of the iconic 23-colored land to the sounds of birds and waterfalls, the fragrance of wet tree trunks, the taste of delicious cuisine, and the unique experience of ziplining. Trekking through the park provides a two-hour journey with thrilling activities and breathtaking views, culminating at a waterfall.";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.valle_des_couleurs_5;
                        model.text9 = "Mountain luge karting offers a thrilling experience on a 700m track, while the Nepalese Bridge, a 350m footbridge, provides an adrenaline rush with panoramic views. Ziplining features seven lines, including the longest one stretching over 1.5 km, offering a bird's-eye view of the park.";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.valle_des_couleurs_12;
                        model.text11 = "<br>" +
                                "Quad biking and buggy rides delve into the tropical forest, interacting with wildlife and reaching the 23-colored land, rich in minerals from volcanic eruptions. The park also houses an animal farm with tortoises, chickens, and deer.<br>";
                        model.image5 = R.drawable.vallee_des_couleurs_1;
                        model.text12 = "Various eateries serve delectable cuisine around the waterfalls, including an Indian restaurant providing Subcontinent and French cuisines. La Vallée des Couleurs ensures a captivating experience for visitors of all ages, combining adventure, wildlife, and natural beauty.";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 4) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.blue_bay;
                        model.text1 = "Located in the southeast of the island, Blue Bay was designated a national park in 1997 and later recognized as a wetland site under the Ramsar Convention on Wetlands of International Importance in 2008. The marine park is renowned for its coral garden, housing a diverse array of corals and abundant fauna. Close to the coastline, it offers ideal conditions for snorkeling, boasting rich biodiversity and calm, shallow seawater.";
                        model.title1 = "";
                        model.image1 = R.drawable.blue_bay_4;
                        model.text2 = "Upon setting foot on Blue Bay beach, you will bump intohawkers selling artisanal jewelry and canvassers promoting glass-bottom boat trips or snorkeling outings. Over fifteen operators are permitted to engage in commercial activities within the Blue Bay Marine Park.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.blue_bay_2;
                        model.text4 = "<br>" +
                                "The main attraction in the Marine Park is a more than 1,000-year-old brain coral with a 5-meter diameter, making it the region's primary tourist attraction. The coral garden near Mahebourg, a small coastal village in the south-east, boasts a remarkable surface area and biodiversity. Visitors often come to witness the ancient brain coral, and various activities, such as glass-bottom boat trips, offer different perspectives of the vibrant marine life.<br>" +
                                "Most operators in Blue Bay Marine Park are descendants of local fishermen turned to tourism. Glass-bottom boat trips are accessible to all, providing a serene experience to explore the beauty of the park. Those seeking a closer encounter can embark on a boat and snorkel, enjoying the vibrant underwater life in warm and clear waters.<br>" +
                                "The Marine Park covers 353 hectares and is a popular leisure area for tourists and locals, sustaining numerous households through various activities. Measures have been implemented to balance economic activity with sustainable development, including the installation of permanent mooring buoys to demarcate conservation areas and regulated zones for fishing, boat traffic, swimming, and waterskiing. These measures aim to protect the marine fauna and flora, preserve biodiversity, promote scientific research, and educate the public.<br>";
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
                        model.text11 = "•\t<b>Unique Classification in Mauritius:</b> Designated a Marine Park under the Wildlife and National Parks Act 1993, a protected zone in 2000 under the Fisheries and Marine Act 1998 and recognized as a Ramsar Convention site in 2008. Mooring buoys are strategically placed to minimize damage to corals by boat anchors";
                        model.image5 = R.drawable.blue_bay_8;
                        model.text12 = "•\t<b>Outdoor Activities Available to All:</b> Glass-bottom boat trips and snorkeling are popular activities, allowing non-swimmers to explore the marine environment through the glass bottom. Snorkeling conditions are ideal, and Coco Island, visible from the beach, serves as a relaxing spot for snorkelers under casuarina trees. Operators provide drop-off and pick-up services.";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 5) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.mahebourg;
                        model.text1 = "Nestled in the heart of the traditional Mauritian Village, the newly developed Mahebourg Waterfront offers an idyllic setting for a leisurely stroll and a captivating journey into local Mauritian history. Take the opportunity to explore the naval museum and delve into the details of the epic battle that unfolded in this region. The Bataille de le Passe memorial stands as a poignant tribute to the brave fighters who sacrificed their lives in that historic battle.";
                        model.title1 = "";
                        model.image1 = R.drawable.mahebourg_5;
                        model.text2 = "Conveniently situated behind the bus station, the iconic Sir Gaetan Duval Esplanade is a prominent feature of the Mahebourg Waterfront. This locale is perfect for enthusiasts of seaside walks, offering an enchanting experience amidst the beauty of nature and breathtaking sea views.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.mahebourg_waterfront_1;
                        model.text4 = "Immerse yourself in the rich history of the Grand Port battle, a pivotal event that has left an indelible mark on our heritage. Don't overlook the captivating sight of the 'Mouchoir Rouge' island at the quay's end – a truly mesmerizing view.";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.mahebourg_3;
                        model.text9 = "Facing the Mahebourg Waterfront is the bustling local market of Mahebourg, a vibrant hub filled with delectable street food, local treats, and fresh vegetables. Take a detour to indulge in some essential shopping. While the Mahebourg Waterfront is a popular weekend destination for locals, attracting picnickers and those seeking casual relaxation, we recommend visiting during the week to avoid the crowds.";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.map_location;
                        model.text11 = "";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 6) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.mahebourg_museum_2;
                        model.text1 = "Nestled in the enchanting Southeast of Mauritius, the National History Museum in Mahebourg is a captivating attraction. Imagine encountering the rare and nearly complete skeleton of the dodo, along with naval artifacts and posters vividly illustrating life during colonial times. Housed in a vintage 'old world' mansion, this museum is not only charming but is also designated as a National Heritage Site.<br>" +
                                "Known as Gheude Castle, this charming residence was constructed at the close of the 18th century and originally belonged to the de Robillard family. Mr. Jean de Robillard, the district commander of Grand Port, was its first owner. Over the years, the house was inhabited by various significant French settlers before being acquired by the Mauritius government in 1947. The transformation of this colonial mansion into a Naval and Historical Museum culminated in the inauguration of the Dutch Section by the descendant of Maurits Van Nassau, after whom Mauritius was named in 1598.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.mahebourg_museum_5;
                        model.text2 = "Within the 12-acre garden surrounding the museum, visitors are treated to a reproduction of quaint village houses. The museum's collection includes salvaged items from naval battles, a rare dodo skeleton, maps, old coins, and furniture. Explore the weaponry used by the corsair Robert Surcouf and marvel at the bell retrieved from the wreck of the Saint Geran, which sank off the East coast in the 18th century.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.mahebourg_6;
                        model.text4 = "The cannon displayed in front of the museum originates from the British frigate named La Magicienne and faces the entrance from the main road leading to the village of Mahebourg. As you ascend to the first floor, discover a four-poster bed that once belonged to Mahe de Labourdonnais, the first French governor of Mauritius. The museum also showcases palanquins carried by slaves, highlighting a regal era.";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.mahebourg_museum_4;
                        model.text9 = "A remarkable historical note reveals that during a naval battle in August 1810 at nearby Vieux Grand Port, both the British and French commanders, Sir Nesbit Willoughby and Baron Victor Duperre, were injured and cared for in the same wing of the maritime museum. This battle is notably the only naval victory for the French, commemorated at the Arc de Triomphe in Paris.<br>" +
                                "Located off the main road, a mere 10-minute drive from the airport, the Mahebourg Naval Museum can be visited from Monday to Saturday, 09:00 to 16:00, and on Sundays from 09:00 to 12:00. Admission is free, making it a must-visit destination in the Southeast. Please note that interior photography is prohibited, ensuring an immersive experience during your visit to this delightful museum.<br>";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.map_location;
                        model.text11 = "";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 7) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.ile_aux_fouquets;
                        model.text1 = "Île aux Fouquets, also known as Île au Phare or Lighthouse Island, is located off the southeastern shoreline of Mauritius.\n" +
                                "This coral-origin island has held the status of Islet National Park since June 5, 2004. Located approximately five kilometers off the southeastern coast, near Ilot Vacoas and Île de la Passe, it lies south of the islands, marking the sole opening in the coral reef through which larger vessels can navigate. Occupying an area of 2.49 hectares, Île aux Fouquets derived its name from a species of tern known as \"fouquet,\" named by local fishermen, as documented by the German zoologist Karl August Möbius.\n" +
                                "Around 1694, a group of Huguenot refugees, led by the Frenchman François Leguat, resided on Île aux Fouquets for several years. Previously attempting to establish a Protestant republic called Eden on Rodrigues Island, 580 kilometers to the east, they abandoned the project due to loneliness and sailed to Mauritius on a self-constructed barge without anchor or compass. Despite safely reaching Mauritius, they found themselves in conflict with the Dutch governor, resulting in their exile to the treeless Île aux Fouquets. Only years later were they transported from there to the island of Java.\n" +
                                "In 1810, near Île aux Fouquets, the naval Battle of Grand Port occurred, resulting in a French victory. Over fifty years later, well after the British had conquered Mauritius, a lighthouse was erected on the island in 1864. While the structure is now a ruin, it holds the designation of a listed building. Île aux Fouquets provides panoramic views of neighboring islands, the coastline, and the prominent Lion Mountain.";
                        model.title1 = "Ile aux Fouqets Lighthouse";
                        model.image1 = R.drawable.ile_aux_fouqets_3;
                        model.text2 = "Erected in 1864, this lighthouse served as a guide for ships navigating towards the Mahébourg harbor. Initially, Mahébourg was the primary French settlement and retained its significance as a crucial port until the early 20th century. During this period, the British shifted all port activities to Port Louis on the opposite side of the island. Consequently, as port operations relocated, the light station was left abandoned and gradually fell into a state of disrepair.\n" +
                                "Located alongside Ile de la Passe and Ile aux Vacoas, Ile aux Fouquets, also known as Ile aux Phare, constitutes the second island in the chain. Unlike its counterparts, this island features relatively hilly terrain, crowned by the remnants of the lighthouse from which it draws its name.\n" +
                                "Regrettably, efforts to restore this lighthouse have not been undertaken, and the metallic components of its once-shining orb are now scattered across its vicinity. Despite its dilapidated state, the ruins offer shade from the sun and shelter from the wind, making Ile aux Phare a preferred picnic spot for local residents and fishermen. Behind the lighthouse, on the steep incline, a colony of tropical birds has made its nesting grounds.\n" +
                                "Accessible solely by boat, the islets offer a distant view from the mainland. \n";
                        model.title2 = "";
                        model.text3 = "";
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
                    }

else if (getAdapterPosition() == 8) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.ile_aux_aigrettes_1;
                        model.text1 = "Located off the southeastern coast of Mauritius, Ile aux Aigrettes serves as both a nature reserve and a scientific research station, drawing visitors that include both tourists and Mauritians.<br>" +
                                "Geographically, it spans 27 hectares (67 acres) and is the largest islet in the Grand Port bay, situated 850 meters (2,790 ft) from the southeast coast of Mauritius and approximately a kilometer (0.62 mi) from the coastal town of Mahebourg. Characterized by its low-lying terrain, the islet is composed of coral-limestone, in contrast to the volcanic rock predominant in the majority of Mauritius.<br>" +
                                "<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.ile_aux_aigrettes_4;
                        model.text2 = "Functioning as a nature reserve and conservation area, Ile aux Aigrettes safeguards the world's sole remaining fragment of the \"Mauritius Dry Coastal Forest,\" once a flourishing vegetation type. Consequently, it hosts a significant population of highly rare or endangered plant and animal species.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.pink_pigeon;
                        model.text4 = "Historically, extensive logging and invasive species decimated indigenous flora and fauna over several centuries, mirroring the plight of the rest of Mauritius. The extinction of the Dodo and the native giant tortoise, along with numerous plant species, was a shared fate. Despite these challenges, remnants of certain species endured. In 1965, the islet earned designation as a nature reserve, prompting dedicated efforts to restore vegetation and preserve the remaining indigenous animal species. Furthermore, various species, previously absent from the island but surviving elsewhere in Mauritius, were reintroduced.";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.ile_aux_aigrettes_3;
                        model.text9 = "<br>" +
                                "Reptile species on the islet include the Telfairs Skink, a large and slow-moving reptile, various ornately colored day geckos, and a population of non-indigenous Aldabra giant tortoises. Introduced to Île aux Aigrettes, these giant tortoises play a vital ecological role, replicating the function of the extinct Mauritian tortoises by consuming and dispersing plant seeds, facilitating natural forest rejuvenation.<br>";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.ile_aux_aigrettes_2;
                        model.text11 = "The rare and endemic ebony tree species, Diospyros egrettarum, derives its name from this island, where it thrives abundantly.";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    }


                    break;
                case "East":
                    if (getAdapterPosition() == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.ferney_1;
                        model.text1 = "Located in the Bambou mountains north of Mahébourg in Grand Port District, La Vallée de Ferney, is a forest and wildlife reserve managed by the La Vallée de Ferney Conservation Trust. Established in 2006, the 200-hectare natural area serves as a conservation trust in collaboration with the Mauritian Wildlife Foundation (MWF) and local authorities, focusing on the restoration of indigenous forests.";
                        model.title1 = "";
                        model.image1 = R.drawable.ferney_3;
                        model.text2 = "The valley gained attention in 2004 when a proposed highway threatened the local flora and fauna. Surveys revealed new and presumed extinct species, leading to successful local action diverting the highway. Situated north of Mahébourg, La Vallée de Ferney boasts Tertiary volcanic soils and a humid climate, making it one of the last nature refuges on the island.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.ferney_4;
                        model.text4 = "The reserve offers hiking circuits through indigenous forests, guided tours, a stone museum depicting the area's history, gardens with useful plants, a restaurant, and a visitor’s complex. Giant tortoises and a nursery for endemic plants are also present. The biodiversity of La Vallée de Ferney includes endangered plant species and protected animals like the Mauritius kestrel and Mauritian flying fox.";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.ferney_conservation_park_1;
                        model.text9 = "With less than 2% of Mauritius' indigenous ecosystems intact, future projects at La Vallée de Ferney focus on large-scale propagation of indigenous plants, weeding out invasive species, and reintroducing endangered birds like the pink pigeon and echo parakeet. The reserve collaborates with la Vallée de l'Est, another conservation area, to protect an additional 70 hectares of rare highland forest.";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.map_location;
                        model.text11 = "";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 1) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.frederik_hendrik_museum_1;
                        model.text1 = "The Vieux Grand Port Heritage site is on the South East coast, about 4km North of Mahebourg/Pointe d’Esny. The Dutch picked this spot at the foot of Lion Mountain, 7 meters above sea level, with a great view of the bay.";
                        model.title1 = "";
                        model.image1 = R.drawable.frederik_hendrik_museum_5;
                        model.text2 = "Here are some interesting facts about the Old Grand Port Heritage Site:<br>" +
                                "•\tIt has the first Dutch East India Company 'VOC' fort in the eastern hemisphere.<br>" +
                                "•\tIt's the initial Dutch Fort built to defend against the sea.<br>" +
                                "•\tIt experienced the first slave rebellion, where slaves set fire to the wooden fort.<br>" +
                                "•\tSlaves influenced the architecture, leading to forts being built with stones for safety.<br>" +
                                "In 1658, Dutch commander Cornelius Gooyer and his crew of 25 men built a small wooden fort shaped like a four-pointed star. Life was tough in Mauritius, with frequent attacks and fires by slaves, cyclones damaging the fort, and crops eaten by rodents. In 1694, one fire destroyed the fort, so the Dutch built a stone fort a few years later.<br>";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.frederik_hendrik_museum_4;
                        model.text4 = "The Dutch left Mauritius in 1710, destroying the site before leaving, with only the stone lodge left standing. You can still see the stone jetty below the fort in the lagoon.<br>" +
                                "Later, the French settled in Mauritius and used the stone lodge as their administration center. They turned the site into a military outpost to protect Vieux Grand Port Bay. In 1806, the outpost moved to the newly built town of Mahebourg.<br>" +
                                "Remnants of the powder/storehouse, prison, bakery, and workshop from the French period are on top of the Dutch ruins.<br>" +
                                "In 1998, the Old Grand Port Heritage site was renovated to celebrate the 400th anniversary of the first Dutch landing in Mauritius. The site was inaugurated by the descendant of Maurits van Nassau, after whom Mauritius was named.<br>" +
                                "The Frederik Hendrik Museum was built alongside the fort and opened in 1999. It houses memorabilia found during archaeological excavations, with a permanent exhibition in the main hall displaying old maps, military objects, potteries, cooking utensils, beads, coins, and more.<br>";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.frederik_hendrik_museum_2;
                        model.text9 = "On your way to the cultural site, check out the monument commemorating the first Dutch landing on 20th September 1598. The sailors were led by Admiral Wybrand Warwick, and you can see the Lion Mountain on the left.<br>" +
                                "Address: The Old Grand Port Heritage site is on the South East coast, a 15-minute drive from the airport, and 4 km North of Mahebourg/Pointe d’Esny.<br>" +
                                "The Frederik Hendrik Museum: Royal Road Old Grand Port Mauritius<br>" +
                                "Visiting hours: <br>" +
                                "Monday, Tuesday, Thursday, Friday, Saturday: 09h00 to 16h00 <br>" +
                                "Wednesday: 11h00 to 16h00 <br>" +
                                "Sunday: 09h00 to 12h00 <br>" +
                                "The cultural heritage site is closed on public holidays.<br>" +
                                "The entrance is free.<br>" +
                                "Nearby attractions include Ile aux Aigrettes Nature Reserve, where you can explore Mauritius before the arrival of humans, and the historical Mahebourg Museum building. These are three must-do activities when you are in the Grand Port area.<br>";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.map_location;
                        model.text11 = "";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 2) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.belle_mare_1;
                        model.text1 = "The Belle Mare Beach is located near the town of Mahebourg on the Southeast coast of Mauritius, spanning between the villages Belle Mare and Pointe de Flacq. Sheltered from the big waves by the coral reef, this crescent-shaped beach has a parking area and a shaded rest area under the filaos trees. It is quite wide with parts of fine, dazzling white sand. The water is transparent and calm, and the lagoon has a most magnificent turquoise blue color. In this realm, unspoiled nature prevails, with minimal development except for a few scatteringhotels and exclusive villas.";
                        model.title1 = "";
                        model.image1 = R.drawable.belle_mare_3;
                        model.text2 = "Renowned among holidaymakers as the epitome of beauty, the Belle Mare Beach is cherished not only by visitors but also by the island's residents who frequent the beach, particularly on weekends and holidays. This enclave retains an authentic charm, preserving the island's essence amidst the rapid development witnessed by other coastal cities, notably Grand Bay, Flic en Flac, and Black River.<br>" +
                                "The Belle Mare Beach is an idyllic destination for swimming and diving, particularly on weekdays when the serene ambiance prevails. It offers an ideal retreat for nature enthusiasts, allowing them to relish miles of sandy expanse for sunbathing.<br>" +
                                "The optimal times to visit the Belle Mare Beach are during the early morning hours from 7:00 to 11:00 or in the afternoon from 13:00 to 17:00.<br>" +
                                "Engage in an array of activities at Belle Mare Beach, including pedalo rides, windsurfing, catamaran journeys, horseback riding, parasailing, scuba diving, speed boat excursions, and kayaking.<br>";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 3) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.poste_lafayette_1;
                        model.text1 = "This unspoiled beach, often overlooked due to its turbulent sea, offers a rare opportunity to embrace tranquility and serenity. With its authentically rustic and untouched nature, this charming locale continually captivates nature enthusiasts. The preserved green habitat is a sanctuary for massive coral reefs, fostering rich marine biodiversity and mangroves.";
                        model.title1 = "";
                        model.image1 = R.drawable.poste_lafayette_2;
                        model.text2 = "Those seeking a peaceful picnic will be pleased that the southern part of the beach provides a serene retreat. Additionally, the southern beach serves as an ideal starting point for a trek leading north of Poste Lafayette, offering picturesque green landscapes along the rocky trail.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.poste_lafayette_3;
                        model.text4 = "Picnicking in the shelter of the trees is a delightful option in certain areas where the sea displays stormy waves due to the proximity of the reefs to the lagoons. Enthusiasts of kite surfing and windsurfing will find this place ideal since Poste Lafayette is consistently exposed to the trade winds throughout the year. ";
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
                        model.text9 = "While the sea may be too challenging for a Sunday swim, the shore or shallow waters provide opportunities for sunbathing while children can revel in building sandcastles.<br>" +
                                "The eastern coast boasts prominent hotels and restaurants, including establishments like Jalsa Beach Hotel & Spa, Radisson Blu Poste Lafayette Resort & Spa, and the esteemed Hôtel Constance Le Prince Maurice. <br>" +
                                "To cater to the discerning tourist, gourmet restaurants have thrived alongside small traditional eateries. La Maison D’Été, specializing in Italian cuisine with seafood and fish menus, is a must-visit in Poste Lafayette. Another favored dining spot, Seabell, offers a menu featuring typical Mauritian dishes, complemented by a nearby mini market owned by the Seabell owners.<br>";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.map_location;
                        model.text11 = "";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 4) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.roche_noire_2;
                        model.text1 = "Ranked among the top 10 beaches in Mauritius, the Roche Noire Beachis located just a few kilometers from Poste Lafayette on the northeast coast of the island. The beach has a stunning landscape characterized by black lava rocks and a dark sea, where gentle waves crash onto the nearby coral reef. The pristine sand and the spectacular views of sunrise and sunset contribute to making Roche Noire Beach an unparalleled destination. The winds throughout the year provide a refreshing breeze, especially during the hot summer months. It is one of the most photographed beaches according to tourist reviews.";
                        model.title1 = "";
                        model.image1 = R.drawable.roche_noire_3;
                        model.text2 = "<br>" +
                                "The Roche Noire Beach is a true paradise for those who love water activities and appreciate nature. Guests can partake in a range of aquatic adventures, including swimming, snorkeling, and kayaking, allowing them to discover the diverse marine life and colorful coral reefs. Furthermore, the tranquil ambiance of the beach creates an ideal setting for a leisurely walk or a peaceful sunbathing experience. <br>" +
                                "Parking facilities are commonly accessible in the vicinity of the Roche Noire Beach, offering travelers a choice between free and paid parking options for easy access to the beach. Interesting fact about the Roche Noire Beach – the beach is famed for its breathtaking volcanic rock formations along the coastline, enhancing the natural beauty of the surroundings with a unique touch.<br>";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 5) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.ile_aux_cerfs_mauritius_1;
                        model.text1 = "On the eastern coast of Mauritius, just south of Trou d’Eau Douce, lies a pair of islands known collectively as Ile aux Cerfs. Ile aux Cerfs is a genuine paradise spanning 87 hectares. It is particularly appealing to water sports enthusiasts andis one of the most stunning beaches in Mauritius.";
                        model.title1 = "What to Explore and Experience on Ile aux Cerfs";
                        model.image1 = R.drawable.ile_aux_cerfs_7;
                        model.text2 = "The island is celebrated for its picturesque turquoise lagoon, perfectly suited for an extensive array of water sports. Among the activities available, whether undertaken solo or with a companion, is parasailing—an endeavor worth adding to your bucket list, particularly for the breathtaking vistas of the lagoon.<br>" +
                                "Other activities include speedboat rides, water skiing, and paddleboarding. Snorkeling is also an option, although, you'll need to take a boat to a location where there is coral as the water near the beach is shallow and consists predominantly of sand.<br>";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.ile_aux_cerfs_5_1;
                        model.text4 = "While many visitors come to the Ile aux Cerfs for leisurely water activities, true sun worshippers find their sanctuary here, especially given the limited shelter on the beach. The overarching advice is to liberally apply sunscreen, preferably opting for products that are environmentally friendly. <br>" +
                                "It's worth noting that most visitors tend to remain in close proximity to the pier, where the shuttle from Pointe Maurice drops them off. If you wish to evade the crowds, particularly on weekends, consider strolling a bit farther along the coast. Numerous other nearby beaches offer equally tranquil surroundings.<br>";
                        model.title3 = "How to Reach Ile aux Cerfs ";
                        model.text5 = "";
                        model.title4 = "";
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
                                "<b>Culinary Offerings</b> <br>";
                        model.image5 = R.drawable.ile_aux_cerfs_3;
                        model.text12 = "Ile aux Cerfs has several dining establishments, including a charming beachside restaurant. Additionally, two bars are available for visitors seeking refreshing beverages or cocktails at reasonable prices. An alternative is to bring ample food and drinks to suit your preferences.";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    }
                    break;
                case "West":

                    if (getAdapterPosition() == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.albion_lighthouse;
                        model.text1 = "Standing proudly on the cliff's edge, overseeing the expanse of the sea, the Cave Point lighthouse stands as a beacon guiding incoming ships into the harbor of Port Louis. Adorned with distinctive red and white stripes running from top to bottom, this iconic lighthouse was inaugurated in 1910 and remains impeccably preserved. To reach the lighthouse's summit, one must ascend a 98-step staircase crafted from wood and cast iron.<br>" +
                                "<br>" +
                                "The reason you would want to make the climb is that the summit offers breathtaking panoramic views of the entire coastline, stretching from Pointe aux Sables to Flic en Flac. For those who are afraid of heights, a stroll along the trail leading to the lighthouse still presents awe-inspiring vistas of the shoreline. Taking a moment to pause, closing your eyes, and immersing yourself in the melodic sounds of waves crashing against the cliffs adds another layer to the experience.<br>" +
                                "<br>" +
                                "Beyond being a hot spot for photographers capturing stunning backdrops, the area beneath the cliffs harbors the entrance to a cave populated by birds and bats. Brave cliff divers often scale the rocks beneath the cliffs, executing impressive jumps into the sea. Additionally, you can witness fishermen engaged in their craft. As the day draws to a close, the sunset unfolds, treating observers to a mesmerizing fusion of colors in the sky, sun, and sea.<br>" +
                                "<br>" +
                                "It's advisable to avoid visiting the Albion Lighthouse on windy days.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 1) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.flic_en_flac_3;
                        model.text1 = "Located on the west coast of Mauritius, Flic en Flachas emerged as the second most popular tourist area in the country, following Grand Baie.<br>" +
                                "Unlike the faster-paced development in the north, the west coast, including beautiful villages like Flic en Flac, has transformed from small fishing communities into charming towns, earning a reputation as a premier holiday destination.<br>" +
                                "Over the past two centuries, Flic en Flac has evolved from a humble fishing village into a prominent tourist hub. Today, it stands as a sought-after destination, attracting both international tourists and local Mauritians.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.flic_en_flac_1;
                        model.text2 = "Flic en Flac offers an ideal holiday experience with its excellent beaches, a variety of watersports, and a tranquil ambiance for complete relaxation. The location boasts a delightful setting with pristine white sand beaches and picturesque blue lagoons. Along the extensive 8 km beach, numerous restaurants, hotels, shops, and facilities cater to visitors.<br>" +
                                "The beach provides a perfect backdrop for activities such as afternoon strolls, watersports, sunbathing, or simply unwinding. It's an excellent spot for picnics, shaded by trees scattered along the coastline.<br>" +
                                "Flic en Flac's beach, adorned with Casuarina Trees, features a fine lagoon protected by a reef, ensuring safe swimming and opportunities for various watersports.<br>" +
                                "Flic-en-Flac buzzes with activity throughout the day and night, offering a dynamic atmosphere for visitors. In the daytime, guests can indulge in delectable street food options such as the \"DhalPuri,\" a thin, multi-layered flatbread crafted from flour, yellow split peas, salt, and water, filled with flavorful curry and sauces. Another popular local dish is fried noodles paired with Mauritian meatballs, enjoyed by both locals and visitors. However, it's crucial for those unfamiliar with the local water and cuisine to exercise extreme caution to prevent any potential food-related illnesses or stomach discomfort.<br>" +
                                "During the weekends, the beach becomes a vibrant hub for locals spending quality time with family and friends. Entertainment unfolds as some locals engage in singing and dancing to the rhythmic beats of Sega music, typically played with guitars and \"ravannes\" — a percussion instrument resembling the \"Bodhrán\" but played with distinctive techniques using hands.<br>" +
                                "The nightlife in Flic-en-Flac is lively, attracting both locals and tourists to nightclubs and restaurants, fostering a lively atmosphere for socializing. Despite its diverse offerings, it's important to note that the otherwise beautiful white sandy beach does contain a considerable amount of corals and sea urchins.<br>";
                        model.title2 = "Flic en Flac - Location";
                        model.text3 = "Situated in the Black River district on the island's western coast, approximately 15 km south of the capital, Port Louis, Flic en Flac lies between the villages of Albion to the north and Tamarin and Black River to the south. The west coastline, lined with hotels and villas providing direct beach access, characterizes Flic en Flac. The drive to Port Louis takes around 30 minutes, while reaching the airport takes approximately 1 hour.<br>" +
                                "Flic en Flac benefits from a well-established bus route, facilitating easy transportation to key locations across Mauritius. Buses connect to Port Louis and other cities like Quatre Bornes and Curepipe, offering convenient access to various parts of the island.<br>";
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

                    } else if (getAdapterPosition() == 2) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.casela;
                        model.text1 = "Casela World of Adventures, acclaimed as the most visited attraction in Mauritius, is a picturesque nature park nestled amidst sugarcane fields in the western part of the island, framed by the Rempart Mountain.";
                        model.title1 = "Casela World of Adventures";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "This nature park boasts an extensive range of activities and enjoyable experiences. Adventurous individuals can engage in thrilling pursuits such as ziplining, quad biking trails, canyoning, and more. Families looking for a fun time can explore the impressive African safari, featuring big cats, monkeys, giraffes, rhinos, impalas, and zebras.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.botanical_garden_5;
                        model.text4 = "";
                        model.title3 = "Thrilling Activities at Casela World of Adventures";
                        model.text5 = "Customize your Casela experience by choosing from a variety of activities, including quad biking, mountain climbing, interactions with cheetahs and lions, camel riding, zip-lining, and the exhilarating Canyon Swing. The Park offers four thematic worlds:<br>" +
                                "1.\t<b>Mountain Kingdom:</b> Features various activities like Zig Zag Racer, Canyon Swing, and Zip and Splash Tour.<br>" +
                                "2.\t<b>Big Cats Kingdom:</b> Offers unique experiences like walking and interacting with lions, cheetahs, and caracals.<br>" +
                                "3.\t<b>Safari Kingdom:</b> Includes Quad biking, Giraffe Feeding, Segway, Rhino Interaction, and E-bike Safari.<br>" +
                                "4.\t<b>Middle Kingdom:</b> Allows visitors to feed and interact with tortoises.<br>";
                        model.title4 = "Action-Packed Thrill Mountain Activities at Casela World of Adventures";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.casela_6;
                        model.text9 = "•\t<b>Ziplining:</b> Enjoy the thrill of flying on zip lines, providing a bird's eye view of the park.<br>" +
                                "•\t<b>Canyon Swing:</b> Experience a different form of bungee jumping from a 45m high platform.<br>" +
                                "•\t<b>Mountain Climbing:</b> Embark on a Via Ferrata Canyon Tour through sugarcane fields and plateaus.<br>";
                        model.title8 = "Safari and Animal Activities at Casela World of Adventures";
                        model.text10 = "";
                        model.image4 = R.drawable.casela_4;
                        model.text11 = "•\t<b>Walk with Lions:</b> Take a stroll alongside lions with expert guides ensuring safety.<br>" +
                                "•\t<b>Interaction with Big Cats:</b> Get up close with lions, cheetahs, and caracals under supervision.<br>" +
                                "•\t<b>Drive Thru:</b> A 45-minute drive to observe lions in their natural habitat.<br>" +
                                "•\t<b>E-Bike Safari:</b> Explore the safari park on eco-friendly electric bikes.<br>" +
                                "•\t<b>Segway Trip:</b> Discover the Yemen Nature Reserve Park on a Segway.<br>" +
                                "•\t<b>Safari Quad Biking:</b> Navigate the park's hills, valleys, and rivers on quad bikes.<br>" +
                                "•\t<b>Camel Riding:</b> Enjoy a camel ride through Casela park.<br>";
                        model.image5 = R.drawable.casela_3;
                        model.text12 = "<b>History</b><br>" +
                                "Casela World of Adventures originated in December 1979 as a bird sanctuary and has evolved into a must-see attraction in Mauritius. Throughout the years, the park has continually expanded its array of adventures, from quad biking and bus safari trips to unforgettable encounters with big cats, traversing a Nepalese bridge, and ziplining above trees and canyons.<br>" +
                                "Today, visitors can engage in activities such as feeding giraffes, interacting with brightly colored lorikeets and pygmy hippos, exploring the hilly landscape on camelback, fishing for tilapias, and embarking on a fun e-bike safari trip around the park.<br>" +
                                "<b>Conservation</b><br>" +
                                "Remaining true to its founding vision, Casela World of Adventures is actively committed to the conservation and protection of endangered species. In February 2015, the park gained notoriety with Her Royal Highness Princess Stephanie of Monaco becoming its patron. Princess Stephanie, renowned for her dedication to elephant protection in Asia, wholeheartedly supported the conservation efforts of Mauritius' leading visitor attraction.<br>";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 3) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.tamarin_3;
                        model.text1 = "Tamarin Bay Beach in Mauritius is a renowned coastal gem located on the west coast of the island, just past the village of Black River. Widely celebrated for its natural beauty and surf-friendly conditions, Tamarin Bay attracts locals and visitors alike. <br>" +
                                "The region was once known as Santosha Bay, evident in the faintly painted word 'Santosha' on some buildings. It was a hidden gem, providing avid surfers with some of the planet's best waves. Interestingly, locals initially refrained from naming the beach to keep its surfable seas a secret from outsiders.<br>" +
                                "The broader recognition of Tamarin Bay came with the release of the iconic surf documentary \"Forgotten Island of Santosha\" by Larry and Roger Yates in 1974, immortalizing the area. Tamarin Bay boasts two globally acclaimed surfing spots: ‘Dal’ on its left (south) and ‘Black Stone’ on the right (north) of the bay.<br>" +
                                "Tamarin Bay is a frequent habitat for dolphins, particularly Spinners and Bottlenose dolphins. These playful creatures are often spotted in the bay during the early morning before returning to the open sea. Numerous boat companies provide morning trips for tourists to observe and swim with dolphins.Tamarin is renowned for its apartments and the excellent service it extends to tourists.<br>";
                        model.title1 = "Surfing Hub";
                        model.image1 = R.drawable.tamarin_2;
                        model.text2 = "Tamarin Bay is famed for being one of the best surfing spots in Mauritius. Since the 1970s, it has been a central hub for surfers, initially introduced by Australians living on the island's west coast. The surf breaks draw enthusiasts, and access to this iconic spot is considered a privileged right.<br>" +
                                "<b>Authentic Charm</b><br>" +
                                "Despite its reputation as a premier surfing destination, Tamarin Bay retains an authentic and genuine atmosphere. Local families frequent the beach for a relaxing break or a leisurely stroll during the week, creating a vibrant yet laid-back ambiance.<br>" +
                                "<b>Swimming Cautions</b><br>" +
                                "While Tamarin Bay is a haven for surfers, swimming is not recommended for children and inexperienced swimmers. The presence of unpredictable currents and substantial waves breaking along the shore makes it less suitable for casual swimming.<br>" +
                                "<b>Beach Atmosphere</b><br>" +
                                "Tamarin Bay is a popular destination for both locals and tourists. The beach may be more crowded on weekends and holidays, offering a lively atmosphere and a chance to witness the vibrant beach culture.<br>" +
                                "<b>Time Recommendations</b><br>" +
                                "For those planning a visit, the best times to enjoy Tamarin Bay are early in the morning from 8:00 to 11:00 or in the afternoon from 13:00 to 16:00. During these periods, the beach offers favorable conditions for various activities.<br>" +
                                "<b>Activities</b><br>" +
                                "<br>";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.tamarin_1;
                        model.text4 = "Apart from surfing, Tamarin Bay provides opportunities for diverse water activities, including stand-up paddleboarding, bodyboarding, catamaran tours, swimming with dolphins, speed boat trips, and kayaking.<br>" +
                                "In summary, Tamarin Bay Beach stands out as a dynamic and authentic coastal destination, offering a perfect blend of surfing excitement, natural beauty, and a lively beach atmosphere.<br>";
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
                    } else if (getAdapterPosition() == 4) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.la_preneuse_4;
                        model.text1 = "The shoreline is adorned with pristine, snow-white sand, featuring a gentle slope and shallow waters. The ocean remains tranquil, displaying a captivating turquoise hue, although intermittent strong currents can be experienced. La Preneuse Beach boasts a spacious and expansive setting, providing ample room for all vacationers. The panoramic view from the coast reveals the towering Mount Le Morne against the backdrop of the turquoise lagoon.<br>" +
                                "Situated on the west coast of Mauritius, the beach offers a range of hotels catering to different comfort levels for tourists. Cafes, stores, and souvenir shops offering diverse goods are conveniently located near the shoreline. A notable attraction is the Martello Tower, erected by the British in the 1830s as a defense against the French fleet. It now serves as a museum housing information about the region's history and the initial planters. The renowned Black River, a freshwater river, flows along the beach. Yachts and boats gracefully navigate the open sea, providing opportunities for sea excursions.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 5) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.martello_tower_4;
                        model.text1 = "To enhance your holiday experience in Mauritius, be sure to explore the Martello Tower Museum. Prepare to be fascinated by the artifacts, and the living conditions that characterize this historical period.As a relic of Mauritius' history, the Martello Tower Museum, located on the La Preneuse beach in Black River, is essential for those seeking a deeper understanding of the island's past.<br>" +
                                "<b>Origin of the Martello Towers </b><br>" +
                                "The British first encountered one of these fortresses during a fierce battle at Mortella Bay in Corsica in 1794. Manned by the French, the tower impressed the British, who decided to build similar structures to safeguard their empire. Remnants of these towers can still be found in some former colonies and along the shores of England, characterized by a conical shape, thick walls, and slight variations.<br>" +
                                "<b>The Martello Tower in Mauritius </b><br>" +
                                "The Martello Tower at La Preneuse has been meticulously restored and converted into a Heritage Museum. Nestled among casuarina trees, it stands as a testament to history.<br>" +
                                "<b>Is it Martello or Mortella? </b><br>" +
                                "Contrary to a common misconception, 'Mortella' and 'Martello' are not related. Mortella Bay is named after a shrub abundant in Corsica, where the battle took place. 'Martello' means hammer in Italian, and in the past, a fire on the tower's flat roof served as a warning of approaching enemies. In Italy, the alarm was signaled by striking a bell with a hammer or 'martello.'<br>";
                        model.title1 = "The Story behind the Martello Towers in Mauritius";
                        model.image1 = R.drawable.matello_tower_1;
                        model.text2 = "In the early 19th century, after the British captured Mauritius, concerns arose about a potential French insurrection with the abolition of slavery and the end of free labor. To protect the island, the British decided to construct five Martello Towers along the west coast at strategic locations near river mouths.<br>" +
                                "The Martello towers wereprimarily built using basalt rock. The construction involved royal engineers, skilled stonecutters from India, carpenters, and, regrettably, slave labor for heavy tasks. Sand dunes called batteries were erected in front of the towers by the slaves. Each tower featured two cannons on the flat rooftop, capable of 360-degree rotation. The construction of the five towers spanned three years, but they never saw any action.<br>";
                        model.title2 = "The Tower turned into a Museum ";
                        model.text3 = "";
                        model.image2 = R.drawable.martello_tower_3;
                        model.text4 = "In 1992, the 'Friends of the Environment' initiated the restoration of the La Preneuse tower, funded by the government and other institutions. Transformed into a museum, it opened its doors in 2000, becoming an integral part of Mauritius' National Heritage Site.";
                        model.title3 = "Inside the Museum ";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.martello_tower_2;
                        model.text9 = "The tower comprises several floors, including a basement for rainwater storage, a ground floor used as a storeroom and gunpowder armory, a first floor for the Chief Officer's exclusive use and soldier accommodation, and a flat roof where cannons were installed. The museum exhibits various memorabilia, including muskets, the officer's deck and uniform, a fireplace with utensils, and more.";
                        model.title8 = "Opening times ";
                        model.text10 = "Tuesday to Saturday: 09h30 to 17h00 <br>" +
                                "Sunday: 09h30 to 13h00 <br>" +
                                "Public Holidays: open except on 1 May, 25 December, 1 and 2 January, 1 February, 12 March. <br>" +
                                "Closed on Mondays.<br>" +
                                "Guided tours occur every half hour, and no advance booking is required. Simply walk in, pay the entrance fee, and a guide will welcome you for a tour.<br>";
                        model.image4 = R.drawable.map_location;
                        model.text11 = "";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 6) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.le_morne_1;
                        model.text1 = "Added to the World Heritage List in 2008, the Le Morne Cultural Landscape is a mountain on the southwestern edge of Mauritius, extending into the Indian Ocean. This site served as a refuge for runaway slaves, commonly referred to as maroons, spanning the 18th century until the early 1900s.<br>" +
                                "The mountain bears an almost fortress-like character, featuring vertical cliffs encircling it, steep slopes crisscrossed by ravines and valleys, and, at its summit, a relatively level plateau—all of which offered refuge to the maroon slaves.<br>" +
                                "A wide gorge, referred to as the V-Gap or the mountain's crucial entry point, posed challenges for accessing the plateau. Both oral traditions and early written records suggest the presence of a narrow and hazardous passage that the maroons had to navigate to evade pursuers and find sanctuary at the summit.<br>" +
                                "Archaeological excavations conducted in cave shelters on the mountain unveiled ashy deposits, providing evidence of fire utilization. Additionally, the discovery of the 300-year-old remains of a young sheep supports the notion that maroons occupied the mountain's summit, successfully securing their survival.<br>" +
                                "The distinctive and fragile ecosystem of Le Morne Brabant Mountain harbors numerous endemic plant species, some of which are among the rarest in the world.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.brabant_6;
                        model.text2 = "The flora is exceptionally varied, encompassing 73 out of the 311 species of flowering plants that are exclusive to Mauritius. Among these, the L’Immortelle Du Morne, or Helichrysum Mauritianum, stands out as an endemic species found specifically on the mountain.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.brabant_8;
                        model.text4 = "The International Slave Route Monument is a tangible representation of the historical impact of slavery in Mauritius and globally. The central monument is encircled by nine smaller stone sculptures, symbolizing the origins and destinations of enslaved individuals.";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.brabant_4;
                        model.text9 = "A notable sculpture, crafted by Haitian artist Fritz Laratte, embodies the theme of liberation from slavery. It narrates the tale of a slave who, through prayer, witnessed the sudden release of his hands from the chains of servitude.<br>" +
                                "The unique Ah-yee shop, an integral part of Trou-Chenille village since its inception, served as a crucial source of basic necessities for the villagers. Testimonies reveal that the villagers relocated along with the shop.<br>" +
                                "Stella Maris, the initial Catholic chapel in Le Morne dating back to 1891, originally situated in Trou-Chenille, found its relocation to L’Embrasure during WWI. Following destruction by a cyclone in 1975, it was reconstructed in concrete in Le Morne Village in 1987.<br>";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.brabant_7;
                        model.text11 = "Trou-Chenille, an integral component of the cultural heritage within the Le Morne Cultural Landscape, retains an open-air museum featuring five traditional huts portraying various aspects of daily life.<br>" +
                                "Archaeological investigations uncovered evidence of a 19th-20th century settlement, Macaque, at the foot of Le Morne Brabant, likely associated with the Labonté and Béguinot families from Madagascar.<br>";
                        model.image5 = R.drawable.brabant_9;
                        model.text12 = "An abandoned cemetery, identified in a remote area beneath the mountain, dates back to the 19th century, with archaeological findings suggesting a connection to individuals of Malagasy and Mozambican origin.";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 7) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.maconde_1;
                        model.text1 = "The Maconde viewpoint is locatedon the southern coast of Baie du Cap, a charming and modest village celebrated for its striking natural allure and untamed, rugged coastlines. The viewpoint is nestled on a curved stretch of the coastal road atop a small rocky cliff. The landscape unfolds with picturesque vistas, featuring the vibrant red earth, lush green forests, rows of palm trees, and the glistening expanse of the Indian Ocean, creating a truly mesmerizing experience.<br>" +
                                "Legend has it that the name \"Maconde\" traces its roots to the era of slavery, where runaway slaves from the Makonde tribe in Mozambique sought refuge in this area, while others believe it was named after Governor Jean Baptiste Henri Conde, who constructed an outlook on the cliff.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.maconde_2;
                        model.text2 = "Access to this region was historically challenging, and it wasn't until the 1920s that the first road was constructed, overcoming the difficulties posed by the low-lying coast and uneven terrain. Recent renovations have significantly enhanced safety. The winding road along basalt cliffs, with the rhythmic sounds of the ocean against the rocks, provides a captivating spectacle, making it a favored spot for those captivated by ocean swells.<br>" +
                                "To reach the viewpoint, ascend a set of narrow stairs, where you'll be greeted by panoramic views of the ocean, the nearby coastal village, and occasional fishermen along the shore.<br>";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 8) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.chamarel_2;
                        model.text1 = "The Seven Coloured Earths form a geological wonder and a popular tourist destination situated in the Chamarel plain of the Rivière Noire District in southwestern Mauritius. This unique site encompasses small sand dunes exhibiting seven distinctive colors—red, brown, violet, green, blue, purple, and yellow. The remarkable characteristic of this location lies in the settling of differently colored sands in distinct layers, creating surrealistic and striped patterns on the dunes. Over time, rains have sculpted captivating designs into the hillside, resulting in an effect reminiscent of earthen meringue.<br>" +
                                "These sands originate from the decomposition of volcanic rock (basalt) gullies into clay, later transformed into ferralitic soil through total hydrolysis. The primary elements responsible for the red/anthracite and blue/purplish colors are iron and aluminum, respectively. The various hues are thought to be a consequence of the molten volcanic rock cooling down at different external temperatures, although the specific causes of their consistent and spontaneous separation are not fully understood.<br>" +
                                "The term \"Seven Coloured Earths\" serves as a descriptive, rather than an official, name. Various versions, including \"Chamarel Seven Coloured Earths,\" \"Chamarel Coloured Earth(s),\" \"Coloured Earth,\" and Terres des Sept Couleurs in French, have been reported.<br>" +
                                "This phenomenon can be replicated on a smaller scale by taking sands of different colors, mixing them together, and observing their eventual separation into a layered spectrum.<br>" +
                                "Since the 1960s, this site has evolved into one of Mauritius' major tourist attractions. Presently, the dunes are safeguarded by a wooden fence, and visitors are prohibited from climbing on them. However, observation outposts along the fence allow visitors to enjoy the scenery. Curio shops in the vicinity offer small test tubes containing the colored sands.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 9) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.chamarel_1;
                        model.text1 = "Unquestionably the tallest single-drop waterfall in Mauritius, standing at an impressive height of approximately 100m, the Chamarel Waterfall is a captivating natural wonder nestled amidst lush vegetation. Fueled by the convergence of three distinct streams flowing into the Saint Denis River, the waterfall exhibits a formidable rush, boasting a peak flow rate exceeding 40,000 m³ per minute.<br>" +
                                "As you traverse the 3km access road of the Seven Coloured Earth Geopark, providing a picturesque drive to the geosite, be sure not to overlook the waterfall's viewpoint on your left. Accessible through a trail winding through dense foliage, the viewpoint offers a front-row spectacle of this natural marvel.<br>" +
                                "Perched on the edge of a basalt cliff, the Chamarel Waterfall cascades into an oval pool before meandering through a 6km canyon fringed by tropical forests, eventually reaching Baie du Cap. The sight not only immerses the senses in freshness but also serves as a stunning testament to millions of years of volcanic activity. The dramatic landscape is shaped by lavas from two distinct ages. The brecciated basalt layer near the base dates back to 10 to 8 million years ago, overlaying a second layer from the intermediate period between 3.5 and 1.7 million years ago.<br>" +
                                "Embark on a three-hour trek through the secret valley of the Chamarel Waterfall, leading you to the waterfall's base, where you can enjoy a refreshing swim in the pool as the majestic waterfall showers you from above.<br>" +
                                "This location, characterized by its exceptional beauty, will mesmerize you with sights and sounds reminiscent of a true tropical rainforest. <br>";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 10) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.black_river_georges_2;
                        model.text1 = "Black River Gorges National Park, located in the hilly southwestern region of Mauritius, was officially established on June 15, 1994, and is under the management of the National Parks and Conservation Service. Encompassing a total area of 67.54 km², the park features diverse habitats, including humid upland forests, drier lowland forests, and marshy heathlands. Visitor facilities within the park comprise two information centers, picnic areas, and an extensive network of 60 kilometers of trails. Additionally, there are four field stations dedicated to research and conservation projects conducted by the National Parks and Conservation Service and the Mauritian Wildlife Foundation.<br>" +
                                "The primary aim of the park is to safeguard a significant portion of the island's remaining rainforest, even though parts of it have suffered degradation due to the introduction of non-native plants like Chinese guava and privet, as well as the presence of invasive animals such as the rusa deer and wild pigs. To preserve native wildlife, specific areas within the park have been cordoned off, and efforts have been made to eliminate invasive species. <br>";
                        model.title1 = "";
                        model.image1 = R.drawable.fody;
                        model.text2 = "Despite the challenges, the park continues to host a variety of endemic plants and animals, including the Mauritian flying fox and all endemic bird species on the island: Mauritius kestrel, pink pigeon, Mauritius parakeet, Mauritius cuckooshrike, Mauritius bulbul, Mauritius olive white-eye, Mauritius grey white-eye, and Mauritius fody. Recognized as an Important Bird Area by BirdLife International, Black River Gorges National Park plays a crucial role in the conservation of Mauritius' unique biodiversity.";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 11) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.le_morne_beach_2;
                        model.text1 = "Nestled on a peninsula along the western coast of Mauritius, at the base of the UNESCO-listed Morne Brabant mountain, lies Le Morne Beach. Easily accessible from the coastal road, this public beach boasts miles of pristine white sand and is adorned with majestic casuarina trees, all against the backdrop of the crystal-clear waters providing excellent visibility for scuba diving.";
                        model.title1 = "";
                        model.image1 = R.drawable.kite_surfing;
                        model.text2 = "Renowned as one of the premier kite-surfing spots in Mauritius, and often regarded as one of the best in the world, Le Morne Beach offers a breathtaking setting with its iconic mountain in the background. The beach is a favorite among windsurfers and kite surfers, as the conditions for these water sports are ideal throughout much of the year. The annual Kiteival, attracting international participants, is among the many competitions hosted at this spectacular location.<br>" +
                                "While Le Morne Beach remains a delightful spot for swimming, it can get quite busy on weekends and holidays. Nudism is prohibited, although topless sunbathing is accepted. For a more tranquil experience, the best times to visit the beach are early in the morning from 8:00 to 11:00 or in the afternoon from 13:00 to 17:00.<br>";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.paddle_boarding;
                        model.text4 = "An array of activities awaits beachgoers, including pedalo rides, windsurfing, kite surfing, scuba diving, stand-up paddleboarding, and kayaking, ensuring there's something for everyone to enjoy at Le Morne Beach.";
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
                    } else if (getAdapterPosition() == 12) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.rhumerie_de_chamarel_1;
                        model.text1 = "Nestled in the fertile valley of the South West region of Mauritius, the Rhumerie de Chamarel offers a captivating experience surrounded by expansive sugarcane plantations seamlessly integrated with pineapples and other tropical fruits.<br>" +
                                "Radiating warmth and authenticity, the Rhumerie de Chamarel Distillery invites visitors to partake in a comprehensive tourism journey, encompassing a guided tour of the distillery, rum tasting, and a delightful meal at L’Alchimiste, its distinctive \"A la Carte\" restaurant.<br>" +
                                "The design of Rhumerie de Chamarel is a testament to its commitment to providing a holistic tourism experience, seamlessly blending with the stunning natural surroundings through the use of wood, natural stone, and water, fostering a sense of communion with nature.<br>" +
                                "Guided Tour of Rhumerie de Chamarel embark on a guided tour of the Rhumerie de Chamarel with experienced guides taking you behind the scenes, offering detailed explanations of the rum-making process during your distillery visit.<br>" +
                                "Explore the exclusive rum-making process, starting with the careful selection and cultivation of sugar cane plants on the domain. The unique fermentation techniques employed ensure the finest aromas and enhance specific flavors. The duration of the tour is approximately 30 to 40 minutes, conducted in either English or French for your convenience.<br>";
                        model.title1 = "Rum Tasting ";
                        model.image1 = R.drawable.rhumerie_de_chamarel_3;
                        model.text2 = "A highlight of the distillery's guided tour is the rum tasting experience. Conclude your tour with a unique opportunity to sample a selection of agricultural rums produced by the distillery. Unlike traditional rum distilled from molasses, agricultural rum is derived from distilling pure cane juice, resulting in distinctive aromas and flavors.<br>" +
                                "Indulge in rum tasting, featuring varieties such as White Rum, Coeur de Chauffe, Chamarel Liquors, Exotic-Flavoured Rums, and the Old Rum.<br>";
                        model.title2 = "About the Rum of Rhumerie de Chamarel ";
                        model.text3 = "";
                        model.image2 = R.drawable.rhumerie_2;
                        model.text4 = "The focus of Rhumerie de Chamarel's rum-making process is to ensure a high-quality, eco-friendly agricultural rum. From cultivation to fermentation and sophisticated distillation, the distillery takes pride in producing rum by distilling fresh, fermented cane juice, deviating from the traditional molasses-based approach.<br>" +
                                "Aligned with sustainable development principles, the distillery emphasizes environmental efforts, including recycling bagasse into energy, purifying industrial fumes, using ashes as fertilizers, and utilizing steam for garden irrigation.<br>" +
                                "Additional Experiences<br>" +
                                "1.\tThe Sugar Cane Spirit Shop: An opportunity to purchase authentic products, including local rum, Mauritian crafts, jewelry, and an exclusive line of clothing crafted by Rhumerie.<br>" +
                                "2.\tRestaurant L’Alchimiste: Immerse yourself in a unique cuisine with dishes prepared from local products sourced on-site, surrounded by lush tropical flora overlooking plantations and mountains. Indulge in exotic delicacies such as palm heart or dishes featuring deer and wild pig, complemented by fine wines from France and other continents.<br>" +
                                "Tourist Information<br>" +
                                "•\tOpened from Monday to Saturday from 9.30 am to 5.30 pm.<br>" +
                                "•\tThe guided visit and rum tasting last approximately 30-40 minutes.<br>" +
                                "•\tChildren (up to 12 years old) must be accompanied by their parents, and rum tasting is not included.<br>";
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
                    } else if (getAdapterPosition() == 13) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.curious_corner_2;
                        model.text1 = "The Curious Corner is the sole science museum in Chamarel, located in the southwestern part of Mauritius. It caters to inquisitive minds, both young and old, who revel in the challenges presented by puzzles. For children, it serves as a stimulating environment, fostering curiosity, enhancing the thought process, and promoting growth. The space also appeals to couples and parents, creating an ambiance conducive to social interaction and daily encounters with numerous people.<br>" +
                                "This venue has become a delightful choice for celebrating birthdays, exchanging gifts with loved ones, or expressing care for one another in a unique setting, creating lasting memories. Families and relatives also frequent the Curious Corner, drawn by its captivating allure.<br>" +
                                "While most tourists visit Mauritius for its beaches and blue lagoon, the Curious Corner offers a distinct adventure and a touch of strangeness. <br>";
                        model.title1 = "";
                        model.image1 = R.drawable.curious_corner_4;
                        model.text2 = "Located opposite the entrance of Chamarel's Seven Coloured Earth, the Curious Corner was constructed with the primary aim of surprising visitors.<br>" +
                                "Spanning an area of 5,000 sq. meters, the adventure at the Curious Corner is filled with optical illusions that spark curiosity, boasting 40 exhibits to explore. A full visit typically takes around one and a half hours to experience all the thrills the place has to offer.<br>" +
                                "Activities at the Curious Corner:<br>" +
                                "1.\t<b>Upside-Down Room:</b> Experience the illusion of standing upside down, where the earth appears above your head, and the sky seems below your feet. The room challenges gravity, providing an excellent opportunity for unique photographs.<br>" +
                                "2.\t<b>Staircase Music Room:</b> Ascend a staircase that produces musical notes with each step, adding an interactive and enjoyable element to the experience.<br>" +
                                "3.\t<b>Light-Tapping Room:</b> Engage in a room where tapping on lights earns points, creating moments of fun and delight.<br>" +
                                "4.\t<b>Ames Room:</b> Named after Adelbert Ames, this room features a trapezoidal shape that distorts perspective, making individuals appear larger or smaller depending on their position in the room.<br>";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.curious_corner_5;
                        model.text4 = "5.\t<b>Mirror Maze:</b> Navigate through a maze of 200 mirrors, creating optical illusions that challenge both the body and the mind.";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.curious_corner_3;
                        model.text9 = "6.\t<b>Laser Music Room:</b> Play your favorite tunes using laser beams, putting your musical skills to the test.<br>" +
                                "7.\t<b>Corner Café:</b> Relax in a pleasant garden setting, enjoying a variety of food items, including ice cream, pizzas, burgers, snacks, and smoothies.<br>" +
                                "8.\t<b>Gift Shop ('Puzzles and Things'):</b> Purchase souvenirs, including local rum produced at the distillery, Mauritian crafts, jewelry, and an exclusive line of clothing.<br>" +
                                "<b>Special Guide:</b> The Curious Corner's staff is always ready to assist and provide information, ensuring a pleasant and engaging visit.<br>" +
                                "<b>Group Visits:</b> Special prices are offered to groups, making group visits a cost-effective and enjoyable way to experience the attraction with friends, family, and loved ones.<br>" +
                                "<b>Operating Information:</b><br>" +
                                "•\tOpening Hours: 9 AM to 5 PM, seven days a week.<br>";
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
                    break;
                case "North":
                    if (getAdapterPosition() == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.red_roof_church;
                        model.text1 = "Situated along the northern coast of Mauritius, overlooking the lagoon in Cap-Malheureux, stands a small church distinguished by its striking red roof, known as Notre Dame Auxiliatrice. Regarded as an emblematic symbol of the island, this location affords breathtaking vistas of Coin de Mire, a nearby islet situated less than ten kilometers off the north coast of Mauritius.<br>" +
                                "A simplistic architectural gem mirroring the essence of Mauritius, the Notre Dame Auxiliatrice chapel in Cap Malheureux is a featured stop on all tours provided by the Mauritius Resort. With its unassuming yet charming design, the chapel boasts a timeless quality, welcoming visitors throughout the year. The serene white hues of its interior walls evoke a sense of tranquility, and the aged yet imposing carved stone altar adds to its allure.<br>" +
                                "<b>Notre Dame Auxiliatrice</b><br>" +
                                "This renowned church, reminiscent of a postcard-perfect scene, beckons exploration. Visitors are captivated by its magnificent basalt altar and Holy water font. The picturesque landscape, adorned with a majestic Banyan tree casting a cooling shade, further enhances its charm. It stands as one of the most photographed locations on the island, attracting not only couples seeking a romantic setting for their vows but also avid photographers.<br>" +
                                "<b>Embark on a Journey Through a Unique Setting/b><br>";
                        model.title1 = "";
                        model.image1 = R.drawable.cap_malheureux_1;
                        model.text2 = "Cap Malheureux, along with its iconic chapel, is best explored towards the end of the day. The sunset bathes the surroundings in an exceptional glow, reminiscent of the enchanting scenes from classic Hollywood romances. The natural beauty of the location is preserved and abundant, offering a chance to witness the renowned green ray, a phenomenon the island proudly boasts about. Optimal times to visit are between October and December when the flamboyant flowers adorn the island, creating a captivating spectacle.";
                        model.title2 = "Coin De Mire ";
                        model.text3 = "";
                        model.image2 = R.drawable.cap_malheureux_2;
                        model.text4 = "A detour to Cap Malheureux provides an opportunity to extend the exploration to the marine cemetery or the nearby Tamil temple. As serene as a sanctuary, Cap Malheureux serves as an ideal haven for recharging one's spirits.<br>"
                        ;
                        model.title3 = "A Must-Visit Destination in Mauritius";
                        model.text5 = "This enchanting chapel is a highlight not to be overlooked during your stay in Mauritius. Conceived by Max Boullé and constructed by Raoul Lolliot in 1938, it received consecration from the Vicar General and Bishop Richard Lee on August 7, 1938.<br>";

                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.red_church_inside;
                        model.text9 = "Originally envisioned by Abbé Albert Glorieux, a Belgian missionary and parish priest of Saint-Michel of Grand Gaube, Notre Dame Auxiliaitrice was initially built to host wedding celebrations. The chapel continues to draw a congregation for Sunday masses, welcoming visitors throughout the day at any given time.";
                        model.title8 = "Cap Malheureux";
                        model.text10 = "Cap Malheureux is a village situated in the Rivière du Rempart District of Mauritius.<br>" +
                                "The designation \"Cap Malheureux,\" translating to \"Cape of Bad Luck,\" was bestowed by the French during their control of the island from 1715 to 1810.<br>" +
                                "The island served as a contentious focal point for numerous explorers, with the British being among them. In 1810, the British decided to seize the island to halt Mauritian corsairs' attacks on British fleets, notably those led by Surcouf. The British naval dominance had severed the island's supply connections with France. After an unsuccessful attempt to invade through Grand Port in the south (marked as the sole defeat of the Royal Navy by the French in the Napoleonic Wars), the British tactically surprised the French by launching an attack from the northern region, where French defenses were vulnerable. Consequently, the French were vanquished, and the name \"Cap Malheureux\" was coined to memorialize their defeat by the English, who successfully invaded and assumed control of the island from that strategic point.<br>";
                        model.image4 = R.drawable.map_location;
                        model.text11 = "";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.pamplemousse_garden;
                        model.text1 = "The Sir Seewoosagur Ramgoolam Botanic Garden, also known as the Pamplemousses Botanic Garden, is a prominent tourist attraction located in Pamplemousses near Port Louis, Mauritius. It holds the distinction of being the oldest botanical garden in the Southern Hemisphere. Established in 1770 by Pierre Poivre, the garden spans approximately 37 hectares (91 acres) and is renowned for its expansive pond featuring giant water lilies (Victoria amazonica).<br>" +
                                "Throughout its history, the garden underwent various name changes, reflecting its evolving status and ownership. Notable names include 'Jardin de Mon Plaisir,' 'Jardin des Plantes,' 'Le Jardin National de l’Ile de France,' 'Jardin Royal,' 'Jardin Botanique des Pamplemousses,' 'The Royal Botanical Gardens of Pamplemousses,' and 'The Royal Botanic Gardens, Pamplemousses.' Eventually, on September 17, 1988, it was officially named the \"Sir Seewoosagur Ramgoolam Botanic Garden\" in honor of the first prime minister of Mauritius.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.botanical_garden_1;
                        model.text2 = "Beyond the mesmerizing giant water lilies, the garden boasts an assortment of spices, ebonies, sugar canes, and 85 palm varieties sourced from Central America, Asia, Africa, and the Indian Ocean islands. Noteworthy individuals, including Princess Margaret, Countess of Snowdon, Indira Gandhi, François Mitterrand, and Robert Mugabe, have contributed by planting trees within the garden.<br>" +
                                "Situated in the village of Pamplemousses, approximately seven miles northeast of Port Louis, the garden has a rich history dating back to 1729 when it was set aside for colonist P. Barmont. Over the years, it changed hands multiple times, with various owners contributing to its expansion and development. Today, it covers an area of about 25,110 hectares (62,040 acres), with the remaining portion serving as an experimental station.<br>";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.botanical_garden_3;
                        model.text4 = "<br>" +
                                "The roots of the Royal Botanic Gardens can be traced to the initiative of Mahé de La Bourdonnais, the first French Governor of Mauritius, in 1735. Initially created as a vegetable garden for his household and the burgeoning township of Port Louis, the garden evolved into a botanical haven. Under Pierre Poivre's directorship in 1768, the garden became a hub for acclimatizing plants from overseas and nurturing crops with economic significance, such as cassava.<br>";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.botanical_garden_2;
                        model.text9 = "Throughout its history, the garden weathered periods of neglect and upheaval, with directors like James Duncan contributing to its restoration and enhancement. In 1866, during a malaria epidemic, the garden played a crucial role in producing Eucalyptus trees to combat the disease.<br>" +
                                "The Department of Agriculture assumed responsibility for the garden in 1913, overseeing its development and maintenance. Notably, following Seewoosagur Ramgoolam's death in 1985, part of the botanical garden was dedicated to a crematorium, marking the first instance of someone being cremated within its grounds.<br>" +
                                "<br>" +
                                "The Sir Seewoosagur Ramgoolam Botanic Garden stands as a testament to Mauritius's botanical heritage, offering visitors a captivating journey through its lush landscapes and rich history.<br>";
                        model.title8 = "Chateau de Mon Plaisir";
                        model.text10 = "";
                        model.image4 = R.drawable.botanical_garden_4;
                        model.text11 = "Until 1839, the Chateau de Mon Plaisir featured a modest structure characterized by a flat roof and circular verandahs. The current single-story building, constructed by the English in the mid-19th century, has been designated as a National Monument, giving it legal protection. Visitors can enjoy a charming panorama of the Moka Range and the Peak of Pieter Both from the Chateau.";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 2) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.sugar_museum_pamplemousses;
                        model.text1 = "Located not too far from the Pamplemousse Botanical Garden, amidst a picturesque setting featuring a bougainvillea and coconut tree-lined alley, a pond surrounded by lush greenery, stands the impressively renovated sugar mill—a truly spectacular attraction on the island!<br>" +
                                "From the moment the Dutch set foot in Mauritius and introduced sugar canes to the island, the sugar industry has played a significant role in the island's history. At L'Aventure du Sucre, you'll delve into the intricacies of the sugar-making process and explore the colonial past that has profoundly shaped Mauritius into what it is today. Traverse a 250-year historical journey within the museum, a former operational sugar factory, and conclude your tour with a delightful sugar tasting experience, along with sampling various products derived from the golden era of colonial centuries.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.laventure_du_sucre;
                        model.text2 = "Embark on your museum tour by delving into the history of sugar plantations in Mauritius. Gain insights into the Dutch era, succeeded by the French and eventually the English colonists. Following this historical exploration, proceed to the operational factory, which remained active until the 1970s. Immerse yourself in the intricate stages of the sugar-making process showcased in vivid detail. Complement your visit to L'Aventure du Sucre by exploring the Village Boutik for gift shopping and souvenirs. Alternatively, enjoy a delightful pause at Restaurant Le Fangourin, savoring the nuances of Mauritian cuisine.";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 3) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.baie_de_larsenal_2;
                        model.text1 = "Explore the remnants of the Balaclava Ruins situated within the enchanting grounds of Maritim Resort and Spa, nestled along the shores of Turtle Bay. Immerse yourself in our Mauritian heritage as you visit the fort, perched gracefully over Riviere Citron on the scenic Northwest coast.<br>" +
                                "<b>Balaclava Ruins</b><br>" +
                                "Turtle Bay has a historical significance as a favored stop for ships traveling from Europe to the East during the 17th century. Initially named 'Ebony Bay' by the Dutch, the abundance of ebony trees in the area, ideal for ship repairs, led to its designation. Over time, the bay earned the name 'Turtle Bay,' possibly due to the presence of numerous turtles in the bay.<br>" +
                                "<b>Balaclava Ruins History</b><br>";
                        model.title1 = "";
                        model.image1 = R.drawable.baie_de_larsenal;
                        model.text2 = "Moving into the 18th century, when the French settled in Mauritius, Governor Mahe de Labourdonnais relocated the administration from Mahebourg to the North, resulting in the establishment of Port Louis. The iron from Balaclava was crucial in constructing the new capital, its harbor, and supporting military efforts in India, including an iron foundry, naval arsenal, and gunpowder factory.<br>" +
                                "<b>Cannon at Balaclava</b><br>" +
                                "In 1774, a powder store explosion occurred, sparing some structures like the flour mill, sawmill, and the building housing ironworks. In 1864, the estate was sold to Mr. Wiehe, who built 'Mon Desir' and a school. Later, it became a popular holiday destination for wealthy Mauritians. Mr. Wiehe also established a modern rum distillery.<br>" +
                                "<b>Balaclava Ruins Today</b><br>" +
                                "Currently owned by a German hotel chain and a Mauritian family, preserving this heritage site is a priority. The Chateau Mon Desir restaurant was constructed on the original Mon Desir site, offering a panoramic view of the ruins and Turtle Bay.<br>" +
                                "<b>Location</b><br>" +
                                "Situated within the Maritim Hotel's 35-hectare estate on the Southwest coast, a mere 10-minute drive from Grand Bay, this open-air museum awaits your exploration. <br>" +
                                "Visitors are advised to contact Maritim Resort for permission due to occasional film and fashion shoots at the site.<br>";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 4) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.mauritius_aquarium_1;
                        model.text1 = "Nestled in the quaint coastal village of Pointe aux Piments, situated in the northern region of Mauritius and approximately a 20-minute drive from Grand Baie, the aquarium unveils a novel ecological system. This innovative setup mirrors the depths and surroundings of the ocean, immersing visitors in a captivating world.<br>" +
                                "Spread across five distinct buildings, the aquarium features various tanks and pools showcasing 150 different species of aquatic life native to Mauritius and its surroundings. The largest tank, spanning 15 meters, offers a mesmerizing spectacle of diverse marine animals. For young visitors, the \"touch pool\" provides an interactive experience with harmless marine creatures.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.mauritius_aquarium_2;
                        model.text2 = "The daily feeding ritual for the fishes takes place at 11:00 am, providing an opportunity to witness the impressive feeding sessions of sharks, tortoises, and morays. While guided tours are not available, the aquarium employs six knowledgeable staff members who are ready to address any queries. Additionally, a small souvenir shop and a snack bar, offering diverse lunch options and beverages, complement the visitor experience.<br>" +
                                "In the event of unfavorable weather during your stay in Mauritius, the aquarium presents itself as a compelling alternative for exploration.<br>";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 5) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.grand_baie_1;
                        model.text1 = "Grand Bay, also known as Grand Baie, is a coastal village and prominent tourist destination situated in the Rivière du Rempart district at the northern tip of Mauritius. In the 17th century, the Dutch referred to it as De Bogt Zonder Eyndt (Bay Without End), a name that resonates when one explores the village. Today, Grand Bay stands out as the most favored holiday spot in Mauritius.<br>" +
                                "<br>" +
                                "Renowned for its mesmerizing emerald waters and vibrant atmosphere both day and night, Grand Bay caters to various water activities such as safe swimming, sailing, windsurfing, and water skiing. It also serves as the starting point for deep-sea fishing expeditions and boat trips to the northern islands of Mauritius, including Gunners' Quoin, Flat Island, Round Island, and Serpent Island.<br>" +
                                "<br>" +
                                "Grand Bay and its surroundings boast an extensive array of fashion and craft shops, hotels, and restaurants. The village offers a blend of traditional local shops, some with nearly five decades of operation, alongside modern shopping centers and global brand outlets, making it a premier shopping destination for clothing, jewelry, textiles, and souvenirs.<br>" +
                                "<b>Nightlife</b><br>" +
                                "Recognized for its vibrant nightlife, Grand Bay hosts some of the island's best bars and nightclubs, such as Banana Café, Zanzibar, Les Enfants Terribles, and the renowned Buddha Bar. Night owls can revel in the lively atmosphere, with parties kicking off around midnight and continuing into the early morning hours.<br>" +
                                "<b>Location</b><br>" +
                                "Located in the Rivière du Rempart district on the northwest side of the island, Grand Bay sits approximately 25 km north of Port Louis, the capital of Mauritius. Positioned between the villages of Pereybere to the east and Trou aux Biches to the west, the drive to Port Louis takes about 30 minutes, while the journey to the airport lasts approximately 1 hour and 30 minutes.<br>" +
                                "<br>" +
                                "Grand Bay enjoys a well-connected bus route, facilitating easy travel to key locations in Mauritius, including Port Louis, Triolet, Goodlands, and Grand Gaube.<br>" +
                                "<b>Climate</b><br>" +
                                "Boasting a favorable climate year-round, Grand Bay offers warm summers and mild winters. With sheltered beaches and lagoons, the region is an excellent choice for a holiday at any time.<br>" +
                                "<b>Activities</b><br>";
                        model.title1 = "";
                        model.image1 = R.drawable.parasailing;
                        model.text2 = "Visitors to Grand Bay can engage in a plethora of activities beyond sunbathing, such as safe swimming, sailing, windsurfing, parasailing, and various water sports. The region is also ideal for exploring the underwater marine life through activities like the Underwater Sea Walk, submarine excursions, and the Underwater Scooter. Divers can discover numerous diving sites along the coral reefs just a few kilometers from the shore.<br>" +
                                "<b>Hotels</b><br>" +
                                "The hospitality industry in Mauritius, particularly Grand Bay, has witnessed significant changes over the years. From being a hidden paradise known to a select few travelers, Mauritius has transformed into a popular holiday destination with a diverse range of hotel options, guesthouses, private apartments, and villas. Grand Bay caters to various preferences, from deluxe resorts to cozy rooms for rent.<br>" +
                                "<br>" +
                                "Prominent hotels in Grand Bay include Veranda Grand Bay, Le Mauricia Hotel, 20 Sud, Ocean Villas, Royal Palm, Ventura Hotel, and Merville Beach Resort.<br>" +
                                "<b>Grand Bay Beaches</b><br>";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.grand_baie_3;
                        model.text4 = "Grand Bay is home to two popular beaches: La Cuvette Beach and the Grand Bay Public Beach. La Cuvette, located near the Royal Palm hotel, offers a small and intimate setting with calm waters, free of rocks and corals. The Grand Bay Public Beach, situated at the heart of Grand Bay, provides panoramic views but has a limited area for entering the water due to active boat traffic inside the bay.";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.grand_bay_1;
                        model.text9 = "<br>" +
                                "The north of Mauritius, including Grand Bay, is characterized by flat terrain, earning the name \"Northern Plains.\" With beautiful lagoons and white sandy beaches, this region boasts a rich palette of colors and varied landscapes. The sea within the lagoons is often adorned with soft sand, offering unmatched transparency. The view of the lagoons transitioning from green to blue, framed by the white surf of coral reefs and the deep blue open sea, creates a breathtaking spectacle.<br>";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.catamaran_cruise_west_coast_2;
                        model.text11 = "For those seeking an underwater adventure, glass-bottom boat trips offer a glimpse into the marine world, but for a truly unique experience, embark on a journey with a two-person submarine to cruise beneath the surface alongside tropical fish.";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, BeachDetails.class);
                        context.startActivity(intent);
                    } else if (getAdapterPosition() == 6) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.port_louis_3;
                        model.text1 = "Le Caudan Waterfront is as a prominent commercial development in Port Louis, the capital city of Mauritius, offering a diverse array of amenities such as shops, banking facilities, casinos, cinemas, restaurants, a marina, and the renowned five-star hotel, Le Labourdonnais.<br>" +
                                "<b>Historical Roots:</b><br>" +
                                "The name \"Le Caudan Waterfront\" pays homage to Jean Dominique Michel de Caudan, a notable figure who arrived in the former Isle de France from Languedoc, a historical province in the South of France, in 1726. He initiated a saltpan near a small bay in the southwest of Port-Louis, now recognized as the Robert Edward Hart Garden, situated on the entrance road to Le Caudan Waterfront.<br>" +
                                "The peninsula of Le Caudan, formed around a fossil coral islet, witnessed the evolution of various structures over 250 years, including a powder magazine, an astronomical and meteorological observatory, quays, warehouses, and small enterprises. The sugar industry significantly influenced the harbor's daily activities until the establishment of the Bulk Sugar Terminal in 1980. Today, only a few remaining walls bear testament to the bustling activities that transpired over 150 years.<br>" +
                                "<b>Historically Significant Spots</b><br>" +
                                "Several areas within Le Caudan Waterfront hold historical significance. The first meteorological observatory in the Indian Ocean, now home to the Food Court and the Namasté restaurant, is one such spot. The Blue Penny Museum occupies the former Docks office building.<br>" +
                                "The naming of different wings within the complex reflects episodes from the country's colonial history:<br>" +
                                "Barkly Wharf: Named after Sir Henry Barkly, a Member of Parliament of the British government and appointed governor of Mauritius from 1863-1870.<br>" +
                                "Le Pavillon wing: Derived from Pavillon Street on an ancient map of Port Louis, speculated to have origins during the period when Port Louis was called ‘Port Napoléon.’<br>" +
                                "Dias Pier: A tribute to Diogo Dias, brother of the famous navigator Barthoulomeu Dias, believed to be the first to record the Mascarene Islands on a navigation map.<br>" +
                                "<b>Modern Day Attraction</b><br>";
                        model.title1 = "";
                        model.image1 = R.drawable.port_louis_13;
                        model.text2 = "<br>" +
                                "Caudan, commonly known today, was the island's first major shopping development, and it continues to be an iconic shopping destination for both locals and tourists. The mall features the latest fashion trends, a popular Craft Market, specialty shops offering unique local goods, cinemas, a marina, a bookstore, restaurants, cafes, a museum housing two of the rarest stamps globally, a casino, and tax-free shopping for tourists.<br>";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.port_louis_6;
                        model.text4 = "Despite being the first shopping mall on the island, Caudan has adeptly adapted to current trends, maintaining its appeal as a modern waterfront mall. Visitors can witness the bustling port activities as large container and cruise ships navigate in and out.";
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
                    } else if (getAdapterPosition() == 7) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.port_louis_4;
                        model.text1 = "The primary shopping hub in Port Louis is undeniably the Port Louis Central Market, also referred to as the Bazaar of Port Louis. It is segmented into different sections, each hosting diverse stalls offering various products.<br>" +
                                "The central focus of the market revolves around fresh fruits and vegetables, creating a visually stunning display of vibrant produce that is truly a feast for the eyes.<br>" +
                                "Ascending to the first floor, visitors encounter the renowned Craft Market. This section provides an extensive selection of locally crafted souvenirs, spices, and handicrafts at reasonable prices. Whether you're seeking a gift for a challenging recipient, the Craft Market ensures you'll find something suitable. We strongly recommend taking the opportunity to indulge in some shopping.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.port_louis_5;
                        model.text2 = "After a bout of shopping, satisfy your appetite by exploring the adjacent section of the Central Market, home to numerous street food stalls. A wide array of choices awaits, ensuring you find something to suit your taste. Don't miss the chance to try dhall puri, crafted from split chickpea and flour, or the famous alouda, resembling a milkshake with basil seeds, grated jelly, and sometimes a scoop of ice. For those interested in local snacks, there's a diverse range of options, including samoussas (fritters filled with potatoes), bajas (fritters made with chickpea flour), and gato piment (fritters made with yellow split pea and chili).<br>" +
                                "<br>" +
                                "Remaining bustling throughout the week, the Central Market stands as a key shopping destination for locals and draws visitors from across the island. It is undeniably worth a visit, offering insights into local life and allowing you to immerse yourself in the authentic Mauritian atmosphere.<br>";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 8) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.port_louis_9;
                        model.text1 = "The Government House in Port Louis is one of the oldest structures, maintaining its graceful presence since the days of the French colony. Although its current appearance differs from its original form, the construction of the Government House began under the leadership of the first French governors, Nicolas de Maupin (1729 – 1735) and Mahé de Labourdonnais (1735 – 1746), who also used it as his residence. The building served as the official venue for the Governor's administrative activities, as well as a host for various receptions and functions.<br>" +
                                "Under the governance of Mahé de La Bourdonnais, Port Louis emerged as a significant naval base and shipbuilding center. During his tenure, several structures were erected, some of which still endure today, including parts of the Government House, the Chateau de Mon Plaisir in Pamplemousses, and the Line Barracks. The French East India Company maintained control of the island until 1767.<br>" +
                                "Originally, the building featured a wooden structure with palm leaf coverings, which was later replaced by a one-story construction during Nicolas de Maupin's era. Mahé de Labourdonnais subsequently expanded the ground floor in 1738, and the building was then designated as Hôtel du Gouvernement. Over time, through the French and British colonial periods, the structure underwent additional modifications and enhancements, culminating in the final form we recognize today.<br>" +
                                "Adjacent to the structure, a statue of Queen Victoria, bearing her trademark solemn expression, stands prominently. Regrettably, the building is not open to visitors.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 9) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.place_des_armes;
                        model.text1 = "In the heart of the bustling capital of the island, Port Louis, between the former government hotel and the waterfront overlooking the port, lies the Place d'Armes. Known to all Mauritians, the Place d'Armes is a square in the capital adorned with statues of the founding fathers of Mauritius.<br>" +
                                "The Place d'Armes is a must-visit location as it is where north-south traffic converges, and the main access points to the city meet.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.place_darmes_2;
                        model.text2 = "Built during the time of Mahé de La Bourdonnais, his statue stands at the entrance of the Place d'Armes. Also known for its towering palm trees, the Place d'Armes features a three-lane avenue that has hosted many dignitaries from around the world.<br>" +
                                "<br>" +
                                "It is also the oldest part of the city of Port Louis, where one can find the headquarters of numerous banks, commercial houses, and consulates. However, the old period buildings have given way to a much more modern architecture.<br>";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.port_louis_8;
                        model.text4 = "The Place d'Armes remains the ideal starting point for your visit to the capital. Nearby, you will find several city landmarks, including the government hotel, the oldest theater in the Indian Ocean, some still cobbled roads like Vieux Conseil Street and Georges Guibert Street. Also in the vicinity are St Louis Cathedral, a Catholic church, and St James Cathedral, a Protestant church. You can also explore the central market and many other museums.<br>";
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
                    } else if (getAdapterPosition() == 10) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.blue_penny_museum_2;
                        model.text1 = "The Blue Penny Museum in Mauritius was inaugurated in November 2001 and is dedicated to showcasing the history and art of the island. Its name is derived from the famous 1847 Blue Penny and Red Penny stamps, which hold great historical significance.<br>" +
                                "Here's a brief history of the Blue Penny Museum:<br>" +
                                "1.\t<b>Stamp Acquisition (1993):</b> The museum's centerpiece is the 1847 Blue Penny and Red Penny stamps, considered some of the rarest and most valuable stamps in the world. In 1993, a consortium of Mauritian enterprises, led by The Mauritius Commercial Bank, purchased the stamps for $2,000,000. These stamps were then repatriated to Mauritius, marking their return to the island after nearly 150 years.<br>" +
                                "2.\t<b>Museum Inauguration (2001):</b> The Blue Penny Museum officially opened its doors to the public in November 2001. It was established as a cultural institution aimed at preserving and showcasing Mauritius's rich history and artistic heritage.<br>" +
                                "3.\t<b>Conservation Efforts:</b> Given the extreme rarity and value of the Blue Penny stamps, conservation efforts were implemented. The originals are illuminated only temporarily to prevent damage from prolonged exposure. Visitors to the museum typically view replicas of the stamps, ensuring the long-term preservation of the priceless artifacts.<br>" +
                                "4.\t<b>Founder - The Mauritius Commercial Bank:</b> The museum was founded by The Mauritius Commercial Bank, one of the leading financial institutions in Mauritius. This initiative reflects the bank's commitment to preserving and promoting the cultural heritage of the island.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.blue_penny_museum_1;
                        model.text2 = "5.\t<b>Additional Artifacts: In addition to the Blue Penny stamps, the museum houses other notable artifacts, including the original statue of Paul and Virginia. Crafted by Prosper d'Épinay in 1881, this statue adds to the cultural and artistic richness of the museum's collection.<br>" +
                                "The Blue Penny Museum has become a significant cultural institution in Mauritius, attracting both locals and tourists interested in exploring the island's history through its valuable artifacts and exhibits.<br>" +
                                "The Blue Penny Museum is structured across two floors, each offering distinct features and exhibits:<br>" +
                                "<b>Ground Floor:</b><br>" +
                                "1.\t<b>Souvenir Shop: Visitors are welcomed by a souvenir shop on the ground floor, providing an opportunity to purchase mementos related to the museum and Mauritius.<br>" +
                                "2.\t<b>Temporary Exhibition Room: The ground floor houses a temporary exhibition room, showcasing rotating exhibits that may vary over time, allowing for diverse and dynamic displays.<br>" +
                                "First Floor:<br>" +
                                "1.\t<b>The Age of Discovery:</b> This exhibition room narrates the stories of pioneers who undertook the first oceanic voyages to reach the Mascarene Islands. It prominently features ancient maps that document this historic journey.<br>" +
                                "2.\t<b>The Island Builders:</b> Covering three significant periods in Mauritius's history—the Dutch Period, the French Period, and the English Taking Over—this room provides a comprehensive overview of the island's historical evolution.<br>" +
                                "3.\t<b>Port Louis:</b> This exhibition room focuses on the origins and history of Port Louis, offering insights into the development and growth of the city.<br>" +
                                "4.\t<b>The Postal Adventure:</b> Dedicated to the postal history of Mauritius, this room proudly displays two stamps from the renowned Blue Penny collection, contributing to the island's philatelic heritage.<br>" +
                                "5.\t<b>Engraved Memory:</b> Honoring Joseph Osmond Barnard, the first individual to engrave stamps in Mauritius, this room serves as a tribute to his significant contributions to the field.<br>" +
                                "Overall, the Blue Penny Museum is thoughtfully organized to provide visitors with a captivating journey through Mauritius's history, art, and unique cultural heritage.<br>";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 11) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.church_pl;
                        model.text1 = "The St. Louis Cathedral, locally known as 'Katedral Sin Lwi,' is situated in Port Louis, not far from Champ de Mars, making it one of the oldest churches in Mauritius. As the seat of the bishop of the diocese of Port Louis, this religious edifice has undergone multiple demolitions and rebuilds throughout its history.<br>" +
                                "Initially erected between 1752 and 1756 as a temporary wooden chapel where the Bank of Mauritius stands today, the cathedral faced destruction due to cyclones and wartime usage. Mahe de Labourdonnais, the visionary behind the church's location, completed it in 1756. However, a cyclone in April 1773 brought it down completely. In 1782, a new church opened but was closed due to structural issues. Sir Robert Farquhar reconstructed it in 1814. Demolished again in 1928 and rebuilt in 1933 under Mgr James Leen, the present structure, with its larger size and historic features like the facade and stone towers, emerged.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.text1;
                        model.text2 = "The interior preserves relics from the past, such as statues, paintings, and furniture. The altar, in use since earlier years, holds historical significance. In 2007, marking its 160th anniversary as a cathedral, the building underwent extensive renovation, restoring its prominence in Port Louis.<br>" +
                                "The cathedral serves as the burial place for its bishops, a tradition in the Catholic Church. Six bishops, including Mgrs Hankinson, Meurin, O’Neil, Bilsborrow, Leen, and the latest, Cardinal Margéot, interred in July 2009, rest beneath the choir tiling.<br>";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 12) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.natural_history_musuem;
                        model.text1 = "The Natural History Museum in Port Louis is located on the ground floor of the Mauritius Institute Building, a structure recognized as a National Heritage, situated in the vibrant heart of the City of Port Louis. Erected between 1880 and 1884, the Mauritius Institute Building is a partial emulation of the Colombo Museum of African Modern Art building in Sri Lanka, designed by British architect M. Mann.<br>" +
                                "As the oldest museum in Mauritius and one of the earliest in southern Africa, the Natural History Museum holds a storied history. The idea for a museum in Mauritius was conceived in 1826 when naturalists Julien Desjardins and Louis Bouton presented the proposal to Governor Sir Lowry Cole. Consequently, on October 14, 1842, the Desjardins Museum of African Modern Art was inaugurated in a wing of the old Royal College in Port Louis, where it remained for the ensuing 42 years.<br>" +
                                "In 1880, the Mauritius Institute was founded under the guidance of Governor Sir George Ferguson Bowen. The collection from the Desjardins Museum was relocated to the newly constructed Mauritius Institute Building in 1885. Primarily focused on marine fauna and birds from the Mascarene Islands, this collection laid the groundwork for the present-day Natural History Museum.<br>" +
                                "Dedicated to the systematic collection, study, and documentation of the fauna and flora of Mauritius and the Mascarene Islands, the museum has evolved into a center for information and exchange across various natural history fields in the Mascarene region.<br>" +
                                "In 2000, the Natural History Museum of the Mauritius Institute attained the status of a National museum, reinforcing its role as a pivotal institution in preserving and promoting the country's natural heritage. Notably, the museum is home to the most complete dodo skeleton, unearthed in 1904 by barber Etienne Thirioux, further emphasizing its significance in the scientific and historical exploration of Mauritius's distinctive biodiversity.<br>" +
                                "Key features of the Natural History Museum in Port Louis:<br>" +
                                "1.\t<b>Exhibits and Displays:</b> The museum typically features exhibits on various aspects of natural history, including geology, paleontology, botany, and zoology. Displays may include fossils, specimens of indigenous plants, and information about the unique ecosystems found in Mauritius.<br>" +
                                "2.\t<b>Endemic Species:</b> Mauritius is known for its unique flora and fauna, and the museum often highlights endemic species that are found nowhere else in the world. This can include information about rare plants, birds, and other wildlife.<br>" +
                                "3.\t<b>Educational Content:</b> Natural history museums often serve an educational purpose, providing valuable information about the island's geological history, evolution of its species, and the importance of conservation.<br>" +
                                "4.\t<b>Research and Conservation:</b> Some natural history museums engage in research and conservation efforts. They may collaborate with scientists, researchers, and conservationists to contribute to the understanding and preservation of the island's natural environment.<br>" +
                                "5.\t<b>Interactive and Engaging Displays:</b> Modern museums often incorporate interactive displays, multimedia presentations, and engaging activities to make the learning experience more enjoyable for visitors of all ages.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 13) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.aapravasi_ghat_1;
                        model.text1 = "The Aapravasi Ghat is a historical site located in Port Louis, the capital city of Mauritius. It holds great significance in the history of the island and is recognized as a UNESCO World Heritage Site. The history of the Aapravasi Ghat is closely tied to the indentured labor system that shaped the social and economic landscape of Mauritius.<br>" +
                                "Here is a brief history of the Aapravasi Ghat:<br>" +
                                "1.\t<b>Indentured Labor System:</b> In the 19th century, after the abolition of slavery, the British turned to the system of indentured labor to meet the demand for cheap and abundant workforce for their colonies. Indentured laborers were recruited from various parts of India, as well as China and Africa, to work on plantations in Mauritius and other British colonies.<br>" +
                                "2.\t<b>Establishment of Aapravasi Ghat:</b> The Aapravasi Ghat was established in 1849 as the first site for the reception of indentured laborers in Mauritius. The name \"Aapravasi Ghat\" translates to \"immigration depot\" in Hindi. The location served as a processing center where indentured laborers arriving by ship were registered, housed temporarily, and assigned to various plantations across the island.<br>" +
                                "3.\t<b>Living Conditions:</b> Indentured laborers faced harsh living conditions at the Aapravasi Ghat. They were often crowded into cramped barracks, and the site became a place where many experienced suffering, sickness, and death. The conditions were challenging, and the laborers endured a difficult transition from their home countries to the unfamiliar environment of Mauritius.<br>" +
                                "4.\t<b>End of Indenture:</b> The indenture system continued until the early 20th century when it was officially abolished. The Aapravasi Ghat continued to be used for processing immigrants until 1920. After the cessation of the indenture system, the site underwent various transformations, serving different purposes over the years.<br>" +
                                "5.\t<b>UNESCO World Heritage Site:</b> In 2006, the Aapravasi Ghat was designated as a UNESCO World Heritage Site in recognition of its historical importance in the global migration of indentured laborers and its impact on the multicultural identity of Mauritius.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.aapravasi_ghat_2;
                        model.text2 = "indentured laborers who played a crucial role in shaping the cultural and social fabric of Mauritius. The site is open to visitors, allowing them to explore its history and gain insights into this critical period in the island's past.";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 14) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.post_office;
                        model.text1 = "The present-day museum building was erected as the General Post Office between 1865 and 1870. It is located by the harbor, adjacent to the customs building in the heart of the city.<br>" +
                                "Construction commenced in January 1865 under the supervision of Surveyor General Morrison. By 1868, three-quarters of the building was completed, with an additional two years required to finish the entire project. The construction expenses amounted to £10,000 to £11,000, employing approximately 80 workers. It officially opened in December 1870.<br>" +
                                "The architecture serves as a notable illustration of Victorian design in public colonial structures from the era of Queen Victoria, mirroring similar structures found in countries such as India, Sri Lanka, South Africa, Trinidad, and Guyana.<br>" +
                                "It served as a replacement for the former General Post Office situated on Government Street near Government House, which had been the post office's headquarters since 1847.<br>" +
                                "Since December 21, 1870, it has functioned as the primary post office of Mauritius, and in April 1877, the Central Telegraph Office also took residence in the building.<br>" +
                                "The Postmaster General made his residence in the building, and it became the hub for mail from the 33 rural post offices built between the 1870s and 1890s on the island.<br>" +
                                "In 1958, under British Governor-General Sir Robert Scott, the building received recognition as a listed structure through Government Notice No. 614. This decision followed a recommendation from the Ancient Monuments Board. The Mauritian National Monuments Act of 1985 confirmed the building's protected status, as did the \"National Monuments of Mauritius\" annex to the National Heritage Fund Act (Act No. 40) of 2003.<br>" +
                                "The postal museum, inaugurated in 2001, showcases exhibits detailing the postal and telecommunications history of the island. Notably, the world-renowned Red and Blue \"Post Office\" Mauritius stamps are not on display here but at the nearby Blue Penny Museum.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 15) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.citadelle;
                        model.text1 = "The Fort Adelaide is as a testament to the initial years of British governance in the region. Erected in the 19th century, precisely between 1834 and 1835, by Colonel Thomas Cunningham, the fort's construction presented formidable challenges due to the scarcity of labor caused by the recent abolition of slavery. To address this shortage, the British government initially relied on apprentices, liberated slaves, prisoners, and even some soldiers. However, owing to the lack of skilled labor, the government had to enlist stonemasons, masons, laborers, and other craftsmen from India in 1837 to complete the construction.<br>" +
                                "The primary purpose behind constructing the fort was to safeguard the port against potential invasions and suppress any potential uprising from the local population. It was christened Fort Adelaide in homage to Adelaide, the wife of King William IV of England, featuring her initials and crown on the entrance pediment. Despite never being utilized for military or policing purposes, it stands as one of the few remnants of the period between the abolition of slavery and the arrival of indentured laborers.<br>" +
                                "In contrast to other forts from the British era, such as Fort William and Fort Victoria, which have succumbed to deterioration and neglect, Fort Adelaide remains the sole intact structure. Crafted from black basalt stones, it serves as a testament to the expertise of the craftsmen of that era. Completed in 1840, the fort became a symbol of the commencement of Indian immigration and the cessation of slavery, not only due to those involved in its construction but also due to the circumstances that led to its inception.<br>" +
                                "During the 1830s, tensions ran high in Mauritius, recently brought under British rule. The French inhabitants on the island were discontented about losing control and the prohibition of the slave trade, compounded by the abolition of slavery. The news of the French Revolution of 1830 heightened these tensions. The island's population comprised whites, people of color, and slaves, prompting British authorities to worry about potential enemy attacks or uprisings. Fort Adelaide's construction was sanctioned to provide defensive capabilities in case of invasion or rebellion. The strategic hill of Port-Louis was chosen to oversee the city, port, and mountain slopes.<br>" +
                                "Upon the fort's completion, the island's situation had significantly improved, and its original purpose was no longer applicable. Instead, it was repurposed for signaling fires and announcing the arrival of notable figures through cannon fire or simply for daily ceremonial cannon fire. Over the years, its function evolved into a hub for cultural initiatives, hosting concerts, shows, and various events. Despite this shift, Fort Adelaide remains a pivotal landmark in Mauritius, symbolizing the intricate history of the island.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 16) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.port_louis_photography_museum;
                        model.text1 = "Established in 1966 through the avid collecting enthusiasm of Mr. Tristan Bréville and his wife, this private museum had its initial presence at their residence in Rose-Hill, then in Quatre Bornes, and eventually found its current home in 1993 within an old building donated by the municipality. This space underwent restoration with the support of AIMF. The inauguration, graced by sixty-four French mayors from AIMF, Mr. Jacques Toubon (French Minister of Culture), and Mr. Jean-Luc Monterrosso (director of the European House of Photography), unfolded on July 1, 1993. Mauritius welcomed the daguerreotype in February 1840, marking its entry into photography practice merely four months after procuring the patent from Louis Daguerre in France. Consequently, the island stands among the pioneers globally in adopting photography.";
                        model.title1 = "";
                        model.image1 = R.drawable.photography_musuem_3;
                        model.text2 = "The museum proudly showcases an array of documents capturing the history of photography in Mauritius, encompassing portraits, landscapes, urban and rural scenes, significant events, factories, fishing moments, inaugural automobiles, early buses (1930), the Mauritian railway, colonial residences, historical structures, flora, fauna, and more.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.port_louis_photography_museum_inside;
                        model.text4 = "With a collection boasting over a thousand cameras spanning various epochs, including Charles Chevalier's lens crafted for Daguerre in 1839, the museum also serves as an iconographic research center. Housing a specialized library and Nadar business card collections, it possesses an extensive compilation featuring 400,000 acetate negatives, 5,000 glass plates, 28 daguerreotypes, 10 Lumière brothers' autochromes, 200,000 prints illustrating the history and landscapes of Mauritius, 9,000 vintage postcards, over twenty-five hours of films depicting Mauritius and its inhabitants from 1939, archival newspapers spanning the late 19th century to 1945 related to photography in Mauritius, as well as books and newspapers delving into the history of cinematography in Mauritius since 1897.";
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
                    } else if (getAdapterPosition() == 17) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.marie_reine_de_la_paix_3;
                        model.text1 = "Marie Reine de la Paix, or Mary Queen of Peace, is a Catholic church and holy site, showcasing a remarkable monument portraying the Virgin Mary gracefully holding a globe. Crafted from Carrara marbleby Ferdinando Palla in Italy, this 3-meter-tall statue was unveiledon the Feast of the Assumption in 1940.The Monument was dedicated to Mary Queen of Peace as an expression of gratitude for safeguarding the country during World War I.";
                        model.title1 = "";
                        model.image1 = R.drawable.marie_reine_de_la_paix_5;
                        model.text2 = "This church holds considerable importance as a pilgrimage destination for Catholics in Mauritius. Particularly esteemed during religious festivities like the Feast of the Assumption of the Blessed Virgin Mary, it attracts throngs of devotees to its sacred premises. In 1989, Pope John Paul II graced the church with his presence during his 44th international journey.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.marie_reine_de_la_paix_4;
                        model.text4 = "Nestled on the inclines of Signal Mountain in the capital city of Port Louis, the church transcends its role as a mere place of worship, evolving into a tranquil haven offering a sweeping view of the city. Accessing the church entails ascending seven terraces and 82 steps hewn from rock. Each terrace is adorned with vibrant flowers, and the meticulously manicured surrounding gardens create an idyllic setting for individuals, friends, and families to convene and partake in moments of serene contemplation.";
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
                    } else if (getAdapterPosition() == 18) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.jardin_de_la_compagnie_1;
                        model.text1 = "The Jardins de la Compagnie is the city's most enchanting garden, adorned with expansive banyan trees, numerous statues, benches, and fountains. It is a delightful and secure destination during the day. However, it is advisable to steer clear of the park at night, as it tends to be a popular gathering spot for sex workers and drug addicts.";
                        model.title1 = "";
                        model.image1 = R.drawable.les_jardins_de_la_compagnie_2;
                        model.text2 = "The origin of the 'Jardin de la Compagnie' dates back to the French Occupation period when French settlers were establishing their colony on the island. After the Dutch abandoned Mauritius in February 1710 due to various challenges, including cyclones, floods, and attacks from maroon slaves, the French took control of the island in September 1721. During the arrival of the acting governor De Nyon (1722 – 1725), Mr. Durongouet-Le-Toullec, dispatched from Bourbon Island in December 1721, settled on the border of 'Ruisseau du Pouce,' establishing a garden that later became the Company Garden.<br>" +
                                "Initially, the area was marshy and not suitable for construction. Over time, as different governors took charge, the 'Jardin de la Compagnie' served partly as a cemetery due to the Smallpox epidemic. In 1771, during Governor Desroches' tenure (1769 – 1772), Port Louis began to resemble a town with the creation and correction of large streets. It was at this point that the cemetery section of the garden was relocated to the current site of the 'West Cemetery' (Les Salines), allowing the original purpose of the garden to emerge as a place for relaxation and enjoyment.<br>";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 19) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.odysseo_1;
                        model.text1 = "Embark on a captivating adventure at Odysseo, the largest oceanarium in the Mascarene Islands, and prepare to be mesmerized by a diverse array of species thriving in their natural habitat. A true delight for animal enthusiasts and sea lovers, especially those with a passion for marine biology and biodiversity.";
                        model.title1 = "";
                        model.image1 = R.drawable.odysseo_2;
                        model.text2 = "Nestled in the heart of the island's capital, Port Louis, near the harbor, Odysseo immerses you in an oceanic theme from the moment you arrive. Encounter adorable fish reminiscent of Nemo and even encounter awe-inspiring sharks. This package provides two options, both including admission to the oceanarium and park access.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.odysseo_3;
                        model.text4 = "Option 2 offers a guided tour of the entire park, providing an opportunity to delve deeper into the mysteries of the ocean and its inhabitants. <br>" +
                                "Odysseo Experience Highlights:<br>" +
                                "1.\t<b>The Lagoon:</b> Immerse yourself in the Mauritian territory, exploring the lagoon's calm waters, vibrant fish, seagrass beds, mangroves, and coral reefs.<br>" +
                                "2.\t<b>Inland Forests:</b> Venture inland to discover species in their habitats, exploring lakes, rivers, and forests with diverse freshwater, insect, and reptile inhabitants.<br>" +
                                "3.\t<b>Coral Reefs:</b> Dive into the blue waters of the Indian Ocean to unveil the secrets and biodiversity of the majestic coral reefs.<br>" +
                                "4.\t<b>Open Sea:</b> Experience a fully immersive underwater journey as stingrays, sharks, eels, and various fish swim alongside you in the tunnel.<br>" +
                                "5.\t<b>Invertebrates:</b> Explore the fascinating world of invertebrates, comprising 95% of animal species on Earth, and unravel their incredible evolutionary history.<br>" +
                                "6.\t<b>Sub-Oceanic View:</b> Gain a better understanding of sharks and their vital role in the interconnected oceans, advocating for their protection.<br>" +
                                "Upon completing your visit, make your way to the gift store, where a diverse range of offerings awaits. From stuffed animals and t-shirts to books, educational games exploring the marine environment, goodies, and jewelry, you can find an array of souvenirs to bring the oceanic experience home with you.<br>";
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

                    } else if (getAdapterPosition() == 20) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.chateau_de_labourdonnais;
                        model.text1 = "A majestic lane of exceptionally large trees invites you to the colonial mansion once owned by Christian Wiehe. Constructed in 1856 and completed approximately three years later, this residence is often referred to by many Mauritians as the most exquisite colonial house on the island, and rightfully so. Featuring a spacious dining room, an impressive house pantry, a large living room, elegantly styled bedrooms, and a grand exhibition hall, this palace is undeniably an enchanting destination.";
                        model.title1 = "";
                        model.image1 = R.drawable.chateau_de_labourdonnais_4;
                        model.text2 = "During your exploration, you'll wander through the lush gardens with expansive pathways, showcasing the opulence of Mr. Wiehe's era. Century-old mango trees, various spice trees, and numerous exotic fruit trees contribute to the garden's incredible charm. The Aldabra tortoises peacefully graze, considering the palace their home. As part of your visit, you can venture to the Rhumerie des Mascareignes, established in 2006, to learn about traditional rum-making techniques. The tour of La Château de Labourdonnais concludes with a splendid tasting session featuring rum and other local delights such as fruit pastes, juices, and sorbets. The boutique provides an opportunity to purchase gifts and souvenirs, and you can also take a break at La Table du Chateau, an elegant restaurant offering Mauritian dishes.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.chateau_de_labourdonnais_2;
                        model.text4 = "The visit concludes delectably at the Tasting Bar, where you can sample products from the distillery or orchards, including jams, fruit jellies, fruit juices, and sorbets.<br>" +
                                "Beyond the Château of Labourdonnais tour, you can explore the shop offering authentic local products, including decorative items related to colonial life and gardens, rum, fruit jellies, spices, and more.<br>" +
                                "La Table du Château provides a unique and refined culinary experience inspired by the fruits and vegetables from the Labourdonnais orchards. Set in a contemporary ambiance, it offers a gastronomic journey unveiling the flavors of Mauritius.<br>";
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
                    } else if (getAdapterPosition() == 21) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.albion_lighthouse;
                        model.text1 = "";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 22) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.albion_lighthouse;
                        model.text1 = "";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 23) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.albion_lighthouse;
                        model.text1 = "";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";
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
                    } else if (getAdapterPosition() == 24) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.albion_lighthouse;
                        model.text1 = "";
                        model.title1 = "";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "";
                        model.title2 = "";
                        model.text3 = "";
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
                    }
                    break;
            }
        }
    }
}


