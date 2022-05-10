package kr.co.patternbot.common.dataStructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MemberCRUD {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        MemberService service = new MemberServiceImpl();
        while (true) {
            System.out.println("0.exit 1.sava 2.update 3.delete 4.findById 5.findByName 6.findAll 7.count 8.existsById 9.clear");//네이밍컨벤션을맞춤
            switch (s.next()) {
                case "0":
                    return;
                case "1":
                    Member hong = new Member.Builder("hong")
                            .email("hong@test.com")
                            .password("1")
                            .name("홍")
                            .phone("010-1010-1010")
                            .profileImg("hong.jpg")
                            .builder();
                    service.save(hong);
                    break;
                case "2":
                    break;
                case "3":
                    Member temp = new Member();
                    temp.setUserid("hong");
                    service.delete(temp);
                    break;
                case "4":
                    Member m = new Member();
                    m.setUserid(m.userid);
                    if (service.findById(m.userid)==null){
                        System.out.println("없음");
                    }else {
                        System.out.println("있음");
                    }

                    break;
                case "5":
                    break;
                case "6":
                    System.out.println("총 회원 목록 : "+service.findAll());
                    break;
                case "7":
                    System.out.println("총 회원 수 : "+service.count());
                    break;
                case "8":
                    break;
                case "9":
                    service.clear();
                    break;
                default:
                    break;
            }
        }
    }

    @Data @NoArgsConstructor
    static class Member {
        protected String userid, name, password, profileImg, phone, email;

        public Member(Builder builder) {
            this.userid = builder.userid;
            this.name = builder.name;
            this.password = builder.password;
            this.profileImg = builder.profileImg;
            this.phone = builder.phone;
            this.email = builder.email;
        }

        static class Builder{
            private String userid, name, password, profileImg, phone, email;
            public Builder(String userid){this.userid=userid;}
            public Builder name(String userid){this.name=name; return this;}
            public Builder password(String userid){this.password=password; return this;}
            public Builder profileImg(String userid){this.profileImg=profileImg; return this;}
            public Builder phone(String userid){this.phone=phone; return this;}
            public Builder email(String userid){this.email=email; return this;}
            Member builder(){return new Member(this);}
        }

        @Override
        public String toString() {
            return String.format("[사용자 스펙] userid: %s, name: %s, password: %s, profileImg: %s, phone: %s, email: %s",
                    userid, name, password, profileImg, phone, email);
        }
    }

    interface MemberService {
        void save(Member member);
        void update(Member member);
        void delete(Member member);
        Member findById(String id);
        List<Member> findByName(String name);
        List<Member> findAll();
        int count();
        boolean existsById(String id);
        void clear();


    }

    @Service
    static class MemberServiceImpl implements MemberService {
        private Map<String, Member> map;
        MemberServiceImpl(){
            map = new HashMap<>();
        }

        @Override
        public void save(Member member) {
            map.put(member.getUserid(), member);
        }

        @Override
        public void update(Member member) {
            map.replace(member.getUserid(), member);
        }

        @Override
        public void delete(Member member) {
            map.remove(member.getUserid());
        }

        @Override
        public Member findById(String id) {
            return map.get(id);
        }

        @Override
        public List<Member> findByName(String name) {
            return (List<Member>) map.get(name);
        }

        @Override
        public List<Member> findAll() {
            return (List<Member>) map.values();
        }

        @Override
        public int count() {
            return map.size();
        }

        @Override
        public boolean existsById(String id) {
            return map.containsKey(id);
        }

        @Override
        public void clear() {
            map.clear();
        }
    }
}
