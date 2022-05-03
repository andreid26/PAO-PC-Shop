import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class ShopService {
    private Set<User> users;
    private List<Product> products;
    private List<Order> orders;

    public ShopService() {
        this.users = new HashSet<User>();
        this.products = new ArrayList<Product>();
        this.orders = new ArrayList<Order>();
    }

    public ShopService(Set<User> users, List<Product> products, List<Order> orders) {
        this.users = users;
        this.products = products;
        this.orders = orders;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        Collections.sort(this.products, new CustomComparatorAscending());
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "users=" + users +
                ", products=" + products +
                ", orders=" + orders +
                '}';
    }

    // HELP FUNCTIONS

    private boolean emailAlreadyExists(String email) {
        for(User user: this.users) {
            if (user.getEmail().toLowerCase().equals(email.toLowerCase())) return true;
        }
        return false;
    }

    private boolean areStringsSimilar(String first, String second) {
        return first.toLowerCase().contains(second.toLowerCase());
    }

    private boolean areStringsEqual(String first, String second) {
        return first.equals(second);
    }

    private List<Product> orderProductsAscending() {
        List<Product> orderedProducts = new ArrayList<Product>(this.products);
        Collections.sort(orderedProducts, new CustomComparatorAscending());
        return orderedProducts;
    }

    private List<Product> orderProductsDescending() {
        List<Product> orderedProducts = new ArrayList<Product>(this.products);
        Collections.sort(orderedProducts, new CustomComparatorDescending());
        return orderedProducts;
    }

    private float getTotalFromOrder(Order order) {
        float total = 0;
        for(Product product: order.getShoppingCart().getProducts()) {
            total = total + product.getPrice();
        }
        return total;
    }

    // ADD

    public void addUser(User user) {
        if (this.emailAlreadyExists(user.getEmail())) {
            System.out.println("This email already exists.");
        } else {
            this.users.add(user);
        }
    }

    public void createNewUser() {
        User newUser = new User();
        newUser.read();

        if (this.emailAlreadyExists(newUser.getEmail())) {
            System.out.println("This email already exists.");
        } else {
            this.users.add(newUser);
        }
    }

    public void addUsers(User... users) {
        for(User user: users) {
            if (this.emailAlreadyExists(user.getEmail())) {
                System.out.println("User with email " + user.getEmail() + " already exists.");
            } else {
                this.users.add(user);
            }
        }
    }

    public void addProduct(Product product) {
        this.products.add(product);
        Collections.sort(this.products, new CustomComparatorAscending());
    }

    public void addProducts(Product... products) {
        for(Product product: products) {
            this.products.add(product);
        }
        Collections.sort(this.products, new CustomComparatorAscending());
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void addOrders(Order... orders) {
        for(Order order: orders) {
            this.orders.add(order);
        }
    }

    // SEARCH

    public User searchUserByEmail(String email) {
        for(User user: this.users) {
            if (user.getEmail().toLowerCase().equals(email.toLowerCase())) return user;
        }
        return null;
    }

    public List<Product> searchProductsByName(String name) {
        List<Product> productsFound = new ArrayList<Product>();

        for(Product product: this.products) {
            String productName = product.getName();

            if (this.areStringsSimilar(productName, name)) {
                productsFound.add(product);
            }
        }
        return productsFound;
    }

    public List<Order> searchOrdersByEmail(String email) {
        List<Order> ordersFound = new ArrayList<Order>();

        if (this.emailAlreadyExists(email)) {
            for(Order order: this.orders) {
                if (this.areStringsEqual(order.getUser().getEmail().toLowerCase(), email.toLowerCase())) {
                    ordersFound.add(order);
                }
            }
        }
        return ordersFound;
    }

    // GET

    public List<Product> getOrderedProducts(boolean ascending) {
        if(ascending) return this.orderProductsAscending();
        return this.orderProductsDescending();
    }

    public float getTotalFromOrder(String email) {
        if(this.emailAlreadyExists(email)) {
            for(Order order: this.orders) {
                if (this.areStringsEqual(order.getUser().getEmail().toLowerCase(), email.toLowerCase())) {
                    return this.getTotalFromOrder(order);
                }
            }
        }
        return 0;
    }
}
