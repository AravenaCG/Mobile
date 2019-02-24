package com.example.reproductor;

import android.arch.lifecycle.Lifecycle;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button play_pause, btn_repetir, prev , next, btn_Stop;
    MediaPlayer mp;
    ImageView iv;
    int repetir=2, posicion=0;
    MediaPlayer vectMp[] = new MediaPlayer[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play_pause = (Button) findViewById(R.id.btnPlay);
        btn_repetir =(Button) findViewById(R.id.btnRepeat);
        prev = (Button)findViewById(R.id.btnPrevious);
        next= (Button)findViewById(R.id.btnNext);
        btn_Stop = (Button)findViewById(R.id.btnStop);
        iv= (ImageView)findViewById(R.id.imageView);
        vectMp [0] = MediaPlayer.create(this,R.raw.race);
        vectMp [1] = MediaPlayer.create(this,R.raw.sound);
        vectMp [2] = MediaPlayer.create(this,R.raw.tea);
    }


    public void PlayPause(View view){

        if(vectMp[posicion].isPlaying()){
            vectMp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this,"pausa",Toast.LENGTH_SHORT).show();

        }else{
            vectMp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this,"Reproduciendo",Toast.LENGTH_SHORT).show();
        }
    }

    public void Stop(View view){
        if (vectMp[posicion]!= null)
        {
            vectMp[posicion].stop();
            vectMp [0] = MediaPlayer.create(this,R.raw.race);
            vectMp [1] = MediaPlayer.create(this,R.raw.sound);
            vectMp [2] = MediaPlayer.create(this,R.raw.tea);
            posicion=0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.portada1);
            Toast.makeText(this,"Detenido",Toast.LENGTH_SHORT).show();
        }

    }

    public void Previous (View view) {
        if (posicion >= 1) {

            if (vectMp[posicion].isPlaying()) {
                vectMp[posicion].stop();
                vectMp[0] = MediaPlayer.create(this, R.raw.race);
                vectMp[1] = MediaPlayer.create(this, R.raw.sound);
                vectMp[2] = MediaPlayer.create(this, R.raw.tea);
                posicion--;

                switch (posicion) {
                    case 0:
                        iv.setImageResource(R.drawable.portada1);
                        break;
                    case 1:
                        iv.setImageResource(R.drawable.portada2);
                        break;
                    case 2:
                        iv.setImageResource(R.drawable.portada3);
                        vectMp[posicion].start();

                }
            } else {

                posicion--;
                switch (posicion) {
                    case 0:
                        iv.setImageResource(R.drawable.portada1);
                        break;
                    case 1:
                        iv.setImageResource(R.drawable.portada2);
                        break;
                    case 2:
                        iv.setImageResource(R.drawable.portada3);
                }

            }

        } else {
            Toast.makeText(this, "No hay Mas Canciones", Toast.LENGTH_SHORT).show();
        }
    }




    public void Next(View view){
        if(posicion < vectMp.length-1)
        {
            if (vectMp[posicion].isPlaying()){
                vectMp[posicion].stop();
                posicion++;
                vectMp[posicion].start();
                switch (posicion){
                    case 0:
                        iv.setImageResource(R.drawable.portada1);
                        break;
                    case 1:
                        iv.setImageResource(R.drawable.portada2);
                        break;
                    case 2:
                        iv.setImageResource(R.drawable.portada3);
                }
            }else{
                posicion++;
                switch (posicion){
                    case 0:
                        iv.setImageResource(R.drawable.portada1);
                        break;
                    case 1:
                        iv.setImageResource(R.drawable.portada2);
                        break;
                    case 2:
                        iv.setImageResource(R.drawable.portada3);
                }
            }
        }else{
            Toast.makeText(this,"No hay mas canciones",Toast.LENGTH_SHORT).show();
        }
    }

    public void Repeat(View view)
    {
        if (repetir==1)
        {
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this,"No Repetir",Toast.LENGTH_SHORT).show();
            vectMp[posicion].setLooping(false);
            repetir = 2;
        }else{
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this,"Repetir",Toast.LENGTH_SHORT).show();
            vectMp[posicion].setLooping(true);
            repetir = 1;
        }

    }
}


