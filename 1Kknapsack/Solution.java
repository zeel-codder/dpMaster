import java.util.*;
import java.io.*;
import java.lang.Character.Subset;

/**
 * @author zeel prajapati
 */

 /***
  * Main Problem 
    01Knapsack
  * Sub Problem
    1.SubSet Sum (class SubSetSum)
    2.Equal Sum Partition  (class EqualSumPartition)
    3.Count SubSet With Given Sum (class CountSubSetWithGivenSum)
    4.Minimum Subset Sum Difference (class MinimumSubsetSumDifference)
    5.Count the number of subset with a given difference (class CountTheNumberOfSubsetWithAGivenDifference)
    6.Target Sum (class TargetSum)
  */


final public class Solution {
    static int max = Integer.MAX_VALUE;
    static int min = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        // _01Knapsack sub = new _01Knapsack();
        // SubSetSum sub=new SubSetSum();
        // EqualSumPartition sub=new EqualSumPartition();
        // CountSubSetWithGivenSum sub=new CountSubSetWithGivenSum();
        // MinimumSubsetSumDifference sub=new MinimumSubsetSumDifference();
        // CountTheNumberOfSubsetWithAGivenDifference sub=new CountTheNumberOfSubsetWithAGivenDifference();
        TargetSum sub=new TargetSum();    
        sub.Sum();
    }

    public static int[] InputArr(BufferedReader br) {
        try {
            String s = br.readLine();
            String d[] = s.split(Character.toString(' '));
            int n = d.length;

            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(d[i]);
            }
            return arr;
        } catch (IOException e) {
            System.out.println(1);
        }
        return new int[1];
    }

    public static void printarr(int arr[]) {
        StringBuffer br = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            br.append(arr[i] + Character.toString(' '));
        }
        System.out.println(br);
    }
}

class Node {
    int i, j, value;

    Node(int i, int j, int v) {
        this.i = i;
        this.j = j;
        this.value = v;
    }
}

class com implements Comparator<Integer> {
    @Override
    public int compare(Integer arg0, Integer arg1) {
        return arg1 - arg0;
    }
}

class TargetSum extends CountTheNumberOfSubsetWithAGivenDifference{

     /**
         * Problem
         * Given: Input array 
         *        int sum
         *        give + - sign to value of array and make sum = sum
         */

}

class CountTheNumberOfSubsetWithAGivenDifference extends CountSubSetWithGivenSum{

       /**
         * Problem
         * Given: Input array 
         *        Count Number of sb set with given diff
         *        count (s1-s2--diff)
         */
    
        public void Sum() throws IOException {
    
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int arr[] = Solution.InputArr(br);

            int diff=Integer.parseInt(br.readLine());
            
            int sum = 0;

            for(int i=0;i<n;i++) sum+=arr[i];

            int total=sum;

        
            sum=sum/2;

            memo = new int[n + 1][sum + 1];

            for(int i=0;i<n+1;i++){
                for(int j=0;j<sum+1;j++){
                    memo[i][j]=-1;
                }
            }

            // hear we have to find for all sum

            for(int i=sum;i>=0;i--){
                // System.out.println(i);
                RSubSet(arr, n, i);
            }
    
            // System.out.println();
    
            for (int a[] : memo) {
    
                System.out.println(Arrays.toString(a));
            }

            int ans=0;


            for(int i=sum;i>=0;i--){

                if(memo[n][i]>=1){
                    if((total-2*i)==diff){
                        ans=ans+memo[n][i];
                    }
                    
                }
            }
            System.out.println("Ans "+ans);

    
            memo = new int[n + 1][sum + 1];

            for(int i=0;i<n+1;i++){
                for(int j=0;j<sum+1;j++){
                    memo[i][j]=-1;
                }
            }
    
            System.out.println(dp(arr, n, sum));
    
            for (int a[] : memo) {
    
                System.out.println(Arrays.toString(a));
            }
            ans=0;

            for(int i=sum;i>=0;i--){

                if(memo[n][i]>=1){
                    if((total-2*i)==diff){
                        ans=ans+memo[n][i];
                    }
                    
                }
            }
            System.out.println("Ans= "+ans);

          
        
        }

}

