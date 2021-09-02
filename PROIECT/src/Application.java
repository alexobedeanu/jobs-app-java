import java.util.ArrayList;
import java.util.List;

public class Application {
    private ArrayList<Company> companies;
    private ArrayList<User> users;
    public static Application obj = null;
    private Application(ArrayList<Company> companies, ArrayList<User> users) {
        this.companies = companies;
        this.users = users;
    }
    public static Application getInstance(ArrayList<Company> companies, ArrayList<User> users) {
        if (obj == null)
            obj = new Application(companies, users);
        return obj;
    }
    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(ArrayList<Company> companies) {
        this.companies = companies;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public Company getCompany(String name) {
        for (Company c : companies
             ) {
            if(c.getName().equals(name))
                return c;
        }
        return null;
    }

    public void add(Company company) {
        if(!companies.contains(company))
            companies.add(company);
    }

    public void add(User user) {
        if(!users.contains(user))
            users.add(user);
    }

    public boolean remove(Company company) {
        return companies.remove(company);
    }

    public boolean remove(User user) {
        return users.remove(user);
    }

    public ArrayList<Job> getJobs(List<String> companies) {
        ArrayList<Job> jobs = new ArrayList<>();
        for (String c : companies
             ) {
            Company company = getCompany(c);
            for (Departement d : company.getDepartements()
                 ) {
                jobs.addAll(d.getJobs());
            }
        }
        return jobs;
    }
}
