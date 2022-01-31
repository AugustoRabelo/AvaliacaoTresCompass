package avaliacao.estado.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import avaliacao.estado.controller.dto.EstadoDto;
import avaliacao.estado.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	List<Estado> findAll(Sort sort);
	
}
