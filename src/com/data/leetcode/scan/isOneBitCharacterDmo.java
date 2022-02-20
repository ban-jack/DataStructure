package com.data.leetcode.scan;
/*
717. 1比特与2比特字符

有两种特殊字符：
第一种字符可以用一个比特 0 来表示
第二种字符可以用两个比特(10 或 11)来表示、
给定一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一位字符，则返回 true 。

示例 1:
输入: bits = [1, 0, 0]
输出: true
解释: 唯一的编码方式是一个两比特字符和一个一比特字符。
所以最后一个字符是一比特字符。
示例 2:
输入: bits = [1, 1, 1, 0]
输出: false
解释: 唯一的编码方式是两比特字符和两比特字符。
所以最后一个字符不是一比特字符。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/1-bit-and-2-bit-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class isOneBitCharacterDmo {

    // 自己的解法
    public boolean isOneBitCharacter(int[] bits) {
    int length = bits.length;
    if (length == 1){
        return true;
    }
    int next = 0;
    while(next < length){
        if (bits[next] == 1) {
            next++;
        }
        next++;
        if (length - next == 1) {
            return true;
        }
    }
    return false;
}

    /*
        官方方法：
        逆序遍历优势在于不用遍历完全部数组。
        关键点是只有 “0”，“10”，“11” 三种编码。
        首先，观察数组最后一位，题干中说了，肯定是 0，但是我们不能确定是 “0” 还是 “10”，
        所以采取的策略是：看看这个 0 前面有多少个连续的 1，为什么是连续呢 ？
        因为我们只要碰到 0 时，不管是 “0” 也好， “10” 也好，都代表着一个字符的结尾。
        注意：没有 “1” 这个编码！我们只需看看连续的 1 个数是奇数还是偶数，如果是偶数，代表这些连续的 1 都组成了“11”，
        如果是奇数，代表最后一个“1”落单了，由于没有 “1” 这个编码，所以只能和最后一位 “0” 进行配对了

     */
    public boolean isOneBitCharacter1(int[] bits) {
        int n = bits.length, count = 0;
        for (int i = n - 2; i >= 0; --i){
            if (bits[i] == 1){
                ++count;
            }else {
                break;
            }
        }
        if (count % 2 == 0){
            return true;
        }
        return false;
    }



}
