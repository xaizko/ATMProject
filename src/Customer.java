public class Customer {
    String name;
    int pin;

    public Customer(String name, int pin) {
        this.name = name;
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
