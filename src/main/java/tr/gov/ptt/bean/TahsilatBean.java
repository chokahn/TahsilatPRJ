/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.bean;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;
import tr.gov.ptt.entity.Borc;
import tr.gov.ptt.entity.Tahsilat;
import tr.gov.ptt.entity.TahsilatDetay;
import tr.gov.ptt.facade.TahsilatDetayFacade;
import tr.gov.ptt.facade.TahsilatFacade;
import tr.gov.ptt.service.BorcService;
import tr.gov.ptt.service.KurumService;

@Named(value = "tahsilatBean")
@SessionScoped
public class TahsilatBean implements Serializable{
    @Inject
    BorcService borcService;
   
    double toplamPara;
    double alinanPara;
    double paraUstu;
    Tahsilat tahsilat = new Tahsilat();
    Borc borc=new Borc();
    List<Borc> kurumFaturaListesi = new ArrayList<Borc>();
    List<Borc> seciliFaturaListesi = new ArrayList<Borc>();



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

    public String borcSorgula()
    {
        this.toplamPara = this.alinanPara = this.paraUstu = 0;
         
        tahsilat.getKurum().setNo(kurumService.kurumAdIleNoGetir(tahsilat.getKurum().getAd()));
        kurumFaturaListesi = borcService.borclariGetir(tahsilat.getKurum().getNo(),borc.getAboneNo());
        return "tahsilatListele.xhtml?faces-redirect=true";
    }

    public void toplamParaHesapla()
    {
        this.toplamPara = this.paraUstu = 0;
        
        for (Borc seciliFatura : seciliFaturaListesi) {
          this.toplamPara+=seciliFatura.getFaturaTutar();
        } 
        paraUstuHesapla();
    }
        
    
    public void paraUstuHesapla()
    {
        this.paraUstu = this.alinanPara - this.toplamPara;
    }

    @Inject
    KurumService kurumService;
        
    @Inject
    TahsilatFacade tahsilatFacade;
   
    @Inject
    TahsilatDetayFacade tahsilatDetayFacade;
       
    @Inject
    KisiBean kisiBean;
    
    public String ode()
    {
//        Tahsilat tahsilat=new Tahsilat();
//        tahsilat.setIslemTrh(new Date());
//        tahsilat.setKisiIslemsayi(kisiBean.getKisi().getIslemsayi()+1);
//        tahsilat.setKurum(kisiBean.getKisi().get);
//        tahsilat.setTahsilatDetayList(null);
//        tahsilat.setTutar(alinanPara);
//        tahsilat.setKisi(kisiBean.getKisi());
//        
//        tahsilatFacade.create(tahsilat);
//        
//        // TODO : Kisi İslem Sayısı Artırılacak
//        
//        // List<Tahsilat> tahsilatListesi=new ArrayList<Tahsilat>();
//        for (Borc fatura : seciliFaturaListesi) {
//            TahsilatDetay tahsilatDetay=new TahsilatDetay();
//            
//            tahsilatDetay.setAboneNo(fatura.getAboneNo());
//            tahsilatDetay.setFaturaNo(fatura.getFaturaNo());
//            tahsilatDetay.setFaturaSonOdemeTrh(fatura.getFaturaSonOdemeTrh());
//            tahsilatDetay.setTutar(fatura.get);
//            
//            
//            
//            tahsilatDetayFacade.create(tahsilatDetay);
//        }
//        return "tahsilatSonuc.xhtml?faces-redirect=true";
    }
    
    
    
    public TahsilatBean() {

    }
        
    public double getToplamPara() {
        return toplamPara;
    }

    public void setToplamPara(double toplamPara) {
        this.toplamPara = toplamPara;
    }

    public double getAlinanPara() {
        return alinanPara;
    }

    public void setAlinanPara(double alinanPara) {
        this.alinanPara = alinanPara;
    }

    public double getParaUstu() {
        return paraUstu;
    }

    public void setParaUstu(double paraUstu) {
        this.paraUstu = paraUstu;
    }  

    public Tahsilat getTahsilat() {
        return tahsilat;
    }

    public void setTahsilat(Tahsilat tahsilat) {
        this.tahsilat = tahsilat;
    }

    public Borc getBorc() {
        return borc;
    }

    public void setBorc(Borc borc) {
        this.borc = borc;
    }  

    public List<Borc> getKurumFaturaListesi() {
        return kurumFaturaListesi;
    }

    public void setKurumFaturaListesi(List<Borc> kurumFaturaListesi) {
        this.kurumFaturaListesi = kurumFaturaListesi;
    }

    public List<Borc> getSeciliFaturaListesi() {
        return seciliFaturaListesi;
    }

    public void setSeciliFaturaListesi(List<Borc> seciliFaturaListesi) {
        this.seciliFaturaListesi = seciliFaturaListesi;
    }
}
