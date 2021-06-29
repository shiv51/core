package core.dailyproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AdobeInterview1 {

	static int maxEvents(int[] start, int[] end, int N) {
		List<Event> l = new ArrayList<>();
		if (start.length == 0) {
			return 0;
		}
		if (start.length == 1) {
			return 1;
		}
		for (int i = 0; i < start.length; i++) {
			l.add(new Event(start[i], end[i]));
		}
		l.sort((a1, a2) -> {
			return a1.getEnd() - a2.getEnd();
		});
		Event m1 = l.get(0);
		int count = 1;
		for (int i = 1; i < l.size(); i++) {
			if (l.get(i).getStart() >= m1.getEnd()) {
				m1 = l.get(i);
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[] start = { 1, 2, 3 };
		int[] end = { 2, 3, 4 };

		int[][] a = { { 1, 4 }, { 4, 4 }, { 2, 2 }, { 3, 4 }, {1,1} };

		System.out.println(maxEvents1(start,end));
	}
	
	public static int maxEvents1(int[][] events) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] event : events) {
            map.putIfAbsent(event[0], new ArrayList<>());
            map.get(event[0]).add(event[1]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int now = 1;
        int ans = 0;
        int lastDay = Arrays.stream(events).flatMapToInt(Arrays::stream).max().getAsInt();
        while (now <= lastDay) {
            if (map.get(now) != null) pq.addAll(map.get(now));
            boolean attended = false;
            while (!pq.isEmpty()) {
                if (pq.poll() >= now) {
                    attended = true;
                    break;
                }
            }
            now++;
            if (attended) ans++;
        }
        return ans;
    }
	
	public static int maxEvents1(int[] start, int[] end) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int lastDay = 0;
        for (int i=0;i<start.length;i++) {
            map.putIfAbsent(start[i], new ArrayList<>());
            map.get(start[i]).add(end[i]);
            lastDay = Math.max(lastDay, end[i]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int now = 1;
        int ans = 0;
        while (now <= lastDay) {
            if (map.get(now) != null) pq.addAll(map.get(now));
            boolean attended = false;
            while (!pq.isEmpty()) {
                if (pq.poll() >= now) {
                    attended = true;
                    break;
                }
            }
            now++;
            if (attended) ans++;
        }
        return ans;
    }

	public static int maxEvents(int[][] events) {
		List<Event> l = new ArrayList<>();
		int max = 0;
		if (events.length == 0) {
			return 0;
		}
		if (events.length == 1) {
			return 1;
		}
		for (int i = 0; i < events.length; i++) {
			max = Math.max(max, events[i][1]);
			l.add(new Event(events[i][0], events[i][1]));

		}
		l.sort((a1, a2) -> {
			return a1.getEnd() - a2.getEnd();
		});
		Map<Integer,String> map = new HashMap<>();
		for (int i = 1; i <= max; i++) {
			map.put(i, "N");
		}
		int count = 0;
		for (int i = 0; i < l.size(); i++) {
			int k = l.get(i).getStart();
			while (k <= l.get(i).getEnd()) {
				if (map.get(k)=="N") {
					map.put(k, "Y");
					count++;
					break;
				}
				k++;
			}
		}
		return count;
	}
}

class Event {
	int start;
	int end;

	public Event(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Event [start=" + start + ", end=" + end + "]";
	}
}
