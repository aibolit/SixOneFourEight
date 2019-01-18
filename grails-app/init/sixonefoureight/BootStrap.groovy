package sixonefoureight

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        if (Environment.getCurrent() != Environment.DEVELOPMENT) return

        def user = new User(email: 'test@test.test')
        user.save(flush: true)
        

        def post = new Post(
            creator: user,
            image: new ImageFile(name: 'c.jpeg', contentType:"image/jpeg", imageData: new File("sample/c.jpeg").bytes),
            comments: [
                new Comment(creator: user, content: 'very cool!'),
                new Comment(creator: user, content: 'agreed')
            ])
        post.save(flush: true)

        new Post(
            creator: user,
            image: new ImageFile(name: 'b.jpeg', contentType:"image/jpeg", imageData: new File("sample/b.jpeg").bytes),
            comments: [
                new Comment(creator: user, content: 'very cool!'),
                new Comment(creator: user, content: 'agreed')
            ]).save(flush: true)

    }
    def destroy = {
    }
}
