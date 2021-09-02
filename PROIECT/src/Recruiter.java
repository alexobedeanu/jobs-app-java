import java.util.ArrayList;

public class Recruiter extends Employee {
    private Double rating;


    public Recruiter(ArrayList<Consumer> knownPeople, Resume resume) {
        super(knownPeople, resume);
        rating = 5.0;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int evaluate(Job job, User user) {
        rating += 0.1;
        Request<Job, Consumer> request = new Request<Job, Consumer>(job, user, this, user.getTotalScore());
        job.getCompany().getManager().addRequest(request);
        return (int) (rating * user.getTotalScore());
    }

}
