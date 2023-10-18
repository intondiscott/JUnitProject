import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
//TODO Appointment Service ✓
public class AppointmentServiceTest {
    String apptID, apptDate, apptDesc;
    AppointmentService as;

    @BeforeEach
    public void init(){
        apptID = "1";
        apptDate = "Oct 20 2023 11:45";
        apptDesc = "Doctor checkup";
        as = new AppointmentService();
        as.addAppointment(new Date(apptDate), apptDesc);
    }

    @Test
    @DisplayName("test adding appointments")
    public void testAddingAppointment(){
        as.addAppointment(new Date("Oct 23 2023 12:34"), "Go to the Doctor");
        as.addAppointment(new Date("Nov 12 2024 10:33"), "Check Flights");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           as.addAppointment(new Date(apptDate), "some long description here that will go over fifty characters...");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            as.addAppointment(new Date(""), "Some description");
        });

        as.listAllAppointments();
    }

    @Test
    @DisplayName("Test deleting Appointments")
    public void testDeletingAppointment(){
        as.addAppointment(new Date("Oct 23 2023 12:34"), "Go to the Doctor");
        as.addAppointment(new Date("Nov 12 2024 10:33"), "Check Flights");
        as.deleteAppointment(apptID);
        assertEquals("1",apptID);
        as.listAllAppointments();
    }
}