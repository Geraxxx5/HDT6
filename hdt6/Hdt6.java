package hdt6;

import Factory.factoryMap;
import Mapas.IMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gerax
 */
public class Hdt6 {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //Se crea el factory para los maps
        factoryMap factory = new factoryMap();
        //Se crea el mapa que contiene todos las cartas
        IMap<String, String> mapCollection;
        //Se crea el mapa que el usuario va a tener
        //El valor List es porque el usuario puede agregar mas de una carta
        //posiciones: 0: tipo de carta, 1: numero de cartas
        IMap<String, List<String>> mapUserCollection;
        Scanner sc = new Scanner(System.in);
        //Se inicia el programa
        System.out.println("Bienvenido al programa\nSeleccione la opcion de map que desea:\n"
                + "1)HashMap\n2)TreeMap\n3)LinkedHashMap\nSeleccion la opcion:");
        boolean start = false;
        //El usuario selecciona el mapa que desea
        String opc = sc.nextLine();
        //String opc = "1";
        if(opc.equals("1") || opc.equals("2")||opc.equals("3")){
            start = true;
            int selected = Integer.parseInt(opc);
            //Se inicializan los dos mapas como el usuario desea
            mapCollection = factory.getMap(selected);
            mapUserCollection = factory.getMap(selected);
            //Aqui se lee el archivo y se ingresa al mapa que va a tener todas las colecciones
            CreateCollection(mapCollection);
            String nameOfCard ;
            while(start){
                System.out.println("Seleccione la opcion que desea:\n0) Salir\n1) Agregar una carta a la colecion\n2) Mostrar el tipo de una carta\n"
                        + "3) Nombre, tipo y cantidad de las cartas de la coleccion\n4) Nombre, tipo y cantidad de las cartas de la coleccion, ordenada por tipo\n"
                        + "5) Nombre y tipo de todas las cartas existentes\n6) Nombre y tipo de todas las cartas existentes, ordenas por tipo");
                String menu = sc.nextLine();
                //String menu = "5";
                if(menu.equals("1")){
                    System.out.println("--------------------------------------------\n");
                    System.out.println("Ingrese el nombre completo de la carta que quiere agregar");
                    //Este solo esta aqui porque se me trababa
                    nameOfCard = sc.nextLine().toLowerCase();
                    System.out.println("Nombre de la carta");
                    //Pregunta si tiene existe la carta, esta funcion es creada por el IMAP
                    if(mapCollection.contains(nameOfCard)){
                        System.out.println("Entro a verificacon");
                        //Pregunta si ya existe la carta dentro de la coleccion del usuario
                        if(mapUserCollection.contains(nameOfCard)){
                            System.out.println("Se agrego una carta");
                            //SI existe se le suma 1 a la posicion de la lista que tiene el numero de cartas
                            int numberOfCards = Integer.parseInt(mapUserCollection.obtainValue(nameOfCard).get(1));
                            mapUserCollection.obtainValue(nameOfCard).set(1,String.valueOf(numberOfCards+1));
                        }else{
                            System.out.println("Se creo una carta");
                            //Se obtiene la carta con su tipo de la coleccion de todas las cartas
                            List<String> card = mapCollection.obtainCard(nameOfCard);
                            //Se crea la lista que va a tener el tipo y numero de cartas
                            List<String> cardSpecifications = new ArrayList<>();
                            //Se agrega el tipo
                            cardSpecifications.add(card.get(1));
                            //El numero de cartas
                            cardSpecifications.add("1");
                            //Se agrega a la coleccion
                            mapUserCollection.addCard(card.get(0), cardSpecifications);
                        }
                    }
                }else if(menu.equals("2")){
                    System.out.println("--------------------------------------------\n");
                    System.out.println("Ingrese el nombre de la carta que quiere saber su tipo: ");
                    nameOfCard = sc.nextLine().toLowerCase();
                    if(mapCollection.contains(nameOfCard)){
                        System.out.println("El tipo de "+nameOfCard+" es: "+mapCollection.typeOfCard(nameOfCard));
                    }
                    System.out.println("\n--------------------------------------------");
                }else if(menu.equals("3")){
                    System.out.println("--------------------------------------------\n");
                    System.out.println(mapUserCollection.showUserCollection(false));
                    System.out.println("\n--------------------------------------------");
                }else if(menu.equals("4")){
                    System.out.println("--------------------------------------------\n");
                    System.out.println(mapUserCollection.showUserCollection(true));
                    System.out.println("\n--------------------------------------------");
                }else if(menu.equals("5")){
                    System.out.println("--------------------------------------------\n");
                    System.out.println(mapCollection.showCollection(false));
                    System.out.println("\n--------------------------------------------");
                }else if(menu.equals("6")){
                    System.out.println("--------------------------------------------\n");
                    System.out.println(mapCollection.showCollection(true));
                    System.out.println("\n--------------------------------------------");
                }else if(menu.equals("0")){
                    start = false;
                }
            }
        }else{
            System.out.println("No selecciono ninguna opcion");
        }
        System.out.println("Termino el programa");
    }
    
    /**
     *
     * @param map
     * @return
     */
    public static IMap CreateCollection(IMap map){
        //Aqui se lee el archivo
        FileReader archivo;
        BufferedReader lector;
        try {
            archivo = new FileReader("cards_desc.txt"); // modificar del archivo querido
            if (archivo.ready()) {
                    lector = new BufferedReader(archivo); // se hace la lectura
                    String cadena;
                    while ((cadena = lector.readLine()) != null) {  
                        int index = cadena.indexOf("|");
                        map.addCard(cadena.substring(0, index).toLowerCase(), cadena.substring(index+1).toLowerCase());                   
                    }
                    return map;
            } else {
                    System.out.println("El archivo no se encuentra");
            }
            
        } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
    
}
