package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "libros", schema = "ut4_tutoria", catalog = "")
public class LibrosEntity implements ObjetoBaseDeDatos {

    @Id
    @Column(name = "libro_id")
    private int libroId;
    @Basic
    @Column(name = "titulo")
    private String titulo;
    @Basic
    @Column(name = "autor")
    private String autor;
    @Basic
    @Column(name = "ano_publicacion")
    private Integer anoPublicacion;
    @Basic
    @Column(name = "editorial")
    private String editorial;

    @ManyToOne
    @JoinColumn(name = "biblioteca_id")
    private BibliotecasEntity biblioteca;
    @ManyToOne
    @JoinColumn(name = "tema_id")
    private TemasEntity tema;

    public LibrosEntity() {
    }

    public LibrosEntity(int libroId, String titulo, String autor, Integer anoPublicacion, String editorial, BibliotecasEntity biblioteca, TemasEntity tema) {
        this.libroId = libroId;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.editorial = editorial;
        this.biblioteca = biblioteca;
        this.tema = tema;
    }

    public LibrosEntity(int libroId, String titulo, String autor) {
        this.libroId = libroId;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(Integer anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public BibliotecasEntity getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(BibliotecasEntity bibliotecaId) {
        this.biblioteca = bibliotecaId;
    }

    public TemasEntity getTema() {
        return tema;
    }

    public void setTema(TemasEntity temaId) {
        this.tema = temaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibrosEntity that = (LibrosEntity) o;

        if (libroId != that.libroId) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (autor != null ? !autor.equals(that.autor) : that.autor != null) return false;
        if (anoPublicacion != null ? !anoPublicacion.equals(that.anoPublicacion) : that.anoPublicacion != null)
            return false;
        if (editorial != null ? !editorial.equals(that.editorial) : that.editorial != null) return false;
        if (biblioteca != null ? !biblioteca.equals(that.biblioteca) : that.biblioteca != null) return false;
        if (tema != null ? !tema.equals(that.tema) : that.tema != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = libroId;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + (anoPublicacion != null ? anoPublicacion.hashCode() : 0);
        result = 31 * result + (editorial != null ? editorial.hashCode() : 0);
        result = 31 * result + (biblioteca != null ? biblioteca.hashCode() : 0);
        result = 31 * result + (tema != null ? tema.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "libroId=" + libroId +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacion=" + anoPublicacion +
                ", editorial='" + editorial + '\'' +
                ", bibliotecaId=" + biblioteca +
                ", temaId=" + tema +
                '}';
    }

    @Override
    public int getId() {
        return libroId;
    }

    @Override
    public void setId(int id) {
        setLibroId(id);
    }
}
