/**
 * Determine if the given password contains at least 8 characters
 * and at least one uppercase letter and one digit.
 *
 * @param password
 * @returns
 */
export function isStrongPassword(password: string): boolean {
  
  if (password.length < 8){
     return false;
}
   const passUpperCase = /[A-Z]/.test(password);
    const passNumber=/\d/.test(password);
        return passUpperCase && passNumber;
  }


/**
 * Determines the day of the week on the given 0-based number.
 *
 * @param day
 * @returns
 */
export function getDayOfWeek(day: number): string {
  if(day==0){
    return "Sunday";
  } else if(day==1){
    return "Monday";
  } else if(day==2){
    return "Tuesday";
  } else if(day==3){
    return "Wednesday"
  } else if(day==4){
    return "Thursday";
  }else if(day==5){
    return "Friday";
  } else if(day==6){
    return "Saturday";
  }else{
  return "";
}
}

/**
 * Determines the ticket price based on the given age. The price is
 * determined as follows:
 * - Children under 5 years old get in for free.
 * - Children between 5 and 17 years old pay 10 dollars.
 * - Adults between 18 and 59 years old pay 20 dollars.
 * - Seniors 60 years old and older pay 15 dollars.
 *
 * @param age
 * @returns
 */
export function getTicketPrice(age: number): number {
  if(age <= 5){
    return 0;
  }else if(age >= 5 && age <= 17){
    return 10;
  }else if(age >= 18 && age <= 59){
    return 20;
  }else{
  return 15;
  }
}


