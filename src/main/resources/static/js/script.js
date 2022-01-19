var counter = 0;
var numOfCards = document.querySelectorAll('[id*="card"]').length;
var nameOfCards = [];
var nameOfCardsAll = [];


function footer()
{
	document.getElementById("footer").style.position = "static";
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

	elem.querySelector("[id*='adminBtn']").style.display = "flex";
	elem.querySelector("[id*='adminBtn']").style.top = "29vw";
	elem.querySelector("[id*='adminBtn']").style.right = "29vw";

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
	elem.querySelector("[id*='adminBtn']").innerHTML = '<button onclick="editEvent(this)"><i class="fas fa-edit"></i> Edit</button><button onclick="deleteEvent(this)"><i class="fas fa-trash-alt"></i> Delete</button>';
}
function closeCard(elem)
{
	document.getElementById("divBg").style.display = "none";

	elem.parentElement.classList.remove("open");

	elem.parentElement.querySelector("[id*='adminBtn']").style.display = "none";
	elem.parentElement.querySelector("[id*='adminBtn']").style.top = "0.5vw";
	elem.parentElement.querySelector("[id*='adminBtn']").style.right = "0.5vw";

	elem.parentElement.querySelectorAll("div")[1].style.display = "none";
	elem.parentElement.querySelector("[id*='close']").style.display = "none";
	for(let i = 0; i < numOfCards; i++)
	{
		if (elem.parentElement.querySelector("h1").innerText == nameOfCardsAll[i])
		{
			elem.parentElement.querySelector("h1").innerText = nameOfCards[i];
		}
	}
	elem.parentElement.querySelector("[id*='adminBtn']").innerHTML = '<button onclick="editEvent(this)"><i class="fas fa-edit"></i></button><button onclick="deleteEvent(this)"><i class="fas fa-trash-alt"></i></button>';

	event.stopPropagation();
}


function addEvent(elem)
{
	document.querySelector('#addEvent').style.display = 'flex';
	document.getElementById("divBg").style.display = "block";
}
function exitAdd(elem)
{
	elem.parentElement.style.display = 'none';
	document.getElementById("divBg").style.display = "none";
}


function editEvent(elem)
{
	document.querySelector('#editEvent').style.display = 'flex';
	document.getElementById("divBg").style.display = "block";

	elem.parentElement.parentElement.classList.remove("open");

	elem.parentElement.style.display = "none";
	elem.parentElement.style.top = "0.5vw";
	elem.parentElement.style.right = "0.5vw";

	elem.parentElement.parentElement.querySelectorAll("div")[1].style.display = "none";
	elem.parentElement.parentElement.querySelector("[id*='close']").style.display = "none";
	for(let i = 0; i < numOfCards; i++)
	{
		if (elem.parentElement.parentElement.querySelector("h1").innerText == nameOfCardsAll[i])
		{
			elem.parentElement.parentElement.querySelector("h1").innerText = nameOfCards[i];
		}
	}

	elem.parentElement.innerHTML = '<button onclick="editEvent(this)"><i class="fas fa-edit"></i></button><button onclick="deleteEvent(this)"><i class="fas fa-trash-alt"></i></button>';

	event.stopPropagation();
}
function exitEdit(elem)
{
	elem.parentElement.style.display = 'none';
	document.getElementById("divBg").style.display = "none";
}


function deleteEvent(elem)
{
	document.querySelector('#deleteEvent').style.display = 'flex';
	document.getElementById("divBg").style.display = "block";

	elem.parentElement.parentElement.classList.remove("open");

	elem.parentElement.style.display = "none";
	elem.parentElement.style.top = "0.5vw";
	elem.parentElement.style.right = "0.5vw";

	elem.parentElement.parentElement.querySelectorAll("div")[1].style.display = "none";
	elem.parentElement.parentElement.querySelector("[id*='close']").style.display = "none";
	for(let i = 0; i < numOfCards; i++)
	{
		if (elem.parentElement.parentElement.querySelector("h1").innerText == nameOfCardsAll[i])
		{
			elem.parentElement.parentElement.querySelector("h1").innerText = nameOfCards[i];
		}
	}
	elem.parentElement.innerHTML = '<button onclick="editEvent(this)"><i class="fas fa-edit"></i></button><button onclick="deleteEvent(this)"><i class="fas fa-trash-alt"></i></button>';

	event.stopPropagation();
}
function exitDelete(elem)
{
	elem.parentElement.style.display = 'none';
	document.getElementById("divBg").style.display = "none";
}


function actionsLecturer(action)
{
	document.querySelector('#'+ action +'Lecturer').style.display = 'flex';
	document.getElementById("divBg2").style.display = "block";
}
function exitActions(action)
{
	document.querySelector('#'+ action +'Lecturer').style.display = 'none';
	document.getElementById("divBg2").style.display = "none";
}


function actionsUser(action)
{
	document.querySelector('#'+ action +'User').style.display = 'flex';
	document.getElementById("divBg3").style.display = "block";
}
function exitActions2(action)
{
	document.querySelector('#'+ action +'User').style.display = 'none';
	document.getElementById("divBg3").style.display = "none";
}


function changePass()
{
	document.querySelector('#changePass').style.display = 'flex';
	document.getElementById("divBg4").style.display = "block";
}
function exitPass()
{
	document.querySelector('#changePass').style.display = 'none';
	document.getElementById("divBg4").style.display = "none";
}


