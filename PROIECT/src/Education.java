import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Education implements Comparable {

    private Date beginDate;
    private Date endDate;
    private String institutionName;
    private EducationLevel educationLevel;
    private Double grade;

    public Education(Date beginDate, Date endDate, String institutionName, EducationLevel educationLevel, Double grade) throws InvalidDatesException, ParseException {
        if (endDate != null) {
            if (beginDate.after(endDate)) {
                throw new InvalidDatesException("Data de final e inainte de cea de inceput");
            }
        }
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.institutionName = institutionName;
        this.educationLevel = educationLevel;
        this.grade = grade;
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

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Object o) {
        Education e = (Education) o;

        if (this.endDate == null || e.getEndDate() == null) {
            return this.beginDate.compareTo(e.beginDate);
        }
        return this.endDate.compareTo(e.getEndDate()) == 0 ? (-1) * this.grade.compareTo(e.getGrade()) : (-1) * this.endDate.compareTo(e.getEndDate());
    }
}
