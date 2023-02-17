package io.github.frcleiton.medicin.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.frcleiton.medicin.model.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer>{

}
