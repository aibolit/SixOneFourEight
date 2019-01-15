package sixonefoureight

class User {
    String email

    static mapping = {
        id name: 'email', generator: 'assigned'
    }
}
