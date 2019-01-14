var React = require('react')
var ReactDOM = require('react-dom')

var Post = require('post.js')



class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {posts: props.posts}
    }

    render() {
        return <div className='posts-root'>
            <div className='posts-create' onClick={() => {window.location = 'createPost'}}></div>
            {
                this.state.posts.map(x =>
                    <Post key={x.id} postId={x.id} image={x.image} comments={x.comments} creator={x.creator} />
                )
            }
        </div>
    }

}

document.addEventListener('DOMContentLoaded', () => {
    fetch('getPosts', {credentials: 'include'}).then(r => r.json()).then(data => {
        console.log(data);

        ReactDOM.render(<Posts {...data} />, document.getElementById('root'));
    });

});