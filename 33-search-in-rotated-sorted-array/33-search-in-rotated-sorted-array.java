/*
    - find the rotated pivot
    - search the target
    
    target = 5/1
    pivot = 8, since the left side of pivot, elements are asceding, and on the right side, elements are asceding
    7,  8,  9,  0,  1,  2,  4,  5
    l
                                r
                m
    - nums[m] > nums[m + 1], m is pivot
    - nums[l] < nums[m] pivot is nor in this side, left = mid + 1
    - nums[l] > nums[m] pivot is in this side, right = mid - 1
*/


class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int pivot = getPivot(nums, target, 0, nums.length - 1);
        int res = -1;
        if (pivot == -1) {
            res = getTarget(nums, target, 0, nums.length - 1);
        } else {
            if (target >= nums[0] && target <= nums[pivot]) {
                res = getTarget(nums, target, 0, pivot);
            } else {
                res = getTarget(nums, target, pivot + 1, nums.length - 1);
            }
        }
        return res;
    }
    private int getPivot(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    private int getTarget(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}