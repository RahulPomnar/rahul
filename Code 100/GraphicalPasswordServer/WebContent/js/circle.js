
		var canvas = document.getElementById('myCanvas');
		var context = canvas.getContext('2d');

		// centre or center for US :) the drawing
		var x = canvas.width -300;
		var y = canvas.height -300;

		// number of days
		var days = 1;

		// number of hours
		var hours = 8;

		// one segment represents an hour so divide degrees by hours
		var segmentWidth = 360 / hours;

		// size of a pie : it is an angle in radians
		var pieAngle = 2 * Math.PI / hours;

		// how thick you want a segment
		var segmentDepth = 150;
		var countButton = 0;
		var str=null;
		var pwd="";
		/*var selectedColor=document.getElementById("pwdcolor").value;	
		console.log("selected password color:" + selectedColor);
		*/
		
		var color = [
				[ "#ff0000", "#ffff00", "#00ff00", "#0000ff", "#bf00ff",
						"#ff00bf", "#8c7373", "#000000" ],
				[ "#000000", "#ff0000", "#ffff00", "#00ff00", "#0000ff",
						"#bf00ff", "#ff00bf", "#8c7373" ],
				[ "#8c7373", "#000000", "#ff0000", "#ffff00", "#00ff00",
						"#0000ff", "#bf00ff", "#ff00bf" ],
				[ "#ff00bf", "#8c7373", "#000000", "#ff0000", "#ffff00",
						"#00ff00", "#0000ff", "#bf00ff" ],
				[ "#bf00ff", "#ff00bf", "#8c7373", "#000000", "#ff0000",
						"#ffff00", "#00ff00", "#0000ff" ],
				[ "#0000ff", "#bf00ff", "#ff00bf", "#8c7373", "#000000",
						"#ff0000", "#ffff00", "#00ff00" ],
				[ "#00ff00", "#0000ff", "#bf00ff", "#ff00bf", "#8c7373",
						"#000000", "#ff0000", "#ffff00" ],
				[ "#ffff00", "#00ff00", "#0000ff", "#bf00ff", "#ff00bf",
						"#8c7373", "#000000", "#ff0000" ], ];

		function init() {
			for (var i = 1; i <= days; i++) {
				drawSegments(i * segmentDepth, countButton);
			}
		}

		function drawSegments(radius, countButton) {
			for (var i = 0; i < hours; i++) {
				console.log("in function countButton:" + countButton);
				context.arc(x,y, radius, 0, 0, false);
				context.beginPath();
				context.moveTo(x, y);
				context.arc(x, y, radius, i * pieAngle, (i + 1) * pieAngle,
						false);
				context.lineWidth = segmentDepth;
				context.fillStyle = '#ffffff';
				context.fill();
				context.lineWidth = 8;
				context.strokeStyle = color[countButton][i];
				context.stroke();

				//below half circle
				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('c', x + 65, y + 30); //inner circle
				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('e', x + 105, y + 50); //outer circle

				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('a', x + 25, y + 70);
				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('b', x + 40, y + 120);

				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('@', x - 25, y + 70);
				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('#', x - 40, y + 120);

				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('1', x - 65, y + 30); //inner circle
				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('3', x - 105, y + 50);

				//above half circle
				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('2', x - 65, y - 20);
				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('4', x - 105, y - 40);

				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('5', x - 25, y - 60);
				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('7', x - 40, y - 100);

				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('6', x + 25, y - 60);
				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('8', x + 40, y - 100);

				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('f', x + 65, y - 20);
				context.font = '20pt Calibri';
				context.fillStyle = 'black';
				context.textAlign = 'center';
				context.fillText('d', x + 105, y - 40);
			}
		}

		document.getElementById("clockwise").onclick = rotateClockwise;
		function rotateClockwise() {
			if (countButton != 7 ) {
				countButton++;
			} else {
				countButton=0;
			}
			console.log("clockwise countButton:" + countButton);
			drawSegments(segmentDepth, countButton);
		};

		document.getElementById("anticlockwise").onclick = rotateAntiClockwise;

		function rotateAntiClockwise() {
			if (countButton!=0) {
				countButton--;
			} else {
				countButton = 7;
			}
			console.log("anticlockwise countButton:" + countButton);
			drawSegments(segmentDepth, countButton);
			};
		
			
			//var passwordText=document.getElementById("password");
			document.getElementById("innerButton").onclick = getInnerCharacter;

			function getInnerCharacter() {
				console.log("in inner Button countButton:" + countButton);
				//drawSegments(segmentDepth, countButton);
				str=str+countButton+",i;";
				console.log("String formed:" + str);
				pwd=pwd+"*";
				console.log("pwd:" + pwd);
				document.getElementById("password").value=pwd;
				};
				
			document.getElementById("outerButton").onclick = getOuterCharacter;

			function getOuterCharacter() {
					console.log("in outer Button countButton:" + countButton);
					//drawSegments(segmentDepth, countButton);
				 str=str+countButton+",o;";
					console.log("String formed:" + str);
					pwd=pwd+"*";
					console.log("pwd:" + pwd);
					document.getElementById("password").value=pwd;
			};
			
			document.getElementById("submit").onclick = submit;
			var form=document.getElementById("form");
			function submit() {
					console.log("in submit String formed:" + str);
					document.getElementById("pwdcolor").value=str;
					
			};
			
			
			
			// start drawing our chart
		init();

		
		
