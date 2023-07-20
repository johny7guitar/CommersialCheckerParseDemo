package johny7guitar.demo.comchecker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class DocumentRetriever {

    private static final String URL = "https://www.e-taxes.gov.az/ebyn/commersialChecker.jsp";

    private DocumentRetriever(){}

    public static Document getPage() throws IOException{
            return Jsoup.connect(URL)
                    .data("name", "1406221141")
                    .data("tip", "2")
                    .data("sub_mit", "1")
                    .post();
    }

}
