/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cristhian Fonseca H
 */
import java.util.Scanner;
import java.util.Random; // libreria para generar numeros aleatorios

public class Matrices {

    public static void main(String[] args) {
        int[][] matriz = new int[3][3];
        int fila = 0;
        int columna = 0;
        int SumaIzquierda = 0;
        int SumaDerecha = 0;
        Scanner leer = new Scanner(System.in); // utilizado en caso de que queramos ingresar los datos
        Random aleatorio = new Random();


        /*
        OMITIR: En caso de requerir que el usuario ingrese los numeros (lo hice para hacer pruebas)
        while (fila < 3) { 
            while (columna < 3) {
                System.out.print("Ingrese un numero (Fila " + (fila + 1) + " - Columna " + (columna + 1) + "): ");
                matriz[fila][columna] = leer.nextInt();
                columna++;
            }
            columna = 0;
            fila++;
        }*/
        
        // crea un numero aleatorio para almacenarlo en la matriz
        while (fila < 3) {
            while (columna < 3) {
                matriz[fila][columna] = aleatorio.nextInt(100);  // crea un numero aleatorio del 0 al 99
                columna++;
            }
            columna = 0;
            fila++;
        }
        // FOR para mostrar en pantalla la matriz generada, para comprobar visualmente las sumas
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%02d  ", matriz[i][j]); // con printf, puedo dar formato al numero, si es de un digito, le añade un 0
            }
            System.out.println();
        }

        //  Sumas de las diagonales, utilizando una variable acumuladora
        // Diagonal Izquierda
        for (int i = 0; i < 3; i++) { // la matriz es de 3x3 (0,1,2), creamos un loop que la recorra
            //  La suma diagonal izquierda consiste en los numeros (0,0), (1,1) y (2,2), 
            //  X - # - # (0,0)
            //  # - X - # (1,1)
            //  # - # - X (2,2)
            //  el valor de i nos sirve para lograr esto (cada vuelta la i aunmenta en 1) ((0,0) (1,1), (2,2))
            SumaIzquierda += matriz[i][i];
        }
        //  Diagonal Derecha
        for (int i = 0; i < 3; i++) { // la matriz es de 3x3 (0,1,2), creamos un loop que la recorra
            //  La suma diagonal derecha consiste en los numeros (0,2), (1,1) y (2,0), 
            //  # - # - X (0,2)
            //  # - X - # (1,1)
            //  X - # - # (2,0)
            //  el valor de i nos sirve para lograr el valor de la fila (X,#)
            // (cada vuelta la i aunmenta en 1) ((0,#) (1,#), (2,#))
            //  la columna se logra medicante [3 - i - 1], permite reducir en 1 cada vuelta, empezando en 2, por ejemplo
            //  en la primer vuelta: 3 - 0 - 1 = 2, segunda vuelta 3 - 1 - 1 = 1, tercer vuelta 3 - 2 - 1 = 0.
            SumaDerecha += matriz[i][3 - i - 1];
        }
        //  Se imprime en pantalla el resultado de las sumas
        System.out.println();
        System.out.println("Diagonal izquierda: " + SumaIzquierda);
        System.out.println("Diagonal derecha: " + SumaDerecha);
        System.out.println();
    }
}
