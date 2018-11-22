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
	
		
		<h1 align="center">List of Available Events</h1>
		
		<h3 align="center">Enter Event Name to Join : </h3>
		
		<div>
			<input type="text" id="searchInput" class="search"  width="40%" title="Enter an Event Name" placeholder="Enter Name of To-Join-Event..." required>
		</div>
		<div>
			<input type="button" id="searchButton" class="button button2" value="Search Event" onclick="searchFunction()">
		</div>
		
		<div>
		<input type="button" class="button button2" style="width:250px" value="Update Attendance" onclick="updateAttendance()">
		</div>
		
		<div>
		<input type="button" class="button button2" value="Back" onclick="window.location = 'searchOrListPage.html';">
		</div>
		
		<div align="center">
		<table id='searchTable' cellpadding='10'>
			  <tr>
				<th>ID</th>
				<th>Name of Organizer</th>
				<th>Event Name</th>
				<th>Date of Event</th>
				<th>Event Venue</th>
				<th>Event Type</th>
				<th>Event Description</th>
				
			  </tr>
		<?php

			$file = fopen("eventData.csv", "r");
			while (($line = fgetcsv($file)) !== false) {						
				
					echo "<tr>";
					foreach ($line as $cell) {
							echo "<td>" . htmlspecialchars($cell) . "</td>";
					}
					echo "</tr>\n";
			}
			fclose($file);
			 
		?>
		</table>
		</div>
		
		
		<script>
		
			var validSearch;
			
				
			function searchFunction() {
				
			  var userInput;
			  var transform;
			  var table;
			  var tr;
			  var td;
			  var i;
			  userInput = document.getElementById("searchInput");
			  transform = userInput.value.toUpperCase();
			  table = document.getElementById("searchTable");
			  tr = table.getElementsByTagName("tr");
			  
				validSearch = 0;
			  
				  for (i = 0; i < tr.length; i++) {
					td = tr[i].getElementsByTagName("td")[2];
					if (td) {
					  if (td.innerHTML.toUpperCase().indexOf(transform) > -1) {
						  validSearch = 1;
						  //alert("validSearch = 1");
						  
						tr[i].style.display = "";
					  } else {
						tr[i].style.display = "none";
					  }
					}      
				  }
				  
				  if(validSearch==0) {
					  alert("Error : Event not found");
					  //validSearch=1;
				  }
				  //validSearch=0;
			  
			  
			}
			
			
			
			function updateAttendance() {
				
				var val1 = document.getElementById("searchInput").value;
				//if(val1=="") {alert("its empty");}
				
				if(val1=="") {
					alert("Please Enter a Valid Event");
				} else {
					
					//var attName = window.prompt("Enter your name", "");
					//var attEmail = window.prompt("Enter your email", "");
					
					//alert("Attendance added! \n\n"+"Name : "+attName+"\nEmail : "+attEmail+"\n\nSee you at the event!");
					
					if(validSearch==1) {
						
						window.location.href = "attendancePage.php";
						
						
					} else {
						alert("Please Enter a Valid Event");
					}
					
				} 
				
			}
			
		</script>
		
		

	
	</body>

</html>