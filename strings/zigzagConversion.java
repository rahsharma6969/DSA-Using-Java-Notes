/*6. Zigzag Conversion
Solved
Medium
Topics
premium lock icon
Companies
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 */

class Solution{
   public String convert(String s, int numRows) {

    if (numRows == 1 || s.length() <= numRows)
        return s;

    StringBuilder[] rows = new StringBuilder[numRows];

    for (int i = 0; i < numRows; i++)
        rows[i] = new StringBuilder();

    int row = 0;
    int dir = 1; // 1 = down, -1 = up

    for (char c : s.toCharArray()) {
        rows[row].append(c);

        if (row == 0)
            dir = 1;
        else if (row == numRows - 1)
            dir = -1;

        row += dir;
    }

    StringBuilder result = new StringBuilder();
    for (StringBuilder sb : rows)
        result.append(sb);

    return result.toString();
}

}


public class zigzagConversion {
    
}
