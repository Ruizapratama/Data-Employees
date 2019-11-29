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
 * KategoriKemampuan generated by hbm2java
 */
@Entity
@Table(name = "kategori_kemampuan", schema = "public")
public class KategoriKemampuan implements java.io.Serializable {

	private Long idKategori;
	private String namaKategori;
	private Set<Kemampuan> kemampuans = new HashSet<Kemampuan>(0);

	public KategoriKemampuan() {
	}

	public KategoriKemampuan(Long idKategori, String namaKategori) {
		this.idKategori = idKategori;
		this.namaKategori = namaKategori;
	}

	public KategoriKemampuan(Long idKategori, String namaKategori, Set<Kemampuan> kemampuans) {
		this.idKategori = idKategori;
		this.namaKategori = namaKategori;
		this.kemampuans = kemampuans;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kategori_kemampuan_id_seq")
	@SequenceGenerator(name="kategori_kemampuan_id_seq", sequenceName="kategori_kemampuan_id_seq", schema = "public", allocationSize = 1)
	@Column(name = "`ID_KATEGORI`", unique = true, nullable = false)
	public Long getIdKategori() {
		return this.idKategori;
	}

	public void setIdKategori(Long idKategori) {
		this.idKategori = idKategori;
	}

	@Column(name = "`NAMA_KATEGORI`", nullable = false, length = 128)
	public String getNamaKategori() {
		return this.namaKategori;
	}

	public void setNamaKategori(String namaKategori) {
		this.namaKategori = namaKategori;
	}

	@OneToMany (fetch = FetchType.LAZY, mappedBy = "kategoriKemampuan")
	public Set<Kemampuan> getKemampuans() {
		return this.kemampuans;
	}

	public void setKemampuans(Set<Kemampuan> kemampuans) {
		this.kemampuans = kemampuans;
	}

}
