package arrayhandler;

public class ArrayHandler {
    public static void r1(int[] a) {
        int[] temp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[a.length - 1 - i];
        }
        a = temp;
    }
 
    public static void r2(int[] a) {
        int[] temp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[a.length - 1 - i];
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = temp[i];
       }
    }
}
