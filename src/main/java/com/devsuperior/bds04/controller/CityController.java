package com.devsuperior.bds04.controller;

import com.devsuperior.bds04.dto.CityDto;
import com.devsuperior.bds04.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<CityDto>> findAll(){
        List<CityDto> cities = cityService.findAll();
        return ResponseEntity.ok(cities);
    }

    @PostMapping
    public ResponseEntity<CityDto> save(@Valid @RequestBody CityDto dto){
        dto = cityService.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
