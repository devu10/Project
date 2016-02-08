package test.com.smarttravelcompanion.topDestinationfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import test.com.smarttravelcompanion.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    TextView txtpg;


    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.page_fragment_layout, container, false);
        txtpg = (TextView)view.findViewById(R.id.txtpagefragment);
        Bundle bundle = getArguments();
        String message = Integer.toString(bundle.getInt("count"));
        txtpg.setText("Page no "+message+". swipe left for next");
        return view;

    }

}
