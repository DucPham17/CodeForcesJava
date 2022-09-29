import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class D_Line {
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
        int j = fs.nextInt();
        while(j-- > 0){
            int len = fs.nextInt();
            String s = fs.next();
            long count = 0;
            Queue<Integer> qu = new LinkedList<>();
            Stack<Integer> st = new Stack<>();
            for(int i = 0; i < len; i++){
                if(s.charAt(i) == 'L'){
                    count += (long)i;
                    qu.add(i);
                }
                else{
                    count += (long)(len - i - 1);
                    st.push(i);
                }
            }

            for(int i = 0; i < len; i++){
                long  val1 = Long.MIN_VALUE,val2 = Long.MIN_VALUE;
                if(!qu.isEmpty()){
                    val1 = (long)((len - qu.peek() - 1) - qu.peek());
                }

                if(!st.isEmpty()){
                    val2 = (long)(st.peek() - (len - st.peek() - 1));
                }
                if(val1 > 0 && val1 >= val2){
                    qu.poll();
                    count += val1;
                    System.out.print(count+" ");
                }
                else if(val2 > 0 && val2 >= val1){
                    st.pop();
                    count += val2;
                    System.out.print(count+" ");
                }
                else{
                    System.out.print(count+" ");
                }

            }
            System.out.println();
        }
    }
}
