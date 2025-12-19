import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LineTooLongException extends RuntimeException {
    public LineTooLongException(String message) {
        super(message);
    }
}

public class FileLineReader {
    public static void main(String[] args) {
        String path = "C:\\Users\\geo\\Downloads\\access (2).log"; // Укажите путь к вашему файлу
        int lineCount = 0;
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;

        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                int length = line.length();

                // Проверка на длину строки
                if (length > 1024) {
                    throw new LineTooLongException("Строка длиннее 1024 символов: " + length);
                }

                // Обновление максимальной и минимальной длины
                if (length > maxLength) {
                    maxLength = length;
                }
                if (length < minLength) {
                    minLength = length;
                }
            }

            // Закрываем BufferedReader
            reader.close();

            // Вывод результатов
            System.out.println("Общее количество строк: " + lineCount);
            System.out.println("Длина самой длинной строки: " + maxLength);
            System.out.println("Длина самой короткой строки: " + (minLength == Integer.MAX_VALUE ? 0 : minLength));

        } catch (LineTooLongException ex) {
            System.err.println("Ошибка: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Ошибка при чтении файла: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Произошла ошибка: " + ex.getMessage());
        }
    }
}