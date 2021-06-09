////////////////////////////////Compteur repas par jour/////////////////////////////////////

var countPerDay=0;
var isChecked1=0;
var isChecked2=0;
var isChecked3=0;


function Checked1(){
	if (isChecked1==0 ){
		isChecked1=1;
	}
	else if (isChecked1==1){
		isChecked1=0;
	}
	countPerDay=isChecked3+isChecked2+isChecked1;
	document.querySelector("#result").innerHTML=countPerDay+" / 3 ";
}
function Checked2(){
	if (isChecked2==0 ){
		isChecked2=1;
	}
	else if (isChecked2==1){
		isChecked2=0;
	}
	countPerDay=isChecked3+isChecked2+isChecked1;
	document.querySelector("#result").innerHTML=countPerDay+" / 3 ";
}

function Checked3(){
	if (isChecked3==0 ){
		isChecked3=1;
	}
	else if (isChecked3==1){
		isChecked3=0;
	} 
	countPerDay=isChecked3+isChecked2+isChecked1;
	document.querySelector("#result").innerHTML=countPerDay+" / 3 ";	
}

/////////////////////////////////////Compteur jour par semaine/////////////////////////////////////////////////////
var countPerWeek=0;
var isCheckedL=0;
var isCheckedMa=0;
var isCheckedMe=0;
var isCheckedJ=0;
var isCheckedV=0;
var isCheckedS=0;
var isCheckedD=0;

function CheckedL(){
	if (isCheckedL==0 ){
		isCheckedL=1;
	}
	else if (isCheckedL==1){
		isCheckedL=0;
	} 
	countPerWeek=isCheckedL+isCheckedMa+isCheckedMe+isCheckedJ+isCheckedV+isCheckedS+isCheckedD;
	document.querySelector("#result2").innerHTML=countPerWeek+" / 7 ";	
}

function CheckedMa(){
	if (isCheckedMa==0 ){
		isCheckedMa=1;
	}
	else if (isCheckedMa==1){
		isCheckedMa=0;
	} 
	countPerWeek=isCheckedL+isCheckedMa+isCheckedMe+isCheckedJ+isCheckedV+isCheckedS+isCheckedD;
	document.querySelector("#result2").innerHTML=countPerWeek+" / 7 ";	
}

function CheckedMe(){
	if (isCheckedMe==0 ){
		isCheckedMe=1;
	}
	else if (isCheckedMe==1){
		isCheckedMe=0;
	} 
	countPerWeek=isCheckedL+isCheckedMa+isCheckedMe+isCheckedJ+isCheckedV+isCheckedS+isCheckedD;
	document.querySelector("#result2").innerHTML=countPerWeek+" / 7 ";	
}

function CheckedJ(){
	if (isCheckedJ==0 ){
		isCheckedJ=1;
	}
	else if (isCheckedJ==1){
		isCheckedJ=0;
	} 
	countPerWeek=isCheckedL+isCheckedMa+isCheckedMe+isCheckedJ+isCheckedV+isCheckedS+isCheckedD;
	document.querySelector("#result2").innerHTML=countPerWeek+" / 7 ";	
}

function CheckedV(){
	if (isCheckedV==0 ){
		isCheckedV=1;
	}
	else if (isCheckedV==1){
		isCheckedV=0;
	} 
	countPerWeek=isCheckedL+isCheckedMa+isCheckedMe+isCheckedJ+isCheckedV+isCheckedS+isCheckedD;
	document.querySelector("#result2").innerHTML=countPerWeek+" / 7 ";	
}

function CheckedS(){
	if (isCheckedS==0 ){
		isCheckedS=1;
	}
	else if (isCheckedS==1){
		isCheckedS=0;
	} 
	countPerWeek=isCheckedL+isCheckedMa+isCheckedMe+isCheckedJ+isCheckedV+isCheckedS+isCheckedD;
	document.querySelector("#result2").innerHTML=countPerWeek+" / 7 ";	
}

function CheckedD(){
	if (isCheckedD==0 ){
		isCheckedD=1;
	}
	else if (isCheckedD==1){
		isCheckedD=0;
	} 
	countPerWeek=isCheckedL+isCheckedMa+isCheckedMe+isCheckedJ+isCheckedV+isCheckedS+isCheckedD;
	document.querySelector("#result2").innerHTML=countPerWeek+" / 7 ";	
}

