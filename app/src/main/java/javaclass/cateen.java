package javaclass;

import androidx.annotation.NonNull;

public class cateen {
    public Integer id;
    public String name;
    public String address;
    public Double num;
    public String [] diet;
    public cateen(){
        setName("");
        setAddress("");
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public String[] getDiet() {
        return diet;
    }

    public void setDiet(String[] diet) {
        this.diet = diet;
    }
}