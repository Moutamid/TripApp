package com.moutimid.sqlapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fxn.stash.Stash;
import com.moutimid.sqlapp.R;
import com.moutimid.sqlapp.activities.Iteneraries.ItenerariesDetails;
import com.moutimid.sqlapp.model.BeacModel;

public class ItenerariesAdapter extends BaseAdapter {

    private Context context;
    private String[] itemTexts;
    private String[] itemName;
    private String[] itemDetails;
    private int[] itemImages;

    public ItenerariesAdapter(Context context, String[] itemName, String[] itemDetails, String[] itemTexts, int[] itemImages) {
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
        View itemView = inflater.inflate(R.layout.iteneraies_layout, parent, false);
        ImageView imageView = itemView.findViewById(R.id.imageView);
        TextView textView = itemView.findViewById(R.id.textView);
        TextView textView1 = itemView.findViewById(R.id.textView1);
        TextView textView2 = itemView.findViewById(R.id.textView2);
        TextView textView3 = itemView.findViewById(R.id.textView3);
        TextView number = itemView.findViewById(R.id.number);
        ImageView map = itemView.findViewById(R.id.map);
        imageView.setImageResource(itemImages[position]);
        textView.setText(itemName[position]);
        textView1.setText(itemTexts[position]);
        textView2.setText(itemDetails[position]);
        int i = position + 1;
        number.setText(""+i);
        if(position==0)
        {
            textView3.setText("Start here");
        }
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                if (Stash.getString("day").equals("day1")) {
                    if (position == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 2) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 3) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 4) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 5) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 6) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 7) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 8) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 9) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 10) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 11) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 12) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.gris_gris_1;
                        model.text1 = "The primary beach area features an expansive green field with a commanding view of dramatic cliffs and enormous waves. There are benches and a pavilion available for relaxation while taking in the scenery.\n" +
                                "To the left, a concrete staircase descends to the beach, but swimming is strongly discouraged due to the high danger level. The powerful waves can swiftly overwhelm swimmers. Instead, enjoy a leisurely stroll along the beach, heading toward a small cave at the far end.\n";
                        model.title1 = "Secret Caves at Gris Gris";
                        model.image1 = R.drawable.grisgris_2;
                        model.text2 = "In addition to the cave on the far left side of the beach, two other hidden caves can be discovered at Gris Gris. These are more challenging to reach, involving a descent down a cliff and walking through the water.\n" +
                                "Caution is advised against going all the way down, as water levels can fluctuate unpredictably, and the current is often too strong.\n" +
                                "For those eager to explore the secret caves at Gris Gris, head towards the cliff's edge directly across from the parking lot. Upon reaching the spot, descend only about halfway to catch a glimpse of the caves on your right.\n" +
                                "It's important to bear in mind that entering the caves could pose risks if the water level rises!\n" +
                                "Gris Gris beach is intricately connected to the village of Souillac, which relies heavily on tourism for its revenue. Established 200 years ago as a port for ships sailing from Europe to India, Souillac has a rich history worth exploring. Plan your day strategically to make the most of your visit to the southern part of Mauritius, and consider including a visit to Rochester Falls, just outside the village, renowned for its distinctive rectangular-sided rocks.\n" + "The name \"Gris Gris\" adds an intriguing dimension to the experience. Upon entering the beach, a large sign displays the history behind the name. According to local tradition, \"Gris Gris\" is linked to the African amulet known as the “Gris Gris” and its association with the tumultuous coastline. However, the story takes an unexpected turn, suggesting that Gris Gris might have been the name of a puppy belonging to a French cartographer who visited the coast in 1753.<br>";
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                }
                else if (Stash.getString("day").equals("day21")) {
                    if (position == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    } else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    } else if (position == 2) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    } else if (position == 3) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    } else if (position == 4) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    } else if (position == 5) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    } else if (position == 6) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }

                }
                else if (Stash.getString("day").equals("day22")) {
                    if (position == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 1) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 2) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
