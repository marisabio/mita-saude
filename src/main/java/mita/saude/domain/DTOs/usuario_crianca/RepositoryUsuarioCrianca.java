package mita.saude.domain.DTOs.usuario_crianca;

import mita.saude.domain.entities.usuario_crianca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUsuarioCrianca extends JpaRepository<usuario_crianca, Long> {
    Page<usuario_crianca> findAll(Pageable paginacao);
}
