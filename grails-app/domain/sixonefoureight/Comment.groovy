package sixonefoureight

class Comment {
    User creator 
    String content
    long timestamp = System.currentTimeMillis()

    static constraints = {
    }

    static belongsTo = Post
}
