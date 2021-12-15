package com.devsuperior.bds04.service;

import com.devsuperior.bds04.dto.CityDto;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional(readOnly = true)
    public List<CityDto> findAll(){
        List<City> cities = cityRepository.findAll(Sort.by("name"));
        return cities.stream().map(CityDto::new).collect(Collectors.toList());
    }

    @Transactional
    public CityDto insert(CityDto dto){
        City entity = new City();
        entity.setName(dto.getName());
        entity = cityRepository.save(entity);
        return new CityDto(entity);
    }
}
