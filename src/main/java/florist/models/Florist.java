package florist.models;

import florist.ticket.Ticket;
import florist.models.*;

import java.util.ArrayList;
import java.util.List;

public class Florist {
    private String name;
    private List<Product> stock;
    private List<Ticket> tickets;
    private double totalStockValue;
    private double totalSales;

    public Florist(String name) {
        this.name = name;
        this.stock = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.totalStockValue = 0.0;
        this.totalSales = 0.0;
    }

    public void addProduct(Product p) {
        stock.add(p);
        totalStockValue += p.getPrice();
    }

    public void removeProduct(Product p) {
        if (stock.remove(p)) {
            totalStockValue -= p.getPrice();
        }
    }

    public void printStock() {
        StringBuilder trees = new StringBuilder();
        StringBuilder flowers = new StringBuilder();
        StringBuilder decorations = new StringBuilder();

        for (Product p : stock) {
            if(p instanceof Tree){
                trees.append(p.getName().append(", "));
            }else if(p instanceof Flower){
                flowers.append(p.getName().append(", "));
            }else if(p instanceof Decoration){
                decorations.append(p.getName().append(", "));
            }
        }

        trees.setLength(trees.length() -2);
        flowers.setLength(flowers.length() -2);
        decorations.setLength(decorations.length() -2);

        System.out.println("-----------STOCK--------------");
        System.out.println("TREES:");
        System.out.println(trees);
        System.out.println("FLOWERS:");
        System.out.println(flowers);
        System.out.println("DECORATION:");
        System.out.println(decorations);
    }

    public void printStockWithQuantities() {
        int treeCount=0, flowerCount=0, decorationCount=0; //must set to 0 to clean previous counts
        for(Product p : stock){
            if(p instanceof Tree){
                treeCount++;
            }else if(p instanceof Flower){
                flowerCount++;
            }else if(p instanceof Decoration){
                decorationCount++;
            }
        }
        System.out.println("------------STOCK XPRODUCT-----------");
        System.out.println("TREE ------------------> x"+treeCount);
        System.out.println("FLOWER ------------------> x"+flowerCount);
        System.out.println("DECORATION ------------------> x"+decorationCount);
    }

    public void printTotalValue() {
        System.out.println("Total Stock Value: " + totalStockValue);
    }

    public Ticket createTicket(List<Product> products) {
        Ticket ticket = new Ticket(products);
        tickets.add(ticket);
        for (Product p : products) {
            totalSales += p.getPrice();
        }
        return ticket;
    }

    public void showOldPurchases() {
        tickets.forEach(t -> System.out.println(t));
    }

    //GETTERS AND SETTERS
    public double calculateTotalSales() {
        return totalSales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getStock() {
        return stock;
    }

    public void setStock(List<Product> stock) {
        this.stock = stock;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public double getTotalStockValue() {
        return totalStockValue;
    }

    public void setTotalStockValue(double totalStockValue) {
        this.totalStockValue = totalStockValue;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
}
