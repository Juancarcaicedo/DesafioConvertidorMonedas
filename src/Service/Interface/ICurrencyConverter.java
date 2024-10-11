package Service.Interface;

public interface ICurrencyConverter {
    double getConversionRate(String baseCurrency, String targetCurrency) throws Exception;
    double convertAmount(String baseCurrency, String targetCurrency, double amount) throws Exception;
}
