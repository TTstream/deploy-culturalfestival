package cultural.festival.controller;

import cultural.festival.entity.Api;
import cultural.festival.repository.ApiRepository;
import cultural.festival.service.ApiService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class DataExchangeController {
    /*
    private final ApiService apiService;

    @GetMapping("/yearSelect") // selectValue은 화면에서 선택한 년도
    public Object yearSelect(@RequestParam("selectValue") String selectValue){
        List<Api> apiDataList;

        if (selectValue.equals("0")){
            apiDataList=apiService.getApiData();
        }else {
            apiDataList=apiService.getApiDynamicData(selectValue);
        }

        return apiDataList;

    }

     */
}
