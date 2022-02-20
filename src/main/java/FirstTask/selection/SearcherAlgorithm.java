package FirstTask.selection;

import java.util.StringJoiner;

public class SearcherAlgorithm implements ContentSearcher {
    @Override
//    public boolean search(String content) {
//        char[] chars = content.trim().toCharArray();
//        if ((chars.length == 12 && chars[3] == '-' && chars[7] == '-') || (chars.length == 14 && chars[0] == '(' && chars[4] == ')' && chars[5] == ' ' && chars[9] == '-')){
//            return true;
//        }
//        return false;
//    }
    public String search(String content) {
        StringJoiner result = new StringJoiner("\n");
        String[] split = content.split("\n");
        for (int i = 0; i < split.length; i++) {
            char[] chars = split[i].toCharArray();
            if ((chars.length == 12 && chars[3] == '-' && chars[7] == '-') || (chars.length == 14 && chars[0] == '(' && chars[4] == ')' && chars[5] == ' ' && chars[9] == '-')) {
                result.add(split[i]);
            }
        }
        return result.toString();
    }
}
