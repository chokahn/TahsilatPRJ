package tr.gov.ptt.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import tr.gov.ptt.entity.Kisi;
import tr.gov.ptt.facade.KisiFacade;

@Stateless
public class KisiService {

    @Inject
    private KisiFacade kisiFacede;

    public Kisi girisKontrol(Kisi p_kisi) 
    {
        return kisiFacede.girisKontrol(p_kisi);
    }
}
