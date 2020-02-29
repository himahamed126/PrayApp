package com.example.prayapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prayapp.R;
import com.example.prayapp.adapter.HistoryAdapter;
import com.example.prayapp.data.local.room.Prays;
import com.example.prayapp.data.local.room.PraysViewModel;
import com.example.prayapp.ui.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryFragment extends BaseFragment {
    @BindView(R.id.fragment_his_rv_prays)
    RecyclerView fragmentHisRvPrays;

    private PraysViewModel mPraysViewModel;
    private HistoryAdapter historyAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        ButterKnife.bind(this, view);


        fragmentHisRvPrays.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentHisRvPrays.setHasFixedSize(true);


        mPraysViewModel = ViewModelProviders.of(getActivity()).get(PraysViewModel.class);
        mPraysViewModel.getAllPrays().observe(getActivity(), new Observer<List<Prays>>() {
            @Override
            public void onChanged(List<Prays> prays) {
                historyAdapter = new HistoryAdapter(getActivity(), prays);
                fragmentHisRvPrays.setAdapter(historyAdapter);
            }
        });
        return view;
    }

    @OnClick(R.id.fragment_his_fab_add)
    void onViewClicked() {
//        mPraysViewModel.insert(new Prays("21-2-2020", true, true, false, false, false, 5));
//        mPraysViewModel.deleteAllPrays();
//        mPraysViewModel.update(new Prays("الاتنين 20/2", true, true, false, false, false, 5));
    }
}
