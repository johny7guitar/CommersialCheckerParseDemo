package johny7guitar.demo.comchecker;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class CommercialEntityTableFilterTest {

    private static final String TEST_PAGE = "/test_filter_page.html";

    @Test
    void test(){

        final AtomicReference<Elements> elements = new AtomicReference<>();

        assertDoesNotThrow(() ->
                elements.set(Jsoup.parse(this.getClass().getResourceAsStream(TEST_PAGE), "utf-8", "")
                        .getAllElements()));

        final CommercialEntityTableFilter testFilter = new CommercialEntityTableFilter();

        assertEquals(1, elements.get().stream()
                .filter(testFilter)
                .count());

    }

}