package sixonefoureight

class LoginController {

    def index() { }

    def login() {
        if (params.email) {
            def user = User.findByEmail(params.email)
            if (!user) {
                new User(email: params.email).save(flush: true)
            }
            session.email = params.email
            redirect controller: 'app'
        } else {
            flash.message= "Email Cannot Be Blank"
            redirect action: 'index'
        }
    }
}
