package cultural.festival.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class DataExchangeController {

    @GetMapping("/yearSelect")
    public String yearSelect(@RequestParam("selectValue") int selectValue){
        System.out.println(selectValue);
        return "test";
    }
}
