//package com.example.hospitalappointmentbookingsystem.serivce;
//
//import com.example.hospitalappointmentbookingsystem.excption.InvalidIdException;
//import com.example.hospitalappointmentbookingsystem.model.Admin;
//import com.example.hospitalappointmentbookingsystem.model.Comment;
//import com.example.hospitalappointmentbookingsystem.model.Doctor;
//import com.example.hospitalappointmentbookingsystem.model.Patient;
//import com.example.hospitalappointmentbookingsystem.repostory.AdminRepository;
//import com.example.hospitalappointmentbookingsystem.repostory.CommentRepository;
//import com.example.hospitalappointmentbookingsystem.repostory.DoctorRepository;
//import com.example.hospitalappointmentbookingsystem.repostory.PatientRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class AdminDetailsService implements UserDetails {
//
//    private final AdminRepository adminRepository;
//    private final PatientRepository patientRepository;
//    private final DoctorRepository doctorRepository;
//    private final CommentRepository commentRepository;
//
//    public List<Admin> getAdmin(){
//
//        return adminRepository.findAll();
//    }
//    public void addAdmin(Admin admin){
//
//       adminRepository.save(admin);
//    }
//
//    public Admin updateAdmin(Integer id){
//       Admin newAdmin=adminRepository.findById(id).orElseThrow(()-> new InvalidIdException("ID invild"));
//
//        //newAdmin.setPassword(newAdmin.getPassword());
//        newAdmin.setUsername(newAdmin.getUsername());
//        return adminRepository.save(newAdmin);
//
//    }
//    public void deletePatientByAdmin(Integer patientId){
//
//        Patient newPatient=patientRepository.findById(patientId).
//                orElseThrow(()->
//                        new InvalidIdException("ID invild"));
//        patientRepository.delete(newPatient);
//
//    }
//    public void deleteDoctorByAdmin(Integer doctorId){
//        Doctor newDoctor=doctorRepository.findById(doctorId).
//                orElseThrow(()->
//                        new InvalidIdException("ID invild"));
//
//                        doctorRepository.delete(newDoctor);
//
//
//    }
//
//    public void deleteCommentByAdmin(Integer commentId){
//       Comment comment=commentRepository.findById(commentId).
//                orElseThrow(()->
//                        new InvalidIdException("ID invild"));
//
//        commentRepository.delete(comment);
//
//
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
