package ch72.net;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String basePackage = "ch72.net";

    public static void main( String[] args )
    {
        Searcher linearSearcher = new LinearSearcher();
        System.out.println(linearSearcher.getClass().getSimpleName());
        setup(linearSearcher);
        search(linearSearcher, 9999999);
        // set null for escape OOM.
        linearSearcher = null;

        Searcher binarySearcher = new BinarySearcher();
        System.out.println(binarySearcher.getClass().getSimpleName());
        setup(binarySearcher);
        search(binarySearcher, 9999999);
    }

    private static void search(Searcher searcher, int key) {
        long start = System.currentTimeMillis();
        Object seach = searcher.search(key);
        long end = System.currentTimeMillis();

        if (seach != null) {
            System.out.println("object is " + seach);
        } else {
            System.out.println("not searched!");
        }

        System.out.println("computed : " + (end - start) + "[msec]");
    }

    private static void setup(Searcher searcher) {
        System.out.println("setup start.");
        for (int i = 0; i < 10000000; i++) {
            searcher.add(i, String.valueOf(i));
        }
        System.out.println("setup end.");
    }
}
