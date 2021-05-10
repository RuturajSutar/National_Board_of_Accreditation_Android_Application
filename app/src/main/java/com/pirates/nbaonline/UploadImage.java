package com.pirates.nbaonline;

public class UploadImage {
    private String Imagename;
    private String Imageurl;

    public UploadImage() {
    }

    public UploadImage(String name, String url) {

        if (name.trim().equals("")) {
            name = "No Name";
        }
        Imagename = name;
        Imageurl = url;
    }

    public String getImagename() {
        return Imagename;
    }

    public String getImageurl() {
        return Imageurl;
    }

    public void setImagename(String imagename) {
        Imagename = imagename;
    }

    public void setImageurl(String imageurl) {
        Imageurl = imageurl;
    }
}
