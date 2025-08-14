package com.modstack.backend.service;

import com.modstack.backend.exceptions.ResourceNotFoundException;
import com.modstack.backend.model.UIComponent;
import com.modstack.backend.repository.UIComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UIComponentService {

    @Autowired
    private UIComponentRepository repository;

    public List<UIComponent> getAll() {
        return repository.findAll();
    }

    public UIComponent create(UIComponent component) {
        return repository.save(component);
    }

    public UIComponent update(String id, UIComponent component) {
        return repository.findById(id)
                .map(existing -> {
                    component.setId(id); // Overwrite the ID to ensure consistency
                    return repository.save(component);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Component not found with ID: " + id));
    }

    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Component not found with ID: " + id);
        }
        repository.deleteById(id);
    }
    public UIComponent getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Component not found with ID: " + id));    
    }
}