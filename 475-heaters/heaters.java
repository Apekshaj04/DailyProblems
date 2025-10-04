import java.util.Arrays;

class Solution {
    
    public boolean binarySearch(int[] heaters, int h) {
        int n = heaters.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (heaters[mid] == h) return true;
            if (heaters[mid] > h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
    
    public int floorSearch(int[] heaters, int h) {
        int n = heaters.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (heaters[mid] <= h) {
                ans = mid;  
                low = mid + 1;  
            } else {
                high = mid - 1;  
            }
        }
        return ans;  
    }
    
    public int ceilSearch(int[] heaters, int h) {
        int n = heaters.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (heaters[mid] >= h) {
                ans = mid;  
                high = mid - 1;  
            } else {
                low = mid + 1;  
            }
        }
        return ans;
    }
    
    public int findRadius(int[] houses, int[] heaters) {
        int n = houses.length;
        int minRadius = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        for (int i = 0; i < n; i++) {
            int h = houses[i];
            if (binarySearch(heaters, h)) continue;

            int floor = floorSearch(heaters, h);
            int ceil = ceilSearch(heaters, h);
            
            int floorDistance = (floor != -1) ? Math.abs(heaters[floor] - h) : Integer.MAX_VALUE;
            int ceilDistance = (ceil != -1) ? Math.abs(heaters[ceil] - h) : Integer.MAX_VALUE;
            
            minRadius = Math.max(minRadius, Math.min(floorDistance, ceilDistance));
        }
        
        return minRadius;
    }
}
