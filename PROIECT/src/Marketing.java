public class Marketing extends Departement {

    @Override
    public double getTotalSalaryBudget() {
        Double s = 0.0;
        for (Job j : this.getJobs()
        ) {
            if (j.getSalary() > 5000)
                s += j.getSalary() - 0.10 * j.getSalary();
            else if (j.getSalary() < 3000)
                s += j.getSalary();
            else
                s += j.getSalary() - 0.16 * j.getSalary();
        }
        return s;
    }
}
