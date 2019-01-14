package sixonefoureight

import grails.converters.JSON


class AppController {

    def index() {}
    def createPost() {}

    def getPosts() {
        render([posts: Post.list(sort: 'timestamp', order: 'desc').collect {
            [id: it.id, creator: it.creator.email, images: it.images*.id, comments: it.comments.collect { 
                [content: it.content, creator: it.creator.email, id: it.id]
            }]
        }, user: session.email] as JSON)
    }

    def getPostImage() {
        def img = ImageFile.findById(params.id)
        header 'Cache-Control', "max-age=44640"
        render file: img.imageData, contentType: img.contentType
    }

    def addComment() {
        Post post = Post.findById(params.id)
        Comment comment = new Comment(creator: session.email, content: params.content)
        post.comments << comment 
        if (post.save(flush: true)) {
            render ([created:true, id: comment.id] as JSON)
        } else {
            println post.errors
            render ([created:false] as JSON)
        }
    }

    def savePost() {
        def file = request.getFile('image')

        new Post(creator: User.findByEmail(session.email), images: [
            new ImageFile(name: file.originalFilename, contentType: file.contentType, imageData: file.bytes)
        ]).save(flush: true)

        redirect action: 'index'
    }

    def testJSON() {
        render([abc:'def', pqr: [1,2,'a']] as JSON)
    }

    def testImage () {
        render file: "grails-app/assets/images/grails.svg", contentType: "image/svg+xml"
    }
}
