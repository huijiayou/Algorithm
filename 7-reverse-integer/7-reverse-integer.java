class Solution {
    public int reverse(int x) {
        /*
            1,534,236,469
        ->  9,646,324,351
        after reverse, it is overflow
        */
        
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            int newResult = result * 10 + digit;
            if (newResult / 10 != result) {
                return 0;
            }
            result = newResult;
            x /= 10;
        }
        return result;
    }
}