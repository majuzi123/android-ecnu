package com.example.campuscomment;

public class food {
    String name;
    String cateen;
    Double num;
    public food(){
        setName("");
        setCateen("");
        setNum(0.0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCateen() {
        return cateen;
    }

    public void setCateen(String cateen) {
        this.cateen = cateen;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }
}