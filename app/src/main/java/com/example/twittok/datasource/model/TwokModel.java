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
}