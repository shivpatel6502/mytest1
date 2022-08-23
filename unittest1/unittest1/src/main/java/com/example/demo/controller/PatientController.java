package com.example.demo.controller;

import com.example.demo.model.PatientRecord;
import com.example.demo.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin(origins="http://localhost:3000")
public class PatientController {
    @Autowired
    PatientRecordRepository patientRecordRepository;

    // Mappings - URL endpoints
    // Get the list of all PatientRecord
    @GetMapping("/listPatientRecords")
    public List<PatientRecord> getAllStudents() {
        return patientRecordRepository.findAll();
    }

    // Get the PatientRecord information
    @GetMapping("/patientRecord/{patientId}")
    public PatientRecord getPatientRecord(@PathVariable Integer patientId) {
        return patientRecordRepository.findById(patientId).get();
    }

    // Delete the patientRecord
    @DeleteMapping("/patientRecord/{patientId}")
    public List<PatientRecord> deletePatientRecord(@PathVariable Integer patientId) {
        patientRecordRepository.delete(patientRecordRepository.findById(patientId).get());
        return patientRecordRepository.findAll();
    }

    // Add new patientRecord
    @PostMapping("/patientRecord")
    public List<PatientRecord> addPatientRecord(@RequestBody PatientRecord patientRecord) {
        patientRecordRepository.save(patientRecord);
        return patientRecordRepository.findAll();
    }

    // Update the patientRecord information
    @PutMapping("/patientRecord/{patientId}")
    public List<PatientRecord> updatePatientRecord(@RequestBody PatientRecord patientRecord, @PathVariable Integer patientId) {
        PatientRecord patientRecord1 = patientRecordRepository.findById(patientId).get();
        patientRecord1.setName(patientRecord.getName());
        patientRecord1.setAddress(patientRecord.getAddress());
        patientRecordRepository.save(patientRecord1);
        return patientRecordRepository.findAll();
    }


}
