import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Random;

public class ParserComplements {

    private Document doc;

    public String init() {
        return getWeb();
    }


    private String getWeb() {
        try {
            doc = Jsoup.connect("https://t-loves.narod.ru/komplimenty-devushke.htm").get();
            Elements complements = doc.getElementsByTag("p");

            int min = 0;
            int max = complements.size()-1;
            int diff = max - min;
            Random random = new Random();
            int i = random.nextInt(diff + 1) + min;

            String complement = complements.get(i).text();
            return complement;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}