package com.example.asheransari.miwokfragment;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class phrase_fragement extends Fragment {
    private MediaPlayer mMediaPlayer;

    private AudioManager maudioManager;

    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {

        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if (focusChange ==AudioManager.AUDIOFOCUS_GAIN)
            {
                mMediaPlayer.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS)
            {
                releasePlayer();
            }
        }
    };
    private MediaPlayer.OnCompletionListener onCompletionListener = (new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releasePlayer();
        }
    });
    public phrase_fragement()
    {
    }

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceView)
{
    View rootview = inflater.inflate(R.layout.word_list,container,false);

    final ArrayList<variableClass> variable = new ArrayList<variableClass>();
    maudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

    variable.add(new variableClass("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
    variable.add(new variableClass("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
    variable.add(new variableClass("My name is...", "oyaaset...",R.raw.phrase_my_name_is));
    variable.add(new variableClass("How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
    variable.add(new variableClass("I’m feeling good.", "kuchi achit",R.raw.phrase_im_feeling_good));
    variable.add(new variableClass("Are you coming?", "әәnәs'aa?",R.raw.phrase_are_you_coming));
    variable.add(new variableClass("Yes, I’m coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
    variable.add(new variableClass("I’m coming.", "әәnәm",R.raw.phrase_im_coming));
    variable.add(new variableClass("Let’s go.", "yoowutis",R.raw.phrase_lets_go));
    variable.add(new variableClass("Come here.", "әnni'nem",R.raw.phrase_come_here));

    word_adapter adapter = new word_adapter(getActivity(), variable, R.color.phrase);

    ListView listView = (ListView) rootview.findViewById(R.id.list);
    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            variableClass variableClass = variable.get(position);
            releasePlayer();
            int result = maudioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
            {
                mMediaPlayer = MediaPlayer.create(getActivity(), variableClass.getmAudioResourceID());
                mMediaPlayer.start();
            }
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    releasePlayer();
                    Toast.makeText(getActivity(), "I am Done",Toast.LENGTH_SHORT).show();
                }
            });
        }
    });

    return rootview;
}

    @Override
    public void onStop()
    {
        super.onStop();
        releasePlayer();
    }
    private void releasePlayer()
    {
        if (mMediaPlayer != null)
        {
            mMediaPlayer.release();
            mMediaPlayer=null;
            maudioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }
}
