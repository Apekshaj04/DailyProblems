class Solution {
    // Rotates the array by k steps
    public int[] rotateArray(int[] arr, int k) {
        int[] temp = new int[arr.length];
        int j = 0;

        // Copy the last k elements to the beginning of temp
        for (int i = arr.length - k; i < arr.length; i++) {
            temp[j] = arr[i];
            j++;
        }

        // Copy the remaining elements to temp
        for (int i = 0; i < arr.length - k; i++) {
            temp[j] = arr[i];
            j++;
        }

        return temp;
    }

    // Checks if the array is sorted or can be rotated to become sorted
    public boolean check(int[] nums) {
        // Clone nums and sort the copy
        int[] arr = nums.clone();
        Arrays.sort(arr);

        // If nums is already sorted, return true
        if (Arrays.equals(arr, nums)) {
            return true;
        }

        // Try all rotations to see if any match the sorted array
        for (int i = 1; i < nums.length; i++) {
            int[] rotated = rotateArray(nums, i);
            if (Arrays.equals(arr, rotated)) {
                return true;
            }
        }

        return false; // No valid rotation found
    }
}
