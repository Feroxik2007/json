import java.util.Scanner;

public class Admin {
    public static void consola(){
        main main = new main();
        snackMenu menu = new snackMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zadajte svoje prihlasovacie meno: ");
        String prihlasovacieMeno = scanner.next();
        if (prihlasovacieMeno.equals("Coopjednotaprievidza16")) {
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
    public static void odobrat(){
        snackMenu snack = new snackMenu();
        
    }
    public static void doplnit(){
        snackMenu snack = new snackMenu();
    }
}
