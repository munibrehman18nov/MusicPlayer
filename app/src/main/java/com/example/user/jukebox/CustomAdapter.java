package com.example.user.jukebox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private String[] allSongs;
    private ImageView imgVU;
    private TextView tVU;

    public CustomAdapter(Context context) {
        this.context = context;
        allSongs = context.getResources().getStringArray(R.array.songsNames);
        //ButterKnife.bind(JukeboxActivity.this);
    }
    @Override
    public int getCount() {
        return allSongs.length;
    }
    @Override
    public Object getItem(int i) {
        return allSongs[i];
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = View.inflate(context, R.layout.layout_custom, null);
        imgVU = v.findViewById(R.id.imageVU);
        tVU = v.findViewById(R.id.musicTextVU);
        imgVU.setImageResource(R.drawable.music_logo);
        tVU.setText(allSongs[i]);
        return v;
    }
}
