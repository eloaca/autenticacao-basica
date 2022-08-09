package com.eloaca.autenticacaoBasica.service

import com.eloaca.autenticacaoBasica.config.security.model.entity.Users

interface UsersService {

    fun salvarUserERolesDefault() : List<Users>

    fun consultarUserPorUsername(username : String) : Users
}