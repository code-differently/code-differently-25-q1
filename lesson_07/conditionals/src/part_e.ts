/**
 * Write a function that takes a single character as an argument and
 * returns boolean value true if the character is an uppercase letter.
 *
 * @param char
 * @returns
 */

export function isUppercase(char: string): boolean {
  if(['A', 'B', 'C', 'D', 'E', 'F','G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S','T', 'U', 'V', 'W', 'X', 'Y', 'Z'].includes(char)) {
    return true;
  } else {
    return false;
  }
  }


/**
 * Determine if a person is eligible for a driving license (age and test passed).
 *
 * @param age
 * @param passedTest
 * @returns
 */
export function canGetDriverLicense(age: number, passedTest: boolean): boolean {
      if (age >= 18 && passedTest) {
        return true;
      }
      else {
        return false;
      }
}

/**
 * Check if a store is open based on the day and time. The store is open
 * Monday to Saturday from 9 AM to 9 PM.
 *
 * @param day
 * @param hour
 * @returns
 */
export function isStoreOpen(day: string, hour: number): boolean {
  const weekCaseDay = day.toLowerCase(); 


    if(weekCaseDay === 'sunday') {
    return false;
    }
    else if (['monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday'].includes(weekCaseDay) && hour >= 21 || hour < 9)
      return false;
    else {
      return true;
    }
}

