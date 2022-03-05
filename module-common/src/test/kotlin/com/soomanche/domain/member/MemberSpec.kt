package com.soomanche.domain.member

import com.soomanche.base.BaseRepositorySpec
import io.kotest.matchers.collections.beEmpty
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.toList
import org.springframework.transaction.reactive.TransactionalOperator
import org.springframework.transaction.reactive.executeAndAwait

internal class MemberSpec(
    memberRepository: MemberQueryRepository,
    memberCommandRepository: MemberCommandRepository,
    transactionalOperator: TransactionalOperator,
) : BaseRepositorySpec({
    describe("123") {
        it("zxc") {
            transactionalOperator.executeAndAwait {
                (1..10000).asFlow().collect {
                    memberCommandRepository.save(Member("member_${it}"))
                }
                val findAll = memberRepository.findAll().toList()
                findAll.size shouldBe 10000
                it.setRollbackOnly()
            }
        }
        it("헤") {
            val findAll = memberRepository.findAll().toList()
            findAll should beEmpty()
        }
    }

})