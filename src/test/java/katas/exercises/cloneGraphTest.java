package katas.exercises;

import org.junit.jupiter.api.Test;

import static katas.exercises.GraphCloner.cloneGraph;
import static org.junit.jupiter.api.Assertions.*;

public class cloneGraphTest {

    @Test
    void testCloneEmptyGraph() {
       GraphCloner.Node node = null;
       assertEquals(null, cloneGraph(node));
    }

    @Test
    void testCloneGraphWithOneNode() {
        GraphCloner.Node node = new GraphCloner.Node(1);
        GraphCloner.Node cloned = cloneGraph(node);

        assertEquals(node.val, cloned.val);
        assertTrue(cloned.neighbors.isEmpty()); // Should have no neighbors
    }

    @Test
    void testCloneGraphWithTwoConnectedNodes() {
        GraphCloner.Node node1 = new GraphCloner.Node(1);
        GraphCloner.Node node2 = new GraphCloner.Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        GraphCloner.Node clonedNode1 = cloneGraph(node1);
        GraphCloner.Node clonedNode2 = clonedNode1.neighbors.get(0);

        assertEquals(1, clonedNode1.val);
        assertEquals(2, clonedNode2.val);
        assertNotSame(node1, clonedNode1);
        assertNotSame(node2, clonedNode2);
        assertEquals(1, clonedNode1.neighbors.size());
        assertEquals(1, clonedNode2.neighbors.size());
        assertSame(clonedNode1, clonedNode2.neighbors.get(0));
    }

    @Test
    void testCloneGraphWithCycle() {
        GraphCloner.Node node1 = new GraphCloner.Node(1);
        GraphCloner.Node node2 = new GraphCloner.Node(2);
        GraphCloner.Node node3 = new GraphCloner.Node(3);

        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);  // Cycle: 1 → 2 → 3 → 1

        GraphCloner.Node clonedNode1 = cloneGraph(node1);


        assertEquals(1, clonedNode1.val);
        assertEquals(1, clonedNode1.neighbors.size());

        GraphCloner.Node clonedNode2 = clonedNode1.neighbors.get(0);
        GraphCloner.Node clonedNode3 = clonedNode2.neighbors.get(0);

        assertEquals(2, clonedNode2.val);
        assertEquals(3, clonedNode3.val);
        assertEquals(1, clonedNode3.neighbors.get(0).val);  // Check cycle
        assertSame(clonedNode1, clonedNode3.neighbors.get(0));
    }


}
