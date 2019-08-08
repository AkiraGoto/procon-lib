package procon_lib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnionFindTreeTest {

    @Test
    public void testConstructor() {
        int size = 10;
        UnionFindTree.UFTree uft = new UnionFindTree.UFTree(size);
        for (int i = 1; i <= size; i++) {
            assertEquals(i, uft.parent[i]);
            assertEquals(0, uft.rank[i]);
            assertEquals(1, uft.size[i]);
        }
    }

    @Test
    public void testUnion1() {
        int size = 10;
        UnionFindTree.UFTree uft = new UnionFindTree.UFTree(size);

        uft.union(1, 5);

        assertEquals(1, uft.parent[1]);
        assertEquals(2, uft.size[1]);
        assertEquals(1, uft.rank[1]);
        assertEquals(1, uft.parent[5]);
        assertEquals(1, uft.size[5]);
        assertEquals(0, uft.rank[5]);
    }

    @Test
    public void testUnion2() {
        int size = 10;
        UnionFindTree.UFTree uft = new UnionFindTree.UFTree(size);

        uft.union(1, 5);
        uft.union(1, 7);

        assertEquals(1, uft.parent[1]);
        assertEquals(3, uft.size[1]);
        assertEquals(1, uft.rank[1]);
        assertEquals(1, uft.parent[5]);
        assertEquals(1, uft.size[5]);
        assertEquals(0, uft.rank[5]);
        assertEquals(1, uft.parent[7]);
        assertEquals(1, uft.size[7]);
        assertEquals(0, uft.rank[7]);
    }

    @Test
    public void testUnion3() {
        int size = 10;
        UnionFindTree.UFTree uft = new UnionFindTree.UFTree(size);

        uft.union(1, 5);
        uft.union(7, 9);
        uft.union(1, 7);

        assertEquals(1, uft.parent[1]);
        assertEquals(4, uft.size[1]);
        assertEquals(2, uft.rank[1]);
        assertEquals(1, uft.parent[5]);
        assertEquals(1, uft.size[5]);
        assertEquals(0, uft.rank[5]);
        assertEquals(1, uft.parent[7]);
        assertEquals(2, uft.size[7]);
        assertEquals(1, uft.rank[7]);
        assertEquals(7, uft.parent[9]);
        assertEquals(1, uft.size[9]);
        assertEquals(0, uft.rank[9]);
    }

    @Test
    public void testFind1() {
        int size = 10;
        UnionFindTree.UFTree uft = new UnionFindTree.UFTree(size);

        uft.union(1, 5);

        assertEquals(1, uft.find(1));
        assertEquals(1, uft.find(5));
    }

    @Test
    public void testFind2() {
        int size = 10;
        UnionFindTree.UFTree uft = new UnionFindTree.UFTree(size);

        uft.union(1, 5);
        uft.union(7, 9);
        uft.union(1, 7);

        assertEquals(1, uft.find(1));
        assertEquals(1, uft.find(5));
        assertEquals(1, uft.find(7));
        assertEquals(1, uft.find(9));
    }

    @Test
    public void testSize1() {
        int size = 10;
        UnionFindTree.UFTree uft = new UnionFindTree.UFTree(size);

        uft.union(1, 5);

        assertEquals(2, uft.size(1));
        assertEquals(2, uft.size(5));
    }

    @Test
    public void testSize2() {
        int size = 10;
        UnionFindTree.UFTree uft = new UnionFindTree.UFTree(size);

        uft.union(1, 5);
        uft.union(7, 9);
        uft.union(1, 7);

        assertEquals(4, uft.size(1));
        assertEquals(4, uft.size(5));
        assertEquals(4, uft.size(7));
        assertEquals(4, uft.size(9));
    }

    @Test
    public void testSame1() {
        int size = 10;
        UnionFindTree.UFTree uft = new UnionFindTree.UFTree(size);

        assertTrue(uft.same(1, 1));
        assertFalse(uft.same(1, 5));
    }

    @Test
    public void testSame2() {
        int size = 10;
        UnionFindTree.UFTree uft = new UnionFindTree.UFTree(size);

        uft.union(1, 5);

        assertTrue(uft.same(1, 5));
    }

    @Test
    public void testSame3() {
        int size = 10;
        UnionFindTree.UFTree uft = new UnionFindTree.UFTree(size);

        uft.union(1, 5);
        uft.union(7, 9);
        uft.union(1, 7);

        assertTrue(uft.same(1, 5));
        assertTrue(uft.same(1, 7));
        assertTrue(uft.same(1, 9));
        assertTrue(uft.same(5, 7));
        assertTrue(uft.same(5, 9));
        assertTrue(uft.same(7, 9));
    }
}
