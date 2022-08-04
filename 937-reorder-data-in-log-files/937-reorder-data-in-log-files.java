class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            /*
                if all letters, lexicographically order
                    - if same, compare identifiers
                if all number, keep the same order
                if one is letter, another is number, letter goes first
            */
            @Override
            public int compare(String str1, String str2) {
                int firstspace1 = str1.indexOf(' ');
                String id1 = str1.substring(0, firstspace1);
                String main1 = str1.substring(firstspace1 + 1);
                boolean isDigit1 = Character.isDigit(main1.charAt(0));
                
                int firstspace2 = str2.indexOf(' ');
                String id2 = str2.substring(0, firstspace2);
                String main2 = str2.substring(firstspace2 + 1);
                boolean isDigit2 = Character.isDigit(main2.charAt(0));
                
                if (!isDigit1 && !isDigit2) {
                    int compare = main1.compareTo(main2);
                    if (compare == 0) return id1.compareTo(id2);
                    return compare;
                } else if (isDigit1 && isDigit2) {
                    return 0;
                } else {
                    return isDigit1 ? 1 : -1;
                }
            }
        });
        return logs;
    }
}