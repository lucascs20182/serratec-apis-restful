// os repositórios são uma conexão entre a aplicação e o banco
// que expõe métodos principais de acesso e recuperação de informações do banco
// como por ex. getAll e getById

package org.serratec.backend.projeto05.repositories;

import org.serratec.backend.projeto05.entities.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

}
