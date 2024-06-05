package com.moutamid.sqlapp.activities.AboutMauritius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fxn.stash.Stash;
import com.moutamid.sqlapp.R;
import com.moutamid.sqlapp.activities.Beaches.BeachDetails;
import com.moutamid.sqlapp.model.BeacModel;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void introduction(View view) {
        BeacModel model = new BeacModel();
        model.title ="Introduction";

        model.main_image = R.drawable.mauritius_flag; // Set the value for main_image

        model.text1 = "Mauritius, officially the Republic of Mauritius, is an island country in the Indian Ocean, about 2,000 kilometres (1,100 nautical miles) off the southeastern coast of East Africa, east of Madagascar. It includes the main island (also called Mauritius), as well as Rodrigues, Agaléga, and St. Brandon (CargadosCarajos shoals). The islands of Mauritius including Agalega, St. Brandon and Rodrigues, along with nearby Réunion (a French overseas department), are part of the Mascarene Islands. The main island of Mauritius, where the population is concentrated, hosts the capital and largest city, Port Louis. The country spans 2,040 square kilometres (790 sq mi) and has an exclusive economic zone covering 2,300,000 square kilometres (670,000 square nautical miles).";
        model.title1 = "";

        model.image1 = R.drawable.map_location; // Set the value for image1

        model.text2 = "Based on verbal accounts and the 1502 Cantino planisphere, Arab traders in the Indian Ocean may have been among the first to discover and name the uninhabited island, around 975 AD, as Dina ArobiIn 1507, Portuguese sailors blown off course from the Madagascar channel on their way to India visited the uninhabited island naming it Cirne ('cisne' or 'swan' in modern day Portuguese), Ilha do Cerne on 16th Century Portuguese maps. A Dutch fleet, under the command of Admiral Van Warwyck, landed at what is now the Grand Port District and took possession of the island in 1598, renaming the uninhabited islands after Maurice, Prince of Orange. A succession of short-lived Dutch attempts at permanent settlement took place over a century with the aim of exploiting the local ebony forests, establishing a consistent sugar and arrack production using cane plant cuttings imported from Java together with over three hundred Malagasy slaves, before abandoning their efforts.France took the uninhabited island in 1715, renaming the island \"Isle de France\". In 1810, the United Kingdom seized the island, and four years later, under the Treaty of Paris, France ceded Mauritius and its dependencies to the United Kingdom. The British colony of Mauritius included Rodrigues, Agaléga, St. Brandon, the Chagos Archipelago, and, until 1906, the Seychelles. Mauritius and France dispute sovereignty over the island of Tromelin, as the treaty failed to mention it specifically. Mauritius became the British Empire's main sugar-producing colony and remained a primarily sugar-dominated plantation-based colony until independence, in 1968.";
        model.title2 = "";
        model.text3 = "";

//        model.image2 = R.drawable.mauritius_territory; // Set the value for image2

        model.text4 = "In 1965, the UK paid Mauritius and excised the Chagos Archipelago from Mauritian territory to create the British Indian Ocean Territory (BIOT). The local population was forcibly expelled and the largest island, Diego Garcia, was leased to the United States. Ruling on the sovereignty dispute between Mauritius and the UK, the International Tribunal for the Law of the Sea requested the return of the Chagos Islands to Mauritius but had no legal jurisdiction in the matter.\n" +
                "<br>Given its geographic location and colonial past, the people of Mauritius is diverse in ethnicity, culture, language and faith. It is the only country in Africa where Hinduism is the most practised religion. Indo-Mauritians make up the bulk of the population with significant Creole, Sino-Mauritian and Franco-Mauritian minorities. The island's government is closely modelled on the Westminster parliamentary system with Mauritius highly ranked for economic and political freedom being listed by the Economist's Democracy Index as the only country in Africa with full democracy. Mauritius is the only African country with a very high Human Development Index, and the World Bank classifies it as a high-income economy. It is amongst the most competitive and most developed economies in the African region. The government provides free universal healthcare, free education up through the tertiary level and free public transportation for students, senior citizens, and the disabled. Mauritius is consistently ranked as the most peaceful when compared to African countries.\n" +
                "<br>Along with the other Mascarene Islands and, especially the CargadosCarajos shoals, Mauritius is known for its biodiverse flora and fauna and its endemism. The main island is known for the demise of the dodo, which, along with several other avian species, became extinct soon after human settlement. Other endemic animals, such as the echo parakeet, the Mauritius kestrel and the pink pigeon, have survived and are subject to intensive and successful conservation efforts.\n";
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
        Intent intent = new Intent(AboutActivity.this, BeachDetails.class);
        startActivity(intent);
    }

    public void etymology(View view) {
        BeacModel model = new BeacModel();
        model.title ="Etymology";

        model.main_image = R.drawable.etymology; // Set the value for main_image

        model.text1 = "The first historical evidence of the existence of the island now known as Mauritius is on a 1502 map called the Cantino planisphere which was smuggled out of Portugal, for the Duke of Ferrara, by the Italian 'spy' Alberto Cantino. On this stolen Portuguese map, Mauritius bore the name Dina Arobi. In 1507, Portuguese sailors visited the uninhabited island. The island appears with the Portuguese names Cirne or Do-Cerne on early Portuguese maps, probably from the name of a ship in the 1507 expedition.";
        model.title1 = "";

        model.image1 = R.drawable.map_location; // Set the value for image1

        model.text2 = "In 1598, a Dutch squadron under Admiral Wybrand van Warwyck landed at Grand Port and named the island Mauritius, in honour of Prince Maurice van Nassau, stadtholder of the Dutch Republic. Later the island became a French colony and was renamed Isle de France. On 3 December 1810, the French surrendered the island to the United Kingdom during the Napoleonic Wars. Under British rule, the island's name reverted to Mauritius. Mauritius is also commonly known as Maurice (and Île Maurice in French, Moris) in Mauritian Creole.";
        model.title2 = "";
        model.text3 = "";

//        model.image2 = R.drawable.mauritius_territory; // Set the value for image2

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
        Intent intent = new Intent(AboutActivity.this, BeachDetails.class);
        startActivity(intent);
    }

    public void history(View view) {
        BeacModel model = new BeacModel();
        model.title ="History";

        model.main_image = R.drawable.mauritius_history; // Set the value for main_image

        model.text1 = "The island of Mauritius was uninhabited before its first recorded visit by Arab sailors in the end of the 10th century. Its name Dina Arobi has been associated with Arab sailors who first discovered the island.";
        model.title1 = "";

        model.image1 = R.drawable.map_location; // Set the value for image1

        model.text2 = "The Treaty of Tordesillas purported to give the Kingdom of Portugal the right to colonise this part of the world. In 1507, Portuguese sailors came to the uninhabited island and established a visiting base. Diogo Fernandes Pereira, a Portuguese navigator, was the first European known to land in Mauritius. He named the island \"Ilha do Cisne\" (\"Island of the Swan\"). The Portuguese did not stay long as they were not interested in these islands. The Mascarene Islands were named after Pedro Mascarenhas, Viceroy of Portuguese India, after his visit to the islands in 1512. Rodrigues Island was named after Portuguese explorer Diogo Rodrigues, who first came upon the island in 1528.";
        model.title2 = "";
        model.text3 = "In 1598, a Dutch squadron under Admiral Wybrand Van Warwyck landed at Grand Port and named the island \"Mauritius\" after Prince Maurice of Nassau (Dutch: Maurits van Nassau) of the Dutch Republic. The Dutch inhabited the island in 1638, from which they exploited ebony trees and introduced sugar cane, domestic animals and deer. It was from here that Dutch navigator Abel Tasman set out to seek the Great Southern Land, mapping parts of Tasmania, New Zealand and New Guinea. The first Dutch settlement lasted 20 years. In 1639, the Dutch East India Company brought enslaved Malagasy to cut down ebony trees and to work in the new tobacco and sugar cane plantations. Several attempts to establish a colony permanently were subsequently made, but the settlements never developed enough to produce dividends, causing the Dutch to abandon Mauritius in 1710. A 1755 article in the English Leeds Intelligencer claims that the island was abandoned due to the large number of long tailed macaque monkeys \"which destroyed everything in it,\" and that it was also known at the time as the Island of Monkeys. Portuguese sailors had brought these monkeys to the island from their native habitat in Southeast Asia, prior to Dutch rule.";

//        model.image2 = R.drawable.mauritius_territory; // Set the value for image2

        model.text4 = "";
        model.title3 = "French Mauritius (1715–1810)";
        model.text5 = "France, which already controlled neighbouring Île Bourbon (now Réunion), took control of Mauritius in 1715 and renamed it Isle de France. In 1723, the Code Noir was established to regulate slavery; categorise one group of human beings as \"goods\", for the owner of these goods to be able to obtain insurance money and compensation in case of loss of his \"goods\". The 1735 arrival of French governor Bertrand-François Mahé de La Bourdonnais coincided with development of a prosperous economy based on sugar production. Mahé de La Bourdonnais established Port Louis as a naval base and a shipbuilding centre. Under his governorship, numerous buildings were erected, a number of which are still standing. These include part of Government House, the Château de Mon Plaisir, and the Line Barracks, the headquarters of the police force. The island was under the administration of the French East India Company, which maintained its presence until 1767. During the French rule, slaves were brought from parts of Africa such as Mozambique and Zanzibar. As a result, the island's population rose dramatically from 15,000 to 49,000 within thirty years. During the late eighteenth century, African slaves accounted for around 80 percent of the island's population, and by the early nineteenth century there were 60,000 slaves on the island. In early 1729, Indians from Pondicherry, India, arrived in Mauritius aboard the vessel La Sirène. Work contracts for these craftsmen were signed in 1734 at the time when they acquired their freedom.";
        model.title4 = "";
        model.text6 = "";
        model.title5 = "";
        model.text7 = "";
        model.title6 = "";
        model.text8 = "";
        model.title7 = "";

        model.image3 = R.drawable.jacques_henri_bernardin;

        model.text9 = "From 1767 to 1810, except for a brief period during the French Revolution when the inhabitants set up a government virtually independent of France, the island was controlled by officials appointed by the French government. Jacques-Henri Bernardin de Saint-Pierre lived on the island from 1768 to 1771, then went back to France, where he wrote Paul et Virginie, a love story that made the Isle de France famous wherever the French language was spoken. In 1796 the settlers broke away from French control when the government in Paris attempted to abolish slavery. Two famous French governors were the Vicomte de Souillac (who constructed the Chaussée in Port Louis and encouraged farmers to settle in the district of Savanne) and Antoine Bruni d'Entrecasteaux (who saw to it that the French in the Indian Ocean should have their headquarters in Mauritius instead of Pondicherry in India). Charles Mathieu Isidore Decaen was a successful general in the French Revolutionary Wars and, in some ways, a rival of Napoléon I. He ruled as Governor of Isle de France and Réunion from 1803 to 1810. British naval cartographer and explorer Matthew Flinders was arrested and detained by General Decaen on the island from 1803 to 1810, in contravention of an order from Napoléon. During the Napoleonic Wars, Mauritius became a base from which French corsairs organised successful raids on British commercial ships. ";
        model.title8 = "";
        model.text10 = "";

        model.image4 = R.drawable.isle_of_france;

        model.text11 = "The raids continued until 1810, when a Royal Navy expedition led by Commodore Josias Rowley, R.N., an Anglo-Irish aristocrat, was sent to capture the island. Despite winning the Battle of Grand Port against the British, the French could not prevent the British from landing at Cap Malheureux three months later. They formally surrendered the island on the fifth day of the invasion, 3 December 1810, on terms allowing settlers to keep their land and property and to use the French language and law of France in criminal and civil matters. Under British rule, the island's name reverted to Mauritius." +
                "<br><b>British Mauritius (1810–1968)</b>" +
                "<br>The British administration, which began with Sir Robert Farquhar as its first governor, oversaw rapid social and economic changes. However, it was tainted by the Ratsitatane episode. Ratsitatane, nephew of King Radama of Madagascar, was brought to Mauritius as a political prisoner. He managed to escape from prison and plotted a rebellion that would free the island's slaves. He was betrayed by his associate Laizaf and was caught by a group of militiamen and summarily executed.\n" +
                "<br>In 1832, d'Épinay launched the first Mauritian newspaper (Le Cernéen), which was not controlled by the government. In the same year, there was a move by the procureur-general to abolish slavery without compensation to the slave owners. This gave rise to discontent, and, to check an eventual rebellion, the government ordered all the inhabitants to surrender their arms. Furthermore, a stone fortress, Fort Adelaide, was built on a hill (now known as the Citadel hill) in the centre of Port Louis to quell any uprising.[43] Slavery was gradually abolished over several years after 1833, and the planters ultimately received two million pounds sterling in compensation for the loss of their slaves, who had been imported from Africa and Madagascar during the French occupation. The abolition of slavery had important effects on Mauritius's society, economy and population. The planters brought a large number of indentured labourers from India to work in the sugar cane fields. \n";

        model.image5 = R.drawable.map_location;

        model.text12 = "";
        Stash.put("model", model);
        Intent intent = new Intent(AboutActivity.this, BeachDetails.class);
        startActivity(intent);
    }
