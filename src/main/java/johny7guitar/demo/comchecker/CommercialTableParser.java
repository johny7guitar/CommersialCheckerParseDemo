package johny7guitar.demo.comchecker;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CommercialTableParser {

    private CommercialTableParser(){}

    public static Element getTable(Document doc){

        Optional<Element> table = doc.select("table")
                .stream()
                .filter(new CommercialEntityTableFilter())
                .findFirst();

        if(table.isEmpty()) throw new IllegalArgumentException("Table not found");

        return table.get();

    }

    public static Map<String, String> getValuesMap(Document doc){
        return getValuesMap(getTable(doc));
    }

    public static Map<String, String> getValuesMap(Element table){
        if(!new CommercialEntityTableFilter().test(table)) throw new IllegalArgumentException("Invalid input table");
        Elements elements = table.getElementsByTag("tr");
        List<String> names = rowToValues(elements.get(1));
        List<String> values = rowToValues(elements.get(2));

        Map<String, String> result = new HashMap<>();
        for(int i = 0; i < names.size(); i++){
            result.put(names.get(i), values.get(i));
        }

        return result;
    }

    public static String getValue(Element table, String property){
        if(!new CommercialEntityTableFilter().test(table)) throw new IllegalArgumentException("Invalid input table");

        Elements elements = table.getElementsByTag("tr");
        List<String> names = rowToValues(elements.get(1));
        List<String> values = rowToValues(elements.get(2));

        for(int i = 0; i < names.size(); i++){
            if(names.get(i).equals(property)) return values.get(i);
        }

        return "Value not found";

    }

    private static List<String> rowToValues(Element row){
        return row.getElementsByTag("td")
                .stream()
                .map(Element::text)
                .toList();
    }

}
