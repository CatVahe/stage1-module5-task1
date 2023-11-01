package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> strings.stream().allMatch(word -> Character.isUpperCase(word.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return numbers -> {
            List<Integer> tmpList = new ArrayList<>();
            for (Integer number : numbers) {
                if(number % 2 == 0){
                    tmpList.add(number);
                }
            }
            numbers.addAll(tmpList);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        List<String> list = new ArrayList<>();
        return () -> {

                for (String value :
                        values) {

                    String[] wordsSplit = value.split(" ");

                    if (Character.isUpperCase(value.charAt(0))&&value.endsWith(".")&&wordsSplit.length>3) {
                        list.add(value);
                    }

                }
                return list;

        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> x.stream().collect(Collectors.toMap(String::toString, String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, y) -> {
            List<Integer> result = new ArrayList<>(x);
            result.addAll(y);
            return result;
        };
    }
}
