/** Classe che implementa l'interfaccia Queue. Non ridimensionabile
*/
public class FixedQueue<T> implements Queue<T> {
    /** Viene costruito una coda di una dimensione fissata e la si inizializza a zero
     */
    public FixedQueue() {
        array = (T[]) new Object[INITIALSIZE];
        makeEmpty();
    }
    /** Viene costruito una coda di una dimensione data e la si inizializza a zero
     * @param size La dimensione dell'array
     */
    public FixedQueue(int size) {
        array = (T[]) new Object[INITIALSIZE];
        makeEmpty();
    }

    /** Controlla se la coda è vuoto
    * @return Vero se la coda è vuoto altrimenti falso
    */
    public boolean isEmpty() { return front == back; }
    /** Rende vuoto la coda
    */
    public void makeEmpty() { front = back = 0; }

    /** Aggiunge un elemento alla coda
     * @param obj Elemento da aggiungere
     */
    public void enqueue(T obj) {
        if (obj == null) throw new IllegalArgumentException();
        if (increment(back) == front) throw new FullQueueException();
        array[back] = obj;
        back = increment(back);
    }
    /** Rimuove un elemento dalla coda
     * @return L'elemento rimosso
     */
    public T dequeue() {
        if (isEmpty()) throw new EmptyQueueException();
        T t = getFront();
        front = increment(front);
        return t;
    }
    /** Ritorna il prossimo elemento che sarà rimosso
     * @return Il prossimo elemento rimosso
     */
    public T getFront() {
        if (isEmpty()) throw new EmptyQueueException();
        return array[front];
    }
    /** Incrementa l'indice, se questo è arrivato al termine dell'array lo fa ritornare all'inizio
     * @param number L'indice da incrementare
     * @return Il numero incrementato o resettato
     */
    protected int increment(int number) {
        return (number + 1) % array.length;
    }

    /** Array circolare che andrà a contenere la coda */
    protected T[] array;
    /** Numero che memorizza la cella di memoria che contiene il primo elemento che verrà rimosso */
    protected int front;
    /** Numero che memorizza la cella di memoria che contiene il l'ultimo elemento inserito */
    protected int back;
    /** Lunghezza standard dell'array se non viene fornita */
    public static final int INITIALSIZE = 10;
}
