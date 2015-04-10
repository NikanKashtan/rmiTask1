/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.travelsit1.buzhinskaya.travel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Veronika
 */
public interface TravelAgency extends Remote{
    public List<String> getListCountries ()throws RemoteException;
    public List<String> getListCity( String country)throws RemoteException;
    public String getdescriptionCity ( String country, String city) throws RemoteException;
}
