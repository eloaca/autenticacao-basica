package com.ginacuida.auth.config

import com.ginacuida.auth.service.UsersService
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class SecurityDataBaseService(
    private val service: UsersService
) : UserDetailsService {


    override fun loadUserByUsername(username: String): UserDetails {
        val users = service.consultarUserPorUsername(username)

        val authorities = HashSet<GrantedAuthority>()
        users.roles?.forEach { role ->
            authorities.add(SimpleGrantedAuthority("ROLE_${role.nome}"))
        }

        return User(users.username, users.password, authorities)
    }
}