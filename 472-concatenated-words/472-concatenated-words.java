class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        /*
            for each word in words
                - DP, [0,i) check table, [i,n) check set
        */
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String str : words) {
            set.add(str);
        }
        for (String str : words) {
            set.remove(str);
            if (canBreak(str, set)) res.add(str);
            set.add(str);
        }
        return res;
    }
    private boolean canBreak(String str, Set<String> set) {
        if (str.length() == 0 || set.size() == 0) return false;
        boolean[] cur = new boolean[str.length() + 1];
        cur[0] = true;
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (cur[j] && set.contains(str.substring(j, i))) {
                    cur[i] = true;
                    break;
                }
            }
        }
        return cur[str.length()];
    }
}