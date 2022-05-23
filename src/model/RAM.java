package model;

import java.util.Arrays;
import java.util.List;

public class RAM extends Product {
    private String latency;
    private int capacity;
    private int id;

    public RAM() {
        this.latency = "";
        this.capacity = 0;
    }

    public RAM(String name, String description, String brand, float price, String latency, int capacity, int id) {
        super(name, description, brand, price);
        this.latency = latency;
        this.capacity = capacity;
        this.id = id;
    }

    public String getLatency() {
        return latency;
    }

    public void setLatency(String latency) {
        this.latency = latency;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString() + "model.RAM{" +
                "latency='" + latency + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public String getPropertiesString() {
        List<String> props = Arrays.asList(this.name, this.description, this.brand, String.valueOf(this.price), this.latency, String.valueOf(this.capacity), String.valueOf(this.id));
        return String.join(",", props);
    }
}
