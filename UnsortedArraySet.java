package UniClasses;

/** Classe che implementa l'interfaccia Set. Non ordinato e ridimensionabile
 * @param <T> Tipo generico dei dati inseriti all'interno dell'insieme
 */
public class UnsortedArraySet<T> implements Set<T> {
    /** Viene costruito un insieme di una dimensione fissata e lo si inizializza a zero
     */
    public UnsortedArraySet() {
        array = (T[]) new Object[INITIALSIZE];
        makeEmpty();
    }
    /** Viene costruito un insieme di una dimensione data e lo si inizializza a zero
     * @param size La dimensione dell'array
     */
    public UnsortedArraySet(int size) {
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
        array[vSize++] = obj;
    }
    /** Ritorna la presenza di un elemento nell'insieme
     * @param obj L'oggetto d ricercare
     * @return true se l'oggetto è presente, altrimenti false
     */
    public boolean contain(T obj) {
        for (int i = 0; i < vSize; i++)
            if (array[i].equals(obj))
                return true;
        return false;
    }
    /** Formatta l'insieme in formato array
     * @return L'array formattato
     */
    public T[] toArray() {
        T[] newArray = (T[]) new Object[vSize];
        System.arraycopy(array, 0, newArray, 0, vSize);
        return newArray;
    }
    /** Ridimensiona l'array che contiene l'insieme
     * @param newLength Lunghezza del nuovo array
     * @return Il nuovo array
     */
    protected T[] resize(int newLength) {
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
    public static <T> Set<T> union(Set<T> s1, Set<T> s2) {
        Set<T> x = new UnsortedArraySet<T>();
        T[] array1 = s1.toArray();
        for (int i = 0; i < array1.length; i++)
            x.add(array1[i]);
        array1 = (T[]) s2.toArray();
        for (int i = 0; i < array1.length; i++)
            if (!x.contain(array1[i]))
                x.add(array1[i]);
        return x;
    }
    /** Esegue l'operazione logica di intersezione su due insiemi
     * @param s1 Primo operando
     * @param s2 Secondo operando
     * @param <T> Tipo generico dei dati inseriti all'interno delgli insieme
     * @return L'inisieme risultante
     */
    public static <T> Set<T> intersection(Set<T> s1, Set<T> s2) {
        Set<T> x = new UnsortedArraySet<T>();
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
    public static <T> Set<T> substract(Set<T> s1, Set<T> s2) {
        Set<T> x = new UnsortedArraySet<T>();
        T[] array1 = (T[]) s1.toArray();
        for (int i = 0; i < array1.length; i++)
            if (!s2.contain(array1[i]))
                x.add(array1[i]);
        return x;
    }

    /** Array che andrà a contenere l'insieme */
    protected T[] array;
    /** Numero che memorizza la cella di memoria che contiene il primo elemento che verrà rimosso */
    protected int vSize;
    /** Lunghezza standard dell'array se non viene fornita */
    public static final int INITIALSIZE = 10;
}
