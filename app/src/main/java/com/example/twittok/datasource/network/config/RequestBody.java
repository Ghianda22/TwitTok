package com.example.twittok.datasource.network.config;

import com.example.twittok.R;
import com.example.twittok.datasource.model.SidModel;
import com.example.twittok.repositories.SidRepository;

public class RequestBody{
    private String sid = SidRepository.getSid();
    private Integer uid = null;
    private String name = null;
    private String picture = null;
    private String text = null;
    private String bgcol = null;
    private String fontcol = null;
    private Integer fontsize = null;
    private Integer fonttype = null;
    private Integer halign = null;
    private Integer valign = null;
    private Double lat = null;
    private Double lon = null;

    public RequestBody(){}

    public RequestBody(Integer uid) {
        this.uid = uid;
    }
    // setProfile
    //can't create 2 constructor like twok ones, they'd be indistinguishable w just 1 string
    //Am I setting the name or the picture?
    //Could implement length control in constructor, but it's way more easier to just set one param to null
    public RequestBody(String name, String picture) {
        this.name = name;
        this.picture = picture;
    }

    //addTwok
    public RequestBody(String text, String bgcol, String fontcol, Integer fontsize, Integer fonttype, Integer halign, Integer valign) {
        this.text = text;
        this.bgcol = bgcol;
        this.fontcol = fontcol;
        this.fontsize = fontsize;
        this.fonttype = fonttype;
        this.halign = halign;
        this.valign = valign;
    }
    public RequestBody(String text, String bgcol, String fontcol, Integer fontsize, Integer fonttype, Integer halign, Integer valign, Double lat, Double lon) {
        this.text = text;
        this.bgcol = bgcol;
        this.fontcol = fontcol;
        this.fontsize = fontsize;
        this.fonttype = fonttype;
        this.halign = halign;
        this.valign = valign;
        this.lat = lat;
        this.lon = lon;
    }
}






