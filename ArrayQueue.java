package UniClasses;

/** Classe che implementa l'interfaccia Queue. Ridimensionabile
 * @param <T> Tipo generico dei dati inseriti all'interno della coda
*/
public class ArrayQueue<T> extends FixedArrayQueue<T> {
    /** Aggiunge un elemento alla coda
     * @param obj Elemento da aggiungere
     */
    public void enqueue(T obj) {
        if (obj == null) throw new IllegalArgumentException();
        if (increment(back) == front) {
            array = resize(2*array.length);
            if (back < front) {
                System.arraycopy(array, 0, array, array.length/2, back);
                back += array.length/2;
            }
        }
        array[back] = obj;
        back = increment(back);
    }
    private T[] resize(int newLength) {
        if (newLength < 0) throw new IllegalArgumentException();
        T[] newArray = (T[]) new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }
}
