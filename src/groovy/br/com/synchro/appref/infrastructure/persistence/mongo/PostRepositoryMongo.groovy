package br.com.synchro.appref.infrastructure.persistence.mongo

import br.com.synchro.appref.domain.model.Post
import br.com.synchro.appref.domain.model.PostRepository
import br.com.synchro.infrastructure.persistence.GormCrudRepository
import org.bson.types.ObjectId

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 10/28/13
 * Time: 12:05 AM
 * To change this template use File | Settings | File Templates.
 */
class PostRepositoryMongo extends BaseAppRefRepositoryMongo<Post> implements PostRepository{

    PostRepositoryMongo(){
        super(Post.class)
    }

    @Override
    Iterable<Post> writtenByAuthor(String author) {
        findAllByExample(new Post(author: author))
    }

    @Override
    Iterable<Post> withTitleMatching(String titleMatch) {
        clazz.findAllByTitleIlike("%${titleMatch}%")
    }
}
