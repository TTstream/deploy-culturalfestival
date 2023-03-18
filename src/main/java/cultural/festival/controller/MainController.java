package cultural.festival.controller;

import cultural.festival.entity.Api;
import cultural.festival.repository.ApiRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController{

    private final ApiRepository apiRepository;
    @GetMapping("/publicData")
    public String index(Model model){

        // 2021년 이후의 데이터를 내림차순으로 출력(최신 데이터부터 출력)
        List<Api> apiDataList=apiRepository.fstvlStart2021_();
        model.addAttribute("apiDataList",apiDataList);
        return "index";

    }

}
