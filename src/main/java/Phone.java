public class Phone extends Catalog implements SMSer {

    String name;
    int price;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getName() + '\'' +
                ", цена " + getPrice();
    }

    @Override
    public void sendSMS(String msg, String number) {

    }
}
