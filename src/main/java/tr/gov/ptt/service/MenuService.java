/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tr.gov.ptt.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tr.gov.ptt.entity.Menu;
import tr.gov.ptt.facade.MenuFacade;

@Stateless
public class MenuService {
    @Inject
    private MenuFacade menuFacede;

    public List<Menu> altMenuleriGetir(Integer p_ustMenuNo) 
    {
        return menuFacede.altMenuleriGetir(p_ustMenuNo);
    }
}
