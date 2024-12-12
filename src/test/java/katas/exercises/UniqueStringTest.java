package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniqueStringTest
{
    @Test
    public void testUniqueString()
    {
        assertTrue(UniqueString.isUnique("code"));
        assertFalse(UniqueString.isUnique("loop"));
        assertFalse(UniqueString.isUnique("loOp"));
        assertTrue(UniqueString.isUnique(""));
        assertTrue(UniqueString.isUnique(null));
    }
}
