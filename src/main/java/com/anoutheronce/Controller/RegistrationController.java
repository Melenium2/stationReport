package com.anoutheronce.Controller;

import com.anoutheronce.Entitys.MeteoUser;
import com.anoutheronce.Entitys.Repository.UserRepo;
import com.anoutheronce.Entitys.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController
{
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registrationPage()
    {
        return "new/registration";
    }

    @PostMapping("/registration")
    public String addNewUser(MeteoUser user, Map<String, Object> model)
    {
        MeteoUser userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb != null)
        {
            model.put("message", "User already exist!");
            return "new/registration";
        }

        if (    user.getUsername().isEmpty() ||
                user.getUsername().length() < 1 ||
                user.getPassword().isEmpty() ||
                user.getPassword().length() < 1)
        {
            model.put("message", "Invalid data");
            return "new/registration";
        }

        user.setActive(true);
        user.setUserRoles(Collections.singleton(UserRole.USER));
        userRepo.save(user);

        return "redirect:new/login";
    }


}
