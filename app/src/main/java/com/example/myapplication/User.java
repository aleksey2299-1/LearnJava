package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class User implements Parcelable {



    private String name;
    private String lastName;
    private int age;

    public static final  Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel parcel) {
            String name = parcel.readString();
            String lastName = parcel.readString();
            int age = parcel.readInt();
            return new User(name, lastName, age);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User(String name, String lastName, int age){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastName);
        dest.writeInt(age);
    }
}
