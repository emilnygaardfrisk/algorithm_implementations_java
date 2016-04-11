import java.util.Scanner;

public class Heapsort {
    public Heapsort() {}

    public static void main(String[] args) {
        Scanner scan = new Scanner();
        String[] input = scan.nextLine().split(" ");
        PQHeap heap = new PQHeap(input.length);
        
        System.out.println(Arrays.toString(input));
    }
}
