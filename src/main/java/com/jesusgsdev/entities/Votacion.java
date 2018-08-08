
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

	private Integer	id_censo;
	private Integer	id_grupo;
	private String	titulo;
	private String	descripcion;
	private Date	fecha_ini;
	private Date	fecha_fin;
	private String	clave;

	public Votacion() { }

	public Votacion(Integer	 id_censo, Integer	id_grupo, String	titulo, String	descripcion, Date	fecha_ini, Date	fecha_fin,String	clave) {
		this.id_censo = id_censo;
		this.id_grupo = id_grupo;
		this. titulo = titulo;
		this.descripcion = descripcion;
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
		this.clave = clave;


	}


	public Integer getId_censo() {
		return this.id_censo;
	}

	public void setId_censo(final Integer id_censo) {
		this.id_censo = id_censo;
	}

	public Integer getId_grupo() {
		return this.id_grupo;
	}

	public void setId_grupo(final Integer id_grupo) {
		this.id_grupo = id_grupo;
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
	public Date getFecha_ini() {
		return this.fecha_ini;
	}

	public void setFecha_ini(final Date fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getFecha_fin() {
		return this.fecha_fin;
	}

	public void setFecha_fin(final Date fecha_fin) {
		this.fecha_fin = fecha_fin;
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
				.append(id_censo, votacion.id_censo)
				.append(id_grupo, votacion.id_grupo)
				.append(titulo, votacion.titulo)
				.append(descripcion, votacion.descripcion)
				.append(fecha_ini, votacion.fecha_ini)
				.append(fecha_fin, votacion.fecha_fin)
				.append(clave, votacion.clave)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(id_censo)
				.append(id_grupo)
				.append(titulo)
				.append(descripcion)
				.append(fecha_ini)
				.append(fecha_fin)
				.append(clave)
				.toHashCode();
	}
}
