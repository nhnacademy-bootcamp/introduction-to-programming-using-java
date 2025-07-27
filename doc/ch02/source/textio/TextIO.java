/*
    An easy-to-use class for reading data from the keyboard.
*/
package textio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TextIO provides a set of static methods for reading and writing text. The
 * input functions read from standard input, and the output functions write to
 * standard output. The user of this class does not have to worry about creating
 * streams or readers.
 * <p>
 * This class is not synchronized, so it should not be used in a multithreaded
 * program.
 *
 * @author David J. Eck
 * @version 1.0
 */
public final class TextIO {

    private static Scanner in = new Scanner(System.in);
    private static PrintWriter out = new PrintWriter(System.out);

    private static String buffer = "";
    private static int pos = 0;

    private static Reader stream = new StringReader("");
    private static String currentFileName = null;
    private static String nextFileName = null;

    /**
     * Test whether the next character in the input is a letter.
     */
    public static boolean peekIsLetter() {
        return Character.isLetter(peek());
    }

    /**
     * Test whether the next character in the input is a digit.
     */
    public static boolean peekIsDigit() {
        return Character.isDigit(peek());
    }

    /**
     * Test whether the next character in the input is a letter or a digit.
     */
    public static boolean peekIsLetterOrDigit() {
        return Character.isLetterOrDigit(peek());
    }

    /**
     * Test whether the next character in the input is whitespace.
     */
    public static boolean peekIsWhitespace() {
        return Character.isWhitespace(peek());
    }

    /**
     * Returns the next character in the input, without consuming it.
     */
    public static char peek() {
        if (pos == buffer.length()) {
            readNextLine();
        }
        if (pos == buffer.length()) {
            return (char) 0;
        } else {
            return buffer.charAt(pos);
        }
    }

    /**
     * Tests whether the next character in the input stream is an end-of-file.
     *
     * @return true if the next character is end-of-file, false otherwise.
     */
    public static boolean eof() {
        return peek() == (char) 0;
    }

    /**
     * Reads the next line of input and returns it as a string.
     */
    public static String getln() {
        String line = "";
        if (pos < buffer.length()) {
            line = buffer.substring(pos);
            pos = buffer.length();
        } else {
            line = in.nextLine();
        }
        return line;
    }

    /**
     * Reads the next line of input and discards it.
     */
    public static void getlnVoid() {
        getln();
    }

    /**
     * Reads the next word from input and returns it as a string.
     */
    public static String getWord() {
        skipWhitespace();
        String word = "";
        while (pos < buffer.length() && !Character.isWhitespace(buffer.charAt(pos))) {
            word += buffer.charAt(pos);
            pos++;
        }
        if (word.length() == 0) {
            word = in.next();
        }
        return word;
    }

    /**
     * Reads the next integer from input and returns it.
     */
    public static int getInt() {
        return (int) Math.round(getDouble());
    }

