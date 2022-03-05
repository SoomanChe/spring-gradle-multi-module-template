package com.soomanche.domain.member

import com.soomanche.domain.dao.BaseQueryRepository
import kotlinx.coroutines.flow.Flow

interface MemberQueryRepository : BaseQueryRepository<Member, Long> {

    fun findAll(): Flow<Member>
}