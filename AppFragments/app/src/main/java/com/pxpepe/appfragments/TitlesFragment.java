package com.pxpepe.appfragments;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitlesFragment extends ListFragment {

    boolean mDualPane;
    int mCurCheckPos = 0;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> connectArray2ListView =
                new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1,
                        SuperHeroInfo.NAMES
                );

        setListAdapter(connectArray2ListView);

        View detailsFrame = getActivity().findViewById(R.id.details);
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null) {

            mCurCheckPos = savedInstanceState.getInt("curChoice",0);

        }

        if (mDualPane) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(mCurCheckPos);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("curChoice",mCurCheckPos);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);

        showDetails(position);

    }

    void showDetails(int index){

        mCurCheckPos = index;

        if (mDualPane) {

            getListView().setItemChecked(index, true);

            DetailsFragment details = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);

            if (details == null || details.getShownIndex() != index) {

                details = DetailsFragment.newInstance(index);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.details, details);

                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();

            }

        } else {

            Intent intent = new Intent();

            intent.setClass(getActivity(),DetailsActivity.class );

            intent.putExtra("index", index);

            startActivity(intent);

        }

    }

}
