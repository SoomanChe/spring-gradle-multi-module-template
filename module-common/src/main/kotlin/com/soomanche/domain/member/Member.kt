package com.soomanche.domain.member

import com.soomanche.domain.model.BaseEntity
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("member")
class Member(
    name: String,
) : BaseEntity() {
    @Column("name")
    var name: String = name
}