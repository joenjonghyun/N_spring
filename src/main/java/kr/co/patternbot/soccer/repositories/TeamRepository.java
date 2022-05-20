package kr.co.patternbot.soccer.repositories;

import kr.co.patternbot.soccer.domains.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

interface TeamCustomRepository{
    // 000. 팀의 전화번호와 팩스번호를 수정하시오
    @Query(value="update team t set t.tel = :tel, t.fax = :fax where t.teamNo = :teamNo",
            nativeQuery = true)
    int update(@Param("tel") String tel, @Param("fax") String fax);
    // 001. 전체 축구팀 목록을  팀이름 오름차순으로 출력하시오
    @Query (value = "select t.teamName as teamName from Team t order by t.teamName asc",
            nativeQuery = true)
    List<String> findTeamNamesAsc();

    // 005-2. 수원팀의 ID는 ?
    @Query(value = "select t.teamId from Team t where t.regionName like 수원",
            nativeQuery = true)
    Optional<Team> findById();
}
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
