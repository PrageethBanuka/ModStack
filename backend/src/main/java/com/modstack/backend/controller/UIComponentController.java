package com.modstack.backend.controller;

import com.modstack.backend.model.UIComponent;
import com.modstack.backend.service.UIComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/components")
@CrossOrigin(origins = "*")
public class UIComponentController {

    @Autowired
    private UIComponentService service;

    @GetMapping
    public List<UIComponent> getAll(){
        return service.getAll();
    }

    @PostMapping
    public UIComponent create(@RequestBody UIComponent component){
        return service.create(component);
    }

    @PutMapping("/{id}")
    public UIComponent update(@PathVariable String id,@RequestBody UIComponent component){
        return service.update(id, component);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
