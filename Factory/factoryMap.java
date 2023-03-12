/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Mapas.ClassHashMap;
import Mapas.ClassLinkedHashMap;
import Mapas.ClassTreeMap;
import Mapas.IMap;

/**
 *
 * @author Gerax
 * @param <E>
 * @param <V>
 */
public class factoryMap<E, V> {
    
    /**
     *
     * @param opc
     * @return IMap<E, V>
     * The desired map is selected
     */
    public IMap<E, V> getMap(int opc){
        if(opc == 1){
            return new ClassHashMap<>();
        }else if(opc == 2){
            return new ClassTreeMap<>();
        }else{
            return new ClassLinkedHashMap<>();
        }
    }
    
}
