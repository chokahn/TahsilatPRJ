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
import tr.gov.ptt.entity.Kurum;

@Stateless
public class KurumFacade extends AbstractFacade<Kurum> {

    @PersistenceContext(unitName = "tr.gov.ptt_TahsilatPRJ_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KurumFacade() {
        super(Kurum.class);
    }

    public List<String> kurumAdlariniGetir() {
        return em.createQuery("select k.ad from Kurum k order by k.ad").getResultList();
    }

    public Integer kurumAdIleNoGetir(String p_kurumAdi) {
        return em.createNamedQuery("Kurum.findByAd", Integer.class).setParameter("ad", p_kurumAdi).getSingleResult();
    }
}
