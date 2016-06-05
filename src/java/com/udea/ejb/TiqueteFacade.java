/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.business.Tiquete;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JPOH97
 */
@Stateless
public class TiqueteFacade extends AbstractFacade<Tiquete> implements TiqueteFacadeLocal {

    @PersistenceContext(unitName = "WWWAirlinesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiqueteFacade() {
        super(Tiquete.class);
    }

    @Override
    public List<Tiquete> findAvalibles(Object id) {
        Query q = em.createQuery("SELECT t FROM Tiquete t WHERE t.tiquetePK = :value");
        q.setParameter("value", id);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return q.getResultList();
    }

    @Override
    public Tiquete finfByCodigo(String codigo) {
        Query q =  em.createNamedQuery("Tiquete.findByCodigo");
        q.setParameter("codigo", codigo);
        try{
        return (Tiquete)q.getSingleResult();
        }catch(NoResultException nre){
            return null;
        }
    }
}
