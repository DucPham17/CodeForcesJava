import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class C_Word_Game {
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
        int l = fs.nextInt();
        while(l-- > 0){
            int len = fs.nextInt();
            HashSet<String> hs1 = new HashSet<>();
            HashSet<String> hs2 = new HashSet<>();
            HashSet<String> hs3 = new HashSet<>();
            for(int i = 0; i < len; i++){
                hs1.add(fs.next());
            }

            for(int i = 0; i < len; i++){
                hs2.add(fs.next());
            }
            for(int i = 0; i < len; i++){
                hs3.add(fs.next());
            }
            System.out.print(get(hs1,hs2,hs3)+" ");
            System.out.print(get(hs2,hs1,hs3)+" ");
            System.out.println(get(hs3,hs1,hs2));
        }
    }

    public static int get(HashSet<String> hs1, HashSet<String> hs2, HashSet<String> hs3){
        int count = 0;
        for(String s : hs1){
            if(hs2.contains(s) && hs3.contains(s)){

            }
            else if(hs2.contains(s) || hs3.contains(s)){
                count += 1;
            }
            else{
                count += 3;
            }
        }

        return count;
    }
}
