package Model_DTO;

import java.math.BigDecimal;

public class TunjanganPegawaiDTO {
	
	private Long idTunjanganPegawai;
	private PosisiDTO posisi;
	private TingkatanDTO tingkatan;
	private BigDecimal besaranTujnaganPegawai;
	
	
	public Long getIdTunjanganPegawai() {
		return idTunjanganPegawai;
	}
	public void setIdTunjanganPegawai(Long idTunjanganPegawai) {
		this.idTunjanganPegawai = idTunjanganPegawai;
	}
	
	
	public PosisiDTO getPosisi() {
		return posisi;
	}
	public void setPosisi(PosisiDTO posisi) {
		this.posisi = posisi;
	}
	
	
	public TingkatanDTO getTingkatan() {
		return tingkatan;
	}
	public void setTingkatan(TingkatanDTO tingkatan) {
		this.tingkatan = tingkatan;
	}
	
	
	public BigDecimal getBesaranTujnaganPegawai() {
		return besaranTujnaganPegawai;
	}
	public void setBesaranTujnaganPegawai(BigDecimal besaranTujnaganPegawai) {
		this.besaranTujnaganPegawai = besaranTujnaganPegawai;
	}
	
	

}
