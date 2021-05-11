<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="css/registerStyle.css">
<#--    <#include "css/registerStyle.css">-->
</head>
<body>
<form action="/signIn" method="post">
<div id="login-box">
    <div class="left">
        <h1><b>Sign in</b></h1>

        <input type="text" name="email" placeholder="E-mail" />
        <input type="password" name="password" placeholder="Password" />

        <input type="submit" name="signup_submit" value="Sign me in" />
    </div>
    <a href="/oauth2/authorization/google" role="button">Login with Google</a>

    <div class="right">
        <span class="loginwith">Sign in with<br />social network</span>


<#--        <button class="social-signin facebook">Log in with facebook</button>-->
<#--        <button class="social-signin twitter">Log in with Twitter</button>-->
<#--        <button class="social-signin google">Log in with Google+</button>-->
    </div>
    <div class="or">OR</div>
</div>
    </form>
</body>
</html>