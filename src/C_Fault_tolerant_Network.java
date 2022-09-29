import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C_Fault_tolerant_Network {
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
        Integer cases = fs.nextInt();

        for(int i = 0; i < cases; i++){

            int n = fs.nextInt();
            long[] arr1 = fs.getArr(n);
            long[] arr2 = fs.getArr(n);
            long a0 = Long.MAX_VALUE;
            long an = Long.MAX_VALUE;
            long b0 = Long.MAX_VALUE;
            long bn = Long.MAX_VALUE;
            for(int j = 0; j < n; j++){
                a0 = Math.min(a0,Math.abs(arr1[0]-arr2[j]));
            }
            for(int j = 0; j < n; j++){
                an = Math.min(an,Math.abs(arr1[n-1]-arr2[j]));
            }
            for(int j = 0; j < n; j++){
                b0 = Math.min(b0,Math.abs(arr2[0]-arr1[j]));
            }
            for(int j = 0; j < n; j++){
                bn = Math.min(bn,Math.abs(arr2[n-1]-arr1[j]));
            }
            List<Long> list = new ArrayList<>();
            list.add(Math.abs(arr1[0] - arr2[0]) + Math.abs(arr1[n-1] - arr2[n-1]));
            list.add(Math.abs(arr1[0] - arr2[0]) + an + bn);
            list.add(Math.abs(an+bn+a0+b0));
            list.add(Math.abs(arr1[0] - arr2[n-1]) + an + b0);
            list.add(Math.abs(arr1[n-1] - arr2[0]) + a0 + bn);
            list.add(Math.abs(arr1[n-1] - arr2[n-1])+a0+b0);
            list.add(Math.abs(arr1[0] - arr2[n-1]) + Math.abs(arr1[n-1] - arr2[0]));
            Collections.sort(list);
                System.out.println(list.get(0));


        }
    }

    public static long find(HashSet<Long> hs, long c){
        long res = Integer.MAX_VALUE;
        for(Long d : hs){
            if(Math.abs(c - d) < res){
                res = Math.abs(c-d);
            }
        }
        //System.out.println(res);
        return res;
    }
}
