package com.example.service;

import java.util.List;

public interface GenericService<T> {

	public T insert(T t) throws Exception ;
	public T fetch(Long id)throws Exception;
	
}
