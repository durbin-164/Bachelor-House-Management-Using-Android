package com.example.root.bachlorhousemanagement;

import android.util.Log;

/**
 * Created by root on 1/29/17.
 */

public class CreateHome {
    private  int id ;
    private  String homename;
    private  String password;
    private  int numberofmember;
    private  int totalBazar;
    private int totalMeal;


    public CreateHome() {

    }

    public CreateHome( String homename, String password, int numberofmember, int totalBazar, int totalMeal) {
        this.id = id;
        this.homename = homename;
        this.password = password;
        this.numberofmember = numberofmember;
        this.totalBazar = totalBazar;
        this.totalMeal = totalMeal;
    }

    public CreateHome(int id, String homename, String password, int numberofmember, int totalBazar, int totalMeal) {
        this.id = id;
        this.homename = homename;
        this.password = password;
        this.numberofmember = numberofmember;
        this.totalBazar = totalBazar;
        this.totalMeal = totalMeal;
    }

    public CreateHome(String homename, String password, int numberofmember) {
        this.homename = homename;
        this.password = password;
        this.numberofmember = numberofmember;
        Log.d(this.password,this.homename);
    }




    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumberofmember() {
        return numberofmember;
    }

    public void setNumberofmember(int numberofmember) {
        this.numberofmember = numberofmember;
    }

    public String getHomename() {
        return homename;
    }

    public void setHomename(String homename) {
        this.homename = homename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalMeal() {
        return totalMeal;
    }

    public void setTotalMeal(int totalMeal) {
        this.totalMeal = totalMeal;
    }

    public int getTotalBazar() {
        return totalBazar;
    }

    public void setTotalBazar(int totalBazar) {
        this.totalBazar = totalBazar;
    }
}
