package com.example.tgsprak4chat;

import java.util.ArrayList;
import java.util.Arrays;

public class DataSource {
    public static ArrayList<Chat> chats = new ArrayList<>(
            Arrays.asList(
                    new Chat("Zabil Sabri", "Selamat hari raya idul fitri!", "17.54", "capek", "April 30, 2023", "08114613767", R.drawable.zabil),
                    new Chat("Kak rafly'19", "sorry baru balas selvi soalnya ketiduran hehe", "15.31", "sibuk pake banget!", "January 20, 2022", "081123456789", R.drawable.kakraf),
                    new Chat("Astrina", "lo dicariin jungkook tuh", "10.40", "ujian ujian", "October 18, 2022", "081234097787", R.drawable.img_4),
                    new Chat("Uni", "jalan yok besok", "10.34", "au ah cape", "December 21, 2022", "081305712412", R.drawable.salma),
                    new Chat("Iin", "ih maumi lebarann", "22.15", "ada", "January 17, 2023", "089509387211", R.drawable.img_2),
                    new Chat("Firah", "dmna ko mau mi mulaii", "15.30", "sibuk", "December 25, 2022", "081125760810", R.drawable.img_1),
                    new Chat("Ica", "Bukber yuk!", "10.36", "bismillah", "April 20, 2023", "08586987412", R.drawable.profilcute),
                    new Chat("Isty", "eh tgs mu dle!", "13.00", "di sekolah", "December 15, 2022", "08586120412", R.drawable.iqbal),
                    new Chat("Iqbal", "dinner yok!", "05.00", "sedang di rumah", "March 20, 2022", "085209876543", R.drawable.img_5),
                    new Chat("doi", "pagi cantik", "05.10", "hareudang", "December 10, 2022", "08586990412", R.drawable.doi),
                    new Chat("Adel", "gas malino deh bsk", "12.30", "di kantor", "December 01, 2022", "089900221199", R.drawable.img_3)
            )
    );

    public static ArrayList<Chat> chatlist = new ArrayList<>(
            Arrays.asList(
                    new Chat("Haiiiiiiiii", "13.00", "hai juga", "21.00"),
                    new Chat("apasi", "07.00", "apa jga", "15.40"),
                    new Chat("blabal", "10.00", "apaansi", "15.00"),
                    new Chat("cantiknya", "13.45", "makasi hihiw", "22.00"),
                    new Chat("astga", "13.32", "lahh loh", "16.00"),
                    new Chat("bisanya", "13.00", "shareloc sob", "13.00"),
                    new Chat("bingungkaaa antara mau kerja tugas sama mau mi juga libur lebarann", "13.00", "hai juga", "15.00"),
                    new Chat("wee dimanakooo bingungkuu tersesatka keknya", "13.00", "di jonggol ka", "18.00"),
                    new Chat("apakah we", "13.00", "syarla menang kah", "12.00"),
                    new Chat("we apaantu", "13.00", "hai juga", "15.00"),
                    new Chat("waw cantiknya selvi haha", "13.00", "hai juga", "15.00")
            )
    );
    static ArrayList<Chat> getLastChat(){
        ArrayList<Chat> chatArrayList = chatlist;
        return chatArrayList;
    };

}
