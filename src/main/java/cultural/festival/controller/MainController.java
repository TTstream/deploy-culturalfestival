package cultural.festival.controller;

import cultural.festival.dto.ApiDto;
import cultural.festival.entity.Api;
import cultural.festival.service.ApiService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class MainController{

    private final ApiService apiService;

    @Data
    @AllArgsConstructor //데이터 값만 보내면 배열상태인데 이 값을 객체로 묶어서 반환해줘야 확장성이 높아진다.
    static class Result<T>{
        private int count;
        private T data;

    }

    @GetMapping("/")
    public String index(Model model){

        // 현재 년도 데이터를 내림차순으로 출력(최신 데이터부터 출력)
        LocalDate now=LocalDate.now();
        String year=Integer.toString(now.getYear()); // 현재 년도 잘 받아옴

        // entity에서 받아온 데이터 DTO로 변환
        List<Api> apiDataList=apiService.getApiData(year);
        List<ApiDto> collect=apiDataList.stream()
                .map(m-> new ApiDto(m.getFstvlNm(),m.getFstvlStartDate(),m.getFstvlEndDate(), m.getRdnmadr(), m.getLnmadr(),m.getFstvlCo(),
                        m.getLatitude(),m.getLongitude()))
                .collect(Collectors.toList());

        model.addAttribute("collect",new Result(collect.size(),collect));

        return "index";
    }

}
