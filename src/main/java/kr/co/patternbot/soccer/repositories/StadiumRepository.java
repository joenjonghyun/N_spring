package kr.co.patternbot.soccer.repositories;

import kr.co.patternbot.soccer.domains.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

interface StadiumCustomRepository{
    // 000. 스타디움의 전화번호와 팩스번호를 수정하시오
    @Query(value="update stadium s set s.tel = :tel, s.fax = :fax where s.stadiumno = :stadiumno",
            nativeQuery = true)
    int update(@Param("tel") String tel, @Param("fax") String fax);}
@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {

}
