package org.Alonso.Sanchez;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    static Scanner Entrada_teclado = new Scanner(System.in);
    static ArrayList<Coche> Array_coches = new ArrayList<Coche>();
    public static void main( String[] args )
    {

    Leer_Fichero();
    Menu();

    }

    public static void Menu(){
        int Menu = 0;
        String  hola;

        do{
            System.out.println("*******  Elige una  ********");
            System.out.println("1- Añadir una agenda");
            System.out.println("3- Ver array");
            System.out.println("5- Salir*");
            System.out.println("********");


            try {
                Menu = Entrada_teclado.nextInt();
                switch(Menu){
                    case 1:
                        break;
                    case 2:
                        for(int i=0;i<Array_coches.size();i++){
                            System.out.println("");
                            System.out.println(Array_coches.get(i).Id);
                            System.out.println(Array_coches.get(i).Id);
                            System.out.println(Array_coches.get(i).Id);
                            System.out.println(Array_coches.get(i).Id);
                        }


                        break;
                    case 5:
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
        File file = new File("concesionario.xml");

        String Id;
        String Marca;
        String Modelo;
        String Cilindrada;

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


                    Id = eElement.getAttribute("id");
                    Marca = eElement.getElementsByTagName("marca").item(0).getTextContent();
                    Modelo = eElement.getElementsByTagName("modelo").item(0).getTextContent();
                    Cilindrada = eElement.getElementsByTagName("cilindrada").item(0).getTextContent();
                    Coche Coche_aux =new Coche(Id,Marca,Modelo,Cilindrada);
                    Array_coches.add(Coche_aux);
                }
            }


        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
