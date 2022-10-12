import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class C_Binary_String {
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
        Integer t = fs.nextInt();
        for(int a = 0; a < t; a++){
            String s = fs.next();
            int n = s.length();
            List<Integer> list = new ArrayList<>();
            for(int i =0; i < n; i++){
                if(s.charAt(i) == '1'){
                    list.add(i);
                }
            }
            int left = 0;
            int right = list.size();
            while(left < right){
                int mid = (right + left)/2;
                if(check(list,mid)){
                    right = mid;
                }
                else{
                    left = mid + 1;
                }
            }

            if(list.size() == 0 || list.size() == n){
                right = 0;
            }
            System.out.println(right);
        }
    }

    public static boolean check(List<Integer> list, int mid){
        int n  = list.size();
        int left = n - mid;
        for(int i = 0; i < n && i + left - 1 < n; i++){
            int l = list.get(i);
            int r = list.get(i + left - 1);
            if(r - l -left + 1 <= mid){
                return true;
            }
        }
        return false;
    }

}
