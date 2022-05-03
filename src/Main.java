import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShopService shopService = new ShopService();

        // Variables
        int numberOfUsers;

        // Creating n new users with read function
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of users to add: ");
        numberOfUsers = scanner.nextInt();

        for(int i=0; i<numberOfUsers; i++) {
            shopService.createNewUser();
        }

        // Creating a user with add function
        User user = new User("Andrei", "Dragulin", "andrei@gmail.com", "address for andrei", "phone number");
        shopService.addUser(user);

        // Creating some products + adding them to the shop
        GPU gpu = new GPU("GeForce GTX 1080", "Graphics Processing Unit", "Nvidia", 1000, 16, 2);
        Case _case = new Case("Case name", "Case description", "Case brand", 250, 4, true, "red");
        Monitor monitor = new Monitor("Monitor name", "Monitor description", "Monitor brand", 500, 150, 100, 144);
        Motherboard motherboard = new Motherboard("Motherboard name", "Motherboard description", "Motherboard brand", 800, 2, 2, "socket");
        RAM ram = new RAM("RAM name", "RAM description", "RAM brand", 40, "latency", 16);

        shopService.addProducts(gpu, _case, monitor, motherboard, ram);

        // Adding a shopping cart with all of the products
        List<Product> productsToOrder = shopService.getProducts();
        ShoppingCart shoppingCart = new ShoppingCart(productsToOrder);

        // Creating a new order + adding it to the shop
        Order order = new Order(user, shoppingCart);
        shopService.addOrder(order);

        // Searching a user by email - should return our user
        System.out.println("Searcing user by email - " + shopService.searchUserByEmail("andrei@gmail.com"));

        // Search products by name - should return our case
        System.out.println("Searcing products by name - " + shopService.searchProductsByName("cAsE"));

        //  Search order by email - should return our user
        System.out.println("Searcing order by email - " + shopService.searchOrdersByEmail("andrei@gmail.com"));

        // Get ordered products (descending)
        System.out.println("Get ordered products - " + shopService.getOrderedProducts(false));

        // Get total from our user's order
        System.out.println("Get total - " + shopService.getTotalFromOrder("andrei@gmail.com"));
    }
}
