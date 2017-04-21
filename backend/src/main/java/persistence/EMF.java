/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luisavivas
 */
public class EMF {
    
    private static final EntityManagerFactory EMF_INSTANCE = Persistence.createEntityManagerFactory("echoPU");
    
    private EMF(){
        
    }
    
    public static EntityManagerFactory get() {
        return EMF_INSTANCE;
    }
    
}
