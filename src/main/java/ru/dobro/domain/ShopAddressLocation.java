package ru.dobro.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;



@Entity
@Table(name = "shop_address_location")
public class ShopAddressLocation {

    @Id   // сам разберется с генерацией   id
    @GeneratedValue(strategy = GenerationType.AUTO)   // определяет стратегию генерации уникального идентификатора с использованием SEQUENCE
    private Long id;
    private int numberOpening;   // порядковый номер открытия
    private String country;   // страна магазина
    private String region;   // обрасть магазина
    private String address;   // адрес магазина
    private double latitude;   // широта   52.38045640401889
    private double longitude;   // долгота    31.019579461886657


    public ShopAddressLocation() {
    }

    public ShopAddressLocation(int numberOpening, String country, String region, String address, double latitude, double longitude) {
        this.country = country;
        this.region = region;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }



    public int getNumberOpening() {
        return numberOpening;
    }
    public void setNumberOpening(int numberOpening) {
        this.numberOpening = numberOpening;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
