package sixonefoureight

class BootStrap {

    def init = { servletContext ->
        def state = new Post(images: [
                new ImageFile(name: 'a.png', contentType:"image/png", imageData: new File("grails-app/assets/images/apple-touch-icon.png").bytes)
            ] ).save(flush: true)
        println state

        println ImageFile.list()

    }
    def destroy = {
    }
}
