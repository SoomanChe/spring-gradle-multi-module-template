package com.soomanche.domain.dao

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import reactor.core.publisher.Mono

@NoRepositoryBean
interface BaseQueryRepository<T, ID> : Repository<T, ID>{
    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be null.
     * @return [Mono] emitting the entity with the given id or empty if none found.
     * @throws IllegalArgumentException in case the given id is null.
     */
    suspend fun findById(id: ID): T?
    /**
     * Returns whether an entity with the given id exists.
     *
     * @param id must not be null.
     * @return true if an entity with the given id exists, false otherwise.
     * @throws IllegalArgumentException in case the given id is null.
     */
    suspend fun existsById(id: ID): Boolean
}