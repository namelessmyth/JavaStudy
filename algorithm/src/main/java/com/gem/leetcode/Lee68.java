package com.gem.leetcode;
import java.util.ArrayList;
import java.util.List;
/**
 * <a href="https://leetcode.cn/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150">
 * 68. 文本左右对齐
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justification = new ArrayList<String>();
        List<String> line = new ArrayList<String>();
        int lineWidth = 0;
        int wordsCount = words.length;
        for (int i = 0; i < wordsCount; i++) {
            String word = words[i];
            int newLength = lineWidth + (lineWidth > 0 ? 1 : 0) + word.length();
            if (newLength <= maxWidth) {
                lineWidth = newLength;
            } else {
                String justifiedLine = justifyLine(line, lineWidth, maxWidth);
                justification.add(justifiedLine);
                line.clear();
                lineWidth = word.length();
            }
            line.add(word);
        }
        String justifiedLastLine = justifyLastLine(line, maxWidth);
        justification.add(justifiedLastLine);
        return justification;
    }

    public String justifyLine(List<String> line, int lineWidth, int maxWidth) {
        StringBuffer sb = new StringBuffer();
        sb.append(line.get(0));
        int lineWords = line.size();
        int splits = lineWords - 1;
        if (splits == 0) {
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
        } else {
            int spaces = maxWidth - (lineWidth - splits);
            int quotient = spaces / splits, remainder = spaces % splits;
            for (int i = 1; i < lineWords; i++) {
                int currSpaces = quotient + (i <= remainder ? 1 : 0);
                for (int j = 0; j < currSpaces; j++) {
                    sb.append(" ");
                }
                sb.append(line.get(i));
            }
        }
        return sb.toString();
    }

    public String justifyLastLine(List<String> line, int maxWidth) {
        StringBuffer sb = new StringBuffer();
        sb.append(line.get(0));
        int lineWords = line.size();
        for (int i = 1; i < lineWords; i++) {
            sb.append(" ");
            sb.append(line.get(i));
        }
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
