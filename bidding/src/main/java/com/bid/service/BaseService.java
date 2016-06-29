package com.bid.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.bid.api.model.AbstractDto;
import com.bid.domain.AbstractEntity;

public abstract class BaseService {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	private static String dtoPackage = packageForClass(AbstractDto.class);
	private static String entityPackage = packageForClass(AbstractEntity.class);
	private static String dtoSuffix = "Dto";

	@Autowired
	ModelMapper modelMapper;

	// dto
	public <D extends AbstractDto, E extends AbstractEntity> D toDto(E entity) {
		return modelMapper.map(entity, getDtoClass(entity.getClass()));
	}

	public <D extends AbstractDto, E extends AbstractEntity> List<D> toDtoList(List<E> entities) {
		if (CollectionUtils.isEmpty(entities)) {
			return new ArrayList<>();
		} else {
			return toDtoList(entities, getDtoClass(entities.get(0).getClass()));
		}
	}

	public <D extends AbstractDto, E extends AbstractEntity> List<D> toDtoList(List<E> entities, Class<D> clazz) {
		List<D> dtos = new ArrayList<>();
		if (entities != null) {
			for (E entity : entities) {
				dtos.add(toDto(entity, clazz));
			}
		}
		return dtos;
	}

	public <D extends AbstractDto, E extends AbstractEntity> D toDto(E entity, Class<D> clazz) {
		return modelMapper.map(entity, clazz);
	}

	// entity
	public <E extends AbstractEntity, D extends AbstractDto> E toEntity(D dto) {
		return modelMapper.map(dto, getEntityClass(dto.getClass()));
	}

	public <E extends AbstractEntity, D extends AbstractDto> List<E> toEntityList(List<D> dtos) {
		if (CollectionUtils.isEmpty(dtos)) {
			return new ArrayList<>();
		} else {
			return toEntityList(dtos, getEntityClass(dtos.get(0).getClass()));
		}
	}

	public <E extends AbstractEntity, D extends AbstractDto> List<E> toEntityList(List<D> dtos, Class<E> clazz) {
		List<E> entities = new ArrayList<>();
		if (dtos != null) {
			for (D dto : dtos) {
				entities.add(toEntity(dto, clazz));
			}
		}
		return entities;
	}

	public <E extends AbstractEntity, D extends AbstractDto> E toEntity(D dto, Class<E> clazz) {
		return modelMapper.map(dto, clazz);
	}

	@SuppressWarnings("unchecked")
	private <D extends AbstractDto, E extends AbstractEntity> Class<D> getDtoClass(Class<E> clazz) {
		try {
			return (Class<D>) Class.forName(dtoPackage + clazz.getSimpleName() + dtoSuffix);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException();
		}
	}

	@SuppressWarnings("unchecked")
	private <D extends AbstractDto, E extends AbstractEntity> Class<E> getEntityClass(Class<D> clazz) {
		try {
			String name = clazz.getSimpleName();
			return (Class<E>) Class
					.forName(entityPackage + clazz.getSimpleName().substring(0, name.length() - dtoSuffix.length()));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException();
		}
	}

	private static String packageForClass(Class<?> clazz) {
		return clazz.getPackage().getName() + ".";
	}

}
