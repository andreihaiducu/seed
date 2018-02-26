package com.incremental.ria.service.auth;

import com.incremental.ria.repository.db.AuthSessionRepository;
import com.incremental.ria.repository.db.UserRepository;
import com.incremental.ria.repository.model.AuthSession;
import com.incremental.ria.repository.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthSessionRepository sessionRepository;
    private UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(AuthSessionRepository sessionRepository, UserRepository userRepository) {
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AuthSession login(String base64) {
        String decrypted = ""; // TODO decrypt base64 string
        String[] userAndPass = decrypted.split(":");
        String username = userAndPass[0];
        String pass = userAndPass[1];

        User user = userRepository.findByUsername(username);

        if (user == null) {
            // TODO throw exception
        }

        String hashedPassword = ""; // TODO: hash pass

        if (!user.getPassword().equals(hashedPassword)) {
            // TODO throw exception
        }

        // TODO: check for existing session

        String token = ""; // TODO: generate a token hash
        AuthSession session = new AuthSession();
        session.setToken(token);
        session.setUserId(user.getId());
        session.setExpireTime(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000);

        session = sessionRepository.save(session);
        return session;
    }

    @Override
    public User validateToken(String token) {
        // TODO: Check if session is expired
        return userRepository.findOne(sessionRepository.findByToken(token).getUserId());
    }
}
