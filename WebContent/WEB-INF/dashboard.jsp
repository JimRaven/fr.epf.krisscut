<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Mood of the month</title>

    <!-- Bootstrap CSS -->
    <link href="/javaEECourse/WebContent/style/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/javaEECourse/WebContent/style/style.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">
</head>

<body>

<div class="container-fluid" id="dashboard">

    <div class="half">
        <div class="month">
            <p class="title">MARCH 2017</p>
            <p class="subtitle">MOOD OF THE MONTH</p>
        </div>

        <div class="details">
            <div class="mood">
                <div class="img-container">
                    <img src="img/1.png" alt="super"/>
                </div>
                <div class="progress-bar-container">
                    <span class="desc">Vote count: 10</span>
                    <div class="progress">
                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="10"
                             aria-valuemin="0" aria-valuemax="100" style="width:10%">
                            <span class="">10%</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mood">
                <div class="img-container">
                    <img src="img/2.png" alt="super"/>
                </div>
                <div class="progress-bar-container">
                    <span class="desc">Vote count: 5</span>
                    <div class="progress">
                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="5"
                             aria-valuemin="0" aria-valuemax="100" style="width:5%">
                            <span class="">5%</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mood">
                <div class="img-container">
                    <img src="img/3.png" alt="super"/>
                </div>
                <div class="progress-bar-container">
                    <span class="desc">Vote count: 15</span>
                    <div class="progress">
                        <div class="progress-bar progress-bar-neutral" role="progressbar" aria-valuenow="15"
                             aria-valuemin="0" aria-valuemax="100" style="width:15%">
                            <span class="">15%</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mood">
                <div class="img-container">
                    <img src="img/4.png" alt="super"/>
                </div>
                <div class="progress-bar-container">
                    <span class="desc">Vote count: 45</span>
                    <div class="progress">
                        <div class="progress-bar progress-bar-midsuccess" role="progressbar" aria-valuenow="45"
                             aria-valuemin="0" aria-valuemax="100" style="width:45%">
                            <span class="">45%</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mood">
                <div class="img-container">
                    <img src="img/5.png" alt="super"/>
                </div>
                <div class="progress-bar-container">
                    <span class="desc">Vote count: 25</span>
                    <div class="progress">
                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="25"
                             aria-valuemin="0" aria-valuemax="100" style="width:25%">
                            <span class="">25%</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="half-2">

        <div class="global">
            <div class="global-mood">
              <div class="img-container">
                <img class="mood" src="img/4.png" alt=""/>
              </div>
              <div class="notation">
                  <p class="title">GLOBAL MOOD</p>
                  <span class="note">4.2</span>
                  <span class="note-on">/5</span>
              </div>
            </div>
        </div>

        <div class="comments">
            <h2 class="title">Comments</h2>
            <div class="comment-container">
                <div class="note">
                    <img class="mood" src="img/3.png" alt=""/>
                </div>
                <div class="comment">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis nec nulla quam. Integer nisi ligula,
                    molestie id diam ac, sagittis efficitur justo. Etiam aliquam aliquam dolor sed fringilla. Nullam at.
                </div>
            </div>
            <div class="comment-container">
                <div class="note">
                    <img class="mood" src="img/4.png" alt=""/>
                </div>
                <div class="comment">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis nec nulla quam. Integer nisi ligula,
                    molestie id diam ac, sagittis efficitur justo. Etiam aliquam aliquam dolor sed fringilla. Nullam at.
                </div>
            </div>
            <div class="comment-container">
                <div class="note">
                    <img class="mood" src="img/3.png" alt=""/>
                </div>
                <div class="comment">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis nec nulla quam. Integer nisi ligula,
                    molestie id diam ac, sagittis efficitur justo. Etiam aliquam aliquam dolor sed fringilla. Nullam at.
                </div>
            </div>
            <div class="comment-container">
                <div class="note">
                    <img class="mood" src="img/5.png" alt=""/>
                </div>
                <div class="comment">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis nec nulla quam. Integer nisi ligula,
                    molestie id diam ac, sagittis efficitur justo. Etiam aliquam aliquam dolor sed fringilla. Nullam at.
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="../js/jquery-3.1.1.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../js/bootstrap.min.js"></script>

</body>
</html>