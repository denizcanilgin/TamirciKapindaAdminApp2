package com.example.denizcan.tamircikapindaadminapp;

import android.app.MediaRouteButton;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class dialog_activity extends AppCompatActivity implements View.OnClickListener {

    Button serviceOkay;
    Button serviceCancel;
    Button serviceNothing;

    TextView userEmail;
    TextView userTelefon;
    TextView userAdres;
    TextView userProblem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_activity);
        
        
        serviceCancel = (Button) findViewById(R.id.hizmetIptal);
        serviceOkay = (Button) findViewById(R.id.hizmetTamamlandi);
        serviceNothing = (Button) findViewById(R.id.hizmetAskida);

        serviceOkay.setOnClickListener(dialog_activity.this);
        serviceCancel.setOnClickListener(this);
        serviceNothing.setOnClickListener(this);

        userEmail = (TextView) findViewById(R.id.userEmail);
        userProblem = (TextView) findViewById(R.id.userProblem);
        userAdres = (TextView) findViewById(R.id.userAdres);
        userTelefon = (TextView) findViewById(R.id.userTelefon);

        GlobalClass globalClass = (GlobalClass) getApplication();

        userEmail.setText(globalClass.email());
        userProblem.setText(globalClass.problem());
        userTelefon.setText(globalClass.telefon());
        userAdres.setText(globalClass.adres());




    }

    public void onClick(View view) {

        GlobalClass globalClass = (GlobalClass) getApplication();
        switch (view.getId()) {
            case 2131230800:
                Toast.makeText(getApplicationContext(),"OK",0).show();
                globalClass.setDialogState(0);
//                viewList.setBackgroundColor(Color.GREEN);
//                globalClass.setButtonState(globalClass.ButtonState()*2);
                break;
            case 2131230799:
                Toast.makeText(getApplicationContext(),"NO",0).show();
                globalClass.setDialogState(0);
                break;
            case 2131230798:
                Toast.makeText(getApplicationContext(),"BY",0).show();
                globalClass.setDialogState(0);
                break;


        }
        finish();



    }

//    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);


//    public void onClick(View v) {
//        v.startAnimation(buttonClick);
//    }

}
