/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import tr.gov.ptt.entity.Borc;
import tr.gov.ptt.entity.Tahsilat;
import tr.gov.ptt.service.BorcService;
import tr.gov.ptt.service.KurumService;

@Named(value = "tahsilatBean")
@ViewScoped
public class TahsilatBean implements Serializable{

    private Tahsilat tahsilat = new Tahsilat();
    public Tahsilat getTahsilat() {
        return tahsilat;
    }
    public void setTahsilat(Tahsilat tahsilat) {
        this.tahsilat = tahsilat;
    }
   
    
    private Borc borc=new Borc();
    public Borc getBorc() {
        return borc;
    }
    public void setBorc(Borc borc) {
        this.borc = borc;
    }

    @Inject
    BorcService borcService;
    
    
    private List<Borc> kurumFaturaListesi = new ArrayList<Borc>();
    public List<Borc> getKurumFaturaListesi() {
        return kurumFaturaListesi;
    }
    public void setKurumFaturaListesi(List<Borc> kurumFaturaListesi) {
        this.kurumFaturaListesi = kurumFaturaListesi;
    }
    
    

    @Inject
    KurumService kurumService;

    public List<String> kurumAdiTamamala(String p_sorgu) {
        List<String> kurumSonucListe = new ArrayList<String>();
        List<String> kurumAdiListe = kurumService.kurumAdlariniGetir();

        for (String kurumAdi : kurumAdiListe) {
            if (kurumAdi.toUpperCase(new Locale("tr","TR")).startsWith(p_sorgu.toUpperCase(new Locale("tr","TR")))) {
                kurumSonucListe.add(kurumAdi);
            }
        }
        return kurumSonucListe;
    }

    public TahsilatBean() {

    }
    
    public String borcSorgula()
    {
        tahsilat.getKurum().setNo(kurumService.kurumAdIleNoGetir(tahsilat.getKurum().getAd()));
        kurumFaturaListesi = borcService.borclariGetir(tahsilat.getKurum().getNo(),borc.getAboneNo());
        return "tahsilatListele.xhtml?faces-redirect=true";
    }
}
