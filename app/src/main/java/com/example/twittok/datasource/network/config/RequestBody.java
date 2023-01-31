package com.example.twittok.datasource.network.config;

import com.example.twittok.R;
import com.example.twittok.datasource.model.SidModel;
import com.example.twittok.repositories.SidRepository;

public class RequestBody{
    // --- ATTRIBUTES ------------------------------------------------------------------------------
    private String sid = SidRepository.getSid();
    private Integer uid = null;
    private Integer tid = null;
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



    // --- CONSTRUCTORS ----------------------------------------------------------------------------
    public RequestBody(){}
    public RequestBody(Integer uid) {
        this.uid = uid;
        this.tid = tid;
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



    // --- GETTERS & SETTERS -----------------------------------------------------------------------

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBgcol() {
        return bgcol;
    }

    public void setBgcol(String bgcol) {
        this.bgcol = bgcol;
    }

    public String getFontcol() {
        return fontcol;
    }

    public void setFontcol(String fontcol) {
        this.fontcol = fontcol;
    }

    public Integer getFontsize() {
        return fontsize;
    }

    public void setFontsize(Integer fontsize) {
        this.fontsize = fontsize;
    }

    public Integer getFonttype() {
        return fonttype;
    }

    public void setFonttype(Integer fonttype) {
        this.fonttype = fonttype;
    }

    public Integer getHalign() {
        return halign;
    }

    public void setHalign(Integer halign) {
        this.halign = halign;
    }

    public Integer getValign() {
        return valign;
    }

    public void setValign(Integer valign) {
        this.valign = valign;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}






