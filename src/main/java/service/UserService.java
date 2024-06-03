package service;
import model.User;
import repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsuarios() {
        return userRepository.findAll();
    }

    public Optional<User> getUsuarioById(Long id) {
        return UserRepository.findById(id);
    }

    public User createUsuario(User usuario) {
        return UserRepository.save(usuario);
    }

    public User updateUsuario(Long id, User usuarioDetails) {
        User usuario = UserRepository.findById(id).orElseThrow();
        usuario.setCpf(usuarioDetails.getCpf());
        usuario.setNome(usuarioDetails.getNome());
        usuario.setEmail(usuarioDetails.getEmail());
        usuario.setSenha(usuarioDetails.getSenha());
        usuario.setLocalizacao(usuarioDetails.getLocalizacao());
        return UserRepository.save(usuario);
    }

    public void deleteUser(Long id) {
        UserRepository.deleteById(id);
    }
}

