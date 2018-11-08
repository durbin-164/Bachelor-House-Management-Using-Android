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

public class ListOfUserInformationInputActivity extends AppCompatActivity {
    public   int numberOfMember;
    public  String homeName;
    public  static  String name[];//=new String[numberOfMember];

    EditText nameInputEdtArray[];//= new EditText[numberOfMember];
    Button saveBtnJava;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_list__of__user_information_);
       // Bundle b= getIntent().getExtras();

        //numberOfMember=MainActivity.numberOFMemberMain;
        //homeName=MainActivity.homeNameMain;
         numberOfMember =getIntent().getExtras().getInt( NewUserDataActivity.putExtraNumberOfMember );

        homeName =getIntent().getExtras().getString( NewUserDataActivity.putExtraHomeName );

        Log.d( homeName +"List Class",Integer.toString( numberOfMember ));



       name =new String[numberOfMember];
        nameInputEdtArray = new EditText[numberOfMember];





        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.GRAY);



        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        layout.addView(scrollView);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
         linearLayout.setGravity(1);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(linearLayout);
        for(int i = 0; i< numberOfMember; i++){
            String temp=Integer.toString(i);

            nameInputEdtArray[i] = new EditText(this);

            nameInputEdtArray[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,100));
            nameInputEdtArray[i].setHint("NAME"+Integer.toString(i)+" "+Integer.toString(i));
            nameInputEdtArray[i].setGravity(1);

            linearLayout.addView( nameInputEdtArray[i]);

        }


        saveBtnJava = new Button(this);
        saveBtnJava.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        saveBtnJava.setText("Save");
        saveBtnJava.setTextColor(Color.BLUE);
        saveBtnJava.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHandlerOne db = DatabaseHandlerOne.getInstance( ListOfUserInformationInputActivity.this );
                db.createTable( homeName );
                UserData userdata =new UserData( );
                for(int i = 0; i< numberOfMember; i++){
                    name[i]= nameInputEdtArray[i].getText().toString();
                    userdata.setUserName( name[i] );
                    userdata.setNumberOfMeal( 0 );
                    userdata.setCost( 0 );
                     db.addUserData( userdata );

                }

                Intent intent = new Intent(ListOfUserInformationInputActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
        linearLayout.addView( saveBtnJava );

        setContentView(layout);

    }

}
