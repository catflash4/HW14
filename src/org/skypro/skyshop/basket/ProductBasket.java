package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductBasket {
    List<Product> basket = new ArrayList<>();

    public void addProduct(Product product) {
            basket.add(product);
    }

    public int getTotalPrice() {
        int fullPrice = 0;
        for (Product p : basket) {
            fullPrice += p.getPrice();
        }
        return fullPrice;
    }

    private boolean isEmpty() {
        for (Product p : basket) {
            if (p != null) {
                return false;
            }
        }
        return true;
    }

    public void printBasket() {
        boolean checkEmpty = true;
        for (Product p : basket) {
            if (p != null) {
                checkEmpty = false;
                break;
            }
        }
        if (!checkEmpty) {
            int specialCount = 0;
            for (Product p : basket) {
                if (p != null && p.isSpecial()) {
                    specialCount++;
                }
            }
            System.out.println(basket + "\nИтого: " + getTotalPrice() + " руб." + "\nСпециальных товаров: " + specialCount);
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean checkProductByName(String name) {
        for (Product p : basket) {
            if (p.getName().equals(name)) {
                    return true;
                }
            }
        return false;
    }

    public void clear() {
        basket.clear();
    }

    public List<String> removeByName(String name) {
        List<Product> removing = new ArrayList<>();
        for (Product p : basket) {
            if (p.getName().contains(name)) {
                removing.add(p);
            }
        }
        List<String> returning = new ArrayList<>();
        for (Product p : removing) {
            returning.add(p.getName());
            basket.remove(p);
        }
        if (returning.isEmpty()) {
            returning.add("Список пуст");
        }
        return returning;
    }
}
