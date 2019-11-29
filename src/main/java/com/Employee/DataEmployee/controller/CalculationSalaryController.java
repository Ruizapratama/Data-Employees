package com.Employee.DataEmployee.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.BigDecimalType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.DataEmployee.model.Karyawan;
import com.Employee.DataEmployee.model.Parameter;
import com.Employee.DataEmployee.model.Pendapatan;
import com.Employee.DataEmployee.model.Penempatan;
import com.Employee.DataEmployee.model.PresentaseGaji;
import com.Employee.DataEmployee.model.TunjanganPegawai;

import com.Employee.DataEmployee.repository.KaryawanRepository;
import com.Employee.DataEmployee.repository.ParameterRepository;
import com.Employee.DataEmployee.repository.PendapatanRepository;
import com.Employee.DataEmployee.repository.PenempatanRepository;
import com.Employee.DataEmployee.repository.PresentaseGajiRepository;
import com.Employee.DataEmployee.repository.TunjanganPegawaiRepository;

import Model_DTO.PendapatanDTO;

@RestController
@RequestMapping("/calculationPendapatan")
public class CalculationSalaryController {
	
	@Autowired
    PendapatanRepository pendapatanRepository;
	@Autowired
	KaryawanRepository karyawanRepository;
	@Autowired
	PresentaseGajiRepository presentaseGajiRepository;
	@Autowired
	PenempatanRepository penempatanRepository;
	@Autowired
	ParameterRepository parameterRepository;
	@Autowired
	TunjanganPegawaiRepository tunjanganPegawaiRepository;
	
