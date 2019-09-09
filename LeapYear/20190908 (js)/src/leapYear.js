function isLeapYear(year){
  const divisibleBy4 = year % 4 === 0;
  const divisibleBy100 = year % 100 === 0;
  const divisibleBy400 = year % 400 === 0;

  return divisibleBy4 && (!divisibleBy100 || (divisibleBy100 && divisibleBy400));
}


export default isLeapYear;
