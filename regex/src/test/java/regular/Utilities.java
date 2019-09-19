package regular;

import io.qameta.allure.Step;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

class Utilities {

    @Step
    static BigDecimal parsePrice(String value, Locale locale) throws ParseException {
        NumberFormat fmt = NumberFormat.getNumberInstance(locale);
        ((DecimalFormat) fmt).setParseBigDecimal(true);
        return (BigDecimal) fmt.parse(value);
    }
}
