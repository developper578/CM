package com.example.developper578.cm;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewGroupCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ItemsListFragment extends Fragment{
    private ArrayAdapter<Item> adapterItems;
    private ListView lvItems;

    private OnItemSelectedListener listener;

    public interface OnItemSelectedListener {
        public void onItemSelected(Item i);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement ItemsListFragment.OnItemSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create arraylist from item fixtures.

        ArrayList<Item> items = Item.getItems();
        adapterItems = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_activated_1, items);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate view.
        View ret = inflater.inflate(R.layout.fragment_items_list, container, false);
        // Bind adapter to listview.
        lvItems = (ListView)ret.findViewById(R.id.lvItems);
        lvItems.setAdapter(adapterItems);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Retrieve the item bases on its position.
                Item i = adapterItems.getItem(position);
                // Fire selected event for item.
                listener.onItemSelected(i);
            }
        });

        return ret;
    }

    public void setActivateOnItemClick(boolean activateOnItemClick) {
        lvItems.setChoiceMode(activateOnItemClick ? ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
    }
}
