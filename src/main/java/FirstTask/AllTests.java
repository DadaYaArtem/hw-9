package FirstTask;


import java.io.File;

public class AllTests {
    public static void main(String[] args) {
        File file = new File("src/FirstTaskFile.txt");
        new AllTogether().printResults(file);
    }
}
