package com.xav59.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class NumbersAndLetters {

    private static final String digitsSearchPattern = "[0-9]";
    private static final String spelledDigitsPattern = "zero|one|two|three|four|five|six|seven|eight|nine";
    private static final Pattern digitsPattern = Pattern.compile(digitsSearchPattern);
    private static final Pattern digitsIncludingSpelledPattern = Pattern
            .compile(digitsSearchPattern + "|" + spelledDigitsPattern);

    public static Stream<String> readFile(String fileName) throws IOException {
            return Files.lines(Paths.get(fileName));
    }

    public static String[] readFileLines(String fileName) throws IOException {
        return readFile(fileName).toArray(String[]::new);
    }

    public String replaceSpelledDigitsWithDigits(String s) {
        return s.replace("zero", "0").replace("one", "1").replace("two", "2").replace("three", "3")
                .replace("four", "4").replace("five", "5").replace("six", "6").replace("seven", "7")
                .replace("eight", "8").replace("nine", "9");
    }

    public Optional<String> getDigit(String s) {
        Matcher digitsMatcher = digitsPattern.matcher(s);
        if (digitsMatcher.find())
            return Optional.of(digitsMatcher.group());
        else
            return Optional.empty();
    }

    public Optional<String> getDigitIncludingSpelledOnes(String s) {
        Matcher digitsMatcher = digitsIncludingSpelledPattern.matcher(s);
        if (digitsMatcher.find())
            return Optional.of(replaceSpelledDigitsWithDigits(digitsMatcher.group()));
        else
            return Optional.empty();
    }

    public Optional<Integer> getConcatOfFirstAndLastDigits(String s, boolean includeSpelledOnes) {
        String firstDigit = new String();
        String lastDigit = new String();

        // TODO: if s is empty or null, return empty

        for (int i = 0; i <= s.length(); i++) {
            Optional<String> digit = includeSpelledOnes ? getDigitIncludingSpelledOnes(s.substring(i))
                    : getDigit(s.substring(i));
            if (digit.isPresent()) {
                firstDigit = digit.get();
                break;
            }

        }
        // if no digit found then return empty

        for (int i = s.length(); i >= 0; i--) {
            Optional<String> digit = includeSpelledOnes ? getDigitIncludingSpelledOnes(s.substring(i))
                    : getDigit(s.substring(i));
            if (digit.isPresent()) {
                lastDigit = digit.get();
                break;
            }
        }

        String result = firstDigit + lastDigit;
        // FIXME: if result is empty then return Optional.empty()
        return Optional.of(Integer.valueOf(result));
    }

    public static void main(String[] args) throws IOException {

        // String fileName =
        // "src/main/resources/input/numbersAndLetters/sampleWithNoSpelledDigits.txt";
        String fileName = "src/main/resources/input/numbersAndLetters/sampleWithMix.txt";
        // Generate an error marked to fix
        // String fileName =
        // "src/main/resources/input/numbersAndLetters/sampleWithMixAndOneLineWithoutAnyPureDigit.txt";
        // Large dataset
        // String fileName = "src/main/resources/input/numbersAndLetters/data.txt";

        NumbersAndLetters numbersAndLetters = new NumbersAndLetters();

        for (String line : readFileLines(fileName)) {
            System.out.println("line: " + line);
            System.out.println("concat of first and last digits: " +
                    numbersAndLetters.getConcatOfFirstAndLastDigits(line, false));
            System.out.println("concat of first and last digits including spelled ones: " +
                    numbersAndLetters.getConcatOfFirstAndLastDigits(line, true));
        }
    }

}
