package com.devsuperior.bds04.service;

import com.devsuperior.bds04.dto.EventDto;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repository.CityRepository;
import com.devsuperior.bds04.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CityRepository cityRepository;

    @Transactional(readOnly = true)
    public Page<EventDto> findAllPaged(Pageable pageable){
        Page<Event> list = eventRepository.findAll(pageable);
        return list.map(EventDto::new);
    }

    @Transactional
    public EventDto insert(EventDto dto){
        Event entity = new Event();
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());
        entity.setCity(cityRepository.getOne(dto.getCityId()));
        eventRepository.save(entity);
        return new EventDto(entity);
    }
}
