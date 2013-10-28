package br.com.synchro.infrastructure.persistence

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 10/21/13
 * Time: 2:19 PM
 * To change this template use File | Settings | File Templates.
 */
interface CrudRepository<ID extends Serializable, T> extends Repository<ID, T>{

    def <S extends T> S save(final S entity)

    def <S extends T> Iterable<S> saveAll(final Iterable<S> entities)

    T findOne(final ID id)

    Boolean exists(final ID id)

    Iterable<T> findAll()

    Long count()

    void delete(final T entity)

    void deleteAll()

    T findByExample(T entity)

    Iterable<T> findAllByExample(T entity)
}
