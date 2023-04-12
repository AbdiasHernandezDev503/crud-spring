package com.abdias.market.persistence;

import com.abdias.market.domain.Purchase;
import com.abdias.market.domain.repository.IPurchaseRepository;
import com.abdias.market.persistence.crud.ICompraCrudRepository;
import com.abdias.market.persistence.entity.Compra;
import com.abdias.market.persistence.mapper.IPurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements IPurchaseRepository {
    @Autowired
    ICompraCrudRepository compraCrudRepository;

    @Autowired
    private IPurchaseMapper mapper;


    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases( (List<Compra>) compraCrudRepository.findAll() );
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId).map(
                    compras -> mapper.toPurchases(compras
                ));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