	//Perhitungan Pendapatan
	@PostMapping("/calculation/{tanggal}")
    public Map<String, Object> calculationPendapatan(@PathVariable("date") String inputDate){
		
		Map<String, Object> result = new HashMap<String,Object>();
		List<Pendapatan> listPendapatan = pendapatanRepository.findAll();
		
        LocalDate myDate =LocalDate.parse(inputDate);
        Date date = Date.from(myDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        
        boolean inputData = true;
		
		if (listPendapatan.isEmpty()) {
			newPendapatan(date);
		}
		else {
			for (Pendapatan pendapatan : listPendapatan) {
				if (pendapatan.getTanggalGaji().getYear() == date.getYear() && pendapatan.getTanggalGaji().getMonth() == date.getMonth()) {
					updatePendapatan(date, pendapatan);
				
				}
				else {
					inputData = false;
				}
			}
			if (!inputData) {
				newPendapatan(date);
			}
		}
		
		
		result.put("Status", 200);
        result.put("message", "Update Salary Data Success");
        result.put("Data", result);
        
    	return result;
    }
	
	//Perhitungan Pendapatan Baru
	public void newPendapatan(Date date) {
		List<Karyawan> listKaryawan = karyawanRepository.findAll();
		
		for (Karyawan karyawan : listKaryawan) {
			Pendapatan pendapatanTemp = new Pendapatan();
			
			pendapatanTemp = inputPendapatan(karyawan, date);
			
			pendapatanRepository.save(pendapatanTemp);
		}
	}
	
	//Perhitungan untuk update pendapatan
	public void updatePendapatan(Date date, Pendapatan pendapatan) {
		List<Karyawan> listKaryawan = karyawanRepository.findAll();
		
		for (Karyawan karyawan : listKaryawan) {
			Pendapatan pendapatanTemp = new Pendapatan();
			if (pendapatan.getKaryawan() == karyawan) {
				pendapatanTemp = inputPendapatan(karyawan, date);
				pendapatanTemp.setIdPendapatan(pendapatan.getIdPendapatan());
			
				pendapatanRepository.save(pendapatanTemp);
			}
		}
	}
	
	
	//Method untuk mencari pendapatan
	public Pendapatan inputPendapatan(Karyawan karyawan, Date dates) {
		
		Pendapatan pendapatan = new Pendapatan();
		BigDecimal finalPresentaseGaji = new BigDecimal(0), umkPenempatan;
		BigDecimal setKosong = new BigDecimal(0);
		int setKosongInteger = 0;
		
		umkPenempatan = karyawan.getPenempatan().getUmkPenempatan();
		finalPresentaseGaji = calculationPresentaseGaji(karyawan);
		
		pendapatan.setKaryawan(karyawan);
		pendapatan.setTanggalGaji(dates);
		pendapatan.setGajiPokok(calculationGajiPokok(finalPresentaseGaji, umkPenempatan));
		pendapatan.setTunjanganKeluarga(calculationTunjanganKeluarga(pendapatan.getGajiPokok(), karyawan));
		pendapatan.setTunjanganPegawai(calculationTunjanganPegawai(karyawan));
		pendapatan.setTunjanganTransport(calculationTunjanganTransport(karyawan));
		pendapatan.setGajiKotor(calculationGajiKotor(pendapatan));
		pendapatan.setPphPerbulan(setKosong);
		pendapatan.setBpjs(calculationBPJS(pendapatan.getGajiPokok()));
		pendapatan.setGajiBersih(calculationGajiBersih(pendapatan));
		pendapatan.setLamaLembur(setKosongInteger);
		pendapatan.setUangLembur(setKosong);
		pendapatan.setVariableBonus(setKosongInteger);
		pendapatan.setUangBonus(setKosong);
		pendapatan.setTakeHomePay(calculationTakeHomePay(pendapatan));
		
		return pendapatan;	
	}
	
	//method untuk perhitungan gaji pokok
	public BigDecimal calculationGajiPokok(BigDecimal presentaseGaji, BigDecimal umkPenempatan) {
		
		Double gajiPokok;
		gajiPokok = presentaseGaji.doubleValue() * umkPenempatan.doubleValue();
		
		return BigDecimal.valueOf(gajiPokok);
	}
	
	//Perhitungan presentase gaji
	public BigDecimal calculationPresentaseGaji(Karyawan karyawan) {
		
		List<PresentaseGaji> listPresentaseGaji = presentaseGajiRepository.findAll(Sort.by("masaKerja").ascending());
		BigDecimal finalPresentaseGaji = new BigDecimal(0);
		List<Integer> listMasaKerja = new ArrayList<>();
		int batasMasaKerja;
		
		for (PresentaseGaji presentaseGaji : listPresentaseGaji) {
			boolean isPresentaseGaji = karyawan.getPosisi() == presentaseGaji.getPosisi() && karyawan.getTingkatan().getIdTingkatan() == presentaseGaji.getIdTingkatan();
			if (isPresentaseGaji) {
				listMasaKerja.add(presentaseGaji.getMasaKerja());
			}
		}
		
		batasMasaKerja = 0;
            if(karyawan.getMasaKerja() <= listMasaKerja.get(0)){
            	batasMasaKerja = listMasaKerja.get(0);
            }else if(karyawan.getMasaKerja() <= listMasaKerja.get(1)){
            	batasMasaKerja = listMasaKerja.get(1);
            }else {
            	batasMasaKerja = listMasaKerja.get(2);
            }
            
		for (PresentaseGaji presentaseGaji : listPresentaseGaji) {
				boolean isPresentaseGaji = karyawan.getPosisi() == presentaseGaji.getPosisi() && karyawan.getTingkatan().getIdTingkatan() == presentaseGaji.getIdTingkatan() && presentaseGaji.getMasaKerja() == batasMasaKerja;
				if (isPresentaseGaji) {
					finalPresentaseGaji = presentaseGaji.getBesaranGaji();
				}
		}
		
		return finalPresentaseGaji;
	}

	
	//Perhitungan Tunjangan Keluarga
	public BigDecimal calculationTunjanganKeluarga(BigDecimal gajiPokok, Karyawan karyawan) {

		List<Parameter> listParameter = parameterRepository.findAll();
		Double tunjanganKeluarga = 0.0;
		
		if (karyawan.getStatusPernikahan() == 1) {
			for (Parameter parameter : listParameter) {
				tunjanganKeluarga = gajiPokok.doubleValue() * parameter.getTKeluarga().doubleValue();
			}
		}
		
		return BigDecimal.valueOf(tunjanganKeluarga);
	}

	
	//Perhitungan Tunjangan Pegawai
	public BigDecimal calculationTunjanganPegawai(Karyawan karyawan) {

		List<TunjanganPegawai> listTunjanganPegawai = tunjanganPegawaiRepository.findAll();
		BigDecimal pTunjanganTransportasi = new BigDecimal(0);
		
		for (TunjanganPegawai tunjanganPegawai : listTunjanganPegawai) {
			boolean isTunjanganPegawai = karyawan.getPosisi() == tunjanganPegawai.getPosisi() && karyawan.getTingkatan() == tunjanganPegawai.getTingkatan();
			if (isTunjanganPegawai) {
				pTunjanganTransportasi = tunjanganPegawai.getBesaranTujnaganPegawai();
			}
		}

		return pTunjanganTransportasi;
	}	

	
	//Perhitungan Tunjangan Transport
	public BigDecimal calculationTunjanganTransport(Karyawan karyawan) {

		List<Parameter> listParameter = parameterRepository.findAll();
		Double tunjanganTransportasi = 0.0;
		
		for (Parameter parameter : listParameter) {
			if (karyawan.getPenempatan().getKotaPenempatan().equalsIgnoreCase("jakarta")) {
				tunjanganTransportasi = parameter.getTTransport().doubleValue();
			}
		}
		
		return BigDecimal.valueOf(tunjanganTransportasi);
	}	

	
	//Perhitungan gaji kotor
	public BigDecimal calculationGajiKotor(Pendapatan pendapatan) {
		
		Double gajiKotor = 0.0;
		
		gajiKotor = pendapatan.getGajiPokok().doubleValue() + pendapatan.getTunjanganKeluarga().doubleValue() + pendapatan.getTunjanganPegawai().doubleValue() + pendapatan.getTunjanganTransport().doubleValue();
		
		return BigDecimal.valueOf(gajiKotor);
	}

	
	//Perhitungan BPJS
	public BigDecimal calculationBPJS(BigDecimal gajiPokok) {

		List<Parameter> listParameter = parameterRepository.findAll();
		Double pBPJS = 0.0;
		
		for (Parameter parameter : listParameter) {
			pBPJS = gajiPokok.doubleValue() * parameter.getPBpjs().doubleValue();
		}
		
		return BigDecimal.valueOf(pBPJS);
	}
	
	
	//Perhitungan Gaji Bersih
	public BigDecimal calculationGajiBersih(Pendapatan pendapatan) {
		
		Double gajiBersih = 0.0;
		
		gajiBersih = pendapatan.getGajiKotor().doubleValue() - pendapatan.getPphPerbulan().doubleValue() - pendapatan.getBpjs().doubleValue();
		
		return BigDecimal.valueOf(gajiBersih);
	}

	
	//Perhitungan Take Home Pay
	public BigDecimal calculationTakeHomePay(Pendapatan pendapatan) {
		
		Double takeHomePay = 0.0;
		
		takeHomePay = pendapatan.getGajiBersih().doubleValue() + pendapatan.getUangBonus().doubleValue();
		
		return BigDecimal.valueOf(takeHomePay);
	}

}