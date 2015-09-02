/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import tr.gov.ptt.facade.KisiFacade;

@Named
@SessionScoped
public class ThemeBean implements Serializable {

    @Inject
    private KisiFacade kisiFacede;
    
    @Inject
    private KisiBean kisiBean;
        
    private Map<String, String> temaListesi;

    public Map<String, String> getTemaListesi() {
        return temaListesi;
    }

    public void setTemaListesi(Map<String, String> temaListesi) {
        this.temaListesi = temaListesi;
    }

    public ThemeBean() {
        this.temaListesi = new HashMap<String, String>();
        this.temaListesi.put("Afterdark", "afterdark");
        this.temaListesi.put("Afterwork", "afterwork");
        this.temaListesi.put("Aristo", "aristo");
        this.temaListesi.put("Black-Tie", "black-tie");
        this.temaListesi.put("Blitzer", "blitzer");
        this.temaListesi.put("Bluesky", "bluesky");
        this.temaListesi.put("Bootstrap", "bootstrap");
        this.temaListesi.put("Casablanca", "casablanca");
        this.temaListesi.put("Cupertino", "cupertino");
        this.temaListesi.put("Cruze", "cruze");
        this.temaListesi.put("Dark-Hive", "dark-hive");
        this.temaListesi.put("Delta", "delta");
        this.temaListesi.put("Dot-Luv", "dot-luv");
        this.temaListesi.put("Eggplant", "eggplant");
        this.temaListesi.put("Excite-Bike", "excite-bike");
        this.temaListesi.put("Flick", "flick");
        this.temaListesi.put("Glass-X", "glass-x");
        this.temaListesi.put("Home", "home");
        this.temaListesi.put("Hot-Sneaks", "hot-sneaks");
        this.temaListesi.put("Humanity", "humanity");
        this.temaListesi.put("Le-Frog", "le-frog");
        this.temaListesi.put("Midnight", "midnight");
        this.temaListesi.put("Mint-Choc", "mint-choc");
        this.temaListesi.put("Overcast", "overcast");
        this.temaListesi.put("Pepper-Grinder", "pepper-grinder");
        this.temaListesi.put("Redmond", "redmond");
        this.temaListesi.put("Rocket", "rocket");
        this.temaListesi.put("Sam", "sam");
        this.temaListesi.put("Smoothness", "smoothness");
        this.temaListesi.put("South-Street", "south-street");
        this.temaListesi.put("Start", "start");
        this.temaListesi.put("Sunny", "sunny");
        this.temaListesi.put("Swanky-Purse", "swanky-purse");
        this.temaListesi.put("Trontastic", "trontastic");
        this.temaListesi.put("UI-Darkness", "ui-darkness");
        this.temaListesi.put("UI-Lightness", "ui-lightness");
        this.temaListesi.put("Vader", "vader");
    }

    public void temayiKaydet()
    {
        kisiFacede.edit(kisiBean.getKisi());
    }
}
