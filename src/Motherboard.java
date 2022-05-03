public class Motherboard extends Product {
    private int sataPorts;
    private int ramSlots;
    private String socket;

    public Motherboard() {
        super();
        this.sataPorts = 0;
        this.ramSlots = 0;
        this.socket = "";
    }

    public Motherboard(String name, String description, String brand, float price, int sataPorts, int ramSlots, String socket) {
        super(name, description, brand, price);
        this.sataPorts = sataPorts;
        this.ramSlots = ramSlots;
        this.socket = socket;
    }

    public int getSataPorts() {
        return sataPorts;
    }

    public void setSataPorts(int sataPorts) {
        this.sataPorts = sataPorts;
    }

    public int getRamSlots() {
        return ramSlots;
    }

    public void setRamSlots(int ramSlots) {
        this.ramSlots = ramSlots;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    @Override
    public String toString() {
        return  super.toString() + "Motherboard{" +
                "sataPorts=" + sataPorts +
                ", ramSlots=" + ramSlots +
                ", socket='" + socket + '\'' +
                '}';
    }
}
