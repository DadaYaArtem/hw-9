package ThirdTask.search;

import java.io.File;

public class ContentReaderTests {
    public static void main(String[] args) {
        FileContentReader fileContentReader = new ContentReader();
        Selection selector = new Selection();
        String content = fileContentReader.read(new File("src/ThirdTaskFile.txt"));
        System.out.println(content);
        selector.select(content);
    }
}
