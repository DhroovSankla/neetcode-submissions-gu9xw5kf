class TimeMap {
    private Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Data(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Data> history = map.get(key);
        return binarySearch(history, timestamp);
    }

    private String binarySearch(List<Data> list, int time) {
        int left = 0, right = list.size() - 1;
        String res = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= time) {
                res = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private static class Data {
        int timestamp;
        String value;
        Data(int t, String v) { this.timestamp = t; this.value = v; }
    }
}