package com.example.shapecalculator;

public class ModelBangun {
    String gambarBangun, namaBangun, rumusBangun;

    public ModelBangun(String namaBangun , String gambarBangun, String rumusBangun) {
        this.namaBangun = namaBangun;
        this.gambarBangun = gambarBangun;
        this.rumusBangun = rumusBangun;
    }

    public String getGambarBangun() {
        return gambarBangun;
    }

    public String getNamaBangun() {
        return namaBangun;
    }

    public String getRumusBangun() {
        return rumusBangun;
    }
}
