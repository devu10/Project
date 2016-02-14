package test.com.smarttravelcompanion.fragmentips;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.ImageView;
=======
>>>>>>> 0b41ced8297b07cc5eb736254991b8dfa05e8581

import test.com.smarttravelcompanion.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SafetytipsFragment extends Fragment {

<<<<<<< HEAD
    ImageView mimageview;

=======
>>>>>>> 0b41ced8297b07cc5eb736254991b8dfa05e8581

    public SafetytipsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
<<<<<<< HEAD
        View view =  inflater.inflate(R.layout.fragment_safetytips, container, false);
        mimageview = (ImageView)view.findViewById(R.id.imgsafety);
        mimageview.setImageResource(R.drawable.safety);
        return view;
=======
        return inflater.inflate(R.layout.fragment_safetytips, container, false);
>>>>>>> 0b41ced8297b07cc5eb736254991b8dfa05e8581
    }

}
