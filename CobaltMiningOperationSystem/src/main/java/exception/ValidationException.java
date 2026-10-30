/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author zefrialrizkullah
 */

public class ValidationException extends RuntimeException {
    public ValidationException(String m) {
        super(m);
    }
    
    public ValidationException(String m, Throwable e) {
        super(m, e);
    }
}
