package johny7guitar.demo.comchecker;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Predicate;

public class CommercialEntityTableFilter implements Predicate<Element> {

    private static final String TABLE_TITLE = "Kommersiya qurumunun hüquqi şəxslərin dövlət reyestrinə daxil edilmiş məlumatları";

    @Override
    public boolean test(Element element) {
        if(!element.tagName().equals("table")) return false;

        Elements rows = element.getElementsByTag("tr");
        if(rows.isEmpty()) return false;

        Elements columns = rows.get(0).getElementsByTag("td");
        if(columns.size() != 1) return false;

        return normalize(columns.get(0).text()).equals(normalize(TABLE_TITLE));

    }

    private String normalize(String val){
        return val.toLowerCase().replaceAll("//s+", " ");
    }

}
