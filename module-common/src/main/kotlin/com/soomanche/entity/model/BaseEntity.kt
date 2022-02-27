package com.soomanche.entity.model

import com.soomanche.entity.member.Member
import org.springframework.data.annotation.*
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import java.io.Serializable
import java.time.Instant

open class BaseEntity : Serializable, Persistable<Long> {
    @Id
    var id: Long = 0

    @CreatedBy
    @Column("created_by")
    lateinit var writer: Member
        private set

    @CreatedDate
    @Column("created_at")
    lateinit var createdAt: Instant
        private set

    @LastModifiedBy
    @Column("updated_by")
    lateinit var editer: Member
        private set

    @LastModifiedDate
    @Column("updated_at")
    lateinit var updatedAt: Instant
        private set

    override fun isNew() = this.id < 1

    override fun getId() = this.id

}
