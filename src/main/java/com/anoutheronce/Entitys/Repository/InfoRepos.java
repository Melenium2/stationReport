package com.anoutheronce.Entitys.Repository;

import com.anoutheronce.Entitys.MeteoInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface InfoRepos extends CrudRepository<MeteoInfo, Long>
{
    @Modifying
    @Transactional
    void deleteByMeteoName(String meteoName);

    MeteoInfo findByMeteoName(String meteoName);
}