public void politics(View view) {
        BeacModel model = new BeacModel();
        model.title ="History";

        model.main_image = R.drawable.mauritius_history; // Set the value for main_image

        model.text1 = "The island of Mauritius was uninhabited before its first recorded visit by Arab sailors in the end of the 10th century. Its name Dina Arobi has been associated with Arab sailors who first discovered the island.";
        model.title1 = "";

        model.image1 = R.drawable.map_location; // Set the value for image1

        model.text2 = "The Treaty of Tordesillas purported to give the Kingdom of Portugal the right to colonise this part of the world. In 1507, Portuguese sailors came to the uninhabited island and established a visiting base. Diogo Fernandes Pereira, a Portuguese navigator, was the first European known to land in Mauritius. He named the island \"Ilha do Cisne\" (\"Island of the Swan\"). The Portuguese did not stay long as they were not interested in these islands. The Mascarene Islands were named after Pedro Mascarenhas, Viceroy of Portuguese India, after his visit to the islands in 1512. Rodrigues Island was named after Portuguese explorer Diogo Rodrigues, who first came upon the island in 1528.";
        model.title2 = "";
        model.text3 = "In 1598, a Dutch squadron under Admiral Wybrand Van Warwyck landed at Grand Port and named the island \"Mauritius\" after Prince Maurice of Nassau (Dutch: Maurits van Nassau) of the Dutch Republic. The Dutch inhabited the island in 1638, from which they exploited ebony trees and introduced sugar cane, domestic animals and deer. It was from here that Dutch navigator Abel Tasman set out to seek the Great Southern Land, mapping parts of Tasmania, New Zealand and New Guinea. The first Dutch settlement lasted 20 years. In 1639, the Dutch East India Company brought enslaved Malagasy to cut down ebony trees and to work in the new tobacco and sugar cane plantations. Several attempts to establish a colony permanently were subsequently made, but the settlements never developed enough to produce dividends, causing the Dutch to abandon Mauritius in 1710. A 1755 article in the English Leeds Intelligencer claims that the island was abandoned due to the large number of long tailed macaque monkeys \"which destroyed everything in it,\" and that it was also known at the time as the Island of Monkeys. Portuguese sailors had brought these monkeys to the island from their native habitat in Southeast Asia, prior to Dutch rule.";

//        model.image2 = R.drawable.mauritius_territory; // Set the value for image2

        model.text4 = "";
        model.title3 = "French Mauritius (1715–1810)";
        model.text5 = "France, which already controlled neighbouring Île Bourbon (now Réunion), took control of Mauritius in 1715 and renamed it Isle de France. In 1723, the Code Noir was established to regulate slavery; categorise one group of human beings as \"goods\", for the owner of these goods to be able to obtain insurance money and compensation in case of loss of his \"goods\". The 1735 arrival of French governor Bertrand-François Mahé de La Bourdonnais coincided with development of a prosperous economy based on sugar production. Mahé de La Bourdonnais established Port Louis as a naval base and a shipbuilding centre. Under his governorship, numerous buildings were erected, a number of which are still standing. These include part of Government House, the Château de Mon Plaisir, and the Line Barracks, the headquarters of the police force. The island was under the administration of the French East India Company, which maintained its presence until 1767. During the French rule, slaves were brought from parts of Africa such as Mozambique and Zanzibar. As a result, the island's population rose dramatically from 15,000 to 49,000 within thirty years. During the late eighteenth century, African slaves accounted for around 80 percent of the island's population, and by the early nineteenth century there were 60,000 slaves on the island. In early 1729, Indians from Pondicherry, India, arrived in Mauritius aboard the vessel La Sirène. Work contracts for these craftsmen were signed in 1734 at the time when they acquired their freedom.";
        model.title4 = "";
        model.text6 = "";
        model.title5 = "";
        model.text7 = "";
        model.title6 = "";
        model.text8 = "";
        model.title7 = "";

        model.image3 = R.drawable.jacques_henri_bernardin;

        model.text9 = "From 1767 to 1810, except for a brief period during the French Revolution when the inhabitants set up a government virtually independent of France, the island was controlled by officials appointed by the French government. Jacques-Henri Bernardin de Saint-Pierre lived on the island from 1768 to 1771, then went back to France, where he wrote Paul et Virginie, a love story that made the Isle de France famous wherever the French language was spoken. In 1796 the settlers broke away from French control when the government in Paris attempted to abolish slavery. Two famous French governors were the Vicomte de Souillac (who constructed the Chaussée in Port Louis and encouraged farmers to settle in the district of Savanne) and Antoine Bruni d'Entrecasteaux (who saw to it that the French in the Indian Ocean should have their headquarters in Mauritius instead of Pondicherry in India). Charles Mathieu Isidore Decaen was a successful general in the French Revolutionary Wars and, in some ways, a rival of Napoléon I. He ruled as Governor of Isle de France and Réunion from 1803 to 1810. British naval cartographer and explorer Matthew Flinders was arrested and detained by General Decaen on the island from 1803 to 1810, in contravention of an order from Napoléon. During the Napoleonic Wars, Mauritius became a base from which French corsairs organised successful raids on British commercial ships. ";
        model.title8 = "";
        model.text10 = "";

        model.image4 = R.drawable.isle_of_france;

        model.text11 = "The raids continued until 1810, when a Royal Navy expedition led by Commodore Josias Rowley, R.N., an Anglo-Irish aristocrat, was sent to capture the island. Despite winning the Battle of Grand Port against the British, the French could not prevent the British from landing at Cap Malheureux three months later. They formally surrendered the island on the fifth day of the invasion, 3 December 1810, on terms allowing settlers to keep their land and property and to use the French language and law of France in criminal and civil matters. Under British rule, the island's name reverted to Mauritius." +
                "<br><b>British Mauritius (1810–1968)</b>" +
                "<br>The British administration, which began with Sir Robert Farquhar as its first governor, oversaw rapid social and economic changes. However, it was tainted by the Ratsitatane episode. Ratsitatane, nephew of King Radama of Madagascar, was brought to Mauritius as a political prisoner. He managed to escape from prison and plotted a rebellion that would free the island's slaves. He was betrayed by his associate Laizaf and was caught by a group of militiamen and summarily executed.\n" +
                "<br>In 1832, d'Épinay launched the first Mauritian newspaper (Le Cernéen), which was not controlled by the government. In the same year, there was a move by the procureur-general to abolish slavery without compensation to the slave owners. This gave rise to discontent, and, to check an eventual rebellion, the government ordered all the inhabitants to surrender their arms. Furthermore, a stone fortress, Fort Adelaide, was built on a hill (now known as the Citadel hill) in the centre of Port Louis to quell any uprising.[43] Slavery was gradually abolished over several years after 1833, and the planters ultimately received two million pounds sterling in compensation for the loss of their slaves, who had been imported from Africa and Madagascar during the French occupation. The abolition of slavery had important effects on Mauritius's society, economy and population. The planters brought a large number of indentured labourers from India to work in the sugar cane fields. \n";

        model.image5 = R.drawable.map_location;

        model.text12 = "";
        Stash.put("model", model);
        Intent intent = new Intent(AboutActivity.this, BeachDetails.class);
        startActivity(intent);
    }
