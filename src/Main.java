import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int validFileCount = 0; // Счетчик корректных путей к файлам

        while (true) {
            System.out.print("Введите путь к файлу:");
            String path = scanner.nextLine(); // Запрашиваем путь к файлу

            File file = new File(path); // Создаем объект File
            boolean fileExists = file.exists(); // Проверяем, существует ли файл
            boolean isDirectory = file.isDirectory(); // Проверяем, является ли путь директорией

            // Проверяем условия
            if (!fileExists || isDirectory) {
                // Если файл не существует или это директория
                System.out.println("Указанный файл не существует или это путь к папке. Попробуйте снова.");
                continue; // Продолжаем цикл
            }

            // Если файл существует и это не директория
            validFileCount++; // Увеличиваем счетчик
            System.out.println("Путь указан верно.");
            System.out.println("Это файл номер " + validFileCount);
        }
    }
}


