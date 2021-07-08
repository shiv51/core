package core.problems.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

	public static void main(String[] args) {
		//List<String> l =  Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		//String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		List<String> l =  Arrays.asList("cats","dog","sand","and","cat","an");
		String s = "catsandogcat";
		Map<Character,List<String>> map = new HashMap<>();
		Map<String,Boolean> resultMap = new HashMap<>();
		l.sort((a1,a2)->a1.length()-a2.length());
		for(String str:l){
			if(!map.containsKey(str.charAt(0))){
				List<String> l1 =  new ArrayList<>();
				l1.add(str);
				map.put(str.charAt(0), l1);
			}
			else{
				map.get(str.charAt(0)).add(str);
			}
		}
		System.out.println(check(map, s, 0, resultMap));
	}

	private static boolean isPossible(Map<Character, List<String>> map, String s,int index, Map<String, Boolean> resultMap,String picked) {
		boolean flag = false;
		if(map.containsKey(picked+index)){
			return resultMap.get(picked+index);
		}
		if(index>=s.length())
			return true;
		if(map.containsKey(s.charAt(index))) {
			List<String> l2 = map.get(s.charAt(index));
			for(int i=0;i<l2.size();i++){
				int newIndex = index+l2.get(i).length();
				if(newIndex>s.length())
					continue;
				String temp = s.substring(index, newIndex);
				String newSubString = s.substring(index+l2.get(i).length());
				System.out.println("Comparing = "+temp+", new index = "+newIndex+", newSubString = "+newSubString+", picked = "+l2.get(i));
				if(l2.get(i).equals(s.substring(index, index+l2.get(i).length()))){
					if(map.containsKey(l2.get(i)+newIndex)){
						flag =  resultMap.get(l2.get(i)+newIndex);
					}
					else{
						flag =  isPossible(map, s, newIndex,resultMap,l2.get(i));
						resultMap.put(l2.get(i)+newIndex, flag);
						
					}
					if(flag)
						break;
				}
				else{
					continue;
				}
			}
		}
		return flag;
	}
	
	
	private static boolean isPossible1(Map<Character, List<String>> map, String s,int index, Map<String, Boolean> resultMap) {
		System.out.println(" String = "+s+" index = "+index);
		if(resultMap.containsKey(s+index)){
			return resultMap.get(s+index);
		}
		boolean flag = false;
		if(index>=s.length())
			return true;
		if(map.containsKey(s.charAt(index))) {
			List<String> l2 = map.get(s.charAt(index));
			for(int i=0;i<l2.size();i++){
				int newIndex = index+l2.get(i).length();
				System.out.println("Comparision with = "+l2.get(i)+" new Index = "+newIndex);
				if(newIndex>s.length())
					continue;
				String temp = s.substring(index, newIndex);
				String newSubString = s.substring(newIndex);
				//System.out.println("Comparing = "+temp+", new index = "+newIndex+", newSubString = "+newSubString+", picked = "+l2.get(i));
				if(l2.get(i).equals(s.substring(index, index+l2.get(i).length()))){
						flag =  isPossible1(map, newSubString, 0,resultMap);
					if(flag)
						break;
				}
				else{
					continue;
				}
			}
			resultMap.put(s+index,flag);
			System.out.println("Result of "+s+" with index = "+index+" is "+ flag);
		}
		return flag;
	}
	
	private static boolean check(Map<Character, List<String>> map, String s, int index, Map<String, Boolean> resultMap) {
		if(resultMap.containsKey(s+index)){
			return resultMap.get(s+index);
		}
		boolean flag = false;
		if(index>=s.length())
			return true;
		if(map.containsKey(s.charAt(index))) {
			List<String> list = map.get(s.charAt(index));
			for(int i=0;i<list.size();i++){
				int newIndex = index+list.get(i).length();
				if(newIndex>s.length())
					break;
				String newSubString = s.substring(newIndex);
				if(list.get(i).equals(s.substring(index, index+list.get(i).length()))){
					flag =  check(map, newSubString, 0,resultMap);
					if(flag)
						break;
				}
				else{
					continue;
				}
			}
			resultMap.put(s+index,flag);
		}
		return flag;
	}
	
	public static boolean check(String s, List<String> l){
		if(s.length()==0){
			return true;
		}
		for(int i=0;i<s.length();i++){
			if(l.contains(s.subSequence(0, i)) && check( s.substring(i),l)){
				return true;
			}
		}
		return false;
	}
	
	public boolean dfs(int ind, String s, boolean[] vis, List<String> wordSet)
    {
        int n = s.length();
        if (ind == n)  return true;        
        if (vis[ind])  return false;
        vis[ind] =  true;
        for(String t:wordSet)
        {
            if(s.startsWith(t,ind))
            {
                if(dfs(ind+t.length(),s,vis,wordSet))
                    return true;
            }
        }          
      return false;   
    }                
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[]  vis = new boolean[n];
        return dfs(0,s,vis,wordDict);
            
    }
    
}
