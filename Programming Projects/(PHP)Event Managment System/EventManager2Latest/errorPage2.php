<!DOCTYPE html>
<html>

	<head>
	
		<meta charset = "utf-8">
		<title>The Event Manager</title>
		
		<style>
			.button {
				width: 250px;
				
				background-color: #4CAF50;
				border: none;
				color: white;
				padding: 15px 32px;
				text-align: center;
				text-decoration: none;
				font-size: 16px;
				margin: 4px 2px;
				cursor: pointer;
				-webkit-transition-duration: 0.4s; /* Safari */
				transition-duration: 0.4s;
				
				margin:auto;
				display:block;
				<!-- position: absolute; -->
				<!-- top: 50%; -->
				<!-- left: 50%; -->
				
			}
			.button1 {
				background-color: white; 
				color: black; 
				border: 2px solid #4CAF50;
			}
			.button1:hover {
				background-color: #4CAF50;
				color: white;
			}
			div {
				padding: 1px 50px 50px 50px;
			}
			h1 {
				color: #2f302e;
			    font-family: Arial, Helvetica, sans-serif;
			}
			form {
				font-family: Arial, Helvetica, sans-serif;
			}

		</style>
		
	</head>
	
	
	
	<body bgcolor="#e4e9db">
		
		<h1 align="center">Event Not Found! Please Retry.</h1>
		
		<input type="button" class="button button1" value="Back" onclick="window.location = 'viewAttenPage.php';">
	
	</body>

</html>