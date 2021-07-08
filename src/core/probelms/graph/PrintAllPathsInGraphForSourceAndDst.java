package core.probelms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;

public class PrintAllPathsInGraphForSourceAndDst {

	public static int count = 0;
	public static void main(String[] args) {
		Graph g = new Graph(5);
		int target = 4;
		g.addEdge(1,2,1);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 4, 1);
		g.addEdge(4, 5, 1);
		g.addEdge(5, 1, 3);
		g.addEdge(1, 3, 2);
		g.addEdge(5, 3, 1);
		
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> ll = new ArrayList<>();
		recur1(g, 1, list, ll, target);
		/*System.out.println(ll);
		System.out.println("--------------");
		int min = Integer.MAX_VALUE;
		int[][] a = g.getL();
		for(List<Integer> temp:ll){
			int tempSum =0;
			for(int i=0;i<=temp.size()-2;i++){
				tempSum = a[temp.get(i)][temp.get(i+1)]+tempSum;
			}
			if(tempSum<=min){
				System.out.println(temp+" -> "+tempSum);
				list = temp;
			}
			min = Math.min(tempSum, min);
		}
		System.out.println(list);
		System.out.println("---------------");
		System.err.println(count);*/
	}
	
	public static void recur(Graph g, int node,List<Integer> l,  List<List<Integer>> ll, int target){
		count++;
		if(!l.contains(node) &&node == target ){
			l.add(node);
			ll.add(new ArrayList<>(l));
			l.remove(l.size()-1);
		}
		else{
			l.add(node);
			List<Integer> list = g.map.get(node);
			list.removeAll(l);
			for(int i=0;i<list.size();i++){
				int x = list.get(i);
				recur(g, x, l, ll, target);
			}
			l.remove(l.size()-1);
		}
	}
	
	public static void recur1(Graph g,int node,List<Integer> vistedList,  List<List<Integer>> possiblePaths, int target){
		if(!vistedList.contains(node) && node == target ){
			vistedList.add(node);
			possiblePaths.add(new ArrayList<>(vistedList));
		}
		else{
			vistedList.add(node);
			List<Integer> list = g.map.get(node);
			list.removeAll(vistedList);
			for(int i=0;i<list.size();i++){
				int x = list.get(i);
				recur1(g, x, vistedList, possiblePaths, target);
			}
		}
		vistedList.remove(vistedList.size()-1);
	}
}
class Graph{
	
	int vertices;
	Map<Integer,List<Integer>> map;
	int[][] l;
	
	Graph(int v){
		this.vertices = v;
		map= new HashMap<Integer, List<Integer>>();
		l = new int[v+1][v+1];
		for(int i=1;i<=v;i++){
			map.put(i, new ArrayList());
		}
	}
	
	public void addEdge(int a, int b, int w){
		map.get(a).add(b);
		map.get(b).add(a);
		l[a][b] = w;
		l[b][a] = w;
	}

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public Map<Integer, List<Integer>> getMap() {
		return map;
	}

	public void setMap(Map<Integer, List<Integer>> map) {
		this.map = map;
	}

	public int[][] getL() {
		return l;
	}

	public void setL(int[][] l) {
		this.l = l;
	}
	
	
	
}
