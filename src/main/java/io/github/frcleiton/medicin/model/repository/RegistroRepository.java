package io.github.frcleiton.medicin.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.frcleiton.medicin.model.entity.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Integer>{

	@Query(" select r from Registro r join r.medicamento m where upper( m.descricao ) like upper( :nome ) ")
	List<Registro> findByNomeMedicamento(@Param("nome") String _nome);

}
