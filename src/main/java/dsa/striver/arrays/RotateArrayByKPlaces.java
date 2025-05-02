package dsa.striver.arrays;

import java.util.Arrays;

class Solution {

    // Left rotate by 1
    int[] leftRotateBy1(int[] arr) {
        int n = arr.length;
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
        return arr;
    }

    // Left rotate by K
    int[] leftRotateByK(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
        return arr;
    }

    // Right rotate by 1
    int[] rightRotateBy1(int[] arr) {
        int n = arr.length;
        int temp = arr[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
        return arr;
    }

    // Right rotate by K
    int[] rightRotateByK(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        return arr;
    }

    // Helper method to reverse an array
    void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}

public class RotateArrayByKPlaces {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {2, 3, 4, 5, 1};
        System.out.println("Left Rotate by 1: " + Arrays.toString(sol.leftRotateBy1(arr1.clone())));

        int[] arr2 = {2, 3, 4, 5, 1};
        System.out.println("Left Rotate by 2: " + Arrays.toString(sol.leftRotateByK(arr2.clone(), 2)));

        int[] arr3 = {2, 3, 4, 5, 1};
        System.out.println("Right Rotate by 1: " + Arrays.toString(sol.rightRotateBy1(arr3.clone())));

        int[] arr4 = {2, 3, 4, 5, 1};
        System.out.println("Right Rotate by 2: " + Arrays.toString(sol.rightRotateByK(arr4.clone(), 2)));
    }
}

