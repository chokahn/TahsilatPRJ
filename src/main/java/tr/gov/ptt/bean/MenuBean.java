/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tr.gov.ptt.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import tr.gov.ptt.entity.Menu;
import tr.gov.ptt.service.MenuService;

@Named
@SessionScoped
public class MenuBean implements Serializable
{
    @Inject
    private KisiBean kisiBean;
    
    @Inject
    private MenuService menuService;
        
    private DefaultMenuModel menuModel;

    public MenuBean() {
        menuModel=new DefaultMenuModel();   
    }
    
    @PostConstruct
    public void menuDoldur()
    {
        List<Menu> ustMenuListesi = kisiBean.getKisi().getTip().getMenuList();
        for (Menu ustMenu : ustMenuListesi) {
            
            DefaultSubMenu subMenu =new DefaultSubMenu(ustMenu.getBaslik());
            subMenu.setIcon(ustMenu.getIcon());
            for (Menu menu : menuService.altMenuleriGetir(ustMenu.getNo())) 
            {
                DefaultMenuItem altMenu = new DefaultMenuItem(menu.getBaslik());
                altMenu.setCommand(menu.getLink());
                altMenu.setIcon(menu.getIcon());
                subMenu.addElement(altMenu);
            }

            menuModel.addElement(subMenu);
        }
    }

    public DefaultMenuModel getMenuModel() {
        return menuModel;
    }
}
