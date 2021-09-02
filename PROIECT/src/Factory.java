public class Factory {
    public static Departement getDepartement(String type) {
        switch(type) {
            case "IT": {
                return new IT();
            }
            case "Management": {
                return new Management();
            }
            case "Marketing": {
                return new Marketing();
            }
            case "Finance": {
                return new Finance();
            }
            default:
                return null;
        }
    }
}