class MinimumSubsetSumDifference extends SubSetSum{

       /**
         * Problem
         * Given: Input array 
         *        Find MinDistans dub set let say s1 is sum of first set and s2 is sum of secound set.
         *        than find min(s1-s2)
         */
    
        public void Sum() throws IOException {
    
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int arr[] = Solution.InputArr(br);
            
            int sum = 0;

            for(int i=0;i<n;i++) sum+=arr[i];

            int total=sum;

        
            sum=sum/2;

            memo = new int[n + 1][sum + 1];

            for(int i=0;i<n+1;i++){
                for(int j=0;j<sum+1;j++){
                    memo[i][j]=-1;
                }
            }
    
            System.out.println(RSubSet(arr, n, sum));
    
            for (int a[] : memo) {
    
                System.out.println(Arrays.toString(a));
            }

            int ans=-1;


            for(int i=sum;i>=0;i--){

                if(memo[n][i]==1){
                    ans=Math.abs(i-(total-i));
                    break;
                }
            }
            System.out.println("Ans "+ans);

    
            memo = new int[n + 1][sum + 1];

            for(int i=0;i<n+1;i++){
                for(int j=0;j<sum+1;j++){
                    memo[i][j]=-1;
                }
            }
    
            System.out.println(dp(arr, n, sum));
    
            for (int a[] : memo) {
    
                System.out.println(Arrays.toString(a));
            }

            for(int i=sum;i>=0;i--){

                if(memo[n][i]==1){
                    ans=Math.abs(i-(total-i));
                    break;
                }
            }
            System.out.println("Ans= "+ans);

            if(memo[n][sum]==1){

                
                int i = n, j = sum;
                
                while (i > 0 && j > 0) {
                    
                    if (j >= arr[i - 1]) {
    
                    if (memo[i - 1][j - arr[i - 1]]==1) {
                        System.out.print(arr[i-1] + " ");
                        j = j - arr[i - 1];
                    }
                    i--;
                    
                } else {
                    i--;
                }
            }
        }
        }

    

}

class CountSubSetWithGivenSum{


        /**
         * Problem
         * Given: Input array and target sum.
         *        Find Count of SubSet With Given Sum
         * 
         * 
         */
    
        static int memo[][];
    
        public void Sum() throws IOException {
    
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int arr[] = Solution.InputArr(br);
            
            int sum = Integer.parseInt(br.readLine());
            memo = new int[n + 1][sum + 1];

            for(int i=0;i<n+1;i++){
                for(int j=0;j<sum+1;j++){
                    memo[i][j]=-1;
                }
            }
    
            System.out.println(RSubSet(arr, n, sum));
    
            for (int a[] : memo) {
    
                System.out.println(Arrays.toString(a));
            }
    
            memo = new int[n + 1][sum + 1];

            for(int i=0;i<n+1;i++){
                for(int j=0;j<sum+1;j++){
                    memo[i][j]=-1;
                }
            }
    
            System.out.println(dp(arr, n, sum));
    
            for (int a[] : memo) {
    
                System.out.println(Arrays.toString(a));
            }

            // if(memo[n][sum]==1){

                
            //     int i = n, j = sum;
                
            //     while (i > 0 && j > 0) {
                    
            //         if (j >= arr[i - 1]) {
    
            //         if (memo[i - 1][j - arr[i - 1]]==1) {
            //             System.out.print(i + " ");
            //             j = j - arr[i - 1];
            //         }
            //         i--;
                    
            //     } else {
            //         i--;
            //     }
            // }
        // }
    
          
    
        }
    
