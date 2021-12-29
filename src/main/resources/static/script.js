function footer() 
{
	if (document.documentElement.scrollHeight > document.documentElement.clientHeight) 
	{
		document.getElementById("footer").style.position = "static";
	}
	else 
	{
		document.getElementById("footer").style.position = "fixed";
		document.getElementById("footer").style.bottom = "0";
	}
}


var numOfCards = document.querySelectorAll('[id*="card"]').length;
var nameOfCards = [];
var nameOfCardsAll = [];

function eventNames() 
{
	for(let i = 0; i < numOfCards; i++) 
	{
		nameOfCardsAll.push(document.querySelectorAll('[id*="card"]')[i].querySelector('h1').innerText);
		nameOfCards.push(document.querySelectorAll('[id*="card"]')[i].querySelector('h1').innerText);

		if(nameOfCards[i].length > 15) 
		{
			nameOfCards[i] = nameOfCards[i].slice(0, 15);
			nameOfCards[i] += "...";
		}
		document.querySelectorAll('[id*="card"]')[i].querySelector('h1').innerText = nameOfCards[i];
	}
}


function openCard(elem) 
{
	document.getElementById("divBg").style.display = "block";

	elem.classList.add("open");

	elem.querySelectorAll("div")[1].style.display = "flex";
	elem.querySelector("[id*='close']").style.display = "flex";
	for(let i = 0; i < numOfCards; i++) 
	{
		if (elem.querySelector("h1").innerText == nameOfCards[i]) 
		{
			elem.querySelector("h1").innerText = nameOfCardsAll[i];
		}
	}
}

function closeCard(elem) 
{
	document.getElementById("divBg").style.display = "none";

	elem.parentElement.classList.remove("open");

	elem.parentElement.querySelectorAll("div")[1].style.display = "none";
	elem.parentElement.querySelector("[id*='close']").style.display = "none";
	for(let i = 0; i < numOfCards; i++) 
	{
		if (elem.parentElement.querySelector("h1").innerText == nameOfCardsAll[i]) 
		{
			elem.parentElement.querySelector("h1").innerText = nameOfCards[i];
		}
	}
	event.stopPropagation();
}

function filter(campus) {
	if (campus == "Prishtine") {
		for(let i = 0; i < numOfCards; i++) {
			if (document.querySelectorAll('[id*="card"]')[i].querySelectorAll('p')[3].innerText == "Prishtine") {
				document.querySelectorAll('[id*="card"]')[i].style.display = "flex";
			}
			else {
				document.querySelectorAll('[id*="card"]')[i].style.display = "none";
			}
		}
	}
	if (campus == "Ferizaj") {
		for(let i = 0; i < numOfCards; i++) {
			if (document.querySelectorAll('[id*="card"]')[i].querySelectorAll('p')[3].innerText == "Ferizaj") {
				document.querySelectorAll('[id*="card"]')[i].style.display = "flex";
			}
			else {
				document.querySelectorAll('[id*="card"]')[i].style.display = "none";
			}
		}
	}
	if (campus == "Gjakove") {
		for(let i = 0; i < numOfCards; i++) {
			if (document.querySelectorAll('[id*="card"]')[i].querySelectorAll('p')[3].innerText == "Gjakove") {
				document.querySelectorAll('[id*="card"]')[i].style.display = "flex";
			}
			else {
				document.querySelectorAll('[id*="card"]')[i].style.display = "none";
			}
		}
	}
	if (campus == "All") {
		for(let i = 0; i < numOfCards; i++) {
			document.querySelectorAll('[id*="card"]')[i].style.display = "flex";
		}
	}
}