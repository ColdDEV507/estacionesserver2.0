/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.estacionesserver.repository;

import com.estacionesserver.model.History;
import com.jmoordb.core.annotation.repository.Count;
import com.jmoordb.core.annotation.repository.Lookup;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.model.Search;
import com.jmoordb.core.repository.CrudRepository;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Repository(entity = History.class, database = "{mongodb.databasehistory")
public interface HistoryRepository extends CrudRepository<History, Long>{
           @Lookup
public List<History> lookup(Search search);
  @Count()
    public Long count(Search... search);
}
