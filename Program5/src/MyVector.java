public class MyVector{
    public static void main(String[] args){
        System.out.println("START\n");

        Vector v = new Vector();

        v.add(5);
        v.add(7);

        int indexOf2 = v.indexOf(2);
        if (v.contains(2)){
            System.out.println("Vector contains " + v.get(indexOf2) + "\n");
        }

        System.out.println(v.toString());

        for(int i = 0; i < v.size; i++){
            System.out.println(v.get(i));
        }
        System.out.println(" ");


        v.add(3, 4);
        v.add(5, 6);
        for(int i = 0; i < v.size; i++){
            System.out.println(v.get(i));
        }
        System.out.println(" ");


        System.out.println("size = " + v.size);
        System.out.println(" ");


        v.remove(6);
        for(int i = 0; i < v.size; i++){
            System.out.println(v.get(i));
        }
        System.out.println(" ");


        v.remove(0);
        for(int i = 0; i < v.size; i++){
            System.out.println(v.get(i));
        }
        System.out.println(" ");

        v.remove(1);
        for(int i = 0; i < v.size; i++){
            System.out.println(v.get(i));
        }
        System.out.println(" ");


        v.clear();
        if(v.isEmpty()){
            System.out.println("\nVector is empty");
        }


        for(int i = 0; i < v.size; i++){
            System.out.println(v.get(i));
        }
        System.out.println(" ");

        v.add(1);
        v.add(2);
        v.add(1);
        for(int i = 0; i < v.size; i++){
            System.out.println(v.get(i));
        }
        System.out.println(" ");
        int n = v.lastIndexOf(1);
        System.out.println("Last index of 1 is " + n);

        System.out.println("FINISHED");
    }
}
