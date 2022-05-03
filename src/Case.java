public class Case extends Product {
    private int coolersNumber;
    private boolean rgb;
    private String color;

    public Case() {
        super();
        this.coolersNumber = 0;
        this.rgb = false;
        this.color = "";
    }

    public Case(String name, String description, String brand, float price, int coolersNumber, boolean rgb, String color) {
        super(name, description, brand, price);
        this.coolersNumber = coolersNumber;
        this.rgb = rgb;
        this.color = color;
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

    @Override
    public String toString() {
        return  super.toString() + "Case{" +
                "coolersNumber=" + coolersNumber +
                ", rgb=" + rgb +
                ", color='" + color + '\'' +
                '}';
    }
}
