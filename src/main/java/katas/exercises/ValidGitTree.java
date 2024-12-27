package katas.exercises;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class ValidGitTree {

    /**
     * Determines if a given tree structure represents a valid Git tree.
     *
     * A valid Git tree should:
     * 1. Have exactly one root (no parent).
     * 2. Contain no cycles.
     *
     * @param treeMap a map representing the Git tree (commit ID to list of child commit IDs)
     * @return true if the tree is a valid Git tree, false otherwise
     */
    public static boolean isValidGitTree(Map<String, List<String>> treeMap) {
        Set<String> allNodes = new HashSet<>();
        Set<String> childNodes = new HashSet<>();

        // Gather all nodes and their child nodes
        for (String node : treeMap.keySet()) {
            allNodes.add(node);
            childNodes.addAll(treeMap.get(node));
        }

        // The root is the only node that isn't a child of any other node
        allNodes.removeAll(childNodes);

        // There should be exactly one root node
        if (allNodes.size() != 1) {
            return false; // No root or more than one root
        }

        // Track visited nodes to check for cycles
        Set<String> visitedNodes = new HashSet<>();
        Set<String> nodesInCurrentPath = new HashSet<>();
        String rootNode = allNodes.iterator().next();

        // Check if there's a cycle in the tree starting from the root
        return !detectCycle(rootNode, treeMap, visitedNodes, nodesInCurrentPath);
    }

    private static boolean detectCycle(String currentNode, Map<String, List<String>> treeMap, Set<String> visitedNodes, Set<String> nodesInCurrentPath) {
        // If we're revisiting a node that's already in the current path, there's a cycle
        if (nodesInCurrentPath.contains(currentNode)) {
            return true; // Cycle found
        }

        // If we've already checked this node, no need to check again
        if (visitedNodes.contains(currentNode)) {
            return false; // No cycle from this node
        }

        // Mark the current node as visited and part of the current path
        visitedNodes.add(currentNode);
        nodesInCurrentPath.add(currentNode);

        // Check all the child nodes of the current node
        for (String child : treeMap.getOrDefault(currentNode, List.of())) {
            if (detectCycle(child, treeMap, visitedNodes, nodesInCurrentPath)) {
                return true; // Cycle found in a child node
            }
        }

        // Remove the current node from the path before going back
        nodesInCurrentPath.remove(currentNode);
        return false; // No cycle found
    }

    public static void main(String[] args) {
        Map<String, List<String>> validTree = new HashMap<>();
        validTree.put("A", List.of("B", "C"));
        validTree.put("B", List.of("D"));
        validTree.put("C", List.of());
        validTree.put("D", List.of());

        Map<String, List<String>> invalidTree = new HashMap<>();
        invalidTree.put("A", List.of("B"));
        invalidTree.put("B", List.of("C"));
        invalidTree.put("C", List.of("A")); // cycle

        System.out.println("Is valid tree: " + isValidGitTree(validTree));
        System.out.println("Is valid tree: " + isValidGitTree(invalidTree));
    }
}
