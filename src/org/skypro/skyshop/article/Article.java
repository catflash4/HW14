package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

public class Article implements Searchable, Comparable<Searchable> {
    private final String name;
    private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return name + '\n' + text;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String searchType() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return searchTerm() + " - " + searchType();
    }

    @Override
    public int compareTo(Searchable o) {
        return this.searchTerm().compareTo(o.searchTerm());
    }
}