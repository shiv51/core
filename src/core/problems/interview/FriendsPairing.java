	package core.problems.interview;
	
	import java.util.ArrayList;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.Queue;
	
	public class FriendsPairing {
	
		public static void main(String[] args) {
			int[] input = { 1, 2, 3 };
			List<Integer> list1 = new ArrayList<Integer>();
			Queue<List<Integer>> q = new LinkedList<List<Integer>>();
			q.add(list1);
			List<Integer> intial = new ArrayList<Integer>();
			Queue<List<List<Integer>>> listTemp = new LinkedList<List<List<Integer>>>();
			List<List<Integer>> l11 = new ArrayList<List<Integer>>();
			l11.add(list1);
			listTemp.add(l11);
			pair(input, null, listTemp);
	
		}
	
		public static void pair(int[] input, List<Integer> pair, Queue<List<List<Integer>>> output) {
			for (int i = 0; i < input.length; i++) {
				int size = output.size();
				for (int y = 0; y < size; y++) {
					List<List<Integer>> list = output.poll();
					List<List<Integer>> justAddList = new ArrayList<List<Integer>>(list);
					List<Integer> list2 = new ArrayList<Integer>();
					if (!justAddList.get(0).isEmpty()) {
						list2.add(input[i]);
						justAddList.add(list2);
						output.add(justAddList);
					}
					for (int x = 0; x < list.size(); x++) {
						List<List<Integer>> listTemp1 = new ArrayList<List<Integer>>(list);
						List<Integer> list1 = new ArrayList<Integer>(list.get(x));
						if (list1.isEmpty()) {
							list1.add(input[i]);
							listTemp1.add(list1);
							listTemp1.remove(0);
							output.add(listTemp1);
							continue;
						}
	
						if (list1.size() == 1) {
							list1.add(input[i]);
							listTemp1.remove(list.get(x));
							listTemp1.add(list1);
							if (!output.contains(listTemp1))
								output.add(listTemp1);
						}
						
						
					}
				}
				System.out.println(output);
			}
		}
	
	}
