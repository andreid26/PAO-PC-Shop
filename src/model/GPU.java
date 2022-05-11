package model;

import java.util.Arrays;
import java.util.List;

public class GPU extends Product {
    private int memory;
    private int portsNumber;

    public GPU() {
        this.memory = 0;
        this.portsNumber = 0;
    }

    public GPU(String name, String description, String brand, float price, int memory, int portsNumber) {
        super(name, description, brand, price);
        this.memory = memory;
        this.portsNumber = portsNumber;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getPortsNumber() {
        return portsNumber;
    }

    public void setPortsNumber(int portsNumber) {
        this.portsNumber = portsNumber;
    }

    @Override
    public String toString() {
        return  super.toString() + "model.GPU{" +
                "memory=" + memory +
                ", portsNumber=" + portsNumber +
                '}';
    }

    public String getPropertiesString() {
        List<String> props = Arrays.asList(this.name, this.description, this.brand, String.valueOf(this.price), String.valueOf(this.memory), String.valueOf(this.portsNumber));
        return String.join(",", props);
    }
}
