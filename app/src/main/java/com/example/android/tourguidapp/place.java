package com.example.android.tourguidapp;

public class place {
        private String mPlace;
        private int mImageResourceId;
        public place(String placeName ,int imageResourceId)
        {
            this.mPlace=placeName;
            this.mImageResourceId=imageResourceId;
        }

    public String getmPlace() {
        return mPlace;
    }

    public int getmImageResourceId() {
            return mImageResourceId;
        }
    }