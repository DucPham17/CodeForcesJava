import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C_Factorials_and_Powers_of_Two {
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
        List<Long> list = new ArrayList<>();
        long cur = 1l;
        for(int i = 1; i < 15; i++){
            cur *= (long)i;
            list.add(cur);
        }
//        System.out.println(convert(7));
//        System.out.println(convert(8));
//        System.out.println(convert(9));
        for(int i = 0; i < cases; i++){
            Long num = fs.nextLong();
            System.out.println(travel(num,list));
        }
    }

    public static long travel(long a,List<Long> list){
        long res = convert(a);
     //   System.out.println(res);
        for(int i = 1; i < (1 <<list.size()); i++){
            long total = 0l;
            int index = 0;
            int val = i;
            int count = 0;
            while(val > 0){
                if(val % 2 == 1){
                    count += 1;
                    total += list.get(index);
                }
                index += 1;
                val /= 2;
            }
            if(total <= a){
//                System.out.println(count);
//                System.out.println(a - total);
//                System.out.println(total+" "+i);
                count += convert(a - total);
//                System.out.println(count);
//                System.out.println();
                res = Math.min(res,count);
            }


        }
        return res;
    }

    public static long convert(long a){
        long count = 0l;
        while(a > 0){
            if(a % 2 == 1){
                count += 1;
            }
            a /= 2l;
        }
        return count;
    }
}
