/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import java.util.List;

/**
 *
 * @author Gerax
 */
public interface IMap<E, V> {
    //Añade una carta a la coleccion
    public void addCard(E name, V type);
    
    //Retorna el tipo de carta
    public String typeOfCard(E name);
    
    //Muestra la coleccion del usuario
    //Pide un booleando para saber si: true: sort por tipo de carta, false: no hay sort
    public String showUserCollection(boolean sort);
    //Muestra la coleccion de todas las cartas
    //Pide un booleando para saber si: true: sort por tipo de carta, false: no hay sort
    public String showCollection(boolean sort);
    public int size();
    //Pregunta si contiene
    public boolean contains(E name);
    //Obtiene la carta en una lista: 0: Nombre de la carta, 1: tipo de la carta
    public List<String> obtainCard(E key);
    //Obtiene el value de la key que se le manda y lo retorna
    //Esto sirve para acceder a la lista en el mapa del usuario
    public V obtainValue(E key);
}
