package com.mario.auth.repository;

import com.mario.auth.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    Member findByEmail(String email);

    Boolean existsByEmail(String email);
}
