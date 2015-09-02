package tr.gov.ptt.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;



public class JSFUtil 
{
    public static String GetKullanici()
    {
        return getSession().getAttribute("kullanici").toString();
    }
    
    public static void mesajGoster(String p_mesaj, String p_detail, FacesMessage.Severity severty)
    {
        FacesContext.getCurrentInstance().addMessage("null",new FacesMessage(severty,p_mesaj,p_detail));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
    
    public static HttpSession getSession()
    { 
        HttpSession httpSession =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        System.out.println(httpSession.getId()+" nolu oturum bilgileri alınıyor.");
        return httpSession;
    }
    
    public static void closeSession(HttpSession p_session)
    {
        System.out.println(p_session.getId()+" nolu oturum kapatılıyor.");
        p_session.invalidate();
    }
}
