package florist.ticket;

import florist.models.Product;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
   private List<Product> products;
   private double total;

   public Ticket(List<Product> products){
       this.products= products;
       this.total = calculateTotal();
   }

   private double calculateTotal(){
       return products.stream().mapToDouble(Product::getPrice).sum();
   }

    public void addProduct(Product p) {//necessitem aquest metode en algun lloc?? per crear el ticket necessitem la llista completa de products
        products.add(p);
        total += p.getPrice();
    }

    @Override
    public String toString() {//not sure if products will print correctly
        return "Ticket - Products: " + products + ", Total: " + total;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
