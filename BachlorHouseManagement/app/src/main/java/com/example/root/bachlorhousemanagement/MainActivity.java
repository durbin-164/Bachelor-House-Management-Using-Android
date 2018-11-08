package com.example.root.bachlorhousemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

     //DatabaseHandlerOne db = DatabaseHandlerOne.getInstance( this );

    public  static  String putextraHOmeName="home";
    public  static  String putextraNumberOfMember="numberfomember";
    public  static  String homeNameMain;
    public  static int numberOFMemberMain;
    public static  int idmain;
    public  static int totalBazarMain;
    public static  int totalMealMain;

    Button creatNewAccountBtnJava;

    EditText homeNameEt;
    EditText passwordEt;

    String homeName;
    String password;




    Button loginBtnJava;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /* DatabaseHandlerOne db =new DatabaseHandlerOne( MainActivity.this );
        List<CreateHome> allhome=new ArrayList<CreateHome>();
        allhome=db.getAllHome();

        boolean flag=false;
        for(CreateHome ch : allhome) {
            Log.d( "Reading: ", "Reading...." );
            Log.d( ch.getHomename(), ch.getPassword() );

        }
*/
          homeNameEt=(EditText)findViewById( R.id.homeNameEditview );
          passwordEt=(EditText)findViewById( R.id.passwordEditView );


        creatNewAccountBtnJava = (Button) findViewById(R.id.createnewaccountButton);

        creatNewAccountBtnJava.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NewUserDataActivity.class);
                startActivity(intent);

            }
        });

        loginBtnJava = (Button) findViewById(R.id.loginBtn);

        loginBtnJava.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeName=homeNameEt.getText().toString();
                password=passwordEt.getText().toString();

                DatabaseHandlerOne db = DatabaseHandlerOne.getInstance( MainActivity.this );
                List<CreateHome> allhome=new ArrayList<CreateHome>();
                allhome=db.getAllHome();

                boolean flag=false;
                for(CreateHome ch : allhome){
                    Log.d("Reading: ","Reading....");
                    Log.d(ch.getHomename(),ch.getPassword());
                    if(ch.getHomename().equals( homeName ))
                    {

                        if(ch.getPassword().equals( password )){
                            flag =true;


                           homeNameMain=ch.getHomename();
                            numberOFMemberMain=ch.getNumberofmember();
                            idmain=ch.getId();
                            totalBazarMain = ch.getTotalBazar();
                            totalMealMain=ch.getTotalMeal();
                            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                          //  Bundle b=new Bundle( );
                           // b.putString(putextraHOmeName,ch.getHomename() );
                           // b.putInt(putextraNumberOfMember,ch.getNumberofmember() );


                           // intent.putExtras(b);
                            startActivity(intent);

                        }

                    }
                }
              if(!flag)  Toast.makeText(getApplicationContext(), "wrong pass id",Toast.LENGTH_LONG).show();


            }
        });




    }
}
