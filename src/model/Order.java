package model;

public class Order {
    private User user;
    private ShoppingCart shoppingCart;

    public Order() {
        this.user = null;
        this.shoppingCart = null;
    }

    public Order(User user, ShoppingCart shoppingCart) {
        this.user = user;
        this.shoppingCart =  shoppingCart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addProductToShoppingCart(Product product) {
        this.shoppingCart.addProduct(product);
    }

    @Override
    public String toString() {
        return "model.Order{" +
                "user=" + user +
                ", shoppingCart=" + shoppingCart +
                '}';
    }

    public void addProductsToShoppingCart(Product... products) {
        for (Product product: products) {
            this.shoppingCart.addProducts(product);
        }
    }
}
