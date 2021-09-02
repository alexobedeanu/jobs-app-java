import java.util.ArrayList;

public class Employee extends Consumer {
    private String companyName;
    private Double salary;


    public Employee(ArrayList<Consumer> knownPeople, Resume resume) {
        super(knownPeople, resume);
        this.companyName = "";
        this.salary = 0.0;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
