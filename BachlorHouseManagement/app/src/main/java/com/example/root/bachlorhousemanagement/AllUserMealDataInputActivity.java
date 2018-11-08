package com.example.root.bachlorhousemanagement;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AllUserMealDataInputActivity extends AppCompatActivity {
    public int numberOfMemberTemp;
    public  String homeName;
    TextView nameArrayTxt[];//=new TextView[numberOfMemberTemp];
    EditText mealEdtArray[];
    EditText mealRateShowEdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_all_user_information);



        //numberOfMemberTemp=getIntent().getExtras().getInt( MainActivity.putextraNumberOfMember );

        //homeName=getIntent().getExtras().getString( MainActivity.putextraHOmeName );

        numberOfMemberTemp =MainActivity.numberOFMemberMain;
        homeName=MainActivity.homeNameMain;
        DatabaseHandlerOne db = DatabaseHandlerOne.getInstance( this );
        List<Member> allmember=new ArrayList<Member>();
        allmember=db.getAllMember(homeName);




        Log.d( Integer.toString( numberOfMemberTemp ),    homeName);
         nameArrayTxt =new TextView[numberOfMemberTemp];
        mealEdtArray =new EditText[numberOfMemberTemp];






        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.GRAY);

        TextView houseManeJava=new TextView(this);
        houseManeJava.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        houseManeJava.setText( NewUserDataActivity.homeName );
        houseManeJava.setTextSize(35);
        houseManeJava.setGravity(1);
        houseManeJava.setTextColor(Color.GREEN);
        layout.addView(houseManeJava);


        TextView dateTxtJava=new TextView(this);
        dateTxtJava.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        dateTxtJava.setText("Enter Date");
        dateTxtJava.setTextSize(25);
        dateTxtJava.setGravity(1);
        dateTxtJava.setTextColor(Color.BLUE);
        layout.addView(dateTxtJava);


        EditText dateJava=new EditText(this);
        dateJava.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        dateJava.setHint("01");
        dateJava.setGravity(1);
        layout.addView(dateJava);

        TextView costTxt=new TextView(this);
        costTxt.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        costTxt.setText("Enter Bazar");
        costTxt.setTextSize(25);
        costTxt.setGravity(1);
        costTxt.setTextColor(Color.BLUE);
        layout.addView(costTxt);

         mealRateShowEdt =new EditText(this);
        mealRateShowEdt.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        mealRateShowEdt.setHint("01");
        mealRateShowEdt.setGravity(1);
        layout.addView( mealRateShowEdt );






        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(scrollView);

        LinearLayout layoutInner = new LinearLayout(this);
        layoutInner.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layoutInner.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(layoutInner);


        for(int i = 0; i< numberOfMemberTemp; i++){

           LinearLayout layoutInnerHori = new LinearLayout(this);
            layoutInnerHori.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutInnerHori.setOrientation(LinearLayout.HORIZONTAL);


            // layoutInnerHori=new LinearLayout(this);
            // layoutInnerHori[i].setBackgroundColor(000);



          //  String temp=ListOfUserInformationInputActivity.name[i];
            String temp=allmember.get( i ).getName();
            nameArrayTxt[i] = new Button(this);
            nameArrayTxt[i].setLayoutParams(new LinearLayout.LayoutParams(400,100,1f));
            nameArrayTxt[i].setTextColor(Color.BLUE);
            //nameArrayTxt[i].setBackgroundColor(Color.GRAY);
            nameArrayTxt[i].setTextSize(20);
            nameArrayTxt[i].setText(temp);

         //   btn_arr_java[i].setHint("NAME"+Integer.toString(i)+" "+Integer.toString(i));

            mealEdtArray[i]=new EditText(this);
            mealEdtArray[i].setLayoutParams(new LinearLayout.LayoutParams(400,100,1f));
           // mealEdtArray[i].setBackgroundColor(Color.WHITE);
            mealEdtArray[i].setGravity(1);
            mealEdtArray[i].setHint("meal number");

            layoutInnerHori.addView( nameArrayTxt[i]);
            layoutInnerHori.addView( mealEdtArray[i]);

           // setContentView(layoutInnerHori);


            //layoutInner.addView(btn_arr_java[i]);
            //layoutInner.addView(mealEdtArray[i]);
           layoutInner.addView(layoutInnerHori);
            //setContentView(layoutInner);


        }

        Button saveInput =new Button(this);
        saveInput.setText("save");
        saveInput.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        saveInput.setGravity(1);
        layoutInner.addView(saveInput);

/*
        TextView confirmation_txt=new TextView(this);
        confirmation_txt.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        confirmation_txt.setText("Data save complete");
        confirmation_txt.setGravity(1);
        layout.addView(confirmation_txt);
*/





        saveInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseHandlerOne db = DatabaseHandlerOne.getInstance( AllUserMealDataInputActivity.this );                List<Member> allmember=new ArrayList<Member>();
                allmember=db.getAllMember(homeName);
                int totalmal=0;


                for(int i = 0; i< numberOfMemberTemp; i++) {
                     int temp=allmember.get( i ).getMeal();
                    String x= mealEdtArray[i].getText().toString();
                    Log.d( ( x ),Integer.toString( temp ) );
                    temp+= Integer.valueOf( x);//Integer.valueOf( mealEdtArray[i].getText().toString());
                   totalmal+=temp;
                     allmember.get( i ).setMeal( temp );


               }

                int totalbazar=Integer.valueOf( mealRateShowEdt.getText().toString() );
                MainActivity.totalBazarMain+=totalbazar;
                MainActivity.totalMealMain=totalmal;
                db.updateBazar(MainActivity.idmain,MainActivity.totalBazarMain,MainActivity.totalMealMain );

                db.updateMeal( homeName,allmember );



                Intent intent = new Intent(AllUserMealDataInputActivity.this,HomeActivity.class);
                startActivity(intent);


            }
        });


        setContentView(layout);

    }
}
