/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Gerax
 */
public class ClassLinkedHashMap<E, V> extends AbstractMap<E, V>{

    LinkedHashMap<E, V> map;
    
    public ClassLinkedHashMap(){
        map = new LinkedHashMap<>();
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
        String res = "";
        if(sort){
            LinkedHashMap<String, List<String>> mapForCollection = (LinkedHashMap<String, List<String>>) map;
            List<Map.Entry<String, List<String>>> entryList = new ArrayList<>(mapForCollection.entrySet());
            Collections.sort(entryList, new Comparator<Map.Entry<String, List<String>>>() {
                @Override
                public int compare(Map.Entry<String, List<String>> o1, Map.Entry<String, List<String>> o2) {
                    return o1.getValue().get(0).compareTo(o2.getValue().get(0));
                }
            });
            
            for(Map.Entry<String, List<String>> entry:  entryList){
                res+="Nombre de la carta: "+entry.getKey()+
                        "\n  Tipo de carta: "+entry.getValue().get(0)+
                        "\n  Numero de cartas que posee: "+entry.getValue().get(1)+"\n";
            }
            
            
        }else{
            LinkedHashMap<String, List<String>> mapForCollection = (LinkedHashMap<String, List<String>>) map;
            for(Map.Entry<String,List<String>> entry: mapForCollection.entrySet()){
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
        if(sort){
            LinkedHashMap<String, String> mapForCollection = (LinkedHashMap<String, String>) map;
            List<Map.Entry<String, String>> entryList = new ArrayList<Map.Entry<String,String>>(mapForCollection.entrySet());

            Collections.sort(entryList, new Comparator<Map.Entry<String, String>>(){
                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
                
            });
            
            for(Map.Entry<String, String> entry: entryList){
                res+="Nombre de la carta: "+entry.getKey()+" y Tipo de carta: "+entry.getValue()+"\n";
            }
        }else{
            LinkedHashMap<String, String> mapForCollection = (LinkedHashMap<String, String>) map;
            for(Map.Entry<String,String> entry: mapForCollection.entrySet()){
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
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(key));
        list.add(String.valueOf(map.get(key)));
        return list;
    }

    @Override
    public V obtainValue(E key) {
        return map.get(key);
    }
    
}
