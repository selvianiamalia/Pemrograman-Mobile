package com.example.tgsprak5fragment;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Post implements Parcelable {

    private Uri image;

    public Post() {
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    public void setCapt(String capt) {
        this.capt = capt;
    }

    private String capt;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post(Uri image, String capt) {
        this.image = image;
        this.capt = capt;
    }
    public String getCapt() {
        return capt;
    }

    public Uri getImage() {
        return image;
    }

    protected Post(Parcel in) {
        this.capt = in.readString();
        this.image =in.readParcelable(Uri.class.getClassLoader());
        this.user = in.readParcelable(User.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.capt);
        dest.writeParcelable(this.image, flags);
        dest.writeParcelable(this.user, flags);
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

