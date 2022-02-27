package com.soomanche.entity.member

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface MemberRepository : CoroutineCrudRepository<Member, Long> {
}