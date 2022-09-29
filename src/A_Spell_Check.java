import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A_Spell_Check {
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
        String s = "Timur";
        int[] temp = new int[100];
        for(int i = 0; i < 5; i++){
            temp[s.charAt(i)-'A'] += 1;
        }

        int len = fs.nextInt();
        for(int i = 0; i < len; i++){
            int tempLen = fs.nextInt();
            String k = fs.next();
            if(tempLen != 5){
                System.out.println("NO");
                continue;
            }
            int[] temp2 = new int[100];
            for(int j = 0; j < 5; j++){
                temp2[k.charAt(j)-'A'] += 1;
            }
            boolean get = true;
            for(int j = 0; j < 100; j++){
                if(temp[j] != temp2[j]){
                    get = false;
                    break;
                }
            }
            if(get){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
