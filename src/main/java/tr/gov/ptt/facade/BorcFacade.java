/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tr.gov.ptt.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.entity.Borc;


@Stateless
public class BorcFacade extends AbstractFacade<Borc> {
    @PersistenceContext(unitName = "tr.gov.ptt_TahsilatPRJ_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BorcFacade() {
        super(Borc.class);
    }

    public List<Borc> borclariGeitr(Integer p_kurumNo,String p_aboneNo)
    {
        return em.createNamedQuery("Borc.findByAboneNoKurumNo",Borc.class).setParameter("aboneNo", p_kurumNo).setParameter("kurumNo", p_aboneNo).getResultList();
    }
}

