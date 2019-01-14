package sixonefoureight


class LoginInterceptor {
    LoginInterceptor () {
        match controller: "app"
    }

    boolean before() { 
        if (!session.email) {
            redirect controller: 'login'
            return false
        }
        true 
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
