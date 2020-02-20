package ch.sbb.cca.Service;

public abstract class PalindromeFinder {
    public static boolean isPalindrome(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);

        if (stringBuilder.length() > 1){
            if (Character.isLetter(stringBuilder.charAt(0)) && Character.isLetter(stringBuilder.charAt(stringBuilder.length() - 1))) {
                if (stringBuilder.charAt(0) == stringBuilder.charAt(stringBuilder.length() - 1)) {
                    if (isPalindrome(stringBuilder.substring(1, stringBuilder.length() - 1))) {
                        return true;
                    }
                }
                return false;
            } else {
                if (Character.isLetter(stringBuilder.charAt(0))) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                } else {
                    stringBuilder.deleteCharAt(0);
                }

                if (isPalindrome(stringBuilder.toString())) {
                    return true;
                }
            }
        }
        return true;
    }
}
