class Post extends React.Component {
    constructor(props) {
        super(props);
        this.state = {comments: props.comments}
    }

    render() {
        console.log(this.props);
        var imageStyle = {
            "backgroundImage": `url("getPostImage?id=${this.props.image}")`
        }

        var commentKey = (evt) => {
            if (evt.key === 'Enter' && evt.target.value) {
                var content = evt.target.value;
                var entry = evt.target;
                var form = new FormData();
                form.append('id', this.props.postId);
                form.append('content', content);
                fetch('addComment', {
                    credentials: 'include',
                    method: 'post',
                    body: form
                }).then(r => r.json()).then(res => {
                    if (res.created) {
                        entry.value = "";
                        this.state.comments.push({content: content, creator: res.user, id: res.id});
                        this.forceUpdate();
                    } else console.error(res);
                }).catch(console.error);
            }
        }

        return <div className='post-root'>
            <label>{this.props.creator}</label>
            <div className="post-image" style={imageStyle} />
            {this.state.comments.map(c => <div className="post-comment" key={c.id}>
                <label className="post-comment-name">{c.creator}</label>
                <label className="post-comment-content">{c.content}</label>
            </div>)}
            <div className="post-comment-entry"><input type="text" placeholder="Add a comment" onKeyDown={commentKey} /></div>
        </div>;
    }
}

module.exports = Post