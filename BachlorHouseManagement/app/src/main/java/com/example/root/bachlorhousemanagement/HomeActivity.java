package com.example.root.bachlorhousemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button editBtnJava;
    Button showBtnJava;
    Button exitBtnJava;
    Bundle b;//=getIntent().getExtras();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
         // b=getIntent().getExtras();

        //View someView = findViewById(R.id.enter_input_btn);
        //View root = someView.getRootView(android.R.color.background_dark);
       // root.setBackgroundColor(getResources().getColor(android.R.color.black));

        editBtnJava = (Button) findViewById(R.id.enter_input_btn);

        editBtnJava.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                //Log.d(Integer.toString( x ),Integer.toString( x ));
                Intent intent = new Intent(HomeActivity.this,AllUserMealDataInputActivity.class);
               // intent.putExtras(b );
                startActivity(intent);

            }
        });


        showBtnJava = (Button) findViewById(R.id.show_Output_btn);

        showBtnJava.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Bundle b=getIntent().getExtras();

                Intent intent = new Intent(HomeActivity.this,UserDataShowOutputActivity.class);
              //  intent.putExtras(b );

                startActivity(intent);


            }
        });

        exitBtnJava = (Button)findViewById( R.id.Exit_btn );

        exitBtnJava.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        } );



    }
}
