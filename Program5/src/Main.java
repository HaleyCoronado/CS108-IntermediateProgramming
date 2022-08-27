public class Main {
    public static void main(String[] args){
        System.out.println("Starting");

        Vector v = new Vector();
        //TestVector test = new TestVector();
        //test.runTests(v);

        v.add("alpha");
        v.add("bravo");
        v.add("charlie");

        String s = (String) v.remove(0);
        System.out.println(s);
        System.out.println(v.remove(0));
        System.out.println(v.remove(0));

        v.add("hello");
        System.out.println(v.get(0));
        System.out.println(v.remove(0));

        //System.out.println(v.remove(-3));

    }
}
