/** Classe che implementa l'interfaccia Stack. Non ridimensionabile
*/
public class FixedArrayStack<T> implements Stack<T> {
    /** Viene costruito uno stack di una dimensione fissata e lo si inizializza a zero
     */
    public FixedArrayStack() {
        array = (T[]) new Object[INITIALSIZE];
        makeEmpty();
    }
    /** Viene costruito uno stack di una dimensione data e lo si inizializza a zero
     * @param size La dimensione dell'array
     */
    public FixedArrayStack(int size) {
        array = (T[]) new Object[size];
        makeEmpty();
    }

    /** Controlla se lo stack è vuoto
    * @return Vero se lo stack è vuoto altrimenti falso
    */
    public boolean isEmpty() { return vSize == 0; }
    /** Rende vuoto lo stack
    */
    public void makeEmpty() { vSize = 0; }

    /** Inserisce un elemento nello stack */
    public void push(T obj) {
        if (obj == null) throw new IllegalArgumentException();
        if (vSize == array.length) throw new FullStackException();
        array[vSize++] = obj;
    }
    /** Ritorna l'ultimo elemento inserito nello stack
     * @return L'ultimo elemento inserito nello stack
     */
    public T top() {
        if (isEmpty()) throw new EmptyStackException();
        return array[vSize-1];
    }
    /** Rimouve e restituisce l'ultimo elemento inserito nello stack
     * @return L'ultimo elemento inserito nello stack
     */
    public T pop() {
        T t = top();
        vSize--;
        return t;
    }

    /** Array che andrà a contenere lo stack */
    protected T[] array;
    /** Numero che memorizza la prima cella di memoria non utilizzata nell'array */
    protected int vSize;
    /** Lunghezza standard dell'array se non viene fornita */
    public static final int INITIALSIZE = 10;
}