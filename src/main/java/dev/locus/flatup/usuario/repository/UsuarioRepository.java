package dev.locus.flatup.usuario.repository;

import java.util.Optional;

import dev.locus.flatup.usuario.model.UsuarioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.locus.flatup.usuario.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Query(value = "SELECT u FROM Usuario u where u.email = :email and u.googleUid = :googleuid")
    Optional<Usuario> findByEmailAndGoogleUid(@Param("email") String email, @Param("googleuid") String googleUid);
}
