package core.problems.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsConcatenationSubstring {

	public static void main(String[] args) {

		String[] ar = { "cat", "fox" };
		String s = "catcatfoxfox";
		findWordConcatenation(s, ar);

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < ar.length; i++) {
			map.put(ar[i], map.getOrDefault(ar[i], 0) + 1);
		}

		int count = 0;
		Map<Integer, String> wordsSeen = new HashMap<>();
		for (int i = 2; i <= s.length(); i++) {

			if (i % 3 != 0)
				continue;
			String temp = i < s.length() ? s.substring(i - 3, i) : s.substring(i - 3);
			if (map.containsKey(temp)) {
				count++;
				wordsSeen.put(count, temp);
			}
			if (wordsSeen.size() == map.size()) {
				//System.out.println(i - (map.size() * 3));
				wordsSeen.remove(count - 1);
			}
		}

	}

	public static List<Integer> findWordConcatenation(String str, String[] words) {
		List<Integer> resultIndices = new ArrayList<Integer>();
		String[] ar = words;
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < ar.length; i++) {
			map.put(ar[i], map.getOrDefault(ar[i], 0) + 1);
		}

		int count = 0;
		Map<Integer, String> wordsSeen = new HashMap<>();

		int wordLeng = words[0].length();

		int j = 0;
		System.out.println("String length = "+str.length());
		for (int i = wordLeng; i <= str.length(); i++) {

			String temp = str.substring(j, i);
			System.out.println(temp);
			if (map.containsKey(temp)) {
				wordsSeen.put(count, temp);
				if (wordsSeen.size() == map.size()) {
					resultIndices.add(i - (map.size() * wordLeng));
					System.out.println();
					wordsSeen.remove(count - (map.size() - 1));
				}
				j = i;
				i += 2;
				count++;
			} else {
				j++;
				wordsSeen.clear();

			}
			System.out.println("i = "+i+", j= "+j);
		}
		System.out.println(resultIndices);
		return resultIndices;
	}
}
