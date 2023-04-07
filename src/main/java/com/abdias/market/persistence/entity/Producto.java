package com.abdias.market.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    /*No de deben notar con la anotacion Column debido a que asi como se llama el atributo en la clase,
    entiende que asi se llama en la base de datos
     */
    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name =  "codigo_barras")
    private String codigoBarras;

    @Column(name =  "precio_venta")
    private Double precioVentas;

    @Column(name =  "cantidad_stock")
    private Integer cantidadStock;

    //al igual que en nombre no se deben notar
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name =  "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    //GETTERS Y SETTERS
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVentas() {
        return precioVentas;
    }

    public void setPrecioVentas(Double precioVentas) {
        this.precioVentas = precioVentas;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
