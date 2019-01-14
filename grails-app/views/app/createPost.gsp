<!Doctype html>

<html>

<head>
    <asset:javascript src="app/createPost.js" />
    <asset:stylesheet src="app/index.css" />
</head>

<body>
    <g:uploadForm action="savePost" class="post-create-form">
        <div class="post-preview" name="preview"></div>
        <label class="error-message" name="errmsg"></label>
        <g:if test="${flash.message}"><label class='flash-message'>${flash.message}</label></g:if>
        <input type="file" name="image" class='file-entry'/>
        <g:submitButton name='upload' value="Create"/>
    </g:uploadForm>
</body>

</html>