/** Classe contenente metodi utili per la gestione degli array
 */
public class ArrayAlgs {
    /** Effettua il ridimensionamento dinamico dell'array
     * @param array L'array da ridimensionare
     * @param size La nuova dimensione dell'array
     * @param <T> Tipo generico dei dati inseriti all'interno dell'array
     * @return L'array ridimensionato
     */
    public static <T> T[] resize(T[] array, int size) {
        if (size < 0) throw new IllegalArgumentException();
        T[] newArray = (T[]) new Object[size];
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
     * @param <T> Tipo generico dei dati inseriti all'interno dell'array
     * @return La stringa in uscita
     */
    public static <T> String toString(T[] array, int vSize) {
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
     * @param <T> Tipo generico dei dati inseriti all'interno dell'array
     */
    public static <T> void insert(T[] array, int vSize, int index, T value) {
        if ((index < 0) || (index > vSize) || (vSize < 0) || (vSize > array.length)) throw new IllegalArgumentException();
        if (vSize == array.length) throw new ArrayFullException();
        for (int i = vSize; i > index; i--)
            array[i] = array[i - 1];
        array[index] = value;
    }

    /** Rimuove un elemento da un array non mantenendo l'ordine
     * @param array L'array da cui si deve eliminare l'elemento
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @param index L'indice dell'elemento da eliminare
     * @param <T> Tipo generico dei dati inseriti all'interno dell'array
     */
    public static <T> void removeUnsorted(T[] array, int vSize, int index) {
        if ((index < 0) || (vSize < 0) || (vSize > array.length) || (index > vSize)) throw new IllegalArgumentException();
        array[index] = array[vSize - 1];
        array[vSize - 1] = null;
    }
    /** Rimuove un elemento da un array mantenendo l'ordine
     * @param array L'array da cui si deve eliminare l'elemento
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @param index L'indice dell'elemento da eliminare
     * @param <T> Tipo generico dei dati inseriti all'interno dell'array
     */
    public static <T> void remove(T[] array, int vSize, int index) {
        if ((index < 0) || (vSize < 0) || (vSize > array.length) || (index > vSize)) throw new IllegalArgumentException();
        for (int i = index + 1; i < vSize; i++)
            array[i-1] = array[i];

        array[vSize - 1] = null;
    }

    /** Ritorna il valore minimo di un array di elementi confrontabili
     * @param array L'array dove si cerca il minimo
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @param <T> Tipo generico dei dati inseriti all'interno dell'array
     * @return Il valore minimo
     */
    public static <T extends Comparable<T>> T findMin(T[] array, int vSize) {
        if ((vSize < 0) || (vSize > array.length)) throw new IllegalArgumentException();
        T min = array[0];
        for (int i = 1; i < vSize; i++) 
            if (array[i].compareTo(min) < 0)
                min = array[i];
        return min;
    }
    /** Ritorna il valore massimo di un array di elementi confrontabili
     * @param array L'array dove si cerca il massimo
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @param <T> Tipo generico dei dati inseriti all'interno dell'array
     * @return Il valore massimo
     */
    public static <T extends Comparable<T>> T findMax(T array[], int vSize) {
        if ((vSize < 0) || (vSize > array.length)) throw new IllegalArgumentException();
        T max = array[0];
        for (int i = 1; i < vSize; i++) 
            if (array[i].compareTo(max) > 0)
                max = array[i];
        return max;
    }

    /** Effettua la ricerca lineare di un elemento al'interno dell'array
     * @param array L'array nel quale si cerca l'elemento
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @param value Il valore da trovare
     * @param <T> Tipo generico dei dati inseriti all'interno dell'array
     * @return L'inidce del primo elemento che coincide con il valore dato (-1 se non presente)
     */
    public static <T> int linearSearch(T[] array, int vSize, Object value) {
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
     * @param <T> Tipo generico dei dati inseriti all'interno dell'array
     * @return L'inidce del primo elemento che coincide con il valore dato (-1 se non presente)
     */
    public static <T extends Comparable<T>> int binarySearch(T[] array, int vSize, T value) {
        if ((vSize < 0) || (vSize > array.length) || (value.getClass() != array[0].getClass())) throw new IllegalArgumentException();
        return binSearch(array, 0, vSize-1, value);
    }
    private static <T extends Comparable<T>> int binSearch(T[] v, int from, int to, T value) {
        if (from > to) return -1;
        int m = (to + from) / 2;
        T middle = v[m];
        if (middle.compareTo(value) == 0) return m;
        else if (middle.compareTo(value) < 0) return binSearch(v, m+1, to, value);
        else return binSearch(v, from, m-1, value);
    }

    /** Effettua l'ordinamento dell'array con algoritmo Selection sort
     * @param array L'array da ordinare
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @param <T> Tipo generico dei dati inseriti all'interno dell'array
     */
    public static <T extends Comparable<T>> void selectionSort(T[] array, int vSize) {
        if ((vSize < 0) || (vSize > array.length)) throw new IllegalArgumentException();
        for (int i = 0; i < vSize-1; i++) {
            int min = i;
            for (int j = i+1; j < vSize; j++)
                if (array[min].compareTo(array[j]) > 0) min = j;
            if (min != i) {
                T t = array[min];
                array[min] = array[i];
                array[i] = t;
            }
        }
    }
    /** Effettua l'ordinamento dell'array con algoritmo Merge sort
     * @param array L'array da ordinare
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @param <T> Tipo generico dei dati inseriti all'interno dell'array
     */
    public static <T extends Comparable<T>> void mergeSort(T[] array, int vSize) {
        if ((vSize < 0) || (vSize > array.length)) throw new IllegalArgumentException();
        if (array.length < 2) return;
        int middle = vSize/2;
        T[] left = (T[]) new Comparable[middle];
        T[] right = (T[]) new Comparable[vSize - middle];
        System.arraycopy(array, 0, left, 0, middle);
        System.arraycopy(array, middle, right, 0, vSize-middle);
        mergeSort(left, middle);
        mergeSort(right, vSize-middle);
        merge(array, left, right);
    }
    private static <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right) {
        int i = 0;
        int il = 0;
        int ir = 0;
        while ((il < left.length) && (ir < right.length)) {
            if (left[il].compareTo(right[ir]) < 0)
                array[i++] = left[il++];
            else
                array[i++] = right[ir++];
        }
        while (il < left.length) {
            array[i++] = left[il++];
        }
        while (ir < right.length) {
            array[i++] = right[ir++];
        }
    }
    /** Effettua l'ordinamento dell'array con algoritmo Insertion sort
     * @param array L'array da ordinare
     * @param vSize La prima cella di memoria che non contiene un valore valido
     * @param <T> Tipo generico dei dati inseriti all'interno dell'array
     */
    public static <T extends Comparable<T>> void insertionSort(T[] array, int vSize) {
        if ((vSize < 0) || (vSize > array.length)) throw new IllegalArgumentException();
        for (int i = 1; i < vSize; i++) {
            T temp = array[i];
            int j;
            for (j = i; j>0 && temp.compareTo(array[j-1]) < 0; j--) {
                array[j] = array[j-1];
            }
            array[j] = temp;
        }
    }
}

class ArrayFullException extends RuntimeException { }