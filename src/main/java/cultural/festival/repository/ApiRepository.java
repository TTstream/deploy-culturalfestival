package cultural.festival.repository;

import cultural.festival.entity.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApiRepository extends JpaRepository<Api,Long> {
    
    // 현재년도 이후의 데이터들을 축제시작일 기준으로 내림차순해서 출력(즉, 최신 데이터부터 출력)
    @Query("select i from Api i where i.fstvlStartDate>=:year order by i.fstvlStartDate asc")
    List<Api> fstvlStartcurrent(@Param("year") String year);

    // 동적으로 들어오는 2021,2022,2023,2024년 데이터들을 축제시작일 기준으로 내림차순해서 출력(즉, 최신 데이터부터 출력)
    @Query("select i from Api i where i.fstvlStartDate like %:year% order by i.fstvlStartDate desc")
    List<Api> fstvlStartDynamic(@Param("year") String year);

}
