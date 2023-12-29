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
        int i;
        for (i = vSize-1; (obj.compareTo(array[i])<0) && (i > 0); i--) {
            array[i+1] = array[i];
        }
        array[i] = obj;
        vSize++;
    }
    /** Ritorna la presenza di un elemento nell'insieme
     * @param obj L'oggetto d ricercare
     * @return true se l'oggetto è presente, altrimenti false
     */
    public boolean contain(T obj) {
        return binSearch(obj, 0, vSize-1);
    }
    /** Formatta l'insieme in formato array
     * @return L'array formattato
     */
    public T[] toArray() {
        T[] newArray = (T[]) new Object[vSize];
        System.arraycopy(array, 0, newArray, 0, vSize);
        return newArray;
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

    /** Esegue l'operazione logica di unione su due insiemi
     * @param s1 Primo operando
     * @param s2 Secondo operando
     * @param <T> Tipo generico dei dati inseriti all'interno delgli insieme
     * @return L'inisieme risultante
     */
    public static <T extends Comparable<T>> SortedSet<T> union(SortedSet<T> s1, SortedSet<T> s2) {
        SortedSet<T> x = new SortedArraySet<T>();
        T[] v1 = s1.toArray();
        T[] v2 = s2.toArray();
        int i = 0, j = 0;
        while ((i < v1.length) && (j < v2.length)) {
            if (v1[i].compareTo(v2[i]) < 0)
                x.add(v1[i++]);
            else if (v1[i].compareTo(v2[i]) < 0)
                x.add(v2[j++]);
            else {
                x.add(v1[i++]);
                j++;
            }
        }
        while (i < v1.length) x.add(v1[i++]);
        while (j < v2.length) x.add(v2[j++]);
        return x;
    }
    /** Esegue l'operazione logica di intersezione su due insiemi
     * @param s1 Primo operando
     * @param s2 Secondo operando
     * @param <T> Tipo generico dei dati inseriti all'interno delgli insieme
     * @return L'inisieme risultante
     */
    public static <T extends Comparable<T>> SortedSet<T> intersection(SortedSet<T> s1, SortedSet<T> s2) {
        SortedSet<T> x = new SortedArraySet<T>();
        T[] array1 = (T[]) s1.toArray();
        for (int i = 0; i < array1.length; i++)
            if (s2.contain(array1[i]))
                x.add(array1[i]);
        return x;
    }
    /**Esegue l'operazione logica di sottrazione su due insiemi
     * @param s1 Primo operando
     * @param s2 Secondo operando
     * @param <T> Tipo generico dei dati inseriti all'interno delgli insieme
     * @return L'inisieme risultante
     */
    public static <T extends Comparable<T>> SortedSet<T> substract(SortedSet<T> s1, SortedSet<T> s2) {
        SortedSet<T> x = new SortedArraySet<T>();
        T[] array1 = (T[]) s1.toArray();
        for (int i = 0; i < array1.length; i++)
            if (!s2.contain(array1[i]))
                x.add(array1[i]);
        return x;
    }

    /** Array che andrà a contenere l'insieme totalmente ordinato*/
    protected T[] array;
    /** Numero che memorizza la cella di memoria che contiene il primo elemento che verrà rimosso */
    protected int vSize;
    /** Lunghezza standard dell'array se non viene fornita */
    public static final int INITIALSIZE = 10;
}
