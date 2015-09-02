/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tr.gov.ptt.facade.KurumFacade;

@Stateless
public class KurumService {

    @Inject
    KurumFacade kurumFacade;

    public List<String> kurumAdlariniGetir() {
        return kurumFacade.kurumAdlariniGetir();
    }

    public Integer kurumAdIleNoGetir(String p_kurumAdi) {
        return kurumFacade.kurumAdIleNoGetir(p_kurumAdi);
    }
}

