package com.incremental.ria.service.auth;

import com.incremental.ria.repository.model.AuthSession;
import com.incremental.ria.repository.model.User;

public interface AuthService {

    AuthSession login(String base64);

    User validateToken(String token);
}
