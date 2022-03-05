package com.soomanche.domain.dao

import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository

@NoRepositoryBean
interface BaseCommandRepository<T, ID> : Repository<T, ID>{
    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
     * entity instance completely.
     *
     * @param entity must not be null.
     * @return  the saved entity.
     * @throws IllegalArgumentException in case the given entity is null.
     */
    suspend fun <S : T> save(entity: S): T
    /**
     * Saves all given entities.
     *
     * @param entities must not be null.
     * @return [Flow] emitting the saved entities.
     * @throws IllegalArgumentException in case the given [entities][Flow] or one of its entities is
     * null.
     */
    fun <S : T> saveAll(entities: Iterable<S>): Flow<S>

    /**
     * Saves all given entities.
     *
     * @param entityStream must not be null.
     * @return [Flow] emitting the saved entities.
     * @throws IllegalArgumentException in case the given [entityStream][Flow] is null.
     */
    fun <S : T> saveAll(entityStream: Flow<S>): Flow<S>
    /**
     * Deletes the entity with the given id.
     *
     * @param id must not be null.
     * @throws IllegalArgumentException in case the given id is null.
     */
    suspend fun deleteById(id: ID)
}