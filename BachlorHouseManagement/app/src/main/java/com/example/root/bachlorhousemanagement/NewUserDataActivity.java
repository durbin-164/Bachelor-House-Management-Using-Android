package com.example.root.bachlorhousemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewUserDataActivity extends AppCompatActivity {
    EditText homeNameEdtJava;

    EditText passwordEdtJava;
    Button savaDataBtnJava;
    EditText numberOfMemberEdtJava;
    public static String homeName;
    public static String password;
    public int numberOfMember;
    public  static  String putExtraHomeName ="x";
    public  static String  put_extra_id="put_extra_id";
    public static  String putExtraNumberOfMember ="b";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuserdata);





        homeNameEdtJava = (EditText) findViewById(R.id.home_name_Et);

        passwordEdtJava = (EditText)findViewById(R.id.password_Et);
        savaDataBtnJava =(Button)findViewById(R.id.save_Bnt);
        numberOfMemberEdtJava =(EditText)findViewById(R.id.number_of_member_Et);
        savaDataBtnJava.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                homeName = homeNameEdtJava.getText().toString();
                 password = passwordEdtJava.getText().toString();
               String s= numberOfMemberEdtJava.getText().toString();
                numberOfMember =Integer.valueOf(s);
                DatabaseHandlerOne db = DatabaseHandlerOne.getInstance( NewUserDataActivity.this );
                Log.d(password, homeName );
                CreateHome newhome =new CreateHome( homeName,password, numberOfMember,0,0);
                db.addHome(newhome);

                Intent intent = new Intent(NewUserDataActivity.this,ListOfUserInformationInputActivity.class);
                Bundle b =new Bundle(  );
                Log.d( homeName +"this is printed ",Integer.toString( numberOfMember ) );



                b.putString( putExtraHomeName, homeName );
                b.putInt( putExtraNumberOfMember, numberOfMember );
               intent.putExtras(b );
                startActivity(intent);
            }
        });

    }
}
