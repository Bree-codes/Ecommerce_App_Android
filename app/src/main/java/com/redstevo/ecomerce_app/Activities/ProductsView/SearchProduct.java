package com.redstevo.ecomerce_app.Activities.ProductsView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import com.redstevo.ecomerce_app.Activities.GeneralView.GeneralActivity;
import com.redstevo.ecomerce_app.R;
import com.redstevo.ecomerce_app.Services.MeiliSearchService;

public class SearchProduct extends GeneralActivity {

    private final MeiliSearchService meiliSearchService;

    public SearchProduct() {
        meiliSearchService = new MeiliSearchService();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        super.handleSearching(findViewById(R.id.search_product));
        super.handleUserCartClick(findViewById(R.id.user_cart));
        super.handleTrackOrderClick(findViewById(R.id.track_order));
        super.handleUserProfileClick(findViewById(R.id.user_profile));
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        EditText searchBar = findViewById(R.id.search_product);

        getSearchProducts(" ", recyclerView);

        //add event listener to the search bar.
        searchBar.setOnKeyListener((v, keyCode, event) -> {
            if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
               getSearchProducts(String.valueOf(searchBar.getText()), recyclerView);
                searchBar.setText("");
            }
            return true;
        });
    }

    private void getSearchProducts(String query, RecyclerView recyclerView) {
        Log.d("SEARCH_BAR", query);
        meiliSearchService.searchProducts(query, this, recyclerView);
    }

}
