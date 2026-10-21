import java.util.*;
public class Rotate {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int k=2;
        int first=arr[0];
        int c=0;
        while(c!=k){
            for(int i=1;i<arr.length;i++){
                arr[i-1]=arr[i];
                if(i==arr.length-1){
                    arr[arr.length-1]=first;
                    first=arr[0];
                }
            }
            c++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
