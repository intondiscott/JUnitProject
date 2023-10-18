


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
//TODO Appointment ✓
public class AppointmentTest {
    String apptID, apptDate, apptDesc, apptIDTooLong, apptDatePast, apptDescTooLong;
    Appointment appt;

    @BeforeEach
    public void init(){
        apptID = "1";
        apptDate = "Oct 20 2023 11:45";
        apptDesc = "Doctor checkup.";
        apptIDTooLong = "12345678910";
        apptDatePast = "Jan 1 2022 23:59";
        apptDescTooLong = "The appointment is for going to the doctors office and check for any reoccurring diseases.";
        appt = new Appointment();
    }

    @Test
    @DisplayName("Testing Appointment Class")
    public void testAppointment(){
        Appointment appointment = new Appointment(apptID, new Date(apptDate), apptDesc);
        assertEquals("1", appointment.getApptID());
        assertEquals(new Date("Oct 20 2023 11:45"), appointment.getApptDate());
        assertEquals("Doctor checkup.", appointment.getApptDesc());

    }

    @Test
    @DisplayName("Testing if appointment ID is too long")
    public void testAppointmentIDTooLong(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(apptIDTooLong, new Date(apptDate), apptDesc);
        });
    }

    @Test
    @DisplayName("Testing if date of appointment is past")
    public void testAppointmentDatePast(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(apptID, new Date(apptDatePast), apptDesc);
        });
    }

    @Test
    @DisplayName("Test if appointment description is too long")
    public void testAppointmentDescriptionTooLong(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(apptID, new Date(apptDate), apptDescTooLong);
        });
    }

    @Test
    @DisplayName("test setting appointment from the past")
    public void testSetAppointmentDatePast(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           appt.setApptDate(new Date(apptDatePast));
        });
    }

    @Test
    @DisplayName("Setting the appointment description too long")
    public void testSetAppointmentDescriptionTooLong(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appt.setApptDesc(apptDescTooLong);
        });
    }
}