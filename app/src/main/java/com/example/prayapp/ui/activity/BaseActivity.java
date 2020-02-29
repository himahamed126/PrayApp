package com.example.prayapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prayapp.ui.BaseFragment;

public class BaseActivity extends AppCompatActivity {
    public BaseFragment baseFragment;


    public void superOnBackPressed() {
        super.onBackPressed();
    }
}
