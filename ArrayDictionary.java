/** Classe che implementa l'interfaccia Dictionary. Ordinato e ridimensionabile
 * @param <T> Tipo generico per la chiave delle coppie
 * @param <E> Tipo generico per il valore associato alle chiavi
*/
public class ArrayDictionary<T extends Comparable<T>, E> extends UnsortedArrayDictionary<T, E> {
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
        insertionSort(new Pair<T, E>(key, value));
    }
    /** Rimuove un elemento dal dizionario
     * @param key La chiave dell'elemento da rimuovere
     */
    public void remove(T key) {
        if (key == null) throw new IllegalArgumentException();
        int index = binarySearch(key);
        for (int i = index+1; i < vSize; i++)
            array[i-1] = array[i];
        vSize--;
    }
    /** Trova un elemento nel dizionario, con algoritmo di ricerca binaria
     * @param key La chiave da trovare
     * @return L'elemento associato alla chiave
     */
    public E find(T key) {
        return array[binarySearch(key)].getValue();
    }
    private int binarySearch(T key) {
        if (key == null) throw new IllegalArgumentException();
        return binSearch(key, 0, vSize-1);
    }
    private int binSearch(T key, int from, int to) {
        if (from > to) throw new DictionaryItemNotFoundException();
        int m = (to + from) / 2;
        T middle = array[m].getKey();
        if (middle.compareTo(key) > 0) return binSearch(key, 0, m-1);
        else if (middle.compareTo(key) < 0) return binSearch(key, m+1, vSize-1);
        else return m;
    }
    private void insertionSort(Pair<T, E> insertion) {
        for (int i = 1; i < vSize; i++) {
            Pair<T,E> temp = array[i];
            int j;
            for (j = i; temp.getKey().compareTo(array[j-1].getKey()) > 0 && j > 0; j++)
                array[j] = array[j-1];
            array[j] = temp;
        }
    }
}