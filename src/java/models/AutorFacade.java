/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Autor;
import entities.Pais;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pc
 */
@Stateless
public class AutorFacade extends AbstractFacade<Autor> {

    @PersistenceContext(unitName = "sistema_librosPU")
    private EntityManager em;
    
    @EJB
    private PaisFacade paisFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutorFacade() {
        super(Autor.class);
    }
    
    public List<Pais> obtenerListaPaises() {
        EntityManager em = getEntityManager();
        Query query_pais_autor = em.createNamedQuery("Pais.findAll", Pais.class);
        return query_pais_autor.getResultList();
    }
    
}
