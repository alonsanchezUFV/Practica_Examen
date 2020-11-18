package org.Alonso.Sanchez;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    static Scanner Entrada_teclado = new Scanner(System.in);
    public static void main( String[] args )
    {


    Menu();

    }

    public static void Menu(){
        int Menu = 0;
        String  hola;

        do{
            System.out.println("*******  Elige una  ********");
            System.out.println("1- Añadir una agenda");
            System.out.println("5- Salir*");
            System.out.println("********");


            try {
                Menu = Entrada_teclado.nextInt();
                switch(Menu){
                    case 1:
                        break;
                    default:
                        System.out.println("Introduzca el numero de nuevo");
                }


            }catch (InputMismatchException ime){

                System.out.println("¡Cuidado! Solo puedes insertar números. Intentalo de nuevo:");

                Entrada_teclado.next();

            }

        }while(Menu!=5);
    }
}
