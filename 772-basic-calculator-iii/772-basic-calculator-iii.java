class Solution {
    int index = 0;
    char[] arr;
    public int calculate(String s) {
        /*
            - global index
            - symbol = '+'
            - if digit
                - get all digits for the number
                - based on the previous symbol to process it
                - add it into the stack
            - else if (, num = dfs(...)
            - else if ), break
            - else (cur is symbol), symbol = arr[i]
            
           + 6 - 4 / 2 + (5 - 3)
           ___
               ___
                  ____
                       _________ -> + 5 - 3
                                    ___
                                        ___
        */
        arr = s.toCharArray();
        return dfs();
    }
    private int dfs() {
        Deque<Integer> stack = new ArrayDeque<>();
        char symbol = '+';
        while (index < arr.length) {
            char cur = arr[index];
            if (cur != ' ') {
                if (Character.isDigit(cur)) {
                    int num = cur - '0';
                    while (index + 1 < arr.length && Character.isDigit(arr[index + 1])) {
                        index++;
                        num = num * 10 + arr[index] - '0';
                    }
                    handleNumber(num, symbol, stack);
                } else if (cur == '(') {
                    index++;
                    int num = dfs();
                    handleNumber(num, symbol, stack);
                } else if (cur == ')') {
                    break;
                } else {
                    symbol = cur;
                }
            }
            index++;
        }
        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }
    private void handleNumber(int num, char symbol, Deque<Integer> stack) {
        if (symbol == '-') {
            num *= -1;
        } else if (symbol == '*') {
            num *= stack.pollLast();
        } else if (symbol == '/') {
            num = stack.pollLast() / num;
        }
        stack.offerLast(num);
    }
}






