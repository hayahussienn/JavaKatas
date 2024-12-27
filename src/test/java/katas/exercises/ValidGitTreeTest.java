package katas.exercises;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ValidGitTreeTest {
    @Test
    public void testInvalidGitTreeWithCycle() {
        Map<String, List<String>> invalidTree = new HashMap<>();
        invalidTree.put("A", List.of("B"));
        invalidTree.put("B", List.of("C"));
        invalidTree.put("C", List.of("A")); // cycle

        //The tree should be invalid due to a cycle
        assertFalse(ValidGitTree.isValidGitTree(invalidTree));
    }

    @Test
    public void testInvalidGitTreeMultipleRoots() {
        Map<String, List<String>> multipleRootsTree = new HashMap<>();
        multipleRootsTree.put("A", List.of("B"));
        multipleRootsTree.put("C", List.of("D"));
        multipleRootsTree.put("B", List.of());
        multipleRootsTree.put("D", List.of());

        //The tree should be invalid due to multiple roots
        assertFalse(ValidGitTree.isValidGitTree(multipleRootsTree));
    }

    @Test
    public void testValidGitTree() {
        Map<String, List<String>> validTree = new HashMap<>();
        validTree.put("A", List.of("B", "C"));
        validTree.put("B", List.of("D"));
        validTree.put("C", List.of());
        validTree.put("D", List.of());

        //The tree should be valid
        assertTrue (ValidGitTree.isValidGitTree(validTree));
    }

    @Test
    public void testInvalidGitTreeNoRoot() {
        Map<String, List<String>> noRootTree = new HashMap<>();
        noRootTree.put("A", List.of("B"));
        noRootTree.put("B", List.of("A")); // no root, cycle between A and B

        //The tree should be invalid due to missing a root
        assertFalse(ValidGitTree.isValidGitTree(noRootTree));
    }


}
