package com.example.developper578.cm;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;

public class ItemDetailActivity extends FragmentActivity {
    public static String TAG = "ItemDetailActivity";

    private ItemDetailFragment fragmentDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "Starting item detail activity");

        setContentView(R.layout.activity_item_detail);
        Item item = (Item)getIntent().getSerializableExtra(ItemsListActivity.KEY_EXTRA_ITEM);

        if(savedInstanceState == null) {
            fragmentDetail = ItemDetailFragment.newInstance(item);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragmentDetail);
            ft.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.item_detail, menu);
        return true;
    }
}
