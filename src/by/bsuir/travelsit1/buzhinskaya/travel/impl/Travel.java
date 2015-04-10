/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.travelsit1.buzhinskaya.travel.impl;

import by.bsuir.travelsit1.buzhinskaya.country.Country;
import by.bsuir.travelsit1.buzhinskaya.travel.TravelAgency;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Veronika
 */
public class Travel implements TravelAgency{

Map<String,Country> coun = new HashMap <String, Country>();

public Travel(){
Country con1 = new Country("Italy"); 
coun.put("1",con1);  

Country con2 = new Country("Germany"); 
coun.put("2", con2);

Country con3 = new Country("Britain"); 
coun.put("3", con3);
}

public List<String> getListCountries (){
    File directory = new File("Countries");
    String[] directories = directory.list();
    List<String> dir= new ArrayList<String>();
    for(String directoryName : directories)
    {
        dir.add(directoryName);
    }
    return dir;
}
    
public List<String> getListCity( String country){
    File directory = new File ("Countries\\" + country);
    String[] directories = directory.list();
    List<String> dir = new ArrayList<String>();
    for(String directoryName : directories)
    {
        directoryName = directoryName.replace(".txt","");
        dir.add(directoryName);
    }
    return dir;
      
}

public String getdescriptionCity ( String country, String city) {
    File description = new File("Countries\\" + country +"\\" + city +".txt");
    try{
        BufferedReader reader = new BufferedReader (new FileReader(description));
        StringBuilder str = new StringBuilder();
        String line;
        while((line=reader.readLine())!=null)
        {
            str.append(line).append("\n");
        }
        return str.toString();
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }
    return null;
} 

}