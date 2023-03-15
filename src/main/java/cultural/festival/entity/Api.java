package cultural.festival.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "api")
@Getter @Setter
@ToString
public class Api {
    /* ex)
    fstvlNm: "강원대학교 산학협력단 K-Digital Training 제2기 교육생 모집",
    opar: "강원대학교 춘천캠퍼스",
    fstvlStartDate: "2022-10-04",
    fstvlEndDate: "2023-03-13",
    fstvlCo: "언리얼엔진 기반 메타버스 개발자 양성 과정 교육생 모집",
    mnnst: "고용노동부",
    auspcInstt: "강원대학교 산학협력단",
    suprtInstt: "",
    phoneNumber: "033-250-8945",
    homepageUrl: "https://www.cccf.or.kr/Home/H40000/H40400/boardView?board_key=10763",
    relateInfo: "행사+축제",
    rdnmadr: "강원도 춘천시 강원대학길 1",
    lnmadr: "강원도 춘천시 효자동 192-1",
    latitude: "37.86802431",
    longitude: "127.74838741",
    referenceDate: "2023-01-12",
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fstvlNm; // 축제명
    private String opar; // 개최장소
    private String fstvlStartDate; // 축제시작일시
    private String fstvlEndDate; // 축제종료일자
    @Column(length = 1000)
    private String fstvlCo; // 축제내용
    private String mnnst; // 주관기관
    private String auspcInstt; // 주최기관
    private String phoneNumber; // 전화번호
    private String homepageUrl; // 홈페이지주소
    private String relateInfo; // 관련정보
    private String rdnmadr; // 소재지도로명주소
    private String lnmadr; // 소재지지번주소
    private String latitude; // 위도
    private String longitude; // 경도
    private String referenceDate; //데이터기준일자

    @Builder
    public Api(String fstvlNm, String opar, String fstvlStartDate, String fstvlEndDate, String fstvlCo, String mnnst, String auspcInstt, String phoneNumber,
               String homepageUrl,String relateInfo, String rdnmadr, String lnmadr, String latitude, String longitude, String referenceDate){
        this.fstvlNm = fstvlNm;
        this.opar = opar;
        this.fstvlStartDate = fstvlStartDate;
        this.fstvlEndDate = fstvlEndDate;
        this.fstvlCo=fstvlCo;
        this.mnnst=mnnst;
        this.auspcInstt=auspcInstt;
        this.phoneNumber=phoneNumber;
        this.homepageUrl=homepageUrl;
        this.relateInfo=relateInfo;
        this.rdnmadr=rdnmadr;
        this.lnmadr=lnmadr;
        this.latitude=latitude;
        this.longitude=longitude;
        this.referenceDate=referenceDate;
    }

}
