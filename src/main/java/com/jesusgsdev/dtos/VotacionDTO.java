package com.jesusgsdev.dtos;

import com.jesusgsdev.entities.Votacion;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class VotacionDTO extends BaseDTO {

    private Long id;

    private Integer	idCenso;
    private Integer	idGrupo;
    private String	titulo;
    private String	descripcion;
    private Date fechaIni;
    private Date	fechaFin;

    @NotEmpty
    @Length(max = 255)
    private String	clave;

    public VotacionDTO() { }

    public VotacionDTO(Long id,Integer	idCenso, Integer idGrupo,  String	titulo,String	descripcion,Date fechaIni, Date	fechaFin,@NotEmpty @Length(max = 255)String	clave) {
        this.id = id;
        this.idCenso = idCenso;
        this.idGrupo = idGrupo;
        this. titulo = titulo;
        this.descripcion = descripcion;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.clave = clave;
    }

    public VotacionDTO(String error, String errorMessage, Integer idGrupo,  String	titulo,String	descripcion,Date fechaIni, Date	fechaFin,@NotEmpty @Length(max = 255)String	clave) {
        super(error, errorMessage);
        this.id = id;
        this.idCenso = idCenso;
        this.idGrupo = idGrupo;
        this. titulo = titulo;
        this.descripcion = descripcion;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.clave = clave;
    }

    public static VotacionDTO fromVotacion(Votacion votacion) {
        return new VotacionDTO(votacion.getId(),votacion.getIdCenso(),votacion.getIdGrupo(),votacion.getTitulo(),
                votacion.getDescripcion(),votacion.getFechaIni(),votacion.getFechaFin(),votacion.getClave());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdCenso() {
        return idCenso;
    }

    public void setIdCenso(Integer idCenso) {
        this.idCenso = idCenso;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("idCenso", idCenso)
                .append("idGrupo", idGrupo)
                .append("titulo", titulo)
                .append("descripcion", descripcion)
                .append("fechaIni", fechaIni)
                .append("fechaFin", fechaFin)
                .append("clave", clave)
                .toString();
    }
}
