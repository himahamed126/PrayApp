package com.example.prayapp.ui.activity;

import android.os.Bundle;

import com.example.prayapp.R;
import com.example.prayapp.ui.fragment.HistoryFragment;
import com.example.prayapp.ui.fragment.HomeFragment;

import static com.example.prayapp.helper.HelperMethod.replace;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        HomeFragment homeFragment = new HomeFragment();
        HistoryFragment historyFragment = new HistoryFragment();

        replace(historyFragment, getSupportFragmentManager(), R.id.activity_home_fl_frame);
    }
}
