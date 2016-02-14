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
public class DresstipsFragment extends Fragment {


    ImageView mimageview;



    public DresstipsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_dresstips, container, false);
        mimageview = (ImageView)view.findViewById(R.id.imgdress);
        mimageview.setImageResource(R.drawable.dress);
        return  view;

    }

}
