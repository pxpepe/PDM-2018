package com.pxpepe.customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceAdapter extends ArrayAdapter<Place> {

    Context mContext;
    int mLayoutResourceId;
    Place mData[] = null;

    public PlaceAdapter(@NonNull Context context, int resource, @NonNull Place[] data) {
        super(context, resource, data);
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mData = data;
    }

    @Nullable
    @Override
    public Place getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        row = inflater.inflate(mLayoutResourceId, parent, false);

        TextView nameView = row.findViewById(R.id.nameTextView);
        TextView zipView = row.findViewById(R.id.zipcodeTextView);
        ImageView imageView = row.findViewById(R.id.imageView);

        Place place = mData[position];
        nameView.setText(place.mNameOfPlace);
        zipView.setText(String.valueOf(place.mZipCode));

        int resId = mContext.getResources().getIdentifier(place.mNameOfImage,"drawable", mContext.getPackageName());
        imageView.setImageResource(resId);

        return row;

    }
}