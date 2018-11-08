package com.example.root.bachlorhousemanagement;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserDataShowOutputActivity extends AppCompatActivity {

    //DatabaseHandlerOne db= new DatabaseHandlerOne( this );



    public String homeName;
    public  int numberOfMember =5;
    public  int totalMealInt =MainActivity.totalMealMain;
    public  int totalBazarInt =MainActivity.totalBazarMain;

    public  int mealRateInt =MainActivity.totalBazarMain/MainActivity.totalMealMain;
    TextView txtArrName[]=new TextView[numberOfMember];
    TextView txtArrMeal[]=new TextView[numberOfMember];
    TextView txtArrCost[]=new TextView[numberOfMember];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //numberOfMember=getIntent().getExtras().getInt( MainActivity.putextraNumberOfMember );

        //homeName=getIntent().getExtras().getString( MainActivity.putextraHOmeName );

        numberOfMember =MainActivity.numberOFMemberMain;
        homeName=MainActivity.homeNameMain;


        DatabaseHandlerOne db =new DatabaseHandlerOne(this );
        List<Member> allmember=new ArrayList<Member>();
        allmember=db.getAllMember(homeName);



        // setContentView(R.layout.activity_user_data_output);
        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.GRAY);







        //layout.setGravity(0);

        // layout.setGravity(0);



        TextView houseNameJava=new TextView(this);
        houseNameJava.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        houseNameJava.setText( NewUserDataActivity.homeName );
        houseNameJava.setTextSize(35);
        houseNameJava.setGravity(1);
        houseNameJava.setTextColor(Color.GREEN);
        layout.addView(houseNameJava);

        LinearLayout layoutHori1 = new LinearLayout(this);
        layoutHori1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layoutHori1.setOrientation(LinearLayout.HORIZONTAL);



        TextView totalMealTxt=new TextView(this);
        totalMealTxt.setLayoutParams(new LinearLayout.LayoutParams(400,100,1f));
        totalMealTxt.setText("Total Meal");
        totalMealTxt.setTextSize(25);
        totalMealTxt.setGravity(1);
        totalMealTxt.setTextColor(Color.BLUE);
        layoutHori1.addView(totalMealTxt);


        TextView totalMeal=new TextView(this);
        totalMeal.setLayoutParams(new LinearLayout.LayoutParams(400,100,1f));
        totalMeal.setText(Integer.toString( totalMealInt ));
        totalMeal.setTextSize(25);
        totalMeal.setGravity(1);
        totalMeal.setTextColor(Color.BLUE);
        layoutHori1.addView(totalMeal);



        layout.addView(layoutHori1);


        LinearLayout layoutHori2 = new LinearLayout(this);
        layoutHori2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layoutHori2.setOrientation(LinearLayout.HORIZONTAL);





        TextView totalMealCostTxt=new TextView(this);
        totalMealCostTxt.setLayoutParams(new LinearLayout.LayoutParams(400,100,1f));
        totalMealCostTxt.setText("Total Bazar");
        totalMealCostTxt.setTextSize(25);
        totalMealCostTxt.setGravity(1);
        totalMealCostTxt.setTextColor(Color.BLUE);
        layoutHori2.addView(totalMealCostTxt);




        TextView totalBazar=new TextView(this);
        totalBazar.setLayoutParams(new LinearLayout.LayoutParams(400,100,1f));
        totalBazar.setText(Integer.toString( totalBazarInt ));
        totalBazar.setTextSize(25);
        totalBazar.setGravity(1);
        totalBazar.setTextColor(Color.BLUE);
        layoutHori2.addView(totalBazar);

        layout.addView(layoutHori2);


        LinearLayout layoutHori3 = new LinearLayout(this);
        layoutHori3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layoutHori3.setOrientation(LinearLayout.HORIZONTAL);


        TextView mealRateTxt=new TextView(this);
        mealRateTxt.setLayoutParams(new LinearLayout.LayoutParams(400,100,1f));
        mealRateTxt.setText("Meal Rate");
        mealRateTxt.setTextSize(25);
        mealRateTxt.setGravity(1);
        mealRateTxt.setTextColor(Color.BLUE);
        layoutHori3.addView(mealRateTxt);




        TextView mealRate=new TextView(this);
        mealRate.setLayoutParams(new LinearLayout.LayoutParams(400,100,1f));
        mealRate.setText(Integer.toString( mealRateInt ));
        mealRate.setTextSize(25);
        mealRate.setGravity(1);
        mealRate.setTextColor(Color.BLUE);

        layoutHori3.addView(mealRate);


        layout.addView(layoutHori3);


        LinearLayout layoutHori4 = new LinearLayout(this);
        layoutHori4.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layoutHori4.setOrientation(LinearLayout.HORIZONTAL);





        TextView headName=new TextView(this);
        headName.setLayoutParams(new LinearLayout.LayoutParams(250,100,1f));
        headName.setText("Name");
        headName.setTextSize(25);
        headName.setGravity(1);
        headName.setTextColor(Color.WHITE);
        layoutHori4.addView(headName);




        TextView headMeal=new TextView(this);
        headMeal.setLayoutParams(new LinearLayout.LayoutParams(300,100,1f));
        headMeal.setText("Total Meal");
        headMeal.setTextSize(20);
        headMeal.setGravity(1);
        headMeal.setTextColor(Color.WHITE);
        layoutHori4.addView(headMeal);



        TextView headCost=new TextView(this);
        headCost.setLayoutParams(new LinearLayout.LayoutParams(300,100,1f));
        headCost.setText("Total Cost");
        headCost.setGravity(1);
        headCost.setTextSize(20);
        headCost.setTextColor(Color.WHITE);
        layoutHori4.addView(headCost);

        layout.addView(layoutHori4);




        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(scrollView);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,0,1f));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(linearLayout);








        for(int i = 0; i< numberOfMember; i++){

            LinearLayout layoutInnerHori = new LinearLayout(this);
            layoutInnerHori.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutInnerHori.setOrientation(LinearLayout.HORIZONTAL);



            String temp=allmember.get( i ).getName();

            txtArrName[i] = new Button(this);
            txtArrName[i].setLayoutParams(new LinearLayout.LayoutParams(300,100,1f));
            txtArrName[i].setGravity(1);
          //  txtArrName[i].setTextSize(20);
            txtArrName[i].setText(temp);

            txtArrMeal[i]=new TextView(this);
            txtArrMeal[i].setLayoutParams(new LinearLayout.LayoutParams(300,100,1f));
            txtArrMeal[i].setGravity(1);
            txtArrMeal[i].setTextSize(25);
            txtArrMeal[i].setGravity(1);
            txtArrMeal[i].setTextColor(Color.BLUE);
            txtArrMeal[i].setText(Integer.toString( allmember.get( i ).getMeal() ));

            int cost_t =allmember.get( i ).getMeal();
            cost_t*= mealRateInt;

            txtArrCost[i]=new TextView(this);
            txtArrCost[i].setLayoutParams(new LinearLayout.LayoutParams(300,100,1f));
            txtArrCost[i].setText(Integer.toString( cost_t ));
            txtArrCost[i].setTextSize(25);
            txtArrCost[i].setGravity(1);
            txtArrCost[i].setTextColor(Color.BLUE);
            txtArrCost[i].setGravity(1);




            layoutInnerHori.addView( txtArrName[i]);
            layoutInnerHori.addView( txtArrMeal[i]);
            layoutInnerHori.addView( txtArrCost[i]);

            linearLayout.addView(layoutInnerHori);

        }
        setContentView(layout);







    }
}
