package ch72.net;

/**
 * Created by tie302954 on 2016/09/28.
 */
public class BinarySearcher implements Searcher {

    /**
     * Entry for Table
     */
    static private class Entry {

        int key;
        Object data;

        private Entry(int key, Object data) {
            this.key = key;
            this.data = data;
        }
    }

    final static int MAX = 10000000;
    Entry[] table = new Entry[MAX];
    int n = 0;

    public void add(int key, Object data) {
        if (n > MAX) {
            throw new IllegalStateException("Too much data!");
        }
        table[n++] = new Entry(key, data);
    }

    public Object search(int key) {

        int low = 0;
        int high = n - 1;

        while (low < high) {
            int middle = (low + high) / 2;

            if (key == table[middle].key) {
                return table[middle].data;
            } else if (key > table[middle].key) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return null;
    }
}
