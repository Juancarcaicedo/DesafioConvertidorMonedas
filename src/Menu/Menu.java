package Menu;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        do {
            try{
                System.out.println("\n*** Menú de opciones ***");
                System.out.println("1) Dolar =>> Peso Argentino");
                System.out.println("2) Peso Argentino =>> Dolar");
                System.out.println("3) Dolar =>> Real Brasileño");
                System.out.println("4) Real Brasileño =>> Dolar");
                System.out.println("5) Dolar =>> Peso Colombiano");
                System.out.println("6) Peso Colombiano =>> Dolar");
                System.out.println("7. Salir");
                System.out.print("Elige una opción: ");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Dolar =>> Peso Argentino");
                        break;
                    case 2:
                        System.out.println("Peso Argentino =>> Dolar");
                        break;
                    case 3:
                        System.out.println("Dolar =>> Real Brasileño");
                        break;
                    case 4:
                        System.out.println("Real Brasileño =>> Dolar");
                        break;
                    case 5:
                        System.out.println("Dolar =>> Peso Colombiano");
                        break;
                    case 6:
                        System.out.println("Peso Colombiano =>> Dolar");
                        break;
                    case 7:
                        System.out.println("Saliendo del menú...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elige una opción válida.");
                }
            }catch (InputMismatchException e ){
                System.out.println("Error debes ingresar numeros no Letras");
                System.out.println(e.getMessage());
                scanner.next();
            }
            } while (option != 7);
            scanner.close();
    }
}
