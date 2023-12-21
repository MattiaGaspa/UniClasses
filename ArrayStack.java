/** Classe che implementa l'interfaccia Stack. Ridimensionabile
 * @param <T> Tipo generico dei dati inseriti all'interno dello stack
 */
public class ArrayStack<T> extends FixedArrayStack<T> {
    /** Inserisce un elemento nello stack, se questo è pieno ne raddoppia la dimensione */
    public void push(T obj) {
        if (obj == null) throw new IllegalArgumentException();
        if (vSize == array.length) array = resize(2 * vSize);
        array[vSize++] = obj;
    }
    private T[] resize(int newLength) {
        if (newLength < 0) throw new IllegalArgumentException();
        T[] newArray = (T[]) new Object[newLength];
        if (newLength < vSize) vSize = newLength;
        System.arraycopy(array, 0, newArray, 0, vSize);
        return newArray;
    }
}
