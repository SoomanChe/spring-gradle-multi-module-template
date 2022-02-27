package com.soomanche.base

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.IsolationMode
import io.kotest.core.test.AssertionMode
import io.kotest.extensions.spring.SpringExtension
import io.mockk.clearAllMocks


object ProjectConfig : AbstractProjectConfig() {
    // If parallelism number bigger than 1, test would be proceed parallel
    override val parallelism: Int = Runtime.getRuntime().availableProcessors()
    // If assertion is not in test what you gonna do? => Would be error
    override val assertionMode: AssertionMode = AssertionMode.Error
    // Proceed to the end if part of the assertion failed.
    override val globalAssertSoftly: Boolean = true
    // Test isolation level
    override val isolationMode = IsolationMode.InstancePerLeaf
    // AfterAll == Junit
    override suspend fun afterProject() {
        clearAllMocks()
    }
    // Spring config
    override fun extensions() = listOf(SpringExtension)
}

