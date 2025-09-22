package latinasincloud;

// import java.util.*;  // importar todas las herramientas en util
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

// --------------------------------
// TAREA 3: Calculadora (Grupal)
// Crear un programa que simule una calculadora con las siguientes funciones:

// 1) Sumar
// 2) Restar
// 3) Multiplicar
// 4) Dividir
// 5) Salir

// Requisitos:
// * Generar una función por cada operación básica (+,-,*,/)
// * Manejo de errores: En operación se debe validar si el divisor es mayor a 0
// para evitar error de cálculo.
// * Menú interactivo: Usar Scanner para pedir datos al usuario
// * GitHub: Subir el proyecto con commits claros.

public class Main {

    // declarar la variable publica en el Main

    private static Scanner scanner = new Scanner(System.in); // Creamos un objeto Scanner para leer la entrada del usuario
    private static List<Double> numeros = new ArrayList<>(); // Creamos una lista para almacenar los números de entrada de la suma multiple


    public static void main(String[] args) {

        int opcion ;
        do {
            System.out.println("--- Calculadora de operaciones básicas---");
            System.out.println("1. SUMAR DOS NÚMEROS");
            System.out.println("2. SUMAR MULTIPLES NÚMEROS");
            System.out.println("3. RESTAR");
            System.out.println("4. MULTIPLICAR");
            System.out.println("5. DIVIDIR");
            System.out.println("6. Salir.");
            System.out.print("> Ingrese una opción: ");
            opcion = scanner.nextInt();
            //Limpieza de buffer
            scanner.nextLine();
            // Detalle de la opcion del ménu que eligió el usuario
            switch (opcion){
                case 1:
                    sumar(); //procedimiento
                    break;
                case 2:
                    sumamultiple(); //procedimiento
                    break;
                case 3:
                    restar();
                    break;
                case 4: multiplicar();
                    break;
                case 5: dividir();
                    break;
                case 6:
                    System.out.println("Gracias por usar la calculadora de operaciones básicas, Adios!");
                    break;
                default: System.out.println("Opción incorrecta,escoja una de las operaciones :");
                    break; }
        } while (opcion !=6);
        scanner.close();
    }
    // fuera del Main agrego los procedimientos por que no retornan valor.

    private static void sumar() {
        System.out.println("Usted a escogido la operación sumar dos números");
        //solicitar el primer número
        System.out.println("Indique el primer valor de la suma :");
        double valor_uno = scanner.nextDouble();
        //scanner.nextLine();// limpiar buffer
        System.out.println("Indique el segundo valor de la suma : ");
        double valor_dos = scanner.nextDouble();
        //scanner.nextLine();// limpiar buffer
        double suma = valor_uno + valor_dos;
        System.out.println("El valor de la suma es : " + suma);
        System.out.println("--------------------------------------------");
    }
    private static void sumamultiple() {
        // Variable para controlar si el usuario quiere seguir añadiendo números
        boolean continueAdding = true;

        System.out.println("Programa para sumar múltiples valores.");
        System.out.println("Ingresa 'fin' para terminar de agregar números.");

        // Bucle para leer los números del usuario hasta que ingrese 'fin'
        while (continueAdding) {
            System.out.print("Ingresa un número (o 'fin' para sumar): ");
            String input = scanner.nextLine();

            // Verificamos si la entrada es "fin"
            if (input.equalsIgnoreCase("fin")) {
                continueAdding = false;
            } else {
                try {
                    // Convertimos la entrada a un tipo de dato Double
                    double number = Double.parseDouble(input);
                    // Agregamos el número a la lista
                    numeros.add(number);
                } catch (NumberFormatException e) {
                    // Manejamos el error si la entrada no es un número
                    System.out.println("Entrada inválida. Por favor, ingresa un número válido o 'fin'.");
                }
            }
        }
        // Cerramos el Scanner para liberar recursos
        //scanner.close();

        // Verificamos si la lista no está vacía antes de procesar
        if (!numeros.isEmpty()) {

            // Mostramos los valores que se van a sumar
            System.out.println("\n--- Valores de entrada ---");
            System.out.println("Elementos de la lista para sumar; " + numeros) ;

            // Calculamos la suma de los valores en la lista
            double sum = 0;
            for (Double num : numeros) {
                sum += num;
            }

            // Mostramos el resultado de la suma
            System.out.println("\n--- Resultado ---");
            System.out.println("La suma total es: " + sum);
            System.out.println("--------------------------------------------");

            // Limpiamos la lista para futuras operaciones
            numeros.clear();
            System.out.println("\nLa lista ha sido limpiada y está lista para ser reutilizada.");
        } else {
            System.out.println("\nNo se ingresaron números para sumar.");
        }
    }

    private static void restar() {
        System.out.println("Usted a escogido la operación restar dos números");
        //solicitar el primer número
        System.out.println("Indique el primer valor(minuendo) de la resta :");
        double valor_uno = scanner.nextDouble();
        //scanner.nextLine();// limpiar buffer
        System.out.println("Indique el segundo valor(sustraendo) de la resta : ");
        double valor_dos = scanner.nextDouble();

        //scanner.nextLine();// limpiar buffer
        double resta = valor_uno - valor_dos;
        System.out.println("\n--- Resultado ---");
        System.out.println("El valor de la resta es : " + resta);
        System.out.println("--------------------------------------------");
    }

    private static void multiplicar() {
        System.out.println("Usted a escogido la operación multiplicar dos números");
        //solicitar el primer número
        System.out.println("Indique el primer valor de la multiplicación :");
        double valor_uno = scanner.nextDouble();
        //scanner.nextLine();// limpiar buffer
        System.out.println("Indique el segundo valor de la multiplicación : ");
        double valor_dos = scanner.nextDouble();
        //scanner.nextLine();// limpiar buffer
        double multiplicacion = valor_uno * valor_dos;
        System.out.println("\n--- Resultado ---");
        System.out.println("El valor de la multiplicación es : " + multiplicacion);
        System.out.println("--------------------------------------------");
    }
    private static void dividir() {
        System.out.println("Usted ha escogido la operación dividir dos números");
        //solicitar el primer número
        System.out.println("Indique el primer valor de la división :");
        double valor_uno = scanner.nextDouble();
        //scanner.nextLine();// limpiar buffer
        System.out.println("Indique el segundo valor de la division : ");
        double valor_dos = scanner.nextDouble();
        //scanner.nextLine();// limpiar buffer

        // Condición de error para el valor_dos cuando es cero
        if (valor_dos == 0) {
            System.out.println("Error: No es posible dividir por cero.");
        } else {
            double division = valor_uno / valor_dos;
            System.out.println("\n--- Resultado ---");
            System.out.println("El valor de la división es : " + division);
        }

        System.out.println("--------------------------------------------");
    }


    }













