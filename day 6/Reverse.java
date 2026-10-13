import java.util.*;
public class Reverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        char[] arr=str.toCharArray();
        Arrays.sort(arr);
        String w="";
        for(int i=0;i<arr.length;i++){
            w+=arr[i];
        }
        String input=sc.next();
        char[] arr1=str.toCharArray();
        Arrays.sort(arr1);
        String w1="";
        if(input.length()!=str.length()){
            System.out.println("Not anagram");
            return;
        }
        for(int i=0;i<arr1.length;i++){
            w1+=arr1[i];
        }
        if(w.equals(w1)){
            System.out.println("Anagram");
            return;
        }
        System.out.println("not anagram");
    }
}
