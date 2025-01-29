package katas.exercises;

import org.junit.jupiter.api.Test;

import static katas.exercises.KthSmallestElementInBST.kthSmallest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthSmallestElementInBSTTest {

    @Test
    void testTreeWithNNumberOfNodes() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(5);
        root.left = new KthSmallestElementInBST.TreeNode(3);
        root.right = new KthSmallestElementInBST.TreeNode(7);
        root.left.left = new KthSmallestElementInBST.TreeNode(2);
        root.left.right = new KthSmallestElementInBST.TreeNode(4);
        root.right.left = new KthSmallestElementInBST.TreeNode(6);
        root.right.right = new KthSmallestElementInBST.TreeNode(8);
        int k = 5;

        assertEquals(6, kthSmallest(root, k));  // The 5th smallest element in this BST is 6
    }

    @Test
    void testTreeWithOneNode() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(5);
        int k = 1;
        assertEquals(5, kthSmallest(root, k));
    }

    @Test
    void testEmptyTree() {
        KthSmallestElementInBST.TreeNode root = null;
        int k = 1;

        assertEquals(-1, kthSmallest(root, k));
    }


}
