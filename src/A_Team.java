import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_Team {
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
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        Integer time = fs.nextInt();
        int count = 0;
        for(int i = 0;i < time; i++){
            int temp = 0;
            for(int j = 0; j < 3; j++){
                temp += fs.nextInt();
            }
            if(temp >= 2){
                count += 1;
            }
        }
        System.out.println(count);
    }
}
