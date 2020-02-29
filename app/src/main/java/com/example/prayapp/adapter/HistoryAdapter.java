package com.example.prayapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prayapp.R;
import com.example.prayapp.data.local.room.Prays;
import com.example.prayapp.data.local.room.PraysViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {


    private Context context;
    private List<Prays> praysList = new ArrayList<>();
    private PraysViewModel mPraysViewModel;

    public HistoryAdapter(Context context, List praysList) {
        this.context = context;
        this.praysList = praysList;
        mPraysViewModel = ViewModelProviders.of((FragmentActivity) context).get(PraysViewModel.class);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
        Prays pray = praysList.get(position);
        holder.itemHisTvDay.setText(pray.getDay());
        holder.itemHisFajrCb.setChecked(pray.isFajr());
        holder.itemHisZohrCb.setChecked(pray.isZohr());
        holder.itemHisAsrCb.setChecked(pray.isAsr());
        holder.itemHisMaghrbCb.setChecked(pray.isMaghrb());
        holder.itemHisAshaCb.setChecked(pray.isAsha());
    }

    private void setAction(ViewHolder holder, int position) {
        Prays pray = praysList.get(position);
        holder.itemHisFajrCb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Prays prays = new Prays(pray.getDay(), isChecked, pray.isZohr(),
                    pray.isAsr(), pray.isMaghrb(), pray.isAsha(), pray.getPercent());
            prays.setId(pray.getId());
            mPraysViewModel.update(prays);
        });
        holder.itemHisZohrCb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Prays prays = new Prays(pray.getDay(), pray.isFajr(), isChecked,
                    pray.isAsr(), pray.isMaghrb(), pray.isAsha(), pray.getPercent());
            prays.setId(pray.getId());
            mPraysViewModel.update(prays);
        });
        holder.itemHisAsrCb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Prays prays = new Prays(pray.getDay(), pray.isFajr(), pray.isZohr(),
                    isChecked, pray.isMaghrb(), pray.isAsha(), pray.getPercent());
            prays.setId(pray.getId());
            mPraysViewModel.update(prays);
        });
        holder.itemHisMaghrbCb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Prays prays = new Prays(pray.getDay(), pray.isFajr(), pray.isZohr(),
                    pray.isAsr(), isChecked, pray.isAsha(), pray.getPercent());
            prays.setId(pray.getId());
            mPraysViewModel.update(prays);
        });
        holder.itemHisAshaCb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Prays prays = new Prays(pray.getDay(), pray.isFajr(), pray.isZohr(),
                    pray.isAsr(), pray.isMaghrb(),isChecked, pray.getPercent());
            prays.setId(pray.getId());
            mPraysViewModel.update(prays);
        });
    }

    @Override
    public int getItemCount() {
        return praysList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_his_tv_day)
        TextView itemHisTvDay;
        @BindView(R.id.item_his_fajr_cb)
        CheckBox itemHisFajrCb;
        @BindView(R.id.item_his_zohr_cb)
        CheckBox itemHisZohrCb;
        @BindView(R.id.item_his_asr_cb)
        CheckBox itemHisAsrCb;
        @BindView(R.id.item_his_maghrb_cb)
        CheckBox itemHisMaghrbCb;
        @BindView(R.id.item_his_asha_cb)
        CheckBox itemHisAshaCb;
        View view;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
}
