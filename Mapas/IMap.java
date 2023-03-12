package Mapas;

import java.util.List;

/**
 *
 * @author Gerax
 * @param <E>
 * @param <V>
 * The interface for class implementation
 */
public interface IMap<E, V> {

    /**
     *
     * @param name
     * @param type
     * Add cards to the collection
     */
    public void addCard(E name, V type);
    
    //Retorna el tipo de carta

    /**
     *
     * @param name
     * @return String
     * Return the type of the card using the key
     */
    public String typeOfCard(E name);
    
    /**
     *
     * @param sort
     * @return
     * It will return the user's collection, sorted or unsorted depending on the parameter sent
     */
    public String showUserCollection(boolean sort);

    /**
     *
     * @param sort
     * @return
     * It will return the complete collection, sorted or unsorted depending on the parameter sent
     */
    public String showCollection(boolean sort);

    /**
     *
     * @return
     * Return size of the map
     */
    public int size();
    //Pregunta si contiene

    /**
     *
     * @param name
     * @return
     * Check if the sent key exists
     */
    public boolean contains(E name);


    /**
     *
     * @param key
     * @return
     * he requested card is returned through a list, which has the card name or key in position 0 and the card type in position 1
     */
    public List<String> obtainCard(E key);


    /**
     *
     * @param key
     * @return
     * For the user's collection, when having a list type to interact with it, it is returned
     */
    public V obtainValue(E key);
}
