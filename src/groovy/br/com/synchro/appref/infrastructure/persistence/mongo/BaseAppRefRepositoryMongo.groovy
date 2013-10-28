package br.com.synchro.appref.infrastructure.persistence.mongo

import br.com.synchro.appref.domain.shared.BaseAppRefRepository
import br.com.synchro.infrastructure.persistence.GormCrudRepository
import org.bson.types.ObjectId

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 10/28/13
 * Time: 1:22 AM
 * To change this template use File | Settings | File Templates.
 */
class BaseAppRefRepositoryMongo<T> extends GormCrudRepository<Serializable, T> implements BaseAppRefRepository<T>{

    BaseAppRefRepositoryMongo(Class<T> clazz){
        super(clazz)
    }

    @Override
    T findOne(final Serializable id){
        clazz.get(new ObjectId(id))
    }

    @Override
    Boolean exists(final Serializable id){
        clazz.exists(new ObjectId(id))
    }

    @Override
    void deleteAll(){
        clazz.collection.drop()
    }
}
