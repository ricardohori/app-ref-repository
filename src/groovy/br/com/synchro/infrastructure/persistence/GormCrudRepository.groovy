package br.com.synchro.infrastructure.persistence

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 10/22/13
 * Time: 12:44 AM
 * To change this template use File | Settings | File Templates.
 */
abstract class GormCrudRepository<ID extends Serializable, T> implements CrudRepository<ID, T>{

    protected final T clazz

    GormCrudRepository(Class<T> clazz){
        this.@clazz = clazz
    }

    @Override
    def <S extends T> S save(final S entity, final Map<String, Object> config = [flush:true, failOnError:true]){
        entity.save(config)
    }

    @Override
    def <S extends T> Iterable<S> saveAll(final Iterable<S> entities, final Map<String, Object> config = [flush:true, failOnError:true]){
        entities.each{
            it.save(config)
        }
    }

    @Override
    T findOne(final ID id){
        clazz.get(id)
    }

    @Override
    Boolean exists(final ID id){
        clazz.exists(id)
    }

    @Override
    Iterable<T> findAll(final Map<String, Object> config = [:]){
        clazz.findAll(config)
    }

    @Override
    Long count(final Map<String, Object> config = [:]){
        clazz.count(config)
    }

    @Override
    void delete(final T entity, final Map<String, Object> config = [flush:true]){
        entity.delete(config)
    }

    @Override
    void delete(final Iterable<? extends T> entities, final Map<String, Object> config = [flush:true]){
        entities.each{
            it.delete(config)
        }
    }

    @Override
    void deleteAll(){
        findAll().each{
            delete(it)
        }
    }

    @Override
    T findByExample(T entity){
        clazz.find(entity)
    }

    @Override
    Iterable<T> findAllByExample(T entity){
        clazz.findAll(entity)
    }
}
