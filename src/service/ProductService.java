package service;

import model.*;
import utils.AscendingPriceComparator;
import utils.DescendingPriceComparator;
import utils.FileService;
import utils.Helper;

import java.util.*;

public class ProductService {
    private List<Product> products;
    private Helper helper;
    private FileService fileService;

    public ProductService() {
        this.products = new ArrayList<Product>();
        this.helper = new Helper();
        this.fileService = FileService.getFileService();
    }

    public ProductService(List<Product> products) {
        this.products = products;
        this.helper = new Helper();
        this.fileService = FileService.getFileService();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        Collections.sort(this.products, new AscendingPriceComparator());
    }

    @Override
    public String toString() {
        return "ProductService{" +
                "products=" + products +
                '}';
    }

    // ADD PRODUCTS FROM CSV

    public void initializeProducts() {
        this.fileService.logEvent("Initialized products list");
        List<String> files = Arrays.asList("gpu", "case", "ram");
        List<String> lines;

        for(String fileName: files) {
            lines = this.fileService.readFromCsv(fileName + ".csv");
            this.addProductsFromCsv(lines, fileName);
        }
    }

    private void addProductsFromCsv(List<String> productsArray, String type) {
        for(String productsString: productsArray) {
            String[] properties = productsString.split(",");

            switch (type.toLowerCase()) {
                case "gpu":
                    GPU gpu = new GPU(properties[0], properties[1], properties[2], Float.parseFloat(properties[3]), Integer.parseInt(properties[4]), Integer.parseInt(properties[5]));
                    this.products.add(gpu);
                    break;
                case "case":
                    Case _case = new Case(properties[0], properties[1], properties[2], Float.parseFloat(properties[3]), Integer.parseInt(properties[4]), Boolean.parseBoolean(properties[5]), properties[6]);
                    this.products.add(_case);
                    break;
                case "ram":
                    RAM ram = new RAM(properties[0], properties[1], properties[2], Float.parseFloat(properties[3]), properties[4], Integer.parseInt(properties[5]));
                    this.products.add(ram);
                    break;
            }
        }
    }

    private void writeProductToCsv(Product product) {
        String props = "";
        String fileName = "";

        if (product instanceof Case) {
            fileName = "case.csv";
            props = ((Case) product).getPropertiesString();
        } else if (product instanceof GPU) {
            fileName = "gpu.csv";
            props = ((GPU) product).getPropertiesString();
        } else if (product instanceof RAM) {
            fileName = "ram.csv";
            props =  ((RAM) product).getPropertiesString();
        }

        if (props.length() > 0) {
            this.fileService.writeToFile(fileName, props);
        }
    }

    // HELP

    private List<Product> orderProductsAscending() {
        this.fileService.logEvent("Ordered products ascending");
        List<Product> orderedProducts = new ArrayList<Product>(this.products);
        orderedProducts.sort(new AscendingPriceComparator());
        return orderedProducts;
    }

    private List<Product> orderProductsDescending() {
        this.fileService.logEvent("Ordered products descending");
        List<Product> orderedProducts = new ArrayList<Product>(this.products);
        orderedProducts.sort(new DescendingPriceComparator());
        return orderedProducts;
    }

    // ADD

    public void addProduct(Product product) {
        this.fileService.logEvent("Added a new product");
        this.products.add(product);
        this.products.sort(new AscendingPriceComparator());
        this.writeProductToCsv(product);
    }

    public void addProducts(Product... products) {
        for(Product product: products) {
            this.addProduct(product);
        }
        this.products.sort(new AscendingPriceComparator());
    }

    // SEARCH

    public List<Product> searchProductsByName(String name) {
        this.fileService.logEvent("Searched products by name");
        List<Product> productsFound = new ArrayList<Product>();

        for(Product product: this.products) {
            String productName = product.getName();

            if (this.helper.areStringsSimilar(productName, name)) {
                productsFound.add(product);
            }
        }
        return productsFound;
    }

    // GET

    public List<Product> getOrderedProducts(boolean ascending) {
        this.fileService.logEvent("Got ordered products");
        if(ascending) return this.orderProductsAscending();
        return this.orderProductsDescending();
    }

}
