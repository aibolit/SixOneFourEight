package sixonefoureight

class Post {
    User creator
    ImageFile image
    List<Comment> comments
    long timestamp = System.currentTimeMillis()

    static belongsTo = User
}
