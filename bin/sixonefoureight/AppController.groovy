package sixonefoureight

import grails.converters.JSON


class AppController {

    def index() {     }

    def getPosts() {
        render Post.list() as JSON
    }

    def testJSON() {
        render([abc:'def', pqr: [1,2,'a']] as JSON)
    }

    def testImage () {
        render file: "grails-app/assets/images/grails.svg", contentType: "image/svg+xml"
    }

    def getPostImage() {
        def img = ImageFile.findById(params.id)
        render file: img.imageData, contentType: img.contentType
    }
}
