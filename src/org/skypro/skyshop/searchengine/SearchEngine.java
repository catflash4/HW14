package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import org.skypro.skyshop.searchable.Searchable;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class SearchEngine {
    private final List<Searchable> searchableArray;

    public SearchEngine() {
        this.searchableArray = new ArrayList<>();
    }

    public TreeMap<String, Searchable> search(String substring) throws BestResultNotFoundException {
        TreeMap<String, Searchable> searchArray = new TreeMap<>();
        for (Searchable s : searchableArray) {
            if (s != null && s.searchTerm().contains(substring)) {
                searchArray.put(s.searchTerm(),s);
            }
        }
        if (searchArray.isEmpty()) {
            throw new BestResultNotFoundException(("Для поискового запроса: <" + substring + ">, не нашлось подходящего результата"));
        }
        return searchArray;
    }

    public void add(Searchable object) {
        searchableArray.add(object);
    }
}
