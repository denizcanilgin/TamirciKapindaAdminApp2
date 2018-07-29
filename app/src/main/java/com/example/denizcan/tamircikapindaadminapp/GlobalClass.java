package com.example.denizcan.tamircikapindaadminapp;

import android.app.Application;
import android.widget.Toast;

public class GlobalClass extends Application {

    private String email;
    private String problem;
    private String adres;
    private String telefon;

    private int ButtonId;

    private int DialogState;

    public int DialogState(){
        return DialogState;
    }

    public void setDialogState(int dialogState){
        this.DialogState = DialogState;
    }

    public int ButtonId(){
        return ButtonId;
    }

    public void setButtonId(int ButtonId){
        this.ButtonId = ButtonId;
    }

    public String email() {
        return email;
    }
    public String problem() {
        return problem;
    }
    public String telefon() {
        return telefon;
    }
    public String adres() {
        return adres;
    }
//GET FUNCTIONS

    public void setEmail(String email) {
        this.email = email;
    }
    public void setAdres(String adres) {
        this.adres = adres;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void setProblem(String problem) {
        this.problem = problem;
    }

}