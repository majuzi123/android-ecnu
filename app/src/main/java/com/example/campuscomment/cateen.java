package com.example.campuscomment;

public class cateen {
    public Integer id;
    public String name;
    public Double num;
    public food [] foods;
    //构造函数
    public cateen(){
        setName("");
        setNum(0.0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public food[] getFoods() {
        return foods;
    }

    public void setFoods(food[] foods) {
        this.foods = foods;
    }
}
