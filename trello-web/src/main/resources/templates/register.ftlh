<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" href="<@spring.url '/css/registerStyle.css'/>"/>
</head>
<body>
<form action="/signUp" method="post">
<div id="reg-box">
    <div class="left">
        <h1>Registration</h1>

        <input type="text" name="username" placeholder="Username" />
        <input type="text" name="email" placeholder="E-mail" />
        <input type="password" name="password" placeholder="Password" />
<#--        <input type="password" name="password2" placeholder="Retype password" />-->

        <input type="submit" name="signup_submit" value="Sign me up" />
    </div>


    <div class="right">
        <span class="loginwith">Sign in with<br />social network</span>
        <button class="social-signin google">Reg with Google+</button>

        <div class="container signin">
            <p>Already have an account? <a href="/signUp">Log in</a>.</p>
        </div>
    </div>
    <div class="or">OR</div>


</div>
</form>
</body>
</html>