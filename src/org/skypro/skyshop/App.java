package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchable.Searchable;
import org.skypro.skyshop.searchengine.SearchEngine;


public class App {
    public static void main(String[] args) {

        Product milk = new SimpleProduct(null, 0);
        System.out.println(milk);
        Product sausage = new DiscountedProduct("", 0, 101);
        System.out.println(sausage);
        Product cheese = new FixPriceProduct("СырСырСырСыр Liebendorf");
        System.out.println(cheese);
        Product chips = new SimpleProduct("Чипсы Lays", 175);
        System.out.println(chips);
        Product chocolate = new DiscountedProduct("Шоколад Алёнка", 80, 5);
        System.out.println(chocolate);
        Article sausageSecond = new Article("Колбаса <<Папа может>>", "Одна из тех колбааааааааааааас которая очень вкусная.");
        System.out.println(sausageSecond);
        Article sausageThird = new Article("Колбаса <<Сервелат>>", "Всегда её беру.");
        System.out.println(sausageThird);

        SearchEngine searchables = new SearchEngine(10);
        searchables.add(milk);
        searchables.add(sausage);
        searchables.add(cheese);
        searchables.add(chocolate);
        searchables.add(chips);
        searchables.add(sausageSecond);
        searchables.add(sausageThird);

        try {
            System.out.println(searchables.search("Колбасу"));
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        try {
            Searchable searchingTmp = searchables.search("о");
            System.out.println(searchingTmp);
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
