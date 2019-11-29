package Model_DTO;

import java.math.BigDecimal;
import java.util.Date;

import com.Employee.DataEmployee.model.Karyawan;

public class PendapatanDTO {
	
	private Long idPendapatan;
	private Karyawan karyawan;
	private Date tanggalGaji;
	private BigDecimal gajiPokok;
	private BigDecimal tunjanganKeluarga;
	private BigDecimal tunjanganPegawai;
	private BigDecimal tunjanganTransport;
	private BigDecimal gajiKotor;
	private BigDecimal pphPerbulan;
	private BigDecimal bpjs;
	private BigDecimal gajiBersih;
	private Integer lamaLembur;
	private BigDecimal uangLembur;
	private Integer variableBonus;
	private BigDecimal uangBonus;
	private BigDecimal takeHomePay;
	
	
	public Long getIdPendapatan() {
		return idPendapatan;
	}
	public void setIdPendapatan(Long idPendapatan) {
		this.idPendapatan = idPendapatan;
	}
	
	
	public Karyawan getKaryawan() {
		return karyawan;
	}
	public void setKaryawan(Karyawan karyawan) {
		this.karyawan = karyawan;
	}
	
	
	public Date getTanggalGaji() {
		return tanggalGaji;
	}
	public void setTanggalGaji(Date tanggalGaji) {
		this.tanggalGaji = tanggalGaji;
	}
	
	
	public BigDecimal getGajiPokok() {
		return gajiPokok;
	}
	public void setGajiPokok(BigDecimal gajiPokok) {
		this.gajiPokok = gajiPokok;
	}
	
	
	public BigDecimal getTunjanganKeluarga() {
		return tunjanganKeluarga;
	}
	public void setTunjanganKeluarga(BigDecimal tunjanganKeluarga) {
		this.tunjanganKeluarga = tunjanganKeluarga;
	}
	
	
	public BigDecimal getTunjanganPegawai() {
		return tunjanganPegawai;
	}
	public void setTunjanganPegawai(BigDecimal tunjanganPegawai) {
		this.tunjanganPegawai = tunjanganPegawai;
	}
	
	
	public BigDecimal getTunjanganTransport() {
		return tunjanganTransport;
	}
	public void setTunjanganTransport(BigDecimal tunjanganTransport) {
		this.tunjanganTransport = tunjanganTransport;
	}
	
	
	public BigDecimal getGajiKotor() {
		return gajiKotor;
	}
	public void setGajiKotor(BigDecimal gajiKotor) {
		this.gajiKotor = gajiKotor;
	}
	
	
	public BigDecimal getPphPerbulan() {
		return pphPerbulan;
	}
	public void setPphPerbulan(BigDecimal pphPerbulan) {
		this.pphPerbulan = pphPerbulan;
	}
	
	
	public BigDecimal getBpjs() {
		return bpjs;
	}
	public void setBpjs(BigDecimal bpjs) {
		this.bpjs = bpjs;
	}
	
	
	public BigDecimal getGajiBersih() {
		return gajiBersih;
	}
	public void setGajiBersih(BigDecimal gajiBersih) {
		this.gajiBersih = gajiBersih;
	}
	
	
	public Integer getLamaLembur() {
		return lamaLembur;
	}
	public void setLamaLembur(Integer lamaLembur) {
		this.lamaLembur = lamaLembur;
	}
	
	
	public BigDecimal getUangLembur() {
		return uangLembur;
	}
	public void setUangLembur(BigDecimal uangLembur) {
		this.uangLembur = uangLembur;
	}
	
	
	public Integer getVariableBonus() {
		return variableBonus;
	}
	public void setVariableBonus(Integer variableBonus) {
		this.variableBonus = variableBonus;
	}
	
	
	public BigDecimal getUangBonus() {
		return uangBonus;
	}
	public void setUangBonus(BigDecimal uangBonus) {
		this.uangBonus = uangBonus;
	}
	
	
	public BigDecimal getTakeHomePay() {
		return takeHomePay;
	}
	public void setTakeHomePay(BigDecimal takeHomePay) {
		this.takeHomePay = takeHomePay;
	}
	
}
