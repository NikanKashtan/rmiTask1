/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.travelsit1.buzhinskaya.client;

import by.bsuir.travelsit1.buzhinskaya.travel.TravelAgency;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Veronika
 */
public class EnterPoint {

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
// Получаем стаб регистратора с хоста, определенного в командной строке
// если в командной строке хост не указывается, то он считается как localhost
            Registry registry = LocateRegistry.getRegistry(host);
// получаем стаб удаленного объекта от регистратора сервера
            TravelAgency tr = (TravelAgency) registry.lookup("TravelAgency");
            Scanner cin = new Scanner(System.in);
            while (true) {
                System.out.println("Select the country in which you would like to visit:");
                List<String> countries = tr.getListCountries();
                for (int i = 0; i < countries.size(); i++) {
                    System.out.println((i + 1) + ". " + countries.get(i));
                }
                int choise = enterInt(cin, 0, countries.size());
                System.out.println("Select city in which you would like to visit:");
                List<String> cities = tr.getListCity(countries.get(choise - 1));
                for (int i = 0; i < cities.size(); i++) {
                    System.out.println((i + 1) + ". " + cities.get(i));
                }
                int cityChoise = enterInt(cin, 0, cities.size());
                System.out.println("The information about the city:");
                System.out.println(tr.getdescriptionCity(countries.get(choise - 1), cities.get(cityChoise - 1)));

                System.out.println("Do you like to try again? \n1.yes\n2.no");
                choise = enterInt(cin, 0, 2);
                if (choise == 1) {
                    continue;
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
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
                    System.out.println("Enter the number between " + (begin + 1) + " and " + end);
                    continue;
                }
            } catch (Exception ex) {
                System.out.println("Enter number");
                continue;
            }

        }
    }
}















































































































































































































































































































































































































































































































































