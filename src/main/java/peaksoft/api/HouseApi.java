package peaksoft.api;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Agency;
import peaksoft.entity.House;
import peaksoft.service.AgencyService;
import peaksoft.service.HouseService;

import java.util.List;

@Controller
@RequestMapping("/houses")
@RequiredArgsConstructor
@Transactional
@Slf4j
public class HouseApi {


    private final HouseService houseService;
    private final AgencyService agencyService;


    @GetMapping("/getAll")
    public String getAllHouses(Model model) {
        model.addAttribute("houses",houseService.getAllHouse());
        return "/houseMainPage";
    }


    @GetMapping("/create/{agencyId}")
    public String createHouse(@PathVariable Long agencyId, Model model) {
        Agency agency = agencyService.getById(agencyId);
        model.addAttribute("newHouse", new House());
        model.addAttribute("agency", agency);
        return "/newHouse";
    }

    @PostMapping("/saveHouse/{agencyId}")
    public String saveHouse(@PathVariable("agencyId") Long agencyId, @ModelAttribute("newHouse") House newHouse) {
        Agency agency = agencyService.getById(agencyId);
        houseService.saveHouse(agency.getId(), newHouse);
        return "redirect:/houses/getAll";
    }

    @GetMapping("/findBYId/{agencyId}")
    public String findHouseById(@PathVariable("agencyId") Long agencyId, Model model) {
        Agency agency = agencyService.getById(agencyId);

        // Добавляем агентство и его дома в модель
        model.addAttribute("agency", agency);
        model.addAttribute("houses", agency.getHouse());
        log.info("Houses: {}", agency.getHouse());
        return "/findHouse";
    }







}
