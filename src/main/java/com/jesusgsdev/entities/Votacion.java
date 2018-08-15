
package com.jesusgsdev.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "votacion")
public class Votacion extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer	idCenso;
	private Integer	idGrupo;
	private String	titulo;
	private String	descripcion;
	private Date	fechaIni;
	private Date	fechaFin;
	private String	clave;

	public Votacion() { }

	public Votacion(Integer	 idCenso, Integer	idGrupo, String	titulo, String	descripcion, Date	fechaIni, Date	fechaFin,String	clave) {
		this.idCenso = idCenso;
		this.idGrupo = idGrupo;
		this. titulo = titulo;
		this.descripcion = descripcion;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.clave = clave;


	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Integer getIdCenso() {
		return this.idCenso;
	}

	public void setIdCenso(final Integer idCenso) {
		this.idCenso = idCenso;
	}

	public Integer getIdGrupo() {
		return this.idGrupo;
	}

	public void setIdGrupo(final Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	@NotBlank
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	@NotBlank
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getFechaIni() {
		return this.fechaIni;
	}

	public void setFechaIni(final Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(final Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@NotBlank
	public String getClave() {
		return this.clave;
	}

	public void setClave(final String clave) {
		this.clave = clave;
	}


	// Relationships

	private Collection<Pregunta> preguntas;


	@OneToMany(mappedBy = "votacion")
	public Collection<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(final Collection<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		Votacion votacion = (Votacion) o;

		return new EqualsBuilder()
				.append(idCenso, votacion.idCenso)
				.append(idGrupo, votacion.idGrupo)
				.append(titulo, votacion.titulo)
				.append(descripcion, votacion.descripcion)
				.append(fechaIni, votacion.fechaIni)
				.append(fechaFin, votacion.fechaFin)
				.append(clave, votacion.clave)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(idCenso)
				.append(idGrupo)
				.append(titulo)
				.append(descripcion)
				.append(fechaIni)
				.append(fechaFin)
				.append(clave)
				.toHashCode();
	}
}
