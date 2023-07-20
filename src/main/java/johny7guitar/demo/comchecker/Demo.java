package johny7guitar.demo.comchecker;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

public class Demo {

    public static void main(String[] args){

        try {
            Document doc = DocumentRetriever.getPage();
            Map<String, String> properties = CommercialTableParser.getValuesMap(doc);
            properties.keySet().forEach(key ->
                    System.out.printf("\"%s\": \"%s\"%n", key, properties.get(key)));
        }catch(IOException e){
            System.err.println("Can't retrieve document");
        }

    }

}
