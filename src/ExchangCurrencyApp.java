public class ExchangCurrencyApp {

    public static void main (String[] args){

        ExchangeAPI ex = new ExchangeAPI();

        // test connection with THB
        if (ex.getConnection("THB")){
            System.out.println(ex.getConversion_rates());
        }
    }
}
