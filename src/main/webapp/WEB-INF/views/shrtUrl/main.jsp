<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
            <!-- CSS only -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                crossorigin="anonymous">
            <style>
                #shortenUrl {
                    resize: none; 
                    font-weight: bold;
                }

                .container {
                    margin-top: 30px;
                }
            </style>
        </head>

        <body>
            <div class="container">
                <h1>단축 URL 생성기</h1>
                <div class="mb-3">
                    <form action="/shrturl/saveurl" method="POST" name="myform">
                        <label for="exampleFormControlInput1" class="form-label">URL 입력</label>
                        <input type="text" name="url" class="form-control" id="exampleFormControlInput1"
                            value="${url}"><br>
                        <input type="button" value="단축" class="btn btn-primary mb-3" id='shorten' onclick="check()">
                    </form>
                    <hr>
                    <textarea id="shortenUrl" readonly class="form-control">${shortenUrl}</textarea><br>
                    <strong><p id="copyOk"></p></strong>
                    <button value="${shortenUrl}" class="btn btn-primary mb-3" id="button">복사</button>
                </div>
            </div>
            <script>  
                let tArea = document.getElementById("shortenUrl");
                let b = document.getElementById("button");
                let s = document.getElementById("shorten");

                // urlText에 값이 있으면 단축, 복사 버튼과 textarea 보이게
                let urlText = document.getElementById('exampleFormControlInput1');

                if (tArea.value.length == 0) {
                    tArea.style.display = "none"
                    b.style.display = "none";
                } else {
                    tArea.style.display = "block"
                    b.style.display = "block";
                }
               function check(){
                    if(urlText.value.length == 0){
                        alert("url을 입력해주세요");
                    }else{
                        myform.submit();
                    }
                }

                // 클립보드에 복사
                function copyClipboard() {
                    let copyOkText = document.getElementById('copyOk');
                    const text = document.getElementById('shortenUrl');
                    const textarea = document.createElement('textarea');

                    copyOkText.innerText ="단축url이 복사되었습니다.";
                    copyOkText.style.color = "green";
                    text.style.border = "3px solid green";

                    textarea.textContent = text.textContent;
                    document.body.append(textarea);
                    textarea.select();
                    document.execCommand('copy');
                    textarea.remove();
                }

                const button = document.getElementById('button');
                button.addEventListener('click', copyClipboard);
            </script>
        </body>

        </html>