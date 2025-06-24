package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchable.Searchable;
import org.skypro.skyshop.searchengine.SearchEngine;

import java.util.Set;


public class App {
    public static void main(String[] args) {

        Product milk = new SimpleProduct("Молоко Село Зеленое", 90);
        System.out.println(milk);
        Product sausage = new DiscountedProduct("Сосиски Останкино", 120, 60);
        System.out.println(sausage);
        Product cheese = new FixPriceProduct("Сыр Liebendorf");
        System.out.println(cheese);
        Product chips = new SimpleProduct("Чипсы Lays", 175);
        System.out.println(chips);
        Product chocolate = new DiscountedProduct("Шоколад Алёнка", 80, 5);
        System.out.println(chocolate);
        Article sausageSecond = new Article("Колбаса <<Папа может>>", "Одна из тех колбааааааааааааас которая очень вкусная.");
        System.out.println(sausageSecond);
        Article sausageThird = new Article("Колбаса <<Сервелат>>", "Всегда её беру.");
        System.out.println(sausageThird);

        ProductBasket basket = new ProductBasket();
        basket.addProduct("Молоко", milk);
        basket.addProduct("Сосиски", sausage);
        basket.addProduct("Сыр", cheese);
        basket.addProduct("Шоколад", chocolate);
        basket.addProduct("Чипсы", chips);

        System.out.println();
        System.out.println("Корзина");
        basket.printBasket();
        if (basket.checkProductByName("Колбаса")) {
            System.out.println("Есть такой продукт");
        } else {
            System.out.println("Нет такого");
        }
        System.out.println(basket.removeByName("Колбаса"));
        basket.printBasket();
        if (basket.checkProductByName("Абрикос")) {
            System.out.println("Есть такой продукт");
        } else {
            System.out.println("Нет такого");
        }
        System.out.println(basket.removeByName("Абрикос"));
        System.out.println();
        basket.clear();
        basket.printBasket();

        SearchEngine searchables = new SearchEngine();
        searchables.add(milk);
        searchables.add(sausage);
        searchables.add(cheese);
        searchables.add(chips);
        searchables.add(chocolate);
        searchables.add(sausageSecond);
        searchables.add(sausageThird);

        try {
            System.out.println(searchables.search("Колбаса"));
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        try {
            Set<Searchable> searchingTmp = searchables.search("а");
            System.out.println(searchingTmp);
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
