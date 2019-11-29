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

import com.Employee.DataEmployee.model.Karyawan;
import com.Employee.DataEmployee.repository.KaryawanRepository;

import Model_DTO.KaryawanDTO;

@RestController
@RequestMapping("/karyawan")
public class KaryawanController {
	
	@Autowired
	KaryawanRepository karyawanRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	//Get DTO
	@GetMapping("/get_karyawanDTO")
	public Map<String, Object> getAllKaryawanDTO() {
		List<Karyawan> listKaryawanEntity = karyawanRepository.findAll();
		
		List<KaryawanDTO> listKaryawanDTO = new ArrayList<KaryawanDTO>();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		for (Karyawan karyawanEntity : listKaryawanEntity) {
			KaryawanDTO karyawanDTO = new KaryawanDTO();		
		
			karyawanDTO = modelMapper.map(karyawanEntity, KaryawanDTO.class);
			
			listKaryawanDTO.add(karyawanDTO);
		}
		
		result.put("Status", 200);
    	result.put("message", "Read All Data Employee Success");
    	
    	result.put("Data", listKaryawanDTO);
    	
    	return result;
	}
	
	//Create 
    @PostMapping("/create_karyawanDTO")
    public Map<String, Object> createKaryawanDTO(@Valid @RequestBody KaryawanDTO karyawanDTO) {
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	
    	Karyawan karyawanEntity = new Karyawan();
    	
		karyawanEntity = modelMapper.map(karyawanDTO, Karyawan.class);
    	
		karyawanRepository.save(karyawanEntity);
		
    	result.put("Status", 200);
        result.put("message", "Create New Employee Data Success");
        result.put("Data", karyawanDTO);
        
		return result;
    	
    }
    
 // Get a Single 
    @GetMapping("/get_single_karyawanDTO/{id}")
    public Map<String, Object> getKaryawanDTOById(@PathVariable(value = "id") Long karyawanId){
		
    	Map<String, Object> result = new HashMap<String,Object>();
    	Karyawan karyawanEntity = karyawanRepository.findById(karyawanId).get();
    	KaryawanDTO karyawanDTO = new KaryawanDTO();
    	
		karyawanDTO = modelMapper.map(karyawanEntity, KaryawanDTO.class);
    	
    	result.put("Status", 200);
        result.put("message", "Read The Specific Employee Data Success");
        result.put("Data", karyawanDTO);

        return result;
    }
    
    // Update
    @PutMapping("/update_karyawanDTO/{id}")
    public Map<String, Object> updateKaryawanDTO(@PathVariable(value = "id") Long karyawanId,
            @Valid @RequestBody KaryawanDTO karyawanDTO) {
			
    	Map<String, Object> result = new HashMap<String,Object>();
    	Karyawan karyawanEntity = karyawanRepository.findById(karyawanId).get();
    	
		karyawanEntity = modelMapper.map(karyawanDTO, Karyawan.class);

        karyawanRepository.save(karyawanEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Update Employee Data Success");
        result.put("Data", karyawanDTO);
        
    	return result;
    }
    
    //Delete
    @DeleteMapping("/delete_karyawanDTO/{id}")
    public Map<String, Object> deleteKaryawanDTO(@PathVariable(value = "id") Long karyawanId,
            @Valid @RequestBody KaryawanDTO karyawanDTO) {
    	
    	Map<String, Object> result = new HashMap<String,Object>();
    	Karyawan karyawanEntity = karyawanRepository.findById(karyawanId).get();    	
    	karyawanRepository.delete(karyawanEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Delete Employee Data Success");
        result.put("Data", karyawanDTO);
        
    	return result;
    }
}