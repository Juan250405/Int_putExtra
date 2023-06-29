package com.dh.mascotas.persistence.entities;


import javax.persistence.*;

@Entity
public class ProductoEstilo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer stock;
    @Column
    private String producto;
    @Column
    private int precio;
    @Column
    private String talle;
    @Column
    private String color;

    public ProductoEstilo(Integer stock, String producto, int precio, String talle, String color) {
        this.stock = stock;
        this.producto = producto;
        this.precio = precio;
        this.talle = talle;
        this.color = color;
    }

    public ProductoEstilo() {
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
