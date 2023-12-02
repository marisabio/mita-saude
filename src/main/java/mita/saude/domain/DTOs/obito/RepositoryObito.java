package mita.saude.domain.DTOs.obito;


import mita.saude.domain.entities.obito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryObito extends JpaRepository<obito, Long> {
    Page<obito> findAll(Pageable paginacao);
}
