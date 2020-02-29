package com.example.prayapp.ui.fragment;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prayapp.R;
import com.example.prayapp.adapter.PrayAdapter;
import com.example.prayapp.data.model.PrayItem;
import com.example.prayapp.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.fragment_home_rv)
    RecyclerView homeRv;

    private LinearLayoutManager linearLayoutManager;
    private PrayAdapter prayAdapter;
    private List<PrayItem> prayItems;

    private int screenHeight;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setupActivity();

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        prayItems = new ArrayList<>();

        prayItems.add(new PrayItem("الفجر", false));
        prayItems.add(new PrayItem("الظهر", false));
        prayItems.add(new PrayItem("العصر", false));
        prayItems.add(new PrayItem("المغرب", false));
        prayItems.add(new PrayItem("العشاء", false));

        linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        prayAdapter = new PrayAdapter(getActivity(), prayItems);
        homeRv.setAdapter(prayAdapter);
        homeRv.setLayoutManager(linearLayoutManager);


        Display display = getActivity().getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        screenHeight = metrics.heightPixels;
        return view;
    }

    @Override
    public void onBack() {
        super.onBack();
    }



    @OnClick(R.id.fragment_home_iv_drawer_btn)
    public void onViewClicked() {

    }
}
