package florist.models;

public abstract class Product {
    protected int lastID;
    protected int ID;
    protected String name;
    protected double price;

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product: \n\tID: " + ID +
                "\n\tname:" + name +
                "\n\tprice:" + price;
    }
}
