
document.addEventListener('DOMContentLoaded', () => {
    document.querySelector('.file-entry').onchange = function (evt) {
        document.querySelector('.error-message').textContent = null;
        var entry = evt.target;
        console.log(evt);

        var file = entry.files[0];
        var reader = new FileReader();

        reader.addEventListener("load", function () {
            var result = reader.result;
            var mime = result.substring(result.indexOf(':') + 1, result.indexOf(';'));
            if (mime.substring(0, 'image'.length) !== 'image') {
                entry.value = "";

                document.querySelector('.error-message').textContent = "Error: bad file type: " + mime
                return;
            }
            console.log(mime);

            document.querySelector('.post-preview').style['background-image'] = "url(\"" + reader.result + "\")";
        }, false);

        if (file) {
            reader.readAsDataURL(file);
        }
    };
});