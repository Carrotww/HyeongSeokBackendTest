package com.example.test;

import java.util.*;

public class A1_WarmupBasics {

    /*
     * ===========================
     * 1. 기본(워밍업) / 자료형 감각
     * ===========================
     */

    // Problem: Count Frequencies
    // Description: 정수 배열 arr에서 각 값의 등장 횟수를 HashMap으로 반환한다.
    // Input: int[] arr
    // Output: Map<Integer, Integer> freq
    static Map<Integer, Integer> countFrequencies(int[] arr) {
        // TODO: HashMap으로 카운팅
        return new HashMap<>();
    }

    // Problem: Two Sum (indices)
    // Description: arr에서 두 수의 합이 target이 되는 (i, j) 인덱스를 반환한다. 없으면 (-1, -1).
    // Input: int[] arr, int target
    // Output: int[] {i, j}
    static int[] twoSumIndices(int[] arr, int target) {
        // TODO: HashMap(value -> index)
        return new int[]{-1, -1};
    }

    // Problem: Reverse String
    // Description: 문자열 s를 뒤집은 문자열을 반환한다.
    // Input: String s
    // Output: String reversed
    static String reverseString(String s) {
        // TODO: StringBuilder 이용
        return "";
    }

    // Problem: Palindrome Check
    // Description: 문자열 s가 팰린드롬인지 판별한다(영문/숫자만 고려 등 조건은 필요시 확장).
    // Input: String s
    // Output: boolean
    static boolean isPalindrome(String s) {
        // TODO: two pointers
        return false;
    }

    // Problem: Anagram Check
    // Description: s와 t가 아나그램인지 판별한다.
    // Input: String s, String t
    // Output: boolean
    static boolean isAnagram(String s, String t) {
        // TODO: 빈도 배열(ASCII/알파벳) or HashMap
        return false;
    }

    // Problem: GCD
    // Description: a, b의 최대공약수(GCD)를 반환한다.
    // Input: int a, int b
    // Output: int gcd
    static int gcd(int a, int b) {
        // TODO: 유클리드 호제법
        return 0;
    }

    // Problem: LCM
    // Description: a, b의 최소공배수(LCM)를 반환한다.
    // Input: int a, int b
    // Output: int lcm
    static int lcm(int a, int b) {
        // TODO: lcm = a / gcd(a,b) * b (오버플로우 주의)
        return 0;
    }

    // Problem: Prime Check
    // Description: n이 소수인지 판별한다.
    // Input: int n
    // Output: boolean
    static boolean isPrime(int n) {
        // TODO: sqrt(n)까지 나눠보기
        return false;
    }

    // Problem: Sieve of Eratosthenes
    // Description: 0..n까지 소수 여부 배열을 반환한다. (true=prime)
    // Input: int n
    // Output: boolean[] isPrime
    static boolean[] sieve(int n) {
        // TODO: 에라토스테네스
        return new boolean[Math.max(0, n + 1)];
    }

    // Problem: Base Conversion (to binary)
    // Description: 정수 n을 2진수 문자열로 반환한다. (음수 처리 여부는 필요시 확장)
    // Input: int n
    // Output: String
    static String toBinaryString(int n) {
        // TODO: Integer.toBinaryString or 직접 구현
        return "";
    }

    // Problem: Base Conversion (parse)
    // Description: base진법 문자열 s를 10진 정수로 변환한다.
    // Input: String s, int base
    // Output: int value
    static int parseBaseN(String s, int base) {
        // TODO: 직접 파싱 (Character.digit)
        return 0;
    }

    // Problem: Bit Operations - set/unset/toggle/kth-bit
    // Description: 비트 연산 유틸: k번째 비트 set/unset/toggle/check
    // Input: int x, int k
    // Output: 각각 결과
    static int setBit(int x, int k) {
        // TODO: x | (1<<k)
        return 0;
    }

    static int unsetBit(int x, int k) {
        // TODO: x & ~(1<<k)
        return 0;
    }

    static int toggleBit(int x, int k) {
        // TODO: x ^ (1<<k)
        return 0;
    }

    static boolean isBitSet(int x, int k) {
        // TODO: (x & (1<<k)) != 0
        return false;
    }
}
