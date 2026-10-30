/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author zefrialrizkullah
 */

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String m) {
        super(m);
    }
    
    public DataNotFoundException(String m, Throwable e) {
        super(m, e);
    }
}
