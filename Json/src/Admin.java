import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



import org.json.*;

public class Admin {
    public static void consola() throws FileNotFoundException{
        main main = new main();
        snackMenu menu = new snackMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zadajte svoje prihlasovacie meno: ");
        String prihlasovacieMeno = scanner.next();
        if (prihlasovacieMeno.equals("1")) {// Coopjednotaprievidza16
            System.out.println("Ste uspesne prihlaseny!");
            System.out.println("1. Doplnit");
            System.out.println("2. Odobrat");
            System.out.println("3. Prejst na hlavne menu");
            int moznost = scanner.nextInt();
                if (moznost == 1) {
                    doplnit();
                }
                if (moznost == 2) {
                    odobrat();
                }
                if (moznost == 3) {
                    main.uvodMenu();
                }

        }
        else{
            System.out.println("Prihlasovacie meno je nespravne");
            main.uvodMenu();
        }
        scanner.close();
        
    }
    public static void odobrat() throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        snackMenu snack = new snackMenu();
        Map<String, String> map = new HashMap<>();
        map.put("1A", "Snickers " );
        map.put("2B", "M&M's " );
        map.put("3C", "Reese's Pieces" );
        map.put("4D", "Kit Kat  ");
        map.put("5E", "Twix" );
        System.out.println("1.Snickers");
        System.out.println("2.M&M's");
        System.out.println("3.Reese's Pieces");
        System.out.println("4.Kit Kat");
        System.out.println("5.Twix");
        System.out.println("Co si prajete odobrat?");
        
        try {
            int vyber = scanner.nextInt();
            Path p = Path.of("Snacky.json");
            String ulozene = Files.readString(p);
            JSONArray jsonObject = new JSONArray(ulozene);
            System.out.println(jsonObject.get(vyber));
            try(PrintWriter writer = new PrintWriter("mnozstvo.json" );){
            
            }
        } catch (Exception e) {
            System.out.println("Error!");
            odobrat();
        }
        
        
    }
    public static void doplnit(){
        snackMenu snack = new snackMenu();
    }

    
}
