package johny7guitar.demo.comchecker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import javax.print.Doc;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class CommercialTableParserTest {

    private static final String TEST_PAGE = "/get_table_test_page.html";

    @Test
    void getTableTest(){

        AtomicReference<Element> table = new AtomicReference<>();
        assertDoesNotThrow(() -> {
            Document testDocument = Jsoup.parse(this.getClass().getResourceAsStream(TEST_PAGE), "utf-8", "");
            table.set(CommercialTableParser.getTable(testDocument));
        });

        assertNotNull(table.get());

    }

}