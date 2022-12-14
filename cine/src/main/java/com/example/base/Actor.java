package com.example.base;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "actor", catalog = "db_peliculas")
public class Actor implements java.io.Serializable {

    private Integer id;
    private String nombre;
    private Date fechaNacimiento;
    private Set<Pelicula> peliculas = new HashSet<Pelicula>(0);

    public Actor() {
    }

    public Actor(String nombre) {
        this.nombre = nombre;
    }

    public Actor(String nombre, Date fechaNacimiento, Set<Pelicula> peliculas) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.peliculas = peliculas;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nombre", nullable = false, length = 200)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", length = 10)
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "actores_peliculas", catalog = "db_peliculas", joinColumns = { @JoinColumn(name = "id_actor", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_pelicula", nullable = false, updatable = false) })
    public Set<Pelicula> getPeliculas() {
        return this.peliculas;
    }

    public void setPeliculas(Set<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

}
