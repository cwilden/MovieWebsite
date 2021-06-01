package com.dal;

import java.util.ArrayList;

public interface DAOInterface<T> {
	public ArrayList<T> getAll();

	public T getById(int id);
	
	public void update(T obj);
	
	public T insert(T obj);
	
	public void deleteById(int id);
}
