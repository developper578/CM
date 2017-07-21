package com.example.developper578.cm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.widget.FrameLayout;

public class ItemsListActivity extends FragmentActivity implements ItemsListFragment.OnItemSelectedListener {
    public static String TAG = "ItemsListActivity";
    public static String KEY_EXTRA_ITEM = "com.exmeple.developper578.cm.Item";
    private boolean isTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);
        determinePaneLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.items, menu);
        Log.v(TAG, "Creating the options menu.");
        return true;
    }

    private void determinePaneLayout() {
        FrameLayout frameItemDetail = (FrameLayout)findViewById(R.id.flDetailContainer);
        if(frameItemDetail != null) {
            isTwoPane = true;
            ItemsListFragment fragmentItemsList = (ItemsListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);
            fragmentItemsList.setActivateOnItemClick(true);
        }
    }

    public void onItemSelected(Item item) {
        if(isTwoPane) { // Single activity with list and detail. Replace FrameLayout with the correct detail fragment.
            ItemDetailFragment detail = ItemDetailFragment.newInstance(item);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, detail);
            ft.commit();
        } else { // Separate activities, launch the detail activity using an intent.
            Intent i = new Intent(this, ItemDetailActivity.class);
            i.putExtra(KEY_EXTRA_ITEM, item);
            startActivity(i);
        }
    }


}
