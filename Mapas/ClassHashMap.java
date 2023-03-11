/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gerax
 */
public class ClassHashMap<E, V> extends AbstractMap<E, V>{

    HashMap<E, V> map;
    
    public ClassHashMap(){
        map = new HashMap<E, V>();
    }

    @Override
    public void addCard(E name, V type) {
        map.put(name, type);
    }

    @Override
    public String typeOfCard(E name) {
        return String.valueOf(map.get(name));
    }

    @Override
    public String showUserCollection(boolean sort) {
        //Se hace un casteo porque los valores son E y V estos no se pueden comarar o modificar
        //Entonces obligo a que el programa crea que los valores son los que les pongo
        String res = "";
        if(sort){
            HashMap<String, List<String>> mapForCollection = (HashMap<String, List<String>>) map;
            List<Map.Entry<String,List<String>>> entryList = new ArrayList<>(mapForCollection.entrySet());
            Collections.sort(entryList, new Comparator<Map.Entry<String, List<String>>>() {
                @Override
                public int compare(Map.Entry<String, List<String>> o1, Map.Entry<String, List<String>> o2) {
                    String firstElement1 = o1.getValue().get(0);
                    String firstElement2 = o2.getValue().get(0);
                    return firstElement1.compareTo(firstElement2);
                }
            });
            for(Map.Entry<String, List<String>> entry: entryList){
                res+="Nombre de la carta: "+entry.getKey()+
                        "\n  Tipo de carta: "+entry.getValue().get(0)+
                        "\n  Numero de cartas que posee: "+entry.getValue().get(1)+"\n";
            }
        }else{
            HashMap<String, List<String>> mapForCollection = (HashMap<String, List<String>>) map;
            for(Map.Entry<String, List<String>> entry:mapForCollection.entrySet()){
                res+="Nombre de la carta: "+entry.getKey()+
                        "\n  Tipo de carta: "+entry.getValue().get(0)+
                        "\n  Numero de cartas que posee: "+entry.getValue().get(1)+"\n";
            }
        }
        return res;
    }

    @Override
    public String showCollection(boolean sort) {
        String res = "";
        if(!sort){
            for(Map.Entry<E, V> entry: map.entrySet()){
                res+="Nombre de la carta: "+entry.getKey()+" y Tipo de la carta: "+entry.getValue()+"\n";
            }
        }else{
            //Se hace un casteo porque los valores son E y V estos no se pueden comarar o modificar
            //Entonces obligo a que el programa crea que los valores son los que les pongo
            HashMap<String, String> mapForCollection = (HashMap<String, String>) map;
            List<Map.Entry<String,String>> entryList = new ArrayList<>(mapForCollection.entrySet());
            Collections.sort(entryList, new Comparator<Map.Entry<String, String>>() {
                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });
            for(Map.Entry<String, String> entry: entryList){
                res+="Nombre de la carta: "+entry.getKey()+" y Tipo de carta: "+entry.getValue()+"\n";
            }
        }
        return res;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean contains(E name) {
        return map.containsKey(name);
    }

    @Override
    public List<String> obtainCard(E key) {
        List<String> card = new ArrayList<>();
        card.add(String.valueOf(key));
        card.add(String.valueOf(map.get(key)));
        return card;
    }

    @Override
    public V obtainValue(E key) {
        return map.get(key);
    }
    
    
   
 
}
