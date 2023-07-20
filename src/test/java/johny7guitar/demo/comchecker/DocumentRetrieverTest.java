package johny7guitar.demo.comchecker;

import johny7guitar.demo.comchecker.DocumentRetriever;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentRetrieverTest {

    @Test
    void getPageTest(){
        assertDoesNotThrow(DocumentRetriever::getPage);
    }

}