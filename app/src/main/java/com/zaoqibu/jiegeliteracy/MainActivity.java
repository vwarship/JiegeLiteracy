package com.zaoqibu.jiegeliteracy;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {
    private MediaPlayer player;
    private Words words;
    private int curWordPos = 0;

    public MainActivity() {
        words = new Words();
        words.add(new Word("爱", "ai.mp3"));
        words.add(new Word("秋", "qiu.mp3"));
        words.add(new Word("去", "qu.mp3"));
        words.add(new Word("全", "quan.mp3"));
        words.add(new Word("让", "rang.mp3"));
        words.add(new Word("热", "re.mp3"));
        words.add(new Word("人", "ren.mp3"));
        words.add(new Word("日", "ri.mp3"));
        words.add(new Word("入", "ru.mp3"));
        words.add(new Word("三", "san.mp3"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player = new MediaPlayer();

        ImageButton ibWordSound = (ImageButton)findViewById(R.id.ibWordSound);
        ibWordSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });

        final TextView tvWord = (TextView)findViewById(R.id.tvWord);
        tvWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });

        Button btnContinue = (Button)findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++ curWordPos;
                if (curWordPos >= words.count())
                    curWordPos = 0;
                
                tvWord.setText(words.get(curWordPos).getText());
            }
        });

        // init
        tvWord.setText(words.get(curWordPos).getText());
    }

    private void play() {
        String wordSoundPath = words.get(curWordPos).getSoundPath();

        try {
            player = new MediaPlayer();

            AssetFileDescriptor afd = this.getAssets().openFd(wordSoundPath);
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();

            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        player.release();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
