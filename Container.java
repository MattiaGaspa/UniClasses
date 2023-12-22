package UniClasses;

/** Interfaccia Container che verrà utilizzata per estendere le interfacce dei dati astratti */
public interface Container {
    /** Verifica se il Container è vuoto
     * @return true se il Container è vuoto, altrimenti false
     */
    boolean isEmpty();
    /** Rende vuoto il Container */
    void makeEmpty();
}
