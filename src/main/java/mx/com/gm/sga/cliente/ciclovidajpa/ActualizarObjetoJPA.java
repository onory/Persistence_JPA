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
public class ActualizarObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
        
        //Paso 1. inicia transaccion
        
        tx.begin();
        
       //paso 2. Ejecutamos SQL de tipo select
       //id proporcionado debe existir en la DB
       Persona persona1 = em.find(Persona.class, 1);
       
     //paso3. termina la transaccion 1
     
     tx.commit();
     
     //objeto ene stado detache
     
     log.debug("Objeto recuperado: " + persona1);
     
     //modificamos el valor de apeelido por setValue
     
     persona1.setApellido("Potter");
     
     //paso5. iniciamos transaccion2 
     
     EntityTransaction tx2 = em.getTransaction();
     
     tx2.begin();
     
     //paso 6. se efectua el update del objeto recuperado
     
     em.merge(persona1); // guarda cambio hasta terminar transsacion
     
     //paso 7. terminamos transaccion 2
     
     tx2.commit();
     
     //objeto pasa a estado detache modificado
     
     log.debug("Objeto recuperado: " + persona1);
             
     //Cerramos el entity manager
        em.close();
    
}
}
