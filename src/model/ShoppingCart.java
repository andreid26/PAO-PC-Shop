package model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<Product>();
    }

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "model.ShoppingCart{" +
                "products=" + products +
                '}';
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addProducts(Product... products) {
        for (Product product: products) {
            this.products.add(product);
        }
    }
}
