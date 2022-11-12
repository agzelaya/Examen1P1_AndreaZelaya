package examen1p1_andreazelaya;

import java.util.Scanner;
import java.util.Random;

public class Examen1P1_AndreaZelaya {

    static Scanner in = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\nMenu");
            System.out.println("1. Divisores Primos");
            System.out.println("2. Contorno de Piramide");
            System.out.println("3. Vecinos");
            System.out.println("4. Triangulo de pascal");
            System.out.println("5. Salida");
            System.out.print("Ingrese una opcion: ");
            opcion = in.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.println("Divisores primos");
                    System.out.println("Ingrese un numero entero: ");
                    int num = in.nextInt();

                    if (num >= 1) {
                        System.out.println("Los numeros primos que dividen el numero " + num + " son: " + primos(num));
                    } else {
                        System.out.println("Ingrese un numero mayor o igual a 1.");
                    }
                    break;
                }

                case 2: {
                    System.out.println("Contorno con piramide");
                    System.out.println("Ingrese el tamaño: ");
                    int tam = in.nextInt();

                    contorno(tam);
                    break;
                }

                case 3: {
                    System.out.println("Vecinos");
                    System.out.println("Ingrese una cadena: ");
                    in.nextLine();
                    String cadena = in.nextLine();
                    int cont = 0;
                    for (int i = 0; i < cadena.length(); i++) {
                        char chara = cadena.charAt(i);
                        if (((int) chara < 65 || (int) chara > 122 || (int) chara >= 91 && (int) chara <= 96) && (int) chara != 32) {
                            cont++;
                        }
                    }
                    if (cont == 0) {
                        System.out.println("Cadena resultante: " + vecinos(cadena));
                    } else {
                        System.out.println("Ingrese solamente letras y espacios");
                    }
                    break;
                }
                
                case 4:{
                    System.out.println("Triangulo de Pascal");
                    System.out.println("Ingrese un tamaño: ");
                    int tam = in.nextInt();
                    
                    pascal(tam);
                    break;
                }
            }
        } while (opcion != 5);
    }

    public static String primos(int N) {
        String acum = "";
        for (int i = 1; i <= N; i++) {
            int cont = 0;
            int div = N % i;
            if (div == 0) {
                for (int j = 1; j <= i; j++) {

                    int resid = i % j;
                    if (resid == 0) {
                        cont++;
                    }
                }

                if (cont == 2) {
                    acum += Integer.toString(i) + ", ";
                }
            }
        }

        String resul = "1, " + acum;

        return resul;
    }

    public static void contorno(int N) {
        if (N % 2 == 0) {
            System.out.println("Ingrese un numero impar");
        } else {
            for (int i = 0; i < N - (N / 2); i++) {
                for (int j = 0; j < N; j++) {
                    if ((i == N / 2 - 1 && (j > 0 && j < N - 1)) || (j > 0 && j + i == N / 2) || (j - i == N / 2 && j < N - 1)) {
                        System.out.print("+");
                    } else if ((i + j > N / 2 && j <= N / 2 && i < N / 2) || (j > N / 2 && i < N / 2 && j - i < N / 2)) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                }
                System.out.println("");
            }
        }
    }

    public static String vecinos(String cadena) {
        String acum = "";
        int rand = random.nextInt(2);
        System.out.println("Numero generado: " + rand);
        
        if (rand == 0) {
            for (int i = 0; i < cadena.length(); i++) {
                char chara = cadena.charAt(i);

                int newChara = (int) chara - 1;
                char newCharaLetter = (char) newChara;
                acum += newCharaLetter;

            }
        } else {
            if (rand == 1) {
                for (int i = 0; i < cadena.length(); i++) {

                    char chara = cadena.charAt(i);

                    int newChara = (int) chara + 1;
                    char newCharaLetter = (char) newChara;
                    acum += newCharaLetter;

                }
            }
        }

        return (acum);

    }
    
    public static int factorial (int N){
        int facto = 1;
            for (int i = 1; i <= N; i++) {
                facto *= i;
            }
        return facto;
    }
    
    public static int permutacion (int n, int r){
        int perm = factorial(n)/factorial(n-r);
        
        return perm;
    }
    
    public static int combinacion (int n, int r){
        int combi = permutacion(n,r)/factorial(r);
        return combi;
    }
    
    public static void pascal (int N){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("["+combinacion(i,j)+"]");
            }
            System.out.println();
        }
    }

}
