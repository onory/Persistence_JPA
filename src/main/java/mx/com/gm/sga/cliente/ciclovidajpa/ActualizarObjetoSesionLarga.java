/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import static mx.com.gm.sga.cliente.ciclovidajpa.PersistirObjetoJPA.log;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;


public class ActualizarObjetoSesionLarga {
    
public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
        
         //Paso 1. Inicia transaccion
        tx.begin();
        
        //Paso 2. Crea nuevo objeto
        
        Persona persona1 = em.find(Persona.class,1);
        
        log.debug("Objeto encontrado:" + persona1);
       
        
        //Paso 3. setValue usando los set modificamos los valores
        //se pueden efectuar n modificaciones dejando siempre la ultima
        persona1.setEmail("Adrianpotter@mail.com");
        persona1.setEmail("apotter@mail.com");
        
                  
        //Paso 4. termina la transaccion se ahce commit
        tx.commit();
        
        //Objeto en estado detached
        log.debug("Objeto modificado :" + persona1);
        
        //Cerramos el entity manager
        em.close();
        
    }
    
}
    

