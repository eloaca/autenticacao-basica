package com.ginacuida.auth.rs.v1.controller

import com.ginacuida.auth.config.security.model.enums.EPerfil
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/teste")
class AuthController {

    @GetMapping("/user")
    @PreAuthorize("hasRole('${EPerfil.USERS}') or hasRole('${EPerfil.MANAGERS}')")
    fun testeUsers() : ResponseEntity<String>{
        return ResponseEntity.ok("Usuario Eloa Autorizado")
    }

    @GetMapping("/manager")
    @PreAuthorize("hasRole('${EPerfil.MANAGERS}')")
    fun testeManagers() : ResponseEntity<String>{
        return ResponseEntity.ok("Usuario Admin Autorizado")
    }
}