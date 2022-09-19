class Solution {
    public boolean search(int[] nums, int target) {
       /* int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
        */
        int l = 0,r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target) return true;
            
            if(nums[l]<=nums[mid]){
                if(target>= nums[l] && target<nums[mid])
                    r = mid-1;
                else l = l+1;
            }else{
                if(target>nums[mid] && target<=nums[r])
                    l = mid+1;
                else r = mid-1;
            }
        }
        return false;
    }
}