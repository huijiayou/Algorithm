class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>(Arrays.asList(new Integer[]{1}));
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for (int j = 0; j < i - 1; j++) {
                temp.add(res.get(j) + res.get(j + 1));
            }
            temp.add(1);
            res = temp;
        }
        return res;
    }
}