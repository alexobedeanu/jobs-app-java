import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;

public class Information {

    private String name;
    private String firstName;
    private String mail;
    private String phone;
    private Date birthDate;
    private String gender;
    private ArrayList<Language> languages;

    public Information() {
    }

    public Information(String name, String firstName, String mail, String phone, Date birthDate, String gender, ArrayList<Language> languages) {
        this.name = name;
        this.firstName = firstName;
        this.mail = mail;
        this.phone = phone;
        this.birthDate = birthDate;
        this.gender = gender;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }

    public void addLanguage(String language, languageLevel languageLevel) {
        Language newLanguage = new Language(language, languageLevel);
        this.languages.add(newLanguage);
    }

}
