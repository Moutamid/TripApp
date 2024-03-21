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

import com.moutimid.sqlapp.R;
import com.moutimid.sqlapp.activities.DetailsActivity;
import com.moutimid.sqlapp.helper.DatabaseHelper;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private String[] itemTexts;
    private String[] itemName;
    private String[] itemDetails;
    private int[] itemImages;

    public CustomAdapter(Context context, String[] itemName, String[] itemDetails, String[] itemTexts, int[] itemImages) {
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
        View itemView = inflater.inflate(R.layout.saved_list_item_layout, parent, false);

        ImageView imageView = itemView.findViewById(R.id.imageView);
        TextView textView = itemView.findViewById(R.id.textView);
        TextView textView1 = itemView.findViewById(R.id.textView1);
        ImageView remove = itemView.findViewById(R.id.remove);

        imageView.setImageResource(itemImages[position]);
        textView.setText(itemName[position]);
        textView1.setText(itemTexts[position]);
        DatabaseHelper dbHelper;
        dbHelper = new DatabaseHelper(context);
        if (!dbHelper.checkDataExists(itemName[position],itemTexts[position], itemDetails[position],itemImages[position])) {
            remove.setVisibility(View.GONE);
        } else {
            remove.setVisibility(View.VISIBLE);
        }
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbHelper.deleteData(itemName[position],itemTexts[position], itemDetails[position],itemImages[position]);
//                removeFromArrays(position);
remove.setVisibility(View.GONE);
                notifyDataSetChanged();
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("name", itemName[position]);
                intent.putExtra("address", itemTexts[position]);
                intent.putExtra("details", itemDetails[position]);
                intent.putExtra("image", itemImages[position]);
                context.startActivity(intent);
            }
        });

        return itemView;
    }

    // Helper method to remove the item from the arrays
    private void removeFromArrays(int position) {
        // Create new arrays with size - 1
        String[] newItemTexts = new String[itemTexts.length - 1];
        String[] newItemName = new String[itemName.length - 1];
        String[] newItemDetails = new String[itemDetails.length - 1];
        int[] newItemImages = new int[itemImages.length - 1];

        // Copy elements before the removed item
        System.arraycopy(itemTexts, 0, newItemTexts, 0, position);
        System.arraycopy(itemName, 0, newItemName, 0, position);
        System.arraycopy(itemDetails, 0, newItemDetails, 0, position);
        System.arraycopy(itemImages, 0, newItemImages, 0, position);

        // Copy elements after the removed item
        System.arraycopy(itemTexts, position + 1, newItemTexts, position, newItemTexts.length - position);
        System.arraycopy(itemName, position + 1, newItemName, position, newItemName.length - position);
        System.arraycopy(itemDetails, position + 1, newItemDetails, position, newItemDetails.length - position);
        System.arraycopy(itemImages, position + 1, newItemImages, position, newItemImages.length - position);

        // Update the original arrays
        itemTexts = newItemTexts;
        itemName = newItemName;
        itemDetails = newItemDetails;
        itemImages = newItemImages;
    }
}
