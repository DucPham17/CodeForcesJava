import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_And_Matching {
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
            Integer n = fs.nextInt();
            Integer k = fs.nextInt();
            if(k == 0){
                boolean[] cache = new boolean[n];
                for(int j = 0; j < n; j++){
                    if(!cache[j]) {
                        System.out.println(j + " " + (j ^ (n - 1)));
                        cache[j] = true;
                        cache[j ^ (n - 1)] = true;
                    }
                }
            }
            else if(k >= 1 && k < n-1){
                boolean[] cache = new boolean[n];
                System.out.println(k+" "+(n-1));
                System.out.println(0+" "+(k^(n-1)));
                cache[k] = true;
                cache[n-1] = true;
                cache[0] = true;
                cache[k^(n-1)] = true;
                for(int j = 0; j < n; j++){
                    if(!cache[j]) {
                        System.out.println(j + " " + (j ^ (n - 1)));
                        cache[j] = true;
                        cache[j ^ (n - 1)] = true;
                    }
                }
            }
            else{
                if(n == 4){
                    System.out.println(-1);
                }
                else{
                    System.out.println((n-1)+" "+(n-2));
                    System.out.println((n-3)+" "+1);
                    System.out.println(2+" "+0);
                    boolean[] cache = new boolean[n];
                    cache[n-1] = true;
                    cache[n-2] = true;
                    cache[n-3] = true;
                    cache[1] = true;
                    cache[2] = true;
                    cache[0] = true;
                    for(int j = 0; j < n; j++){
                        if(!cache[j]) {
                            System.out.println(j + " " + (j ^ (n - 1)));
                            cache[j] = true;
                            cache[j ^ (n - 1)] = true;
                        }
                    }
                }

            }
        }
    }
}
