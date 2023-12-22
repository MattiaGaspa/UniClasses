package UniClasses;

/** Interfaccia per implementare un dizionario (Dictionary)
 * @param <T> Tipo generico per la chiave delle coppie
 * @param <E> Tipo generico per il valore associato alle chiavi
*/
public interface Dictionary<T extends Comparable<T>, E> extends Container {
    /** Inserisce una coppia chiave/valore nel dizionario
     * @param key La chiave con cui si inserisce l'elemento
     * @param value L'elemento da inserire
     */
    void insert(T key, E value);
    /** Rimuove un elemento dal dizionario
     * @param key La chiave dell'elemento da rimuovere
     */
    void remove(T key);
    /** Trova un elemento nel dizionario
     * @param key La chiave da trovare
     * @return L'elemento associato alla chiave
     */
    E find(T key);
}

class DictionaryItemNotFoundException extends RuntimeException { }