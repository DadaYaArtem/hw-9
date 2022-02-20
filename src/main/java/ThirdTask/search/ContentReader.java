package ThirdTask.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringJoiner;

public class ContentReader implements FileContentReader {
    @Override
    public String read(File file) {
        StringJoiner result = new StringJoiner(" ");
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNextLine()){
                result.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result.toString().replaceAll(" {2,}", " ");
    }

}
