package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Sorter
{
    public static Map<String, List<String>> SortByName(Map<String, List<String>> phonebook)
    {
        return new TreeMap<>(phonebook);
    }

    public static LinkedHashMap<String, List<String>> SortByPhoneCount(Map<String, List<String>> phonebook)
    {
        int size = phonebook.size();
        HashMap<String, Integer> tempMap = new HashMap<>(size);

        for (var record: phonebook.entrySet())
        {
            tempMap.put(record.getKey(), record.getValue().size());
        }

        LinkedHashMap<String, Integer> sortedMap1 =
                tempMap.entrySet()
                        .stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                        .collect(Collectors
                                .toMap(Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (e1, e2) -> e1,
                                        LinkedHashMap::new));

        LinkedHashMap<String, List<String>> sortedMap = new LinkedHashMap<>();

        for (var item: sortedMap1.entrySet())
        {
            sortedMap.put(item.getKey(), phonebook.get(item.getKey()));
        }
        return sortedMap;
    }
}
