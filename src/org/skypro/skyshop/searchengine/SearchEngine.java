package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import org.skypro.skyshop.searchable.Searchable;

import java.util.Arrays;

public class SearchEngine {
    private static int count = 0;
    private final Searchable[] searchableArray;

    public SearchEngine(int count) {
        this.searchableArray = new Searchable[count];
    }

    public Searchable search(String substring) throws BestResultNotFoundException {
        Searchable[] searchArray = new Searchable[5];
        for (int i = 0, tmp = 0; i < 5 && tmp < searchableArray.length; tmp++) {
            if (searchableArray[tmp] != null && searchableArray[tmp].searchTerm().contains(substring)) {
                searchArray[i++] = searchableArray[tmp];
            }
        }
        System.out.println(Arrays.toString(searchArray));
        int[] tmpArray = new int[5];
        int it = 0;
        for (Searchable s : searchArray) {
            if (s == null) {
                break;
            }
            String str = s.searchTerm();
            int count = 0;
            int index = 0;
            int indexSubstring = str.indexOf(substring, index);

            while (indexSubstring != -1) {
                count++;
                index = indexSubstring + substring.length();
                indexSubstring = str.indexOf(substring, index);
            }
            tmpArray[it++] = count;
        }
        System.out.println(Arrays.toString(tmpArray));
        int count = 0;
        int tmp = 0;
        for (int i = 0; i < tmpArray.length; i++) {
            if (tmpArray[i] > tmp) {
                tmp = tmpArray[i];
                count = i;
            }
        }
        if (searchArray[count] == null) {
            throw new BestResultNotFoundException(("Для поискового запроса: <" + substring + ">, не нашлось подходящего результата"));
        }
        return searchArray[count];
    }

    public void add(Searchable object) {
        searchableArray[count++] = object;
    }
}
