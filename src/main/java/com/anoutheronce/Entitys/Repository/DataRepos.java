package com.anoutheronce.Entitys.Repository;

import com.anoutheronce.Entitys.MeteoData;
import org.springframework.data.repository.CrudRepository;

public interface DataRepos extends CrudRepository<MeteoData, Long>
{

}
