class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] + carry <= 9) {
                digits[i] += carry;
                carry = 0;
                break;
            } else {
                int temp = digits[i] + carry;
                digits[i] = temp % 10;
                carry = temp / 10;
            }
        }
        if (carry > 0) {
            int[] newArray = new int[n + 1];
            newArray[0] = carry;
            for (int i = 1; i < n + 1; i++) {
                newArray[i] = digits[i - 1];
            }
            return newArray;
        }
        return digits;
    }
}