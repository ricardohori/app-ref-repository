package br.com.synchro.appref.domain.model

import org.bson.types.ObjectId

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 10/27/13
 * Time: 11:58 PM
 * To change this template use File | Settings | File Templates.
 */
class Post {

    static mapWith = "mongo"

    ObjectId id

    String author
    String title
    String content

    static constraints = {}

}
