package com.example.layouts

open class Producto()
{
    open var foto:String = ""
    open var precio:Float = 0.0f
    open var desc:String = ""


    constructor(foto:String,precio:Float,desc:String) : this()
    {
        this.foto = foto
        this.precio = precio
        this.desc = desc
    }

    constructor(p: Producto): this(p.foto,p.precio,p.desc)

    companion object
    {
        const val IVA:Float = 1.21f
        const val IVA_REDUCIDO:Float = 1.1f
    }

    open override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other !is Producto) return false

        if (foto != other.foto) return false
        if (precio != other.precio) return false
        if (desc != other.desc) return false

        return true
    }

    open override fun hashCode(): Int
    {
        var result = foto.hashCode()
        result = 31 * result + precio.hashCode()
        result = 31 * result + desc.hashCode()
        return result
    }

    open override fun toString(): String
    {
        return "foto=$foto, precio=$precio, desc=$desc"
    }


}

enum class TipoComida {
    ENTRANTE, PRINCIPAL, POSTRE
}

class Comida(foto:String, precio:Float, desc:String, tipoComida: TipoComida): Producto(foto,precio, desc)
{
    init {
        this.precio *= IVA_REDUCIDO
    }

    var tipoComida:TipoComida = tipoComida

    constructor(): this("", 0.0f, "", TipoComida.ENTRANTE)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Comida) return false
        if (!super.equals(other)) return false

        if (tipoComida != other.tipoComida) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + tipoComida.hashCode()
        return result
    }

    override fun toString(): String {
        return "Comida(${super.toString()}, tipoComida=$tipoComida)"
    }


}

class Bebida(foto:String, precio:Float, desc:String, tamLitros:Float = 0.0f, alcoholica:Boolean = false): Producto(foto,precio, desc)
{
    init
    {
        this.precio = when(alcoholica)
        {
            false -> this.precio* IVA_REDUCIDO
            true -> this.precio* IVA
        }

    }

    var tamLitros: Float = tamLitros
    var alcoholica: Boolean = alcoholica

    constructor(): this("", 0.0f, "")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Bebida) return false
        if (!super.equals(other)) return false

        if (tamLitros != other.tamLitros) return false
        if (alcoholica != other.alcoholica) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + tamLitros.hashCode()
        result = 31 * result + alcoholica.hashCode()
        return result
    }

    private fun BooleanToString(): String
    {
        when (this.alcoholica)
        {
            false -> return "NO"
            true -> return "SÍ"
        }
    }

    override fun toString(): String {
        return "Bebida() ${super.toString()}, Tamaño Litros = ${tamLitros}L, Alcoholica = ${BooleanToString()}"
    }


}

class Comanda()
{
    var listaProductos:MutableList<Producto> = mutableListOf()
    var numMesa:Int = 0
    var numComensales:Int = 1

    constructor(numMesa:Int, numComensales:Int): this()
    {
        //listaProductos = mutableListOf() --> No es necesario porque se indica en el atributo un valor por defecto
        this.numMesa = numMesa
        this.numComensales = numComensales

    }

    fun añadirProducto(p: Producto) = listaProductos.add(p)

    fun eliminarProducto(p: Producto) = listaProductos.remove(p)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Comanda) return false

        if (listaProductos != other.listaProductos) return false
        if (numMesa != other.numMesa) return false
        if (numComensales != other.numComensales) return false

        return true
    }

    override fun hashCode(): Int {
        var result = listaProductos.hashCode()
        result = 31 * result + numMesa
        result = 31 * result + numComensales
        return result
    }

    override fun toString(): String {
        return "Comanda(listaProductos=$listaProductos, numMesa=$numMesa, numComensales=$numComensales)"
    }


}

fun main()
{


    val c1 = Comida("/home/fotos/1.jpeg", 3.0f, "Marinera", TipoComida.ENTRANTE)
    val c2 = Comida()
    val c3 = Comida("/home/fotos/2.jpeg", 12.0f, "Tortilla de Patatas", TipoComida.PRINCIPAL)
    val c4 = Comida("/home/fotos/3.jpeg", 6.0f, "Natillas", TipoComida.POSTRE)

    val b1 = Bebida()
    val b2 = Bebida("/home/fotos/bebida1.jpeg", 3.0f, "Agua", 0.33f, false)
    val b3 = Bebida("/home/fotos/bebida2.jpeg", 4.5f, "Tinto de verano", 0.5f, true)


    println("Comida 1: $c1")
    println("Comida 2: $c2")
    println("Comida 3: $c3")
    println("Comida 4: $c4")


    println("Bebida 1: $b1")
    println("Bebida 2: $b2")
    println("Bebida 3: $b3")

    val comanda1 = Comanda(1, 2)
    val comanda2 = Comanda(2, 4)

    comanda1.añadirProducto(c1)
    comanda1.añadirProducto(c2)
    comanda1.añadirProducto(b1)
    comanda1.añadirProducto(b2)

    comanda2.añadirProducto(c3)
    comanda2.añadirProducto(c4)
    comanda2.añadirProducto(b3)

    println("Comanda 1: $comanda1")
    println("Comanda 2: $comanda2")


}
