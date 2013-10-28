package br.com.synchro.appref.domain.model

import br.com.synchro.appref.domain.shared.BaseAppRefRepository

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 10/28/13
 * Time: 12:09 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PostRepository extends BaseAppRefRepository<Post> {

    Iterable<Post> writtenByAuthor(String author)

    Iterable<Post> withTitleMatching(String titleMatch)

}