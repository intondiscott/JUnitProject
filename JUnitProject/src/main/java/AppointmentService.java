import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class AppointmentService {
    public ArrayList<Appointment> listOfAppts = new ArrayList<>();
    public String generateTaskID(){
        int i = 0;
        for(int j=i; j < listOfAppts.size(); j++){
            i++;
        }
        return String.valueOf(++i);
    }
    public void addAppointment(Date apptDate, String apptDesc){
        Appointment appt = new Appointment(generateTaskID(), apptDate, apptDesc);
        listOfAppts.add(appt);
        System.out.printf("Appointment with apptID: %s has been added to list\n%s\n", appt.getApptID(), "-".repeat(100));
    }
    public void deleteAppointment(String apptID){
        for (Appointment appt: listOfAppts) {
            if(Objects.equals(apptID, appt.getApptID())){
                listOfAppts.remove(appt);
                System.out.printf("Appointment with apptID: %s has been deleted...\n%s\n", apptID, "-".repeat(100));
                break;
            }
        }
        if(listOfAppts.size() < Integer.parseInt(apptID)){
            throw new IllegalArgumentException("Appointment with apptID: " + apptID + " cannot be found...");
        }
    }

    public void listAllAppointments(){
        for(Appointment appt: listOfAppts){
            System.out.println("{ " +
                    "\n\tID: " + appt.getApptID() +
                    ", \n\tDate: " + appt.getApptDate()+
                    ", \n\tAppointment Description: " + appt.getApptDesc() +
                    "\n}" + ((listOfAppts.indexOf(appt) < listOfAppts.size()-1)?",":""));
        }
    }
}
