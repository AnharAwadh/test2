package com.example.hospitalappointmentbookingsystem.controller;

import com.example.hospitalappointmentbookingsystem.DTO.Api;
import com.example.hospitalappointmentbookingsystem.Utils;
import com.example.hospitalappointmentbookingsystem.model.Account;
import com.example.hospitalappointmentbookingsystem.model.Appointment;
import com.example.hospitalappointmentbookingsystem.model.Comment;
import com.example.hospitalappointmentbookingsystem.model.Patient;
import com.example.hospitalappointmentbookingsystem.serivce.AppointmentService;
import com.example.hospitalappointmentbookingsystem.serivce.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("api/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final PatientService patientService;


    @PostMapping("/addappointment/{did}")
    public ResponseEntity<Api> addAppointment(@PathVariable Integer did,@RequestBody @Valid Appointment appointment){
        Account account = Utils.getAccount(SecurityContextHolder.getContext());
        Patient patient = patientService.getPatientByEmail(account.getEmail());
       appointmentService.addAppointmentByPatient(patient.getId(),did,appointment);
        return ResponseEntity.status(201).body(new Api(" Appointment  added",201));

    }

    @GetMapping("/getappointment/{pid}")
    public ResponseEntity getAppointment(@PathVariable Integer pid){

        return ResponseEntity.status(201).body(appointmentService.getAppointmentByyPatientId(pid));
    }
    @DeleteMapping("/delappointment/{id}")
    public ResponseEntity deleteAppointmentByPatient(@PathVariable Integer id){

        appointmentService.deleteAppointmentByPatient(id);
        return ResponseEntity.status(200).body("The Appointment deleted");

    }
    @GetMapping("/getappointmentbydoctor/{did}")
    public ResponseEntity getAppointmentByDoctor(@PathVariable Integer did){


        return ResponseEntity.status(201).body(appointmentService.getAppointmentByyDoctorId(did));

    }

}
