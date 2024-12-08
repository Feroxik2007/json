import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class snackMenu {
    
    public static void main(String[] args) throws InterruptedException {
        Diddy();
    }
    public static void Diddy() throws InterruptedException{
        Snack snacky = new Snack();
        snacky.setCena(1.9);
        
        int mnozstvo = 5;
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        map.put("1A", "Snickers " );
        map.put("2B", "M&M's " );
        map.put("3C", "Reese's Pieces" );
        map.put("4D", "Kit Kat  ");
        map.put("5F", "Twix" );
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
            FileWriter writer = new FileWriter("snack.txt");
            if (map.containsKey(odpoved)) {
                snacky.setMnozstvo(mnozstvo);
                mnozstvo--;
                writer.write("Pocete snickersu: " + mnozstvo);
                writer.close();
                if (mnozstvo == 0) {
                    System.out.println("Snickers su vypredane!");
                    Thread.sleep(1000);
                    Diddy();
                }
                System.out.println( "Vybrali ste si: "+ " "  + map.get(odpoved));
                platba();
            }
            else{
                System.out.println("Nespravna volba");
                System.out.println("Skus este raz!");
                Thread.sleep(1000);
                Diddy();
            }
        } catch (Exception e) {
            System.out.println("Somehing went wrong");
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