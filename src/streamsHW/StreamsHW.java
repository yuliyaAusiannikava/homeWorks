package streamsHW;

import java.io.*;
import java.util.Scanner;

public class StreamsHW {
    public static void main(String[] args) throws IOException {

        //1st task
        File file1 = new File("/Users/julia/Desktop/HWIOTest/first_file");
        try {
            boolean isCreated = file1.createNewFile();
            System.out.println("New file is created - " + isCreated);

            boolean isExists = file1.exists();
            if (!isExists) {
                file1.createNewFile();
                System.out.println("New file is created");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer1 = new FileWriter(file1)){
            String text1 = "Hello Java developer!";
            writer1.write(text1);
            System.out.println("Text appended in file");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //2nd task
        try(FileReader reader1 = new FileReader(file1)){
            int c;
            while ((c = reader1.read()) != -1){
                if (Character.isLowerCase(c)){
                    c = Character.toUpperCase(c);
                }
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //3 task
        System.out.println();
        updateFile("/Users/julia/Desktop/HWIOTest/first_file", "\nOlolololo\n", 0);





    }

    public static void updateFile (String path, String textToUpdate, int num){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество повторений добавления текста: ");
        num = sc.nextInt();
        try (Writer writer = new BufferedWriter(new FileWriter(path, true))){
            for (int i = 1; i <= num; i++){
                writer.write(textToUpdate);
            }
            System.out.println("Текст добавлен в выбранный файл " + num + " раз(а)");
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

}
