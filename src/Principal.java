import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ComunicacionApi comunicacionApi = new ComunicacionApi();

        String menu = """
                ----------------------------
                   CONVERSOR DE MONEDAS
                ----------------------------
                1) Dólar =>> Peso Argentino
                2) Peso Argentino =>> Dólar
                3) Dólar =>> Real Brasileño
                4) Real Brasileño =>> Dólar
                5) Dólar =>> Peso Colombiano
                6) Peso Colombiano =>> Dólar
                7) Peso Chileno =>> Peso Colombiano
                8) Peso Colombiano =>> Peso Chileno
                9) Colon Costa Rica  =>> Peso Colombiano
                10) Peso Colombiano => Colon Costa Rica
                11) Peso Mexicano =>> Peso Colombiano
                12 Peso Colombiano =>> Peso Mexicano                
                13) Salir
                """;
        System.out.println(menu);

        System.out.println("Elija una opción válida: ");
        try {
           // var opcion = Integer.valueOf(lectura.nextLine());
            int opcion = Integer.parseInt(lectura.nextLine());
            String codigoMonedaInicial = "";
            String codigoMonedaFinal = "";

            while (opcion != 13) {
                if (opcion == 1) {
                    codigoMonedaInicial = "USD"; // Dólares
                    codigoMonedaFinal = "ARS"; //Peso Argentino
                }
                if (opcion == 2) {
                    codigoMonedaInicial = "ARS";
                    codigoMonedaFinal = "USD";
                }
                if (opcion == 3) {
                    codigoMonedaInicial = "USD";
                    codigoMonedaFinal = "BRL"; // Real Brasil
                }
                if (opcion == 4) {
                    codigoMonedaInicial = "BRL";
                    codigoMonedaFinal = "USD";
                }
                if (opcion == 5) {
                    codigoMonedaInicial = "USD";
                    codigoMonedaFinal = "COP";
                }
                if (opcion == 6) {
                    codigoMonedaInicial = "COP";
                    codigoMonedaFinal = "USD";
                }
                if (opcion == 7) {
                    codigoMonedaInicial = "CLP";  //Peso Chileno
                    codigoMonedaFinal = "COP";
                }
                if (opcion == 8) {
                    codigoMonedaInicial = "COP";
                    codigoMonedaFinal = "CLP";
                }
                if (opcion == 9) {
                    codigoMonedaInicial = "CRC";
                    codigoMonedaFinal = "COP"; // Colon Costa Rica
                }
                if (opcion == 10) {
                    codigoMonedaInicial = "COP";
                    codigoMonedaFinal = "CRC";
                }
                if (opcion == 11) {
                    codigoMonedaInicial = "MXN";
                    codigoMonedaFinal = "COP";
                }
                if (opcion == 12) {
                    codigoMonedaInicial = "COP";
                    codigoMonedaFinal = "MXN";
                }



                System.out.println("Ingresa el valor que desea convertir: ");
                double valor = Double.parseDouble(lectura.nextLine());

                System.out.println("\n"+ "********************************");
                System.out.println("  RESULTADOS DE LA CONVERSIÓN  ");
                System.out.println("********************************");

                System.out.println("\n"+ "MONEDA INICIAL: " + codigoMonedaInicial);
                System.out.println("MONEDA FINAL: " + codigoMonedaFinal);
                System.out.println("VALOR A CONVERTIR: " + valor);


                var valorConvertido = comunicacionApi.ConversorDatos(codigoMonedaInicial, codigoMonedaFinal, valor);
               // System.out.println("El valor " + valor + " " + codigoMonedaInicial + " es igual a " + valorConvertido + " " + codigoMonedaFinal + "\n");
                System.out.println("VALOR CONVERTIDO: " + valorConvertido  + "\n");

                System.out.println(menu);

                System.out.println("Elija una opción válida: ");
                opcion = Integer.parseInt(lectura.nextLine()); // Pedimos la opción nuevamente
            }
            System.out.println("Saliendo del programa...");

        } catch (NumberFormatException | InputMismatchException e ) {
            System.out.println("Opción no válida, por favor ingrese el número correspondiente a la opción deseada" + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación");
        }

    }
}
