package sixonefoureight

class Post {
    User creator
    List<ImageFile> images
    List<Comment> comments
    long timestamp = System.currentTimeMillis()


    static belongsTo = User

    static constraints = {
    }
}
