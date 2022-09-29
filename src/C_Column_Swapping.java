import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.StringTokenizer;
import java.util.*;

public class C_Column_Swapping {
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
        int test = fs.nextInt();
        for(int m = 0; m < test; m++){
            int row = fs.nextInt();
            int col = fs.nextInt();
            int[][] arr = new int[row][col];
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    arr[i][j] = fs.nextInt();
                }
            }
            int swap1,swap2;
            swap1 = -3;
            swap2 = -3;
            boolean good = true;
            List<Integer> pre = new ArrayList<>();
            for(int i = 0; i < row; i++){
                List<Integer> res = change(arr[i],col);
                // printf("Vector contents: ");
                // for(int c : res){
                //     printf("%d ",c);
                // }
                // cout << "\n";
                if(res.get(0) == -2){
                    good = false;
                    break;
                }
                else if(res.get(0) == -1 && swap1 != -3){
                    swap(arr[i],swap1,swap2);
                    if(check(arr[i],col)){
                        continue;
                    }
                    else{
                        good = false;
                        break;
                    }
                }
                else if(res.get(0) != -1 && swap1 != -3 && swap1 != res.get(0) && swap2 != res.get(1)){
                    good = false;
                    break;
                }
                else if(res.get(0) != -1 && swap1 == -3){
                    for(int c : pre){
                        swap(arr[c],res.get(0),res.get(1));
                        if(!check(arr[i],col)){
                            good  = false;
                            break;
                        }

                    }
                    swap1 = res.get(0);
                    swap2 = res.get(1);
                }
                else if(res.get(0) == -1 && swap1 == -3){
                    pre.add(i);
                }
            }
//            if(m == 21){
//                for(int[] c : arr){
//                    System.out.print(Arrays.toString(c) +" ");
//                }
//                continue;
//            }
            if(!good){
                System.out.println(-1);
            }
            else{
                if(swap1 == -3){
                    System.out.println("1 1");
                }
                else{
                    swap1++;
                    swap2++;
                    System.out.printf("%d %d \n",swap1,swap2);
                }
            }
        }
    }

    static void swap(int arr[], int pos1, int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    static boolean check(int arr[], int len){
        for(int i = 0; i < len-1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    static List<Integer> change(int arr[], int col){
        List<Integer> res = new ArrayList<>();
        res.add(-1);
        res.add(-1);
        for(int i = 0; i < col - 1; i++){
            if(arr[i] > arr[i+1]){
                //  cout << "this is where" << i << arr[i]<< arr[i+1] <<endl;
                int j = i+1;
                while(j < col && arr[j] < arr[i]){
                    j += 1;
                }
                swap(arr,i,j-1);
                if(check(arr,col)){
                    res.set(0,i);
                    res.set(1,j-1);
                    return res;
                }
                else{
                    res.set(0,-2);
                    res.set(0,-2);
                    return res;
                }
            }
        }
        return res;
    }
}