    /**
     * Reads a value of type int from the input. The value should be on a
     * line by itself. Any extra characters on the line are discarded.
     * The value is returned. This will throw an IllegalArgumentException
     * if the input is not a legal integer.
     */
    public static int getlnInt() {
        String s = getln();
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input is not a legal integer: \"" + s + "\"");
        }
    }

    /**
     * Reads a value of type double from the input. The value should be on a
     * line by itself. Any extra characters on the line are discarded.
     * The value is returned. This will throw an IllegalArgumentException
     * if the input is not a legal double.
     */
    public static double getlnDouble() {
        String s = getln();
        try {
            return Double.parseDouble(s.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input is not a legal double: \"" + s + "\"");
        }
    }

    /**
     * Reads a single character from a line of input. The line should
     * contain at least one non-blank character. The first non-blank
     * character is returned. Any other characters on the line are
     * discarded. If the line is empty or contains only blank characters,
     * an IllegalArgumentException is thrown.
     */
    public static char getlnChar() {
        String s = getln();
        if (s == null || s.trim().length() == 0) {
            throw new IllegalArgumentException("Input line is empty or contains only whitespace.");
        }
        return s.trim().charAt(0);
    }

    /**
     * Reads a line of input and tries to interpret it as a boolean value.
     * Legal values are: true, false, t, f, yes, no, y, n, 1, 0.
     * Case is ignored. If the input is not one of these values,
     * an IllegalArgumentException is thrown.
     * 
     * @return the boolean value read from input.
     */
    public static boolean getlnBoolean() {
        String s = getln().trim().toLowerCase();
        if (s.equals("true") || s.equals("t") || s.equals("yes") || s.equals("y") || s.equals("1")) {
            return true;
        }
        if (s.equals("false") || s.equals("f") || s.equals("no") || s.equals("n") || s.equals("0")) {
            return false;
        }
        throw new IllegalArgumentException("Input is not a legal boolean value: \"" + s + "\"");
    }

    /**
     * Reads the next double from input and returns it.
     */
    public static double getDouble() {
        skipWhitespace();
        String doubleStr = "";
        while (pos < buffer.length() && (Character.isDigit(buffer.charAt(pos)) || buffer.charAt(pos) == '.')) {
            doubleStr += buffer.charAt(pos);
            pos++;
        }
        if (doubleStr.length() == 0) {
            return in.nextDouble();
        } else {
            return Double.parseDouble(doubleStr);
        }
    }

    /**
     * Reads the next character from input and returns it.
     */
    public static char getChar() {
        if (pos == buffer.length()) {
            readNextLine();
        }
        if (pos == buffer.length()) {
            return (char) 0;
        } else {
            char ch = buffer.charAt(pos);
            pos++;
            return ch;
        }
    }

    /**
     * Skips any whitespace characters in the input.
     */
    public static void skipWhitespace() {
        while (pos < buffer.length() && Character.isWhitespace(buffer.charAt(pos))) {
            pos++;
        }
        if (pos == buffer.length()) {
            Pattern pattern = Pattern.compile("\\S*");
            Matcher matcher = pattern.matcher(in.delimiter().toString());
            if (matcher.matches()) {
                in.skip(pattern);
            }
        }
    }

    private static void readNextLine() {
        if (in.hasNextLine()) {
            buffer = in.nextLine();
        } else {
            buffer = "";
        }
        pos = 0;
    }

    /**
     * Sets the input source to the specified file.
     */
    public static void readFile(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("File name cannot be null.");
        }
        try {
            in = new Scanner(new File(fileName));
            currentFileName = fileName;
            nextFileName = null;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }
    }

    /**
     * Sets the input source to standard input.
     */
    public static void readStandardInput() {
        in = new Scanner(System.in);
        currentFileName = null;
    }

    /**
     * Sets the output destination to the specified file.
     */
    public static void writeFile(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("File name cannot be null.");
        }
        try {
            out = new PrintWriter(new FileWriter(fileName));
            nextFileName = fileName;
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot open file for output: " + fileName);
        }
    }

    /**
     * 지정된 파일에 데이터를 추가할 수 있도록 출력 대상을 설정합니다.
     */
    public static void appendFile(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("File name cannot be null.");
        }
        try {
            out = new PrintWriter(new FileWriter(fileName, true));
            nextFileName = fileName;
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot open file for append: " + fileName);
        }
    }

    /**
     * Sets the output destination to standard output.
     */
    public static void writeStandardOutput() {
        out = new PrintWriter(System.out);
        nextFileName = null;
    }

    /**
     * Prints the specified object to the output destination.
     */
    public static void put(Object x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints the specified object to the output destination, followed by a newline.
     */
    public static void putln(Object x) {
        out.println(x);
        out.flush();
    }

    /**
     * Prints a newline to the output destination.
     */
    public static void putln() {
        out.println();
        out.flush();
    }

    /**
     * Prints a formatted string to the output destination.
     */
    public static void putf(String format, Object... args) {
        out.printf(format, args);
        out.flush();
    }

}