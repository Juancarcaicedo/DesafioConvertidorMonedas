package Menu;
import Service.Interface.ICurrencyConverter;
import Service.impl.CurrencyConverterImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final ICurrencyConverter currencyConverter;
    public Menu() {
        this.currencyConverter = new CurrencyConverterImpl();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        do {
            try {
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
                        convertirMoneda("USD", "ARS", scanner);
                        break;
                    case 2:
                        convertirMoneda("ARS", "USD", scanner);
                        break;
                    case 3:
                        convertirMoneda("USD", "BRL", scanner);
                        break;
                    case 4:
                        convertirMoneda("BRL", "USD", scanner);
                        break;
                    case 5:
                        convertirMoneda("USD", "COP", scanner);
                        break;
                    case 6:
                        convertirMoneda("COP", "USD", scanner);
                        break;
                    case 7:
                        System.out.println("Saliendo del menú...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elige una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: debes ingresar números, no letras.");
                scanner.next(); // Limpia el input
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        } while (option != 7);
        scanner.close();
    }

    private void convertirMoneda(String baseCurrency, String targetCurrency, Scanner scanner) {
        try {
            System.out.print("Ingresa la cantidad de " + baseCurrency + " que deseas convertir: ");
            double cantidad = scanner.nextDouble();

            // Llama al método de conversión de monto
            double resultado = currencyConverter.convertAmount(baseCurrency, targetCurrency, cantidad);

            // Muestra el resultado de la conversión
            System.out.println(cantidad + " " + baseCurrency + " equivale a " + resultado + " " + targetCurrency);
        } catch (InputMismatchException e) {
            System.out.println("Error: debes ingresar un número válido.");
            scanner.next(); // Limpia el input
        } catch (Exception e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }
    }
}
