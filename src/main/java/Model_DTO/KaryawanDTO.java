package Model_DTO;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class KaryawanDTO {

	private Long idKaryawan;
	private AgamaDTO agama;
	private PenempatanDTO penempatan;
	private PosisiDTO posisi;
	private TingkatanDTO tingkatan;
	//===============================//
	private String nama;
	private String noKtp;
	private String alamat;
	private Date tanggalLahir;
	private Integer masaKerja;
	private Short statusPernikahan;
	private Date kontrakAwal;
	private Date kontrakAkhir;
	private String jenisKelamin;
	private Integer jumlahAnak;
	
	//KARYAWAN
	public Long getIdKaryawan() {
		return idKaryawan;
	}
	public void setIdKaryawan(Long idKaryawan) {
		this.idKaryawan = idKaryawan;
	}
	
	//AGAMA DTO
	public AgamaDTO getAgama() {
		return agama;
	}
	public void setAgama(AgamaDTO agama) {
		this.agama = agama;
	}
	
	//PENEMPATAN DTO
	public PenempatanDTO getPenempatan() {
		return penempatan;
	}
	public void setPenempatan(PenempatanDTO penempatan) {
		this.penempatan = penempatan;
	}
	
	//POSISI DTO
	public PosisiDTO getPosisi() {
		return posisi;
	}
	public void setPosisi(PosisiDTO posisi) {
		this.posisi = posisi;
	}
	
	//TINGKATAN DTO
	public TingkatanDTO getTingkatan() {
		return tingkatan;
	}
	public void setTingkatan(TingkatanDTO tingkatan) {
		this.tingkatan = tingkatan;
	}
	
//========================================================= INPUT DATA
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getNoKtp() {
		return noKtp;
	}
	public void setNoKtp(String noKtp) {
		this.noKtp = noKtp;
	}
	
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getTanggalLahir() {
		return tanggalLahir;
	}
	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}
	
	public Integer getMasaKerja() {
		return masaKerja;
	}
	public void setMasaKerja(Integer masaKerja) {
		this.masaKerja = masaKerja;
	}
	
	public Short getStatusPernikahan() {
		return statusPernikahan;
	}
	public void setStatusPernikahan(Short statusPernikahan) {
		this.statusPernikahan = statusPernikahan;
	}
	
	public Date getKontrakAwal() {
		return kontrakAwal;
	}
	public void setKontrakAwal(Date kontrakAwal) {
		this.kontrakAwal = kontrakAwal;
	}
	
	public Date getKontrakAkhir() {
		return kontrakAkhir;
	}
	public void setKontrakAkhir(Date kontrakAkhir) {
		this.kontrakAkhir = kontrakAkhir;
	}
	
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	
	public Integer getJumlahAnak() {
		return jumlahAnak;
	}
	public void setJumlahAnak(Integer jumlahAnak) {
		this.jumlahAnak = jumlahAnak;
	}
	
	
}
