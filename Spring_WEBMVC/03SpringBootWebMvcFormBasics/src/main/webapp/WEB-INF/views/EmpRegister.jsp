<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employee Register</title>
</head>
<body>
<h1>WELCOME TO EMPLOYEE REGISTERATION</h1>
<pre>
    <form action="/read/data" method="post" style="font-weight: bold" att>
        ID     : <input type="text" name="id"/> <br>
        NAME   : <input type="text" name="name"/><br>
        SALARY : <input type="text" name="salary"/><br>
        PWD    : <input type="text" name="pwd"/><br>
        DEPT   : <SELECT name="dept">
                    <option value="DEV">dev</option>
                    <option value="QA">Qa</option>
                    <option value="BA">Ba</option>
                </SELECT>
        ADDR   : <textarea name="addr"></textarea>
        <input type="submit" value="CREATE"/>
    </form>
</pre>
</body>
</html>
