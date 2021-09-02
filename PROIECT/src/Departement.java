import java.util.ArrayList;

public abstract class Departement {
    private ArrayList<Employee> employees;
    private ArrayList<Job> jobs;

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    public abstract double getTotalSalaryBudget();

    public void add(Employee employee) {
        if(!employees.contains(employee))
            employees.add(employee);
    }

    public void remove(Employee employee) {
        if(employees.contains(employee))
            employees.remove(employee);
    }

    public void add(Job job) {
        if(!jobs.contains(job))
            jobs.add(job);
    }

    public  void remove(Job job) {
        if(jobs.contains(job))
            jobs.remove(job);
    }

}
