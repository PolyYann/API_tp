<%--
  Created by IntelliJ IDEA.
  User: Mélanie
  Date: 2022-06-24
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connection</title>
</head>
<body>


<!DOCTYPE html>
<html>
<head>
    <title>TODO supply a title</title>
    <link rel="icon" type="image/x-icon" href="img/icon.jpg"/>
    <!--Bootstrap -->
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="bootstrap/bootstrap-grid.min.css"/>
    <link rel="stylesheet" href="bootstrap/bootstrap-reboot.min.css"/>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://bootstrap-colors-extended.herokuapp.com/bootstrap-colors.css" />


</head>
<body>

<div class="bg-steel-light">
    <jsp:include page="navBar.jsp"  />

<form name="maform" action="ControlSession" method="post">


    <!-- Section: Design Block -->
    <section class="text-center text-lg-start">
        <style>
            .cascading-right {
                margin-right: -50px;
            }

            @media (max-width: 991.98px) {
                .cascading-right {
                    margin-right: 0;
                }
            }
        </style>

        <!-- Jumbotron -->
        <div class="container py-4">
            <div class="row g-0 align-items-center">
                <div class="col-lg-6 mb-5 mb-lg-0">
                    <div class="card cascading-right" style="
            background: hsla(0, 0%, 100%, 0.55);
            backdrop-filter: blur(30px);
            ">
                        <div class="card-body p-5 shadow-5 text-center">
                            <h2 class="fw-bold mb-5">Se Connecter</h2>
                            <form>
                                <!-- 2 column grid layout with text inputs for the name and password -->
                                <div class="row">
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <input type="text" id="name" class="form-control" />
                                            <label class="form-label" >Nom</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline mb-4">
                                            <input type="password" id="password" class="form-control" />
                                            <label class="form-label">Mot de passe</label>
                                        </div>
                                    </div>
                                </div>

                                <!-- Email input -->
                                <div class="form-outline mb-4">
                                    <input type="email" id="email" class="form-control" />
                                    <label class="form-label">Adresse courriel</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="text" id="phone" class="form-control" />
                                    <label class="form-label">Telephone</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="text" id="address" class="form-control" />
                                    <label class="form-label">Adresse</label>
                                </div>


                                <!-- Submit button -->
                                <button type="submit" class="btn btn-secondary btn-block mb-4">
                                    Connection<input type="hidden" name="action" value="login">
                                </button>
                                <button type="submit" class="btn btn-secondary btn-block mb-4">
                                    Creer un compte<input type="hidden" name="action" value="createaccount">
                                </button>


                            </form>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6 mb-5 mb-lg-0">
                    <img src="img/icon.png" class="w-100 rounded-4 shadow-4"
                         alt="" />
                </div>
            </div>
        </div>
        <!-- Jumbotron -->
    </section>
    <!-- Section: Design Block -->


</form>

</div>
</body>
</html>




<script src="js/script.js"></script>
<script src="bootstrap/bootstrap.bundle.min.js"></script>
<script src="bootstrap/bootstrap.min.js"></script>
<script src="bootstrap/jquery-3.6.0.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>


</body>
</html>
