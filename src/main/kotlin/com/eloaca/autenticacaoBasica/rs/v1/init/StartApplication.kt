package com.eloaca.autenticacaoBasica.rs.v1.init

import com.eloaca.autenticacaoBasica.service.UsersService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class StartApplication(
    private val service: UsersService
) : CommandLineRunner {


    override fun run(vararg args: String?) {
        service.salvarUserERolesDefault()
    }
}