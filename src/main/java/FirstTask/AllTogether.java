package FirstTask;


import FirstTask.search.ContentReader;
import FirstTask.search.FileContentReader;
import FirstTask.selection.ContentSearcher;
import FirstTask.selection.SearcherAlgorithm;

import java.io.File;

public class AllTogether {
    public void printResults(File file){
        FileContentReader fileContentReader = new ContentReader();
        ContentSearcher contentSearcher = new SearcherAlgorithm();
        String content = fileContentReader.read(file);
        System.out.println(contentSearcher.search(content));
    }
}
