import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class H2_Maximum_Crossings_Hard_Version {
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
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < len; j++){
                list.add(fs.nextInt());
            }
            System.out.println(process(list));
        }
    }

    public static long process(List<Integer> list){
        long res = 0l;
        int n = list.size();
        int[] total = new int[n+1];
        for(int i = 0; i < n; i++){
            res += get(total,list.get(i));
            update(total,list.get(i));
         //   System.out.println(res);
        }
        return res;
    }

    public static void update(int[] arr, int pos){
        while(pos > 0){
            arr[pos] += 1;
            pos -= (pos & -pos);
          //  System.out.println(pos);
        }
    }

    public static long get(int[] arr,int pos){
        long res = 0l;
        while(pos < arr.length){
           // System.out.println(pos);
            res += arr[pos];
            pos += (pos & (-pos));
       //     System.out.println();
        }
      //  System.out.println();
        return res;
    }
}
