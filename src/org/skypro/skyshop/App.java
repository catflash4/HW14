package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;



public class App {
    public static void main(String[] args) {
        Product milk = new SimpleProduct("Молоко Parlamat", 100);
        Product sausage = new DiscountedProduct("Сосиски Останкино", 220, 20);
        Product cheese = new FixPriceProduct("Сыр Liebendorf");
        Product chips = new SimpleProduct("Чипсы Lays", 175);
        Product chocolate = new DiscountedProduct("Шоколад Алёнка", 80, 5);

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
