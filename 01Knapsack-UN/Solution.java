import java.util.*;
import java.lang.*;
import java.io.*;
/**
* @author zeel prajapati
 */


 /***
  * Main Problem 
    01Knapsack Unbound
  * Sub Problem
  1. Road cutting problem
  */
// public class Main{
final public class Solution{
static int max=Integer.MAX_VALUE;
static int min=Integer.MIN_VALUE;
public static void main(String[] args)throws IOException{
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

//  _O1KnapsackUn sub=new _O1KnapsackUn();
// CountCoinChange sub=new CountCoinChange();
MinCountCoinChange sub=new MinCountCoinChange();
 sub.Sum();
 
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


class _O1KnapsackUn{

    static int memo[][];

    public void Sum() throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        
        int w[]=Solution.InputArr(br);
        int v[]=Solution.InputArr(br);
        
        int W=Integer.parseInt(br.readLine());

        memo=new int[n+1][W+1];

        for(int i=1;i<=n;i++){

            for(int j=1;j<=W;j++){
                memo[i][j]=-1;
            }

        }

        System.out.println(__01KnapsackUn(w, v, n, W));

        for(int a[]:memo){
         System.out.println(Arrays.toString(a));
        }

        memo=new int[n+1][W+1];

        for(int i=1;i<=n;i++){

            for(int j=1;j<=W;j++){
                memo[i][j]=-1;
            }

        }


        System.out.println(dp(w, v,  W));

        for(int a[]:memo){
         System.out.println(Arrays.toString(a));
        }




    }

    public static int __01KnapsackUn(int w[],int v[],int i,int W){

        if(memo[i][W]!=-1){
            return memo[i][W];
        }


        if(i==0 || W==0){
            memo[i][W]=0;
            return memo[i][W];
        }

        int ans=-1;

        if(W>=w[i-1]){
            ans=Math.max(__01KnapsackUn(w, v, i-1, W),v[i-1]+__01KnapsackUn(w,v,i,W-w[i-1]));
        }else{

            ans=__01KnapsackUn(w, v, i-1, W);

        }

        memo[i][W]=ans;

        return ans;

    }

    public static int dp(int w[],int v[],int W){
 
        int n=w.length;

        for(int i=1;i<=n;i++){

            for(int j=1;j<=W;j++){

                if(j>=w[i-1]){
                    memo[i][j]=Math.max(memo[i-1][j],v[i-1]+memo[i][j-w[i-1]]);
                }else{
                    memo[i][j]=memo[i-1][j];
                }
            }
        }


        return memo[n][W];

    }


    

    // public 
}

class RoadCutting extends _O1KnapsackUn{

    /**
     * problem:
     * given road of length n divide road in such way that you get max profit.
     * the length and profit arrays will given.
     * 
     * think:
     * is return all zero is ok or not
     */

}

class CountCoinChange{

    static int memo[][];

    public void Sum() throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        
        // int w[]=Solution.InputArr(br);
        int arr[]=Solution.InputArr(br);
        
        int W=Integer.parseInt(br.readLine());

        memo=new int[n+1][W+1];

        for(int i=0;i<=n;i++){

            for(int j=0;j<=W;j++){
                memo[i][j]=-1;
            }

        }

        System.out.println(CountCoinChange_R(arr, n, W));

        for(int a[]:memo){
         System.out.println(Arrays.toString(a));
        }

        memo=new int[n+1][W+1];

        for(int i=1;i<=n;i++){

            for(int j=1;j<=W;j++){
                memo[i][j]=-1;
            }

        }


        System.out.println(dp(arr,  W));

        for(int a[]:memo){
         System.out.println(Arrays.toString(a));
        }




    }

    public static int CountCoinChange_R(int arr[],int i,int W){

        if(memo[i][W]!=-1){
            return memo[i][W];
        }

        if(W==0){
            memo[i][W]=1;
            return 1;
        }

        
        if(i==0){
            memo[i][W]=0;
            return memo[i][W];
        }
        
        int ans=-1;
        
        
        if(W>=arr[i-1]){
            // System.out.println(W+" "+arr[i-1]);
            ans=CountCoinChange_R(arr,  i-1, W) + CountCoinChange_R( arr, i, W-arr[i-1]);
        }else{
            ans=CountCoinChange_R(arr, i-1, W);
        }

        memo[i][W]=ans;

        return ans;

    }

    public static int dp(int w[],int W){
 
        int n=w.length;

        for(int i=0;i<=n;i++){
            memo[i][0]=1;
        }

        for(int i=1;i<=n;i++){

            for(int j=1;j<=W;j++){

                if(j>=w[i-1]){
                    memo[i][j]=memo[i-1][j] + memo[i][j-w[i-1]];
                }else{
                    memo[i][j]=memo[i-1][j];
                }
            }
        }


        return memo[n][W];

    }

}


class MinCountCoinChange{

    static int memo[][];

    public void Sum() throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        
        // int w[]=Solution.InputArr(br);
        int arr[]=Solution.InputArr(br);
        
        int W=Integer.parseInt(br.readLine());

        memo=new int[n+1][W+1];

        for(int i=0;i<=n;i++){

            for(int j=0;j<=W;j++){
                memo[i][j]=-1;
            }

        }

        System.out.println(MinCountCoinChange_R(arr, n, W));

        for(int a[]:memo){
         System.out.println(Arrays.toString(a));
        }

        memo=new int[n+1][W+1];

        for(int i=1;i<=n;i++){

            for(int j=1;j<=W;j++){
                memo[i][j]=-1;
            }

        }


        System.out.println(dp(arr,  W));

        for(int a[]:memo){
         System.out.println(Arrays.toString(a));
        }




    }

    public static int MinCountCoinChange_R(int arr[],int i,int W){

        if(memo[i][W]!=-1){
            return memo[i][W];
        }

        
        if(i==0 && W!=0){
            memo[i][W]=10000000;
            return memo[i][W];
        }
        if(W==0){
            memo[i][W]=0;
            return memo[i][W];
        }
        
        int ans=-1;
        
        
        if(W>=arr[i-1]){
            // System.out.println(W+" "+arr[i-1]);
            ans=Math.min(MinCountCoinChange_R(arr,  i-1, W) ,1+ MinCountCoinChange_R( arr, i, W-arr[i-1]));
        }else{
            ans=MinCountCoinChange_R(arr, i-1, W);
        }

        memo[i][W]=ans;

        return ans;

    }
    public static int dp(int w[],int W){
        // "z".length()
 
        int n=w.length;

        for(int i=0;i<=n;i++){
            memo[i][0]=0;
        }

        for(int i=1;i<=W;i++){
            memo[0][i]=1000000;
            
            if(i%w[0]==0){
                memo[1][i]=i/w[0];
            }else{
                
                memo[0][i]=1000000;
            }

        }

        
        for(int i=1;i<=n;i++){

            for(int j=1;j<=W;j++){

                if(j>=w[i-1]){
                    memo[i][j]=Math.min(memo[i-1][j],1 + memo[i][j-w[i-1]]);
                }else{
                    memo[i][j]=memo[i-1][j];
                }
            }
        }


        return memo[n][W];

    }

}