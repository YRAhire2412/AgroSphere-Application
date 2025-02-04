package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Appointment;
import com.app.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from React frontend

public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping("/list")	
	public ResponseEntity<?> getAllAppointments(){
		List<Appointment> appointments = appointmentService.getAppointments();
		if(appointments.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(appointments);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addAppointment(@RequestBody Appointment appointment){
       
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.addAppointment(appointment));
    }
	
	@DeleteMapping("/{appointmentId}")
	public ResponseEntity<?> deleteAppointment(@PathVariable Long appointmentId){
		try {
			return ResponseEntity.ok(appointmentService.deleteAppointment(appointmentId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
    }
}

