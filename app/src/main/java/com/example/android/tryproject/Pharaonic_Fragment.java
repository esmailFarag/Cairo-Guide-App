package com.example.android.tryproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Pharaonic_Fragment extends Fragment {


    public Pharaonic_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_item, container, false);
        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.pyramids_of_giza, "Pyramids of Giza", "opens all the time", "one of the 7 amazies of the world", "geo:29.979487, 31.134250\n" +
                "\n", "tel:02 257445694596", "http://www.sca-egypt.org/eng/SITE_GIZA_MP.htm", getString(R.string.pyramids_of_giza)));
        places.add(new Place(R.drawable.mohamed_ali_mosqe, "Mohamed Ali Mosqe", "opens at 8 oclock", "Built in 18 centiries in the middle of Saladin casitle", "geo:30.029080, 31.259514\n" +
                "\n", "tel: 555555", "https://www.marefa.org/%D9%85%D8%B3%D8%AC%D8%AF_%D9%85%D8%AD%D9%85%D8%AF_%D8%B9%D9%84%D9%8A", getString(R.string.mohamed_ali_detailed_info)));
        places.add(new Place(R.drawable.elsuhimi_house, "El Suhimi house", "opens at 10 ocklock", "An ancient house from the 5 centireis which located in Al mo'es streat", "geo: 30.052484, 31.262578\n" +
                "\n,?z=18", "tel: 011 54265654", "https://www.facebook.com/s7emy.house/", getString(R.string.el_suhimi_house)));

        placeAdapter adapter = new placeAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list_item);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Place} object at the given position the user clicked on
                Place place = places.get(position);
                //create a new intent to open the place_detaile activity that will show the complete informaton about the place
                Intent intent = new Intent(Pharaonic_Fragment.this.getActivity(), place_detailes.class);
                //create a bundle that will transfee the data to the place_detailes activity
                Bundle bundle = new Bundle();
                bundle.putInt("placeImage", place.getPlaceImage());
                bundle.putString("placeName", place.getPlaceName());
                bundle.putString("placeInformation", place.getPlaceInformation());
                bundle.putString("placeLocation", place.getLocation());
                bundle.putString("placePhone", place.getPlacePhone());
                bundle.putString("placeWbsite", place.getPlaceWebsite());
                bundle.putString("PlaceInformationDetaled", place.getPlaceInformationDetailed());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return rootView;
    }

}
