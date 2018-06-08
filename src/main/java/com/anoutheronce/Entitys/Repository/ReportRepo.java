package com.anoutheronce.Entitys.Repository;

import com.anoutheronce.Entitys.ReportStructureStorage;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepo extends CrudRepository<ReportStructureStorage, Long>
{

}
