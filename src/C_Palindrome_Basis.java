import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C_Palindrome_Basis {
    public static final long mod = 1000000007;
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
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            list.add(i);
        }
        for(int i = 1; i <= 9; i++){
            list.add(i*10+i);
        }

        for(int i = 1; i <= 9; i++){
            for(int j = 0; j <= 9; j++){
                list.add(i*100+j*10+i);
            }
        }

        for(int i = 1; i <= 9; i++){
            for(int j = 0; j <= 9; j++){
                list.add(i*1000+j*100+j*10+i);
            }
        }

        for(int i = 1; i <= 3; i++){
            for(int j = 0; j <= 9; j++){
                for(int k = 0; k <= 9; k++){
                    list.add(i*10000+j*1000+k*100+j*10+i);
                }
            }
        }
    //    System.out.println(list);
        List<Integer> temp = new ArrayList<>();
        int max = 0;
        for(int i = 0; i < cases; i++){
            temp.add(fs.nextInt());
            max = Math.max(temp.get(i),max);
        }
        long[][] res = travel(max,list);
        for(Integer c : temp){
            System.out.println(res[list.size()][c] % mod);
        }
    }

    public static long[][] travel(long val,List<Integer> list){
    //    System.out.println(val);

        long[][] cache = new long[list.size()+1][(int)val+1];
        for(int i = 0; i <= list.size();i++){
            cache[i][0] = 1;
        }

        for(int i = 1; i <= val; i++){
            for(int j = 1; j <= list.size(); j++){
                if(i >= list.get(j-1)){
//                    if(cache[j-1][i] + cache[j][i - list.get(j-1)] > mod){
//                        System.out.println("a");
//                    }
                    cache[j][i] = (cache[j-1][i] + cache[j][i - list.get(j-1)]) % mod;
                }
                else{
                    cache[j][i] = cache[j-1][i];
                }
            }
        }


        return cache;
    }
}
