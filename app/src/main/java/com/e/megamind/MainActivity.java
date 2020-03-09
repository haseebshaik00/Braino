package com.e.megamind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6;
    ArrayList<Integer> a2 = new ArrayList<Integer>();
    int c,n,f=0,s=0;
    TextView t1,t4,t2,t3;
    public void start(View view)
    {
        b1.setVisibility(View.INVISIBLE);
        f=1;
        again(b6 = (Button) findViewById(R.id.b6));
    }

    public void again(View view)
    {
        if(f==1) {
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            s = 0;
            n = 0;
            t1.setText("30s");
            t2.setText("0/0");
            t4.setText("");
            b6.setVisibility(View.INVISIBLE);
            g();
            new CountDownTimer(30100, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    t1.setText(String.valueOf(millisUntilFinished / 1000) + "s");
                }

                @Override
                public void onFinish() {
                    t1.setText("0s");
                    t4.setVisibility(View.VISIBLE);
                    t4.setText("Score:" + Integer.toString(s) + "/" + Integer.toString(n));
                    MediaPlayer m3 = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    m3.start();
                    f=1;
                    b6.setVisibility(View.VISIBLE);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                }
            }.start();
        }
    }

    public void g()
    {
        Random r = new Random();

        int a = r.nextInt(21);
        int b = r.nextInt(21);

        String a1 = Integer.toString(a);
        String b1 = Integer.toString(b);

        t3.setText(a1+"+"+b1);

        c=r.nextInt(4);
        a2.clear();
        int ic,i;

        for(i=0;i<4;i++)
        {
            if(i==c) {
                a2.add(a + b);
            }
            else {
                ic=r.nextInt(41);
                while(ic==a+b)
                {
                    ic=r.nextInt(41);
                }
                a2.add(ic);
            }
        }

        b2.setText(Integer.toString(a2.get(0)));
        b3.setText(Integer.toString(a2.get(1)));
        b4.setText(Integer.toString(a2.get(2)));
        b5.setText(Integer.toString(a2.get(3)));
    }

    public void answer(View view)
    {
        if(view.getTag().toString().equals(Integer.toString(c)))
        {
            s++;
            t4.setText("Right!");
            t4.setVisibility(View.VISIBLE);
            t4.postDelayed(new Runnable() {
                public void run() {
                    t4.setVisibility(View.INVISIBLE);
                }
            }, 1000);
        }
        else
        {
            t4.setText("Wrong!");
            t4.setVisibility(View.VISIBLE);
            t4.postDelayed(new Runnable() {
                public void run() {
                    t4.setVisibility(View.INVISIBLE);
                }
            }, 1000);
        }

        n++;
        t2.setText(Integer.toString(s)+"/"+Integer.toString(n));
        g();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.b1);
        t3 = (TextView) findViewById(R.id.t3);
        t4 = (TextView) findViewById(R.id.t4);
        t2 = (TextView) findViewById(R.id.t2);
        t1 = (TextView) findViewById(R.id.t1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
    }
}
