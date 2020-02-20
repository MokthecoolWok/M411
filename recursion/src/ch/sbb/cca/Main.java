package ch.sbb.cca;

import ch.sbb.cca.Service.PalindromeFinder;

public class Main {

    public static void main(String[] args) {
        System.out.println(PalindromeFinder.isPalindrome("znaznz"));
        System.out.println(PalindromeFinder.isPalindrome("abcv"));
        System.out.println(PalindromeFinder.isPalindrome("Madam, I'm Adam."));
        System.out.println(PalindromeFinder.isPalindrome("A man, a plan, a canal, Panama!"));
        System.out.println(PalindromeFinder.isPalindrome("Go hang a salami, I'm a lasagna hog."));
        System.out.println(PalindromeFinder.isPalindrome("Go hang a salami, I'm a lasagna hog.!!!!"));
    }
}
