package com.aaa.triecount.repository;

import com.aaa.triecount.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    public Optional<Member> findByLoginId(String loginId) {
        List<Member> result = jdbcTemplate.query("SELECT * FROM member WHERE login_id = ?", memberRowMapper(), loginId);
        return result.stream().findAny();
    }

    // member를 조회해서 나오는 reslutSet을 멤버 엔티티와 매핑해주는 역할
    // rowMapper는 객체 field와 실제 DB랑 연결해주는 역할이다.
    private RowMapper<Member> memberRowMapper() {
        return ((rs, rowNum) -> {
            Member member = Member.builder()
                                  .id(rs.getLong(("id")))
                                  .loginId(rs.getString("login_id"))
                                  .name(rs.getString("name"))
                                  .password(rs.getString("password"))
                                  .build();
            return member;
        });
    }

    public Member save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

        Map<String, Object> params = new HashMap<>();
        params.put("login_id", member.getLoginId());
        params.put("password", member.getPassword());
        params.put("name", member.getName());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(params));
        member.setId(key.longValue());

        return member;
    }
}
