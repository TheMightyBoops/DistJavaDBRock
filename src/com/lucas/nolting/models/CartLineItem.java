package com.lucas.nolting.models;

import java.io.Serializable;

public class CartLineItem implements Serializable {
    private String Name;
    private double price;
    private int id,
                quantity;

    public CartLineItem(){

    }

    public CartLineItem(String name, double price,
                        int id, int quantity) {
        setName(name);
        setPrice(price);
        setId(id);
        setQuantity(quantity);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
