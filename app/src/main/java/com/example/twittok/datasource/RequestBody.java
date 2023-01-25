package com.example.twittok.datasource;

import com.example.twittok.repositories.SidRepository;
import com.example.twittok.repositories.TwokRepository;

public class RequestBody{
    private String sid = new SidRepository().getSid();
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
    public RequestBody(String name, String picture) {
        this.name = name;
        this.picture = picture;
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
    public RequestBody(String text, String bgcol, String fontcol, Integer fontsize, Integer fonttype, Integer halign, Integer valign) {
        this.text = text;
        this.bgcol = bgcol;
        this.fontcol = fontcol;
        this.fontsize = fontsize;
        this.fonttype = fonttype;
        this.halign = halign;
        this.valign = valign;
    }
}
