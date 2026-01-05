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

    // 2. МЕТОД ДЛЯ ПОИСКА
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

    // 3. МЕТОД ДЛЯ СОРТИРОВКИ
    public List<T> sort(Comparator<T> comparator) {
        return data.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    // 4. МЕТОД ДЛЯ ПАГИНАЦИИ
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

    // 5. ДОБАВЛЕНИЕ/УДАЛЕНИЕ ДАННЫХ
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

    // Геттер для получения всех данных
    public List<T> getAllData() {
        return new ArrayList<>(data);
    }
}
