/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JAEL ARMAS
 */
@Entity
@Table(name = "reservacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservacion.findAll", query = "SELECT r FROM Reservacion r")
    , @NamedQuery(name = "Reservacion.findByReservacionId", query = "SELECT r FROM Reservacion r WHERE r.reservacionId = :reservacionId")
    , @NamedQuery(name = "Reservacion.findByFechaEntrada", query = "SELECT r FROM Reservacion r WHERE r.fechaEntrada = :fechaEntrada")
    , @NamedQuery(name = "Reservacion.findByFechaSalida", query = "SELECT r FROM Reservacion r WHERE r.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "Reservacion.findByNumUsuarios", query = "SELECT r FROM Reservacion r WHERE r.numUsuarios = :numUsuarios")
    , @NamedQuery(name = "Reservacion.findByPrecio", query = "SELECT r FROM Reservacion r WHERE r.precio = :precio")
    , @NamedQuery(name = "Reservacion.findByEstado", query = "SELECT r FROM Reservacion r WHERE r.estado = :estado")
    , @NamedQuery(name = "Reservacion.findByPagada", query = "SELECT r FROM Reservacion r WHERE r.pagada = :pagada")})
public class Reservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reservacion_id")
    private Integer reservacionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrada")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_usuarios")
    private int numUsuarios;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Float precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pagada")
    private boolean pagada;
    @JoinColumn(name = "habitacion_id", referencedColumnName = "habitacion_id")
    @ManyToOne(optional = false)
    private Habitacion habitacionId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    
    @Transient
    private String strFechaHabitaciones;

    @Transient
    private String strFechaInicial;

    @Transient
    private String strFechaFinal;

    @Transient
    private String strFechaEntrada;

    @Transient
    private String strFechaSalida;

    @Transient
    private int idusuario;

    @Transient
    private int idhabitacion;

    @Transient
    private int idcategoria;

    @Transient
    private String strEstado;

    public String getStrFechaHabitaciones() {
        return strFechaHabitaciones;
    }

    public void setStrFechaHabitaciones(String strFechaHabitaciones) {
        this.strFechaHabitaciones = strFechaHabitaciones;
    }

    public String getStrFechaInicial() {
        return strFechaInicial;
    }

    public void setStrFechaInicial(String strFechaInicial) {
        this.strFechaInicial = strFechaInicial;
    }

    public String getStrFechaFinal() {
        return strFechaFinal;
    }

    public void setStrFechaFinal(String strFechaFinal) {
        this.strFechaFinal = strFechaFinal;
    }
    
    

    public String getStrFechaEntrada() {
        return strFechaEntrada;
    }

    public void setStrFechaEntrada(String strFechaEntrada) {
        this.strFechaEntrada = strFechaEntrada;
    }

    public String getStrFechaSalida() {
        return strFechaSalida;
    }

    public void setStrFechaSalida(String strFechaSalida) {
        this.strFechaSalida = strFechaSalida;
    }

    public String getFechaEntradaMostrar() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(fechaEntrada);
    }

    public String getFechaSalidaMostrar() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(fechaSalida);
    }

    public String getStrEstado() {
        switch (this.estado) {
            case 1:
                this.strEstado = "Pendiente";
                break;
            case 2:
                this.strEstado = "Alojamiento";
                break;
            case 3:
                this.strEstado = "Finalizada";
                break;
            default:
                this.strEstado = "Sin Estado";
                break;
        }
        return strEstado;
    }

    public void setStrEstado(String strEstado) {
        this.strEstado = strEstado;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Reservacion() {
    }

    public Reservacion(Integer reservacionId) {
        this.reservacionId = reservacionId;
    }

    public Reservacion(Integer reservacionId, Date fechaEntrada, int numUsuarios, int estado, boolean pagada) {
        this.reservacionId = reservacionId;
        this.fechaEntrada = fechaEntrada;
        this.numUsuarios = numUsuarios;
        this.estado = estado;
        this.pagada = pagada;
    }

    public Integer getReservacionId() {
        return reservacionId;
    }

    public void setReservacionId(Integer reservacionId) {
        this.reservacionId = reservacionId;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getNumUsuarios() {
        return numUsuarios;
    }

    public void setNumUsuarios(int numUsuarios) {
        this.numUsuarios = numUsuarios;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean getPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public Habitacion getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(Habitacion habitacionId) {
        this.habitacionId = habitacionId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservacionId != null ? reservacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservacion)) {
            return false;
        }
        Reservacion other = (Reservacion) object;
        if ((this.reservacionId == null && other.reservacionId != null) || (this.reservacionId != null && !this.reservacionId.equals(other.reservacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Reservacion[ reservacionId=" + reservacionId + " ]";
    }
    
}
