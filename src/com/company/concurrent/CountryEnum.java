package com.company.concurrent;

public enum  CountryEnum {

    ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕"),
    FOUR(4, "赵"), FIVE(5, "魏"), SIX(6, "韩");

    private Integer retCode;
    private String retMessage;

    public Integer getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static String getCountryEnum(int index) {
        for (CountryEnum countryEnum : values()) {
            if (countryEnum.getRetCode() == index){
                return countryEnum.retMessage;
            }
        }
        return "";
    }
}
