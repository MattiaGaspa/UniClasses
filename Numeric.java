/** Classe contenente  metodi utili per gestire numeri
 */
public class Numeric {
    /** Calcola se due numeri double sono approssimativamente uguali: |a - b| &lt; 1E-14 * max(|a|, |b|)
     * @param a Primo numero a virgola mobile da comparare
     * @param b Secondo numero a virgola mobile da comparare
     * @return Ritorna vero se i due numeri sono approssimativamente uguali altrimenti falso
     */
    public static boolean approxEqual(double a, double b) {
        return Math.abs(a - b) < 1E-14 * Math.max(Math.abs(a), Math.abs(b));
    }
}
