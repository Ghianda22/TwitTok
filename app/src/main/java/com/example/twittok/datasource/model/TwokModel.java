package com.example.twittok.datasource.model;

public class TwokModel {
    private Integer uid;
    private String name;
    private Integer pversion;
    private Integer tid;

    private String text;
    private String bgcol;
    private String fontcol;
    private Integer fontsize;
    private Integer fonttype;
    private Integer halign;
    private Integer valign;
    private Double lat = null;
    private Double lon = null;

    public TwokModel() {
    }


    //without position
    public TwokModel(Integer uid, String name, Integer pversion, Integer tid, String text, String bgcol, String fontcol, Integer fontsize, Integer fonttype, Integer halign, Integer valign) {
        this.uid = uid;
        this.name = name;
        this.pversion = pversion;
        this.tid = tid;
        this.text = text;
        this.bgcol = bgcol;
        this.fontcol = fontcol;
        this.fontsize = fontsize;
        this.fonttype = fonttype;
        this.halign = halign;
        this.valign = valign;
    }

    //with position
    public TwokModel(Integer uid, String name, Integer pversion, Integer tid, String text, String bgcol, String fontcol, Integer fontsize, Integer fonttype, Integer halign, Integer valign, Double lat, Double lon) {
        this.uid = uid;
        this.name = name;
        this.pversion = pversion;
        this.tid = tid;
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

    @Override
    public String toString() {
        return "\nTwokModel{" +
                "\n    uid=" + uid +
                ", \n    name='" + name + '\'' +
                ", \n    pversion=" + pversion +
                ", \n    tid=" + tid +
                ", \n    text='" + text + '\'' +
                ", \n    bgcol='" + bgcol + '\'' +
                ", \n    fontcol='" + fontcol + '\'' +
                ", \n    fontsize=" + fontsize +
                ", \n    fonttype=" + fonttype +
                ", \n    halign=" + halign +
                ", \n    valign=" + valign +
                ", \n    lat=" + lat +
                ", \n    lon=" + lon +
                "\n}";
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPversion() {
        return pversion;
    }

    public void setPversion(Integer pversion) {
        this.pversion = pversion;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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