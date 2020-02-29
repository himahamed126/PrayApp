package com.example.prayapp.ui;

import androidx.fragment.app.Fragment;

import com.example.prayapp.ui.activity.BaseActivity;
import com.example.prayapp.ui.activity.HomeActivity;

public abstract class BaseFragment extends Fragment {
    BaseActivity baseActivity;
    HomeActivity homeActivity;

    public void setupActivity() {
        baseActivity = (BaseActivity) getActivity();
        baseActivity.baseFragment = this;
    }

    public void setupHomeActivity() {
        homeActivity = (HomeActivity) getActivity();
    }

    public void onBack() {
        baseActivity.superOnBackPressed();
    }

}
