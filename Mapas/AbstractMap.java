package Mapas;

/**
 *
 * @author Gerax
 */
abstract class AbstractMap<E, V> implements IMap<E, V> {
    //Esta clase solo existe para que los demas mapas la extiendan y asi pueda crear mapas de diferentes formas
    //Como el mapa que tiene todos los datos es String, String
    //y el mapa del usuario es String,List<String>
    //Solo es para tener las mismas funciones
}
