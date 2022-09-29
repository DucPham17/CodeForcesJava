import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_Colourblindness {
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
        int len = fs.nextInt();

        for(int i = 0; i < len; i++){
            int tempLen = fs.nextInt();
            String s1 = fs.next();
            String s2 = fs.next();
            boolean get = true;
            for(int j = 0; j < s1.length(); j++){
                if(s1.charAt(j) == 'R'){
                    if(s2.charAt(j) != 'R'){
                        get = false;
                        System.out.println("NO");
                        break;
                    }
                }
                else{
                    if(s2.charAt(j) == 'R'){
                        get = false;
                        System.out.println("NO");
                        break;
                    }
                }
            }
            if(get){
                System.out.println("YES");
            }

        }
    }
}
