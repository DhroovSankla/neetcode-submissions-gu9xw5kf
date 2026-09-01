class TimeMap {

    private static class Entry {
        String value;
        int timestamp;

        Entry(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Entry(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Entry> list = map.get(key);

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).timestamp <= timestamp) {
                return list.get(i).value;
            }
        }

        return "";
    }
}