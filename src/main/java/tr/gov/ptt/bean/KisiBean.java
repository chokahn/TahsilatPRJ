/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import tr.gov.ptt.entity.Kisi;
import tr.gov.ptt.service.KisiService;
import tr.gov.ptt.util.JSFUtil;

@Named(value = "kisiBean")
@SessionScoped
public class KisiBean implements Serializable {
    private Kisi kisi = new Kisi();

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    @Inject
    KisiService kisiService;

    public String girisKontrol() {
        
        ResourceBundle backendText = FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(),"msg");
       
        Kisi vtKisi = kisiService.girisKontrol(this.kisi);
        if (vtKisi == null) {
            JSFUtil.mesajGoster(backendText.getString("tahsilatprj.giris.loginErrorSummary"),
                    backendText.getString("tahsilatprj.giris.loginErrorDetail"),
                    FacesMessage.SEVERITY_WARN);

            return "giris.xhtml?faces-context=true"; 
        } else {
            this.kisi = vtKisi;

            HttpSession session = JSFUtil.getSession();
            session.setAttribute("kullanici", this.kisi.getKullaniciAd());
            return "menu.xhtml?faces-context=true";
        }
    }

    public String guvenliCikis() {
        HttpSession httpSession = JSFUtil.getSession();

        JSFUtil.closeSession(httpSession);
        JSFUtil.mesajGoster("Session Kapatıldı.", "Yeniden Giriş Yapınız.", FacesMessage.SEVERITY_INFO);

        return "giris.xhtml?faces-redirect=true";
    }

    public KisiBean() {
        this.kisi.setTema("bluesky");
    }

}
