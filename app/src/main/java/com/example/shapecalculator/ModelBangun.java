package com.example.shapecalculator;

public class ModelBangun {
    String gambarBangun, namaBangun;

    public ModelBangun(String namaBangun , String gambarBangun) {
        this.namaBangun = namaBangun;
        this.gambarBangun = gambarBangun;
    }

    public String getGambarBangun() {
        return gambarBangun;
    }

    public String getNamaBangun() {
        return namaBangun;
    }
}
