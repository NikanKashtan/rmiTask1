/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.travelsit1.buzhinskaya.city;

/**
 *
 * @author Veronika
 */
public class City {
    
    public String city;
    public String description;

    public City(String city, String description) {
        this.city = city;
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
