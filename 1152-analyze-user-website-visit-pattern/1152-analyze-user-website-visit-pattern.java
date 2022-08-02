/*
    Map<String, TreeMap<Integer, String>>
        username        time    web
    
    Map<String, Integer>
        pattern     time
*/

class Solution {
public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, TreeMap<Integer, String>> map = new HashMap<>();
        for (int i = 0; i < timestamp.length; i++) {
            if(!map.containsKey(username[i])) {
                map.put(username[i], new TreeMap<>());
            }
            map.get(username[i]).put(timestamp[i], website[i]);
        }
        Map<String, Integer> patternFrequency = new HashMap<>();
        for (String name : map.keySet()) {
            getPattern(name, map, patternFrequency);
        }
        String candi = "";
        int count = 0;
        for (String str : patternFrequency.keySet()) {
            int freq = patternFrequency.get(str);
            if (freq > count) {
                candi = str;
                count = freq;
            } else if (freq == count) {
                candi = candi.compareTo(str) < 0 ? candi : str;
            }
        }
        String[] res = candi.split(",");
        return Arrays.asList(res);
    }
    private void getPattern(String name, Map<String, TreeMap<Integer, String>> map, Map<String, Integer> patternFrequency) {
        List<String> websites = new ArrayList<>(map.get(name).values());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < websites.size() - 2; i++) {
            for (int j = i + 1; j < websites.size() - 1; j++) {
                for (int l = j + 1; l < websites.size(); l++) {
                    String pattern = websites.get(i) + "," + websites.get(j) + "," + websites.get(l);
                    set.add(pattern);
                }
            }
        }
        for (String str : set) {
            patternFrequency.put(str, patternFrequency.getOrDefault(str, 0) + 1);
        }
    }
}