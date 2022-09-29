import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G_Even_Odd_XOR {
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
        while(l-- > 0) {
            int len = fs.nextInt();
            // cho so chan
            int len1 = (len)/2;
            // cho so le
            int len2 = len - len1;

            Queue<Integer> list1 = new LinkedList<>();
            Queue<Integer> list2 = new LinkedList<>();
            if(len1 == len2){
                if(len1 % 2== 0){
                    for(int i = 1; i <= len1; i++){
                        list1.add(i*2+1);
                        list2.add(i*2);
                    }
                }
                else{
                    //  4 1 2 12 3 8
                    list1.add(4);
                    list1.add(2);
                    list1.add(3);
                    list2.add(1);
                    list2.add(12);
                    list2.add(8);
                    int val = 100;
                    while(list1.size() < len1){
                        list1.add(val * 2 + 1);
                        list2.add(val*2);
                        val += 1;
                    }

                }
            }
            // len2 = len1 + 1
            else{
                if(len1 % 2 == 0){
                    for(int i = 1; i <= len1; i++){
                        list1.add(i*2+1);
                        list2.add(i*2);
                    }
                    list1.add(0);
                }
                else{
                    for(int i = 1; i <= len1; i++){
                        list1.add(i*2+1);
                        list2.add(i*2);
                    }
                    list1.add(1);
                }
            }
            while(!list1.isEmpty() || !list2.isEmpty()){
                if(!list1.isEmpty()){
                    System.out.print(list1.poll()+" ");
                }
                if(!list2.isEmpty()){
                    System.out.print(list2.poll()+" ");
                }
            }
            System.out.println();
        }
    }
}
