package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchable.Searchable;
import org.skypro.skyshop.searchengine.SearchEngine;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {
        Product milk = new SimpleProduct("Молоко Parlamat", 100);
        Product sausage = new DiscountedProduct("Сосиски Останкино", 220, 20);
        Product cheese = new FixPriceProduct("Сыр Liebendorf");
        Product chips = new SimpleProduct("Чипсы Lays", 175);
        Product chocolate = new DiscountedProduct("Шоколад Алёнка", 80, 5);
        Article sausageSecond = new Article("Колбаса <<Папа может>>", "Одна из тех колбас которая очень вкусная.");
        Article sausageThird = new Article("Колбаса <<Сервелат>>", "Всегда её беру.");

        SearchEngine searchables = new SearchEngine(10);
        searchables.add(milk);
        searchables.add(sausage);
        searchables.add(cheese);
        searchables.add(chocolate);
        searchables.add(chips);
        searchables.add(sausageSecond);
        searchables.add(sausageThird);

        System.out.println(Arrays.toString(searchables.search("Колбаса")));

        System.out.println();
        Searchable[] searchingTmp;
        searchingTmp = searchables.search("о");
        for (Searchable s : searchingTmp) {
            if (s != null) {
                System.out.println(s.getStringRepresentation() + '\n');
            }
        }
    }
}
