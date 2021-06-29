package core.dailyproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class TopNWords {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("aa");
		list.add("aaa");
		
		
		Map<String,Word> map = new HashMap<>();
		Queue<Word> q = new PriorityQueue<Word>((w1,w2)-> w2.getFreq()!=w1.getFreq()?w2.getFreq()-w1.getFreq():w1.getW().compareTo(w2.getW()));
		List<String> outputList = new ArrayList<>();
		int n = 2;
		for(String w:list){
			Word w1 = null;
			if(map.containsKey(w)){
				w1 = map.get(w);
				w1.setFreq(w1.getFreq()+1);
				q.remove(w1);
			}
			else {
				w1 = new Word();
				w1.setW(w);
				w1.setFreq(1);
				map.put(w, w1);
			}
			q.add(w1);
		}
		int i=0;
		while(i<n && !q.isEmpty()){
			outputList.add(q.poll().getW());
			i++;
		}
		
		//M+N(log(n));
		
		System.out.println(outputList);
	}
}
class Word{
	String w;
	Integer freq;
	public String getW() {
		return w;
	}
	public void setW(String w) {
		this.w = w;
	}
	public Integer getFreq() {
		return freq;
	}
	public void setFreq(Integer freq) {
		this.freq = freq;
	}
	
	
}