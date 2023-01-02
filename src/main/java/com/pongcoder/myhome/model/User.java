package com.pongcoder.myhome.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Boolean enabled;

    //양방향 매핑
    @ManyToMany
    @JoinTable(
            name = "user_role", //조인테이블
            joinColumns = @JoinColumn(name = "user_id"), //user_role의 user_id
            inverseJoinColumns = @JoinColumn(name = "role_id")) //user_role의 role_id

    //멤버변수 userropo를 이용해서 조회를 하게 되면 user에 해당하는 권한이 조회된다.
    private List<Role> roles = new ArrayList<>();



}
