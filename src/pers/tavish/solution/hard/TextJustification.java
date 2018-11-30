package pers.tavish.solution.hard;

import java.util.ArrayList;
import java.util.List;

/*

Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
Example 1:
Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Example 2:
Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.

Example 3:
Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]

for more information: https://leetcode.com/problems/text-justification/description/
*/

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int curWidth = 0;
        List<String> line = new ArrayList<>();
        for (String s : words) {

            if (curWidth == 0) {
                curWidth += s.length();
                line.add(s);
                continue;
            }

            // add Line
            if (curWidth + s.length() + 1 > maxWidth) {
                addLine(res, line, maxWidth);
                line = new ArrayList<>();
                line.add(s);
                curWidth = s.length();
            } else {
                curWidth += s.length() + 1;
                line.add(s);
            }
        }

        // process last line
        if (line.size() == 0)
            return res;

        if (line.size() == 1)
            addOneWord(res, line.get(0), maxWidth);

        if (line.size() > 1) {
            StringBuilder build = new StringBuilder();
            build.append(line.get(0));
            for (int i = 1; i < line.size(); i++) {
                build.append(" ").append(line.get(i));
            }
            addSpace(build, maxWidth - build.toString().length());
            res.add(build.toString());
        }

        return res;
    }

    private void addOneWord(List<String> res, String word, int maxWidth) {
        StringBuilder build = new StringBuilder();
        build.append(word);
        addSpace(build, maxWidth - word.length());
        res.add(build.toString());
        return;
    }

    private void addLine(List<String> res, List<String> line, int maxWidth) {
        StringBuilder build = new StringBuilder();
        if (line.size() == 1) {
            addOneWord(res, line.get(0), maxWidth);
            return;
        }

        int wordlen = 0;
        for (String s : line) {
            wordlen += s.length();
        }

        int emptySpace = maxWidth - wordlen;
        int extraSpace = emptySpace % (line.size() - 1);
        int everySpace = emptySpace / (line.size() - 1);

        for (int i = 0; i < line.size() - 1; i++) {
            build.append(line.get(i));
            addSpace(build, everySpace);
            if (extraSpace-- > 0)
                addSpace(build, 1);

        }
        if (line.size() > 1)
            build.append(line.get(line.size() - 1));

        res.add(build.toString());
    }

    private void addSpace(StringBuilder build, int n) {
        for (int i = 0; i < n; i++) {
            build.append(" ");
        }
    }
}
