public class Test {
    public static void main(String[] args) {
        Integer[] numeri = new Integer[10];

        for (int i = 0; i < 10; i++)
            numeri[i] = i;
        
        for (int i = 0; i < 11; i++)
            System.out.println(ArrayAlgs.binarySearch(numeri, 10, i));
    }
}
