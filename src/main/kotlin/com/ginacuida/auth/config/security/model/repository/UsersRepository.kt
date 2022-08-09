package com.ginacuida.auth.config.security.model.repository

import com.ginacuida.auth.config.security.model.entity.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UsersRepository : JpaRepository<Users, Long> {


    @Query("select u from Users u join fetch u.roles where u.username = ?1")
    fun findByUsername(username: String): Optional<Users>

}