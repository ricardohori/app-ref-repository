package br.com.synchro.appref.domain.shared

import br.com.synchro.infrastructure.persistence.CrudRepository

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 10/28/13
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */
interface BaseAppRefRepository<T> extends CrudRepository<Serializable, T> {

}
