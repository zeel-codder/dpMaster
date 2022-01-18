import java.util.*;

// import javax.management.loading.MLet;
// import java.lang.*;
import java.io.*;

/**
 * @author zeel prajapati
 */
// public class Main{
final public class Solution {
    static int max = Integer.MAX_VALUE;
    static int min = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // LCS l=new LCS();
        // LCSubString l=new LCSubString();
        // Shortest_Common_SuperSequence l=new Shortest_Common_SuperSequence();
        // Minimum_Number_of_Insertion_and_Deletion l=new
        // Minimum_Number_of_Insertion_and_Deletion();
        // Longest_Palindromic_Subsequence l=new Longest_Palindromic_Subsequence();
        Minimum_number_of_deletion_in_a_string_to_make_it_a_palindrome l = new Minimum_number_of_deletion_in_a_string_to_make_it_a_palindrome();

        l.Sum();

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

class LCS {
    /**
     * 
     * Very Comman problem:
     * Give two string find there Longest Common Subsequences.
     */

    static int memo[][];

    public void Sum() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int n = a.length();
        int m = b.length();

        memo = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }

        }

        System.out.println(memo[n][m]);

        for (int arr[] : memo) {
            System.out.println(Arrays.toString(arr));
        }

        int i = n, j = m;

        String ans = "";

        while (i > 0 && j > 0) {

            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                ans = a.charAt(i - 1) + ans;
                i--;
                j--;
            } else {
                if (memo[i - 1][j] > memo[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }

        }

        System.out.println(ans);

    }
}

class LCSubString {
    /**
     * 
     * Very Comman problem:
     * Give two string find there Longest Common Subsequences.
     *
     * 
     * 
     */

    static int memo[][];

    public void Sum() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int n = a.length();
        int m = b.length();

        memo = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = 0;
                }
            }

        }

        System.out.println(memo[n][m]);

        for (int arr[] : memo) {
            System.out.println(Arrays.toString(arr));
        }

    }
}

class Shortest_Common_SuperSequence {

    /**
     * Problem: GIve two string find shortest common SuperSequence.
     * => mean find the shortest string which can include both a and b as
     * subSequence
     * 
     * ex:
     * a:zeel
     * b:pel
     * ans: zpeel
     * - --- ->zeel
     * -- - ->pel
     */

    int memo[][];

    public void Sum() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int n = a.length();
        int m = b.length();

        memo = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }

        }

        System.out.println(a.length() + b.length() - memo[n][m]);

        for (int arr[] : memo) {
            System.out.println(Arrays.toString(arr));
        }

        int i = n, j = m;

        String ans = "";

        while (i > 0 && j > 0) {

            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                ans = a.charAt(i - 1) + ans;
                i--;
                j--;
            } else {
                if (memo[i - 1][j] > memo[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }

        }

        String tem = "";
        int a1 = 0, a2 = 0;

        for (i = 0; i < ans.length(); i++) {

            while (a1 < a.length() && a.charAt(a1) != ans.charAt(i)) {
                tem = tem + a.charAt(a1);
                a1++;
            }
            while (a2 < b.length() && b.charAt(a2) != ans.charAt(i)) {
                tem = tem + b.charAt(a2);
                a2++;
            }

            tem = tem + ans.charAt(i);
            a1++;
            a2++;

        }
        while (a1 < a.length()) {
            tem = tem + a.charAt(a1);
            a1++;
        }
        while (a2 < b.length()) {
            tem = tem + b.charAt(a2);
            a2++;
        }

        System.out.println(ans);
        System.out.println(tem);

    }

}

class Minimum_Number_of_Insertion_and_Deletion {

    /**
     * 
     * Give two string a , b. find the minimum number of insertion and deletetion
     * for convert
     * a into b;
     * If we have replace function also than it is edit distance problem (-_-)
     */

    static int memo[][];

    public void Sum() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int n = a.length();
        int m = b.length();

        memo = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }

        }

        System.out.println("Deletions " + (a.length() - memo[n][m]) + " Insertions " + (b.length() - memo[n][m]));

        for (int arr[] : memo) {
            System.out.println(Arrays.toString(arr));
        }

    }

}

class Longest_Palindromic_Subsequence {

    /**
     * 
     * Give a string. find it's Longest_Palindromic_Subsequence;
     */

    static int memo[][];

    public void Sum() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = new StringBuffer(a).reverse().toString();

        int n = a.length();
        int m = b.length();

        memo = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }

        }

        System.out.println(memo[n][m]);

        for (int arr[] : memo) {
            System.out.println(Arrays.toString(arr));
        }

        int i = n, j = m;

        String ans = "";

        while (i > 0 && j > 0) {

            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                ans = a.charAt(i - 1) + ans;
                i--;
                j--;
            } else {
                if (memo[i - 1][j] >= memo[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }

        }

        System.out.println(ans);

    }

}

class Minimum_number_of_deletion_in_a_string_to_make_it_a_palindrome {

    static int memo[][];

    public void Sum() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = new StringBuffer(a).reverse().toString();

        int n = a.length();
        int m = b.length();

        memo = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }

        }

        System.out.println("Deletions " + (a.length() - memo[n][m]));

    }

}