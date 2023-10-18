import java.util.Date;

public class Appointment {
    private String apptID;
    private Date apptDate;
    private String apptDesc;

    public Date getApptDate() {
        return apptDate;
    }

    public String getApptID() {
        return apptID;
    }
    public void setApptDate(Date apptDate) {
        if(apptDate == null || apptDate.before(new Date())){
            throw new IllegalArgumentException("apptDate needs to be on or after current date and cannot be null...");
        }
        this.apptDate = apptDate;
    }

    public String getApptDesc() {
        return apptDesc;
    }

    public void setApptDesc(String apptDesc) {
        if(apptDesc == null || apptDesc.length() > 50){
            throw new IllegalArgumentException("apptDesc cannot be null or greater than 50 characters...");
        }
        this.apptDesc = apptDesc;
    }
    public Appointment(){}
    public Appointment(String apptID, Date apptDate, String apptDesc) {
        if(apptID == null || apptID.length() > 10){
            throw new IllegalArgumentException("apptID cannot be null or greater than 10 characters...");
        }
        if(apptDate == null || apptDate.before(new Date())){
            throw new IllegalArgumentException("apptDate needs to be on or after current date and cannot be null...");
        }
        if(apptDesc == null || apptDesc.length() > 50){
            throw new IllegalArgumentException("apptDesc cannot be null or greater than 50 characters...");
        }
        this.apptID = apptID;
        this.apptDate = apptDate;
        this.apptDesc = apptDesc;
    }
}
