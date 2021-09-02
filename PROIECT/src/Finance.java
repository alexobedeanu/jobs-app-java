public class Finance extends Departement {
    @Override
    public double getTotalSalaryBudget() {
        Double s = 0.0;
        for (Employee e : this.getEmployees()
        ) {
            Integer years = 0;
            for (Experience ex : e.resume.expCollection
            ) {
                Integer year1 = ex.getEndDate().getYear() - ex.getBeginDate().getYear();
                if (year1 == 0)
                    if (ex.getEndDate().getMonth() - ex.getBeginDate().getMonth() >= 3)
                        year1 = 1;
                years += year1;

                if(years < 1)
                    s += 0.9 * e.getSalary();
                else
                    s += 0.84 * e.getSalary();
            }
        }
        return s;
    }
}
