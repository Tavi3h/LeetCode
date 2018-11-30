package pers.tavish.solution.medium;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

/*

Given an absolute path for a file (Unix-style), simplify it. 

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
path = "/a/../../b/../c//.//", => "/c"
path = "/a//b////c/d//././/..", => "/a/b/c"

In a UNIX-style file system, a period ('.') refers to the current directory, so it can be ignored in a simplified path. Additionally, a double period ("..") moves up a directory, so it cancels out whatever the last directory was. For more information, look here: https://en.wikipedia.org/wiki/Path_(computing)#Unix_style

Corner Cases:

Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

for more information: https://leetcode.com/problems/simplify-path/description/
*/

public class SimplifyPath {
    public String simplifyPath(String path) {
        LinkedList<String> linkedList = new LinkedList<>();
        int i = 0;
        while (i < path.length()) {
            char c = path.charAt(i);
            if (c == '/') {
                ++i;
                continue;
                // ./
            } else if (c == '.' && ((i + 1 < path.length() && path.charAt(i + 1) == '/') || i == path.length() - 1)) {
                i += 2;
                continue;
                // ../
            } else if (c == '.' && i + 1 < path.length() && path.charAt(i + 1) == '.'
                    && ((i + 2 < path.length() && path.charAt(i + 2) == '/') || i == path.length() - 2)) {
                i += 3;
                linkedList.pollLast();
            } else {
                int j = i;
                for (; j < path.length(); j++) {
                    char k = path.charAt(j);
                    if (k != '/') {
                        continue;
                    } else {
                        linkedList.add(path.substring(i, j));
                        i = j;
                        break;
                    }
                }
                if (j == path.length()) {
                    linkedList.add(path.substring(i, j));
                    break;
                }
            }
        }

        if (linkedList.isEmpty()) {
            return "/";
        } else {
            StringBuilder sb = new StringBuilder();
            for (String s : linkedList) {
                sb.append("/").append(s);
            }
            return sb.toString();
        }
    }

    @Test
    public void testCase() {

        assertEquals(simplifyPath("/.hidden/.../..a/.."), "/.hidden/...");
        assertEquals(simplifyPath("/.hidden"), "/.hidden");
        assertEquals(simplifyPath("/a//b////c/d//././/.."), "/a/b/c");
        assertEquals(simplifyPath("/home/"), "/home");
        assertEquals(simplifyPath("/a/./b/../../c/"), "/c");
        assertEquals(simplifyPath("/a/../../b/../c//.//"), "/c");
    }
}
