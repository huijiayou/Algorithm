/*
    use one candidate and one count to remember the majority element
    - if current element is same with candidate, count++
    - if different, count--
    - if count = 0; candidate = arr[i], count = 1
*/

class Solution {
    public int majorityElement(int[] nums) {
        int candi = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (candi == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    candi = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }
        return candi;
    }
}