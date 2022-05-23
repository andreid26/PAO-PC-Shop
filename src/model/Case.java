package model;

import java.util.Arrays;
import java.util.List;

public class Case extends Product {
    private int coolersNumber;
    private boolean rgb;
    private String color;
    private int id;

    public Case() {
        this.coolersNumber = 0;
        this.rgb = false;
        this.color = "";
    }

    public Case(String name, String description, String brand, float price, int coolersNumber, boolean rgb, String color, int id) {
        super(name, description, brand, price);
        this.coolersNumber = coolersNumber;
        this.rgb = rgb;
        this.color = color;
        this.id = id;
    }

    public int getCoolersNumber() {
        return coolersNumber;
    }

    public void setCoolersNumber(int coolersNumber) {
        this.coolersNumber = coolersNumber;
    }

    public boolean isRgb() {
        return rgb;
    }

    public void setRgb(boolean rgb) {
        this.rgb = rgb;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  super.toString() + "model.Case{" +
                "coolersNumber=" + coolersNumber +
                ", rgb=" + rgb +
                ", color='" + color + '\'' +
                '}';
    }

    public String getPropertiesString() {
        List<String> props = Arrays.asList(this.name, this.description, this.brand, String.valueOf(this.price), String.valueOf(this.coolersNumber), String.valueOf(this.rgb), this.color, String.valueOf(this.id));
        return String.join(",", props);
    }
}
