package com.example.planetsapp;

//This class is acting as Model Class for our ListView
//it defines behaviour and attributes associated with each item in list
public class Planet {
    //Attributes
    private String planetName;
    private  String moonCount;
    private  int planetImage;
//Resource identifier are used to store and manage images efficiently

    //Constructor
    public Planet(String planetName,String moonCount,int planetImage) {
        this.planetName = planetName;
      this.moonCount = moonCount;
      this.planetImage = planetImage;
    }
    //Getters and Setters


    public String getMoonCount() {
        return moonCount;
    }

    public void setMoonCount(String moonCount) {
        this.moonCount = moonCount;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public int getPlanetImage() {
        return planetImage;
    }

    public void setPlanetImage(int planetImage) {
        this.planetImage = planetImage;
    }
}
