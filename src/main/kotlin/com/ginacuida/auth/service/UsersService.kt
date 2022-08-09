package com.ginacuida.auth.service

import com.ginacuida.auth.config.security.model.entity.Users

interface UsersService {

    fun salvarUserERolesDefault() : List<Users>

    fun consultarUserPorUsername(username : String) : Users
}