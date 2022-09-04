class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            if (i == n) {
                break;
            }
            factorial *= i;
        }
        k--;
        StringBuilder sb = new StringBuilder();
        while(true) {
            int index = k / factorial;
            sb.append(nums.get(index));
            nums.remove(index);
            k %= factorial;
            if (nums.isEmpty()) break;
            factorial /= nums.size();
        }
        return sb.toString();
    }
}