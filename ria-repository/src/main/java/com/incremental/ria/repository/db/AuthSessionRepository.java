package com.incremental.ria.repository.db;

import com.incremental.ria.repository.model.AuthSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthSessionRepository extends JpaRepository<AuthSession, Long> {

    AuthSession findByToken(String token);
}
