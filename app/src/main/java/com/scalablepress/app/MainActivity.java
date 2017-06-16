package com.scalablepress.app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.scalablepress.app.product.ProductPresenter;
import com.scalablepress.v2.models.Category;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity
        implements ProductPresenter.View {

    @Inject
    ProductPresenter productPresenter;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    productPresenter.getCategories();
                    return true;
                case R.id.navigation_dashboard:
                    productPresenter.getCategory("hoodies"); //todo
                    return true;
                case R.id.navigation_notifications:
                    productPresenter.getProduct("anvil-ladies-long-sleeve-t"); //todo
                    return true;
            }
            return false;
        }

    };

    public MainActivity() {
        super();
        MainApplication.getInstance().injectsMainActivity(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void updateProductCategories(List<Category> categories) {
        this.mTextMessage.setText(Arrays.toString(categories.toArray()));
    }

    @Override
    public void updateError(String errorMessage) {
        this.mTextMessage.setText(errorMessage);
    }
}
