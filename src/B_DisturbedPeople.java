import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_DisturbedPeople {
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
        Integer houses = fs.nextInt();
        int[] arr = new int[houses];
        for(int i = 0; i < houses; i++){
            arr[i] = fs.nextInt();
        }
        int count = 0;
        for(int i = 1; i < houses-1; i++){
            if(arr[i] == 0 && arr[i+1] == 1 && arr[i-1] == 1){
                if(i + 2 < houses - 1 && arr[i+3] == 1){
                    count += 1;
                    i = i + 3;
                }
                else{
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}
