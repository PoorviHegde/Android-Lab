package com.example.poorvi_hegde.testapp;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Poorvi_Hegde on 04-02-2018.
 */

public class VersionFragment extends ListFragment {

    String[] versions={"cupcake","donut","eclairs","froyo","honeycomb","icecreamsandwitch","jellybean","kitkat","lollipop","marshmellow","nougat","oreo"};
    int[] icons={R.drawable.cupcake,R.drawable.donut,R.drawable.eclair,R.drawable.froyo,R.drawable.gingerbread,R.drawable.honeycomb,R.drawable.icecreamsandwitch,R.drawable.jellybean,R.drawable.kitkat,R.drawable.lollipop,R.drawable.marshmellow,R.drawable.nouget,R.drawable.oreo};

    ArrayList <HashMap<String,String>> data = new ArrayList<HashMap<String, String>>();
    SimpleAdapter adapter;

    public View onCreateVew(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        HashMap<String,String> map ;

        for(int i=0;i<versions.length;i++)
        {
            map = new HashMap<String, String>();
            map.put("version",versions[i]);
            map.put("icon",Integer.toString(icons[i]));

            data.add(map);
        }

        String[] from={"version","icon"};
        int[] to ={R.id.nameTxt,R.id.imageView1};

        adapter = new SimpleAdapter(getActivity(),data,R.layout.list,from,to);
        setListAdapter(adapter);

        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onStart()
    {
        super.onStart();

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),data.get(i).get("version"),Toast.LENGTH_LONG  ).show();
            }
        });
    }
}
