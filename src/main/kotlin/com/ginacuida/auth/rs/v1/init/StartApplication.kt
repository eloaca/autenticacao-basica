package com.ginacuida.auth.rs.v1.init

import com.ginacuida.auth.service.UsersService
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