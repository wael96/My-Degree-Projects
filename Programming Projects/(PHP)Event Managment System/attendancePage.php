




<!DOCTYPE html>
<html>

	<head>
	
		<meta charset = "utf-8">
		<title>The Event Manager</title>
		
		<style>
		


			input[type=submit] {
				width: 250px;
				
				background-color: white;
				border: 2px solid #4CAF50;
				color: black;
				padding: 15px 32px;
				text-align: center;
				text-decoration: none;
				font-size: 16px;
				margin: 4px 2px;
				cursor: pointer;
				-webkit-transition-duration: 0.4s; /* Safari */
				transition-duration: 0.4s;
				float: right;
			}

			input[type=submit]:hover {
				background-color: #4CAF50;
				color: white;
			}
			
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
				float: left;
				
				margin:auto;
				display:block;
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

			h1 {
				color: #2f302e;
			    font-family: Arial, Helvetica, sans-serif;
			}

			
			input[type=text], select, textarea {
				width: 100%;
				padding: 10px;
				border: 1px solid #ccc;
				border-radius: 2px;
				resize: vertical;
			}
			

			
			.col1 {
				float: left;
				width: 25%;
				margin-top: 6px;
			}

			.col2 {
				float: left;
				width: 75%;
				margin-top: 6px;
			}

		</style>
		
	</head>
	
	
	
	<body bgcolor="#e4e9db">
		
		<h1 align="center">New Attendance Entry</h1>
		
		<div>
			<form method="post">

				<div class="row">
				  <div class="col1">
					<label for="eventid">Event ID :</label>
				  </div>
				  <div class="col2">
					<input type="text" name="eventid" placeholder="Event ID.." value="" required/>
				  </div>
				</div>
			
				<div class="row">
				  <div class="col1">
					<label for="nameofparticipant">Name of Participant :</label>
				  </div>
				  <div class="col2">
					<input type="text" name="nameofparticipant" placeholder="Name of Participant.." value="" required/>
				  </div>
				</div>
				
				<div class="row">
				  <div class="col1">
					<label for="participantemail">Pariticipant Email : </label>
				  </div>
				  <div class="col2">
					<input type="text" name="participantemail" placeholder="Email.." value="" required/>
				  </div>
				</div>

			
				<div class="row">
					<input type="button" class="button button1" value="Cancel" onclick="window.location = 'listPage.php';">
					<input type="submit" name="submit" value="Submit">
				</div>
			
			</form>
		</div>
	
	
	
	</body>

</html>