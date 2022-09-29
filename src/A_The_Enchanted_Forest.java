import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_The_Enchanted_Forest {
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {}
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        long[] getArr(int n) {
            long[] res = new long[n];
            for(int i = 0; i < n; i++){
                res[i] = Long.parseLong(next());
            }
            return res;
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        Integer t = fs.nextInt();
        for(int i = 0; i < t; i++){
            Integer len = fs.nextInt();
            Integer k = fs.nextInt();
            int[] arr = new int[len];
            for(int j = 0; j < len; j++){
                Integer a = fs.nextInt();
                arr[j] = a;
            }
            if(arr.length != 1){
                solve(arr,k);
            }
            else{
                long res = (long)(k-1) + (long)arr[0];
                System.out.println(res);
            }
        }
    }

    public static void solve(int[] arr, int k){
        int n = arr.length;
        if(k > n-1){
            int left = k % (n-1);
            int count = 0;
            int total = 0;
            int[] got = new int[n];
            long res = 0l;
            for(int c : arr){
                res += (long) c;
            }
            int cur = 1;
            boolean minus = true;
            if(left == 0){
                left= n-1;
            }
            while(count < n && total < k){
                left -= minus? 1 : -1;
                long add = (long)cur - (long)got[left];
                if(got[left] == 0){
                    add -= 1l;
                    count += 1;
                }
                //  System.out.println(add+" "+left);
                got[left] = cur;
                res += add;
                cur += 1;
                total += 1;
                if(left == 0){
                    minus = false;
                }
                if(left == n){
                    minus = true;
                }
                //   System.out.println(res+" "+count+" "+left);
            }
            int v = (k - total)/(n-1);
            res += v > 0? (long)(n-1) * (long)n * (long)v:0l;
            System.out.println(res);
        }
        else{
            long cur = 0l;
            for(int i = 0; i < k; i++){
                cur += (long) arr[i];
            }
            long max = cur;
            for(int i = k; i < n; i++){
                cur += (long) arr[i];
                cur -= (long) arr[i-k];
                max = Math.max(max,cur);
            }
            long res = max + (long)k*(long)(k-1)/2;
            System.out.println(res);
        }
    }
}
