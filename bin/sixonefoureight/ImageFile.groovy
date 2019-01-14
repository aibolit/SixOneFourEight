package sixonefoureight

class ImageFile {
    byte[] imageData
    String name
    String contentType

    static constraints = {
    }

    static mapping = {
        imageData sqlType: 'longblob'
    }
    static belongsTo = Post
}
