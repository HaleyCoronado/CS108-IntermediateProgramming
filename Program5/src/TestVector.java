public class TestVector {
    private Vector vector;

    public static void main(String[] args) {
        System.out.println("*** Starting ***");

        Vector vector = new Vector();

        TestVector test = new TestVector();
        test.runTests(vector);

        System.out.println("*** Finished ***");
    }

    public void runTests(Vector vector){
        log("Starting Vector tests");
        this.vector = vector;

        boolean result = false;
        int errors = 0;

        result = testAdd();
        if(!result) errors++;

        result = testContains();
        if(!result) errors++;

        result = testResize();
        if(!result) errors++;

        result = testRemove();
        if(!result) errors++;

        result = testAddAfter();
        if(!result) errors++;

        result = testLastIndexOf();
        if(!result) errors++;

        result = testIndexOf();
        if(!result) errors++;

        result = testTrim();
        if(!result) errors++;

        result = testConstructors();
        if(!result) errors++;

        result = testClear();
        if(!result) errors++;

        result = test();
        if(!result) errors++;

        if(result)
            log("ZyBooks test PASSED");
        else
            log("ZyBooks test FAILED");

        log("");
        log("THERE WERE " + errors + " ERRORS");
        log("");

        log("Finished Vector tests");
    }

    private boolean testConstructors(){
        boolean result = false;

        try{
            Vector v1 = new Vector();
            Vector v2 = new Vector(25);
            Vector v3 = new Vector(25, 5);
            result = true;
        }
        catch (Exception ex){
            result = false;
        }

        if(result)
            log("Constructor test PASSED");
        else
            log("Constructor test FAILED");

        return result;
    }

    private boolean testTrim(){
        boolean result = false;

        vector.trimToSize();
        Integer val = vector.getCapacity();
        Integer size = vector.size();
        if(val.equals(size))
            result = true;

        if(result)
            log("Trim test PASSED");
        else
            log("Trim test FAILED");

        return result;
    }

    private boolean testIndexOf(){
        boolean result = false;

        Integer val = (Integer) vector.indexOf(200);

        if(val.equals(7))
            result = true;

        if(result)
            log("IndexOf test PASSED");
        else
            log("IndexOf test FAILED");

        return result;
    }

    private boolean testLastIndexOf(){
        boolean result = false;

        vector.add(200);
        Integer val = (Integer) vector.lastIndexOf(200);

        if(val.equals(13))
            result = true;

        if(result)
            log("LastIndexOf test PASSED");
        else
            log("LastIndexOf test FAILED");

        return result;
    }

    private boolean testAddAfter(){
        boolean result = false;

        vector.add(7, 200);
        Integer val = (Integer) vector.get(7);

        if(val.equals(200))
            result = true;

        if(result)
            log("Add After test PASSED");
        else
            log("Add After test FAILED");

        return result;
    }

    private boolean testRemove(){
        boolean result = false;

        int size = vector.size();

        Integer val = (Integer) vector.remove(4);

        size = vector.size();
        if(size == 12 && val.equals(101))
            result = true;

        if(result)
            log("Remove test PASSED");
        else
            log("Remove test FAILED");

        return result;
    }

    private boolean testResize(){
        boolean result = false;

        int cap = vector.getCapacity();

        for(int i = 0; i < 10; i++){
            vector.add(100 + i);
        }

        int size = vector.size();
        if(size == 13 && vector.getCapacity() == 15)
            result = true;

        if(result)
            log("Resize test PASSED");
        else
            log("Resize test FAILED");

        return result;
    }

    private boolean testContains(){
        boolean result = false;
        boolean val = vector.contains(30);
        if(val)
            result = true;

        if(result)
            log("Contains test PASSED");
        else
            log("Contains test FAILED");

        return result;
    }

    private boolean testClear(){
        boolean result = false;
        vector.add(10);

        Integer cap = vector.getCapacity();
        vector.clear();
        Integer val = (Integer) vector.get(0);
        if(val == null && cap.equals(vector.getCapacity()))
            result = true;

        if(result)
            log("Clear test PASSED");
        else
            log("Clear test FAILED");

        return result;
    }

    private boolean testAdd(){
        boolean result = false;

        vector.add(10);
        vector.add(20);
        vector.add(30);

        Integer val = (Integer) vector.get(0);
        if(val.equals(10))
            result = true;

        if(result)
            log("Add test PASSED");
        else
            log("Add test FAILED");

        return result;
    }

    private void log(String msg){
        System.out.println(msg);
    }

    public static boolean test(){
        Vector<String> studentMain = new Vector<String>();

        try {

            //Test adding and removing one string
            String stringAdded = "Hello";
            studentMain.add(stringAdded);
            String stringRemoved = studentMain.remove(0);
            if (!stringAdded.equals(stringRemoved)) {
                System.out.println("'" + stringAdded + "' was added to your vector, but '" + stringRemoved + "' was removed.");
                return false;
            }

            //Test adding and removing two strings
            stringAdded = "alpha";
            String stringAdded2 = "bravo";
            studentMain.add(stringAdded);
            studentMain.add(stringAdded2);
            stringRemoved = studentMain.remove(0);
            String stringRemoved2 = studentMain.remove(0);
            if (!stringAdded.equals(stringRemoved) || !stringAdded2.equals(stringRemoved2)) {
                System.out.println("'" + stringAdded + "' and '" + stringAdded2 + "' were added to your vector, but '" + stringRemoved + "' and '" + stringRemoved2 + "' were removed.");
                System.out.println("If correct Strings were returned, check their order, as the order they are stored and returned matters.");
                return false;
            }

            //Test adding three strings and removing them in different order
            stringAdded = "alpha";
            stringAdded2 = "bravo";
            String stringAdded3 = "charlie";
            studentMain.add(stringAdded);
            studentMain.add(stringAdded2);
            studentMain.add(stringAdded3);

            //Tests removing bad index
            // boolean failed = false;
            try {
                studentMain.remove(-3);
            }
            catch (IllegalArgumentException o) {
                System.out.println("Successfully threw IllegalArgumentException");
            }
            catch (Exception e) {
                System.out.println("Your program should return an IllegalArgumentException when attempting to remove an index out of range (index < 0 || index >= size())");
                System.out.println(e);
                return false;
            }
            //End testing remove of bad index

            stringRemoved = studentMain.remove(1);
            stringRemoved2 = studentMain.remove(1);
            String stringRemoved3 = studentMain.remove(0);

            if (!stringAdded.equals(stringRemoved3) || !stringAdded2.equals(stringRemoved) || !stringAdded3.equals(stringRemoved2)) {
                System.out.println("'" + stringAdded + "', '" + stringAdded2 + "' and '" + stringAdded3 + " were added to your vector, but '" + stringRemoved + "', '" + stringRemoved2 + "' and '" + stringRemoved3 + "' were removed (in that order).");
                System.out.println("If correct Strings were returned, check their order, as the order they are stored and returned matters.");
                System.out.println("The order the strings should be returned: " + stringAdded2 + " " + stringAdded3 + " " + stringAdded );
                return false;
            }

        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }


        return true;
    }
}
