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
import tr.gov.ptt.entity.TahsilatDetay;


@Stateless
public class TahsilatDetayFacade extends AbstractFacade<TahsilatDetay> {
    @PersistenceContext(unitName = "tr.gov.ptt_TahsilatPRJ_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TahsilatDetayFacade() {
        super(TahsilatDetay.class);
    }


}
