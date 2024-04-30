import br.com.conversordemoedas.models.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Connection connection = new Connection();
        ApiConfig config = new ApiConfig("https://v6.exchangerate-api.com/v6/b2a1328665fc8af03aa36758/latest/");
        JsonProcessor processor = new JsonProcessor();
        menu.showMenu(config);
        String url = config.getApiUrl();
        String jsonBodyResponse = connection.createConnection(url);
        Coins coins = new Coins(processor.DataSerializer(jsonBodyResponse));
        //System.out.println(coins.toString());
        Calculator calculator = new Calculator();
        double result = calculator.convertCurrency(menu.getValue(), menu.getFirstCoin(), menu.getSecondCoin(), coins);
        System.out.println("O resultado da conversão de " + menu.getValue()
                + menu.getFirstCoin() + " para " + menu.getSecondCoin() + " é " + result);
    }
}