public class GPU extends Product {
    private int memory;
    private int portsNumber;

    public GPU() {
        super();
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
        return  super.toString() + "GPU{" +
                "memory=" + memory +
                ", portsNumber=" + portsNumber +
                '}';
    }
}
