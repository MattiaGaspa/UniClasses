/** Interfaccia per implementare una pila (stack)
 * @param <T> Tipo generico dei dati inseriti all'interno dello stack
*/
public interface Stack<T> extends Container {
    /** Inserisce un elemento sulla pila
     * @param obj L'elemento da inserire
     */
    void push(T obj);
    /** Rimuove un elemento dalla pila
     * @return L'elemento rimosso
     */
    T pop();
    /** Ritorna l'ultimo elemento inserito senza però rimuoverlo
     * @return L'ultimo elemento rimosso
     */
    T top();
}

class FullStackException extends RuntimeException {}
class EmptyStackException extends RuntimeException {}