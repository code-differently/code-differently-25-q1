function canVote(age:number); boolean{
    if (age >= 18) {
        return true; 
    }
    else {
        return false;
    }
}

console.log(canVote(18));