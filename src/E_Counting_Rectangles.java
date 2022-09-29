import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E_Counting_Rectangles {
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
        int j = fs.nextInt();
        while(j-- > 0){
            int rec = fs.nextInt();
            int que = fs.nextInt();
            long[][] count = new long[1002][1002];
            for(int i = 0; i < rec; i++){
                int h = fs.nextInt();
                int w = fs.nextInt();
                update(h,w,count);
            }
          //  System.out.println("Completed at here");
            for(int i = 0; i < que; i++){
                int h1 = fs.nextInt();
                int w1 = fs.nextInt();
                int h2 = fs.nextInt() -1;
                int w2 = fs.nextInt() -1;
                long val1 = get(h2,w2,count);
                long val2 = get(h2,w1,count);
                long val3 = get(h1,w2,count);
                long val4 = get(h1,w1,count);
                System.out.println(val1 - val2 -val3 + val4);
            }
        }
    }

    public static void update(int h, int w, long[][] count){
        long val = (long)h * (long)w;
        for(int i = h; i <= 1001; i += (i &-i) ){
            for(int j = w; j <= 1001; j += (j & -j)){
                count[i][j] += val;
            }
        }
    }

    public static long get(int h, int w, long[][] count){
        long res = 0l;
        for(int i = h; i > 0; i -= (i &-i) ){
            for(int j = w; j > 0; j -= (j & -j)){
                res += count[i][j];
            }
        }
        return res;
    }
}
