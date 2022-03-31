package com.example.tourist;

public class uploadinfo {

    public String village_name;
    public String Tahsil;
    public String District;
    public String Post;
    public String Sarpanch;
    public String HOJ;
    public String Population;
    public String Male_population;

    public String Female_Population;
    public String Famous_Attraction;
    public String Popular_for;
    public String Area_pincode;
    public String Area_under_farming;


    public String imageURL;
    public uploadinfo(){}



    public uploadinfo(String name, String name1, String name2, String name3, String name4, String name5, String name6, String name7, String name8, String name9, String name10, String name11, String name12, String url) {
        this.village_name = name;
        this.Tahsil = name1;
        this.District = name2;
        this.Post = name3;
        this.Sarpanch = name4;
        this.HOJ = name5;
        this.Population = name6;
        this.Male_population = name7;

        this.Female_Population = name8;
        this.Famous_Attraction = name9;
        this.Popular_for = name10;
        this.Area_pincode = name11;
        this.Area_under_farming= name12;
        this.imageURL = url;
    }




}
