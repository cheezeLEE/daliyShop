package com.shopping.daliyShop.user.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class UserVO implements UserDetails {

    private int usrNo;
    private String usrId;
    private String usrPw;
    private String usrName;
    private String usrMblNo;
    private String usrAddr;
    private String usrRoad;
    private String usrPostal;
    private String usrAddrDetail;
    private String usrBirth;
    private LocalDateTime usrRegDate;
    private LocalDateTime usrModDate;
    private String usrRank;
    private char usrWithdrawYn;

    private List<AuthVO> authList;

    // 계정의 권한 목록 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (AuthVO auth : authList) {
            authorities.add(new SimpleGrantedAuthority(auth.getUsrAuth()));
        }

        return authorities;
    }

    // 계정의 비밀번호를 리턴
    @Override
    public String getPassword() {
        return usrPw;
    }

    // 계정의 고유한 값을 리턴 (DB PK값, 중복이 없는 이메일 값 등) : 여기서는 사용자 ID
    @Override
    public String getUsername() {
        return usrId;
    }

    // 계정의 만료 여부 리턴 : true - 만료 안됨
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정의 잠김 여부 리턴 : true - 잠기지 않음
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호 만료 여부 리턴 : true - 만료 안됨
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정의 활성화 여부 리턴 : true -  활성화 됨
    @Override
    public boolean isEnabled() {
        return true;
    }
}
