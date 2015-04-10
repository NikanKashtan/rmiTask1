/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.travelsit1.buzhinskaya.server;

import by.bsuir.travelsit1.buzhinskaya.travel.impl.Travel;
import by.bsuir.travelsit1.buzhinskaya.travel.TravelAgency;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Veronika
 */
public class EnterPoint {

    public static void main(String[] args) {
       try {
// создаем и экспортируем удаленный объект
			Travel obj = new Travel();
    			TravelAgency stub = 
				(TravelAgency) UnicastRemoteObject.exportObject(obj, 0);

// Регистрируем удаленный объект в RMI-регистраторе под именем
                        LocateRegistry.createRegistry(1099);
			 Registry registry = LocateRegistry.getRegistry();
   			 registry.bind("TravelAgency", stub);

  			 System.err.println("Server ready");
		} catch (Exception e) {
			    System.err.println("Server exception: " + e.toString());
			    e.printStackTrace();
		}

    }

    private static int enterInt(Scanner sc, int begin, int end) {
        int result = 0;
        while (true) {
            try {
                result = sc.nextInt();
                if (result > begin && result <= end) {
                    return result;
                } else {
                    System.out.println("Enter the number between " + (begin+1) + " and " + end);
                    continue;
                }
            } catch (Exception ex) {
                System.out.println("Enter number");
                continue;
            }

        }
    }

}
