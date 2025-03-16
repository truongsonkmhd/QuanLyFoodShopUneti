package DAO;

import java.util.ArrayList;

/**
 *
 * @author truongs
 */
public interface DAOinterface<T> {
    public int insert(T t);
    
    public int update(T t);
    
    public int delete(String t);
    
    public ArrayList<T> selectAll();
    
    public T selectById(String t);
    
    
    int getAutoIncrement();
}
