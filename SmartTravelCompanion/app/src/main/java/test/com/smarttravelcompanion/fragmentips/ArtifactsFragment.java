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
public class ArtifactsFragment extends Fragment {


    ImageView mimageview;



    public ArtifactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_artifacts, container, false);
        mimageview = (ImageView)view.findViewById(R.id.imgartifacts);
        mimageview.setImageResource(R.drawable.artifacts);
        return  view;



    }

}
