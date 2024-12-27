package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SemanticVersionComparatorTest
{
    @Test
    public void testCompareVersions() {
        // Test for equal versions
        assertEquals(SemanticVersionComparator.compareVersions("1.0.0", "1.0.0"), 0);

        // Test for version1 < version2
        assertEquals(SemanticVersionComparator.compareVersions("1.0.0", "2.0.0"), -1);

        // Test for version1 > version2
        assertEquals(SemanticVersionComparator.compareVersions("2.0.0", "1.0.0"), 1);

        // Test for null or empty input (throws IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> SemanticVersionComparator.compareVersions("", "1.0.0"));
        assertThrows(IllegalArgumentException.class, () -> SemanticVersionComparator.compareVersions("1.0.0", ""));
        assertThrows(IllegalArgumentException.class, () -> SemanticVersionComparator.compareVersions(null, "1.0.0"));
        assertThrows(IllegalArgumentException.class, () -> SemanticVersionComparator.compareVersions("1.0.0", null));
    }
}
