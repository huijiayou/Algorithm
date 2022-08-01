class Solution {
    private String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    private String[] TENTH = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] THOUSAND = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num > 0) {
            int temp = num % 1000;
            if (temp > 0) {
                StringBuilder cur = new StringBuilder();
                helper(temp, cur);
                cur.append(THOUSAND[index]).append(" ");
                sb.insert(0, cur);
            }
            index++;
            num /= 1000;
        }
        return sb.toString().trim();
    }
    private void helper(int temp, StringBuilder cur) {
        if (temp > 0) {
            if (temp <= 20) {
                cur.append(LESS_THAN_TWENTY[temp]).append(" ");
            } else if (temp > 20 && temp < 100) {
                int tenth = temp / 10;
                cur.append(TENTH[tenth]).append(" ");
                helper(temp % 10, cur);
            } else {
                int hundred = temp / 100;
                cur.append(LESS_THAN_TWENTY[hundred]).append(" Hundred ");
                helper(temp % 100, cur);
            }
        }
    }
}