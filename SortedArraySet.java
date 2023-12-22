package UniClasses;

/** Classe che implementa l'interfaccia Set. Ordinato e ridimensionabile
 * @param <T> Tipo generico dei dati inseriti all'interno dell'insieme
 */
public class SortedArraySet<T extends Comparable<T>> implements SortedSet<T>{
    /** Viene costruito un insieme di una dimensione fissata e lo si inizializza a zero
     */
    public SortedArraySet() {
        array = (T[]) new Object[INITIALSIZE];
        makeEmpty();
    }
    /** Viene costruito un insieme di una dimensione data e lo si inizializza a zero
     * @param size La dimensione dell'array
     */
    public SortedArraySet(int size) {
        array = (T[]) new Object[size];
        makeEmpty();
    }

    /** Controlla se il dizionario è vuoto
    * @return Vero se la coda è vuoto altrimenti falso
    */
    public boolean isEmpty() { return vSize == 0; }
    /** Rende vuoto il dizionario
    */
    public void makeEmpty() { vSize = 0; }

    /** Inserisce un elemento nell'insieme, se questo non è già presente
     * @param obj L'oggetto da inserire
     */
    public void add(T obj) {
        if (contain(obj)) return;
        if (vSize == array.length) array = resize(2*vSize);
        array[vSize--] = obj;
        array = toSortedArray();
    }
    /** Ritorna la presenza di un elemento nell'insieme
     * @param obj L'oggetto d ricercare
     * @return true se l'oggetto è presente, altrimenti false
     */
    public boolean contain(T obj) {
        return binSearch(obj, 0, vSize-1);
    }
    /** Formatta l'insieme in un array ordinato
     * @return L'array formattato
     */
    public T[] toSortedArray() {
        for (int i = 1; i < vSize; i++) {
            T temp = array[i];
            int j;
            for (j = i; j > 0 && temp.compareTo(array[j-1]) < 0; j--)
                array[j] = array[j-1];
            array[j] = temp;
        }
        return array;
    }
    public T[] toArray() {
        return toSortedArray();
    }

    private boolean binSearch(T value, int from, int to) {
        if (from > to) return false;
        int m = (from + to)/2;
        T middle = array[m];
        if (middle.compareTo(value) > 0) return binSearch(value, 0, m-1);
        else if (middle.compareTo(value) < 0) return binSearch(value, m+1, to);
        else return true;
    }
    private T[] resize(int newLength) {
        T[] newArray = (T[]) new Object[newLength];
        if (newLength < vSize) newLength = vSize;
        System.arraycopy(array, 0, newArray, 0, newLength);
        return newArray;
    }

    /** Array che andrà a contenere l'insieme totalmente ordinato*/
    protected T[] array;
    /** Numero che memorizza la cella di memoria che contiene il primo elemento che verrà rimosso */
    protected int vSize;
    /** Lunghezza standard dell'array se non viene fornita */
    public static final int INITIALSIZE = 10;
}
