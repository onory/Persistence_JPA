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


public class EliminarObjetoJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
               
         //Paso 1. Inicia transaccion
        tx.begin();
        
        //paso 2. ejecutamos un sql de tipo select
        
        Persona persona1 = em.find(Persona.class,1);
        
       //paso 3.cierre de transaacion
        
        tx.commit();
        
        //imprime objeto encontrado para su elimnacion
        
             
        log.debug("Objeto enocntrado :" + persona1);
        
        //Paso 4. iniciamos transaccion 2
        
         //seleccionamos el objeto a eliminar
         
         EntityTransaction tx2 = em.getTransaction();
         
         tx2.begin();
         
         //Paso 5. ejecutamos el sql de tipo delete
                 
        em.remove(em.merge(persona1)); // se agrega el merge para sincronizar la informacion con el objeto en memoria
        
        //Paso 6. termina transaccion 2
        
        tx2.commit();
        
        //objeto elimnado en la DB
        
        log.debug("Objeto elimnado :" + persona1);
        
        //Cerramos el entity manager
        em.close();
        
    }
}