//                    TODO change
                    else if (position == 3) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.la_vanilla_1;
                        model.text1 = "Discover the native plants and animals of Mauritius and its neighboring islands at La Vanille Nature Park. You may see Nile Crocodiles, tenrecs, eels, iguanas, and turtles from Madagascar and the Seychelles among the reserve's wildlife under the shade of large bamboo and palm trees.";
                        model.title1 = "";
                        model.image1 = R.drawable.la_vanille_4;
                        model.text2 = "You will discover a variety of fossilized species, like the Madagascar elephant bird and the dodo that were once common in Mauritius and the neighboring islands but are now extinct. Additionally, the La Vanille Nature Park has an insectarium with a distinctive collection of more than 23,000 species from all over the world where you will have the opportunity to expand your knowledge on insects.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.la_vanille_9;
                        model.text4 = "The Crocodile Park section is famous for housing more than 2000 Nile crocodiles in various stages of growth. The centerpiece of the Crocodile Park is the enormous colony of crocodiles, where visitors may hold newborn Nile crocodiles to pose for photos.It is a great place to broaden your knowledge of this reptile that coexisted with humans before the dinosaur eraand observe firsthand how they have adapted their physical characteristics to survive throughout history. Every day at 11:30 am there is a free crocodile feeding display.<br>" +
                                "The Park is home to the world's largest artificial Aldabra tortoise habitat. Thanks to the park's specialized breeding facilities, the number of tortoises has increased to over a thousand. You are free to approach and feed them.<br>" +
                                "The La Vanille Nature Park is a comprehensive institution designed to preserving the earth's wonderful environment. The Park features a wide range of natural elements, including trees, plants, animals, insects, marine life, and fossils preserved in their most authentic form. <br>";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.la_vanille_6;
                        model.text9 = "When you hike in the La Vanille Nature Park you will feel you are close to nature.The serene atmosphere of strolling along a well-kept path becomes even more thrilling as nature presents itself to you at every turn. Indeed, you will discover the park's surrounding beautiful green forest and will be enthralled with the ponds and unique wildlife where you may come across the giant tortoises and friendly deer strolling alongside you. For those with a keen eye for photography and the ability to engage with wildlife, this location is a photographer's paradise.<br>" +
                                "Actively participating in the preservation of nature, the La Vanille Nature Park works on numerous programs to plant over 350,000 domestic trees and endangered animal breeds in their facilities.<br>" +
                                "The Crocodile Park Shop sells a variety of merchandise such as handcrafted souvenirs from Mauritius, crocodile-inspired items, and books about animals. <br>";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.la_vanilla_8;
                        model.text11 = "A wonderful way to end your wildlife excursion is with a meal of good food and relaxation in a cozy setting at the Crocodile Park Restaurant. Located in the forest, the restaurant provides a range of choices for both adults and children.To make up for the craziest supper of your life, Le Crocodile Affamé serves a distinctive cuisine made with crocodile meat. Those who try it can't help but compliment the dish.";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "<b>Opening hours:</b><br> Every day from 8:30 to 17:00";
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);

                    } else if (position == 4) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.gris_gris_1;
                        model.text1 = "The primary beach area features an expansive green field with a commanding view of dramatic cliffs and enormous waves. There are benches and a pavilion available for relaxation while taking in the scenery.<br>" +
                                "To the left, a concrete staircase descends to the beach, but swimming is strongly discouraged due to the high danger level. The powerful waves can swiftly overwhelm swimmers. Instead, enjoy a leisurely stroll along the beach, heading toward a small cave at the far end.<br>";
                        model.title1 = "Caves at Gris Gris";
                        model.image1 = R.drawable.grisgris_2;
                        model.text2 = "In addition to the cave on the far left side of the beach, two other hidden caves can be discovered at Gris Gris. These are more challenging to reach, involving a descent down a cliff and walking through the water.<br>" +
                                "Caution is advised against going all the way down, as water levels can fluctuate unpredictably, and the current is often too strong.<br>" +
                                "For those eager to explore the secret caves at Gris Gris, head towards the cliff's edge directly across from the parking lot. Upon reaching the spot, descend only about halfway to catch a glimpse of the caves on your right.<br>" +
                                "It'simportant to bear in mind that entering the caves could pose risks if the water level rises!<br>" +
                                "Gris Gris beach is intricately connected to the village of Souillac, which relies heavily on tourism for its revenue. Established 200 years ago as a port for ships sailing from Europe to India, Souillac has a rich history worth exploring. Plan your day strategically to make the most of your visit to the southern part of Mauritius, and consider including a visit to Rochester Falls, just outside the village, renowned for its distinctive rectangular-sided rocks.<br>";                 model.title2 = "";
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    } else if (position == 5) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    } else if (position == 6) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }

                }
                else if (Stash.getString("day").equals("day31")) {
                    if (position == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.sugar_museum_pamplemousses;
                        model.text1 = "Located not too far from the Pamplemousse Botanical Garden, amidst a picturesque setting featuring a bougainvillea and coconut tree-lined alley, a pond surrounded by lush greenery, stands the impressively renovated sugar mill—a truly spectacular attraction on the island!<br>" +
                                "From the moment the Dutch set foot in Mauritius and introduced sugar canes to the island, the sugar industry has played a significant role in the island's history. At L'Aventure du Sucre, you'll delve into the intricacies of the sugar-making process and explore the colonial past that has profoundly shaped Mauritius into what it is today. Traverse a 250-year historical journey within the museum, a former operational sugar factory, and conclude your tour with a delightful sugar tasting experience, along with sampling various products derived from the golden era of colonial centuries.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.laventure_du_sucre;
                        model.text2 ="Embark on your museum tour by delving into the history of sugar plantations in Mauritius. Gain insights into the Dutch era, succeeded by the French and eventually the English colonists. Following this historical exploration, proceed to the operational factory, which remained active until the 1970s. Immerse yourself in the intricate stages of the sugar-making process showcased in vivid detail. Complement your visit to L'Aventure du Sucre by exploring the Village Boutik for gift shopping and souvenirs. Alternatively, enjoy a delightful pause at Restaurant Le Fangourin, savoring the nuances of Mauritian cuisine.";
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }

                    else if (position == 2) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.chateau_de_labourdonnais;
                        model.text1 = "A majestic lane of exceptionally large trees invites you to the colonial mansion once owned by Christian Wiehe. Constructed in 1856 and completed approximately three years later, this residence is often referred to by many Mauritians as the most exquisite colonial house on the island, and rightfully so. Featuring a spacious dining room, an impressive house pantry, a large living room, elegantly styled bedrooms, and a grand exhibition hall, this palace is undeniably an enchanting destination.";
                        model.title1 = "";
                        model.image1 = R.drawable.chateau_de_labourdonnais_4;
                        model.text2 = "During your exploration, you'll wander through the lush gardens with expansive pathways, showcasing the opulence of Mr. Wiehe's era. Century-old mango trees, various spice trees, and numerous exotic fruit trees contribute to the garden's incredible charm. The Aldabra tortoises peacefully graze, considering the palace their home. As part of your visit, you can venture to the Rhumerie des Mascareignes, established in 2006, to learn about traditional rum-making techniques. The tour of La Château de Labourdonnais concludes with a splendid tasting session featuring rum and other local delights such as fruit pastes, juices, and sorbets. The boutique provides an opportunity to purchase gifts and souvenirs, and you can also take a break at La Table du Chateau, an elegant restaurant offering Mauritian dishes";
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 3) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.port_louis_3;
                        model.text1 = "Le Caudan Waterfront is as a prominent commercial development in Port Louis, the capital city of Mauritius, offering a diverse array of amenities such as shops, banking facilities, casinos, cinemas, restaurants, a marina, and the renowned five-star hotel, Le Labourdonnais.";
                        model.title1 = "Historical Roots:";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "The name \"Le Caudan Waterfront\" pays homage to Jean Dominique Michel de Caudan, a notable figure who arrived in the former Isle de France from Languedoc, a historical province in the South of France, in 1726. He initiated a saltpan near a small bay in the southwest of Port-Louis, now recognized as the Robert Edward Hart Garden, situated on the entrance road to Le Caudan Waterfront.<br>" +
                                "The peninsula of Le Caudan, formed around a fossil coral islet, witnessed the evolution of various structures over 250 years, including a powder magazine, an astronomical and meteorological observatory, quays, warehouses, and small enterprises. The sugar industry significantly influenced the harbor's daily activities until the establishment of the Bulk Sugar Terminal in 1980. Today, only a few remaining walls bear testament to the bustling activities that transpired over 150 years.<br>";
                        model.title2 = "Historically Significant Spots";
                        model.text3 = "Several areas within Le Caudan Waterfront hold historical significance. The first meteorological observatory in the Indian Ocean, now home to the Food Court and the Namasté restaurant, is one such spot. The Blue Penny Museum occupies the former Docks office building.<br>" +
                                "The naming of different wings within the complex reflects episodes from the country's colonial history:<br>" +
                                "Barkly Wharf: Named after Sir Henry Barkly, a Member of Parliament of the British government and appointed governor of Mauritius from 1863-1870.<br>" +
                                "Le Pavillon wing: Derived from Pavillon Street on an ancient map of Port Louis, speculated to have origins during the period when Port Louis was called ‘Port Napoléon.’<br>" +
                                "Dias Pier: A tribute to Diogo Dias, brother of the famous navigator Barthoulomeu Dias, believed to be the first to record the Mascarene Islands on a navigation map.<br>";
                        model.image2 = R.drawable.map_location;
                        model.text4 = "";
                        model.title3 = "Modern Day Attraction";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.port_louis_13;
                        model.text9 = "Caudan, commonly known today, was the island's first major shopping development, and it continues to be an iconic shopping destination for both locals and tourists. The mall features the latest fashion trends, a popular Craft Market, specialty shops offering unique local goods, cinemas, a marina, a bookstore, restaurants, cafes, a museum housing two of the rarest stamps globally, a casino, and tax-free shopping for tourists.";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.port_louis_6;
                        model.text11 = "Despite being the first shopping mall on the island, Caudan has adeptly adapted to current trends, maintaining its appeal as a modern waterfront mall. Visitors can witness the bustling port activities as large container and cruise ships navigate in and out.";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
