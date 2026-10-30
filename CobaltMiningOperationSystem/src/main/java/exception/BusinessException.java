/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author zefrialrizkullah
 */

public class BusinessException extends RuntimeException {
    public BusinessException(String m) {
        super(m);
    }
    
    public BusinessException(String m, Throwable e) {
        super(m, e);
    }
}
