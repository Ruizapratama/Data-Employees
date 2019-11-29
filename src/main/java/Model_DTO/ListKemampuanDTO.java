package Model_DTO;

public class ListKemampuanDTO {

	private Long idListKemampuan;
	private KaryawanDTO karyawan;
	private KemampuanDTO kemampuan;
	private Integer nilaiKemampuan;
	
	
	public Long getIdListKemampuan() {
		return idListKemampuan;
	}
	public void setIdListKemampuan(Long idListKemampuan) {
		this.idListKemampuan = idListKemampuan;
	}
	
	
	public KaryawanDTO getKaryawan() {
		return karyawan;
	}
	public void setKaryawan(KaryawanDTO karyawan) {
		this.karyawan = karyawan;
	}
	
	
	public KemampuanDTO getKemampuan() {
		return kemampuan;
	}
	public void setKemampuan(KemampuanDTO kemampuan) {
		this.kemampuan = kemampuan;
	}
	
	
	public Integer getNilaiKemampuan() {
		return nilaiKemampuan;
	}
	public void setNilaiKemampuan(Integer nilaiKemampuan) {
		this.nilaiKemampuan = nilaiKemampuan;
	}
	
	
}
