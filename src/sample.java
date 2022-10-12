public class sample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4000; i++){
            sb.append("z");
        }
        System.out.println(sb.toString());
    }
}
