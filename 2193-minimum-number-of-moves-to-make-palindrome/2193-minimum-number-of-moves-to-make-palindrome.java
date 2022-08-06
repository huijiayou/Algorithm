class Solution {
    public int minMovesToMakePalindrome(String s) {
        /*
            x...(a)...y..(b)..x..(c)...y..(d)
            xy...yx  c+d+1  + d+a
            yx...xy  d+a+1  + c+d
            
            x..(a)..x..(b)..y..(c)..y..(d)
            xyyx  b+c+d+2  + d+b+a
            yxxy  d+a+b+2  + b+c+d
            
            - even number case
            - odd number case
                - wait until the end to move single char
        */
        
        char[] arr = s.toCharArray();
        int n = s.length();
        int res = 0;
        int count = 0;
        for (int i = 0; i < n/2; i++) {
            char cur = arr[i];
            int j = n - 1 - count;
            while (arr[j] != cur) j--;
            if (j > i) {
                int k = n - j - 1 - count;
                count++;
                res += k;
                while (k-- > 0) {
                    swap(arr, j, j + 1);
                    j++;
                }
            } else {
                res += n / 2 - i;
            }
        }
        return res;
    }
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}