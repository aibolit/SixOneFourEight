package sixonefoureight

class Comment {
    User user 
    String content
    long timestamp = System.currentTimeMillis()

    static constraints = {
        user nullable: true
    }

    static belongsTo = Post
}
