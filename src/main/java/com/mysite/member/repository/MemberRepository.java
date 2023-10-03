package com.mysite.member.repository;

import com.mysite.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository 상속받는데 첫 번째 인자를 어떤 entity 클래스를 다룰 것인지, 두 번째 인자를 entity 클래스의 pk(column의 타입)가 어떤 타입인지
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 이메일로 회원 정보 조회(select * from member_table where member_email=?)
    Optional<MemberEntity> findByMemberEmail(String memberEmail);
}
