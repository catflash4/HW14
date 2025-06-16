package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductBasket {
    Map<String, List<Product>> basket = new HashMap<>();

    public void addProduct(String name, Product product) {
        basket.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }

    public int getTotalPrice() {
        int fullPrice = 0;
        for (Map.Entry<String, List<Product>> e : basket.entrySet()) {
            for (Product p : e.getValue()) {
                fullPrice += p.getPrice();
            }
        }
        return fullPrice;
    }

    public void printBasket() {
        if (!basket.isEmpty()) {
            int specialCount = 0;
            for (Map.Entry<String, List<Product>> e : basket.entrySet()) {
                for (Product p : e.getValue()) {
                    if (p != null && p.isSpecial()) {
                        specialCount++;
                    }
                }
            }
            System.out.println(basket + "\nИтого: " + getTotalPrice() + " руб." + "\nСпециальных товаров: " + specialCount);
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean checkProductByName(String name) {
        return basket.containsKey(name);
    }

    public void clear() {
        basket.clear();
    }

    public List<String> removeByName(String name) {
        List<String> returning = new ArrayList<>();
        List<String> removingNames = new ArrayList<>();
        for (Map.Entry<String, List<Product>> e : basket.entrySet()) {
            if (e.getKey().contains(name)) {
                removingNames.add(e.getKey());
                for (Product p : e.getValue()) {
                    returning.add(e.getKey() + " " + p.getName());
                }
            }
        }
        for (String p : removingNames) {
            basket.remove(p);
        }
        if (returning.isEmpty()) {
            returning.add("Список пуст");
        }
        return returning;
    }
}

