import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import netscape.javascript.JSObject;
import org.json.*;

public class snackMenu {
    
    public static void main(String[] args) throws InterruptedException {
        Diddy();
    }
    public static void Diddy() throws InterruptedException{
        Snack snacky = new Snack();
        snacky.setCena(1.9);
        
        
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        map.put("1A", "Snickers " );
        map.put("2B", "M&M's " );
        map.put("3C", "Reese's Pieces" );
        map.put("4D", "Kit Kat  ");
        map.put("5E", "Twix" );
        System.out.println("Tu je nase menu: ");
        System.out.println("Snickers -  [1A]" + " " + "cena: " +snacky.getCena());
        Thread.sleep(500);
        System.out.println("M&M's - [2B]" + " "+ "cena: "  + snacky.getCena());
        Thread.sleep(500);
        System.out.println("Reese's Pieces - [3C]" + " " + "cena: " + snacky.getCena());
        Thread.sleep(500);
        System.out.println("Kik Kat - [4D]" + " "+ "cena: " + snacky.getCena());
        Thread.sleep(500);
        System.out.println("Twix - [5E]" + " " + "cena: " + snacky.getCena());
        System.out.println("Co si prajete?");
        

        try {
            String odpoved = scanner.nextLine(); 
            Path p = Path.of("Snacky.json");
            String nacitany = Files.readString(p);
            JSONObject ulozenyJson = new JSONObject(nacitany);
            int mnozstvooo = ulozenyJson.getInt("Mnozstvo");
            mnozstvooo--;
            if (mnozstvooo == 0) {
                System.out.println("Vypredane!");
                System.exit(0);
            }
            snacky.setMnozstvo(mnozstvooo);
            ulozenyJson.put("Mnozstvo", mnozstvooo);
            if (map.containsKey(odpoved)) {
                try(PrintWriter writer = new PrintWriter("Snacky.json")) {
                    writer.println (ulozenyJson);
                }
                
                System.out.println( "Vybrali ste si: "+ " "  + map.get(odpoved));
                platba();
                
                
            }
            
        } catch (Exception e) {
            System.out.println("Somehing went wrong");
            Diddy();
        }
        scanner.close();
        
    }
    public static void platba() throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        Snack cena = new Snack();
        cena.setCena(1.9);
        System.out.println("Mate presne " + cena.getCena() + " Eur ?"  + " ano/nie");
        String vyber = scanner.nextLine();
        try {
            if(vyber.equalsIgnoreCase("ano")){
                System.out.println("Prosím vložte mince do kavomatu");
                Thread.sleep(1000);
                System.out.println("Vlozili ste mince do kavomatu....");
                System.out.println("Snack sa pripravuje...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("Snack je pripraveny na zobratie, Dakujeme za navstevu!");
                System.exit(0);
    
            }
            if(vyber.equalsIgnoreCase("nie")){
                System.out.println("Zadajte presnu ciastku aku mate: ");
                int ciastka = scanner.nextInt();
                double vydavok = ciastka - cena.getCena();
                if(ciastka > 5){
                    System.out.println("Kavomat nemoze vidat taku ciastku");
                    Thread.sleep(1000);
                    platba();
                }
                else if (ciastka < 0) {
                    System.out.println("Zadali ste zlu hodnotu");
                    System.exit(0);
                    Thread.sleep(1000);
                    platba();
                }
                System.out.println("Tu je vas vydavok: " + vydavok + " Eur");
                System.out.println("Snack sa pripravuje...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("Snack je pripraveny na zobratie, Dakujeme za navstevu!");
                System.exit(ciastka);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        scanner.close();
        
        
    }
    
}