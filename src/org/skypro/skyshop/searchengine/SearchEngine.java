package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import org.skypro.skyshop.searchable.Searchable;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchableArray;

    public SearchEngine() {
        this.searchableArray = new ArrayList<>();
    }

    public List<Searchable> search(String substring) throws BestResultNotFoundException {
        List<Searchable> searchArray = new ArrayList<>();
        for (Searchable s : searchableArray) {
            if (s != null && s.searchTerm().contains(substring)) {
                searchArray.add(s);
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
