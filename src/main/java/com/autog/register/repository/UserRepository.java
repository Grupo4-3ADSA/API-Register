package com.autog.register.repository;

import com.autog.register.entity.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Gestor, Long> {

    Gestor findByLoginAndPassword(String login, String senha);

}
