package com.desai.vatsal.mydynamiccalendar;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HCL on 09-10-2016.
 */
public class EventListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private String strViewFlag;
    private ArrayList<EventModel> eventModelList;

    public EventListAdapter(Context context, ArrayList<EventModel> eventModelList, String strViewFlag) {
        this.context = context;
        this.strViewFlag = strViewFlag;
        this.eventModelList = eventModelList;
    }

    class EventViewHolder extends RecyclerView.ViewHolder {

        LinearLayout ll_month_events;
        TextView tv_event_name, tv_event_date, tv_event_time, tv_event_simbol;
        View v_divider;

        public EventViewHolder(View itemView) {
            super(itemView);
            ll_month_events = (LinearLayout) itemView.findViewById(R.id.ll_month_events);
            tv_event_name = (TextView) itemView.findViewById(R.id.tv_event_name);
            tv_event_date = (TextView) itemView.findViewById(R.id.tv_event_date);
            tv_event_time = (TextView) itemView.findViewById(R.id.tv_event_time);
            tv_event_simbol = (TextView) itemView.findViewById(R.id.tv_event_simbol);
            v_divider = (View) itemView.findViewById(R.id.v_divider);

        }

        public void setEvent(EventModel model) {

            if (strViewFlag.equals("month")) {
                ll_month_events.setVisibility(View.VISIBLE);

                if (model.getImage() != -1) {
                    tv_event_simbol.setBackgroundResource(model.getImage());
                } else {
                    tv_event_simbol.setBackgroundResource(R.drawable.event_view);
                }

                tv_event_name.setText(model.getStrName());
                tv_event_date.setText(model.getStrDate());
                tv_event_time.setText(String.format("%s to %s", model.getStrStartTime(), model.getStrEndTime()));

                if (AppConstants.belowMonthEventTextColor != -1) {
                    tv_event_name.setTextColor(AppConstants.belowMonthEventTextColor);
                    tv_event_date.setTextColor(AppConstants.belowMonthEventTextColor);
                    tv_event_time.setTextColor(AppConstants.belowMonthEventTextColor);
                }

                if (!AppConstants.strBelowMonthEventTextColor.equals("null")) {
                    tv_event_name.setTextColor(Color.parseColor(AppConstants.strBelowMonthEventTextColor));
                    tv_event_date.setTextColor(Color.parseColor(AppConstants.strBelowMonthEventTextColor));
                    tv_event_time.setTextColor(Color.parseColor(AppConstants.strBelowMonthEventTextColor));
                }

                if (AppConstants.belowMonthEventDividerColor != -1) {
                    v_divider.setBackgroundColor(AppConstants.belowMonthEventDividerColor);
                }

                if (!AppConstants.strBelowMonthEventDividerColor.equals("null")) {
                    v_divider.setBackgroundColor(Color.parseColor(AppConstants.strBelowMonthEventDividerColor));
                }
            }


        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.row_event, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        EventModel eventModel = eventModelList.get(position);

        EventViewHolder showEventsViewHolder = (EventViewHolder) holder;
        showEventsViewHolder.setEvent(eventModel);

    }

    @Override
    public int getItemCount() {
        return eventModelList.size();
    }
}
