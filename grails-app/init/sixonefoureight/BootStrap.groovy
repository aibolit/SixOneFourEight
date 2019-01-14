package sixonefoureight

class BootStrap {

    def init = { servletContext ->
        def user = new User(email: 'test@test.test')
        user.save(flush: true)
        

        def post = new Post(
            creator: user,
            image: new ImageFile(name: 'a.png', contentType:"image/png", imageData: new File("grails-app/assets/images/apple-touch-icon.png").bytes),
            comments: [
                new Comment(creator: user, content: 'very cool!'),
                new Comment(creator: user, content: 'agreed')
            ])
        post.save(flush: true)

        new Post(
            creator: user,
            image: new ImageFile(name: 'a.png', contentType:"image/png", imageData: new File("grails-app/assets/images/apple-touch-icon.png").bytes),
            comments: [
                new Comment(creator: user, content: 'very cool!'),
                new Comment(creator: user, content: 'agreed')
            ]).save(flush: true)

    }
    def destroy = {
    }
}
