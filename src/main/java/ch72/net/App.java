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
        //Searcher searcher = createSearcher(args[0]);
        Searcher searcher = new LinearSearcher();
        setup(searcher);
        //int target = Integer.parseInt(args[1]);
        int target = 9999999;
        search(searcher, target);
    }

    private static Searcher createSearcher(String searcherName) throws IllegalAccessException, InstantiationException {
        Class clazz;
        String className = basePackage + "." + searcherName;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(className + " is not exist.");
        }
        return (Searcher) clazz.newInstance();
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
        for (int i = 0; i < 10000000; i++) {
            searcher.add(i, String.valueOf(i));
        }
    }
}
