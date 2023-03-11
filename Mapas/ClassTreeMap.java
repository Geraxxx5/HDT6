/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Gerax
 */
public class ClassTreeMap<E, V> extends AbstractMap<E, V>{

    TreeMap<E, V> map;
    
    public ClassTreeMap(){
        map = new TreeMap<>();
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
            TreeMap<String, List<String>> mapForCollection = (TreeMap<String, List<String>>) map;
            TreeMap<String, List<String>> sortedMap = new TreeMap<String, List<String>>(new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    List<String> list1 = mapForCollection.get(s1);
                    List<String> list2 = mapForCollection.get(s2);
                    String val1 = list1.get(0);
                    String val2 = list2.get(0);
                    int valueCompare = val1.compareTo(val2);
                    if (valueCompare == 0) {
                        // if values are equal, compare keys to avoid overwriting
                        return s1.compareTo(s2);
                    }
                    return valueCompare;
                }
            });
            sortedMap.putAll(mapForCollection);
            
            for(Map.Entry<String, List<String>> entry:  sortedMap.entrySet()){
                res+="Nombre de la carta: "+entry.getKey()+
                        "\n  Tipo de carta: "+entry.getValue().get(0)+
                        "\n  Numero de cartas que posee: "+entry.getValue().get(1)+"\n";
            }
        }else{
            TreeMap<String, List<String>> mapForCollection = (TreeMap<String, List<String>>) map;
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
        if(sort){
            TreeMap<String, String> mapForCollection = (TreeMap<String, String>) map;
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
            TreeMap<String, String> mapForCollection = (TreeMap<String, String>) map;
            for(Map.Entry<String, String> entry:mapForCollection.entrySet()){
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
