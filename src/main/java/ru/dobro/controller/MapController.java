package ru.dobro.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dobro.beans.Shop;
import ru.dobro.constants.MapConstant;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/map")
@PreAuthorize("hasAuthority('ADMIN')")
public class MapController {


    @GetMapping
    public String showShopsAsTable(Model model) {

        List list = new ArrayList<Shop>();
        for (int i = 0; i < MapConstant.SHOP_ADDRESS_LOCATIONS.length; i++) {
            list.add(new Shop(i + 1, MapConstant.SHOP_ADDRESS_LOCATIONS[i]));
        }
        model.addAttribute("shops", list);
        return "map/tables/printAllShops";
    }

    @GetMapping("/useful_links")
    public String showUsefulLinksAsTable(Model model) {

//        List list = new ArrayList<Shop>();
//        for (int i = 0; i < MapConstant.SHOP_ADDRESS_LOCATIONS.length; i++) {
//            list.add(new Shop(i + 1, MapConstant.SHOP_ADDRESS_LOCATIONS[i]));
//        }
//        model.addAttribute("shops", list);
        return "map/other/links";
    }


}
