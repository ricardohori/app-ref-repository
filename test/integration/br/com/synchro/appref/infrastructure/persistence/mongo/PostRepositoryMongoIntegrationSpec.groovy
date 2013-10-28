package br.com.synchro.appref.infrastructure.persistence.mongo

import br.com.synchro.appref.domain.model.Post
import br.com.synchro.appref.domain.model.PostRepository
import grails.plugin.spock.IntegrationSpec

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 10/28/13
 * Time: 12:39 AM
 * To change this template use File | Settings | File Templates.
 */
class PostRepositoryMongoIntegrationSpec extends IntegrationSpec {

    PostRepository postRepository

    def cleanup(){
        postRepository.deleteAll()
    }

    def "Find all posts written by an author"(){
        setup:
        postRepository.save new Post(author: "Jiraya", title: "The way of the", content: "Ninja!")
        postRepository.save new Post(author: "Jiraya", title: "Natural born", content: "Ninja!")
        postRepository.save new Post(author: "Jiraya", title: "To be or not to be a", content: "Ninja!")
        postRepository.save new Post(author: "Gokuu", title: "Kamehame...", content: "HAAA!")

        when:
        def jirayaPosts = postRepository.writtenByAuthor("Jiraya")
        def gokuuPosts = postRepository.writtenByAuthor("Gokuu")

        then:
        jirayaPosts.toList().size() == 3
        gokuuPosts.toList().size() == 1
    }

    def "Find all posts with matching title"(){
        setup:
        postRepository.save new Post(author: "TMNT", title: "Teenage mutant", content: "Ninja turtles!")
        postRepository.save new Post(author: "X-Men", title: "Mutants of the new age", content: "Go!")
        postRepository.save new Post(author: "UFC", title: "No mutants allowed", content: "It's TIME!")
        postRepository.save new Post(author: "Gokuu", title: "Kamehame...", content: "HAAA!")

        when:
        def mutantPosts = postRepository.withTitleMatching("mutant")
        def kamehamehaPosts = postRepository.withTitleMatching("kame")

        then:
        mutantPosts.toList().size() == 3
        kamehamehaPosts.toList().size() == 1
    }
}
