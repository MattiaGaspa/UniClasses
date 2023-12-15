package UniClasses;

/** Classe contenente metodi utili per la gestione degli array
 */
public class ArrayAlgs {
    /** Effettua il ridimensionamento dinamico dell'array
     * @param array L'array da ridimensionare
     * @param size La nuova dimensione dell'array
     * @return L'array ridimensionato
     */
    public static Object[] resize(Object[] array, int size) {
        if (size < 0) throw new IllegalArgumentException();
        Object[] newArray = new Object[size];
        if (size < array.length) size = array.length;
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    /** riempie un array con numeri interi casuali
     * @param array L'array da riempire
     * @param min Il numero minimo
     * @param max Il numero massimo
     */
    public static void randomFill(Object[] array, int min, int max) {
        int delta = Math.abs(max - min);
        int realMin = Math.min(max, min);
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * delta + realMin);
    }

    /** Converte un array in formato stringa
     * @param array L'array da convertire
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @return La stringa in uscita
     */
    public static String toString(Object[] array, int vSize) {
        if ((vSize < 0) || (vSize > array.length)) throw new IllegalArgumentException();
        String stringa = "[";
        for (int i = 0; i < vSize; i++)
            stringa += array[i] + ", ";
        stringa += "\b\b]";
        return stringa;
    }

    /** Inserisce un elemento in un indice dell'array
     * @param array L'array dove si inserisce il valore
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @param index L'indice dove si vuole inserire il valore
     * @param value Il valore da inserire
     */
    public static void insert(Object[] array, int vSize, int index, Object value) {
        if ((index < 0) || (index > vSize) || (vSize < 0) || (vSize > array.length) || (value.getClass() != array[0].getClass())) throw new IllegalArgumentException();
        if (vSize == array.length) throw new ArrayFullException();
        for (int i = vSize; i > index; i--)
            array[i] = array[i - 1];
        array[index] = value;
    }

    /** Rimuove un elemento da un array non mantenendo l'ordine
     * @param array L'array da cui si deve eliminare l'elemento
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @param index L'indice dell'elemento da eliminare
     */
    public static void removeUnsorted(Object[] array, int vSize, int index) {
        if ((index < 0) || (vSize < 0) || (vSize > array.length) || (index > vSize)) throw new IllegalArgumentException();
        array[index] = array[vSize - 1];
        array[vSize - 1] = null;
    }
    /** Rimuove un elemento da un array mantenendo l'ordine
     * @param array L'array da cui si deve eliminare l'elemento
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @param index L'indice dell'elemento da eliminare
     */
    public static void remove(Object[] array, int vSize, int index) {
        if ((index < 0) || (vSize < 0) || (vSize > array.length) || (index > vSize)) throw new IllegalArgumentException();
        for (int i = index + 1; i < vSize; i++)
            array[i-1] = array[i];

        array[vSize - 1] = null;
    }

    /** Ritorna il valore minimo di un array di elementi confrontabili
     * @param array L'array dove si cerca il minimo
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @return Il valore minimo
     */
    public static Comparable findMin(Comparable array[], int vSize) {
        if ((vSize < 0) || (vSize > array.length)) throw new IllegalArgumentException();
        Comparable min = array[0];
        for (int i = 1; i < vSize; i++) 
            if (array[i].compareTo(min) < 0)
                min = array[i];
        return min;
    }
    /** Ritorna il valore massimo di un array di elementi confrontabili
     * @param array L'array dove si cerca il massimo
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @return Il valore massimo
     */
    public static Comparable findMax(Comparable array[], int vSize) {
        if ((vSize < 0) || (vSize > array.length)) throw new IllegalArgumentException();
        Comparable max = array[0];
        for (int i = 1; i < vSize; i++) 
            if (array[i].compareTo(max) > 0)
                max = array[i];
        return max;
    }

    /** Effettua la ricerca lineare di un elemento al'interno dell'array
     * @param array L'array nel quale si cerca l'elemento
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @param value Il valore da trovare
     * @return L'inidce del primo elemento che coincide con il valore dato (-1 se non presente)
     */
    public static int linearSearch(Object[] array, int vSize, Object value) {
        if ((vSize < 0) || (vSize > array.length) || (value.getClass() != array[0].getClass())) throw new IllegalArgumentException();
        for (int i = 0; i < vSize; i++) {
            if (array[i].equals(value)) return i;
        }
        return -1;
    }
    /** Effettua la ricerca binaria in un array ordinato
     * @param array L'array nel quale si cerca l'elemento
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @param value Il valore da trovare
     * @return L'inidce del primo elemento che coincide con il valore dato (-1 se non presente)
     */
    public static int binarySearch(Object[] array, int vSize, Object value) {
        if ((vSize < 0) || (vSize > array.length) || (value.getClass() != array[0].getClass())) throw new IllegalArgumentException();
        // Complete
        return -1;
    }

    /** Effettua l'ordinamento dell'array con algoritmo Selection sort
     * @param array L'array da ordinare
     * @param vSize La prima cella di memoria che non contiene un valore valido
     */
    public static void SelectionSort(Comparable[] array, int vSize) {
        if ((vSize < 0) || (vSize > array.length)) throw new IllegalArgumentException();
        // TODO
    }
    /** Effettua l'ordinamento dell'array con algoritmo Merge sort
     * @param array L'array da ordinare
     * @param vSize La prima cella di memoria che non contiene un valore valido
     */
    public static void MergeSort(Comparable[] array, int vSize) {
        if ((vSize < 0) || (vSize > array.length)) throw new IllegalArgumentException();
        // TODO
    }
    private static void Merge(Comparable[] array, Comparable[] left, Comparable[] right) {
        // TODO
    }
    /** Effettua l'ordinamento dell'array con algoritmo Insertion sort
     * @param array L'array da ordinare
     * @param vSize La prima cella di memoria che non contiene un valore valido
     */
    public static void InsertionSort(Comparable[] array, int vSize) {
        if ((vSize < 0) || (vSize > array.length)) throw new IllegalArgumentException();
        // TODO
    }
}

class ArrayFullException extends RuntimeException { }