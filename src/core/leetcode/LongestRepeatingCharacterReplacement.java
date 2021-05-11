package core.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		System.out.println(get1());
	}

	
	public static int get1() {
		String s = "BAAAB";
		int start = 0, end = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		LinkedList<Character> l = new LinkedList<Character>();
		int max = 0;
		int k = 2;
		
		while(start <= end && end <= s.length() - 1) {
			char charAtStart = s.charAt(start);
			char charAt = s.charAt(end);
			
			if(charAt == charAtStart && count(map, charAtStart)<=k) {
				map.put(charAt, map.getOrDefault(charAt, 0) + 1);
			}
			
			else if(count(map, charAtStart)<k) {
				map.put(charAt, map.getOrDefault(charAt, 0) + 1);
			}
			else if(count(map, charAt)<=k) {
				map.put(charAt, map.getOrDefault(charAt, 0) + 1);
			}
			else {
				while(!l.isEmpty()&& start>=0 && start<=s.length()-1 && !(count(map, s.charAt(start))<k)) {
					Character c = l.pop();
					map.put(c, map.getOrDefault(c, 0) - 1);
					if (map.get(c) <= 0) {
						map.remove(c);
					}
					start++;
				}
				map.put(charAt, map.getOrDefault(charAt, 0) + 1);
			}
			l.add(charAt);
			end++;
			max = Math.max(max, end-start);
		}
		return max;
		
	}
	
	public static int get() {
		String s = "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
		int start = 0, end = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		LinkedList<Character> l = new LinkedList<Character>();
		int max = 0;
		int k = 4;
		
		while(start <= end && end <= s.length() - 1) {
			char charAt = s.charAt(end);
			l.add(charAt);
			
			if(count(map, charAt)<=k || (map.getOrDefault(charAt,0)<k)) {
				map.put(charAt, map.getOrDefault(charAt, 0) + 1);
			}
			else {
				while(!(count(map, charAt)<=k) ) {
					Character c = l.pop();
					map.put(c, map.getOrDefault(c, 0) - 1);
					if (map.get(c) <= 0) {
						map.remove(c);
					}
					start++;
				}
			}
			end++;
			max = Math.max(max, end-start);
		}
		return max;
		
	}
	
	
	public static int count(Map<Character, Integer> map, Character c) {
		int count = 0;
		for(Character s:map.keySet()) {
			if(s == c)
				continue;
			count= count+map.get(s);
		}
		return count;
	}
	
	
	public static void find() {
		String s = "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
		int start = 0, end = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		LinkedList<Character> l = new LinkedList<Character>();
		int max = 0;
		int k = 4;
		while (start <= end && end <= s.length() - 1) {
			l.add(s.charAt(end));
			if (map.containsKey(s.charAt(end))) {
				while (map.entrySet().size() >= 2) {
					boolean valid = false;
					if (map.get(s.charAt(end)) < k) {
						valid = true;
					} else {
						for (Character x : map.keySet()) {
							if (x == s.charAt(end)) {
								continue;
							}
							if (map.get(x) <= k) {
								valid = true;
								break;
							}
						}
					}

					if (!valid) {

						Character c = l.pop();
						map.put(c, map.getOrDefault(c, 0) - 1);
						if (map.get(c) <= 0) {
							map.remove(c);
						}
						start++;
					} else
						break;
				}
				map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
			} else {
				if (map.entrySet().size() >= 1) {
					boolean valid = false;
					if(k == 0) {
						valid = true;
						while (!map.isEmpty()) {
							Character c = l.pop();
							map.put(c, map.getOrDefault(c, 0) - 1);
							if (map.get(c) <= 0) {
								map.remove(c);
							}
							start++;
						}
					}
					while (map.entrySet().size() >= 2) {
						Character c = l.pop();
						map.put(c, map.getOrDefault(c, 0) - 1);
						if (map.get(c) <= 0) {
							map.remove(c);
						}
						start++;
					}
					map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
				} else {
					map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
				}
			}
			end++;
			max = Math.max(max, end - start);
		}
		System.out.println(max);
	}
}
