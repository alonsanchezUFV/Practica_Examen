package org.Alonso.Sanchez;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
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
    public static void Leer_Fichero(){
        File file = new File("coches.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("coche");

            for(int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("\nCoche id: " + eElement.getAttribute("id"));
                    System.out.println("Marca: "
                            + eElement.getElementsByTagName("marca").item(0).getTextContent());
                    System.out.println("Modelo: "
                            + eElement.getElementsByTagName("modelo").item(0).getTextContent());
                    System.out.println("Cilindrada: "
                            + eElement.getElementsByTagName("cilindrada").item(0).getTextContent());
                }
            }


        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
