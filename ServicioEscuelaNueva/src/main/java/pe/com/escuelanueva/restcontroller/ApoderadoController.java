/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.escuelanueva.restcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.escuelanueva.entity.ApoderadoEntity;

import pe.com.escuelanueva.service.ApoderadoService;


@RestController
@RequestMapping("/apoderado")
public class ApoderadoController {
    @Autowired
    private ApoderadoService apoderadoService;    
    
    //getmapping permite obtener valores
    @GetMapping
    public List<ApoderadoEntity> findAll(){
        return apoderadoService.findAll();
    }
    
    @GetMapping("/custom")
    public List<ApoderadoEntity> findAllCustom(){
        return apoderadoService.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<ApoderadoEntity> findById(@PathVariable Long id){
        return apoderadoService.findById(id);
    }
    @PostMapping
    public ApoderadoEntity add(@RequestBody ApoderadoEntity d){
        return apoderadoService.add(d);
    }
    
    @PutMapping("/{id}")
    public ApoderadoEntity update(@PathVariable long id,@RequestBody ApoderadoEntity d){
        d.setCodigo(id);
        return apoderadoService.update(d);
    }
    @DeleteMapping("/delete/{id}")
    public ApoderadoEntity delete(@PathVariable Long id) {
	ApoderadoEntity objapo=new ApoderadoEntity();
        objapo.setEstado(false);
        return apoderadoService.delete(ApoderadoEntity.builder().codigo(id).build());
        
	}
    
}
