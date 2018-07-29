package com.example.denizcan.tamircikapindaadminapp;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.provider.Settings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.app.PendingIntent.getActivity;


public class Home extends AppCompatActivity {




//    public void changeBG() {
//
////        GlobalClass globalClass = (GlobalClass) getApplication();
////        int id=globalClass.ButtonId();
//////        switch (id) {
//////            case 2131230800:
//////                Toast.makeText(getApplicationContext(),"OK",0).show();
////////                viewList.setBackgroundColor(Color.GREEN);
////////                globalClass.setButtonState(globalClass.ButtonState()*2);
//////                break;
//////            case 2131230799:
//////                Toast.makeText(getApplicationContext(),"NO",0).show();
//////
//////                break;
//////            case 2131230798:
//////                Toast.makeText(getApplicationContext(),"BY",0).show();
//////
//////                break;
//////        }
////
////    }



    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView text = (TextView) findViewById(R.id.text);


        getJSON("http://www.tamircikapinda.com/FetchData/getdata.php");

    }


    private void loadIntoListView(String json) throws JSONException {
        //creating a json array from the json string
        JSONArray jsonArray = new JSONArray(json);

        //creating a string array for listview
        final String[] email = new String[jsonArray.length()];
        final String[] problem = new String[jsonArray.length()];
        final String[] adres = new String[jsonArray.length()];
        final String[] telefon = new String[jsonArray.length()];


        //looping through all the elements in json array
        for (int i = 0; i < jsonArray.length(); i++) {

            //getting json object from the json array
            JSONObject obj = jsonArray.getJSONObject(i);

            //getting the name from the json object and putting it inside string array
            email[i] = obj.getString("email");
            problem[i] = obj.getString("problem");
            adres[i] = obj.getString("adres");
            telefon[i] = obj.getString("telefon");

        }

        final ListView listView = (ListView) findViewById(R.id.listView);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, email);
        listView.setAdapter(arrayAdapter);





                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View viewList, int position, long arg3) {

                        GlobalClass globalClass = (GlobalClass) getApplication();

                        globalClass.setEmail(email[position]);
                        globalClass.setTelefon(telefon[position]);
                        globalClass.setProblem(problem[position]);
                        globalClass.setAdres(adres[position]);

                        int dialogButtonId;

                        openDialog();


                    }
                });


    }



            //this method is actually fetching the json string
            private void getJSON(final String urlWebService) {





                /*
                 * As fetching the json string is a network operation
                 * And we cannot perform a network operation in main thread
                 * so we need an AsyncTask
                 * The constrains defined here are
                 * Void -> We are not passing anything
                 * Void -> Nothing at progress update as well
                 * String -> After completion it should return a string and it will be the json string
                 * */
                class GetJSON extends AsyncTask<Void, Void, String> {

                    //this method will be called before execution
                    //you can display a progress bar or something
                    //so that user can understand that he should wait
                    //as network operation may take some time
                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                    }

                    //this method will be called after execution
                    //so here we are displaying a toast with the json string
                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        // Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();

                        try {
                            loadIntoListView(s);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    //in this method we are fetching the json string
                    @Override
                    protected String doInBackground(Void... voids) {


                        try {
                            //creating a URL
                            URL url = new URL(urlWebService);

                            //Opening the URL using HttpURLConnection
                            HttpURLConnection con = (HttpURLConnection) url.openConnection();

                            //StringBuilder object to read the string from the service
                            StringBuilder sb = new StringBuilder();

                            //We will use a buffered reader to read the string from service
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                            //A simple string to read values from each line
                            String json;

                            //reading until we don't find null
                            while ((json = bufferedReader.readLine()) != null) {

                                //appending it to string builder
                                sb.append(json + "\n");
                            }

                            //finally returning the read string
                            return sb.toString().trim();
                        } catch (Exception e) {
                            return null;
                        }

                    }
                }

                //creating asynctask object and executing it
                GetJSON getJSON = new GetJSON();
                getJSON.execute();
            }


            public void openDialog() {
                GlobalClass globalClass = (GlobalClass) getApplication();
                globalClass.setDialogState(1);

                Intent activity_dialog = new Intent(this, dialog_activity.class);
                startActivity(activity_dialog);

            }


        }
