import java.util.Arrays;

/**
 * Description: 输出最大连续子序列 以及 求最大子序列之和
 * Created by small small su
 * Date: 2022/6/7
 * Email: surao@foryou56.com
 */
public class MaxArray {
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // dp[i]：以nums[i]结尾的 和最大的 连续子数组的和
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        int start = 0, end = 0;
        for (int i = 1; i < len; i++) {
//            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
                start = i; //最大子序列的开头位置
            }
//            res = Math.max(res, dp[i]);
            if (res < dp[i]) {
                end = i;    //最大子序列的结尾位置
                res = dp[i];
            }
            System.out.println("i= " + i);
            System.out.println("res: " + res);
            System.out.println(Arrays.toString(dp));
            System.out.println("start：" + start + "  end：" + end);

            //最大序列的数组
            System.out.println(Arrays.toString(Arrays.copyOfRange(nums, start, end + 1)));

            System.out.println("");
            System.out.println("");
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(a) + "");
    }
}
