package com.ginacuida.auth.config.security.model.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_roles")
class Roles (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column var id : Long? = null,

    @Column var nome: String? = null
)