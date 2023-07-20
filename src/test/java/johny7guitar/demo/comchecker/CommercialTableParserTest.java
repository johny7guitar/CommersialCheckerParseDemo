package johny7guitar.demo.comchecker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;

import javax.print.Doc;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class CommercialTableParserTest {

    private static final String TEST_PAGE = "/get_table_test_page.html";
    private static final String MAP_TEST_PAGE = "/map_values_test_page.html";

    @Test
    void getTableTest(){

        AtomicReference<Element> table = new AtomicReference<>();
        assertDoesNotThrow(() -> {
            Document testDocument = Jsoup.parse(this.getClass().getResourceAsStream(TEST_PAGE), "utf-8", "");
            table.set(CommercialTableParser.getTable(testDocument));
        });

        assertNotNull(table.get());

    }

    @Test
    void mapValuesTest(){

        final AtomicReference<Map<String, String>> valuesMapRef = new AtomicReference<>();
        assertDoesNotThrow(() -> {
            Document testDoc = Jsoup.parse(this.getClass().getResourceAsStream(MAP_TEST_PAGE), "utf-8", "");
            valuesMapRef.set(CommercialTableParser.getValuesMap(testDoc));
        });

        assertNotNull(valuesMapRef);
        assertEquals(3, valuesMapRef.get().size());
        assertEquals("55", valuesMapRef.get().get("test_property_1"));
        assertEquals("22", valuesMapRef.get().get("test_property_2"));
        assertEquals("58", valuesMapRef.get().get("test_property_3"));

    }

}