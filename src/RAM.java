public class RAM extends Product {
    private String latency;
    private int capacity;

    public RAM() {
        super();
        this.latency = "";
        this.capacity = 0;
    }

    public RAM(String name, String description, String brand, float price, String latency, int capacity) {
        super(name, description, brand, price);
        this.latency = latency;
        this.capacity = capacity;
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

    @Override
    public String toString() {
        return super.toString() + "RAM{" +
                "latency='" + latency + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
