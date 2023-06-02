<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <script>
            let pr = "${shortenurlPrimary}"
            let shortenUrlText = document.getElementById("shortenUrl");
            if(pr != null){
                shortenUrlText.style.display = "block";
            }else{
                shortenUrlText.style.display = "none";
            }
        </script>
        <div class="container">
            <div class = "mb-3">
                <form action="/shrturl/saveurl" method="POST">
                    <label for="exampleFormControlInput1" class="form-label">URL 입력</label>
                    <input type="text" name="url" class="form-control" id="exampleFormControlInput1"><br>
                    <input type="submit" value="단축" class="btn btn-primary mb-3">
                </form>
                <textarea id = "shortenUrl" readonly class="form-control">${shortenUrl}</textarea>
            </div>
        </div>
    </body>
</html>