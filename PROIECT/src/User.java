import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class User extends Consumer implements Observer{
    private ArrayList<String> companiesList;
    private Employee employee;
    private Notification notification;

    public User(ArrayList<String> companiesList, Employee employee) {
        this.companiesList = companiesList;
        this.employee = employee;
    }

    public User(ArrayList<Consumer> knownPeople, Resume resume, ArrayList<String> companiesList, Employee employee) {
        super(knownPeople, resume);
        this.companiesList = companiesList;
        this.employee = employee;
    }

    public ArrayList<String> getCompaniesList() {
        return companiesList;
    }

    public void setCompaniesList(ArrayList<String> companiesList) {
        this.companiesList = companiesList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee convert() {
        Employee employee1 = new Employee(this.knownPeople, this.resume);
        return employee1;
    }

    public Double getTotalScore() {
        Integer years = 0;
        for (Experience e : this.resume.expCollection
        ) {
            Integer year1 = e.getEndDate().getYear() - e.getBeginDate().getYear();
            if (year1 == 0)
                if (e.getEndDate().getMonth() - e.getBeginDate().getMonth() >= 3)
                    year1 = 1;
            years += year1;
        }
        Double grade = 0.0;
        for (Education e : this.resume.edCollection
             ){
            grade += e.getGrade();
        }
        grade = grade / this.resume.edCollection.size();

        return (years * 1.5 + grade);
    }

    @Override
    public void update(Notification notification) {
        this.notification = notification;
    }
}
