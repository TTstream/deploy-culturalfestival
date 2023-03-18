package cultural.festival.service;

import cultural.festival.dto.ApiDto;
import cultural.festival.entity.Api;
import cultural.festival.repository.ApiRepository;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ApiService {

    private final ApiRepository apiRepository;

    public void apiDataInsert(String jsonData){
        try{

            JSONParser jsonParser=new JSONParser();//json파싱객체 생성
            JSONObject jsonObject= (JSONObject) jsonParser.parse(jsonData); //json객체로 파서를 통해 저장

            /*데이터 분해 단계*/

            //1.parseResponse변수에 response 내부의 데이터 넣기
            JSONObject parseResponse= (JSONObject) jsonObject.get("response");

            //2.parseBody변수에 body 내부의 데이터 넣기
            JSONObject parseBody= (JSONObject) parseResponse.get("body");

            //3.parseBody의 items는 [ ] 배열의 형태이기 때문에 JOSNArray 사용
            JSONArray items= (JSONArray) parseBody.get("items");

            /*데이터 삽입*/
            JSONObject jObj; //json객체 생성

            for(int i=0;i<items.size();i++){
                jObj= (JSONObject) items.get(i);

                //빌더 패턴으로 값 삽입
                Api apiData=Api.builder()
                        .fstvlNm(jObj.get("fstvlNm").toString())
                        .opar(jObj.get("opar").toString())
                        .fstvlStartDate(jObj.get("fstvlStartDate").toString())
                        .fstvlEndDate(jObj.get("fstvlEndDate").toString())
                        .fstvlCo(jObj.get("fstvlCo").toString())
                        .mnnst(jObj.get("mnnst").toString())
                        .auspcInstt(jObj.get("auspcInstt").toString())
                        .phoneNumber(jObj.get("phoneNumber").toString())
                        .homepageUrl(jObj.get("homepageUrl").toString())
                        .relateInfo(jObj.get("relateInfo").toString())
                        .rdnmadr(jObj.get("rdnmadr").toString())
                        .lnmadr(jObj.get("lnmadr").toString())
                        .latitude(jObj.get("latitude").toString())
                        .longitude(jObj.get("longitude").toString())
                        .referenceDate(jObj.get("referenceDate").toString())
                        .build();
                apiRepository.save(apiData);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //전체 데이터 index페이지로 전달
    public List<Api> getApiData() {
        return apiRepository.fstvlStart2021_();
    }

}
