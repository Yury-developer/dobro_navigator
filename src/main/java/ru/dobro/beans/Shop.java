package ru.dobro.beans;


public class Shop {

    private int number;   // порядковый номер открытия в структуре ДОБРОЦЕН
    private ShopAddressLocation shopAddressLocation;   // физический адрес магазина



    public Shop() {
    }

    public Shop(int number, ShopAddressLocation shopAddressLocation) {
        this.number = number;
        this.shopAddressLocation = shopAddressLocation;
    }



    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public ShopAddressLocation getShopAddressLocation() {
        return shopAddressLocation;
    }
    public void setShopAddressLocation(ShopAddressLocation shopAddressLocation) {
        this.shopAddressLocation = shopAddressLocation;
    }

}