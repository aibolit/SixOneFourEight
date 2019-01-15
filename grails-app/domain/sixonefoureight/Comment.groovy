package sixonefoureight

class Comment {
    User creator 
    String content
    long timestamp = System.currentTimeMillis()

    static belongsTo = Post
}
