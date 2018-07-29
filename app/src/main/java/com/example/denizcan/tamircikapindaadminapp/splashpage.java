package com.example.denizcan.tamircikapindaadminapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class splashpage extends Activity {


    private final int PASSWORD = 24232423;


    private ImageView iv;
    private TextView tv;

    private EditText enterPass;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashpage);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

//        ImageView upper_cable = (ImageView) findViewById(R.id.upper_cable);
//        ImageView lower_cable = (ImageView) findViewById(R.id.lower_cable);
//
//        upper_cable.setTranslationY(-1000f);
//        upper_cable.animate().translationYBy(1000f).setDuration(2000);
//
//        lower_cable.setTranslationY(+1000f);
//        lower_cable.animate().translationYBy(-1000f).setDuration(2000);


//        Animation upper_cable_anim = AnimationUtils.loadAnimation(this,R.anim.enter_from_up);
//        Animation lower_cable_anim = AnimationUtils.loadAnimation(this,R.anim.enter_from_down);


        enterPass = (EditText) findViewById(R.id.enterPass);
        loginButton = (Button) findViewById(R.id.loginButton);

        iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.splashText);

        Animation logoAnim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        Animation textAnim = AnimationUtils.loadAnimation(this, R.anim.mytransition);

        tv.startAnimation(textAnim);
        iv.startAnimation(logoAnim);

        tv.setTranslationY(200f);
        iv.setTranslationY(200f);

        iv.animate().translationYBy(-300f).setDuration(1000);
        tv.animate().translationYBy(-300f).setDuration(1000);

        enterPass.animate().alpha(1f).setDuration(2000);
        loginButton.animate().alpha(0.85f).setDuration(2000);


        final Intent i = new Intent(this, Home.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredPass = enterPass.getText().toString();
                if (Integer.parseInt(enteredPass) == PASSWORD){ startActivity(i);
                    Toast.makeText(getApplicationContext()," Giriş Başarılı! ",0).show();
                }
                else Toast.makeText(getApplicationContext()," Şifre geçersiz! ",0).show();
            }
        });


//dsadsad

//        Animation logoAnimUp = AnimationUtils.loadAnimation(this, R.anim.enter_from_right);
//         iv.startAnimation(logoAnimUp);


//        Thread timer = new Thread() {
//            public void run() {
//                try {
//                    sleep(2000);
//                    startActivity(i);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//
//                } finally {
//
//                    finish();
//
//                }
//            }
//
//        };
//        timer.start();

    }
}

