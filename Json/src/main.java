import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONObject;



public class main   {
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
        Napoj napoj = new Napoj();
        napoj.setMnozstvoo(10);
        Item napojeCena = new Item();
        Map<Integer, String> napoje = new HashMap<>();
        napoje.put(1, "Fantu");
        napoje.put(2, "Kofolu");
        napoje.put(3, "Aloe-Veru");
        napoje.put(4, "Monstera");
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
            if (napoje.containsKey(vyber)) {
                Path p = Path.of("studeneNapoje.json");
                String ukladac = Files.readString(p);
                JSONObject ukladacMnozstva = new JSONObject(ukladac);
                int mnozstvooo = ukladacMnozstva.getInt("Mnozstvo");
                mnozstvooo--;
                napoj.setMnozstvoo(mnozstvooo);
                ukladacMnozstva.put("Mnozstvo", mnozstvooo);
                try(PrintWriter writer = new PrintWriter("studeneNapoje.json")){
                    writer.println(ukladacMnozstva);
                }
                    if (mnozstvooo == 0) {
                        System.out.println("Produkt je vzpredany");
                        System.exit(0);
                        Thread.sleep(1000);
                        studenyNapoj();
                }
                System.out.println("Vybrali ste si  " + napoje.get(vyber) +  ", cena je " + napojeCena.getCena() + " Eur");
                platba();
                
            }else{
                System.out.println("Naplatny vystup");
                studenyNapoj();
            }
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            System.exit(0);
        }
    }
    public static void teplyNapoj() throws InterruptedException{
        Item napojeCena = new Item();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Latte");
        map.put(2, "Cappuccino");
        map.put(3, "Americano");
        map.put(4, "Espreso");
        napojeCena.setCena(1.8);
        Napoj napoj = new Napoj();
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
        
        try {
                int vyber = scanner.nextInt();
                Path p = Path.of("tepleNapoje.json");
                String ukladac = Files.readString(p);
                JSONObject ukladacMnozstva = new JSONObject(ukladac);
                int mnozstvooo = ukladacMnozstva.getInt("Mnozstvo" + " " +  map.get(vyber));
                mnozstvooo--;
                napoj.setMnozstvoo(mnozstvooo);
                ukladacMnozstva.put("Mnozstvo" + " " +  map.get(vyber), mnozstvooo);
                    if (map.containsKey(vyber)) {
                        try(PrintWriter writer = new PrintWriter("tepleNapoje.json")){
                        writer.println(ukladacMnozstva);
                    }
                    System.out.println("Vybrali ste si  " + map.get(vyber) +  ", cena je " + napojeCena.getCena() + " Eur");
                    platba();
                        if (mnozstvooo == 0) {
                            System.out.println("Produkt je vypredany");
                            System.exit(0);
                            Thread.sleep(1000);
                            teplyNapoj();
                        }
                        

            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
            teplyNapoj();
        }
        scanner.close();
    }
    public static void platba() throws InterruptedException {
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

                if (ciastka < napojeCena.getCena()) {
                    System.out.println("Nemas dostatok!");
                    Thread.sleep(1000);
                    platba();
                    System.exit(0);
                }
                else if(ciastka > 10){
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