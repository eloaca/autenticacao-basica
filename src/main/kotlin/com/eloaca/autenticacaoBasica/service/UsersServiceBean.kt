package com.eloaca.autenticacaoBasica.service

import com.eloaca.autenticacaoBasica.config.security.model.entity.Roles
import com.eloaca.autenticacaoBasica.config.security.model.entity.Users
import com.eloaca.autenticacaoBasica.config.security.model.enums.EPerfil
import com.eloaca.autenticacaoBasica.config.security.model.repository.UsersRepository
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class UsersServiceBean(
    private val repository: UsersRepository
) : UsersService {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    override fun salvarUserERolesDefault(): List<Users> {
        val users = this.novoDataSqlDefault()
        return repository.saveAllAndFlush(users)
    }

    override fun consultarUserPorUsername(username: String): Users {
        val userFindy = repository.findByUsername(username)

        when {
            userFindy.isPresent -> return userFindy.get()
            else -> throw UsernameNotFoundException(username)
        }
    }

    private fun novoDataSqlDefault() : List<Users> {
        val roles = Roles(null, EPerfil.USERS)
        val roles2 = Roles(null, EPerfil.MANAGERS)
        val users = Users(null,"Eloa Cardozo", "eloaca", "eloaca", listOf(roles))
        val users2 = Users(null, "Admin", "admin", "admin", listOf(roles, roles2))

        val lista = ArrayList<Users>()
        lista.add(users)
        lista.add(users2)

        return lista
    }
}