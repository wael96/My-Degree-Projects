
<!DOCTYPE html>
<html>

	<head>
	
		<meta charset = "utf-8">
		<title>The Event Manager</title>
		
		<style>
		
			.hide{
				display:none;
			}

			.show{
				display:block;
			}
		
			.search {
				width: 250px;
				background-color: #e2e4e0;
				color: black;
				padding: 15px 32px;
				text-align: center;
				text-decoration: none;
				font-size: 16px;
				margin:auto;
				display:block;
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
			
			.button2 {
				width: 150px;
                position:relative;
                padding:6px 15px;
                left:-8px;
                border:2px solid #4CAF50;
                background-color:white;
                color:black;
			}
			
			.button2:hover  {
                background-color:#4CAF50;
                color:white;
			}

			
			div {
				
				padding: 5px 50px 5px 50px;
			}
			h1 {
				padding: 5px 50px 20px 50px;
				color: #2f302e;
			    font-family: Arial, Helvetica, sans-serif;
			}
			h3 {
				color: #2f302e;
			    font-family: Arial, Helvetica, sans-serif;
			}


		</style>
		
	</head>
	
	
	
	<body bgcolor="#e4e9db">
	
		
		<h1 align="center">Attendance List</h1>
		
		<h3 align="center">Event ID : 
		
			<?php
				
				$myFilef = "targetID";

				
				
				$linesf = file($myFilef);
				
				
				$tIDf = $linesf[0];


				
				echo $tIDf;


			?>
		</h3>
		
		
		<div>
		<input type="button" class="button button2" value="Back" onclick="window.location = 'viewAttenPage.php';">
		</div>
		
		<div align="center">
		<table id='searchTable' cellpadding='10'>
			  <tr>
				<th>ID</th>
				<th>Name of Participant</th>
				<th>Email of Participant</th>

			  </tr>
		<?php
			
			
			$myFile = "targetID";
			$lines = file($myFile);
			$tID = $lines[0]; 
			
 			$file = fopen($tID+"", "r");
			while (($line = fgetcsv($file)) !== false) {						
				
					echo "<tr>";
					foreach ($line as $cell) {
							echo "<td>" . htmlspecialchars($cell) . "</td>";
					}
					echo "</tr>\n";
			}
			fclose($file); 
			
			file_put_contents("targetID", "");
			 
		?>
		</table>
		</div>
		
			
		
		

	
	</body>

</html>