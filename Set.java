/** Interfaccia per implementare un insieme (Set)
 * @param <T> Tipo generico dei dati inseriti all'interno dell'insieme
 */
public interface Set<T> extends Container {
    /** Inserisce un elemento nell'insieme, se questo non è già presente
     * @param obj L'oggetto da inserire
     */
    void add(T obj);
    /** Ritorna la presenza di un elemento nell'insieme
     * @param obj L'oggetto d ricercare
     * @return true se l'oggetto è presente, altrimenti false
     */
    boolean contain(T obj);
    /** Formatta l'insieme in formato array
     * @return L'array formattato
     */
    T[] toArray();
}
