import java.util.ArrayList;

public class Job {
    private String name;
    private Company company;
    private boolean flag;
    private Constraint graduationYear;
    private Constraint yearsExp;
    private Constraint grade;
    private ArrayList<User> candidates;
    private Integer numberOfEmployees;
    private Double salary;

    public Job(String name, Company company, boolean flag, Constraint graduationYear, Constraint yearsExp, Constraint grade, ArrayList<User> candidates, Integer numberOfEmployees, Double salary) {
        this.name = name;
        this.company = company;
        this.flag = flag;
        this.graduationYear = graduationYear;
        this.yearsExp = yearsExp;
        this.grade = grade;
        this.candidates = candidates;
        this.numberOfEmployees = numberOfEmployees;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Constraint getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Constraint graduationYear) {
        this.graduationYear = graduationYear;
    }

    public Constraint getYearsExp() {
        return yearsExp;
    }

    public void setYearsExp(Constraint yearsExp) {
        this.yearsExp = yearsExp;
    }

    public Constraint getGrade() {
        return grade;
    }

    public void setGrade(Constraint grade) {
        this.grade = grade;
    }

    public ArrayList<User> getCandidates() {
        return candidates;
    }

    public void setCandidates(ArrayList<User> candidates) {
        this.candidates = candidates;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void apply(User user) {
        Integer max = Integer.MIN_VALUE;
        Recruiter bestFriend = this.company.getRecruiters().get(0);
        for (Recruiter r : this.company.getRecruiters()) {
            if (r.getDegreeInFriendship(user) > max) {
                max = r.getDegreeInFriendship(user);
                bestFriend = r;
            } else if (r.getDegreeInFriendship(user) == max)
                if (r.getRating() > bestFriend.getRating())
                    bestFriend = r;
        }
        bestFriend.evaluate(this, user);
    }

    public boolean meetsRequirments(User user) {
        Integer experience = 0;
        for (Experience e : user.resume.expCollection
        ) {
            if ((e.getEndDate().getYear() - e.getBeginDate().getYear()) == 0) {
                if ((e.getEndDate().getMonth() - e.getBeginDate().getMonth()) > 3)
                    experience += 1;
            } else
                experience += (e.getEndDate().getYear() - e.getBeginDate().getYear());
        }
        if (user.resume.edCollection.get(0).getEndDate().getYear() < this.getGraduationYear().getUpperLimit() &&
                user.resume.edCollection.get(0).getEndDate().getYear() > this.getGraduationYear().getLowerLimit() &&
                experience > this.getYearsExp().getLowerLimit() && experience < this.getYearsExp().getUpperLimit()
                && user.resume.edCollection.get(0).getGrade() < this.getGrade().getUpperLimit() &&
                user.resume.edCollection.get(0).getGrade() > this.getGrade().getLowerLimit())
            return true;
        return false;

    }

}
