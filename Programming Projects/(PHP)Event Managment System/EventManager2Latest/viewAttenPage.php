<?php
//viewAttenPage.php

$targetID = '';


if(isset($_POST["submit"]))
{
	
	
	$targetID = $_POST["targetID"];

	if ( file_exists($targetID) && ($fp1 = fopen($targetID, "rb"))!==false ) {
		
	} else {

		header('Location: errorPage2.php');
			
	}
	
	$file_openCheck1 = fopen($targetID, "r") or die ("No such file!");
	
	$file_open3 = fopen("targetID", "a");
	

	$form_data3 = array(
		'targetID'		=>	$targetID,
	);
	fputcsv($file_open3, $form_data3);
	
	//$targetID = '';	
	
	header('Location: dispAttenPage.php');

	
}

?>





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
		
		<h1 align="center">View Event Attendance</h1>
		
		<div>
			<form method="post">
			
				<div class="row">
				  <div class="col1">
					<label for="eventID">Event ID :</label>
				  </div>
				  <div class="col2">
					<input type="text" name="targetID" placeholder="Event ID.." value="<?php echo $targetID; ?>" />
				  </div>
				</div>
				
				
			
				<div class="row">
					<input type="button" class="button button1" value="Cancel" onclick="window.location = 'searchOrListPage.html';">
					<input type="submit" name="submit" value="View">
				</div>
			
			</form>
		</div>
	
	
	
	</body>

</html>