package cultural.festival.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter //getter,setter 안 붙이면 프론트에서 값을 가져오지 못함
public class ApiDto {

    private String fstvlNm; //축제명

    private String fstvlStartDate; //축제시작일

    private String fstvlEndDate; //축제종료일

    private String rdnmadr; // 소재지도로명주소

    private String lnmadr; // 소재지지번주소

    private String fstvlCo; // 축제내용
}
