package com.pongcoder.myhome.repository;

import com.pongcoder.myhome.model.Board;
import com.pongcoder.myhome.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>  {


}
