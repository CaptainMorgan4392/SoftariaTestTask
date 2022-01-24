package mapcomparator;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MapComparatorImpl<K, V> implements MapComparator<K, V> {

    @Override
    public Map<K, V> leftDiff(Map<K, V> left, Map<K, V> right) {
        Predicate<Map.Entry<K, V>> filterPredicate = (kvEntry -> !right.containsKey(kvEntry.getKey()));

        return left.entrySet()
            .stream()
            .filter(filterPredicate)
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue)
            );
    }

    @Override
    public Map<K, V> rightDiff(Map<K, V> left, Map<K, V> right) {
        Predicate<Map.Entry<K, V>> filterPredicate = (kvEntry -> !left.containsKey(kvEntry.getKey()));

        return right.entrySet()
            .stream()
            .filter(filterPredicate)
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue)
            );
    }

    @Override
    public Map<K, V> valueDiff(Map<K, V> left, Map<K, V> right) {
        Predicate<Map.Entry<K, V>> filterPredicate = (kvEntry ->
            left.containsKey(kvEntry.getKey()) &&
                left.get(kvEntry.getKey()) != right.get(kvEntry.getKey())
        );

        return right.entrySet()
            .stream()
            .filter(filterPredicate)
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue)
            );
    }

}
