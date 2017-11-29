import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String inFile = "D:/Users/Олег/Excel/src/input.csv";
        String outFile = "D:/Users/Олег/Excel/src/output.csv";
        String firstName;
        String age;
        String lastName;

        Excel.initial(inFile);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "Что вы планируете делать?" +
                            "1. Добавить нового пользователя" +
                            "2. Изменить существующего пользователя" +
                            "3. Выход");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("имя");
                    firstName = scanner.next();
                    System.out.println();
                    System.out.println("фамилия");
                    lastName = scanner.next();
                    System.out.println();
                    System.out.println("возраст");
                    age = scanner.next();
                    System.out.println();
                    Excel.addUsers(firstName, lastName, age);
                    FileUtils.print(Excel.get());
                    continue;
                default:
                    System.out.println("вводить только 1 или 2");
                    break;
            }
        }
    }
}





