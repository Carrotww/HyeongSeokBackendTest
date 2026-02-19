package com.example.test;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.*;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JavaCodingTestInterviewBook {

    public static boolean brace(char[] ary) {
        if (ary == null) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : ary) {
            if (c == '{') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.isEmpty()) return false;

                stack.pop();
            } else {
                return false;
            }
        }

        // 남아있으면 false
        return stack.isEmpty();
    }

    @Test
    void braceEdgeCases() {
        // null input -> false
        assertThat(brace(null), is(false));

        // empty array -> true (no unmatched braces)
        assertThat(brace(new char[] {}), is(true));

        // single opening -> false
        assertThat(brace(new char[] { '{' }), is(false));

        // single closing -> false
        assertThat(brace(new char[] { '}' }), is(false));

        // balanced nested -> true
        assertThat(brace(new char[] { '{', '{', '}', '}' }), is(true));

        // extra closing -> false
        assertThat(brace(new char[] { '{', '}', '}' }), is(false));

        // invalid characters -> false
        assertThat(brace(new char[] { '[', ']' }), is(false));

        char[] longBalanced = "{{{{}}}}{{}}".toCharArray();
        assertThat(brace(longBalanced), is(true));

        // almost balanced but with wrong order
        char[] wrongOrder = new char[] { '}', '{' };
        assertThat(brace(wrongOrder), is(false));
    }
}
