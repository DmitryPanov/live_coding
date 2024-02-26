package coding.livecode28_07;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CalculateBruttoImpl implements CalculateBrutto {

    private static Map<String, BigDecimal> mapCountryProcent = new HashMap<>();

    public static void init() {
        mapCountryProcent.put("RU", BigDecimal.valueOf(0.13));
        mapCountryProcent.put("DE", BigDecimal.valueOf(0.19));
    }

    @Override
    public BigDecimal calculateBrutto(Integer sum, String countryCode) {
        BigDecimal bigDecimal =mapCountryProcent.get(countryCode);
        BigDecimal bigDecimalProcent = BigDecimal.valueOf(sum).subtract(bigDecimal.multiply(BigDecimal.valueOf(sum)));
        return bigDecimalProcent;
    }
}
