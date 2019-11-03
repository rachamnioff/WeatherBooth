package com.rakel.he.weatherbooth.view;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.rakel.he.weatherbooth.R;
import com.rakel.he.weatherbooth.contacts.DetailContact;
import com.rakel.he.weatherbooth.model.entity.HourlyEntity;
import com.rakel.he.weatherbooth.model.entity.TimeMachineEntity;
import com.rakel.he.weatherbooth.presenter.DetailPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

public class DetailActivity extends BasicActivity implements DetailContact.View {

    @Inject
    public DetailPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private List<HourlyEntity> entities=new ArrayList<>();
    private HourlyAdaper mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        loadTimeMachine();
    }

    @Override
    public void onTimeMachineLoaded(TimeMachineEntity entity) {
        entities.clear();
        entities.addAll(entity.hourly);
        mAdapter.notifyDataSetChanged();
    }

    private void loadTimeMachine() {
        long timeForDay=getIntent().getLongExtra("timestampForDay",System.currentTimeMillis());
        Location location=getCurrentLocation();
        mPresenter.loadTimeMachineData(location.getLatitude(),location.getLongitude(),timeForDay);
    }

    private void initView()
    {
        setContentView(R.layout.activity_detail);
        mRecyclerView=findViewById(R.id.hourly_detail);
        mAdapter=new HourlyAdaper();
    }


    private class HourlyAdaper extends RecyclerView.Adapter<HourlyDetailViewHolder>
    {
        private long currentTime;
        private SimpleDateFormat sdf;
        public HourlyAdaper() {
            currentTime=System.currentTimeMillis();
            sdf=new SimpleDateFormat("HH");
        }
        @Override
        public void onBindViewHolder(@NonNull HourlyDetailViewHolder holder, int position) {
            holder.mTemperatureText.setText(
                    String.valueOf(entities.get(position).temperature));
            holder.mIconText.setText(entities.get(position).icon);
            holder.mHourText.setText(sdf.format(new Date(entities.get(position).time)));
            if(currentTime>entities.get(position).time+60*60*1000) {
                int grayColor=getResources().getColor(android.R.color.darker_gray);
                holder.mHourText.setTextColor(grayColor);
                holder.mTemperatureText.setTextColor(grayColor);
                holder.mIconText.setTextColor(grayColor);
            }else {
                int whiteColor=getResources().getColor(android.R.color.white);
                holder.mHourText.setTextColor(whiteColor);
                holder.mTemperatureText.setTextColor(whiteColor);
                holder.mIconText.setTextColor(whiteColor);
            }
        }

        @NonNull
        @Override
        public HourlyDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(DetailActivity.this).inflate(R.layout.item_hourly_detail, parent, false);
            return new HourlyDetailViewHolder(view);
        }

        @Override
        public int getItemCount() {
            return entities==null?0:entities.size();
        }
    }

    private class HourlyDetailViewHolder extends  RecyclerView.ViewHolder
    {
        private TextView mHourText,mTemperatureText,mIconText;

        public HourlyDetailViewHolder(View itemView) {
            super(itemView);
            mHourText = (TextView) itemView.findViewById(R.id.item_hour);
            mIconText = (TextView) itemView.findViewById(R.id.item_icon);
            mTemperatureText = (TextView) itemView.findViewById(R.id.item_temperature);
        }
    }
}
