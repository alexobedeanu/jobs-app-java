import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Experience implements Comparable {
    private Date beginDate;
    private Date endDate;
    private String position;
    private String company;

    public Experience(Date beginDate, Date endDate, String position, String company) throws InvalidDatesException {

        if (endDate != null) {
            if (beginDate.after(endDate)) {
                throw new InvalidDatesException("Data de final e inainte de cea de inceput");
            }
            Date now = new Date();
            if (beginDate.after(now) || endDate.after(now)) {
                throw new InvalidDatesException("Data inexistenta");
            }
        }
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.position = position;
        this.company = company;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public int compareTo(Object o) {
        Experience e = (Experience) o;

        if (this.endDate == null || e.getEndDate() == null) {
            return this.company.compareTo(e.company);
        }
        return (-1) * this.endDate.compareTo(e.getEndDate());
    }
}
