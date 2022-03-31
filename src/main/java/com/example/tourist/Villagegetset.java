package com.example.tourist;

import java.io.Serializable;

public class Villagegetset implements Serializable {


    public String getArea_under_farming() {
        return Area_under_farming;
    }

    public void setArea_under_farming(String area_under_farming) {
        Area_under_farming = area_under_farming;
    }

    public String getArea_pincode() {
        return Area_pincode;
    }

    public void setArea_pincode(String area_pincode) {
        Area_pincode = area_pincode;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getFamous_Attraction() {
        return Famous_Attraction;
    }

    public void setFamous_Attraction(String famous_Attraction) {
        Famous_Attraction = famous_Attraction;
    }

    public String getFemale_Population() {
        return Female_Population;
    }

    public void setFemale_Population(String female_Population) {
        Female_Population = female_Population;
    }

    public String getMale_population() {
        return Male_population;
    }

    public void setMale_population(String male_population) {
        Male_population = male_population;
    }

    public String getPopular_for() {
        return Popular_for;
    }

    public void setPopular_for(String popular_for) {
        Popular_for = popular_for;
    }

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        Population = population;
    }

    public String getSarpanch() {
        return Sarpanch;
    }

    public void setSarpanch(String sarpanch) {
        Sarpanch = sarpanch;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getHOJ() {
        return HOJ;
    }

    public void setHOJ(String HOJ) {
        this.HOJ = HOJ;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }

    public String getTahsil() {
        return Tahsil;
    }

    public void setTahsil(String tahsil) {
        Tahsil = tahsil;
    }



    public String getVillage_name() {
        return village_name;
    }

    public void setVillage_name(String village_name) {
        this.village_name = village_name;
    }

    String village_name;


    String Area_under_farming;
    String Area_pincode;
    String District;
    String Famous_Attraction;
    String Female_Population;
    String Male_population;
    String Popular_for;
    String Population;
    String Sarpanch;
    String imageURL;
    String HOJ;
    String Post;
    String Tahsil;


    public Villagegetset() {
        //empty constructor needed
    }
    public Villagegetset(String name, String description, String galaxy, String star, String dob,
                         String dod ) {
        if (name.trim().equals("")) {
            name = "Villagegetset NoName";
        }
        this.village_name = name;
        this.District = description;
        this.Popular_for = galaxy;
        this.Popular_for = star;
        this.District = dob;
        this.Tahsil = dod;
    }



}
//end
