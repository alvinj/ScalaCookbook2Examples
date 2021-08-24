package r01_collections;

import java.util.*;


// pp. 648-649
public class JavaCollections {

    public static List<Integer> getNumbers() {
        return new ArrayList<Integer>(List.of(1,2,3));
    }

    public static Map<String, String> getPeeps() {
        return new HashMap<String, String>(Map.of(
            "Captain", "Kirk",
            "Mr.", "Spock"
        ));
    }
    
}


