class Solution {
    public String simplifyPath(String path) {
        String[] array = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            String cur = array[i].trim();
            if (cur.length() == 0 || cur.equals(".") || cur.equals("/")) continue;
            if (cur.equals("..") && !stack.isEmpty()) {
                stack.pollLast();
            } else if (!cur.equals("..")) {
                stack.offerLast(cur);
            }
        }
        sb.append('/');
        while(!stack.isEmpty()) {
            sb.append(stack.pollFirst());
            sb.append('/');
        }
        if (sb.length() > 1) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}