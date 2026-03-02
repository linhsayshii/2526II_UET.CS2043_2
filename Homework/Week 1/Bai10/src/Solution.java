public class Solution {
    public int secondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE, secondlargest = Integer.MIN_VALUE;
        if (arr == null || arr.length < 2) {
            return -1;
        }
        for (int num : arr) {
            if (num > largest) {
                secondlargest = largest;
                largest = num;
            } else if (num > secondlargest && num != largest) {
                secondlargest = num;
            }
        }
        if (secondlargest == Integer.MIN_VALUE) {
            return -1;
        }
        return secondlargest;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        // 1. Mảng bình thường
        int[] arr1 = {5, 2, 8, 1, 9, 3};
        System.out.println("Mảng bình thường: " + sol.secondLargest(arr1));

        // 2. Mảng có phần tử trùng nhau (số lớn nhất lặp lại)
        int[] arr2 = {10, 10, 9, 8};
        System.out.println("Mảng trùng số lớn nhất: " + sol.secondLargest(arr2));

        // 3. Mảng chỉ có 1 phần tử
        int[] arr3 = {5};
        System.out.println("Mảng 1 phần tử: " + sol.secondLargest(arr3));

        // 4. Mảng tất cả các phần tử giống nhau
        int[] arr4 = {7, 7, 7, 7};
        System.out.println("Mảng các phần tử giống nhau: " + sol.secondLargest(arr4));
    }
}