public void wild_life(View view) {
        BeacModel model = new BeacModel();
        model.title ="History";

        model.main_image = R.drawable.mauritius_history; // Set the value for main_image

        model.text1 = "The island of Mauritius was uninhabited before its first recorded visit by Arab sailors in the end of the 10th century. Its name Dina Arobi has been associated with Arab sailors who first discovered the island.";
        model.title1 = "";

        model.image1 = R.drawable.map_location; // Set the value for image1

        model.text2 = "The Treaty of Tordesillas purported to give the Kingdom of Portugal the right to colonise this part of the world. In 1507, Portuguese sailors came to the uninhabited island and established a visiting base. Diogo Fernandes Pereira, a Portuguese navigator, was the first European known to land in Mauritius. He named the island \"Ilha do Cisne\" (\"Island of the Swan\"). The Portuguese did not stay long as they were not interested in these islands. The Mascarene Islands were named after Pedro Mascarenhas, Viceroy of Portuguese India, after his visit to the islands in 1512. Rodrigues Island was named after Portuguese explorer Diogo Rodrigues, who first came upon the island in 1528.";
        model.title2 = "";
        model.text3 = "In 1598, a Dutch squadron under Admiral Wybrand Van Warwyck landed at Grand Port and named the island \"Mauritius\" after Prince Maurice of Nassau (Dutch: Maurits van Nassau) of the Dutch Republic. The Dutch inhabited the island in 1638, from which they exploited ebony trees and introduced sugar cane, domestic animals and deer. It was from here that Dutch navigator Abel Tasman set out to seek the Great Southern Land, mapping parts of Tasmania, New Zealand and New Guinea. The first Dutch settlement lasted 20 years. In 1639, the Dutch East India Company brought enslaved Malagasy to cut down ebony trees and to work in the new tobacco and sugar cane plantations. Several attempts to establish a colony permanently were subsequently made, but the settlements never developed enough to produce dividends, causing the Dutch to abandon Mauritius in 1710. A 1755 article in the English Leeds Intelligencer claims that the island was abandoned due to the large number of long tailed macaque monkeys \"which destroyed everything in it,\" and that it was also known at the time as the Island of Monkeys. Portuguese sailors had brought these monkeys to the island from their native habitat in Southeast Asia, prior to Dutch rule.";

//        model.image2 = R.drawable.mauritius_territory; // Set the value for image2

        model.text4 = "";
        model.title3 = "French Mauritius (1715–1810)";
        model.text5 = "France, which already controlled neighbouring Île Bourbon (now Réunion), took control of Mauritius in 1715 and renamed it Isle de France. In 1723, the Code Noir was established to regulate slavery; categorise one group of human beings as \"goods\", for the owner of these goods to be able to obtain insurance money and compensation in case of loss of his \"goods\". The 1735 arrival of French governor Bertrand-François Mahé de La Bourdonnais coincided with development of a prosperous economy based on sugar production. Mahé de La Bourdonnais established Port Louis as a naval base and a shipbuilding centre. Under his governorship, numerous buildings were erected, a number of which are still standing. These include part of Government House, the Château de Mon Plaisir, and the Line Barracks, the headquarters of the police force. The island was under the administration of the French East India Company, which maintained its presence until 1767. During the French rule, slaves were brought from parts of Africa such as Mozambique and Zanzibar. As a result, the island's population rose dramatically from 15,000 to 49,000 within thirty years. During the late eighteenth century, African slaves accounted for around 80 percent of the island's population, and by the early nineteenth century there were 60,000 slaves on the island. In early 1729, Indians from Pondicherry, India, arrived in Mauritius aboard the vessel La Sirène. Work contracts for these craftsmen were signed in 1734 at the time when they acquired their freedom.";
        model.title4 = "";
        model.text6 = "";
        model.title5 = "";
        model.text7 = "";
        model.title6 = "";
        model.text8 = "";
        model.title7 = "";

        model.image3 = R.drawable.jacques_henri_bernardin;

        model.text9 = "From 1767 to 1810, except for a brief period during the French Revolution when the inhabitants set up a government virtually independent of France, the island was controlled by officials appointed by the French government. Jacques-Henri Bernardin de Saint-Pierre lived on the island from 1768 to 1771, then went back to France, where he wrote Paul et Virginie, a love story that made the Isle de France famous wherever the French language was spoken. In 1796 the settlers broke away from French control when the government in Paris attempted to abolish slavery. Two famous French governors were the Vicomte de Souillac (who constructed the Chaussée in Port Louis and encouraged farmers to settle in the district of Savanne) and Antoine Bruni d'Entrecasteaux (who saw to it that the French in the Indian Ocean should have their headquarters in Mauritius instead of Pondicherry in India). Charles Mathieu Isidore Decaen was a successful general in the French Revolutionary Wars and, in some ways, a rival of Napoléon I. He ruled as Governor of Isle de France and Réunion from 1803 to 1810. British naval cartographer and explorer Matthew Flinders was arrested and detained by General Decaen on the island from 1803 to 1810, in contravention of an order from Napoléon. During the Napoleonic Wars, Mauritius became a base from which French corsairs organised successful raids on British commercial ships. ";
        model.title8 = "";
        model.text10 = "";

        model.image4 = R.drawable.isle_of_france;

        model.text11 = "The raids continued until 1810, when a Royal Navy expedition led by Commodore Josias Rowley, R.N., an Anglo-Irish aristocrat, was sent to capture the island. Despite winning the Battle of Grand Port against the British, the French could not prevent the British from landing at Cap Malheureux three months later. They formally surrendered the island on the fifth day of the invasion, 3 December 1810, on terms allowing settlers to keep their land and property and to use the French language and law of France in criminal and civil matters. Under British rule, the island's name reverted to Mauritius." +
                "<br><b>British Mauritius (1810–1968)</b>" +
                "<br>The British administration, which began with Sir Robert Farquhar as its first governor, oversaw rapid social and economic changes. However, it was tainted by the Ratsitatane episode. Ratsitatane, nephew of King Radama of Madagascar, was brought to Mauritius as a political prisoner. He managed to escape from prison and plotted a rebellion that would free the island's slaves. He was betrayed by his associate Laizaf and was caught by a group of militiamen and summarily executed.\n" +
                "<br>In 1832, d'Épinay launched the first Mauritian newspaper (Le Cernéen), which was not controlled by the government. In the same year, there was a move by the procureur-general to abolish slavery without compensation to the slave owners. This gave rise to discontent, and, to check an eventual rebellion, the government ordered all the inhabitants to surrender their arms. Furthermore, a stone fortress, Fort Adelaide, was built on a hill (now known as the Citadel hill) in the centre of Port Louis to quell any uprising.[43] Slavery was gradually abolished over several years after 1833, and the planters ultimately received two million pounds sterling in compensation for the loss of their slaves, who had been imported from Africa and Madagascar during the French occupation. The abolition of slavery had important effects on Mauritius's society, economy and population. The planters brought a large number of indentured labourers from India to work in the sugar cane fields. \n";

        model.image5 = R.drawable.map_location;

        model.text12 = "";
        Stash.put("model", model);
        Intent intent = new Intent(AboutActivity.this, BeachDetails.class);
        startActivity(intent);
    }
}