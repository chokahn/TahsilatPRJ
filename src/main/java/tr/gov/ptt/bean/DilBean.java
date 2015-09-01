package tr.gov.ptt.bean;

import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class DilBean implements Serializable
{
    public void dilDegistir(String p_dil)
    {
        locale = new Locale(p_dil);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
    
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
}
