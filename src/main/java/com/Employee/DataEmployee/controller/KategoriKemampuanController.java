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

import com.Employee.DataEmployee.model.KategoriKemampuan;
import com.Employee.DataEmployee.repository.KategoriKemampuanRepository;

import Model_DTO.KategoriKemampuanDTO;

@RestController
@RequestMapping("/kategoriKemampuan")
public class KategoriKemampuanController {
	
	@Autowired
	KategoriKemampuanRepository kategoriKemampuanRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	//Get DTO
	@GetMapping("/get_kategoriKemampuanDTO")
	public Map<String, Object> getAllKategoriKemampuanDTO() {
		List<KategoriKemampuan> listKategoriKemampuanEntity = kategoriKemampuanRepository.findAll();
		
		List<KategoriKemampuanDTO> listKategoriKemampuanDTO = new ArrayList<KategoriKemampuanDTO>();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		for (KategoriKemampuan kategoriKemampuanEntity : listKategoriKemampuanEntity) {
			KategoriKemampuanDTO kategoriKemampuanDTO = new KategoriKemampuanDTO();		
		
			kategoriKemampuanDTO = modelMapper.map(kategoriKemampuanEntity, KategoriKemampuanDTO.class);
			
			listKategoriKemampuanDTO.add(kategoriKemampuanDTO);
		}
		
		result.put("Status", 200);
    	result.put("message", "Read All Data Category Skill Success");
    	
    	result.put("Data", listKategoriKemampuanDTO);
    	
    	return result;
	}
	
	//Create 
    @PostMapping("/create_kategoriKemampuanDTO")
    public Map<String, Object> createKategoriKemampuanDTO(@Valid @RequestBody KategoriKemampuanDTO kategoriKemampuanDTO) {
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	
    	KategoriKemampuan kategoriKemampuanEntity = new KategoriKemampuan();
    	
		kategoriKemampuanEntity = modelMapper.map(kategoriKemampuanDTO, KategoriKemampuan.class);
    	
		kategoriKemampuanRepository.save(kategoriKemampuanEntity);
		
    	result.put("Status", 200);
        result.put("message", "Create New Category Skill Data Success");
        result.put("Data", kategoriKemampuanDTO);
        
		return result;
    	
    }
    
 // Get a Single 
    @GetMapping("/get_single_kategoriKemampuanDTO/{id}")
    public Map<String, Object> getKategoriKemampuanDTOById(@PathVariable(value = "id") Long kategoriKemampuanId){
		
    	Map<String, Object> result = new HashMap<String,Object>();
    	KategoriKemampuan kategoriKemampuanEntity = kategoriKemampuanRepository.findById(kategoriKemampuanId).get();
    	KategoriKemampuanDTO kategoriKemampuanDTO = new KategoriKemampuanDTO();
    	
		kategoriKemampuanDTO = modelMapper.map(kategoriKemampuanEntity, KategoriKemampuanDTO.class);
    	
    	result.put("Status", 200);
        result.put("message", "Read The Specific Category Skill Data Success");
        result.put("Data", kategoriKemampuanDTO);

        return result;
    }
    
    // Update
    @PutMapping("/update_kategoriKemampuanDTO/{id}")
    public Map<String, Object> updateKategoriKemampuanDTO(@PathVariable(value = "id") Long kategoriKemampuanId,
            @Valid @RequestBody KategoriKemampuanDTO kategoriKemampuanDTO) {
			
    	Map<String, Object> result = new HashMap<String,Object>();
    	KategoriKemampuan kategoriKemampuanEntity = kategoriKemampuanRepository.findById(kategoriKemampuanId).get();
    	
		kategoriKemampuanEntity = modelMapper.map(kategoriKemampuanDTO, KategoriKemampuan.class);
		
		kategoriKemampuanEntity.setIdKategori(kategoriKemampuanId);

        kategoriKemampuanRepository.save(kategoriKemampuanEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Update Category Skill Data Success");
        result.put("Data", kategoriKemampuanDTO);
        
    	return result;
    }
    
    //Delete
    @DeleteMapping("/delete_kategoriKemampuanDTO/{id}")
    public Map<String, Object> deleteKategoriKemampuanDTO(@PathVariable(value = "id") Long kategoriKemampuanId,
            @Valid @RequestBody KategoriKemampuanDTO kategoriKemampuanDTO) {
    	
    	Map<String, Object> result = new HashMap<String,Object>();
    	KategoriKemampuan kategoriKemampuanEntity = kategoriKemampuanRepository.findById(kategoriKemampuanId).get();    	
    	kategoriKemampuanRepository.delete(kategoriKemampuanEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Delete Data Category Skill Success");
        result.put("Data", kategoriKemampuanDTO);
        
    	return result;
    }
}
