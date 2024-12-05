import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import org.json.*;

public class main {
    public static void main(String[] args) {
       uvodMenu();
    }

    public static void uvodMenu(){
        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);
        snackMenu snack = new snackMenu();
        System.out.println("Vitajte vo Kavomate, co si prajete zvolit?");
        System.out.println("1. Napoje");
        System.out.println("2. Snacky");
        System.out.println("3. Admin");
        System.out.println("4. Exit");
        int vyber = scanner.nextInt();
        try {
            if(vyber == 1){
                napoje();
            }
            if(vyber == 2){
                snack.Diddy();
            }
            if(vyber == 3){
                admin.consola();
            }
            if(vyber == 4){
                System.out.println("Dovidenia!");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
        scanner.close();

       
        
    }

    public static void napoje(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vybrali ste moznost napoje zvolte 1. pre teple a 2 pre studene");
        try {
            int vyber = scanner.nextInt();
            if(vyber == 1){
                teplyNapoj();
            }
            if(vyber == 2){
                studenyNapoj();
            }
            else{
                System.out.println("Zly vyber");
                napoje();
            }
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
        scanner.close();
    }

    public static void studenyNapoj() throws InterruptedException{
        Napoj napoj = new Napoj(10);
        JSONObject jsonObject = new JSONObject(napoj);
        int fanta = 10;
        int Kofola = 10;
        int aloeVera = 10;
        int monster = 10;
        
        
        

        Item napojeCena = new Item();
        napojeCena.setCena(1.8);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zvolili ste studeny napoj, co si date?");
        System.out.println("1. Fanta , " + napojeCena.getCena() + "Eur");
        Thread.sleep(500);
        System.out.println("2. Kofola , " + napojeCena.getCena() + "Eur");
        Thread.sleep(500);
        System.out.println("3. Aloe-Vera , " + napojeCena.getCena() + "Eur");
        Thread.sleep(500);
        System.out.println("4. Monster , " + napojeCena.getCena() + "Eur");
        System.out.println("Co si prajete?");
        int vyber  = scanner.nextInt();
        try {
            if (vyber == 1) {
                fanta--;
                try(PrintWriter writer = new PrintWriter("Napoje.json")){
                    writer.println(jsonObject);
                }
                    if (fanta == 0) {
                        System.out.println("Fanta je vypredana");
                        Thread.sleep(1000);
                        studenyNapoj();
                }
                        System.out.println("Vybrali ste si Fantu , cena je " + napojeCena.getCena() + " Eur");
                         platba();
                
            }
            if (vyber == 2) {
                Kofola--;
                System.out.println("Vybrali ste si Kofolu , cena je " + napojeCena.getCena() + " Eur");
                platba();
                FileWriter writer = new FileWriter("studeneNapoje.txt");
                writer.write("Kofola: " + Kofola + "\n");
                writer.write("\n");
                writer.close();
            }
            if (vyber == 3) {
                aloeVera--;
                System.out.println("Vybrali ste si Aloe-Veru , cena je " + napojeCena.getCena() + " Eur");
                platba();
                FileWriter writer = new FileWriter("studeneNapoje.txt");
                writer.write("Aloe-Vera: " + aloeVera + "\n");
                writer.write("\n");
                writer.close();
            }
            if (vyber == 4) {
                monster--;
                System.out.println("Vybrali ste si Monstera , cena je " + napojeCena.getCena() + " Eur");
                platba();
                FileWriter writer = new FileWriter("studeneNapoje.txt");
                writer.write("Monster: " + monster + "\n");
                writer.write("\n");
                writer.close();
            }
            if (vyber > 4 || vyber < 1) {
                System.out.println("Skus este raz: ");
                Thread.sleep(1000);
                studenyNapoj();
                
            }
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            System.exit(0);
        }

    }

    public static void teplyNapoj() throws InterruptedException{
        Item napojeCena = new Item();
        napojeCena.setCena(1.8);
        Napoj napoj = new Napoj(10);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zvolili ste si teple napoje!");
        System.out.println("Tu je nase menu: ");
        System.out.println("1. Latte , " + napojeCena.getCena() + "Eur");
        Thread.sleep(500);
        System.out.println("2. Cappuccino , " + napojeCena.getCena() + "Eur");
        Thread.sleep(500);
        System.out.println("3. Americano , " + napojeCena.getCena() + "Eur");
        Thread.sleep(500);
        System.out.println("4. Espreso , " + napojeCena.getCena() + "Eur");
        System.out.println("Co si prajete? ");
        int vyber = scanner.nextInt();
        try {
            if (vyber == 1) {
                napoj.setNapojId("Latte");
                System.out.println("Vybrali ste si " + napoj.getNapojId() +   ", cena je " + napojeCena.getCena() + " Eur");
                platba();

            }
            if (vyber == 2) {
                napoj.setNapojId("Cappuccino");
                System.out.println("Vybrali ste si " + napoj.getNapojId() +   ", cena je " + napojeCena.getCena() + " Eur");
                platba();
            }
            if (vyber == 3) {
                napoj.setNapojId("Americano");
                System.out.println("Vybrali ste si " + napoj.getNapojId() +   ", cena je " + napojeCena.getCena() + " Eur");
                platba();
            }
            if (vyber == 4) {
                napoj.setNapojId("Espreso");
                System.out.println("Vybrali ste si " + napoj.getNapojId() +   ", cena je " + napojeCena.getCena() + " Eur");
                platba();              
            }
            if (vyber > 4 || vyber < 1) {
                System.out.println("Skus este raz: ");
                Thread.sleep(1000);
                teplyNapoj();
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        scanner.close();
    }
    public static void platba() throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        
        Item napojeCena = new Item();
        napojeCena.setCena(1.8);
        System.out.println("Mate presne " + napojeCena.getCena() + " Eur ?"  + " ano/nie");
        String vyber = scanner.nextLine();
        try {
            if(vyber.equalsIgnoreCase("ano")){
                System.out.println("Prosím vložte mince do kavomatu");
                Thread.sleep(1000);
                System.out.println("Vlozili ste mince do kavomatu....");
                System.out.println("Prudukt sa pripravuje...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("Prudukt je pripraveny, Dakujeme za navstevu!");
                System.exit(0); 
    
            }
            if(vyber.equalsIgnoreCase("nie")){
                System.out.println("Zadajte presnu ciastku aku mate: ");
                int ciastka = scanner.nextInt();
                if(ciastka > 10){
                    System.out.println("Kavomat nemoze vidat taku ciastku");
                    Thread.sleep(1000);
                    platba();
                }
                else if (ciastka < 0) {
                    System.out.println("Zadali ste zlu hodnotu");
                    Thread.sleep(1000);
                    platba();
                }
                System.out.println("Tu je vas vydavok: " + (ciastka - napojeCena.getCena()) + " Eur");
                System.out.println("Produkt sa pripravuje...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("Produk je pripraveny, Dakujeme za navstevu!");
                System.exit(0);
            } 
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        scanner.close();
        
        
    }
   
}
