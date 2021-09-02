import java.util.ArrayList;
import java.util.List;

public class Company implements Subject {
    private String name;
    private Manager manager;
    private ArrayList<Departement> departements;
    private ArrayList<Recruiter> recruiters;
    private List<User> observers;
    private Notification notification;

    public Company(String name, Manager manager, ArrayList<Departement> departements, ArrayList<Recruiter> recruiters) {
        this.name = name;
        this.manager = manager;
        this.departements = departements;
        this.recruiters = recruiters;
        this.observers = new ArrayList<>();
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Departement> getDepartements() {
        return departements;
    }

    public void setDepartements(ArrayList<Departement> departements) {
        this.departements = departements;
    }

    public ArrayList<Recruiter> getRecruiters() {
        return recruiters;
    }

    public void setRecruiters(ArrayList<Recruiter> recruiters) {
        this.recruiters = recruiters;
    }

    public void add(Departement departement) {
        if (!departements.contains(departement))
            departements.add(departement);
    }

    public void add(Recruiter recruiter) {
        if (!recruiters.contains(recruiter))
            recruiters.add(recruiter);
    }

    public void addJob(Job job, Departement departement) {
        this.notification = new Notification("New job");
        departement.add(job);
        notifyAllObservers();
    }

    public void removeJobs(Job job, Departement departement) {
        this.notification = new Notification("The job is not longer available!");
        departement.remove(job);
        notifyAllObservers();
    }

    public void add(Employee employee, Departement departement) {
        departement.add(employee);
    }

    public void remove(Employee employee) {
        for (Departement d : departements
        ) {
            d.remove(employee);
        }
    }

    public void remove(Departement departement) {
        if (!departements.contains(departement))
            departements.remove(departement);
    }

    public void remove(Recruiter recruiter) {
        if (!recruiters.contains(recruiter))
            recruiters.remove(recruiter);
    }

    public void move(Departement source, Departement destination) {
        for (Job j : source.getJobs()
        ) {
            destination.add(j);
        }
        for (Employee e : source.getEmployees()
        ) {
            destination.add(e);
            source.remove(e);
        }
    }

    public void move(Employee employee, Departement newDepartement) {
        newDepartement.add(employee);
    }

    public boolean contains(Departement departement) {
        return departements.contains(departement);
    }

    public boolean contains(Employee employee) {
        for (Departement d : departements
        ) {
            if (d.getEmployees().contains(employee))
                return true;
        }
        return false;
    }

    public boolean contains(Recruiter recruiter) {
        return recruiters.contains(recruiter);
    }

    public Recruiter getRecruiter(User user) {
        Double maxim = Double.MIN_VALUE;
        Recruiter newRecruiter = recruiters.get(0);
        for (Recruiter r : recruiters) {
            if (user.getDegreeInFriendship(r) > maxim) {
                maxim = Double.valueOf(user.getDegreeInFriendship(r));
                newRecruiter = r;
            }
        }
        return newRecruiter;
    }//metoda care intoarce o lista de recruiters sortata crescator

    public ArrayList<Job> getJobs() {
        ArrayList<Job> allJobs = new ArrayList<Job>();
        for (Departement d : departements
        ) {
            for (Job j : d.getJobs()
            ) {
                if (j.isFlag())
                    allJobs.add(j);
            }
        }
        return allJobs;
    }

    @Override
    public void addObserver(User user) {
        this.observers.add(user);
    }

    @Override
    public void removeObserver(User c) {
        for (Departement d : departements) {
            if (d.getEmployees().contains(c.getEmployee())) {
                observers.remove(c);
            }
        }
    }

    @Override
    public void notifyAllObservers() {
        for (User u : observers) {
            u.update(notification);
        }
    }
}
