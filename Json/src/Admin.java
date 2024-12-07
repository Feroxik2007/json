import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
        int mnozstvo = 10;
        try {
            snackMenu snack = new snackMenu();
            Snack snacky = new Snack();
            JSONArray jsonObject = new JSONArray();
            jsonObject.put(0,snacky.getCena() );
            try(PrintWriter writer = new PrintWriter("mnozstvo.json" );){
            writer.println(jsonObject);
            System.out.println(jsonObject.get(0));
            }
        } catch (Exception e) {
            System.out.println("Chyba pri zapisovaní do súboru");
        }
        
        
    }
    public static void doplnit(){
        snackMenu snack = new snackMenu();
    }

    
}
