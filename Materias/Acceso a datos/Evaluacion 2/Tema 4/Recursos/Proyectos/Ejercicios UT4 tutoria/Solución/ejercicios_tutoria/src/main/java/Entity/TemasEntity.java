package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "temas", schema = "ut4_tutoria", catalog = "")
public class TemasEntity implements ObjetoBaseDeDatos{

    @Id
    @Column(name = "tema_id")
    private int temaId;
    @Basic
    @Column(name = "nombre")
    private String nombre;

    public int getTemaId() {
        return temaId;
    }

    public void setTemaId(int temaId) {
        this.temaId = temaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemasEntity that = (TemasEntity) o;

        if (temaId != that.temaId) return false;
        if (!Objects.equals(nombre, that.nombre)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = temaId;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @Override
    public int getId() {
        return temaId;
    }

    @Override
    public void setId(int id) {
        setTemaId(id);
    }

    @Override
    public String toString() {
        return "{" +
                "temaId=" + temaId +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
