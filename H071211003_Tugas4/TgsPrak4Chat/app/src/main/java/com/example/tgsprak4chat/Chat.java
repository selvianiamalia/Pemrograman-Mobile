package com.example.tgsprak4chat;

import android.widget.RelativeLayout;

public class Chat {
    private String name, chat, time;

    public Chat(Chat chat) {

    }

    public Chat(String chat, String time) {

    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastseen() {
        return lastseen;
    }

    public void setLastseen(String lastseen) {
        this.lastseen = lastseen;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    private String status, lastseen, notelp;
    private int profile;
    private String textchata;
    private String timea;
    private String textchatb;
    private String timeb;

    public String getTextchat2() {
        return textchatb;
    }

    public void setTextchat2(String textchat2) {
        this.textchatb = textchat2;
    }

    public String getTime2() {
        return timeb;
    }

    public void setTime2(String timeb) {
        this.timeb = timeb;
    }

    public String getTextchat1() {
        return textchata;
    }

    public void setTextchat1(String textchat1) {
        this.textchata = textchat1;
    }

    public String getTime1() {
        return timea;
    }

    public void setTime1(String timea) {
        this.timea = timea;
    }


    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public Chat(String name, String chat, String time, String status, String lastseen, String notelp, int profile) {
        this.name = name;
        this.chat = chat;
        this.time = time;
        this.notelp = notelp;
        this.profile = profile;
        this.status = status;
        this.lastseen = lastseen;
    }
    public Chat(String textchat1, String timea, String textchat2, String timeb) {
        this.textchata = textchat1;
        this.timea = timea;
        this.textchatb = textchat2;
        this.timeb = timeb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
