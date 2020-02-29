package com.example.prayapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prayapp.helper.WaveLoadingView;
import com.example.prayapp.R;
import com.example.prayapp.data.model.PrayItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PrayAdapter extends RecyclerView.Adapter<PrayAdapter.ViewHolder> {


    private Context context;
    private List<PrayItem> prayList;
    private int progress = 0;
    private ImageView imageView;
    WaveLoadingView waveLoadingView;

    public PrayAdapter(Context context, List<PrayItem> prayList) {
        this.context = context;
        this.prayList = prayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pray_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
        waveLoadingView = ((AppCompatActivity) context).findViewById(R.id.fragment_home_wave);
    }

    private void setData(ViewHolder holder, int position) {
        PrayItem prayItem = prayList.get(position);

        holder.name.setText(prayItem.getName());
    }

    private void setAction(ViewHolder holder, int position) {
        PrayItem prayItem = prayList.get(position);
        TextView donePryTv = ((AppCompatActivity) context).findViewById(R.id.fragment_home_tv_done);

        if (progress == 100) {
            donePryTv.setVisibility(View.VISIBLE);
        } else {
            donePryTv.setVisibility(View.GONE);
        }
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!prayItem.isCheck()) {
                    prayItem.setCheck(true);

                    holder.name.setTextColor(ContextCompat.getColor(context, R.color.white));
                    holder.linearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.sh_cv_bg_fill));

                    progress += 20;
                    waveLoadingView.setProgressValue(progress);
                    waveLoadingView.setCenterTitle("%" + progress);

                    if (progress == 100) {
                        donePryTv.setVisibility(View.VISIBLE);
                    } else {
                        donePryTv.setVisibility(View.GONE);
                    }
                    switch (progress) {
                        case 0:
                            waveLoadingView.setCenterTitleColor(ContextCompat.getColor(context, R.color.black_light));
                            waveLoadingView.setWaveColor(ContextCompat.getColor(context, R.color.black_light));
                            break;
                        case 20:
                            waveLoadingView.setCenterTitleColor(ContextCompat.getColor(context, R.color.black_light));
                            waveLoadingView.setWaveColor(ContextCompat.getColor(context, R.color.lemon));
                            break;
                        case 40:
                            waveLoadingView.setCenterTitleColor(ContextCompat.getColor(context, R.color.black_light));
                            waveLoadingView.setWaveColor(ContextCompat.getColor(context, R.color.lemon));
                            break;
                        case 60:
                            waveLoadingView.setCenterTitleColor(ContextCompat.getColor(context, R.color.black_light));
                            waveLoadingView.setWaveColor(ContextCompat.getColor(context, R.color.lemon));
                            break;
                        case 80:
                            waveLoadingView.setCenterTitleColor(ContextCompat.getColor(context, R.color.white));
                            waveLoadingView.setWaveColor(ContextCompat.getColor(context, R.color.lemon));
                            break;
                        case 100:
                            waveLoadingView.setCenterTitleColor(ContextCompat.getColor(context, R.color.white));
                            waveLoadingView.setWaveColor(ContextCompat.getColor(context, R.color.lemon));
                            break;
                    }

                } else {
                    prayItem.setCheck(false);
                    holder.name.setTextColor(ContextCompat.getColor(context, R.color.purple));
                    holder.linearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.sh_cv_bg));
                    progress -= 20;
                    waveLoadingView.setProgressValue(progress);
                    waveLoadingView.setCenterTitle("%" + progress);

                    if (progress == 100) {
                        donePryTv.setVisibility(View.VISIBLE);
                    } else {
                        donePryTv.setVisibility(View.GONE);
                    }

                    switch (progress) {
                        case 0:
                            waveLoadingView.setCenterTitleColor(ContextCompat.getColor(context, R.color.black_light));
                            waveLoadingView.setWaveColor(ContextCompat.getColor(context, R.color.black_light));
                            break;
                        case 20:
                            waveLoadingView.setCenterTitleColor(ContextCompat.getColor(context, R.color.black_light));
                            waveLoadingView.setWaveColor(ContextCompat.getColor(context, R.color.lemon));
                            break;
                        case 40:
                            waveLoadingView.setCenterTitleColor(ContextCompat.getColor(context, R.color.black_light));
                            waveLoadingView.setWaveColor(ContextCompat.getColor(context, R.color.lemon));
                            break;
                        case 60:
                            waveLoadingView.setCenterTitleColor(ContextCompat.getColor(context, R.color.black_light));
                            waveLoadingView.setWaveColor(ContextCompat.getColor(context, R.color.lemon));
                            break;
                        case 80:
                            waveLoadingView.setCenterTitleColor(ContextCompat.getColor(context, R.color.white));
                            waveLoadingView.setWaveColor(ContextCompat.getColor(context, R.color.lemon));
                            break;
                        case 100:
                            waveLoadingView.setCenterTitleColor(ContextCompat.getColor(context, R.color.white));
                            waveLoadingView.setWaveColor(ContextCompat.getColor(context, R.color.lemon));
                            break;
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return prayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.pray_item_ly)
        LinearLayout linearLayout;
        @BindView(R.id.pray_item_tv_name)
        TextView name;

        View view;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
}
