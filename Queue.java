/** Interfaccia pe rimplementare una coda (Queue) */
public interface Queue<T> extends Container {
    /** Aggiunge un elemento alla coda
     * @param obj Elemento da aggiungere
     */
    void enqueue(T obj);
    /** Rimuove un elemento dalla coda
     * @return L'elemento rimosso
     */
    T dequeue();
    /** Ritorna il prossimo elemento che sarà rimosso
     * @return Il prossimo elemento rimosso
     */
    T getFront();
}

class EmptyQueueException extends RuntimeException { }
class FullQueueException extends RuntimeException { }