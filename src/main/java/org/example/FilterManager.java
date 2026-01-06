package org.example;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FilterManager<T> {
    private List<T> data;

    public FilterManager(List<T> data) {
        this.data = new ArrayList<>(data);
    }

    public List<T> filter(Predicate<T> condition) {
        return data.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    public List<T> search(String keyword, Function<T, String> fieldGetter) {
        return data.stream()
                .filter(item -> {
                    String fieldValue = fieldGetter.apply(item);
                    if (fieldValue == null) return false;
                    return fieldValue.toLowerCase()
                            .contains(keyword.toLowerCase());
                })
                .collect(Collectors.toList());
    }

    public List<T> sort(Comparator<T> comparator) {
        return data.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<T> getPage(int pageNumber, int pageSize) {
        if (data == null || data.isEmpty()) {
            return Collections.emptyList();
        }

        int fromIndex = (pageNumber - 1) * pageSize;
        if (fromIndex >= data.size()) {
            return Collections.emptyList();
        }

        int toIndex = Math.min(fromIndex + pageSize, data.size());
        return data.subList(fromIndex, toIndex);
    }

    public void addItem(T item) {
        if (data == null) {
            data = new ArrayList<>();
        }
        data.add(item);
    }

    public void removeItem(Predicate<T> condition) {
        if (data != null) {
            data.removeIf(condition);
        }
    }

    public List<T> getAllData() {
        return new ArrayList<>(data);
    }
}
