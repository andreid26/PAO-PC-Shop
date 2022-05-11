package utils;

import model.Product;

import java.util.Comparator;

public class AscendingPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product first, Product second) {
        float firstPrice = first.getPrice();
        float secondPrice = second.getPrice();

        if (firstPrice < secondPrice) {
            return -1;
        }
        return 1;
    }
}