/** Checked exception for bad location
 *
 * You should throw this whenever there is a bad location.
 * For example, a location that is outside of the world.
 */
public class BadLocationException extends Exception{
    public BadLocationException(String s){
        super(s);
    }
}