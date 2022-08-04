class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        /*
            for from index i in search word to end
                two pointers
                - left if product[left].charAt(i) is different and left is smaller then products length left++
                - right if product[right].charAt(i) is different and right >= 0 products length right++
                return elements from left to left + 3/ right
        */
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        int n = searchWord.length();
        int len = products.length;
        int left = 0;
        int right = len - 1;
        for (int i = 0; i < n; i++) {
            while (left <= right && (products[left].length() <= i || products[left].charAt(i) != searchWord.charAt(i))) {
                left++;
            }
            while (left <= right && (products[right].length() <= i || products[right].charAt(i) != searchWord.charAt(i))) {
                right--;
            }
            List<String> temp = new ArrayList<>();
            int min = Math.min(left + 3, right + 1);
            for (int j = left; j < min; j++) {
                temp.add(products[j]);
            }
            res.add(temp);
        }
        return res;
    }
}