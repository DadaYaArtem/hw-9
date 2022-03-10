package ThirdTask;

import java.util.*;
import java.util.stream.Collectors;

public class Selection {
    public void select(String content) {
        String[] s = content.split(" ");
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < s.length; i++) {
            list.add(s[i].trim().toLowerCase().replaceAll("\\pP", ""));
        }

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String string : list) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }

        map = map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));

        System.out.println(map);
    }
}
