package procon_lib;

public class UnionFindTree {

    public static class UFTree {
        int[] parent;
        int[] size;
        int[] rank;

        public UFTree(int size) {
            this.parent = new int[size + 1];
            this.rank = new int[size + 1];
            this.size = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                makeSet(i);
            }
        }

        public void makeSet(int i) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }

        public void union(int x, int y) {
            if (x == y) return;

            int xRoot = find(x);
            int yRoot = find(y);
            if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
                size[xRoot] += size[yRoot];
            } else if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
                size[yRoot] += size[xRoot];
            } else if (xRoot != yRoot) {
                parent[yRoot] = xRoot;
                size[xRoot] += size[yRoot];
                rank[xRoot]++;
            }
        }

        public int find(int i) {
            if (i != parent[i]) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public int size(int i) {
            return size[find(i)];
        }

        public boolean same(int x, int y) {
            return find(x) == find(y);
        }

    }
}
