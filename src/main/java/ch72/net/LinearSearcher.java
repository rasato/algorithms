package ch72.net;

/**
 * Created by tie302954 on 2016/09/27.
 */
public class LinearSearcher implements Searcher {

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
        int i = 0;
        while (i < n) {
            if (table[i].key == key) {
                return table[i].data;
            }
            i++;
        }
        return null;
    }
}
