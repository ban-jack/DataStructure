package com.data.leetcode.recursion;

/*
38. 外观数列

给定一个正整数 n ，输出外观数列的第 n 项。

「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。

你可以将其视作是由递归公式定义的数字字符串序列：

countAndSay(1) = "1"
countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-and-say
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */

public class CountDemo {

    /*
    1-------------1
    2-------------1，1
    3-------------2，1
    4-------------1，2，1，1
    5-------------1，1，1，2，2，1
    6-------------3，1，2，2，1，1
    7-------------1，3，1，1，2，2，2，1
    8-------------1，1，1，3，2，1，3，2，1，1
     */

    public String countAndSay(int n) {

        String str = "1";

        for (int i = 2; i <= n; ++i) {
            // i每次加一都要重置
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;

            while (pos < str.length()) {
                // 比较前一个数有多少个和后一个数一样
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                // pos - start 可以得到重复的次数 ， str.charAt(start) 当前的数
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                // 重新定位，开始下一个数的计算
                start = pos;
            }
            // 输出第i次对应的 数列
            str = sb.toString();
        }

        return str;
    }

}
