public class Language {
    private String name;
    private languageLevel languageLevel;

    public Language(String name, languageLevel languageLevel) {
        this.name = name;
        this.languageLevel = languageLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public languageLevel getLanguageLevel() {
        return languageLevel;
    }

    public void setLanguageLevel(languageLevel languageLevel) {
        this.languageLevel = languageLevel;
    }
}
