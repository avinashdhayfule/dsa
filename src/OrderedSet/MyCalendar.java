package src.OrderedSet;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> startEntry = map.floorEntry(start);
        Map.Entry<Integer, Integer> endEntry = map.ceilingEntry(start);
        if(startEntry != null &&  start < startEntry.getValue() ) return false;
        if(endEntry != null && endEntry.getKey() < end )  return false;

        map.put(start, end);

        return true;

    }
}
