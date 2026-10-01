class Solution {
    public int search(int[] nums, int target) {

        int min = minSearch(nums);

        if(nums[min] <= target && target <= nums[nums.length - 1]){
            return search(nums,min,nums.length-1,target);
        }
        else{
            return search(nums,0,min,target);
        }
    }
    public int search(int[] nums,int left, int right, int target){
        int l = left;
        int r = right;

        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if (nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
    public int minSearch(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(mid > 0 && nums[mid - 1] > nums[mid]){
                return mid;
            }
            else if (nums[left] <= nums[mid] && nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}