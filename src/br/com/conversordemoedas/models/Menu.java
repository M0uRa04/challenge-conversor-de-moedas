package br.com.conversordemoedas.models;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private String firstCoin;
    private String secondCoin;

    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getFirstCoin() {
        return firstCoin;
    }

    public String getSecondCoin() {
        return secondCoin;
    }

    public String coinPicker(int option) {
        Coins coins = new Coins();
        List<String> listOfCoins = coins.createListOfAllCoins();
        return listOfCoins.get(option);
    }

    public void showMenu(ApiConfig config) {
        int option;
        Scanner keyboard = new Scanner(System.in);
        try {

            do  {
                System.out.println("**************************************************************");
                System.out.println("Seja bem vindo(a) ao conversor de moedas!");
                System.out.println("Por favor selecione uma opção abaixo: ");
                System.out.println("1 - Conversão de Moedas");
                System.out.println("0 - Para sair ");
                System.out.println("**************************************************************");
                option = keyboard.nextInt();
                if (option == 1) {
                    System.out.println("**************************************************************");
                    System.out.println("Por favor selecione a moeda que deseja converter abaixo: ");
                    System.out.println("1 - Dólar Americano (USD)");
                    System.out.println("2 - Peso Argentino (ARS)");
                    System.out.println("3 - Guarani paraguaio (PYG)");
                    System.out.println("4 - Real (BRL)");
                    System.out.println("5 - Riyal saudita (SAR)");
                    System.out.println("6 - Peso Colombiano (COP)");
                    System.out.println("7 - Peso Chileno (CLP)");
                    System.out.println("0 - Para sair ");
                    System.out.println("**************************************************************");
                    option = keyboard.nextInt();
                    firstCoin = coinPicker(option - 1);
                    config.setApiUrl("https://v6.exchangerate-api.com/v6/b2a1328665fc8af03aa36758/latest/" + firstCoin);
                    System.out.println(firstCoin + " Selecionado(a).");

                    System.out.println("Digite um valor: ");
                    value = keyboard.nextDouble();

                    System.out.println("**************************************************************");
                    System.out.println("Por favor selecione a moeda para qual o valor será convertido: ");
                    System.out.println("1 - Dólar Americano (USD)");
                    System.out.println("2 - Peso Argentino (ARS)");
                    System.out.println("3 - Guarani paraguaio (PYG)");
                    System.out.println("4 - Real (BRL)");
                    System.out.println("5 - Riyal saudita (SAR)");
                    System.out.println("6 - Peso Colombiano (COP)");
                    System.out.println("7 - Peso Chileno (CLP)");
                    System.out.println("0 - Para sair ");
                    System.out.println("**************************************************************");
                    option = keyboard.nextInt();
                    secondCoin = coinPicker(option - 1);
                    System.out.println(secondCoin + " Selecionado(a).");
                    break;
                }
            } while ( option != 0);
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Valor inesperado digitado: " + e.getMessage());
        }
    }

}
