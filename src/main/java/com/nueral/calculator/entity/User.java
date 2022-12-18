package com.nueral.calculator.entity;

import com.nueral.calculator.types.Role;
import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor
@SequenceGenerator(name = "USER_IDX_GENERATOR" , sequenceName = "USER_SEQ", allocationSize = 1) // 시퀀스 생성
@Table(name = "users") // 테이블 네임 선언
@Entity // 엔티티 선언
@Setter
public class User {
    @Id //PRIMARY_KEY
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "USER_IDX_GENERATOR"
    ) // 위에서 정의한 SEQ 를 사용하겠다.
    @Column(name = "USER_ID") // 컬럼의 이름
    private Long id; // 회원 번호
    @Enumerated(EnumType.STRING)
    private Role role; // 권한부여
    @Column(length = 50 , unique = true , nullable = false) //unique = true 속성으로 값이 중복되지 못하게함
    private String username; //아이디
    @Column(length = 100 , nullable = false)
    private String password; //비밀번호

    @Builder
    public User(
            String username , String password ,
            Long id , Role role
    ){
        this.password = password;
        this.username = username;
        this.role = role;
    }
}
