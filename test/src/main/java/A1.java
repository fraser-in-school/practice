import java.util.Scanner;

public class A1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String order = in.nextLine();
        char[] chars = order.toCharArray();
        int[] count = new int[4];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A') {
                count[0] ++;
            } else if (chars[i] == 'W') {
                count[1] ++;
            } else if (chars[i] == 'S') {
                count[2] ++;
            } else if (chars[i] == 'D') {
                count[3] ++;
            }
        }

        int x = chars.length / 4;
        int ans = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > x) {
                ans += count[i] - x;
            }
        }
        System.out.println(ans);
    }
}
