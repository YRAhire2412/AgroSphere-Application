package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppointmentDto;
import com.app.entities.Appointment;
import com.app.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "http://localhost:3000")

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
	
	
	@DeleteMapping("/delete/{appointmentId}")
	public ResponseEntity<?> deleteAppointment(@PathVariable Long appointmentId){
		try {
			return ResponseEntity.ok(appointmentService.deleteAppointment(appointmentId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
    }
	
//	@PutMapping("/{id}/confirm")
//    public ResponseEntity<Appointment> confirmAppointment(@PathVariable Long id) {
//        Appointment updatedAppointment = appointmentService.confirmAppointment(id);
//        if (updatedAppointment == null) {
//            return ResponseEntity.notFound().build(); // If appointment not found
//        }
//        return ResponseEntity.ok(updatedAppointment); // Return the confirmed appointment
//    }
//
//    //cancel an appointment
//    @PutMapping("/{id}/cancel")
//    public ResponseEntity<Appointment> cancelAppointment(@PathVariable Long id) {
//        Appointment updatedAppointment = appointmentService.cancelAppointment(id);
//        if (updatedAppointment == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(updatedAppointment);
//    }
//	@PreAuthorize("hasRole('ADMIN')")
	@PatchMapping("/update/{id}")
	public ResponseEntity<Appointment> updateAppointmentStatus(@PathVariable Long id, @RequestBody AppointmentDto statusUpdateRequest) {
	    Appointment updatedAppointment = appointmentService.updateAppointmentStatus(id, statusUpdateRequest.getStatus());

	    if (updatedAppointment == null) {
	        return ResponseEntity.notFound().build(); // If appointment not found or invalid status
	    }

	    return ResponseEntity.ok(updatedAppointment); // Return the updated appointment
	}
	
//	@PreAuthorize("hasRole('FARMER')")
	@GetMapping("/farmer/{id}")
	public ResponseEntity<List<Appointment>> getAppointmentsForFarmer(@PathVariable Long id) {
	    List<Appointment> appointments = appointmentService.getAppointmentsForFarmer(id);
	    if (appointments.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
	    return ResponseEntity.ok(appointments);
	}

	@GetMapping("/appointments")
	 public List<Appointment> getAppointmentsByMarketAndProduct(
	   @RequestParam Long marketId,
	     @RequestParam Long productId
	 ) {
	     return appointmentService.findByMarketIdAndProductId(marketId, productId);
	 }
}

