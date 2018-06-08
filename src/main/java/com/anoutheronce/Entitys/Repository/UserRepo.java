package com.anoutheronce.Entitys.Repository;

import com.anoutheronce.Entitys.MeteoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<MeteoUser, Long>
{
    MeteoUser findByUsername(String username);
}
