package Model_DTO;

import java.math.BigDecimal;

public class PenempatanDTO {
	
	private Long idPenempatan;
	private String kotaPenempatan;
	private BigDecimal umkPenempatan;
	
	
	public Long getIdPenempatan() {
		return idPenempatan;
	}
	public void setIdPenempatan(Long idPenempatan) {
		this.idPenempatan = idPenempatan;
	}
	
	
	public String getKotaPenempatan() {
		return kotaPenempatan;
	}
	public void setKotaPenempatan(String kotaPenempatan) {
		this.kotaPenempatan = kotaPenempatan;
	}
	
	
	public BigDecimal getUmkPenempatan() {
		return umkPenempatan;
	}
	public void setUmkPenempatan(BigDecimal umkPenempatan) {
		this.umkPenempatan = umkPenempatan;
	}
	
	

}
