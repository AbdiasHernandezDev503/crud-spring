package com.abdias.market.persistence;

import com.abdias.market.persistence.crud.IProductoCrudRepository;
import com.abdias.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private IProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidadStock) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, true);
    }

    public Optional<Producto> getProducto(int idProducto) {
        return  productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto) {
        return  productoCrudRepository.save(producto);
    }

    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
