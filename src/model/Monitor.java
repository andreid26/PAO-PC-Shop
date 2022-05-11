package model;

public class Monitor extends Product {
    private int height;
    private int width;
    private int refreshRate;

    public Monitor() {
        this.height = 0;
        this.width = 0;
        this.refreshRate = 0;
    }

    public Monitor(String name, String description, String brand, float price, int height, int width, int refreshRate) {
        super(name, description, brand, price);
        this.height = height;
        this.width = width;
        this.refreshRate = refreshRate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    @Override
    public String toString() {
        return super.toString() + "model.Monitor{" +
                "height=" + height +
                ", width=" + width +
                ", refreshRate=" + refreshRate +
                '}';
    }
}
