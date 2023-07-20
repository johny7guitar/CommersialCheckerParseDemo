package johny7guitar.demo.comchecker;

import org.jsoup.nodes.Document;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Map;

public class Demo {

    public static void main(String[] args){

        try {
            Document doc = DocumentRetriever.getPage();
            Map<String, String> properties = CommercialTableParser.getValuesMap(doc);

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(properties);
            System.out.println(json);

            System.out.println("---- Search certain properties ----");
            Element table = CommercialTableParser.getTable(doc);
            System.out.printf("\"Maliyyə ili\": %s%n", CommercialTableParser.getValue(table, "Maliyyə ili"));
            System.out.printf("\"Hüquqi ünvanı\": %s%n", CommercialTableParser.getValue(table, "Hüquqi ünvanı"));


        }catch(IOException e){
            System.err.println("Can't retrieve document");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
