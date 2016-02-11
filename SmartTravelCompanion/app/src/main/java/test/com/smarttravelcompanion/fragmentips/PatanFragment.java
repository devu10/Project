package test.com.smarttravelcompanion.fragmentips;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import test.com.smarttravelcompanion.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatanFragment extends Fragment {
    ImageView mimageview;
    TextView mtextview;
    public PatanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_patan, container, false);
        mimageview = (ImageView)view.findViewById(R.id.imgpatan);
        mtextview=(TextView)view.findViewById(R.id.txtpatan);
        mimageview.setImageResource(R.drawable.patan);
        return view;
    }

}
