package com.eugenedatsenko.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pagination {

    public static List<Integer> getLinks(int allPublications) {
        List<Integer> range = IntStream.rangeClosed(0, (int) Math.ceil(allPublications / 3))
                .boxed().collect(Collectors.toList());
        return range;
    }
}
