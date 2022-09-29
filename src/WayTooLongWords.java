import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WayTooLongWords {
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
        FastScanner fastScanner = new FastScanner();
        Integer time = fastScanner.nextInt();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < time; i++){
            list.add(fastScanner.next());
        }
        for(String s : process(list)){
            System.out.println(s);
        }
    }

    public static List<String> process(List<String> words){
        List<String> res = new ArrayList<>();
        for(String s : words){
            if(s.length() > 10){
                res.add(s.substring(0,1)+(s.length() - 2)+s.substring(s.length()-1));
            }
            else{
                res.add(s);
            }
        }
        return res;
    }
}
