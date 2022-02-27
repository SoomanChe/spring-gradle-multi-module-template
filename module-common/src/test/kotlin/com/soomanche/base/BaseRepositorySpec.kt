package com.soomanche.base

import io.kotest.core.spec.style.DescribeSpec
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest

@DataR2dbcTest
abstract class BaseRepositorySpec(body: DescribeSpec.() -> Unit = {}) : DescribeSpec(body)