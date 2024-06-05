package br.com.seasaver.aplication.service;
import br.com.seasaver.aplication.model.User;
import br.com.seasaver.aplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsurious() {
        return userRepository.findAll();
    }

    public Optional<User> getUsuriousById(Long id) {
        return userRepository.findById(id);
    }

    public User createUsuario(User user) {
        return userRepository.save(user);
    }

    public User updateUsuario(Long id, User usuarioDetails) {
        User usuario = userRepository.findById(id).orElseThrow();
        usuario.setCpf(usuarioDetails.getCpf());
        usuario.setNome(usuarioDetails.getNome());
        usuario.setEmail(usuarioDetails.getEmail());
        usuario.setSenha(usuarioDetails.getSenha());
        usuario.setLocalizacao(usuarioDetails.getLocalizacao());
        return userRepository.save(usuario);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

