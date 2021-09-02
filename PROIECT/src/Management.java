public class Management extends Departement{

    @Override
    public double getTotalSalaryBudget() {
        Double s = 0.0;
        for (Job j: this.getJobs()
        ) {
            s += j.getSalary();
        }
        return (s - 0.16*s);
    }
}
