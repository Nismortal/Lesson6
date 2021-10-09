import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static int substringCount(String s, String substring) {
        int result = 0;
        for (int i = 0; i < s.length() - substring.length(); i++) {
            if (s.substring(i, i + substring.length()).equalsIgnoreCase(substring)) {
                result++;
                i += substring.length();
            }
        }
        return result;
    }

    private static String readUsingScanner(String fileName) throws IOException {
        Scanner scanner = new Scanner(Paths.get(fileName), "Windows-1251");
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        scanner.useDelimiter(ls);
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.next());
            stringBuilder.append(ls);
        }
        scanner.close();
        return stringBuilder.toString();
    }

    private static String read(String fileName) throws IOException {
        File fileInput = new File(fileName);
        FileInputStream inputStream = new FileInputStream(fileInput);

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        inputStream.close();
        Charset w1251 = Charset.forName("Windows-1251");

        return new String(buffer, w1251);
    }

    public static void main(String[] args) {
        String fileName = "C:\\Users\\Magistr\\Downloads\\Telegram Desktop\\tols.txt";
        String substring = "страда";
        //страда - корень слова страдание, что обеспечивает независимость от регистра

        try {
            String s1 = read(fileName);
            System.out.println(s1);
            System.out.println(substringCount(s1, substring));
            //страда - корень слова страдание, что обеспечивает независимость от регистра
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String s1 = readUsingScanner(fileName);
            System.out.println(substringCount(s1, substring));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



