/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.business.Tiquete;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JPOH97
 */
@Local
public interface TiqueteFacadeLocal {

    void create(Tiquete tiquete);

    void edit(Tiquete tiquete);

    void remove(Tiquete tiquete);

    Tiquete find(Object id);

    List<Tiquete> findAvalibles(Object id);
    
    List<Tiquete> findAll();

    List<Tiquete> findRange(int[] range);
    
    Tiquete finfByCodigo(String codigo);

    int count();
    
}
