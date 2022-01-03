import java.util.*;
import java.lang.*;
import java.io.*;
/**
* @author zeel prajapati
 */
// public class Main{
final public class Solution{
static int max=Integer.MAX_VALUE;
static int min=Integer.MIN_VALUE;
public static void main(String[] args)throws IOException{
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 int t=Integer.parseInt(br.readLine());
 while(t-->0){
 }
}


public static int[] InputArr(BufferedReader br){
    try{
    String s=br.readLine();
    String d[]=s.split(Character.toString(' '));
    int n=d.length;
    
    int arr[]=new int[n];
    for(int i=0;i<n;i++){
        arr[i]=Integer.parseInt(d[i]);
    }
        return arr;
    }catch(IOException e){
     System.out.println(1); 
    }
    return new int[1];
}

public static void printarr(int arr[]){
    StringBuffer br=new StringBuffer();
    for(int i=0;i<arr.length;i++){
        br.append(arr[i]+Character.toString(' '));
    }
    System.out.println(br);
}
}
class Node{
int i,j,value;
Node(int i,int j,int v){
this.i=i;
this.j=j;
this.value=v;
}
}
class com implements Comparator<Integer>{
@Override
public int compare(Integer arg0, Integer arg1) {
return arg1-arg0;
}
}