function toggle()
{
	counter++;
	if(counter%2 == 1)
	{
		document.querySelector('#events').style.backgroundColor = "#333333";
		document.querySelector('#subtitle').style.color = "#ffffff";
		document.querySelector('#subtitle2').style.color = "#ffffff";
		document.querySelector('#filter').querySelector('button').style.boxShadow = "0 0 5px #555555";
		document.querySelector('#dropdown2').querySelector('button').style.backgroundColor = "#444444";

		for(let i = 0; i < numOfCards; i++)
		{
			document.querySelectorAll('[id*="card"]')[i].style.backgroundColor = "#444444";
			document.querySelectorAll('[id*="card"]')[i].style.color = "#ffffff";
			document.querySelectorAll('[id*="card"]')[i].style.boxShadow = "0 0 5px #111111";
		}
	}
	else {
		document.querySelector('#events').style.backgroundColor = "#ffffff";
	}
}


function escFunc()
{
	if(event.keyCode == 27)
	{

		document.getElementById("addEvent").style.display = "none";
		document.getElementById("editEvent").style.display = "none";
		document.getElementById("deleteEvent").style.display = "none";
		document.getElementById("divBg").style.display = "none";
		for(let i = 0; i < numOfCards; i++)
		{
			if(document.querySelectorAll('[id*="card"]')[i].getAttribute("class") == "open")
			{
				document.querySelectorAll('[id*="card"]')[i].classList.remove("open");

				document.querySelectorAll('[id*="card"]')[i].querySelector("[id*='adminBtn']").style.display = "none";
				document.querySelectorAll('[id*="card"]')[i].querySelector("[id*='adminBtn']").style.top = "0.5vw";
				document.querySelectorAll('[id*="card"]')[i].querySelector("[id*='adminBtn']").style.right = "0.5vw";

				document.querySelectorAll('[id*="card"]')[i].querySelectorAll("div")[1].style.display = "none";
				document.querySelectorAll('[id*="card"]')[i].querySelector("[id*='close']").style.display = "none";
				if (document.querySelectorAll('[id*="card"]')[i].querySelector("h1").innerText == nameOfCardsAll[i])
				{
					document.querySelectorAll('[id*="card"]')[i].querySelector("h1").innerText = nameOfCards[i];
				}
				document.querySelectorAll('[id*="card"]')[i].querySelector("[id*='adminBtn']").innerHTML = '<button onclick="editEvent(this)"><i class="fas fa-edit"></i></button><button onclick="deleteEvent(this)"><i class="fas fa-trash-alt"></i></button>';
			}
		}
	}
}

function escFunc2()
{
	if(event.keyCode == 27)
	{
		document.getElementById("divBg2").style.display = "none";
		document.getElementById("addLecturer").style.display = "none";
		document.getElementById("editLecturer").style.display = "none";
		document.getElementById("deleteLecturer").style.display = "none";
	}
}
function escFunc3()
{
	if(event.keyCode == 27)
	{
		document.getElementById("divBg3").style.display = "none";
		document.getElementById("addUser").style.display = "none";
		document.getElementById("editUser").style.display = "none";
		document.getElementById("deleteUser").style.display = "none";
	}
}
function escFunc4()
{
	if(event.keyCode == 27)
	{
		document.getElementById("divBg4").style.display = "none";
		document.getElementById("changePass").style.display = "none";
	}
}


function pictures()
{
	for(let i = 0; i < numOfCards; i++)
	{
		if (document.querySelectorAll('[id*="card"]')[i].querySelectorAll('p')[3].innerText == "Prishtine")
		{
			document.querySelectorAll('[id*="card"]')[i].querySelector('img').src = "../images/prishtine.png";
		}
		else if (document.querySelectorAll('[id*="card"]')[i].querySelectorAll('p')[3].innerText == "Ferizaj")
		{
			document.querySelectorAll('[id*="card"]')[i].querySelector('img').src = "../images/ferizaj.png";
		}
		else if (document.querySelectorAll('[id*="card"]')[i].querySelectorAll('p')[3].innerText == "Gjakove")
		{
			document.querySelectorAll('[id*="card"]')[i].querySelector('img').src = "../images/gjakove.png";
		}
		else
		{
			document.querySelectorAll('[id*="card"]')[i].querySelector('img').src = "../images/prishtine.png";
		}
	}
}


function filter(campus)
{
	if (campus == "Prishtine")
	{
		for(let i = 0; i < numOfCards; i++)
		{
			if (document.querySelectorAll('[id*="card"]')[i].querySelectorAll('p')[3].innerText == "Prishtine")
			{
				document.querySelectorAll('[id*="card"]')[i].style.display = "flex";
			}
			else
			{
				document.querySelectorAll('[id*="card"]')[i].style.display = "none";
			}
		}
	}
	if (campus == "Ferizaj")
	{
		for(let i = 0; i < numOfCards; i++)
		{
			if (document.querySelectorAll('[id*="card"]')[i].querySelectorAll('p')[3].innerText == "Ferizaj")
			{
				document.querySelectorAll('[id*="card"]')[i].style.display = "flex";
			}
			else
			{
				document.querySelectorAll('[id*="card"]')[i].style.display = "none";
			}
		}
	}
	if (campus == "Gjakove")
	{
		for(let i = 0; i < numOfCards; i++)
		{
			if (document.querySelectorAll('[id*="card"]')[i].querySelectorAll('p')[3].innerText == "Gjakove")
			{
				document.querySelectorAll('[id*="card"]')[i].style.display = "flex";
			}
			else
			{
				document.querySelectorAll('[id*="card"]')[i].style.display = "none";
			}
		}
	}
	if (campus == "All")
	{
		for(let i = 0; i < numOfCards; i++)
		{
			document.querySelectorAll('[id*="card"]')[i].style.display = "flex";
		}
	}
}









//function disableScrolling(){
//     var x=window.scrollX;
//     var y=window.scrollY;
//     window.onscroll=function(){window.scrollTo(x, y);};
// }

// function enableScrolling(){
//     window.onscroll=function(){};
// }