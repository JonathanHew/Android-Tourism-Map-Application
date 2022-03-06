package com.example.ca_tourism_app;

public class Attraction
{
    int _id;
    String _name;
    String _description;
    String _lat;
    String _longi;


    public Attraction(String name, String description, String lat, String longi)
    {
        this._name = name;
        this._description=  description;
        this._lat = lat;
        this._longi = longi;
    }

    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    //name getter
    public String getName()
    {
        return this._name;
    }
    //name setter
    public void setName(String name)
    {
        this._name = name;
    }

    //desc getter
    public String getDescription()
    {
        return this._description;
    }
    //desc setter
    public void setDescription(String description)
    {
        this._description = description;
    }

    public String getLat()
    {
        return this._lat;
    }
    //name setter
    public void setLat(String lat)
    {
        this._lat = lat;
    }

    public String getLongi()
    {
        return this._longi;
    }
    //name setter
    public void setLongi(String longi)
    {
        this._longi = longi;
    }

}

