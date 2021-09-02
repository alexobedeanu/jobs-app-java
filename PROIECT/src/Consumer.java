import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

abstract class Consumer {
    ArrayList<Consumer> knownPeople = new ArrayList<Consumer>();
    Resume resume;

    class Resume {
        Information info = new Information();
        ArrayList<Education> edCollection = new ArrayList<Education>();
        ArrayList<Experience> expCollection = new ArrayList<Experience>();

        public Resume() {
        }

        public Resume(Information info, ArrayList<Education> edCollection, ArrayList<Experience> expCollection) {
            this.info = info;
            this.edCollection = edCollection;
            this.expCollection = expCollection;
        }

        public Information getInfo() {
            return info;
        }

        public void setInfo(Information info) {
            this.info = info;
        }

        public ArrayList<Education> getEdCollection() {
            return edCollection;
        }

        public void setEdCollection(ArrayList<Education> edCollection) {
            this.edCollection = edCollection;
        }

        public ArrayList<Experience> getExpCollection() {
            return expCollection;
        }

        public void setExpCollection(ArrayList<Experience> expCollection) {
            this.expCollection = expCollection;
        }
        public class Builder {
           private Information info = new Information();
           private ArrayList<Education> edCollection = new ArrayList<>();
           private ArrayList<Experience> expCollection = new ArrayList<>();

           public Builder setInformation(Information info) {
               this.info = info;
               return this;
           }

           public Builder setEdCollection(ArrayList<Education> edCollection) {
               this.edCollection = edCollection;
               return this;
           }

           public Builder setExpCollection(ArrayList<Experience> expCollection) {
               this.expCollection = expCollection;
               return this;
           }

           public Resume build() {
               return new Resume(info, edCollection, expCollection);
           }
        }
    }
    public Consumer() {

    }
    public Consumer(ArrayList<Consumer> knownPeople, Resume resume) {
        this.knownPeople = knownPeople;
        this.resume = resume;
    }

    public void add(Education education) {
        if (!resume.edCollection.contains(education))
            resume.edCollection.add(education);
        Collections.sort(resume.edCollection);
    }

    public void add(Experience experience) {
        if (!resume.expCollection.contains(experience))
            resume.expCollection.add(experience);
        Collections.sort(resume.expCollection);
    }

    public void add(Consumer consumer) {
        if (!knownPeople.contains(consumer))
            knownPeople.add(consumer);
    }

    public int getDegreeInFriendship(Consumer consumer) {
        Integer degree = 0;

        for (Consumer c: knownPeople
             ) {
            if(c.equals(consumer))
                degree++;
        }
        for (Education e : this.resume.edCollection
             ) {
            for (Education e2 : consumer.resume.edCollection
                 ) {
                if(e.getInstitutionName().equals(e2.getInstitutionName()))
                    degree++;
            }
        }
        for (Experience e : this.resume.expCollection) {
            for (Experience e2 : consumer.resume.expCollection
                 ) {
                if(e.getCompany().equals(e2.getCompany()))
                    degree++;
            }
        }
        return degree;
    }
    public void remove(Consumer consumer) {
        if (knownPeople.contains(consumer))
            knownPeople.remove(consumer);
    }

    public Integer getGraduationYear() {

        for (Education aux : resume.edCollection) {
            if (aux.getEducationLevel().equals("BACHELOR")) {
                return aux.getEndDate().getYear() + 1900;
            }
        }
        return null;
    }

    public Double meanGPA() {
        Integer counter = 0;
        Double sum = 0.0;
        for (Education aux : resume.edCollection) {
            if (aux.getEndDate() != null) {
                sum += aux.getGrade();
                counter++;
            }
        }
        return sum / counter;
    }
}
