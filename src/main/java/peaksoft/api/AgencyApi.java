package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Agency;
import peaksoft.service.AgencyService;

@Controller
@RequestMapping("/agencies")
@RequiredArgsConstructor
public class AgencyApi {


    private final AgencyService agencyService;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("newAgency", new Agency());
        return "/newAgency";
    }

    @PostMapping("/saveAgency")
    public String saveAgency(@ModelAttribute("newAgency")  Agency agency) {
        agencyService.saveAgency(agency);
        return "redirect:/agencies/getAll";
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("agencies",agencyService.getAllAgency());
        return "/agencyMainPage";
    }



    @GetMapping("/update/{agencyId}")
    public String updateAgency(@PathVariable("agencyId") Long agencyId,Model model) {
        Agency agency = agencyService.getById(agencyId);
        model.addAttribute("agencies", agency);
        return "/agencyUpdate";
    }


    @PostMapping("/editUpdate/{agencyId}")
    public String editUpdate(@ModelAttribute("newAgency") Agency agency,
                             @PathVariable("agencyId") Long agencyId) {
        agencyService.updateAgencyById(agencyId, agency);
        return "redirect:/agencies/getAll";
    }


    @PostMapping("/delete/{agencyId}")
    public String deleteAgency(@PathVariable("agencyId") Long agencyId) {
        agencyService.deleteById(agencyId);
        return "redirect:/agencies/getAll";
    }







}
