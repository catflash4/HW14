package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.searchable.Searchable;

public class SearchEngine {
    private static int count = 0;
    private final Searchable[] searchables;

    public SearchEngine(int count) {
        this.searchables = new Searchable[count];
    }

    public Searchable[] search(String searchString) {
        Searchable[] searchArray = new Searchable[5];
        for (int i = 0, tmp = 0; i < 5 && tmp < searchables.length; tmp++) {
            if (searchables[tmp] != null && searchables[tmp].searchTerm().contains(searchString)) {
                searchArray[i++] = searchables[tmp];
            }
        }
        return searchArray;
    }

    public void add(Searchable object) {
        searchables[count++] = object;
    }
}
