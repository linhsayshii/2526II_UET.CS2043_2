public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = {5, 1, 3, 2};
        String[] arr2 = {"Java", "C++", "Python"};
        //Student[] arr3 = {};
        //ArrayUtils.sort(arr3);
        ArrayUtils.sort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        ArrayUtils.sort(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
