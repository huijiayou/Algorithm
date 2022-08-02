class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> dict = new HashSet<>(wordList);
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int count = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                Set<String> next = helper(cur, dict, visited);
                for (String str : next) {
                    if(str.equals(endWord)) return count + 1;
                    queue.offer(str);
                }
            }
            count++;
        }
        return 0;
    }
    private Set<String> helper(String word, Set<String> dict, Set<String> visited) {
        Set<String> res = new HashSet<>();
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char orig = arr[i];
            for (char j = 'a'; j <= 'z'; j++) {
                arr[i] = j;
                String cur = new String(arr);
                if (dict.contains(cur) && !visited.contains(cur)) {
                    res.add(cur);
                    visited.add(cur);
                }
            }
            arr[i] = orig;
        }
        return res;
    }
}