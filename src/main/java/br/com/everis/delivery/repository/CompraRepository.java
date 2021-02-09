package br.com.everis.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.delivery.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}
