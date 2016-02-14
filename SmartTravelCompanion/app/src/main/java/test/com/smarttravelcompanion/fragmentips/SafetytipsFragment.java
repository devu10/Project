package test.com.smarttravelcompanion.fragmentips;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import test.com.smarttravelcompanion.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SafetytipsFragment extends Fragment {

    ImageView mimageview;


    public SafetytipsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_safetytips, container, false);
        mimageview = (ImageView)view.findViewById(R.id.imgsafety);
        mimageview.setImageResource(R.drawable.safety);
        return view;
    }

}
