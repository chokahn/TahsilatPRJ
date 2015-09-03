/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tr.gov.ptt.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tr.gov.ptt.entity.Borc;
import tr.gov.ptt.facade.BorcFacade;

@Stateless
public class BorcService {
    
    @Inject
    BorcFacade borcFacade;
    
    public List<Borc> borclariGetir(Integer p_kurumNo,String p_aboneNo)
    {
        return borcFacade.borclariGeitr(p_kurumNo, p_aboneNo);
    }
}
