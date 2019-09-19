package regular;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static regular.Utilities.parsePrice;

/**
 * task#2
 * ---------------
 * 1. extract all price values from string into List<>:
 * "product1: 12.50$; product2: 13$; product3: 1 598.00$"
 * Note: you MUST use regex for this task
 * 2. increase each price by 1$ and print all  them into console
 */

public class RegexTest {

    @DataProvider(name = "data-provider")
    public Object[] dataProviderMethod() {
        return new Object[][]{{"product1: 12.50$; product2: 13$; product3: 1 598.00$"}};
    }

    @Test(dataProvider = "data-provider")
    public void parseStringUsingRegexTest(String data) throws ParseException {
        List<BigDecimal> allMatches = new ArrayList<>();
        Matcher m = Pattern.compile("(?<=:)(.*?)(?=\\$)")
                .matcher(data);
        while (m.find()) {
            allMatches.add(parsePrice(m.group().replace(" ", ""), Locale.US));
        }
        allMatches.stream().map(match -> match.add(BigDecimal.ONE)).map(add -> add + "$").forEach(System.out::println);
    }
}