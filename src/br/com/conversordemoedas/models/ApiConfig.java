package br.com.conversordemoedas.models;

public class ApiConfig {
    private String apiUrl;

    public ApiConfig(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public ApiConfig() {}

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}