        public static int dp(int arr[], int n, int sum) {

            
    
            for (int i = 0; i < n + 1; i++) {
                
                memo[i][0] = 1;
            }
    
            for (int j = 1; j < sum + 1; j++) {
                memo[0][j] = 0;
            }
    
            for (int i = 1; i < n + 1; i++) {
    
                for (int j = 1; j < sum + 1; j++) {
    
                    if (j >= arr[i - 1]) {
    
                        memo[i][j] = memo[i - 1][j] + memo[i - 1][j - arr[i - 1]];
    
                    } else {
                        memo[i][j] = memo[i - 1][j];
                    }
                }
            }
    
            return memo[n][sum];
    
        }
    
        public static int RSubSet(int arr[],  int n, int sum) {
    
            if (memo[n][sum] != -1)
                return memo[n][sum];
    
            // if(n==0 || W==0){
            // return 0;
            // }

            if(sum==0){
                memo[n][sum]=1;
                return memo[n][sum];
            }

            if (n == 0) {
                memo[n][sum]= 0;
                return memo[n][sum];
            }

    
            if (sum >= arr[n - 1]) {
    
                memo[n][sum] = RSubSet(arr, n - 1,sum)+RSubSet(arr, n - 1, sum-arr[n-1]);
    
            } else
                memo[n][sum] = RSubSet(arr, n - 1,sum);
    
            return memo[n][sum];
        }
    

}

class EqualSumPartition extends SubSetSum{

    /**
         * Problem
         * Given: Input array 
         *        Find is we can divid array into two same partision or not
         */
    
        public void Sum() throws IOException {
    
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int arr[] = Solution.InputArr(br);
            
            int sum = 0;

            for(int i=0;i<n;i++) sum+=arr[i];

            if(sum%2!=0) System.out.println("0");

            sum=sum/2;

            memo = new int[n + 1][sum + 1];

            for(int i=0;i<n+1;i++){
                for(int j=0;j<sum+1;j++){
                    memo[i][j]=-1;
                }
            }
    
            System.out.println(RSubSet(arr, n, sum));
    
            for (int a[] : memo) {
    
                System.out.println(Arrays.toString(a));
            }
    
            memo = new int[n + 1][sum + 1];

            for(int i=0;i<n+1;i++){
                for(int j=0;j<sum+1;j++){
                    memo[i][j]=-1;
                }
            }
    
            System.out.println(dp(arr, n, sum));
    
            for (int a[] : memo) {
    
                System.out.println(Arrays.toString(a));
            }

            if(memo[n][sum]==1){

                
                int i = n, j = sum;
                
                while (i > 0 && j > 0) {
                    
                    if (j >= arr[i - 1]) {
    
                    if (memo[i - 1][j - arr[i - 1]]==1) {
                        System.out.print(i + " ");
                        j = j - arr[i - 1];
                    }
                    i--;
                    
                } else {
                    i--;
                }
            }
        }
        }

}

class SubSetSum{


        /**
         * Problem
         * Given: Input array and target sum.
         *        Find is there exits sub set which sum is equals to target sum;
         * 
         * 
         */
    
        static int memo[][];
    
        public void Sum() throws IOException {
    
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int arr[] = Solution.InputArr(br);
            
            int sum = Integer.parseInt(br.readLine());
            memo = new int[n + 1][sum + 1];

            for(int i=0;i<n+1;i++){
                for(int j=0;j<sum+1;j++){
                    memo[i][j]=-1;
                }
            }
    
            System.out.println(RSubSet(arr, n, sum));
    
            for (int a[] : memo) {
    
                System.out.println(Arrays.toString(a));
            }
    
            memo = new int[n + 1][sum + 1];

            for(int i=0;i<n+1;i++){
                for(int j=0;j<sum+1;j++){
                    memo[i][j]=-1;
                }
            }
    
            System.out.println(dp(arr, n, sum));
    
            for (int a[] : memo) {
    
                System.out.println(Arrays.toString(a));
            }

            if(memo[n][sum]==1){

                
                int i = n, j = sum;
                
                while (i > 0 && j > 0) {
                    
                    if (j >= arr[i - 1]) {
    
                    if (memo[i - 1][j - arr[i - 1]]==1) {
                        System.out.print(i + " ");
                        j = j - arr[i - 1];
                    }
                    i--;
                    
                } else {
                    i--;
                }
            }
        }
    
          
    
        }
    
