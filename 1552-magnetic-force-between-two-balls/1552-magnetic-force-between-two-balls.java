import java.util.*;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int low = 1;
        int high = position[position.length - 1] - position[0];
        int result = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            int balls = 1;
            int lastPos = position[0];
            
            for (int i = 1; i < position.length; i++) {
                if (position[i] - lastPos >= mid) {
                    balls++;
                    lastPos = position[i];
                }
            }
            
            if (balls >= m) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return result;
    }
}