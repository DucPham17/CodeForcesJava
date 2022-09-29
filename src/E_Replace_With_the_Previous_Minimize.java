import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E_Replace_With_the_Previous_Minimize {
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
        Integer cases = fs.nextInt();
        for(int i = 0; i < cases; i++){
            Integer len = fs.nextInt();
            Integer k = fs.nextInt();
            String s = fs.next();
            System.out.println(process(s,k));
        }
    }

    public static String process(String s,int k){
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(!list.contains(s.charAt(i))){
                list.add(s.charAt(i));
            }
        }
        HashMap<Character,Character> hm = new HashMap<>();
        boolean[][] res = check(list,k);

        for(Character ch : list){
            int start = ch - 'a';
                while(start > 0 && res[1][start-1]){
                    start -= 1;
            }
            hm.put(ch,(char)(start+'a'));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            sb.append(hm.get(s.charAt(i)));
        }
        return sb.toString();
    }

    public static boolean[][] check(List<Character> list, int k){
        boolean[][] arr = new boolean[2][26];
        for(Character ch : list){
            int pos = ch - 'a';
            arr[0][pos] = true;
            while(k > 0 && pos > 0){
                if(!arr[1][--pos]){
                    arr[1][pos] = true;
                    k -= 1;
                }
            }
            if(k == 0){
                break;
            }
        }
        return arr;
    }
}
