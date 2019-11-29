package Model_DTO;

public class KemampuanDTO {
	
	private Long idKemampuan;
	private KategoriKemampuanDTO kategoriKemampuan;
	private String namaKemampuan;
	
	public Long getIdKemampuan() {
		return idKemampuan;
	}
	public void setIdKemampuan(Long idKemampuan) {
		this.idKemampuan = idKemampuan;
	}
	
	
	public KategoriKemampuanDTO getKategoriKemampuan() {
		return kategoriKemampuan;
	}
	public void setKategoriKemampuan(KategoriKemampuanDTO kategoriKemampuan) {
		this.kategoriKemampuan = kategoriKemampuan;
	}
	
	
	public String getNamaKemampuan() {
		return namaKemampuan;
	}
	public void setNamaKemampuan(String namaKemampuan) {
		this.namaKemampuan = namaKemampuan;
	}


}
