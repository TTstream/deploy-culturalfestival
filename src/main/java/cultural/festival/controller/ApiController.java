package cultural.festival.controller;

import cultural.festival.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;

    String API_KEY="bsz1Z2%2FEJ2Aixom%2BFqbT%2B3Un7a56GuhvDoUcngvXatWX1e7XhdI4BKB0nYAT2FmiaUgpFUFOajgbm6Vw0CErnA%3D%3D";
    String url="http://api.data.go.kr/openapi/tn_pubr_public_cltur_fstvl_api?";

    @GetMapping("/api")
    public String callApi() throws Exception{
        StringBuilder result=new StringBuilder();

        /* 한 페이지에 numOfRows개의 데이터를 받아오기 */
        String urlStr=url+"&"+
                "serviceKey="+API_KEY+"&"+
                "pageNo=1&"+
                "numOfRows=102&"+
                "type=json";
        URL url=new URL(urlStr);

        HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod(("GET"));;

        BufferedReader br;
        br=new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));

        String returnLine;
        while((returnLine=br.readLine())!=null){
            result.append(returnLine+"\n\r");
        }
        urlConnection.disconnect();

        // JSONData전달
        apiService.apiDataInsert(result.toString());
        
        return result.toString();
    }

}
