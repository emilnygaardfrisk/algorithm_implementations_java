import java.util.Scanner;
import java.util.Arrays;

public class Heapsort {

    public static int[] sort(int[] a) {
        PQHeap h = new PQHeap(a.length);
        for (int i : a) h.insert(new Element(i, null)); 
        for (int i = 0; i < a.length; i++) a[i] = h.extractMin().key;
        return a;
    }

    public static void main(String[] args) {
        int[] a = {3,8,2,1,31,5,23,3,6};
        System.out.println(Arrays.toString(Heapsort.sort(a)));
    }
}
