/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zefrialrizkullah
 */

public final class IdGenerator {
    private static final Map<String, Integer> counters = new HashMap<>();
    private IdGenerator() {}
    
    public static synchronized int generate(String entity) {
        String key = entity.toUpperCase();
        int nextId = counters.getOrDefault(key, 0) + 1;
        counters.put(key, nextId);
        return nextId;
    }
    
    public static synchronized void setCurrent(String entity, int currentId) {
        counters.put(entity.toUpperCase(), currentId);
    }
}
