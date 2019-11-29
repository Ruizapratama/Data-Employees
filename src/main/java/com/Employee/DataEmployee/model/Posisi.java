package com.Employee.DataEmployee.model;
// Generated Nov 26, 2019 9:44:58 AM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Posisi generated by hbm2java
 */
@Entity
@Table(name = "posisi", schema = "public")
public class Posisi implements java.io.Serializable {

	private Long idPosisi;
	private String namaPosisi;
	private Set<PresentaseGaji> presentaseGajis = new HashSet<PresentaseGaji>(0);
	private Set<TunjanganPegawai> tunjanganPegawais = new HashSet<TunjanganPegawai>(0);
	private Set<Karyawan> karyawans = new HashSet<Karyawan>(0);

	public Posisi() {
	}

	public Posisi(Long idPosisi, String namaPosisi) {
		this.idPosisi = idPosisi;
		this.namaPosisi = namaPosisi;
	}

	public Posisi(Long idPosisi, String namaPosisi, Set<PresentaseGaji> presentaseGajis,
			Set<TunjanganPegawai> tunjanganPegawais, Set<Karyawan> karyawans) {
		this.idPosisi = idPosisi;
		this.namaPosisi = namaPosisi;
		this.presentaseGajis = presentaseGajis;
		this.tunjanganPegawais = tunjanganPegawais;
		this.karyawans = karyawans;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "posisi_id_seq")
	@SequenceGenerator(name="posisi_id_seq", sequenceName="posisi_id_seq", schema = "public", allocationSize = 1)
	@Column(name = "`ID_POSISI`", unique = true, nullable = false)
	public Long getIdPosisi() {
		return this.idPosisi;
	}

	public void setIdPosisi(Long idPosisi) {
		this.idPosisi = idPosisi;
	}

	@Column(name = "`NAMA_POSISI`", nullable = false, length = 128)
	public String getNamaPosisi() {
		return this.namaPosisi;
	}

	public void setNamaPosisi(String namaPosisi) {
		this.namaPosisi = namaPosisi;
	}

	@OneToMany (fetch = FetchType.LAZY, mappedBy = "posisi")
	public Set<PresentaseGaji> getPresentaseGajis() {
		return this.presentaseGajis;
	}

	public void setPresentaseGajis(Set<PresentaseGaji> presentaseGajis) {
		this.presentaseGajis = presentaseGajis;
	}

	@OneToMany (fetch = FetchType.LAZY, mappedBy = "posisi")
	public Set<TunjanganPegawai> getTunjanganPegawais() {
		return this.tunjanganPegawais;
	}

	public void setTunjanganPegawais(Set<TunjanganPegawai> tunjanganPegawais) {
		this.tunjanganPegawais = tunjanganPegawais;
	}

	@OneToMany (fetch = FetchType.LAZY, mappedBy = "posisi")
	public Set<Karyawan> getKaryawans() {
		return this.karyawans;
	}

	public void setKaryawans(Set<Karyawan> karyawans) {
		this.karyawans = karyawans;
	}

}
