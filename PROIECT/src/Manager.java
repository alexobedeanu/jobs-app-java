import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Manager extends Employee {
    private ArrayList<Request> requests;

    public Manager(ArrayList<Consumer> knownPeople, Resume resume, ArrayList<Request> requests) {
        super(knownPeople, resume);
        this.requests = requests;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<Request> requests) {
        this.requests = requests;
    }

    public void addRequest(Request request) {
        if (!requests.contains(request))
            requests.add((request));
    }

    public void process(Job job) {
        ArrayList<Request> requests1 = new ArrayList<>();
        for (Request r : requests
        ) {
            if (r.getKey().equals(job))
                requests1.add(r);
        }
        Collections.sort(requests1, new Comparator<Request>() {
            @Override
            public int compare(Request o1, Request o2) {
                return Double.compare(o1.getScore(), o2.getScore());
            }
        });//sortez crescator lista
        for (int i = 0; i < job.getNumberOfEmployees(); i++) {
            User user = (User) requests1.get(i).getValue1();//value1 intoarce utilizatorul
            if (user.getEmployee().getCompanyName().equals("")) {
                Resume resume = user.resume;
                Employee employee = new Employee(new ArrayList<>(), resume);
                for (Departement d : job.getCompany().getDepartements()) {
                    for (Job j : d.getJobs()
                    ) {
                        if (j.equals(job)) {
                            d.add(employee);
                            job.getCompany().removeObserver(user);
                        }
                    }
                }
            }
        }
        job.getCompany().setNotification(new Notification("You have not been accepted"));
        job.getCompany().notifyAllObservers();
    }
}
