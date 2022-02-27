package com.soomanche.entity.member

import com.soomanche.entity.model.BaseEntity
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("member")
class Member(
    name: String,
) : BaseEntity() {
    @Column("name")
    var name: String = name
}