package br.com.conversordemoedas.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

public class JsonProcessor {

    public HashMap<String, Double> DataSerializer(String jsonBody) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        JsonObject jsonObject = gson.fromJson(jsonBody, JsonObject.class);
        JsonObject conversionRatesObject = jsonObject.getAsJsonObject("conversion_rates");
        Type tipoHashMap = new TypeToken<HashMap<String,Double>>(){}.getType();
        HashMap<String, Double> conversionRatesHashMap = gson.fromJson(conversionRatesObject, tipoHashMap);
        return conversionRatesHashMap;
    }
}
