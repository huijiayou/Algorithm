class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int n = s.length();
        int index = 0;
        while (index < n) {
            for (int i = 0; i < numRows && index < n; i++) {
                sb[i].append(s.charAt(index++));
            }
            for (int i = numRows - 2; i > 0 && index < n; i--) {
                sb[i].append(s.charAt(index++));
            }
        }
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}