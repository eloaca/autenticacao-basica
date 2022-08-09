package com.eloaca.autenticacaoBasica.config.security.model.entity

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "tb_users")
class Users (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column var id : Long? = null,

    @Column(length = 30) var nome: String? = null,

    @Column(length = 10) var username : String? = null,

    @Column(length = 100) var password : String? = null,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    @JoinTable(name = "tb_role", joinColumns = [JoinColumn(name = "users_id")])
    @Column var roles : List<Roles>? = null
)