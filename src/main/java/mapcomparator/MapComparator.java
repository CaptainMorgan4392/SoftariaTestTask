package mapcomparator;

import java.util.Map;

public interface MapComparator<K, V> {

    /**
     * Check for entries from left map except entries with same keys from right map.
     * @param left left operand map.
     * @param right right operand map.
     * @return map with entries from left map except entries with same keys from right map.
     */
    Map<K, V> leftDiff(Map<K, V> left, Map<K, V> right);

    /**
     * Check for entries from right map except entries with same keys from left map.
     * @param left left operand map.
     * @param right right operand map.
     * @return map with entries from right map except entries with same keys from left map.
     */
    Map<K, V> rightDiff(Map<K, V> left, Map<K, V> right);

    /**
     * Check for entries from both maps with different values in key-value pairs.
     * @param left left operand map.
     * @param right right operand map.
     * @return entries with different values in maps. Stores value from right map.
     */
    Map<K, V> valueDiff(Map<K, V> left, Map<K, V> right);

}
