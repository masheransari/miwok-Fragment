package com.example.asheransari.miwokfragment;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by asher.ansari on 9/30/2016.
 */
public class word_adapter extends ArrayAdapter<variableClass>{

    private int mColorResourceID;
    public word_adapter(Activity activity, ArrayList<variableClass> word,int colorResourceID)
    {
        super(activity,0, word);
        mColorResourceID = colorResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items,parent,false);
        }
        variableClass currentWord = getItem(position);

        TextView miworkTextView = (TextView) listItemView.findViewById(R.id.miwok_text);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miworkTextView.setText(currentWord.getmMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView DefaultTextView = (TextView) listItemView.findViewById(R.id.default_text);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        DefaultTextView.setText(currentWord.getmDefaulttranslate());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);

        if (currentWord.hasImage())
        {
            imageView.setImageResource(currentWord.getmImageResourceID());
            imageView.setVisibility(View.VISIBLE);
        }
        else
        {
            imageView.setVisibility(View.GONE);
        }
        View textContainer = listItemView.findViewById(R.id.list_views_item);

        int color = ContextCompat.getColor(getContext(),mColorResourceID);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }

}
