package com.soomanche.config

import io.kotest.core.spec.DslDrivenSpec
import io.kotest.core.spec.style.scopes.DescribeSpecRootScope
import org.springframework.transaction.reactive.TransactionalOperator

abstract class DescribeSpec(body: DescribeSpec.() -> Unit = {}, transactionalOperator: TransactionalOperator) : DslDrivenSpec(), DescribeSpecRootScope {
    init {
        body()
    }
}
