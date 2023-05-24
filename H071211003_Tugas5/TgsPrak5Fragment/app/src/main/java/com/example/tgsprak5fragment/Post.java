package com.example.tgsprak5fragment;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Post implements Parcelable {

    private String fullName;
    private int photoRes;

    public Post(Uri image) {
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;
    private String capt;

    public String getCapt() {
        return capt;
    }

    public void setCapt(String capt) {
        this.capt = capt;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    private Uri image;


    public Post(String fullName, String userName, int photoRes,String capt, Uri image){
        this.fullName = fullName;
        this.userName = userName;
        this.photoRes = photoRes;
        this.capt = capt;
        this.image = image;
    }

    protected Post(Parcel in) {
        this.fullName = in.readString();
        this.userName = in.readString();
        this.photoRes = in.readInt();
        this.capt = in.readString();
        this.image = (Uri) in.readParcelable(Uri.class.getClassLoader());
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhotoRes() {
        return photoRes;
    }

    public void setPhotoRes(int photoRes) {
        this.photoRes = photoRes;
    }

    public String getPostName() {
        return userName;
    }

    public void setPostName(String userName) {
        this.userName = userName;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fullName);
        dest.writeString(this.userName);
        dest.writeInt(this.photoRes);
        dest.writeString(this.capt);
        dest.writeParcelable(this.image, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };
}