//                        Toast.makeText(context, "data is not added", Toast.LENGTH_SHORT).show();
                    }
                    else if (position == 4) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 5) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }

                }
                else if (Stash.getString("day").equals("day32")) {
                    if (position == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.la_vanilla_1;
                        model.text1 = "Discover the native plants and animals of Mauritius and its neighboring islands at La Vanille Nature Park. You may see Nile Crocodiles, tenrecs, eels, iguanas, and turtles from Madagascar and the Seychelles among the reserve's wildlife under the shade of large bamboo and palm trees.";
                        model.title1 = "";
                        model.image1 = R.drawable.la_vanille_4;
                        model.text2 = "You will discover a variety of fossilized species, like the Madagascar elephant bird and the dodo that were once common in Mauritius and the neighboring islands but are now extinct. Additionally, the La Vanille Nature Park has an insectarium with a distinctive collection of more than 23,000 species from all over the world where you will have the opportunity to expand your knowledge on insects.";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.la_vanille_9;
                        model.text4 = "The Crocodile Park section is famous for housing more than 2000 Nile crocodiles in various stages of growth. The centerpiece of the Crocodile Park is the enormous colony of crocodiles, where visitors may hold newborn Nile crocodiles to pose for photos.It is a great place to broaden your knowledge of this reptile that coexisted with humans before the dinosaur eraand observe firsthand how they have adapted their physical characteristics to survive throughout history. Every day at 11:30 am there is a free crocodile feeding display.<br>" +
                                "The Park is home to the world's largest artificial Aldabra tortoise habitat. Thanks to the park's specialized breeding facilities, the number of tortoises has increased to over a thousand. You are free to approach and feed them.<br>" +
                                "The La Vanille Nature Park is a comprehensive institution designed to preserving the earth's wonderful environment. The Park features a wide range of natural elements, including trees, plants, animals, insects, marine life, and fossils preserved in their most authentic form. <br>";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.la_vanille_6;
                        model.text9 = "When you hike in the La Vanille Nature Park you will feel you are close to nature.The serene atmosphere of strolling along a well-kept path becomes even more thrilling as nature presents itself to you at every turn. Indeed, you will discover the park's surrounding beautiful green forest and will be enthralled with the ponds and unique wildlife where you may come across the giant tortoises and friendly deer strolling alongside you. For those with a keen eye for photography and the ability to engage with wildlife, this location is a photographer's paradise.<br>" +
                                "Actively participating in the preservation of nature, the La Vanille Nature Park works on numerous programs to plant over 350,000 domestic trees and endangered animal breeds in their facilities.<br>" +
                                "The Crocodile Park Shop sells a variety of merchandise such as handcrafted souvenirs from Mauritius, crocodile-inspired items, and books about animals. <br>";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.la_vanilla_8;
                        model.text11 = "A wonderful way to end your wildlife excursion is with a meal of good food and relaxation in a cozy setting at the Crocodile Park Restaurant. Located in the forest, the restaurant provides a range of choices for both adults and children.To make up for the craziest supper of your life, Le Crocodile Affamé serves a distinctive cuisine made with crocodile meat. Those who try it can't help but compliment the dish.";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "<b>Opening hours:</b><br> Every day from 8:30 to 17:00";
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                        //                        Toast.makeText(context, "images are no available", Toast.LENGTH_SHORT).show();
                    }
                    else if (position == 2) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.gris_gris_1;
                        model.text1 = "The primary beach area features an expansive green field with a commanding view of dramatic cliffs and enormous waves. There are benches and a pavilion available for relaxation while taking in the scenery.<br>" +
                                "To the left, a concrete staircase descends to the beach, but swimming is strongly discouraged due to the high danger level. The powerful waves can swiftly overwhelm swimmers. Instead, enjoy a leisurely stroll along the beach, heading toward a small cave at the far end.<br>";
                        model.title1 = "Caves at Gris Gris";
                        model.image1 = R.drawable.grisgris_2;
                        model.text2 = "In addition to the cave on the far left side of the beach, two other hidden caves can be discovered at Gris Gris. These are more challenging to reach, involving a descent down a cliff and walking through the water.<br>" +
                                "Caution is advised against going all the way down, as water levels can fluctuate unpredictably, and the current is often too strong.<br>" +
                                "For those eager to explore the secret caves at Gris Gris, head towards the cliff's edge directly across from the parking lot. Upon reaching the spot, descend only about halfway to catch a glimpse of the caves on your right.<br>" +
                                "It'simportant to bear in mind that entering the caves could pose risks if the water level rises!<br>" +
                                "Gris Gris beach is intricately connected to the village of Souillac, which relies heavily on tourism for its revenue. Established 200 years ago as a port for ships sailing from Europe to India, Souillac has a rich history worth exploring. Plan your day strategically to make the most of your visit to the southern part of Mauritius, and consider including a visit to Rochester Falls, just outside the village, renowned for its distinctive rectangular-sided rocks.<br>";
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                }
                else if (Stash.getString("day").equals("day33")) {
                    if (position == 0) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    } else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    } else if (position == 2) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }

                    else if (position == 3) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    } else if (position == 4) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                }
                else if (Stash.getString("day").equals("day41")) {
                    if (position == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.sugar_museum_pamplemousses;
                        model.text1 = "Located not too far from the Pamplemousse Botanical Garden, amidst a picturesque setting featuring a bougainvillea and coconut tree-lined alley, a pond surrounded by lush greenery, stands the impressively renovated sugar mill—a truly spectacular attraction on the island!<br>" +
                                "From the moment the Dutch set foot in Mauritius and introduced sugar canes to the island, the sugar industry has played a significant role in the island's history. At L'Aventure du Sucre, you'll delve into the intricacies of the sugar-making process and explore the colonial past that has profoundly shaped Mauritius into what it is today. Traverse a 250-year historical journey within the museum, a former operational sugar factory, and conclude your tour with a delightful sugar tasting experience, along with sampling various products derived from the golden era of colonial centuries.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.laventure_du_sucre;
                        model.text2 ="Embark on your museum tour by delving into the history of sugar plantations in Mauritius. Gain insights into the Dutch era, succeeded by the French and eventually the English colonists. Following this historical exploration, proceed to the operational factory, which remained active until the 1970s. Immerse yourself in the intricate stages of the sugar-making process showcased in vivid detail. Complement your visit to L'Aventure du Sucre by exploring the Village Boutik for gift shopping and souvenirs. Alternatively, enjoy a delightful pause at Restaurant Le Fangourin, savoring the nuances of Mauritian cuisine.";
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }

                    else if (position == 2) {
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 3) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.port_louis_3;
                        model.text1 = "Le Caudan Waterfront is as a prominent commercial development in Port Louis, the capital city of Mauritius, offering a diverse array of amenities such as shops, banking facilities, casinos, cinemas, restaurants, a marina, and the renowned five-star hotel, Le Labourdonnais.";
                        model.title1 = "Historical Roots:";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "The name \"Le Caudan Waterfront\" pays homage to Jean Dominique Michel de Caudan, a notable figure who arrived in the former Isle de France from Languedoc, a historical province in the South of France, in 1726. He initiated a saltpan near a small bay in the southwest of Port-Louis, now recognized as the Robert Edward Hart Garden, situated on the entrance road to Le Caudan Waterfront.<br>" +
                                "The peninsula of Le Caudan, formed around a fossil coral islet, witnessed the evolution of various structures over 250 years, including a powder magazine, an astronomical and meteorological observatory, quays, warehouses, and small enterprises. The sugar industry significantly influenced the harbor's daily activities until the establishment of the Bulk Sugar Terminal in 1980. Today, only a few remaining walls bear testament to the bustling activities that transpired over 150 years.<br>";
                        model.title2 = "Historically Significant Spots";
                        model.text3 = "Several areas within Le Caudan Waterfront hold historical significance. The first meteorological observatory in the Indian Ocean, now home to the Food Court and the Namasté restaurant, is one such spot. The Blue Penny Museum occupies the former Docks office building.<br>" +
                                "The naming of different wings within the complex reflects episodes from the country's colonial history:<br>" +
                                "Barkly Wharf: Named after Sir Henry Barkly, a Member of Parliament of the British government and appointed governor of Mauritius from 1863-1870.<br>" +
                                "Le Pavillon wing: Derived from Pavillon Street on an ancient map of Port Louis, speculated to have origins during the period when Port Louis was called ‘Port Napoléon.’<br>" +
                                "Dias Pier: A tribute to Diogo Dias, brother of the famous navigator Barthoulomeu Dias, believed to be the first to record the Mascarene Islands on a navigation map.<br>";
                        model.image2 = R.drawable.map_location;
                        model.text4 = "";
                        model.title3 = "Modern Day Attraction";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.port_louis_13;
                        model.text9 = "Caudan, commonly known today, was the island's first major shopping development, and it continues to be an iconic shopping destination for both locals and tourists. The mall features the latest fashion trends, a popular Craft Market, specialty shops offering unique local goods, cinemas, a marina, a bookstore, restaurants, cafes, a museum housing two of the rarest stamps globally, a casino, and tax-free shopping for tourists.";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.port_louis_6;
                        model.text11 = "Despite being the first shopping mall on the island, Caudan has adeptly adapted to current trends, maintaining its appeal as a modern waterfront mall. Visitors can witness the bustling port activities as large container and cruise ships navigate in and out.";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 4) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 5) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }

                }
                else if (Stash.getString("day").equals("day42")) {
                    if (position == 0) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }

                }
                else if (Stash.getString("day").equals("day43")) {
                    if (position == 0) {
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    } else if (position == 1) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 2) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                else if (position == 3)
                {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                else if (position == 4)
                {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }      else if (position == 5)
                {
                    BeacModel model = new BeacModel();
                    model.title = textView.getText().toString();
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
                    Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                }
                else if (Stash.getString("day").equals("day44")) {
                    if (position == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.eau_bleu_1;
                        model.text1 = "This waterfall is breathtakingly beautiful, soothing both the eyes and the soul. The Eau Bleu Waterfall, so named for its turquoise ponds, is a must-visit site for all adventurers and environment enthusiasts.The spectacular views of the Eau Bleu Waterfall will surely enchant visitors. <br>" +
                                "The Eau Bleu Waterfall is located on the southeast side of the island, about 20 minutes from Curepipe and roughly 45 minutes from Port Louis.It is a must-visit site for anyone wishing to discover Mauritius' hidden gems and is perfect for a weekend escape.<br>";
                        model.title1 = "";
                        model.image1 = R.drawable.eau_bleue_5;
                        model.text2 = "The waterfall, also known as Cascade Rama originates from the Eau Bleu reservoir. It got its name from the beautiful crystal blue color and clear water of Eau Bleu. This particular color so natural to Eau Bleu is due to the fact that it gets its summertime water from underground water springs, which gives the river and ponds their characteristic turquoise glare.<br>" +
                                "The more adventurous ones will be able to enjoy canoeing and cliff jumps at Eau Bleu. With five or so waterfalls that range in height from eight to fifteen meters, Eau Bleu offer opportunities to the more adventurous ones to enjoy canoeing and cliff jumps. Swimming and diving into the cool pond water are other great activities in this area.<br>" +
                                "It is advised to have at least basic swimming skills, even if it is not hazardous for novices to swim in the pond. It's helpful to know that swimming or diving should be avoided right after a heavy meal or after consuming alcohol. Note that the season has an impact on the ponds' water level.<br>";
                        model.title2 = "";
                        model.text3 = "";
                        model.image2 = R.drawable.eau_bleu_3;
                        model.text4 = "Make sure you have the appropriate attire, sunscreen, sunglasses, and closed-toe shoes if you choose to explore all five waterfalls. Hiking in the area requires an average degree of fitness as well. Keep an eye out for trails that are steep or that are covered in roots and dense vegetation. Be advised that during the rainy season the areais slippery.";
                        model.title3 = "";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.eau_bleu_4;
                        model.text9 = "The area's rich, green vegetation makes Eau Bleu an ideal peaceful place to unwind. The areawill undoubtedly soothe your eyes and infuse your body and mind with uplifting vibes. Several businesses plan canoe trips to Eau Bleu and other outdoor activities. Adventurers of all experience levels can enjoy these activities as well.<br>" +
                                "The rainy season, which runs from January to March, is the ideal time to explore Eau Bleu because every waterfall is at its peak.<br>" +
                                "Although you can still go from April to August, unless it has been raining for a few days beforehand, the water level may be lower.<br>" +
                                "It should be noted that between September and the beginning of December, some of the waterfalls may be totally dry.<br>";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.map_location;
                        model.text11 = "";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.pont_naturel_2;
                        model.text1 = "Located in the south of Mauritius, the Pont Naturel (Natural Bridge) is a bridge made entirely of natural rock formations that were created by nature. Here, you'll experience complete relaxation from the breathtaking cliffs' beauty and the serenity of the surrounds. <br>";
                        model.title1 = "";
                        model.image1 = R.drawable.pont_naturel_3;
                        model.text2 = "If you're daring enough, you can cross the bridge, but you should exercise extreme caution because the strong currents could quickly carry you away if you slip and fall on the occasionally slippery rock surface. Still, it's one of the island's most tranquil and picturesque locations for photo shooting.";
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 2) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.le_souffleur_1;
                        model.text1 = "Hiking to Le Souffleur is undoubtedly one of the best things to do in Mauritius because of the area's distinctive rock formations, powerful waves that crash against the cliffs, causing enormous water sprays, and a hidden beach that few visitors ever visit.\n" +
                                "Le Souffleur is conveniently close to Pont Naturel and Gris Gris beach, so you should consider organizing a quick road trip to visit all three places in one day.\n" +
                                "Le Souffleur is located near the village of L'Escalier in the southern region of Mauritius. There are no buses that will transport you to the beach, so you'll need to rent a car to get there. Even so, if you rely solely on Google Maps to get you to Le Souffleur you almost certainly will get lost.The best way to reach to your destination is using Google Maps and search for \"Savannah Sugar Industry.\" Follow the driving directions until you arrive at a roundabout with a sign directing you to Le Souffleur.\n";
                        model.title1 = "";
                        model.image1 = R.drawable.le_souffleur_2;
                        model.text2 ="One of Mauritius' most distinctive natural attractions, Le Souffleur is a place where you may even see the amazing blowhole effect if the sea is rough that day. As waves crash against the cliffs and rock cracks you will be able to watch the huge awe-inspiringwater jets flying in the air. You shouldn't miss it if you're visiting Mauritius - it's an amazing sight!\n" +
                                "The gorgeous golden sand beach of Savinia, which is by far the least populated beach in Mauritius, is the last stop downhill on the right. You will also find two naturally occurring arches which should not be mistaken with the Pont Naturel, another natural attraction.Just a few meters before you reach theSavinia Beach, you will find another small cove. Unfortunately, the strong current makes swimming there impossible.\n";
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
                    }
                    else if (position == 3) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.gris_gris_1;
                        model.text1 = "The primary beach area features an expansive green field with a commanding view of dramatic cliffs and enormous waves. There are benches and a pavilion available for relaxation while taking in the scenery.\n" +
                                "To the left, a concrete staircase descends to the beach, but swimming is strongly discouraged due to the high danger level. The powerful waves can swiftly overwhelm swimmers. Instead, enjoy a leisurely stroll along the beach, heading toward a small cave at the far end.\n";
                        model.title1 = "Secret Caves at Gris Gris";
                        model.image1 = R.drawable.grisgris_2;
                        model.text2 = "In addition to the cave on the far left side of the beach, two other hidden caves can be discovered at Gris Gris. These are more challenging to reach, involving a descent down a cliff and walking through the water.\n" +
                                "Caution is advised against going all the way down, as water levels can fluctuate unpredictably, and the current is often too strong.\n" +
                                "For those eager to explore the secret caves at Gris Gris, head towards the cliff's edge directly across from the parking lot. Upon reaching the spot, descend only about halfway to catch a glimpse of the caves on your right.\n" +
                                "It's important to bear in mind that entering the caves could pose risks if the water level rises!\n" +
                                "Gris Gris beach is intricately connected to the village of Souillac, which relies heavily on tourism for its revenue. Established 200 years ago as a port for ships sailing from Europe to India, Souillac has a rich history worth exploring. Plan your day strategically to make the most of your visit to the southern part of Mauritius, and consider including a visit to Rochester Falls, just outside the village, renowned for its distinctive rectangular-sided rocks.\n" + "The name \"Gris Gris\" adds an intriguing dimension to the experience. Upon entering the beach, a large sign displays the history behind the name. According to local tradition, \"Gris Gris\" is linked to the African amulet known as the “Gris Gris” and its association with the tumultuous coastline. However, the story takes an unexpected turn, suggesting that Gris Gris might have been the name of a puppy belonging to a French cartographer who visited the coast in 1753.<br>";
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 4) {

                         BeacModel model = new BeacModel();
                         model.title = textView.getText().toString();
                         model.main_image = R.drawable.la_roche_qui_pleure;
                         model.text1 = "This mystical site derives its name from the visual impression it creates: as water trickles down its walls, the cliffs appear to shed tears. Even more astonishing, some claim to recognize the eroded features of the Mauritian poet Robert Edward Hart.<br>\" + \"From a geographical and climatic standpoint, unlike other parts of the island, La Roche qui Pleure lacks coral reefs. Consequently, its shores are more exposed to the assaults of the ocean. This absence of a natural barrier results in more powerful and spectacular waves, a stark contrast to the tranquil lagoons typically associated with the island. The region is influenced by strong winds and seasonal variations, shaping its unique landscape and marine dynamics.<br>";
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
                         model.text11 = "" + "From a geographical and climatic standpoint, unlike other parts of the island, La Roche qui Pleure lacks coral reefs. Consequently, its shores are more exposed to the assaults of the ocean. This absence of a natural barrier results in more powerful and spectacular waves, a stark contrast to the tranquil lagoons typically associated with the island. The region is influenced by strong winds and seasonal variations, shaping its unique landscape and marine dynamics.<br>";
                         model.image5 = R.drawable.map_location;
                         model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 5) {

                         BeacModel model = new BeacModel();
                         model.title = textView.getText().toString();
                         model.main_image = R.drawable.rochester_falls_1;
                         model.text1 = "Although Rochester Falls may not rank as the most breathtaking waterfalls in the country, they are undeniably worth exploring if you find yourself nearby. Simply follow the makeshift signs guiding you from the main road through Souillac. The route, while a bit intricate, is reliable, albeit a tad rough along the stony track. Be prepared for local vendors who might expect a tip for assisting you in finding a parking spot. Following a brief five-minute walk from your vehicle, you'll arrive at the cascading waterfall emerging from the cane fields.<br>" +
                                 "Situated in the southern part of the island, within the Souillac district, Rochester Falls exemplifies the distinctive volcanic formations and the historical background of Mauritius as a volcanic island. What sets this waterfall apart is its unique appearance, with water flowing through rock formations that resemble square blocks, creating a captivating illusion unlike any other waterfall on the island.<br>" +
                                 "Popular among both locals and visitors, the falls offer a serene pond for swimming, tucked away in a lush, untamed forest, providing a peaceful escape from the hustle and bustle of civilization. This secluded setting makes it an ideal location for a day out with friends, emphasizing the appeal of nature's untouched beauty. <br>";
                         model.title1 = "A few tips";
                         model.image1 = R.drawable.map_location;
                         model.text2 = "\t1.\tNot recommended to visit during or after heavy rainfall.<br>" +
                                 "\t2.\tExercise caution if engaging in cliff jumping, as surfaces may be slippery.<br>";
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
                         model.text11 = "" + "From a geographical and climatic standpoint, unlike other parts of the island, La Roche qui Pleure lacks coral reefs. Consequently, its shores are more exposed to the assaults of the ocean. This absence of a natural barrier results in more powerful and spectacular waves, a stark contrast to the tranquil lagoons typically associated with the island. The region is influenced by strong winds and seasonal variations, shaping its unique landscape and marine dynamics.<br>";
                         model.image5 = R.drawable.map_location;
                         model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 6) {
                        BeacModel model = new BeacModel();
                         model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 7) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.la_prairie_2;
                        model.text1 = "While driving down Mauritius' lovely southern coastline road, it is difficult not to be captivated by the little beach of La Prairie. The short grass that grows all the way to the water's edge gives the area its name and contributes to its allure. There are plenty of quaint little locations to escape the crowd, and the vast lagoon is just a feast to the eyes. Located in the southwest region of Mauritius, Prairie Beach is close to the community of Baie-du-Cap. It is one of Mauritius' many beaches in the Savanne region.";
                        model.title1 = "";
                        model.image1 = R.drawable.la_prairie_1;
                        model.text2 ="Nestled between the charming village of Baie-du-Cap and Le Morne, la Prairie is a wonderful spot to see the famous Le Morne Brabant mountain. Usually, the beach is not crowded during weekdays, but it can get pretty busy on weekends and holidays.<br>" +
                                "Although swimming is not recommended because of the strong sea currents, the location is still perfect for picnicking or sunbathing.<br>";
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                }
                else if (Stash.getString("day").equals("day51")) {
                    if (position == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.port_louis_3;
                        model.text1 = "Le Caudan Waterfront is as a prominent commercial development in Port Louis, the capital city of Mauritius, offering a diverse array of amenities such as shops, banking facilities, casinos, cinemas, restaurants, a marina, and the renowned five-star hotel, Le Labourdonnais.";
                        model.title1 = "Historical Roots:";
                        model.image1 = R.drawable.map_location;
                        model.text2 = "The name \"Le Caudan Waterfront\" pays homage to Jean Dominique Michel de Caudan, a notable figure who arrived in the former Isle de France from Languedoc, a historical province in the South of France, in 1726. He initiated a saltpan near a small bay in the southwest of Port-Louis, now recognized as the Robert Edward Hart Garden, situated on the entrance road to Le Caudan Waterfront.<br>" +
                                "The peninsula of Le Caudan, formed around a fossil coral islet, witnessed the evolution of various structures over 250 years, including a powder magazine, an astronomical and meteorological observatory, quays, warehouses, and small enterprises. The sugar industry significantly influenced the harbor's daily activities until the establishment of the Bulk Sugar Terminal in 1980. Today, only a few remaining walls bear testament to the bustling activities that transpired over 150 years.<br>";
                        model.title2 = "Historically Significant Spots";
                        model.text3 = "Several areas within Le Caudan Waterfront hold historical significance. The first meteorological observatory in the Indian Ocean, now home to the Food Court and the Namasté restaurant, is one such spot. The Blue Penny Museum occupies the former Docks office building.<br>" +
                                "The naming of different wings within the complex reflects episodes from the country's colonial history:<br>" +
                                "Barkly Wharf: Named after Sir Henry Barkly, a Member of Parliament of the British government and appointed governor of Mauritius from 1863-1870.<br>" +
                                "Le Pavillon wing: Derived from Pavillon Street on an ancient map of Port Louis, speculated to have origins during the period when Port Louis was called ‘Port Napoléon.’<br>" +
                                "Dias Pier: A tribute to Diogo Dias, brother of the famous navigator Barthoulomeu Dias, believed to be the first to record the Mascarene Islands on a navigation map.<br>";
                        model.image2 = R.drawable.map_location;
                        model.text4 = "";
                        model.title3 = "Modern Day Attraction";
                        model.text5 = "";
                        model.title4 = "";
                        model.text6 = "";
                        model.title5 = "";
                        model.text7 = "";
                        model.title6 = "";
                        model.text8 = "";
                        model.title7 = "";
                        model.image3 = R.drawable.port_louis_13;
                        model.text9 = "Caudan, commonly known today, was the island's first major shopping development, and it continues to be an iconic shopping destination for both locals and tourists. The mall features the latest fashion trends, a popular Craft Market, specialty shops offering unique local goods, cinemas, a marina, a bookstore, restaurants, cafes, a museum housing two of the rarest stamps globally, a casino, and tax-free shopping for tourists.";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.port_louis_6;
                        model.text11 = "Despite being the first shopping mall on the island, Caudan has adeptly adapted to current trends, maintaining its appeal as a modern waterfront mall. Visitors can witness the bustling port activities as large container and cruise ships navigate in and out.";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 3) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 2) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 4) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                }
                else if (Stash.getString("day").equals("day52")) {
                    if (position == 0) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 2) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 3) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 4) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                }
                else if (Stash.getString("day").equals("day53")) {
                    if (position == 0) {
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 2) {

                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.martello_tower_4;
                        model.text1 = "To enhance your holiday experience in Mauritius, be sure to explore the Martello Tower Museum. Prepare to be fascinated by the artifacts, and the living conditions that characterize this historical period.As a relic of Mauritius' history, the Martello Tower Museum, located on the La Preneuse beach in Black River, is essential for those seeking a deeper understanding of the island's past.<br>" +
                                "<b>Origin of the Martello Towers</b> <br>" +
                                "The British first encountered one of these fortresses during a fierce battle at Mortella Bay in Corsica in 1794. Manned by the French, the tower impressed the British, who decided to build similar structures to safeguard their empire. Remnants of these towers can still be found in some former colonies and along the shores of England, characterized by a conical shape, thick walls, and slight variations.<br>" +
                                "<b>The Martello Tower in Mauritius</b> <br>" +
                                "The Martello Tower at La Preneuse has been meticulously restored and converted into a Heritage Museum. Nestled among casuarina trees, it stands as a testament to history.<br>" +
                                "<b>Is it Martello or Mortella?</b> <br>" +
                                "Contrary to a common misconception, 'Mortella' and 'Martello' are not related. Mortella Bay is named after a shrub abundant in Corsica, where the battle took place. 'Martello' means hammer in Italian, and in the past, a fire on the tower's flat roof served as a warning of approaching enemies. In Italy, the alarm was signaled by striking a bell with a hammer or 'martello.'<br>" +
                                "<b>The Story behind the Martello Towers in Mauritius</b><br>" + "The primary aim of the park is to safeguard a significant portion of the island's remaining rainforest, even though parts of it have suffered degradation due to the introduction of non-native plants like Chinese guava and privet, as well as the presence of invasive animals such as the rusa deer and wild pigs. To preserve native wildlife, specific areas within the park have been cordoned off, and efforts have been made to eliminate invasive species. <br>";
                        model.title1 = "";
                        model.image1 = R.drawable.matello_tower_1;
                        model.text2 = "In the early 19th century, after the British captured Mauritius, concerns arose about a potential French insurrection with the abolition of slavery and the end of free labor. To protect the island, the British decided to construct five Martello Towers along the west coast at strategic locations near river mouths.<br>" +
                                "The Martello towers wereprimarily built using basalt rock. The construction involved royal engineers, skilled stonecutters from India, carpenters, and, regrettably, slave labor for heavy tasks. Sand dunes called batteries were erected in front of the towers by the slaves. Each tower featured two cannons on the flat rooftop, capable of 360-degree rotation. The construction of the five towers spanned three years, but they never saw any action.<br>";
                        model.title2 = "The Tower turned into a Museum";
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 3) {
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
                        model.text2 = "The flora is exceptionally varied, encompassing 73 out of the 311 species of flowering plants that are exclusive to Mauritius. Among these, the L’Immortelle Du Morne, or Helichrysum Mauritianum, stands out as an endemic species found specifically on the mountain.";      model.title2 = "About the Rum of Rhumerie de Chamarel ";
                        model.text3 = "";
                        model.image2 = R.drawable.brabant_8;
                        model.text4 ="The International Slave Route Monument is a tangible representation of the historical impact of slavery in Mauritius and globally. The central monument is encircled by nine smaller stone sculptures, symbolizing the origins and destinations of enslaved individuals.";
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 4) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                }
                else if (Stash.getString("day").equals("day54")) {                     if (position == 0) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 1) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 2) {

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
                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 3) {

                    BeacModel model = new BeacModel();
                    model.title = textView.getText().toString();
                    model.main_image = R.drawable.gris_gris_1;
                    model.text1 = "The primary beach area features an expansive green field with a commanding view of dramatic cliffs and enormous waves. There are benches and a pavilion available for relaxation while taking in the scenery.\n" +
                            "To the left, a concrete staircase descends to the beach, but swimming is strongly discouraged due to the high danger level. The powerful waves can swiftly overwhelm swimmers. Instead, enjoy a leisurely stroll along the beach, heading toward a small cave at the far end.\n";
                    model.title1 = "Secret Caves at Gris Gris";
                    model.image1 = R.drawable.grisgris_2;
                    model.text2 = "In addition to the cave on the far left side of the beach, two other hidden caves can be discovered at Gris Gris. These are more challenging to reach, involving a descent down a cliff and walking through the water.\n" +
                            "Caution is advised against going all the way down, as water levels can fluctuate unpredictably, and the current is often too strong.\n" +
                            "For those eager to explore the secret caves at Gris Gris, head towards the cliff's edge directly across from the parking lot. Upon reaching the spot, descend only about halfway to catch a glimpse of the caves on your right.\n" +
                            "It's important to bear in mind that entering the caves could pose risks if the water level rises!\n" +
                            "Gris Gris beach is intricately connected to the village of Souillac, which relies heavily on tourism for its revenue. Established 200 years ago as a port for ships sailing from Europe to India, Souillac has a rich history worth exploring. Plan your day strategically to make the most of your visit to the southern part of Mauritius, and consider including a visit to Rochester Falls, just outside the village, renowned for its distinctive rectangular-sided rocks.\n" + "The name \"Gris Gris\" adds an intriguing dimension to the experience. Upon entering the beach, a large sign displays the history behind the name. According to local tradition, \"Gris Gris\" is linked to the African amulet known as the “Gris Gris” and its association with the tumultuous coastline. However, the story takes an unexpected turn, suggesting that Gris Gris might have been the name of a puppy belonging to a French cartographer who visited the coast in 1753.<br>";
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 4) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.la_roche_qui_pleure;
                        model.text1 = "This mystical site derives its name from the visual impression it creates: as water trickles down its walls, the cliffs appear to shed tears. Even more astonishing, some claim to recognize the eroded features of the Mauritian poet Robert Edward Hart.<br>" +
                                "From a geographical and climatic standpoint, unlike other parts of the island, La Roche qui Pleure lacks coral reefs. Consequently, its shores are more exposed to the assaults of the ocean. This absence of a natural barrier results in more powerful and spectacular waves, a stark contrast to the tranquil lagoons typically associated with the island. The region is influenced by strong winds and seasonal variations, shaping its unique landscape and marine dynamics.<br>";
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
                        model.text9 ="";
                        model.title8 = "";
                        model.text10 = "";
                        model.image4 = R.drawable.map_location;
                        model.text11 = "";
                        model.image5 = R.drawable.map_location;
                        model.text12 = "";

                        Stash.put("model", model);
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                    else if (position == 5) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }      else if (position == 6) {
                        BeacModel model = new BeacModel();
                        model.title = textView.getText().toString();
                        model.main_image = R.drawable.la_prairie_2;
                        model.text1 = "While driving down Mauritius' lovely southern coastline road, it is difficult not to be captivated by the little beach of La Prairie. The short grass that grows all the way to the water's edge gives the area its name and contributes to its allure. There are plenty of quaint little locations to escape the crowd, and the vast lagoon is just a feast to the eyes. Located in the southwest region of Mauritius, Prairie Beach is close to the community of Baie-du-Cap. It is one of Mauritius' many beaches in the Savanne region.";
                        model.title1 = "";
                        model.image1 = R.drawable.la_prairie_1;
                        model.text2 ="Nestled between the charming village of Baie-du-Cap and Le Morne, la Prairie is a wonderful spot to see the famous Le Morne Brabant mountain. Usually, the beach is not crowded during weekdays, but it can get pretty busy on weekends and holidays.<br>" +
                                "Although swimming is not recommended because of the strong sea currents, the location is still perfect for picnicking or sunbathing.<br>";
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }
                }
                else if (Stash.getString("day").equals("day55")) {
                    if (position == 0) {
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
                        intent = new Intent(context, ItenerariesDetails.class);
                        context.startActivity(intent);
                    }

                }

            }
        });
        return itemView;
    }


}
