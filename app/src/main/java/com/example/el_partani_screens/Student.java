package com.example.el_partani_screens;

import android.graphics.Bitmap;

public class Student {
    private String Name;
    private String claas;
    private Bitmap bitmap;

    public Student(){
        //for fire base
    }
    public Student(String name, String claas, Bitmap bitmap) {
        Name = name;
        this.claas = claas;
        this.bitmap = bitmap;
    }

    public Student(String name, String claas) {
        Name = name;
        this.claas = claas;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getClaas() {
        return claas;
    }

    public void setClaas(String claas) {
        this.claas = claas;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}

