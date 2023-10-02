package com.mysite.member.dto;

import lombok.*;

// save.html의 name과 DTO 객체의 필드가 동일하면 알아서 DTO 객체를 하나 만들어서 Setter 호출 후 각각 알아서 담아준다.

@Getter
@Setter
// 기본 생성자 자동으로 생성
@NoArgsConstructor
// 필드를 매개변수로 하는 생성자 생성
@AllArgsConstructor
// DTO 객체가 갖고 있는 필드값을 출력할 때 사용
@ToString
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
