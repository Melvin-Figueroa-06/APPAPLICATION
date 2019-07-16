package com.example.app_aplication;

class ItemList {
    private String image;
    private String name;
    private String categoria;
    private String description;
    private String precio;
    private String stock;
    private String estado;

    public ItemList(String categoria, String image, String name, String descripcion, String precio, String stock, String estado){
        this.image = this.image;
        this.name = this.name;
        this.categoria = this.categoria;
        this.description = description;
        this.precio = this.precio;
        this.stock = this.stock;
        this.estado = this.estado;
    }
    public String getImage(){
        return this.image;
    }
    public String getName(){
        return this.name;
    }
    public String getCategoria(){
        return this.categoria;
    }
    public String getDescription(){
        return this.description;
    }
    public String getPrecio(){
        return this.precio;
    }
    public String getStock(){
        return this.stock;
    }
    public String getEstado(){
        return this.estado;
    }

}
