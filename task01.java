import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


// Задача №1. 1. Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
// 1 Расширение файла: txt
// 2 Расширение файла: pdf
// 3 Расширение файла:
// 4 Расширение файла: jpg 
public class task01 {
    public static void main(String[] args) {
        File dir = new File("C:/Users/dmitriy_di/Desktop/Java_test");
        File[] files = dir.listFiles();

        File file = new File("C:/Users/dmitriy_di/Desktop/Education GeekBrains/Second quarter/Java/Java-Homework2/file1.txt");
        try (PrintWriter wr = new PrintWriter(file)) {
            for (int i = 0; i < files.length; i++) {
                wr.println(files[i]);
            }
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        try (BufferedReader br = new BufferedReader(new FileReader("file1.txt"))) {
            String str;
            String str1 = "";
            String result = "";
            int count = 1;
            while ((str = br.readLine()) != null) {
                for (int i = str.length()-1; i > str.length()-4; i--) {
                    str1+=str.charAt(i);
                }
                for (int j = str1.length()-1; j >= 0; j--) {
                    result+=str1.charAt(j);
                }
                System.out.printf("%d Расширение файла: %s\n", count, result);
                str1="";
                result="";
                count+=1;
            }
        br.close();
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
