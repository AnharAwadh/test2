package com.example.hospitalappointmentbookingsystem.serivce;

import com.example.hospitalappointmentbookingsystem.excption.InvalidIdException;
import com.example.hospitalappointmentbookingsystem.model.Appointment;
import com.example.hospitalappointmentbookingsystem.model.Comment;
import com.example.hospitalappointmentbookingsystem.model.Doctor;
import com.example.hospitalappointmentbookingsystem.model.Patient;
import com.example.hospitalappointmentbookingsystem.repostory.AppointmentRepository;
import com.example.hospitalappointmentbookingsystem.repostory.DoctorRepository;
import com.example.hospitalappointmentbookingsystem.repostory.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;

    private final DoctorService doctorService;
    public List<Appointment> getAppointmentByyPatientId(Integer patientId){
        return appointmentRepository.findAppointmentsByPatientId(patientId);
    }

    public List<Appointment> getAppointmentByyDoctorId(Integer doctorId){
        return appointmentRepository.findAppointmentsByDoctorId(doctorId);
    }
    public void deleteAppointmentByPatient(Integer appointmentId){
       Appointment appointment=appointmentRepository.findById(appointmentId).
                orElseThrow(()->
                        new InvalidIdException("ID invild"));

        appointmentRepository.delete(appointment);


    }
    public void addAppointmentByPatient(Integer patientId, Integer doctorId, Appointment appointment){
        Doctor newDoctor=doctorService.getDoctorById(doctorId);
        Patient newPatient=patientService.getPatientById(patientId);
       appointment.setPatient(newPatient);
        appointment.setDoctor(newDoctor);;
        appointmentRepository.save(appointment);

    }

}
