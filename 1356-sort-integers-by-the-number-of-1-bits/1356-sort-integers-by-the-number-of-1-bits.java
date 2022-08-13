class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] input = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(input, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                int count1 = Integer.bitCount(i1);
                int count2 = Integer.bitCount(i2);
                if (count1 == count2) return i1 < i2 ? -1 : 1;
                return count1 < count2 ? -1 : 1;
            }
        });
        return Arrays.stream(input).mapToInt(Integer::intValue).toArray();
    }
}