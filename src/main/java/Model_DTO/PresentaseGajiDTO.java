package Model_DTO;

import java.math.BigDecimal;

public class PresentaseGajiDTO {
	
	private Long idPresentaseGaji;
	private PosisiDTO posisi;
	private Long idTingkatan;
	private BigDecimal besaranGaji;
	private Integer masaKerja;
	
	
	public Long getIdPresentaseGaji() {
		return idPresentaseGaji;
	}
	public void setIdPresentaseGaji(Long idPresentaseGaji) {
		this.idPresentaseGaji = idPresentaseGaji;
	}
	
	
	public PosisiDTO getPosisi() {
		return posisi;
	}
	public void setPosisi(PosisiDTO posisi) {
		this.posisi = posisi;
	}
	
	
	public Long getIdTingkatan() {
		return idTingkatan;
	}
	public void setIdTingkatan(Long idTingkatan) {
		this.idTingkatan = idTingkatan;
	}
	
	
	public BigDecimal getBesaranGaji() {
		return besaranGaji;
	}
	public void setBesaranGaji(BigDecimal besaranGaji) {
		this.besaranGaji = besaranGaji;
	}
	
	
	public Integer getMasaKerja() {
		return masaKerja;
	}
	public void setMasaKerja(Integer masaKerja) {
		this.masaKerja = masaKerja;
	}
	
	

}
