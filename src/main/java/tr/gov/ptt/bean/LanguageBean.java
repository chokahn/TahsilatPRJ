package tr.gov.ptt.bean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "languageBean")
@SessionScoped
public class LanguageBean implements Serializable {

    private String localeCode;

    private static Map<String, Locale> ulkeler;

    static {
        ulkeler = new LinkedHashMap<String, Locale>();
        ulkeler.put("Türkce", new Locale("tr", "TR"));
        ulkeler.put("English", Locale.ENGLISH);
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public Map<String, Locale> getUlkeler() {
        return ulkeler;
    }

    public void seciliDilDegistiginde() {
        FacesContext.getCurrentInstance()
                .getViewRoot().setLocale(new Locale(localeCode));
    }
}
