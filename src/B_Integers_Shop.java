import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_Integers_Shop {
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
        for(int i = 0; i < cases; i++){
            Integer time = fs.nextInt();
            long min = Long.MAX_VALUE;
            long priceMin = 9999999999l;
            long max = Long.MIN_VALUE;
            long priceMax = 9999999999l;
            long prePrice = priceMin + priceMax;
            for(int j = 0; j < time; j++){
                long[] arr = fs.getArr(3);
                if(arr[0] < min || arr[1] > max){
                    if(arr[0] < min && arr[1] > max){
                        min = arr[0];
                        max = arr[1];
                        priceMin = arr[2];
                        priceMax = arr[2];
                        prePrice = arr[2];
                        System.out.println(arr[2]);
                    }
                    // this mean arr[1] > max
                    else if(arr[0] > min){
                        priceMax = arr[2];
                        max = arr[1];
                        prePrice = priceMin + priceMax;
                        System.out.println(prePrice);
                    }
                    // this mean arr[0] < min
                    else if(arr[1] < max){
                        priceMin = arr[2];
                        min = arr[0];
                        prePrice = priceMin + priceMax;
                        System.out.println(prePrice);
                    }
                    else{
                        if(arr[0] == min){
                            priceMin = Math.min(priceMin,arr[2]);
                        }
                        if(arr[0] < min){
                            priceMin = arr[2];
                        }
                        if(arr[1] == max){
                            priceMax = Math.min(priceMax,arr[2]);
                        }
                        if(arr[1] > max){
                            priceMax = arr[2];
                        }
                        min = Math.min(min,arr[0]);
                        max = Math.max(max,arr[1]);
                        prePrice = arr[2];
                        System.out.println(prePrice);
                    }
                }
                else if(arr[0] == min && arr[1] == max){
                    priceMin = Math.min(priceMin,arr[2]);
                    priceMax = Math.min(priceMax,arr[2]);
                    prePrice = Math.min(prePrice,arr[2]);
                    System.out.println(prePrice);
                }
                else if(arr[0] == min){
                    priceMin = Math.min(priceMin,arr[2]);
              //      System.out.println(prePrice+" "+priceMin+" "+priceMax+" "+min+" "+max);
                    prePrice = Math.min(prePrice,priceMax+priceMin);
                    System.out.println(prePrice);
                }
                else if(arr[1] == max){
                    priceMax = Math.min(priceMax,arr[2]);
                    prePrice = Math.min(prePrice,priceMax+priceMin);
                    System.out.println(prePrice);
                }
                else{
                    System.out.println(prePrice);
                }
            }
        }
    }
}
