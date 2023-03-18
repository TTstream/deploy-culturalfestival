package cultural.festival.repository;

import cultural.festival.entity.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApiRepository extends JpaRepository<Api,Long> {
    
    // 2021년 이후의 데이터들을 축제시작일 기준으로 내림차순해서 출력(즉, 최신 데이터부터 출력)
    @Query("select i from Api i where i.fstvlStartDate>=2021 order by i.fstvlStartDate desc")
    List<Api> fstvlStart2021_();
}
