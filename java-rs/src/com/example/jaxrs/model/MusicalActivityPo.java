package com.example.jaxrs.model;


public class MusicalActivityPo {


    private int id;
    public MusicalActivityPo() {

    }
    public MusicalActivityPo(int id, String area, String longhair, String event) {
        this.id = id;
        this.area = area;
        this.longhair = longhair;
        this.event = event;
    }

    /**
     * 区域
     */
    private String area;

    /**
     * 艺术家
     */
    private String longhair;

    /**
     * 事件
     */
    private String event;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLonghair() {
        return longhair;
    }

    public void setLonghair(String longhair) {
        this.longhair = longhair;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

}
