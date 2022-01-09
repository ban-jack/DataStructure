package com.data.hashtale;

/*

36. 有效的数独

请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 

注意：

一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
空白格用 '.' 表示。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-sudoku
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */

// 用哈希表的思想解决问题
public class isValidSudokuDemo {

    public boolean isValidSudoku(char[][] board) {
        // 数组代替哈希表解决问题

        //数独的行内数字出现的次数
        int[][] rows = new int[9][9];

        //数独的列内数字出现的次数
        int[][] columns = new int[9][9];

        //九宫格的内数字出现的次数
        int[][][] ge = new int[3][3][9];

        //开始遍历数独，一次遍历
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                char c = board[i][j];
                if (c != '.'){
                    int index = c - '1';

                    rows[i][index]++;

                    columns[j][index]++;

                    ge[i/3][j/3][index]++;

                    if (rows[i][index] > 1 || columns[j][index] > 1 || ge[i/3][j/3][index] > 1){
                        return false;
                    }

                }
            }
        }
        return true;
    }

}
