package ru.dobro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dobro.constants.MapConstant;
import ru.dobro.domain.Message;
import ru.dobro.domain.User;
import ru.dobro.repos.MessageRepo;

import java.time.LocalDateTime;
import java.util.Map;


//@Controller
public class MapController {

//    @GetMapping("/map")
    public String showShops(Map<String, Object> model) {
        model.put("shops", MapConstant.SHOP_ADDRESS_LOCATIONS);
        return "shohs_on_map";
    }

}
