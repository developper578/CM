package com.example.developper578.cm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemDetailFragment extends Fragment {
    private Item item;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = (Item)getArguments().getSerializable(ItemsListActivity.KEY_EXTRA_ITEM);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ret = inflater.inflate(R.layout.fragment_item_detail, container, false);
        TextView tvTitle = (TextView)ret.findViewById(R.id.tvTitle);
        TextView tvBody = (TextView)ret.findViewById(R.id.tvBody);
        tvTitle.setText(item.getTitle());
        tvBody.setText(item.getBody());

        return ret;
    }

    public static ItemDetailFragment newInstance(Item item) {
        ItemDetailFragment fragmentItemDetail = new ItemDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ItemsListActivity.KEY_EXTRA_ITEM, item);
        fragmentItemDetail.setArguments(args);

        return fragmentItemDetail;
    }
}
