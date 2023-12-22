package UniClasses;

/** Classe che implementa l'interfaccia Dictionary. Non ordinato e ridimensionabile
 * @param <T> Tipo generico per la chiave delle coppie
 * @param <E> Tipo generico per il valore associato alle chiavi
*/
public class UnsortedArrayDictionary<T extends Comparable<T>, E> implements Dictionary<T, E> {
    /** Viene costruito un dizionario di una dimensione fissata e lo si inizializza a zero
     */
    public UnsortedArrayDictionary() {
        array = new Pair[INITIALSIZE];
        makeEmpty();
    }
    /** Viene costruito un dizionario di una dimensione data e lo si inizializza a zero
     * @param size La dimensione dell'array
     */
    public UnsortedArrayDictionary(int size) {
        array = new Pair[size];
        makeEmpty();
    }

    /** Controlla se il dizionario è vuoto
    * @return Vero se la coda è vuoto altrimenti falso
    */
    public boolean isEmpty() { return vSize == 0; }
    /** Rende vuoto il dizionario
    */
    public void makeEmpty() { vSize = 0; }

    /** Inserisce una coppia chiave/valore nel dizionario
     * @param key La chiave con cui si inserisce l'elemento
     * @param value L'elemento da inserire
     */
    public void insert(T key, E value) {
        if (key == null) throw new IllegalArgumentException();
        try {
            remove(key);
        }
        catch (DictionaryItemNotFoundException e) {}
        if (vSize == array.length) array = resize(2 * vSize);
        array[vSize++] = new Pair(key, value);
    }
    /** Rimuove un elemento dal dizionario
     * @param key La chiave dell'elemento da rimuovere
     */
    public void remove(T key) {
        if (key == null) throw new IllegalArgumentException();
        array[linearSearch(key)] = array[--vSize];
    }
    /** Trova un elemento nel dizionario
     * @param key La chiave da trovare
     * @return L'elemento associato alla chiave
     */
    public E find(T key) {
        return array[linearSearch(key)].getValue();
    }
    /** Ridimensiona l'array che contiene le coppie chiave/valore
     * @param newLength Lunghezza del nuovo array
     * @return Il nuovo array
     */
    protected Pair<T, E>[] resize(int newLength) {
        Pair<T, E>[] newArray = new Pair[newLength];
        if (newLength < vSize) newLength = vSize;
        System.arraycopy(array, 0, newArray, 0, newLength);
        return newArray;
    }
    private int linearSearch(T key) {
        for (int i = 0; i < vSize; i++)
            if (array[i].getKey().compareTo(key) == 0)
                return i;
        throw new DictionaryItemNotFoundException();
    }
    public String toString() {
        String s = "";
        for (int i = 0; i < vSize; i++)
            s += array[i].toString() + '\n';
        return s;
    }

    /** Classe interna che implementa la coppia chiave/valore
     * @param <T> Tipo generico per la chiave delle coppie
     * @param <E> Tipo generico per il valore associato alle chiavi
     */
    protected class Pair<T extends Comparable<T>, E> {
        /** Costrutto per creare una coppia chiave/valore
         * @param key Il valore della chiave
         * @param value Il valore associato alla chiave
         */
        protected Pair(T key, E value) {
            setKey(key);
            setValue(value);
        }

        /** Formatta la coppia chiave/valore
         * @return La stringa che descrive la coppia
         */
        public String toString() { return key + ": " + value; }
        /** Ottiene la chiave
         * @return La chiave
         */
        protected T getKey() { return this.key; }
        /** Ottiene il valore
         * @return Il valore
         */
        protected E getValue() { return this.value; }
        /** Imposta la chiave
         * @param key Chiave da impostare
         */
        protected void setKey(T key) { this.key = key; }
        /** Imposta il valore
         * @param value Valore da impostare
         */
        protected void setValue(E value) { this.value = value; }

        /** Chiave della coppia */
        protected T key;
        /** Valore associato alla chiave */
        protected E value;
    }

    /** Array che andrà a contenere la coppia di chiavi/valori */
    protected Pair<T, E>[] array;
    /** Numero che memorizza la cella di memoria che contiene il primo elemento che verrà rimosso */
    protected int vSize;
    /** Lunghezza standard dell'array se non viene fornita */
    public static final int INITIALSIZE = 10;
}