<?php
//createPage.php

$organizerName = '';
$eventName = '';
$eventDate = '';
$eventVenue = '';
$eventType = '';
$eventDescription = '';

if(isset($_POST["submit"]))
{
	$organizerName = $_POST["organizerName"];
	$eventName = $_POST["eventName"];
	$eventDate = $_POST["eventDate"];
	$eventVenue = $_POST["eventVenue"];
	$eventType = $_POST["eventType"];
	$eventDescription = $_POST["eventDescription"];
	
	$file_open = fopen("eventData.csv", "a");
	$no_rows = count(file("eventData.csv"));
	

	$form_data = array(
		'ID'		=>	$no_rows,
		'Name of Organizer'		=>	$organizerName,
		'Event Name'		=>	$eventName,
		'Date of Event'	=>	$eventDate,
		'Event Venue'	=>	$eventVenue,
		'Event Type'	=>	$eventType,
		'Event Description'	=>	$eventDescription,
	);
	fputcsv($file_open, $form_data);
	$organizerName = '';
	$eventName = '';
	$eventDate = '';
	$eventVenue = '';
	$eventType = '';
	$eventDescription = '';
	
	echo '<script language="javascript">';
	echo 'alert("Congratulations\nEvent Successfully Created!")';  
	echo '</script>';
	
	echo file_put_contents($no_rows+'.csv',"");
	
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
		
		<h1 align="center">Event Creation Form</h1>
		
		<div>
			<form method="post">
			
				<div class="row">
				  <div class="col1">
					<label for="nameoforganizer">Name of Organizer :</label>
				  </div>
				  <div class="col2">
					<input type="text" name="organizerName" placeholder="Name of Organizer.." value="<?php echo $organizerName; ?>" />
				  </div>
				</div>
				
				<div class="row">
				  <div class="col1">
					<label for="eventname">Event Name : </label>
				  </div>
				  <div class="col2">
					<input type="text" name="eventName" placeholder="Name of Event.." value="<?php echo $eventName; ?>" />
				  </div>
				</div>
				
				<div class="row">
				  <div class="col1">
					<label for="date">Event Date : </label>
				  </div>
				  <div class="col2">
					<input type="date" name="eventDate" placeholder="Date of Event.." value="<?php echo $eventDate; ?>" />
				  </div>
				</div>
				
				<div class="row">
				  <div class="col1">
					<label for="eventvanue">Event Venue : </label>
				  </div>
				  <div class="col2">
					<input type="text" name="eventVenue" placeholder="Venue of Event.." value="<?php echo $eventVenue; ?>" />
				  </div>
				</div>
				
				<div class="row">
				  <div class="col1">
					<label for="eventtype">Event Type : </label>
				  </div>
				  <div class="col2">
					<input type="text" name="eventType" placeholder="Type of Event.." value="<?php echo $eventType; ?>" />
				  </div>
				</div>
				
				<div class="row">
				  <div class="col1">
					<label for="eventdescription">Event Description : </label>
				  </div>
				  <div class="col2">
					<textarea name="eventDescription" placeholder="Describe the event.." style="height:200px" value="<?php echo $eventDescription; ?>"></textarea>
				  </div>
				</div>
			
				<div class="row">
					<input type="button" class="button button1" value="Cancel" onclick="window.location = 'homePage.html';">
					<input type="submit" name="submit" value="Submit">
				</div>
			
			</form>
		</div>
	
	
	
	</body>

</html>