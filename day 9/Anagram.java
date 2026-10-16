import java.util.*;
class Anagram{
	public static void main(String[] args){
		String a="dormitory";
		String b="dirty room";
		HashMap<Character,Integer> map=new HashMap<>();
		for(int i=0;i<a.length();i++){
			char ch=a.charAt(i);
			if(ch!=' '){
				map.put(ch,map.getOrDefault(ch,0)+1);
			}
		}
		for(int i=0;i<b.length();i++){
			char ch=b.charAt(i);
			if(ch==' ')continue;
			if(!map.containsKey(ch))System.out.println("Not an anagram"); return ;
			map.put(ch,map.get(ch)-1);
				
			
			if(map.get(ch)==0){
				map.remove(ch);
			}
		}
		if(map.size()>0)System.out.println("Not an anagram"); return ;
		System.out.println("It is an anagram");
	}
}