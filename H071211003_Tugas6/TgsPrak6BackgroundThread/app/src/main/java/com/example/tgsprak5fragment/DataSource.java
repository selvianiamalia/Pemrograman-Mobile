package com.example.tgsprak5fragment;

import android.net.Uri;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class DataSource {

    private static final String URI_CONST="android.resource://com.example.tgsprak5fragment/";
    public static ArrayList<Post> users = new ArrayList<>();

    public ArrayList<Post> getUsers(){
        return users;
    }

     public DataSource(){
        users.addAll(dummyData());
     }


    public ArrayList<User> getUsersByQuery(String q) {
        ArrayList<User> filteredUsers = new ArrayList<>();

        User tempUser = users.get(0).getUser();

        for(int i = 0; i < users.size(); i++) {
            User user = users.get(i).getUser();

            if (i > 0){
                if (tempUser.getUserName().equals(user.getUserName()) || tempUser.getFullName().equals(user.getFullName())){
                    continue;
                }
            }

            String query = q.toLowerCase();

            String fullname = user.getFullName().toLowerCase();
            String username = user.getUserName().toLowerCase();

            if (fullname.startsWith(query) || username.startsWith(query)) {
                filteredUsers.add(user);
            }
            tempUser = user;
        }
        return filteredUsers;
    }

    public void addUsers(Post post){
        this.getUsers().add(0, post);
    }
    public ArrayList<Post> dummyData() {
//        ArrayList<User> usersDummy = new ArrayList<>();
        ArrayList<Post> usersDummy = new ArrayList<>();

        for (int i = 0; i < dataNames.length; i++){
//            User userr = new User(dataNames[i][0], dataNames[i][1]), photoRes[i], new Post(Uri.parse(URI_CONST + photoRes[i]),"Loremm"););
            Post post = new Post();
            post.setImage(Uri.parse(URI_CONST + photoRes[i]));
            post.setCapt("Lorem lipsum dolor sit amet, consectetur adpsing allalal. ih bingung banget ya kan ini tugas susah banget.");
            post.setUser(new User(dataNames[i][0],
                    dataNames[i][1],
                    photoRes[i]));
            usersDummy.add(post);
        }

        return usersDummy;
    };

    private String[][] dataNames = new String[][] {
            {"Selviani Amalia Kartika", "selvianiaml"},
            {"Ayu Ajid", "ayujid"},
            {"Rafly Masloman", "rafmasloman_"},
            {"Jefri Nichol", "jeff"}
    };


    private final int[] photoRes = new int[] {
            R.drawable.profilepict,
            R.drawable.profilepict,
            R.drawable.profilepict,
            R.drawable.profilepict,
    };

}
