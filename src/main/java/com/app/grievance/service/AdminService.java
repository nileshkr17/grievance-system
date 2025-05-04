package com.app.grievance.service;

import com.app.grievance.model.Role;
import com.app.grievance.model.Role.RoleName;
import com.app.grievance.model.RoleMapping;
import com.app.grievance.model.User;
import com.app.grievance.repository.RoleMappingRepository;
import com.app.grievance.repository.RoleRepository;
import com.app.grievance.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMappingRepository roleMappingRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword()); // encode this in real apps!
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public RoleMapping assignRoleToUser(Long userId, RoleName roleName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        RoleMapping mapping = new RoleMapping();
        mapping.setUser(user);
        mapping.setRole(role);
        return roleMappingRepository.save(mapping);
    }
}
