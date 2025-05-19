package com.example.repository;

import com.example.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private final static RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
        Member member = new Member();
        member.setId(rs.getInt("id"));
        member.setName(rs.getString("name"));
        member.setAge(rs.getInt("age"));
        member.setDepId(rs.getInt("dep_id"));
        return member;
    };

    public List<Member> findByName(String keyword) {
        String sql = "SELECT id, name, age, dep_id FROM members WHERE name LIKE :keyword ORDER BY age DESC;";

        SqlParameterSource param = new MapSqlParameterSource().addValue("keyword", "%" + keyword + "%");

        List<Member> members = template.query(sql, param, MEMBER_ROW_MAPPER);

        return members;
    }
}
