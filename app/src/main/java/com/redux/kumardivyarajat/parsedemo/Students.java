package com.redux.kumardivyarajat.parsedemo;

import android.graphics.drawable.Drawable;

/**
 * Created by kumardivyarajat on 15/04/15.
 */
public class Students {

    String Name, USN, Semester;
    Drawable pic;

    Students () {

    };

    public Students(String name, Drawable pic, String semester, String USN) {
        Name = name;
        this.pic = pic;
        Semester = semester;
        this.USN = USN;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Drawable getPic() {
        return pic;
    }

    public void setPic(Drawable pic) {
        this.pic = pic;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getUSN() {
        return USN;
    }

    public void setUSN(String USN) {
        this.USN = USN;
    }
}
