public class CPU extends Product {
    private String technology;
    private int coresNumber;
    private int threadsNumber;

    public CPU() {
        super();
        this.technology = "";
        this.coresNumber = 0;
        this.threadsNumber = 0;
    }

    public CPU(String name, String description, String brand, float price, String technology, int coresNumber, int threadsNumber) {
        super(name, description, brand, price);
        this.technology = technology;
        this.coresNumber = coresNumber;
        this.threadsNumber = threadsNumber;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public int getCoresNumber() {
        return coresNumber;
    }

    public void setCoresNumber(int coresNumber) {
        this.coresNumber = coresNumber;
    }

    public int getThreadsNumber() {
        return threadsNumber;
    }

    public void setThreadsNumber(int threadsNumber) {
        this.threadsNumber = threadsNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "CPU{" +
                "technology='" + technology + '\'' +
                ", coresNumber=" + coresNumber +
                ", threadsNumber=" + threadsNumber +
                '}';
    }
}
