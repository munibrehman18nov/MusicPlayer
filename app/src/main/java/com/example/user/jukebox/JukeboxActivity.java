package com.example.user.jukebox;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import stanford.androidlib.SimpleActivity;

public class JukeboxActivity extends SimpleActivity
{
    @BindView(R.id.songListVU) ListView songsListVU;
    private String[] allSongs;
    private MediaPlayer mp;
    private int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jukebox);

        ButterKnife.bind(this);

        allSongs = getResources().getStringArray(R.array.songsNames);
        length=0;

        CustomAdapter myAdapter = new CustomAdapter(getApplicationContext());
        songsListVU.setAdapter(myAdapter);
    }

    @OnItemClick(R.id.songListVU)
    public void onListViewItemClick(int position)
    {
        if(mp != null) {
            mp.stop();
            mp = null;
        }
        String selectedSong = allSongs[position].toLowerCase();

        int songID = getResources().getIdentifier(selectedSong, "raw", getPackageName());
        mp = MediaPlayer.create(this, songID);
        mp.start();
    }

    @OnClick(R.id.stop)
    public void onClickStop(View view)
    {
        if(mp!=null) {
            mp.stop();
            mp = null;
        }
    }
    @OnClick(R.id.pause)
    public void onClickPause(View view)
    {
        if(mp.isPlaying()) {
            mp.pause();
            length = mp.getCurrentPosition();
        }
    }
    @OnClick(R.id.play)
    public void onClickPlay(View view)
    {
        if(mp!=null) {
            if (mp.isPlaying()) {
                return;
            } else {
                mp.seekTo(length);
                mp.start();
            }
        }
    }

}
