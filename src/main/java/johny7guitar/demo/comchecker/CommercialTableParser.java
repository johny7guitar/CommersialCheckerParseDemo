package johny7guitar.demo.comchecker;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

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

}
