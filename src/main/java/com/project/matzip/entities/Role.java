package com.project.matzip.entities;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int roleId;


    // ADMIN : 맛집 등록, 삭제, 수정
    // USER : 후기 등록, 삭제, 수정
    @Column(name = "role")
    private String role;

    public Role() {

    }

    public Role(String role) {
        this.role = role;
    }

    public int getRoleId() {
        return this.roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}