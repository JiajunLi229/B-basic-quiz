package com.basicquiz.demo.repository;

import com.basicquiz.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(Integer integer);

    <S extends User> S save(S entity);

}
