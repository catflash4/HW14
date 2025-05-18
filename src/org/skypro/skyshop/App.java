package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product milk = new Product("Молоко Parlamat", 100);
        Product sausage = new Product("Сосиски Останкино", 220);
        Product cheese = new Product("Сыр Liebendorf", 220);
        Product chips = new Product("Чипсы Lays", 175);
        Product chocolate = new Product("Шоколад Алёнка", 80);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(milk);
        basket.addProduct(sausage);
        basket.addProduct(cheese);
        basket.addProduct(chips);
        basket.addProduct(chocolate);

        System.out.println(basket);

        System.out.println(basket.getTotalPrice() + " руб.");

        System.out.println(basket.checkProductByName("Чипсы Lays"));

        System.out.println(basket.checkProductByName("Шоколад Алёнка"));

        basket.clear();

        System.out.println(basket);

        System.out.println(basket.getTotalPrice() + " руб.");

        System.out.println(basket.checkProductByName("Шоколад Алёнка"));

        System.out.println(basket.checkProductByName("Чипсы Lays"));
    }
}
