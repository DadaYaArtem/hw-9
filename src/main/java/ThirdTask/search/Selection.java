package ThirdTask.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Selection {
    public void select(String content) {
        String[] s = content.split(" ");
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < s.length; i++) {
            list.add(s[i]);
        }

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String string : list) {
            if (map.keySet().contains(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }

        System.out.println(map);
    }
}
