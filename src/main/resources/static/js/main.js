function GerarMatricula(){
	let txt = "EDU"
	let aleatorio = Math.floor(Math.random() * 1500);
	document.getElementById("matricula").value = (txt + aleatorio); 
}