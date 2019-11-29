package com.Employee.DataEmployee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.DataEmployee.model.Pendapatan;
import com.Employee.DataEmployee.repository.PendapatanRepository;

import Model_DTO.PendapatanDTO;

@RestController
@RequestMapping("/pendapatan")
public class PendapatanController {
	
	@Autowired
	PendapatanRepository pendapatanRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	//Get DTO
	@GetMapping("/get_pendapatanDTO")
	public Map<String, Object> getAllPendapatanDTO() {
		List<Pendapatan> listPendapatanEntity = pendapatanRepository.findAll();
		
		List<PendapatanDTO> listPendapatanDTO = new ArrayList<PendapatanDTO>();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		for (Pendapatan pendapatanEntity : listPendapatanEntity) {
			PendapatanDTO pendapatanDTO = new PendapatanDTO();		
		
			pendapatanDTO = modelMapper.map(pendapatanEntity, PendapatanDTO.class);
			
			listPendapatanDTO.add(pendapatanDTO);
		}
		
		result.put("Status", 200);
    	result.put("message", "Read All Data Income Success");
    	result.put("Data", listPendapatanDTO);
    	
    	return result;
	}
	
	//Create 
    @PostMapping("/create_pendapatanDTO")
    public Map<String, Object> createPendapatanDTO(@Valid @RequestBody PendapatanDTO pendapatanDTO) {
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	
    	Pendapatan pendapatanEntity = new Pendapatan();
    	
		pendapatanEntity = modelMapper.map(pendapatanDTO, Pendapatan.class);
    	
		pendapatanRepository.save(pendapatanEntity);
		
    	result.put("Status", 200);
        result.put("message", "Create New Income Data Success");
        result.put("Data", pendapatanDTO);
        
		return result;
    	
    }
    
 // Get a Single 
    @GetMapping("/get_single_pendapatanDTO/{id}")
    public Map<String, Object> getPendapatanDTOById(@PathVariable(value = "id") Long pendapatanId){
		
    	Map<String, Object> result = new HashMap<String,Object>();
    	Pendapatan pendapatanEntity = pendapatanRepository.findById(pendapatanId).get();
    	PendapatanDTO pendapatanDTO = new PendapatanDTO();
    	
		pendapatanDTO = modelMapper.map(pendapatanEntity, PendapatanDTO.class);
    	
    	result.put("Status", 200);
        result.put("message", "Read The Specific Income Data Success");
        result.put("Data", pendapatanDTO);

        return result;
    }
    
    // Update
    @PutMapping("/update_pendapatanDTO/{id}")
    public Map<String, Object> updatePendapatanDTO(@PathVariable(value = "id") Long pendapatanId,
            @Valid @RequestBody PendapatanDTO pendapatanDTO) {
			
    	Map<String, Object> result = new HashMap<String,Object>();
    	Pendapatan pendapatanEntity = pendapatanRepository.findById(pendapatanId).get();
    	
		pendapatanEntity = modelMapper.map(pendapatanDTO, Pendapatan.class);
		pendapatanEntity.setIdPendapatan(pendapatanId);

        pendapatanRepository.save(pendapatanEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Update Income Data Success");
        result.put("Data", pendapatanDTO);
        
    	return result;
    }
    
    //Delete
    @DeleteMapping("/delete_pendapatanDTO/{id}")
    public Map<String, Object> deletePendapatanDTO(@PathVariable(value = "id") Long pendapatanId,
            @Valid @RequestBody PendapatanDTO pendapatanDTO) {
    	
    	Map<String, Object> result = new HashMap<String,Object>();
    	Pendapatan pendapatanEntity = pendapatanRepository.findById(pendapatanId).get();    	
    	pendapatanRepository.delete(pendapatanEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Delete Data Income Success");
        result.put("Data", pendapatanDTO);
        
    	return result;
    }
}
