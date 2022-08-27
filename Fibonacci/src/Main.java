public class Main {

    public static int computeFibonacci(int N) {

        if (N <= 1){
            return N;
        }
         int total;
        total = computeFibonacci(N - 1) + computeFibonacci(N - 2);

        return total;
    }

    public static void main(String[] args) {
        int N;      // F_N, starts at 0

        N = 4;

        System.out.println("F_" + N + " is " + computeFibonacci(N));
    }
}
