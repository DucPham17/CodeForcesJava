import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E_PriceMaximization {
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
        for(int  i = 0; i < cases; i++){
            Integer item = fs.nextInt();
            Integer k = fs.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < item; j++){
                list.add(fs.nextInt());
            }
            System.out.println(process(k,list));
        }
    }

    public static long process(int k, List<Integer> list){
      //  System.out.println(k+" "+list);
        long res = 0;
        int n = list.size();
        Queue<Integer>[] arr = new LinkedList[k];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new LinkedList();
        }
        for(Integer c : list){
            arr[c % k].add(c);
        }
        List<Integer> left = new ArrayList<>();
        while(!arr[0].isEmpty()){
            Integer c = arr[0].poll();
            if(!arr[0].isEmpty()){
                Integer d = arr[0].poll();
                res += (c+d)/k;
            }
            else{
                left.add(c);
            }
        }
        int l = 1;
        int r = k-1;
        while(l <= r){
            if(arr[l].isEmpty() || l + r < k){
                l += 1;
            }
            else if(arr[r].isEmpty()){
                r -= 1;
            }
            else if(l == r && arr[l].size() < 2){
                break;
            }
            else{
                res += (arr[l].poll() + arr[r].poll())/k;
            }
        }
        for(int i = 0; i < k; i++){
            if(!arr[i].isEmpty()){
                left.addAll(arr[i]);
            }
        }
        for(int i = 1; i < left.size();i += 2){
            res += (left.get(i-1) + left.get(i))/k;
        }
        return res;
    }
}
