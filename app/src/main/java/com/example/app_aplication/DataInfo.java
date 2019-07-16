package com.example.app_aplication;

public class DataInfo {
    private Integer image_inicio;
    private String name;
    private String description;
    private int quanty;


    public Integer getImg() {
        return image_inicio;
    }

    public void setImg(Integer img) {
        this.image_inicio = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuanty() {
        return quanty;
    }

    public void setQuanty(int quanty) {
        this.quanty = quanty;
    }
}
