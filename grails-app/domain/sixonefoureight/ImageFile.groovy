package sixonefoureight

class ImageFile {
    byte[] imageData
    String name
    String contentType

    static mapping = {
        imageData sqlType: 'longblob'
    }
    
    static belongsTo = Post
}