        public static int dp(int arr[], int n, int sum) {

            
    
            for (int i = 0; i < n + 1; i++) {
                
                memo[i][0] = 1;
            }
    
            for (int j = 1; j < sum + 1; j++) {
                memo[0][j] = 0;
            }
    
            for (int i = 1; i < n + 1; i++) {
    
                for (int j = 1; j < sum + 1; j++) {
    
                    if (j >= arr[i - 1]) {
    
                        memo[i][j] = Math.max(memo[i - 1][j],  memo[i - 1][j - arr[i - 1]]);
    
                    } else {
                        memo[i][j] = memo[i - 1][j];
                    }
                }
            }
    
            return memo[n][sum];
    
        }
    
        public static int RSubSet(int arr[],  int n, int sum) {
    
            if (memo[n][sum] != -1)
                return memo[n][sum];
    
            // if(n==0 || W==0){
            // return 0;
            // }

            if(sum==0){
                memo[n][sum]=1;
                return memo[n][sum];
            }

            if (n == 0) {
                memo[n][sum]= 0;
                return memo[n][sum];
            }

    
            if (sum >= arr[n - 1]) {
    
                memo[n][sum] = Math.max(RSubSet(arr, n - 1,sum),  RSubSet(arr, n - 1, sum-arr[n-1]));
    
            } else
                memo[n][sum] = RSubSet(arr, n - 1,sum);
    
            return memo[n][sum];
        }
    
    
}

class _01Knapsack {


    /**
     * Notes
     * 
     * 1. In problem is array of value is given
     * 2. we can take value our not
     * 3. we have to find max min sum out set
     * 
     * In above three condition we can think that problem can be solved by 0/1
     * Knapsack(-_-)
     * 6 similar problem are code in this folder
     */

    static int memo[][];

    public void Sum() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int w[] = Solution.InputArr(br);
        int v[] = Solution.InputArr(br);

        int W = Integer.parseInt(br.readLine());
        memo = new int[n + 1][W + 1];

        System.out.println(RKnapsack(w, v, n, W));

        for (int a[] : memo) {

            System.out.println(Arrays.toString(a));
        }

        memo = new int[n + 1][W + 1];

        System.out.println(dp(w, v, n, W));

        for (int a[] : memo) {

            System.out.println(Arrays.toString(a));
        }

        // printing the ans

        int i = n, j = W;

        while (i > 0 && j > 0) {

            if (j >= w[i - 1]) {

                if (memo[i - 1][j] < v[i - 1] + memo[i - 1][j - w[i - 1]]) {
                    System.out.print(i + " ");
                    j = j - w[i - 1];
                }
                i--;

            } else {
                i--;
            }
        }

    }

    public static int dp(int w[], int v[], int n, int W) {

        for (int i = 0; i < n + 1; i++) {
            memo[i][0] = 0;
        }

        for (int j = 0; j < W + 1; j++) {
            memo[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {

            for (int j = 1; j < W + 1; j++) {

                if (j >= w[i - 1]) {

                    memo[i][j] = Math.max(memo[i - 1][j], v[i - 1] + memo[i - 1][j - w[i - 1]]);

                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }

        return memo[n][W];

    }

    public static int RKnapsack(int w[], int v[], int n, int W) {

        if (memo[n][W] != 0)
            return memo[n][W];

        // if(n==0 || W==0){
        // return 0;
        // }

        if (n == 0 || W == 0) {
            memo[n][W] = 0;
            return memo[n][W];
        }

        if (W >= w[n - 1]) {

            memo[n][W] = Math.max(RKnapsack(w, v, n - 1, W), v[n - 1] + RKnapsack(w, v, n - 1, W - w[n - 1]));

        } else
            memo[n][W] = RKnapsack(w, v, n - 1, W);

        return memo[n][W];
    }

}