/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;


/**
 *
 * @author onory
 */
public class EncontrarObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
        
        //Paso 1. inicia transaccion
        
        tx.begin();
        
       //paso 2. Ejecutamos SQL de tipo select
                                             //el 1 es el numero del id de db
       Persona persona1 = em.find(Persona.class, 1);
       
       //paso 3. termina transaccion
       
       tx.commit();
       
       //imprimimos objeto en estado detached 
       
       log.debug("Objeto recuperado: " + persona1);
        
        //Cerramos el entity manager
        em.close();
}
}
