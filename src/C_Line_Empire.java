import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C_Line_Empire {
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
            Integer nums = fs.nextInt();
            Integer a = fs.nextInt();
            Integer b = fs.nextInt();
            int[] num = new int[nums];
            for(int j = 0; j < nums; j++){
                num[j] = fs.nextInt();
            }
            System.out.println(travel(a,b,num));
        }
    }

    public static long travel(long move, long con, int[] nums){
     //   System.out.println(move);
    //    System.out.println(Arrays.toString(nums));
        long res = Long.MAX_VALUE;
        int n = nums.length;
        long pre = 0l;
        for(int i = n-2; i >= 0; i--){
            int dis = n - i-1;
            pre  = pre + dis * (nums[i+1] - nums[i]) * con;
            res = Math.min(res,pre + nums[i] * (move+con));

        }
        pre = pre + n * nums[0]*con;
        res = Math.min(res,pre);
        return res;
    }
}
