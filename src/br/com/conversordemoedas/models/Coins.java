package br.com.conversordemoedas.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Coins {
        private double dolar;
        private double pesoArgentino;
        private double guaraniParaguaio;
        private double real;
        private double riyalSaudita;
        private double pesoColombiano;
        private double pesoChileno;

        public Coins(){};

        public Coins (HashMap<String, Double> conversionRatesHashMap) {
                this.dolar = conversionRatesHashMap.get("USD");
                this.pesoArgentino = conversionRatesHashMap.get("ARS");
                this.guaraniParaguaio = conversionRatesHashMap.get("PYG");
                this.real = conversionRatesHashMap.get("BRL");
                this.riyalSaudita = conversionRatesHashMap.get("SAR");
                this.pesoColombiano = conversionRatesHashMap.get("COP");
                this.pesoChileno = conversionRatesHashMap.get("CLP");
        };

        public double getDolar() {
                return dolar;
        }

        public double getPesoArgentino() {
                return pesoArgentino;
        }

        public double getGuaraniParaguaio() {
                return guaraniParaguaio;
        }

        public double getReal() {
                return real;
        }

        public double getRiyalSaudita() {return riyalSaudita;}
        
        public double getPesoColombiano () {return pesoColombiano;}
        public double getPesoChileno () {return pesoChileno;}
        
        public double getCoinValue (String currency) {
            return switch (currency) {
                case "USD" -> getDolar();
                case "ARS" -> getPesoArgentino();
                case "PYG" -> getGuaraniParaguaio();
                case "BRL" -> getReal();
                case "SAR" -> getRiyalSaudita();
                case "COP" -> getPesoColombiano();
                case "CLP" -> getPesoChileno();
                    default -> throw new IllegalStateException("Unexpected value: " + currency);
            };
        }


        public List<String> createListOfAllCoins() {
                List<String> coins = new ArrayList<>();
                coins.add("USD");
                coins.add("ARS");
                coins.add("PYG");
                coins.add("BRL");
                coins.add("SAR");
                coins.add("COP");
                coins.add("CLP");
                return coins;
        }

        @Override
        public String toString() {
                return "Coins{" +
                        "dolar=" + dolar +
                        ", pesoArgentino=" + pesoArgentino +
                        ", guaraniParaguaio=" + guaraniParaguaio +
                        ", real=" + real +
                        ", riyalSaudita=" + riyalSaudita +
                        ", pesoColombiano=" + pesoColombiano +
                        ", pesoChileno=" + pesoChileno +
                        '}';
        }
}
