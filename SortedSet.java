package UniClasses;

/** Interfaccia per implementare un insieme totalmente ordinato (Dictionary)
 * @param <T> Tipo generico dei dati inseriti all'interno dell'insieme
 */
public interface SortedSet<T extends Comparable<T>> extends Set<T> {
    /** Inserisce un elemento nell'insieme, se questo non è già presente
     * @param obj L'oggetto da inserire
     */
    void add(T obj);
    /** Formatta l'insieme in un array ordinato
     * @return L'array formattato
     */
    T[] toSortedArray();
}
