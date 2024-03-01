package Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "bibliotecas", schema = "ut4_tutoria", catalog = "")
public class BibliotecasEntity implements ObjetoBaseDeDatos {
    @Id
    @Column(name = "biblioteca_id")
    private int bibliotecaId;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "capacidad")
    private Integer capacidad;

    public int getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(int bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BibliotecasEntity that = (BibliotecasEntity) o;

        if (bibliotecaId != that.bibliotecaId) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (capacidad != null ? !capacidad.equals(that.capacidad) : that.capacidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bibliotecaId;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (capacidad != null ? capacidad.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BibliotecasEntity{" +
                "bibliotecaId=" + bibliotecaId +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }

    @Override
    public int getId() {
        return bibliotecaId;
    }

    @Override
    public void setId(int id) {
        this.bibliotecaId = id;
    }
}
